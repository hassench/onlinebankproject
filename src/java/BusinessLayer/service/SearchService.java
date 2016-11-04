/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.service;

import BusinessLayer.model.Utilisateur;
import DataBaseAcessLayer.UserDAO;
import java.util.List;
import web.Command.CommandSearch;


public class SearchService {

    private UserDAO rechercheDAO;

    public void setRechercheDAO(UserDAO rechercheDAO) {
        this.rechercheDAO = rechercheDAO;
    }

    public UserDAO getRechercheDAO() {
        return rechercheDAO;
    }

    public Utilisateur getUtilisateur(int id) {
        Utilisateur u = rechercheDAO.getUser(id);
        return u;
    }

    public List<Utilisateur> getUtilisateurByCriterias(CommandSearch comm) {
        List<Utilisateur> utilisateurs = rechercheDAO.getUserByCriterias(comm);
        return utilisateurs;
    }

    public void updateUtilisateur(Utilisateur u) {
        rechercheDAO.saveUser(u);
    }

}
