/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.model.Compte;
import BusinessLayer.service.AddAccountService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandAddAccount;

public class AddAccountController extends SimpleFormController {

    AddAccountService addaccountservice;

    public AddAccountService getAddaccountservice() {
        return addaccountservice;
    }

    public void setAddaccountservice(AddAccountService addaccountservice) {
        this.addaccountservice = addaccountservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        return new CommandAddAccount();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandAddAccount,
            BindException errors) throws Exception {
        CommandAddAccount command = (CommandAddAccount) commandAddAccount;

        Compte compte = new Compte();
        compte.setDateOuverture(new Date());
        try {
            compte.setSolde(Double.parseDouble(command.getSolde()));
            addaccountservice.addAccount(compte, command.getPass());
            return new ModelAndView("accountcreationsuccess", "compte", compte);
        } catch (DisabledUserProfileException e) {
            errors.reject("Disabled Profile", "Your Profile is Disabled this action is forbidden");
            return showForm(request, response, errors);
        } catch (WrongPasswordException e) {
            errors.reject("Wrong Password", "Your Password is Wrong");
            return showForm(request, response, errors);
        } catch (java.lang.NumberFormatException e) {
            errors.reject("NumberFormatException", "amount is invalid");
            return showForm(request, response, errors);
        }

    }

}
