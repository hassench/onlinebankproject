/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


public class CommandSearch implements Serializable {

    String nom;
    String pernom;
    String cin;
    String dateNaissance;
    Date dateNaissance1;
    String adresse;
    String telephone;
    String profession;

    public String getNom() {
        return nom;
    }

    public Date getDateNaissance1() {
        return dateNaissance1;
    }

    public void setDateNaissance1(Date dateNaissance1) {
        this.dateNaissance1 = dateNaissance1;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public CommandSearch() throws ParseException {

    }

}
