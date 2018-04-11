/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.ICategorie;
import entities.Categorie;
import entities.Patisserie;
import service.PatisserieService;
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
public class CategorieService implements ICategorie {
  Connection conn;
   PreparedStatement ps;
   Statement stmt;
   
      public CategorieService() {
        conn = DataSource.getInsatance().getConnection(); 
    }
    
  
   @Override
    public void add(Categorie categorie) {
        System.out.print(categorie);
        try {
            String req = "INSERT INTO pibase.categorie (nom,patisserie_id) VALUES (?,?)";
            ps = conn.prepareStatement(req);
            ps.setString(1, categorie.getNom());
            ps.setInt(2, categorie.getPatisserie().getIdPatisserie());
            System.out.print(categorie);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 


      @Override
      public void  remove(int id_Categorie) {
        try {
            String req= "DELETE FROM `categorie` WHERE `categorie`.`id_Categorie` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id_Categorie);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
      
          @Override
  
    public ObservableList<Categorie> DisplayAll() {
        ObservableList<Categorie> listcategories=FXCollections.observableArrayList();
        String req = "SELECT * FROM pibase.categorie";
        
        try {
            PreparedStatement st = conn.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

               Categorie categorie = new Categorie (
                       rs.getInt(2),
               rs.getString(3),new  PatisserieService().findById(rs.getInt(1)));
//               categorie.setId_Categorie(resultSet.getInt("id_Categorie"));
//               categorie.setNom(resultSet.getString("nom"));  
//               categorie.setPatisserie(new PatisserieService().findById(resultSet.getInt("IdPatisserie"))) ; 
               listcategories.add(categorie);
            }
      }catch (SQLException ex){
           Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listcategories;   
    }

               
    
//      @Override
//
//    public List<Categorie> getByPatisserie(int IdUser){
//        
//    List<Categorie> cat = new ArrayList<>();
//        String req = "select  id_Categorie,nom,patisserie from categorie JOIN patisserie WHERE patisserie.user=? ";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connection.prepareStatement(req);
//            preparedStatement.setInt(1,IdUser);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//              Categorie categ = new Categorie (resultSet.getInt("id_Categorie"),resultSet.getString("nom"),
//                       new PatisserieService().findById(resultSet.getInt(1))
//);
//                 // cat.add(categ);
//            }
//        } catch (SQLException ex) {
//        }
//        return cat ;
//    }
          @Override

     public Categorie findByNom(String n) {
            Categorie c = null;
        String req = "select * from categorie where nom =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1,n);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            c = new Categorie(resultSet.getInt("id_Categorie"),resultSet.getString("nom"),
                       new PatisserieService().findById(resultSet.getInt(1)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
           @Override

       public Categorie findById(Integer r) {
            Categorie c = null;
        String req = "select * from categorie where id_Categorie=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            c = new Categorie(resultSet.getInt("id_Categorie"),resultSet.getString("nom"),
                       new PatisserieService().findById(resultSet.getInt(1)));
            }
        } catch (SQLException ex) {
          //  ex.printStackTrace();
        }
        return c;
    }
       
            @Override    
    public List<Categorie> findAll() {
        String req = "SELECT * FROM pibase.categorie";
        List<Categorie> listcateg= new ArrayList<>();
        try {
            ps = conn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Categorie categorie = new Categorie();
                categorie.setPatisserie(new PatisserieService().findById(rs.getInt(1)));
                categorie.setId_Categorie(rs.getInt(2));
               categorie.setNom(rs.getString(3));
                
  
                listcateg.add(categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listcateg;
    }
    
     public ObservableList<Categorie> getByUser(int Iduser ){
        
  ObservableList<Categorie> pr=FXCollections.observableArrayList();
        String req = "SELECT * FROM categorie c JOIN patisserie pa on c.patisserie_id=pa.idPatisserie where pa.user=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,Iduser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              Categorie c = new Categorie(resultSet.getInt("id_Categorie"),  
                        resultSet.getString("nom"), 
                        new PatisserieService().findById(resultSet.getInt(1)));
              pr.add(c);
                 // cat.add(categ);
            }
       }catch (SQLException ex){
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        return pr;
    }
}
        

    
   // getByNom
    

