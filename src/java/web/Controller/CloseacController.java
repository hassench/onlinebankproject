/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;

import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.service.CloseacService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandBalanceCloseac;


public class CloseacController extends SimpleFormController {

    CloseacService closeacservice;

    public CloseacService getCloseacservice() {
        return closeacservice;
    }

    public void setCloseacservice(CloseacService closeacservice) {
        this.closeacservice = closeacservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        return new CommandBalanceCloseac();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandCloseac,
            BindException errors) throws Exception {

        CommandBalanceCloseac command = (CommandBalanceCloseac) commandCloseac;

        Double somme;
        try {
            somme = closeacservice.closeAccount(command.getPassword());
            return new ModelAndView("closeacsuccess", "somme", somme);
        } catch (AccountNONExistantException e) {
            errors.reject("Inexistant ACCOUNT", "This ACCOUNT doesn't exist");
            return showForm(request, response, errors);
        } catch (WrongPasswordException e) {
            errors.reject("Authentification Failure", "wrong username or password");
            return showForm(request, response, errors);
        } catch (DisabledUserProfileException e) {
            errors.reject("Disabled Profile", "Your Profile is Disabled this action is forbidden");
            return showForm(request, response, errors);
        }

    }

}
