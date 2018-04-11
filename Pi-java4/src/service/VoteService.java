/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entities.Vote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author Siala
 */
public class VoteService  {
     Connection connection;

    public VoteService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
   
    public void add(Vote c) {
            System.out.println(c.toString());
        String req = "insert into vote (idrecette,rating)"
                + " values (?,?)";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, c.getIdrecette().getId());
            preparedStatement.setInt(2, c.getRating());
            
           
           
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }
    public Vote findByRecette(Integer r) {
        Vote v = null;
        String req = "select * from vote where idrecette =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               v= new Vote(resultSet.getInt(1),
                       new RecetteService().findById(resultSet.getInt(2)),
                       
                       
                      resultSet.getInt(3)
                      ); }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return v;
    }
        
      
    public List<Vote> getListVoteByRecette(int IdRecette) {
       List<Vote> votes  = new ArrayList<>();
        String req = "select * from vote where idrecette=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,IdRecette);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Vote vote= new Vote(resultSet.getInt(1),
                        new RecetteService().findById(resultSet.getInt(2)),
                     resultSet.getInt(3)
                      
                      
                      );
                votes.add(vote); 
            }
        } catch (SQLException ex) {
        }
        return votes  ;
    
    }
    
    public double noteRecette(int r){
         int v = 0;
         int v1=0;
        String req = "select count(*) from vote where idrecette =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               v= resultSet.getInt(1); }
            System.out.println(v);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        ///////////
           String req1 = "select sum(rating) from vote where idrecette =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1, r);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        //////
         if(v==0 || v1==0){
           return 0;  
         }
        double x=(double)v1/(double)v;
       
        if(x>0 && x<=0.5){
            x=0.5;
            
        }else if(x>0.5 &&x<=1.0){
            x=1.0;
        }else if(x>1.0 && x<=1.5){
            x=1.5;
        }else if(x>1.5 && x<=2.0){
            x=2.0;
        }else if(x>2.0 && x<=2.5){
            x=2.5;
        } else if(x>2.5 && x<=3.0){
            x=3.0;
        }else if(x>3.0 && x<=3.5){
            x=3.5;
        }else if(x>3.5 && x<=4.0){
            x=4.0;
        }else if(x>4.0 && x<=4.5){
            x=4.5;
        }else if (x>4.5 && x<=5.0){
            x=5.0;
        }
        
        System.out.println(x);
        return x;
    }
    //return id de top1 recette
    public int TOP1(){
        int Score=0; //note recette
        int ReturnidRecette=0; //idrecette
        int idRecette=0;
        String req = "select id from recette ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idRecette= resultSet.getInt(1);
               ////// 
               String req1 = "select sum(rating) from vote where idrecette =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idRecette);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int Somme=0;
                    while (resultSet1.next()) {
                    Somme= resultSet1.getInt(1); }
                   
                    if(Score<=Somme){
                        ReturnidRecette=idRecette;
                        Score=Somme;
                    }
                    
                } catch (SQLException ex) {
                      ex.printStackTrace();
                }
                ////   
           }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("top1");
        System.out.println(ReturnidRecette);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidRecette;
    }
    
    
        //return id de top2 recette
    public int TOP2(){
        int Score=0; //note recette
        int ReturnidRecette=0; //idrecette
        int idRecette=0;
        int idRecettteTOP1=TOP1();
        String req = "select id from recette WHERE id <> ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idRecettteTOP1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idRecette= resultSet.getInt(1);
               ////// 
               String req1 = "select sum(rating) from vote where idrecette =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idRecette);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int Somme=0;
                    while (resultSet1.next()) {
                    Somme= resultSet1.getInt(1); }
                   
                    if(Score<=Somme){
                        ReturnidRecette=idRecette;
                        Score=Somme;
                    }
                    
                } catch (SQLException ex) {
                      ex.printStackTrace();
                }
                ////   
           }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("top2");
        System.out.println(ReturnidRecette);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidRecette;
    }   
    //return id recette top3
    public int TOP3(){
        int Score=0; //note recette
        int ReturnidRecette=0; //idrecette
        int idRecette=0;
        int idRecettteTOP1=TOP1();
        int idRecettteTOP2=TOP2();
        String req = "select id from recette WHERE id NOT IN (?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idRecettteTOP1);
            preparedStatement.setInt(2,idRecettteTOP2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idRecette= resultSet.getInt(1);
               ////// 
               String req1 = "select sum(rating) from vote where idrecette =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idRecette);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int Somme=0;
                    while (resultSet1.next()) {
                    Somme= resultSet1.getInt(1); }
                   
                    if(Score<=Somme){
                        ReturnidRecette=idRecette;
                        Score=Somme;
                    }
                    
                } catch (SQLException ex) {
                      ex.printStackTrace();
                }
                ////   
           }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("top3");
        System.out.println(ReturnidRecette);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidRecette;
    } 

   //return id recette top4
    public int TOP4(){
        int Score=0; //note recette
        int ReturnidRecette=0; //idrecette
        int idRecette=0;
        int idRecettteTOP1=TOP1();
        int idRecettteTOP2=TOP2();
        int idRecettteTOP3=TOP3();
        String req = "select id from recette WHERE id NOT IN (?,?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idRecettteTOP1);
            preparedStatement.setInt(2,idRecettteTOP2);
            preparedStatement.setInt(3,idRecettteTOP3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idRecette= resultSet.getInt(1);
               ////// 
               String req1 = "select sum(rating) from vote where idrecette =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idRecette);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int Somme=0;
                    while (resultSet1.next()) {
                    Somme= resultSet1.getInt(1); }
                   
                    if(Score<=Somme){
                        ReturnidRecette=idRecette;
                        Score=Somme;
                    }
                    
                } catch (SQLException ex) {
                      ex.printStackTrace();
                }
                ////   
           }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("top4");
        System.out.println(ReturnidRecette);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidRecette;
    } 
   //return id recette top5
    public int TOP5(){
        int Score=0; //note recette
        int ReturnidRecette=0; //idrecette
        int idRecette=0;
        int idRecettteTOP1=TOP1();
        int idRecettteTOP2=TOP2();
        int idRecettteTOP3=TOP3();
        int idRecettteTOP4=TOP4();
        String req = "select id from recette WHERE id NOT IN (?,?,?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idRecettteTOP1);
            preparedStatement.setInt(2,idRecettteTOP2);
            preparedStatement.setInt(3,idRecettteTOP3);
            preparedStatement.setInt(4,idRecettteTOP4);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idRecette= resultSet.getInt(1);
               ////// 
               String req1 = "select sum(rating) from vote where idrecette =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idRecette);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int Somme=0;
                    while (resultSet1.next()) {
                    Somme= resultSet1.getInt(1); }
                   
                    if(Score<=Somme){
                        ReturnidRecette=idRecette;
                        Score=Somme;
                    }
                    
                } catch (SQLException ex) {
                      ex.printStackTrace();
                }
                ////   
           }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println("top5");
        System.out.println(ReturnidRecette);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidRecette;
    } 
    
    public int getScoreVote(int idrecette){
        int v1=0;
        String req1 = "select sum(rating) from vote where idrecette =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1, idrecette);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
    
    public int NbTotalV(){
        int v1=0;
        String req1 = "select count(*) from vote ";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }

}
