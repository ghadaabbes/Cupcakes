/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Produit;
import entities.Promotion;
import entities.User;
import entities.Wishlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;
import utils.Session;

/**
 *
 * @author Ghada
 */
public class ServiceWishlist {
    private static ServiceWishlist pwService;

    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs  ; 
    ServicePromotion promo=new ServicePromotion();
public static ServiceWishlist getInstance() throws SQLException {
        if (pwService == null) {
            return pwService = new ServiceWishlist();
        }
        return pwService;
    }
    public ServiceWishlist() {
        this.cnx = DataSource.getInsatance();
    }
    public void ajouterfavoris(Wishlist p) {
        try {
            String request = "INSERT INTO `wishlist`( `produit_id`,`user`)VALUES(?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(request);
          
          
            ps.setInt(1, p.getProduitId().getIdProduit());
            
//            ps.setInt(2, Session.LoggedUser.getId());
ps.setInt(2,1 );
            ps.executeUpdate();
            System.out.println("ajoute");
        } catch (SQLException ex) {
             Logger.getLogger(ServiceWishlist.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public void supprimerWishlist(Wishlist a) {
        
        try {
            String req;
            req = "DELETE  FROM `wishlist` WHERE id=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
              ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("Wishlist supprimée");
        } catch (SQLException ex) {
            
            Logger.getLogger(ServicePromotion.class.getName());
        }}
          public ObservableList<Wishlist> getAll( User user) {
        ObservableList<Wishlist> list =  FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            //Select * from wishlist WHERE  `user` = "+Session.LoggedUser
            ResultSet rs2 = stmt.executeQuery("Select * from wishlist WHERE  `user` = "+Session.LoggedUser);
           
            while (rs2.next()) {
                
                Produit p=promo.getProduitbyId(rs2.getInt(2));
                
               String ch=p.getNom();
               System.out.println(ch);
                list.add(new Wishlist(p)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceWishlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}
   public ObservableList<Wishlist> getAll2( ) {
        ObservableList<Wishlist> list =  FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            //Select * from wishlist WHERE  `user` = "+Session.LoggedUser
            ResultSet rs = stmt.executeQuery("Select * from wishlist  ");
           
            while (rs.next()) {
                Integer i=rs.getInt(1);
                Produit p=promo.getProduitbyId(rs.getInt(2));
                
               String ch=p.getNom();
               System.out.println(ch);
                list.add(new Wishlist(i,p)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceWishlist.class.getName()).log(Level.SEVERE, null, ex);
        }return list;}
}
