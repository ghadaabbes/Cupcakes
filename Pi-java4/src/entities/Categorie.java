/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import java.util.Objects;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author CSS
 */
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Categorie")
    private Integer idCategorie;
    private int id_Categorie;
    private String nom;
    private Patisserie patisserie;
    //ghada
     @JoinColumn(name = "patisserie_id", referencedColumnName = "idPatisserie")
    @ManyToOne
    private Patisserie patisserieId;
    @OneToMany(mappedBy = "categorieid")
    private Collection<Produit> produitCollection;
 
    public Categorie() {

    }

    public Categorie(int id_Categorie, String nom, Patisserie patisserie) {
        this.id_Categorie = id_Categorie;
        this.nom = nom;
        this.patisserie = patisserie;
    }
        public Categorie(String nom, Patisserie patisserie) {

        this.nom = nom;
        this.patisserie = patisserie;
    }

    

//    @Override
//    public String toString() {
//        return "Categorie{" + "id_Categorie=" + id_Categorie + ", nom=" + nom + ", patisserie=" + patisserie + '}';
//    }

    public int getId_Categorie() {
        return id_Categorie;
    }
    //ghada
public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }
    public void setId_Categorie(int id_Categorie) {
        this.id_Categorie = id_Categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Patisserie getPatisserie() {
        return patisserie;
    }

    public void setPatisserie(Patisserie patisserie) {
        this.patisserie = patisserie;
    }

    public Categorie(int id_Categorie, String nom) {
        this.id_Categorie = id_Categorie;
        this.nom = nom;
    }

    public Categorie(Integer idCategorie, String nom) {
        this.idCategorie = idCategorie;
        this.nom = nom;
    }


//ghada
    public Patisserie getPatisserieId() {
        return patisserieId;
    }

    public void setPatisserieId(Patisserie patisserieId) {
        this.patisserieId = patisserieId;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }
      public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }
//ghada
 @Override
    public String toString() {
        return nom;
    }
 
}
