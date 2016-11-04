/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TransactionId generated by hbm2java
 */
@Embeddable
public class TransactionId implements java.io.Serializable {

    private int idTransaction;
    private int compteIdCompte;
    private int compteUtilisateurId;

    public TransactionId() {
    }

    public TransactionId(int idTransaction, int compteIdCompte, int compteUtilisateurId) {
        this.idTransaction = idTransaction;
        this.compteIdCompte = compteIdCompte;
        this.compteUtilisateurId = compteUtilisateurId;
    }

    @Column(name = "idTransaction", nullable = false)
    public int getIdTransaction() {
        return this.idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Column(name = "Compte_idCompte", nullable = false)
    public int getCompteIdCompte() {
        return this.compteIdCompte;
    }

    public void setCompteIdCompte(int compteIdCompte) {
        this.compteIdCompte = compteIdCompte;
    }

    @Column(name = "Compte_Utilisateur_id", nullable = false)
    public int getCompteUtilisateurId() {
        return this.compteUtilisateurId;
    }

    public void setCompteUtilisateurId(int compteUtilisateurId) {
        this.compteUtilisateurId = compteUtilisateurId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof TransactionId)) {
            return false;
        }
        TransactionId castOther = (TransactionId) other;

        return (this.getIdTransaction() == castOther.getIdTransaction())
                && (this.getCompteIdCompte() == castOther.getCompteIdCompte())
                && (this.getCompteUtilisateurId() == castOther.getCompteUtilisateurId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getIdTransaction();
        result = 37 * result + this.getCompteIdCompte();
        result = 37 * result + this.getCompteUtilisateurId();
        return result;
    }

}