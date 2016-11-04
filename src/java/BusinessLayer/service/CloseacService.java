/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.model.Compte;
import BusinessLayer.model.CustomSecurityUser;
import BusinessLayer.model.Utilisateur;
import DataBaseAcessLayer.AccountDAO;
import DataBaseAcessLayer.UserDAO;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;


public class CloseacService {

    private AccountDAO accountDAO;
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public Double closeAccount(String password) {
        CustomSecurityUser currentUser = (CustomSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser.getId());

        Utilisateur utilisateur = userDAO.getUser(currentUser.getId());

        if (!utilisateur.getEnabled()) {
            throw new DisabledUserProfileException();
        }

        if (!(utilisateur.getPass().equals(password))) {
            throw new WrongPasswordException();
        }

        utilisateur.setEnabled(Boolean.FALSE);

        userDAO.saveUser(utilisateur);

        List useraccounts = accountDAO.getUserAccounts(currentUser.getId());

        Double somme = 0.0;
        for (Object account : useraccounts) {
            somme += ((Compte) account).getSolde();
        }

        return somme;

    }
}
