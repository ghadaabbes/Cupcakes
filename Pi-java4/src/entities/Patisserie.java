/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Objects;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 *
 * @author CSS
 */
public class Patisserie {
    private int idPatisserie;
    private String nom;
    private String adresse;
    private String description;
    private User user;
    private String nomImage;
    private BigDecimal note;
    private String altitude;
    private String longitude;
//ghada
        
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private FosUser userr;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Evaluation> evaluationCollection;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Reclamation> reclamationCollection;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Promotion> promotionCollection;
    public Patisserie(String nom, String adresse, String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
    }

    public Patisserie(int idPatisserie, String nom, String adresse, String description, String nomImage, BigDecimal note) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.nomImage = nomImage;
        this.note = note;
    }

    public Patisserie(String nom, String adresse, String description, User user, String nomImage) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.user = user;
        this.nomImage = nomImage;
    }

        public Patisserie(User user,int idPatisserie,String nom, String adresse, String description, String nomImage) {
        this.user = user;
         this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;     
     this.nomImage = nomImage;
    }
        
      public Patisserie(User user,int idPatisserie,String nom, String adresse, String description, String nomImage,BigDecimal note) {
        this.user = user;
         this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;     
     this.nomImage = nomImage;
            this.note = note;
    }
    

    public void setNote(BigDecimal note) {
        this.note = note;
    }
    
        public Patisserie() {

    }

    @Override
    public String toString() {
        return "Patisserie{" + "idPatisserie=" + idPatisserie + ", nom=" + nom + ", adresse=" + adresse + ", description=" + description + ", user=" + user + ", image=" + nomImage + '}';
    }

    public Patisserie(int idPatisserie, String nom, String adresse, String description, User user, String nomImage,BigDecimal note) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.user = user;
        this.nomImage = nomImage;
        this.note = note;
    }

    public Patisserie(String nom, String adresse, String description, User user, String nomImage, String altitude, String longitude) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.user = user;
        this.nomImage = nomImage;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public Patisserie( String nom, String adresse, String description,String nomImage) {
       
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
         this.nomImage = nomImage;
       
    }
        public Patisserie(int idPatisserie, String nom, String adresse, String description,String nomImage) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.user = user;
        this.nomImage = nomImage;

    }
         public Patisserie(String nom, BigDecimal note) {
        this.nom = nom;
        this.note = note;
    }

        public Patisserie(int idPatisserie,String nom, String adresse, String description) {
       this.idPatisserie = idPatisserie;
            this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        

    }

    public Patisserie(int idPatisserie, String nom) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
    }

    public Patisserie(int idPatisserie, String nom, String adresse, String description, BigDecimal note) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.note = note;
    }

    

    

    

    public int getIdPatisserie() {
        return idPatisserie;
    }

    public void setIdPatisserie(int idPatisserie) {
        this.idPatisserie = idPatisserie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String image) {
        this.nomImage = image;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
     
}