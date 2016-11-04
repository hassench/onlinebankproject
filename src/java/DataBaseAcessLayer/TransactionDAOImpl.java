/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;

import BusinessLayer.model.Transaction;
import BusinessLayer.model.TransactionId;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class TransactionDAOImpl implements TransactionDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return hibernateTemplate.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Transaction getTransaction(TransactionId id) {
        Transaction transaction = (Transaction) hibernateTemplate.get(Transaction.class, id);

        return transaction;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addTransaction(Transaction transaction) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(transaction);

        System.out.println(transaction.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeTransaction(Transaction transaction) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.delete(transaction);
        System.out.println(transaction.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTransaction(Transaction transaction) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(transaction);

        System.out.println(transaction.toString());
    }

    @Override
    public List getAllUserAccountTransactions() {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        return session.createQuery("from Transaction").list();
    }

}
