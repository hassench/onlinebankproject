/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;


import BusinessLayer.model.Utilisateur;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class CommandModification implements Serializable {

    String id;
    String nom;
    String pernom;
    String cin;
    String dateNaissance;
    String adresse;
    String profession;
    String telephone;
    String login;
    String pass;
    String role;
    String enabled;

    public CommandModification(String id, String nom, String pernom, String cin, String dateNaissance, String adresse, String profession, String telephone, String login, String pass, String role, String enabled) {
        this.id = id;
        this.nom = nom;
        this.pernom = pernom;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.profession = profession;
        this.telephone = telephone;
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.enabled = enabled;
    }

    public CommandModification(Utilisateur u) {
        this.id = u.getId().toString();
        this.nom = u.getNom() == null ? null : u.getNom();
        this.pernom = u.getPernom() == null ? null : u.getPernom();
        this.cin = u.getCin() == null ? null : u.getCin();
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dateNaissance = u.getDateNaissance() == null ? null : myFormatter.format(u.getDateNaissance());
        this.adresse = u.getAdresse() == null ? null : u.getAdresse();
        this.profession = u.getProfession() == null ? null : u.getProfession();
        this.telephone = u.getTelephone() == null ? null : Integer.toString(u.getTelephone().intValue());
        this.login = u.getLogin() == null ? null : u.getLogin();
        this.pass = u.getPass() == null ? null : u.getPass();
        this.role = u.getRole() == null ? null : u.getRole();
        this.enabled = u.getEnabled() == null ? null : u.getEnabled().toString();
    }

    public CommandModification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPernom() {
        return pernom;
    }

    public void setPernom(String pernom) {
        this.pernom = pernom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
