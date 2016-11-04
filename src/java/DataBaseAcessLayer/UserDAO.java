/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;

import BusinessLayer.model.Utilisateur;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.Command.CommandSearch;


public interface UserDAO {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void addUser(Utilisateur utilisateur);

    @SuppressWarnings(value = "unchecked")
    Utilisateur getUser(int id);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void removeUser(Utilisateur utilisateur);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void saveUser(Utilisateur utilisateur);

    Utilisateur findUserByName(String username);

    List<Utilisateur> getUserByCriterias(CommandSearch comm);

}
