/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;

import BusinessLayer.model.Transaction;
import BusinessLayer.model.TransactionId;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface TransactionDAO {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void addTransaction(Transaction transaction);

    List getAllUserAccountTransactions();

    @SuppressWarnings(value = "unchecked")
    Transaction getTransaction(TransactionId id);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void removeTransaction(Transaction transaction);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void saveTransaction(Transaction transaction);

}
