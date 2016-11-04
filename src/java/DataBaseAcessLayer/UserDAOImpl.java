/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;

import BusinessLayer.model.Compte;
import BusinessLayer.model.Utilisateur;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.Command.CommandSearch;


public class UserDAOImpl implements UserDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return hibernateTemplate.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Utilisateur getUser(int id) {
        Utilisateur utilisateur = (Utilisateur) hibernateTemplate.get(Utilisateur.class, id);
        return utilisateur;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addUser(Utilisateur utilisateur) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(utilisateur);

        System.out.println(utilisateur.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeUser(Utilisateur utilisateur) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.delete(utilisateur);
        System.out.println(utilisateur.toString());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveUser(Utilisateur utilisateur) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        session.saveOrUpdate(utilisateur);

        System.out.println(utilisateur.toString());
    }
    
    

    @Override
    public Utilisateur findUserByName(String username) {
        org.hibernate.classic.Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("login", username));
        return (Utilisateur) criteria.uniqueResult();
    }

    @Override
    public List<Utilisateur> getUserByCriterias(CommandSearch comm) {
        String nom = comm.getNom();
        String pernom = comm.getPernom();
        String dateNaissance = comm.getDateNaissance();
        String cin = comm.getCin();
        String adresse = comm.getAdresse();
        String tel = comm.getTelephone();
        String[] paramNames = new String[]{"Nom", "Pernom", "DateNaissance", "CIN", "Adresse", "Telephone"};
        String[] values = new String[]{nom, pernom, dateNaissance, cin, adresse, tel};
        // hibernateTemplate.findByNamedParam(cin, paramNames, values);
        //hibernateTemplate.find();
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String query = ""
                + "from Utilisateur u where "
                + "u.nom like '%" + nom + "%' ";
        if (!"".equals(pernom)) {
            query += "and u.pernom like '%" + pernom + "%' ";
        }
        if (!"".equals(dateNaissance)) {
            query += "and u.dateNaissance like '%" + dateNaissance + "%'";
        }
        if (!"".equals(cin)) {
            query += "and u.cin like '%" + cin + "%' ";
        }
        if (!"".equals(adresse)) {
            query += "and u.adresse like '%" + adresse + "%' ";
        }
        if (!"".equals(tel)) {
            query += "and u.telephone like '%" + tel + "%'";
        }
        List<Utilisateur> resultList = null;
        resultList = hibernateTemplate.find(query);
//resultList = query.list();
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i).getNom());
        }
        System.out.println(resultList.size() + "*******************************");
        return resultList;
    }
    
}
