/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.DataSource;
import entities.Evaluation;
import entities.Patisserie;
import entities.Reclamation;
import java.math.BigDecimal;
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
public class EvaluationService {
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
private static EvaluationService evaluationService;
 public static EvaluationService getInstance() {
        if (evaluationService == null) {
            return evaluationService = new EvaluationService();
        }
        return evaluationService;
    }
    

    public void createEvaluation(Evaluation e) {
        try {
            String req = "INSERT INTO evaluation (patisserie_id,mail,local,service,noteprix,noteproduit,decor) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            
            st.setString(2, e.getMail());
            st.setInt(7, e.getDecor());
            st.setInt(3, e.getLocal());
            st.setInt(4, e.getService());
            st.setInt(5, e.getNoteprix());
            st.setInt(6, e.getNoteproduit());
            st.setInt(1, e.getPatisserieId().getIdPatisserie());
     
            st.executeUpdate();
            System.out.println("ev ajoute");
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Patisserie getPatisseriebyId(int id){
        Patisserie p=new Patisserie();
        try {
         
                     stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from patisserie WHERE idPatisserie = "+id);
           
                    while (rs.next()) {
                        p=new Patisserie(rs.getInt(2), rs.getString(3));
                    }
        } catch (SQLException e) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, e);
        }
        return p;
    }
     public List<Evaluation> getAll() {
         ObservableList<Evaluation> listEvaluation = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from evaluation");
            while (rs.next()) {
                Patisserie p=getPatisseriebyId(rs.getInt(2));
                
                listEvaluation.add(new Evaluation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEvaluation;
    }
    
      public void delete(int id) {
        try {
            String req= "DELETE FROM `evaluation` WHERE `id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCause());
        }
    }

 public List<Evaluation> Trienotelocal() throws SQLException {
         List<Evaluation> ls = new ArrayList();
        
        String sql = "SELECT * FROM evaluation r ORDER BY local desc";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        Evaluation v=null;
      
        while (rs.next()) {
              Patisserie p=getPatisseriebyId(rs.getInt(2));
           v=new Evaluation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                  v.setId(rs.getInt(1));   
                   ls.add(v);
            
        }
        return ls;
    }
  public List<Evaluation> Tritriservic() throws SQLException {
         List<Evaluation> ls = new ArrayList();
        
        String sql = "SELECT * FROM evaluation r ORDER BY service desc";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        Evaluation v=null;
      
        while (rs.next()) {
              Patisserie p=getPatisseriebyId(rs.getInt(2));
           v=new Evaluation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                  v.setId(rs.getInt(1));   
                   ls.add(v);
            
        }
        return ls;
    }
  public List<Evaluation> Tritriprix() throws SQLException {
         List<Evaluation> ls = new ArrayList();
        
        String sql = "SELECT * FROM evaluation r ORDER BY noteprix desc";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        Evaluation v=null;
      
        while (rs.next()) {
              Patisserie p=getPatisseriebyId(rs.getInt(2));
           v=new Evaluation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                  v.setId(rs.getInt(1));   
                   ls.add(v);
            
        }
        return ls;
    }
   public List<Evaluation> Tritriprd() throws SQLException {
         List<Evaluation> ls = new ArrayList();
        
        String sql = "SELECT * FROM evaluation r ORDER BY noteproduit desc";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        Evaluation v=null;
      
        while (rs.next()) {
              Patisserie p=getPatisseriebyId(rs.getInt(2));
           v=new Evaluation(rs.getInt(1),p,
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                  v.setId(rs.getInt(1));   
                   ls.add(v);
            
        }
        return ls;
    }
      
}

