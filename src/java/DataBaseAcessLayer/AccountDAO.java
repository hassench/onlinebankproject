/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseAcessLayer;

import BusinessLayer.model.Compte;
import BusinessLayer.model.CompteId;
import java.util.List;


public interface AccountDAO {

    Compte getAccount(CompteId id);

    void addAccount(Compte account);

    void removeAccount(Compte account);

    void saveAccount(Compte account);

    List getAllUserAccounts();

    List getUserAccounts(int userid);
    
    Object getUserbyAccount(int accountid);

}
