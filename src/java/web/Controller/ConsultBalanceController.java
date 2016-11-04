/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.model.Compte;
import BusinessLayer.service.ConsultBalanceService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandBalanceCloseac;

public class ConsultBalanceController extends SimpleFormController {

    ConsultBalanceService consultbalanceservice;

    public ConsultBalanceService getConsultbalanceservice() {
        return consultbalanceservice;
    }

    public void setConsultbalanceservice(ConsultBalanceService consultbalanceservice) {
        this.consultbalanceservice = consultbalanceservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        return new CommandBalanceCloseac();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandBalance,
            BindException errors) throws Exception {

        CommandBalanceCloseac command = (CommandBalanceCloseac) commandBalance;

        Compte account;
        try {
            account = consultbalanceservice.getAccount(command.getAccountnumber(), command.getPassword());
            return new ModelAndView("accountcreationsuccess", "compte", account);
        } catch (AccountNONExistantException e) {
            errors.reject("Inexistant ACCOUNT", "This ACCOUNT doesn't exist");
            return showForm(request, response, errors);
        } catch (WrongPasswordException e) {
            errors.reject("Authentification Failure", "Wrong  password");
            return showForm(request, response, errors);
        } catch (DisabledUserProfileException e) {
            errors.reject("Disabled Profile", "Your Profile is Disabled this action is forbidden");
            return showForm(request, response, errors);
        }
    }

}
