/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;

import java.io.Serializable;


public class CommandAddAccount implements Serializable {

    String pass;
    String solde;

    public String getPass() {
        return pass;
    }

    public void setPass(String Pass) {
        this.pass = Pass;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getSolde() {
        return solde;
    }

    public CommandAddAccount() {
        //this.solde = "how much money..";
    }

}
