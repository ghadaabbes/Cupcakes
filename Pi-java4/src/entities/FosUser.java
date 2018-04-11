/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Siala
 */

@Entity
@Table(name = "fos_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FosUser.findAll", query = "SELECT f FROM FosUser f")
    , @NamedQuery(name = "FosUser.findById", query = "SELECT f FROM FosUser f WHERE f.id = :id")
    , @NamedQuery(name = "FosUser.findByUsername", query = "SELECT f FROM FosUser f WHERE f.username = :username")
    , @NamedQuery(name = "FosUser.findByUsernameCanonical", query = "SELECT f FROM FosUser f WHERE f.usernameCanonical = :usernameCanonical")
    , @NamedQuery(name = "FosUser.findByEmail", query = "SELECT f FROM FosUser f WHERE f.email = :email")
    , @NamedQuery(name = "FosUser.findByEmailCanonical", query = "SELECT f FROM FosUser f WHERE f.emailCanonical = :emailCanonical")
    , @NamedQuery(name = "FosUser.findByEnabled", query = "SELECT f FROM FosUser f WHERE f.enabled = :enabled")
    , @NamedQuery(name = "FosUser.findBySalt", query = "SELECT f FROM FosUser f WHERE f.salt = :salt")
    , @NamedQuery(name = "FosUser.findByPassword", query = "SELECT f FROM FosUser f WHERE f.password = :password")
    , @NamedQuery(name = "FosUser.findByLastLogin", query = "SELECT f FROM FosUser f WHERE f.lastLogin = :lastLogin")
    , @NamedQuery(name = "FosUser.findByConfirmationToken", query = "SELECT f FROM FosUser f WHERE f.confirmationToken = :confirmationToken")
    , @NamedQuery(name = "FosUser.findByPasswordRequestedAt", query = "SELECT f FROM FosUser f WHERE f.passwordRequestedAt = :passwordRequestedAt")
    , @NamedQuery(name = "FosUser.findByFirstname", query = "SELECT f FROM FosUser f WHERE f.firstname = :firstname")
    , @NamedQuery(name = "FosUser.findByLastname", query = "SELECT f FROM FosUser f WHERE f.lastname = :lastname")})
public class FosUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "username_canonical")
    private String usernameCanonical;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "email_canonical")
    private String emailCanonical;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "password_requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordRequestedAt;
    @Basic(optional = false)
    @Lob
    @Column(name = "roles")
    private String roles;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @OneToMany(mappedBy = "user")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(mappedBy = "user")
    private Collection<Patisserie> patisserieCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Commandes> commandesCollection;
    @OneToMany(mappedBy = "iduser")
    private Collection<Recette> recetteCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Utilisateurs_Adresses> utilisateursAdressesCollection;
    @OneToMany(mappedBy = "iduser")
    private Collection<Commentaire> commentaireCollection;

    public FosUser() {
    }

    public FosUser(Integer id) {
        this.id = id;
    }
//(prenomuserr, nameuser, emailuser, emailuser, false, mdp2user, roleuser)
    public FosUser(String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String password, String roles) {
        
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    @XmlTransient
    public Collection<Patisserie> getPatisserieCollection() {
        return patisserieCollection;
    }

    public void setPatisserieCollection(Collection<Patisserie> patisserieCollection) {
        this.patisserieCollection = patisserieCollection;
    }

    @XmlTransient
    public Collection<Commandes> getCommandesCollection() {
        return commandesCollection;
    }

    public void setCommandesCollection(Collection<Commandes> commandesCollection) {
        this.commandesCollection = commandesCollection;
    }

    @XmlTransient
    public Collection<Recette> getRecetteCollection() {
        return recetteCollection;
    }

    public void setRecetteCollection(Collection<Recette> recetteCollection) {
        this.recetteCollection = recetteCollection;
    }

    @XmlTransient
    public Collection<Utilisateurs_Adresses> getUtilisateursAdressesCollection() {
        return utilisateursAdressesCollection;
    }

    public void setUtilisateursAdressesCollection(Collection<Utilisateurs_Adresses> utilisateursAdressesCollection) {
        this.utilisateursAdressesCollection = utilisateursAdressesCollection;
    }

    @XmlTransient
    public Collection<Commentaire> getCommentaireCollection() {
        return commentaireCollection;
    }

    public void setCommentaireCollection(Collection<Commentaire> commentaireCollection) {
        this.commentaireCollection = commentaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FosUser)) {
            return false;
        }
        FosUser other = (FosUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.FosUser[ id=" + id + " ]";
    }
    
}
