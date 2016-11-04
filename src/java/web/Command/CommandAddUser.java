/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;


import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class CommandAddUser implements Serializable {

    private String nom;
    private String pernom;
    private String cin;
    private String dateNaissance;
    private String adresse;
    private String profession;
    private String telephone;
    @NotNull
    private String login;
    @NotNull
    private String pass;
    @NotNull
    private String role;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPernom(String pernom) {
        this.pernom = pernom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getPernom() {
        return pernom;
    }

    public String getCin() {
        return cin;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getProfession() {
        return profession;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public CommandAddUser() {
//      //  this.setNom("your FIRST name is..");
//        this.setPernom("your LAST NAME is");
//        this.setDateNaissance("15/10/2014");
//        this.setRole("ADMIN/USER");
    }

}
