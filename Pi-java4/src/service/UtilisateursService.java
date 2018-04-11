/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.IUtilisateursAdresses;
import entities.Commandes;
import entities.Produit;
import entities.User;
import entities.Utilisateurs_Adresses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.DataSource;

/**
 *
 * @author beryl kristina
 */
public class UtilisateursService implements IUtilisateursAdresses {
    
   Connection connection;
    
    public UtilisateursService(){
    
    connection = DataSource.getInsatance().getConnection();
    }
    
    @Override
    public List<Utilisateurs_Adresses> getAll() {
          List<Utilisateurs_Adresses> ua = new ArrayList<>();
        String req = "select * from utilisateurs_adresses";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Utilisateurs_Adresses uti;
                uti = new Utilisateurs_Adresses(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8) );
                ua.add(uti);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ua;    }
    
   @Override
    public Utilisateurs_Adresses findById(Integer id) {
       Utilisateurs_Adresses  uti = null;
        String req = "select * from Utilisateurs_Adresses  where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                uti = new Utilisateurs_Adresses(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8) );}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return uti;
     
    }
    
    @Override
    public void remove(Integer id) {
        String req = "delete from utilisateurs_adresses where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       @Override
        public void add(Utilisateurs_Adresses t) {
       
        try {
            String requete = "INSERT INTO utilisateurs_adresses(user_id,telephone,adresse,cp,pays,ville,complement) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            
            pst.setInt(1, t.getUser_id().getId());
            pst.setInt(2, t.getTelephone());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getCp());
            pst.setString(5, t.getPays());
            pst.setString(6, t.getVille());
            pst.setString(7, t.getComplement());
            
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
        
   @Override
         public Utilisateurs_Adresses findByAdresse(String adresse) {
       Utilisateurs_Adresses  uti = null;
        String req = "select * from utilisateurs_adresses where adresse =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, adresse);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
               uti = new Utilisateurs_Adresses(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8) );}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return uti;
     
    }
   @Override
        public List<Utilisateurs_Adresses> GetByUsersId(User u1) {
        List<Utilisateurs_Adresses> ua = new ArrayList<>();
        String req = "select * from utilisateurs_adresses where user_id = ?  ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, u1.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Utilisateurs_Adresses uti;
                uti = new Utilisateurs_Adresses(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8) );
                ua.add(uti);
                
               
            }
            System.out.println("utilisa teurs");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ua;
    }
        

}
