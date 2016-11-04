/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.exception.AccountNONExistantException;
import BusinessLayer.exception.DisabledUserProfileException;
import BusinessLayer.exception.WrongPasswordException;
import BusinessLayer.exception.InsufficientBalanceException;
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


public class WithdrawService {

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

    public Compte depositinAccount(String accountnumber, String password, String amount) {
        CustomSecurityUser currentUser = (CustomSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser.getId());

        Utilisateur utilisateur = userDAO.getUser(currentUser.getId());

        if (!utilisateur.getEnabled()) {
            throw new DisabledUserProfileException();
        }

        if (!(utilisateur.getPass().equals(password))) {
            throw new WrongPasswordException();
        }

        Compte account = accountDAO.getAccount(new CompteId((int) Integer.parseInt(accountnumber), (int) currentUser.getId()));

        if (account == null) {
            throw new AccountNONExistantException();
        }

        if (account.getSolde() - Double.parseDouble(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        account.setSolde(account.getSolde() - Double.parseDouble(amount));

        accountDAO.saveAccount(account);

        List alltransaction = transactionDAO.getAllUserAccountTransactions();

        TransactionId transactionid = new TransactionId(alltransaction.size() + 1, (int) Integer.parseInt(accountnumber), (int) currentUser.getId());

        Transaction transaction = new Transaction(transactionid, account, new Date(), "-" + amount);

        transactionDAO.saveTransaction(transaction);

        return account;

    }

}
