/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author beryl kristina
 */
public class Ligne_Commande {
    
    private int id;
    private Commandes commande;
    private Produit produit;
     private int quantite;
    private double prixp;
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrixp() {
        return prixp;
    }

    public void setPrixp(double prixp) {
        this.prixp = prixp;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commandes getCommande() {
        return commande;
    }

    public void setCommande(Commandes commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Ligne_Commande{" + "id=" + id + ", prixp=" + prixp + ", quantite=" + quantite + ", commande=" + commande + ", produit=" + produit + '}';
    }

    public Ligne_Commande(int id, double prixp, int quantite, Commandes commande, Produit produit) {
        this.id = id;
        this.prixp = prixp;
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }
    public Ligne_Commande( double prixp, int quantite, Commandes commande, Produit produit) {
        
        this.prixp = prixp;
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }
    
    
}
