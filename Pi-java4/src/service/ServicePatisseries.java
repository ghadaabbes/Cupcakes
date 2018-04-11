/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import gui.AjouterEvaluationController;
import gui.InterfaceFxController;
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
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

/**
 *
 * @author Ghada
 */
public class ServicePatisseries {
    private static ServicePatisseries ptService;

    public static ServicePatisseries getInstance() {
        if (ptService == null) {
            return ptService = new ServicePatisseries();
        }
        return ptService;
    }
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs ;

    public ServicePatisseries() {
        this.cnx = DataSource.getInsatance();
    }
    public Patisserie get(Patisserie p )
    {
       
            String query = "Select * from patisserie where nom='"+p.getNom()+"'" ;
        try {
            stmt = conn.createStatement();
             rs = stmt.executeQuery(query);
            if (rs.next())
            {
                p.setIdPatisserie(rs.getInt("idPatisserie"));
                
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePatisseries.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        return null ; 
    }
    
    public ObservableList <Patisserie> getAll(){
       ObservableList<Patisserie> listPatisserie =  FXCollections.observableArrayList();
        try{
             String query = "Select * from Patisserie";
             
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery(query);
            while (rs.next()) {
//                listPatisserie.add(new Patisserie (rs.getInt(2),rs.getString(3)));
                listPatisserie.add(new Patisserie(rs.getInt(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getBigDecimal(7)));
            }
        }catch (SQLException ex) {
            Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);}
            return listPatisserie;
    
    }
     public List<Patisserie> TriePatisserie() throws SQLException {
         List<Patisserie> ls = new ArrayList();
        
        String sql = "SELECT * FROM patisserie r ORDER BY note desc";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
          Patisserie p = null;
       
        while (rs.next()) {
            p = new Patisserie(rs.getString(3),
                        rs.getBigDecimal(7));
            p.setIdPatisserie(rs.getInt(1));
            ls.add(p);
        }
        return ls;
    }
      public ObservableList <Patisserie> getAlll(){
       ObservableList<Patisserie> listPatisserie =  FXCollections.observableArrayList();
        try{
             String query = "Select * from Patisserie";
             
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listPatisserie.add(new Patisserie (rs.getInt(2),rs.getString(3)));

            }
        }catch (SQLException ex) {
            Logger.getLogger(AjouterEvaluationController.class.getName()).log(Level.SEVERE, null, ex);}
            return listPatisserie;
    
    }
    public ArrayList<Categorie> getData(int idPatisserie){

   ArrayList<Categorie> list = new ArrayList<Categorie>();
  
   try {
   stmt = conn.createStatement();
   rs = stmt.executeQuery("SELECT * FROM `categorie` WHERE `patisserie_id` = "+ idPatisserie);
   
   
   while(rs.next()){
    Categorie p = new Categorie(rs.getInt("id_Categorie"));
   
  
   list.add(p);
   }
   
   } catch (SQLException ex) {
       Logger.getLogger(ServicePatisseries.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   }
    public ObservableList<Categorie> getCategorie(Patisserie p){
        ObservableList<Categorie> listCategorie = FXCollections.observableArrayList();
    try {
         
            String query = "SELECT * FROM categorie WHERE patisserie_id=? ";
            
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setInt(1, p.getIdPatisserie());
            rs = psmt.executeQuery();
            while (rs.next()) {
                listCategorie.add(new Categorie(rs.getInt(2),rs.getString(3)));

            }
        }
        catch (SQLException ex) {
            Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);}
        return listCategorie;
    }
    
    
}
