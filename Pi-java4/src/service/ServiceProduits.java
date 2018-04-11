/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.Promotion;
import utils.DataSource;
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

/**
 *
 * @author Ghada
 */
public class ServiceProduits {

    private static ServiceProduits pdtService;

    public static ServiceProduits getInstance() throws SQLException {
        if (pdtService == null) {
            return pdtService = new ServiceProduits();
        }
        return pdtService;
    }
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs ;

    public ServiceProduits() {
        this.cnx = DataSource.getInsatance();
    }
    public Produit get(Produit p )throws SQLException
    {
       
            String query = "Select * from produit where nom='"+p.getNom()+"'" ;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                p.setIdProduit(rs.getInt("idProduit"));
                
                return p;
            }
        
        return null ; 
    }
    

    public ObservableList<Produit> getAll(Categorie categorie){
    ObservableList<Produit> listProduit = FXCollections.observableArrayList();
    
    String query = "SELECT * FROM produit WHERE Categorie_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setInt(1,categorie.getId_Categorie());
            rs = psmt.executeQuery();
            while (rs.next()){
            listProduit.add(new Produit (rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));}
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return listProduit;
    }
    public ObservableList<Promotion> getAll4( Categorie cat) {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM promotion INNER join produit WHERE produit.idProduit = promotion.produit_id and Categorie_id = ?");
            while (rs.next()) {
                ServicePromotion s= new ServicePromotion();
                Produit p=s.getProduitbyId(rs.getInt(2));
                Integer i=rs.getInt(1);
                String imag=rs.getString(8);
                System.out.println(8);
                Double d=p.getPrix();
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(i+" "+k+""+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
//    public ObservableList getAll(Produit p ) {
//        ObservableList listproduits = FXCollections.observableArrayList();
//       
////        ArrayList<Produit> listproduits = new ArrayList<>();
//        try {
//            stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("Select '"+p.getNom()+"' from Produit");
//            while (rs.next()) {
//                p = new Produit(rs.getInt("idProduit"), rs.getString("nom"), 0, null, null);
//                listproduits.add(p);
//
//            }
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceProduits.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listproduits;
//    }
}
