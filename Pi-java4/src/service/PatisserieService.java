/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Interface.IPatisserie;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.User;
import entities.Patisserie;
import entities.Produit;
import entities.Recette;
//import utils.StaticAccount;
import java.sql.Blob;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Session;


/**
 *
 * @author siwar
 */
public class PatisserieService  implements IPatisserie{
 Connection conn;
   PreparedStatement ps;
   Statement stmt;
    public PatisserieService() {
        conn = DataSource.getInsatance().getConnection(); 
    }
    

 
   @Override
       public void add(Patisserie patisserie) {

        try {
         String req = "INSERT INTO pibase.patisserie (nom,adresse,description,user,nomImage,altitude,longitude) VALUES (?,?,?,?,?,?,?)";
         ps = conn.prepareStatement(req);
            
           // ps.setInt(1, patisserie.getIdPatisserie());
            ps.setString(1, patisserie.getNom());
            ps.setString(2, patisserie.getAdresse());
            ps.setString(3,patisserie.getDescription());
            ps.setInt(4, patisserie.getUser().getId());
            ps.setString(5, patisserie.getNomImage());
            ps.setString(6, patisserie.getAltitude());
            ps.setString(7, patisserie.getLongitude());
           // ps.setInt(6,0);
         ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatisserieService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


@Override
    public void update(Patisserie patisserie) {
        System.out.println(patisserie.toString());
       
             PreparedStatement preparedStatement;
        try {
              String req = "UPDATE patisserie SET  nom =?,adresse =?,description =?, nomImage =? WHERE idPatisserie=?";
              preparedStatement = conn.prepareStatement(req);
            System.out.println(patisserie.getIdPatisserie());
//          ps.setInt(1, patisserie.getIdPatisserie());
            ps.setString(1, patisserie.getNom());
            ps.setString(2, patisserie.getAdresse());
            ps.setString(3,patisserie.getDescription());
            ps.setString(4, patisserie.getNomImage());
         //  ps.setFloat(5,patisserie.getNote());
              ps.setInt(5, patisserie.getIdPatisserie());


           preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatisserieService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
     @Override
      public void  remove(int idPatisserie) {
        try {
            String req= "DELETE FROM `patisserie` WHERE `patisserie`.`idPatisserie` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, idPatisserie);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatisserieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


 @Override
    public List<Patisserie> getAll() {
        String req = "SELECT * FROM pibase.patisserie ";
         ArrayList<Patisserie> listpatisseries = new ArrayList<>();
        try {
              PreparedStatement st = conn.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Patisserie patisserie = new Patisserie();
               // patisserie.setIdPatisserie(rs.getInt("idPatisserie"));
                patisserie.setNom(rs.getString("nom"));
                patisserie.setDescription(rs.getString("description"));
                patisserie.setAdresse(rs.getString("adresse"));
             //  patisserie.setUser(new UserService().findById(rs.getInt("id")));

                patisserie.setNomImage(rs.getString("nomImage"));


                listpatisseries.add(patisserie);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(PatisserieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpatisseries;
    }

   public List<Patisserie> findByUser(int user) {
       List<Patisserie> pats=new ArrayList<>();
      // Patisserie p = null;
        String req = "select * from patisserie where user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patisserie p = new Patisserie(
                    new UserService().findById(resultSet.getInt(1)),
                    resultSet.getInt("idPatisserie"),  resultSet.getString("nom"),
                       resultSet.getString("adresse"),
                      resultSet.getString("description"),
                       resultSet.getString("nomImage")
                    );
                pats.add(p);
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pats;
    }

   @Override
    public Patisserie findById(Integer r) {
            Patisserie p = null;
        String req = "select * from patisserie where idPatisserie =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            p = new Patisserie(
                   new UserService().findById(resultSet.getInt(1)),
                    resultSet.getInt("idPatisserie"),resultSet.getString("nom"), 
                    resultSet.getString("adresse"),
                    resultSet.getString("description"),
                    resultSet.getString("nomImage"));
                   // resultSet.getInt(4, user().getId());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
  @Override
   public ObservableList<Patisserie> getByUser(int Iduser ){
            ObservableList<Patisserie> listeMesPatisseries=FXCollections.observableArrayList();
       String req="select idPatisserie, nom,adresse,description,nomImage from patisserie where user=? ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=conn.prepareStatement(req);
           preparedStatement.setInt(1,Iduser);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Patisserie p;
               p = new Patisserie(
                       
                     
                       resultSet.getInt("idPatisserie"),
                       resultSet.getString("nom"),
                       resultSet.getString("adresse"),
                      resultSet.getString("description"),
                       resultSet.getString("nomImage")
                     
                    //   resultSet.getString(6)
                       //   resultSet.getInt(6)
               );
               listeMesPatisseries.add(p);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(PatisserieService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeMesPatisseries;
             
         } 

 
   public Patisserie findByNom(String n) {
            Patisserie c = null;
        String req = "select * from patisserie where nom =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1,n);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            c = new Patisserie(new UserService().findById(resultSet.getInt(1)),
                    resultSet.getInt("idPatisserie"),  resultSet.getString("nom"),
                       resultSet.getString("adresse"),
                      resultSet.getString("description"),
                       resultSet.getString("nomImage"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
   
   
     @Override
  
    public ObservableList<Patisserie> DisplayAll() {
        ObservableList<Patisserie> listpat=FXCollections.observableArrayList();
        String req = "SELECT * FROM pibase.patisserie";
        
        try {
            PreparedStatement st = conn.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

               Patisserie pat = new Patisserie ( 
                         
                       rs.getString("nom"),
                       rs.getString("adresse"),
                      rs.getString("description"),
                       rs.getString("nomImage"));

               listpat.add(pat);
            }
      }catch (SQLException ex){
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listpat;   
    }

  @Override 
   public ObservableList<Patisserie> DisplayByNom(String nom){
        ObservableList<Patisserie> listpat=FXCollections.observableArrayList();
        String req = "SELECT * FROM patisserie where nom=?";
        
        try {
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1,nom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

               Patisserie pat = new Patisserie ( 
                         
                       rs.getString("nom"),
                       rs.getString("adresse"),
                      rs.getString("description"),
                       rs.getString("nomImage"));

               listpat.add(pat);
            }
      }catch (SQLException ex){
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listpat;   
   }
   
     @Override    
    public List<Patisserie> findAll() {
        String req = "SELECT * FROM pibase.patisserie";
        List<Patisserie> listpatisseries = new ArrayList<>();
        try {
            ps = conn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patisserie patisserie = new Patisserie();
                 patisserie.setUser(new UserService().findById(rs.getInt(1)));
                patisserie.setIdPatisserie(rs.getInt("idPatisserie"));
                patisserie.setNom(rs.getString("nom"));
               patisserie.setAdresse(rs.getString("adresse"));
                patisserie.setDescription(rs.getString("description"));
               patisserie.setNomImage(rs.getString("nomImage"));
             patisserie.setNote(rs.getBigDecimal("note"));
               listpatisseries.add(patisserie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listpatisseries;
    }
    
    
}
