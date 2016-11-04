/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;

import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.exception.InsufficientBalanceException;
import BusinessLayer.model.Compte;
import BusinessLayer.service.WithdrawService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandDepositWithdraw;


public class WithdrawController extends SimpleFormController {

    WithdrawService withdrawservice;

    public WithdrawService getWithdrawservice() {
        return withdrawservice;
    }

    public void setWithdrawservice(WithdrawService withdrawservice) {
        this.withdrawservice = withdrawservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        return new CommandDepositWithdraw();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandWithdraw,
            BindException errors) throws Exception {

        CommandDepositWithdraw command = (CommandDepositWithdraw) commandWithdraw;

        Compte account;
        try {
            account = withdrawservice.depositinAccount(command.getAccountnumber(), command.getPassword(), command.getAmount());
            return new ModelAndView("accountcreationsuccess", "compte", account);
        } catch (DisabledUserProfileException e) {
            errors.reject("Disabled Profile", "Your Profile is Disabled this action is forbidden");
            return showForm(request, response, errors);
        } catch (AccountNONExistantException e) {
            errors.reject("Inexistant ACCOUNT", "This ACCOUNT doesn't exist");
            return showForm(request, response, errors);
        } catch (WrongPasswordException e) {
            errors.reject("Authentification Failure", "wrong username or password");
            return showForm(request, response, errors);
        } catch (InsufficientBalanceException e) {
            errors.reject("Insufficient Balance", "Your Balance is Insufficient");
            return showForm(request, response, errors);
        }

    }

}
