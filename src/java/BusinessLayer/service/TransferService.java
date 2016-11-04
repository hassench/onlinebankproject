/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DifferentAccountException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.InsufficientBalanceException;
import BusinessLayer.exception.TargetAccountNONExistantException;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.context.SecurityContextHolder;


public class TransferService {

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

    public Map<String, Object> transfertoAccount(String accountnumber, String password, String targetaccountnumber, String amount) {
        CustomSecurityUser currentUser = (CustomSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser.getId());

        Utilisateur utilisateur = userDAO.getUser(currentUser.getId());

        if (!utilisateur.getEnabled()) {
            throw new DisabledUserProfileException();
        }

        if (!(utilisateur.getPass().equals(password))) {
            throw new WrongPasswordException();
        }

        Map<String, Object> myModel = new HashMap<String, Object>();

        Compte account = accountDAO.getAccount(new CompteId((int) Integer.parseInt(accountnumber), (int) currentUser.getId()));

        if (account == null) {
            throw new AccountNONExistantException();
        }
        if (account.getUtilisateur()!=utilisateur) {
            throw new DifferentAccountException();
        }
        
        if (account.getSolde() < Double.parseDouble(amount)) {
            throw new InsufficientBalanceException();
        }

        Compte targetaccount= (Compte) accountDAO.getUserbyAccount((int) Integer.parseInt(targetaccountnumber));
        
        //Compte targetaccount = accountDAO.getAccount(new CompteId((int) Integer.parseInt(targetaccountnumber), (int) target.getId()));

        if (targetaccount == null) {
            throw new TargetAccountNONExistantException();
        }

        account.setSolde(account.getSolde() - Double.parseDouble(amount));

        targetaccount.setSolde(targetaccount.getSolde() + Double.parseDouble(amount));

        accountDAO.saveAccount(account);
        accountDAO.saveAccount(targetaccount);

        List alltransaction = transactionDAO.getAllUserAccountTransactions();

        TransactionId transactioniddeduction = new TransactionId(alltransaction.size() + 1, (int) Integer.parseInt(accountnumber), (int) currentUser.getId());

        Transaction transactiondeduction = new Transaction(transactioniddeduction, account, new Date(), "-" + amount);

        transactionDAO.saveTransaction(transactiondeduction);

        TransactionId transactioniddeposit = new TransactionId(alltransaction.size() + 2, (int) targetaccount.getId().getIdCompte(), (int) targetaccount.getUtilisateur().getId());

        Transaction transactiondeposit = new Transaction(transactioniddeposit, account, new Date(), "+" + amount);

        transactionDAO.saveTransaction(transactiondeposit);

        myModel.put("account", account);
        myModel.put("targetaccount", targetaccount);

        return myModel;

    }

}
