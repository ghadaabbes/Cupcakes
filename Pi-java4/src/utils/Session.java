/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import Interface.ICategorie;
import Interface.ICommandes;
import Interface.ICommentaire;
import Interface.ILignes;
import Interface.IPatisserie;
import Interface.IProduit;
import Interface.IRecette;
import Interface.IUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.User;
import service.CategorieService;
import service.CommentaireService;
import service.RecetteService;
import service.CommandesServices;
import service.LigneServices;
import service.PatisserieService;
import service.ProduitService;

import service.UserService;
/**
 *
 * @author Siala
 */
public class Session {
      public static IUser iuserService =new UserService();
      public static IRecette iRecetteService =  new RecetteService();
      public static ICommentaire iCommentaireService =  new CommentaireService();
      public static ICommandes iCommandes = new CommandesServices();
      public static ILignes iLignes = new LigneServices();
      public static IPatisserie iPatisserieService =new PatisserieService();
      public static IProduit iProduitService =new ProduitService();
      public static ICategorie iCategorieService =new CategorieService();
          //hello

    public  static User LoggedUser ;
    


    public Session() {
    }

   

    public User getLoggedUser() {
        return LoggedUser;
    }

    

    public  void setLoggedUser(User LoggedUser) {
        Session.LoggedUser = LoggedUser;
    }

  
    
    /**
     *
     * @param login
     * @return
     * @throws SQLException
     */
    public User SetLoggedUser (String login ) throws SQLException{
       Connection connection;
         connection = DataSource.getInsatance().getConnection();
               
        String sql = "SELECT * FROM fos_user WHERE login=? " ;
        
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, login);
        
        ResultSet resultSet = pst.executeQuery();
        if(resultSet.next()){
         LoggedUser = new User(); 
        LoggedUser.setId(resultSet.getInt("id") );  
        LoggedUser = iuserService.findById(LoggedUser.getId());
        }
        
       
        return LoggedUser;   
    
    }

}
