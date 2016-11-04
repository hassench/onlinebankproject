/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DifferentAccountException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.exception.InsufficientBalanceException;
import BusinessLayer.exception.TargetAccountNONExistantException;
import BusinessLayer.service.TransferService;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import web.Command.CommandTransfer;

public class TransferController extends SimpleFormController {

    TransferService transferservice;

    public void setTransferservice(TransferService transferservice) {
        this.transferservice = transferservice;
    }

    public TransferService getTransferservice() {
        return transferservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        return new CommandTransfer();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandTransfer,
            BindException errors) throws Exception {

        CommandTransfer command = (CommandTransfer) commandTransfer;

        HashMap<String, Object> accounts;
        try {
            accounts = (HashMap<String, Object>) transferservice.transfertoAccount(command.getAccountnumber(), command.getPassword(), command.getTargetaccountnumber(), command.getAmount());
            return new ModelAndView("transferinfo", accounts);
        }catch (DifferentAccountException e) {
            errors.reject("Different ACCOUNT", "This ACCOUNT is not yours!");
            return showForm(request, response, errors);
        } catch (AccountNONExistantException e) {
            errors.reject("Inexistant ACCOUNT", "This ACCOUNT of yours doesn't exist");
            return showForm(request, response, errors);
        } catch (WrongPasswordException e) {
            errors.reject("Authentification Failure", "wrong username or password");
            return showForm(request, response, errors);
        } catch (TargetAccountNONExistantException e) {
            errors.reject("Inexistant Target Account", "Target ACCOUNT doesn't exist");
            return showForm(request, response, errors);
        } catch (InsufficientBalanceException e) {
            errors.reject("Insufficient Balance", "Your Balance is Insufficient");
            return showForm(request, response, errors);
        } catch (DisabledUserProfileException e) {
            errors.reject("Disabled Profile", "Your Profile is Disabled this action is forbidden");
            return showForm(request, response, errors);
        }

    }

}
