/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author CSS
 */
public class Produit {
    private  int idProduit;
    private  String nom;
    private double prix;
    private String stock;
    private Categorie categorie;  
    private String nomImage;
   // private byte[] imageProduit;
     @OneToMany(mappedBy = "produitId")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(mappedBy = "produit")
    private Collection<Ligne_Commande> ligneCommandeCollection;
    @OneToMany(mappedBy = "produitId")
    private Collection<Promotion> promotionCollection;
    
    //ghada
     @JoinColumn(name = "Categorie_id", referencedColumnName = "id_Categorie")
    @ManyToOne
    private Categorie categorieid;
    
        public Produit() {

    
    }


    public Produit(int idProduit, String nom, double prix, String stock, Categorie categorie, String nomImage ) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.nomImage = nomImage;
    
    }
        public Produit(String nom, double prix, String stock, Categorie categorie ) {

        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
    
    
    }

    
        public Produit(String nom, double prix, String stock, Categorie categorie, String nomImage  ) {

        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
         this.nomImage = nomImage;

    }
// siwar 
//    @Override
//    public String toString() {
//        return "Produit{" + "idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + ", categorie=" + categorie + ", image=" + nomImage + '}';
//    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage= nomImage;
    }
    
    //ghada
  public Categorie getCategorieid() {
        return categorieid;
    }

    public void setCategorieid(Categorie categorieid) {
        this.categorieid = categorieid;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    @XmlTransient
    public Collection<Ligne_Commande> getLigneCommandeCollection() {
        return ligneCommandeCollection;
    }

    public void setLigneCommandeCollection(Collection<Ligne_Commande> ligneCommandeCollection) {
        this.ligneCommandeCollection = ligneCommandeCollection;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }  
   
    
    //ghada
 @Override
    public String toString() {
        return nom;
    }

//    public Produit(int idProduit, String nom, double prix, String stock, Categorie categorieid) {
//        this.idProduit = idProduit;
//        this.nom = nom;
//        this.prix = prix;
//        this.stock = stock;
//        this.categorieid = categorieid;
//    }
    public Produit(int idProduit, String nom, double prix, String stock, Categorie categorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
    }
     public Produit(Integer idProduit, String nom, double prix, String stock, String nomImage) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.nomImage = nomImage;
    }
    
    
}