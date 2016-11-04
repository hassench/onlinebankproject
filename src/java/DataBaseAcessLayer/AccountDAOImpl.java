/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;


import BusinessLayer.model.Compte;
import BusinessLayer.model.CompteId;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountDAOImpl implements AccountDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return hibernateTemplate.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Compte getAccount(CompteId id) {
        Compte account = (Compte) hibernateTemplate.get(Compte.class, id);

        return account;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addAccount(Compte account) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(account);

        System.out.println(account.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeAccount(Compte account) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.delete(account);
        System.out.println(account.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveAccount(Compte account) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(account);

        System.out.println(account.toString());
    }

    @Override
    public List getAllUserAccounts() {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        return session.createQuery("from Compte").list();
    }

    @Override
    public List getUserAccounts(int userid) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        return session.createQuery("from Compte where Utilisateur_Id=" + userid).list();
    }
    
    @Override
    public Object getUserbyAccount(int accountid) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        return session.createQuery("from Compte where idCompte=" + accountid).uniqueResult();
    }

}
