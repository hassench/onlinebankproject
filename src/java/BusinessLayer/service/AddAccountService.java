/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.model.Compte;
import BusinessLayer.model.CompteId;
import BusinessLayer.model.CustomSecurityUser;
import BusinessLayer.model.Transaction;
import BusinessLayer.model.TransactionId;
import BusinessLayer.model.Utilisateur;
import DataBaseAcessLayer.AccountDAO;
import DataBaseAcessLayer.TransactionDAO;
import DataBaseAcessLayer.UserDAO;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;


public class AddAccountService {

    private AccountDAO accountDAO;
    private UserDAO userDAO;
    private TransactionDAO transactionDAO;

    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public TransactionDAO getTransactionDAO() {
        return transactionDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void addAccount(Compte compte, String password) {

        CustomSecurityUser currentUser = (CustomSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser.getId());

        Utilisateur utilisateur = userDAO.getUser(currentUser.getId());

        if (!utilisateur.getEnabled()) {
            throw new DisabledUserProfileException();
        }

        if (!(utilisateur.getPass().equals(password))) {
            throw new WrongPasswordException();
        }
        compte.setUtilisateur(utilisateur);
        List comptes = accountDAO.getAllUserAccounts();

        CompteId compteid = new CompteId(comptes.size() + 1, currentUser.getId());
        compte.setId(compteid);

        accountDAO.addAccount(compte);

        List alltransaction = transactionDAO.getAllUserAccountTransactions();

        TransactionId transactionid = new TransactionId(alltransaction.size() + 1, (int) compte.getId().getIdCompte(), (int) currentUser.getId());

        Transaction transaction = new Transaction(transactionid, compte, new Date(), "+" + compte.getSolde());

        transactionDAO.saveTransaction(transaction);

    }

}
