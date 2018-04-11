/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.IUser;
import entities.Recette;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author Siala
 */
public class UserService implements IUser  {
    Connection connection;
 DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs  ; 
    private static UserService ppService ; 
public static UserService getInsatance() throws SQLException {
        if (ppService == null) {
            return ppService = new UserService();
        }
        return ppService;
    }
    public UserService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(User u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO fos_user"
                    + " (username,username_canonical,email,email_canonical,enabled,password,roles) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
             pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
           // pst.setInt(5,u.getEnabled() );
           pst.setInt(5,1 );
            pst.setString(6, u.getPassword());
            pst.setString(7, u.getRoles());
          
           
           
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
         //  throw new RuntimeException(ex); 
        }
    } 
     @Override
    public void update(User u) {
        try {
            System.out.println(u.toString());
            String requete = "update fos_user set username=?,username_canonical=?,email=?,email_canonical=?,enabled=?, password=?, roles=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
             pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
             pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
           pst.setInt(5,1 );
          
            pst.setString(6, u.getPassword());
           
            pst.setString(7, u.getRoles());
            

            pst.setInt(8, u.getId());
            
            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
           //  throw new RuntimeException(ex); 
        }
    }
     @Override
    public List<User> getAll() {
        List<User> user = new ArrayList<>();
        String req = "select * from fos_user";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                      
                
                        resultSet.getString("password"),
                      
                        resultSet.getString("roles")
                       );
                user.add(u);
             
            }
        } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        return user;
    }
     @Override
    public void remove(Integer r) {
        try {
            String requete = "delete from fos_user where id=?";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, r);

            ps.executeUpdate();
            System.out.println("remove sucess");
        } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        
    }
     @Override    
    public User findById(Integer r) {
        User user = null;
        String req = "select * from fos_user where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles")
                );
            }
        } catch (SQLException ex) {
       
           // ex.printStackTrace();
        }
        return user;
    }
     @Override
    public boolean findByLogin(String s) {
        User user = null;
        String req = "select * from fos_user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
            }
        } catch (SQLException ex) {
         //   ex.printStackTrace();
        }
        return user != null;
    }
     @Override        
    public User UserByLogin(String s) {
        User user = null;
        String req = "select * from fos_user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
            }
        } catch (SQLException ex) {
          //  ex.printStackTrace();
        }

        return user;
    }
     @Override
    public boolean findByPassword(String s) {
        User user = null;
        String req = "select * from fos_user where password =?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
            }
        } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        return user != null;
    }
    


    @Override
    public String Getrole(String s) {
        String s1 = "";
        String req = "select roles from fos_user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("roles");
            }
        } catch (SQLException ex) {
          //  ex.printStackTrace();
        }
        return s1;
    }
    
     @Override
    public User findByLogin1(String s) {
        User user = null;
        String req = "select * from fos_user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
            }
        } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        return user;
    }
          @Override
    public ObservableList<User> DisplayAllClients(){
             ObservableList<User> listeUsers=FXCollections.observableArrayList();
       String req="select * from fos_user where roles=?";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              User user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
               listeUsers.add(user);     
           }
       }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listeUsers;   
    }        
   
         @Override
   public ObservableList<User> findClientsByUserNom(String nom ){
        ObservableList<User> listeUsers=FXCollections.observableArrayList();
       String req="select * from fos_user where username=? AND roles=?";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setString(1,nom);
           preparedStatement.setString(2, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
             User user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
               listeUsers.add(user);      
           }
        }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);           
        }
        return listeUsers;    
    } 
   
    @Override
   public int getnombreClients(){
        int v1=0;
        String req1 = "select count(*) from fos_user where roles =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
       @Override
   public double getPourcentageClients(){
        int nbClients=0;
        String req1 = "select count(*) from fos_user where roles =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               nbClients= resultSet1.getInt(1); }
            System.out.println(nbClients);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
       
        int nbUsers=0;
        String req = "select count(*) from fos_user";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               nbUsers= resultSet.getInt(1); }
            System.out.println(nbUsers);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        double result=0.0;
        if(nbClients==0 || nbUsers==0){
            result=0;
        }else{
         result=((double)nbClients/(double)nbUsers)*100; 
        
  	  	result=(double) Math.round(result * 100) / 100;
  	  	
        }
       
        
    return result;    
   }
   
 
   
   
   
    //return id de top1 client
    public int ClientTOP1(){
        int Score=0; //note recette
        int ReturnidUser=0; //idrecette
        int idUser=0;
        String req = "select id from fos_user where roles=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idUser= resultSet.getInt(1);
               ////// 
               String req1 = "select count(*) from recette where iduser =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idUser);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int CountRecette=0;
                    while (resultSet1.next()) {
                    CountRecette= resultSet1.getInt(1); 
                    String req2="select count(*) from commentaire where iduser =?";
                    PreparedStatement preparedStatement2;
                    try{
                         preparedStatement2 = connection.prepareStatement(req2);
                    preparedStatement2.setInt(1, idUser);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    int CountComment=0;
                     while (resultSet2.next()) {
                    CountComment= resultSet2.getInt(1);
                      if(Score<=CountRecette + CountComment){
                        ReturnidUser=idUser;
                        Score=CountRecette + CountComment;
                       }
                     }       
                    }
                    catch(SQLException ex) {
                      ex.printStackTrace();
                    }
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
        System.out.println(ReturnidUser);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidUser;
    }
    
    //return id de top2 client
    public int ClientTOP2(){
        int Score=0; //note recette
        int ReturnidUser=0; //idrecette
        int idUser=0;
        int idTOP1=ClientTOP1();
        String req = "select id from fos_user where roles=? AND id <> ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            preparedStatement.setInt(2,idTOP1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idUser= resultSet.getInt(1);
               ////// 
               String req1 = "select count(*) from recette where iduser =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idUser);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int CountRecette=0;
                    while (resultSet1.next()) {
                    CountRecette= resultSet1.getInt(1); 
                    String req2="select count(*) from commentaire where iduser =?";
                    PreparedStatement preparedStatement2;
                    try{
                         preparedStatement2 = connection.prepareStatement(req2);
                    preparedStatement2.setInt(1, idUser);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    int CountComment=0;
                     while (resultSet2.next()) {
                    CountComment= resultSet2.getInt(1);
                      if(Score<=CountRecette + CountComment){
                        ReturnidUser=idUser;
                        Score=CountRecette + CountComment;
                       }
                     }       
                    }
                    catch(SQLException ex) {
                      ex.printStackTrace();
                    }
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
        System.out.println(ReturnidUser);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidUser;
    }
    
    //return id de top3 client
    public int ClientTOP3(){
        int Score=0; //note recette
        int ReturnidUser=0; //idrecette
        int idUser=0;
        int idTOP1=ClientTOP1();
        int idTOP2=ClientTOP2();
        
        String req = "select id from fos_user where roles=? AND id NOT IN(?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            preparedStatement.setInt(2,idTOP1);
            preparedStatement.setInt(3,idTOP2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idUser= resultSet.getInt(1);
               ////// 
               String req1 = "select count(*) from recette where iduser =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idUser);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int CountRecette=0;
                    while (resultSet1.next()) {
                    CountRecette= resultSet1.getInt(1); 
                    String req2="select count(*) from commentaire where iduser =?";
                    PreparedStatement preparedStatement2;
                    try{
                         preparedStatement2 = connection.prepareStatement(req2);
                    preparedStatement2.setInt(1, idUser);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    int CountComment=0;
                     while (resultSet2.next()) {
                    CountComment= resultSet2.getInt(1);
                      if(Score<=CountRecette + CountComment){
                        ReturnidUser=idUser;
                        Score=CountRecette + CountComment;
                       }
                     }       
                    }
                    catch(SQLException ex) {
                      ex.printStackTrace();
                    }
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
        System.out.println(ReturnidUser);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidUser;
    }
    
    //return id de top4 client
    public int ClientTOP4(){
        int Score=0; //note recette
        int ReturnidUser=0; //idrecette
        int idUser=0;
        int idTOP1=ClientTOP1();
        int idTOP2=ClientTOP2();
        int idTOP3=ClientTOP3();
        String req = "select id from fos_user where roles=? AND id NOT IN(?,?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            preparedStatement.setInt(2,idTOP1);
            preparedStatement.setInt(3,idTOP2);
            preparedStatement.setInt(4,idTOP3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idUser= resultSet.getInt(1);
               ////// 
               String req1 = "select count(*) from recette where iduser =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idUser);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int CountRecette=0;
                    while (resultSet1.next()) {
                    CountRecette= resultSet1.getInt(1); 
                    String req2="select count(*) from commentaire where iduser =?";
                    PreparedStatement preparedStatement2;
                    try{
                         preparedStatement2 = connection.prepareStatement(req2);
                    preparedStatement2.setInt(1, idUser);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    int CountComment=0;
                     while (resultSet2.next()) {
                    CountComment= resultSet2.getInt(1);
                      if(Score<=CountRecette + CountComment){
                        ReturnidUser=idUser;
                        Score=CountRecette + CountComment;
                       }
                     }       
                    }
                    catch(SQLException ex) {
                      ex.printStackTrace();
                    }
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
        System.out.println(ReturnidUser);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidUser;
    }
    
    //return id de top5 client
    public int ClientTOP5(){
        int Score=0; //note recette
        int ReturnidUser=0; //idrecette
        int idUser=0;
        int idTOP1=ClientTOP1();
        int idTOP2=ClientTOP2();
        int idTOP3=ClientTOP3();
        int idTOP4=ClientTOP4();
        String req = "select id from fos_user where roles=? AND id NOT IN(?,?,?,?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
            preparedStatement.setInt(2,idTOP1);
            preparedStatement.setInt(3,idTOP2);
            preparedStatement.setInt(4,idTOP3);
            preparedStatement.setInt(5,idTOP4);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               idUser= resultSet.getInt(1);
               ////// 
               String req1 = "select count(*) from recette where iduser =?";
               PreparedStatement preparedStatement1;
               try {
                    preparedStatement1 = connection.prepareStatement(req1);
                    preparedStatement1.setInt(1, idUser);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    int CountRecette=0;
                    while (resultSet1.next()) {
                    CountRecette= resultSet1.getInt(1); 
                    String req2="select count(*) from commentaire where iduser =?";
                    PreparedStatement preparedStatement2;
                    try{
                         preparedStatement2 = connection.prepareStatement(req2);
                    preparedStatement2.setInt(1, idUser);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    int CountComment=0;
                     while (resultSet2.next()) {
                    CountComment= resultSet2.getInt(1);
                      if(Score<=CountRecette + CountComment){
                        ReturnidUser=idUser;
                        Score=CountRecette + CountComment;
                       }
                     }       
                    }
                    catch(SQLException ex) {
                      ex.printStackTrace();
                    }
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
        System.out.println(ReturnidUser);
        System.out.println("avec score");
        System.out.println(Score);
        return ReturnidUser;
    }
    
    @Override
    public int Client_NbRecettes(int id){
        int v1=0;
        String req1 = "select count(*) from recette where iduser =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1,id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
    
    @Override
    public int Client_NbComment(int id){
        int v1=0;
        String req1 = "select count(*) from commentaire where iduser =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1,id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
    
    
       ////////////////////////////////////////////////////////////////
           @Override
    public ObservableList<User> DisplayAllResponsables(){
             ObservableList<User> listeUsers=FXCollections.observableArrayList();
       String req="select * from fos_user where roles=?";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setString(1, "a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}");
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              User user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("roles"));
               listeUsers.add(user);     
           }
       }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listeUsers;   
    }        
   @Override
   public int CountUserByRoles(String Role){
         int v1=0;
        String req1 = "select count(*) from fos_user where roles =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, Role);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
   }
   public String activationcode(){
      //String pw="1234";
//      RegisterController n=new RegisterController();
//      String pw=n.chaine1();
 Random gen = new Random();
            String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

            String pw = "";
            for (int i = 0; i < 8; i++) {
                int index = (int) (gen.nextDouble() * letters.length());
                pw += letters.substring(index, index + 1);
            }
            return pw;
}
    //////////////////////////////////////////////////////////////
}
