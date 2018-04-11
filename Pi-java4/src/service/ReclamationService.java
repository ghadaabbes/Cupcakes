/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.DataSource;
import entities.Patisserie;
import entities.Reclamation;
import Interface.IReclamationService;
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
 * @author Anouar
 */
public class ReclamationService implements IReclamationService{
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;

    @Override
    public void createReclamation(Reclamation r) {
        try {
            String req = "INSERT INTO reclamation (patisserie_id,mail,description) VALUES (?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            
            st.setString(2, r.getMail());
            st.setString(3, r.getDescription());
            st.setInt(1, r.getPatisserieId().getIdPatisserie());
     
            st.executeUpdate();
            System.out.println("reclamation ajoute");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reclamation> getAll() {
         ObservableList<Reclamation> listReclamation = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from reclamation");
            while (rs.next()) {
                 Patisserie p=getPatisseriebyId(rs.getInt(2));
                listReclamation.add(new Reclamation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getString(4)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReclamation;
    }
public Patisserie getPatisseriebyId(int id){
        Patisserie p=new Patisserie();
        try {
         
                     stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from patisserie WHERE idPatisserie = "+id );
           
                    while (rs.next()) {
                        p=new Patisserie(rs.getInt(2), rs.getString(3));
                    }
        } catch (SQLException e) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, e);
        }
        return p;
    }
    @Override
    public void delete(int id) {
        try {
            String req= "DELETE FROM `reclamation` WHERE `reclamation`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
