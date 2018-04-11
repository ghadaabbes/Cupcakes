/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.IProduit;
import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.User;
import service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author CSS
 */
public class ProduitService implements IProduit {
 Connection conn = DataSource.getInsatance().getConnection(); 
   PreparedStatement ps;
   Statement stmt;


     @Override 
    public void add(Produit produit) {
        String req = "INSERT INTO produit (nom,prix,stock,nomImage,Categorie_id) VALUES (?,?,?,?,?)";
        try {
           ps = conn.prepareStatement(req);
           // ps.setInt(1, produit.getIdProduit());
            ps.setString(1, produit.getNom());
            ps.setDouble(2, produit.getPrix());
            ps.setString(3, produit.getStock());
            ps.setString(4, produit.getNomImage());
            ps.setInt(5, produit.getCategorie().getId_Categorie());


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

     @Override 
    public void update(Produit produit) {

        String req = "UPDATE produit SET nom =?,prix =?,stock =?,categorie=?,nomImage=? WHERE idProduit=?";
        try {
         ps = conn.prepareStatement(req);
            ps.setString(1, produit.getNom());
            ps.setDouble(2, produit.getPrix());
            ps.setString(3, produit.getStock());

            ps.setString(4, produit.getCategorie().getNom());

            ps.setString(5, produit.getNomImage());

            ps.setInt(6, produit.getIdProduit());

            System.out.println(req);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
     @Override    
    public void remove(int idProduit) {
  try {
             String req= "DELETE FROM `produit` WHERE `produit`.`idProduit` = ? ";
             PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, idProduit);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
     @Override    
    public List<Produit> findAll() {
        String req = "SELECT * FROM pibase.produit";
        List<Produit> listproduits = new ArrayList<>();
        try {
            ps = conn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setIdProduit(rs.getInt("idProduit"));
                produit.setNom(rs.getString("nom"));

                produit.setPrix(rs.getFloat("prix"));

                produit.setStock(rs.getString("stock"));
                produit.setNomImage(rs.getString("NomImage"));
               produit.setCategorie(new CategorieService().findById(rs.getInt("Categorie_id")));
            



                listproduits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listproduits;
    }
    
    
    
        
          @Override
  
    public ObservableList<Produit> DisplayAll() {
        ObservableList<Produit> listproduits=FXCollections.observableArrayList();
        String req = "SELECT * FROM produit";
        
        try {
            PreparedStatement st = conn.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

               Produit produit = new Produit (
               rs.getString(2),rs.getInt(3),rs.getString(4),new  CategorieService().findById(rs.getInt(6)));

               listproduits.add(produit);
            }
      }catch (SQLException ex){
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listproduits;   
    }

    
    
  @Override
    public Produit findById(Integer r) {
            Produit p = null;
        String req = "select * from produit where idProduit =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            p = new Produit( resultSet.getString("nom"), resultSet.getDouble("prix"),resultSet.getString("stock"),new CategorieService().findById(resultSet.getInt(6)),resultSet.getString("nomImage"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
      @Override
    public Produit findByNom(String r) {
            Produit p = null;
        String req = "select * from produit where idProduit =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            p = new Produit( resultSet.getString("nom"), resultSet.getDouble("prix"),resultSet.getString("stock"),new CategorieService().findById(resultSet.getInt(6)),resultSet.getString("nomImage"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    @Override  
  public List<Produit> getByUser(int Iduser ){
        
    List<Produit> pr = new ArrayList<>();
        String req = "select * from produit pr join categorie c join patisserie p where p.user=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,Iduser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              Produit prod = new Produit (resultSet.getInt("idProduit"),resultSet.getString("nom"),
                 resultSet.getDouble("prix"),resultSet.getString("stock"),new CategorieService().findByNom(resultSet.getString(2)),resultSet.getString("nomImage"));
                 // cat.add(categ);
            }
        } catch (SQLException ex) {
        }
        return pr;
    }
   
//    @Override
//   public Produit getProduitIdByNom(String nom) {
//        Produit p = new Produit();
//        String requete = "select * from produit where nom=?";
//        try {
//            PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(requete);
//            ps.setString(1, nom);
//            ResultSet resultat = ps.executeQuery();
//
//            while (resultat.next()) {
//                //h.setId_categorie_produit(resultat.getInt(1));
//                //  h.setNom_categorie_produit(resultat.getString(2));
//               p.setIdProduit(resultat.getInt(1));
//               p.setNom(resultat.getString(2));
//               p.setPrix(resultat.getDouble(3));
//               p.setStock(resultat.getString(4));
//               p.setCategorie(new CategorieService().findByNom(resultat.getString("nom")));
//               p.setNomImage(resultat.getString(5));
//            }
//            return p;
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
//            p.setIdProduit(0);
//            return p;
//        }}
//        
  @Override
    public List<Produit> findByCategorie(int id_Categorie) {
        String req = "SELECT * FROM produit WHERE Categorie_id= ?";

        List<Produit> produits = new ArrayList<Produit>();
        try {

          ps = conn.prepareStatement(req);
            ps.setInt(1, id_Categorie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produit produit = new Produit();
                produit.setIdProduit(rs.getInt("idProduit"));
                produit.setNom(rs.getString("nom"));
                produit.setPrix(rs.getDouble("prix"));
                produit.setStock(rs.getString("stock"));
                produit.setCategorie(new CategorieService().findById(rs.getInt("Categorie_id")));
                produit.setNomImage(rs.getString("nomImage"));

              produits.add(produit);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produits;
    }
    
 
    @Override
     public ObservableList<Produit> DisplayByNom(String nom){
        ObservableList<Produit> listprod=FXCollections.observableArrayList();
        String req = "SELECT * FROM produit where nom=?";
        
        try {
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1,nom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

               Produit prod = new Produit ( 
                         
                     rs.getString("nom"),
                       rs.getDouble("prix"),
                       rs.getString("stock"),
                       new CategorieService().findById(rs.getInt(6)),
                       rs.getString("nomImage"));
          

               listprod.add(prod);
            }
      }catch (SQLException ex){
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listprod;   
   }
     
            @Override
    public int NbTotalProduit(){
        int v1=0;
        String req1 = "select count(*) from produit ";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = conn.prepareStatement(req1);
            
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
    
    
    public List<Categorie> findByUser(int id) {
        
            List<Categorie> pats=new ArrayList<>();
      // Patisserie p = null;
        String req = "SELECT * FROM categorie c JOIN patisserie pa on c.patisserie_id=pa.idPatisserie where pa.user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Categorie p = new Categorie(resultSet.getInt("id_Categorie"),  
                        resultSet.getString("nom"), 
                        new PatisserieService().findById(resultSet.getInt(1)));
//                    new UserService().findById(resultSet.getInt(1)),
//                    resultSet.getInt("idPatisserie"),  resultSet.getString("nom"),
//                       resultSet.getString("adresse"),
//                      resultSet.getString("description"),
//                       resultSet.getString("nomImage")
//                    );
                pats.add(p);
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pats;
    }
}
