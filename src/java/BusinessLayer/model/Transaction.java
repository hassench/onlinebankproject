/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer.model;


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name = "transaction", catalog = "banque"
)
public class Transaction implements java.io.Serializable {

    private TransactionId id;
    private Compte compte;
    private Date date;
    private String somme;

    public Transaction() {
    }

    public Transaction(TransactionId id, Compte compte) {
        this.id = id;
        this.compte = compte;
    }

    public Transaction(TransactionId id, Compte compte, Date date, String somme) {
        this.id = id;
        this.compte = compte;
        this.date = date;
        this.somme = somme;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "idTransaction", column = @Column(name = "idTransaction", nullable = false)),
        @AttributeOverride(name = "compteIdCompte", column = @Column(name = "Compte_idCompte", nullable = false)),
        @AttributeOverride(name = "compteUtilisateurId", column = @Column(name = "Compte_Utilisateur_id", nullable = false))})
    public TransactionId getId() {
        return this.id;
    }

    public void setId(TransactionId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Compte_idCompte", referencedColumnName = "idCompte", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "Compte_Utilisateur_id", referencedColumnName = "Utilisateur_id", nullable = false, insertable = false, updatable = false)})
    public Compte getCompte() {
        return this.compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Date", length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "Somme", length = 30)
    public String getSomme() {
        return this.somme;
    }

    public void setSomme(String somme) {
        this.somme = somme;
    }

}
