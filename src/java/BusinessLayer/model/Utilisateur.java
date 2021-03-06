package BusinessLayer.model;
// Generated 21 janv. 2014 17:07:49 by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "banque",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"id", "Login"})
)
public class Utilisateur implements java.io.Serializable {

    private Integer id;
    private String nom;
    private String pernom;
    private String cin;
    private Date dateNaissance;
    private String adresse;
    private String profession;
    private Double telephone;
    private String login;
    private String pass;
    private String role;
    private Boolean enabled;
    private Set comptes = new HashSet(0);

    public Utilisateur() {
    }

    public Utilisateur(String nom, String pernom, String cin, Date dateNaissance, String adresse, String profession, Double telephone, String login, String pass, String role, Boolean enabled, Set comptes) {
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
        this.comptes = comptes;
    }

    public Utilisateur(String nom, String pernom, String cin, Date dateNaissance, String adresse, String profession, Double telephone, String login, String pass, String role, Boolean enabled) {
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

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Nom", length = 45)
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "Pernom", length = 45)
    public String getPernom() {
        return this.pernom;
    }

    public void setPernom(String pernom) {
        this.pernom = pernom;
    }

    @Column(name = "CIN", length = 8)
    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DateNaissance", length = 10)
    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Column(name = "Adresse", length = 45)
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name = "Profession", length = 45)
    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "Telephone", precision = 22, scale = 0)
    public Double getTelephone() {
        return this.telephone;
    }

    public void setTelephone(Double telephone) {
        this.telephone = telephone;
    }

    @Column(name = "Login", length = 45, unique = true, nullable = false)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "Pass", length = 45, nullable = false)
    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Column(name = "Role", length = 45)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "Enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    public Set getComptes() {
        return this.comptes;
    }

    public void setComptes(Set comptes) {
        this.comptes = comptes;
    }

}
