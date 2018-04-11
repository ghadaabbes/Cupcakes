/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.IRecette;
import entities.Recette;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;


/**
 *
 * @author Siala
 */
public class RecetteService implements IRecette{
      Connection connection;

    public RecetteService() {
        connection = DataSource.getInsatance().getConnection();
    }
    @Override
    public void add(Recette r) {
            System.out.println(r.toString());
        String req = "insert into recette (iduser,nom,type,description,nom_image,cout,temps_preparation,temps_repos,temps_cuisson,nb_personne,difficulte,astuces,ingredients,etapes )"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, r.getIduser().getId());
            preparedStatement.setString(2, r.getNom());
            preparedStatement.setString(3, r.getType());
            preparedStatement.setString(4, r.getDescription());
            preparedStatement.setString(5, r.getNom_image());
            preparedStatement.setString(6, r.getCout());
       
            preparedStatement.setTime(7, r.getTemps_preparation()); 
            preparedStatement.setTime(8, r.getTemps_repos()); 
            preparedStatement.setTime(9, r.getTemps_cuisson()); 
            
            preparedStatement.setInt(10, r.getNb_personne()); 
            preparedStatement.setString(11, r.getDifficulte());
            preparedStatement.setString(12, r.getAstuces());      
            preparedStatement.setString(13, r.getIngredients());  
            preparedStatement.setString(14, r.getEtapes()); 
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }
   @Override
   public ObservableList<Recette> getByUser(int Iduser ){
            ObservableList<Recette> listeMesRecettes=FXCollections.observableArrayList();
       String req="select * from recette where iduser=? ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setInt(1,Iduser);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      
                      
                      );
               listeMesRecettes.add(r);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeMesRecettes;
             
         } 

 

    @Override
    public void update(Recette t) {
            System.out.println(t.toString());
        String req = "update recette set id=?,nom=? ,type=?,description=?,nom_image=?,cout=?,temps_preparation=?,temps_repos=?,temps_cuisson=?,nb_personne=?,difficulte=?,astuces=?,ingredients=?,etapes=? where id=?";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
             System.out.println(t.getId());
            preparedStatement.setInt(1, t.getId()); 
            preparedStatement.setString(2, t.getNom());
            preparedStatement.setString(3, t.getType());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setString(5, t.getNom_image());
            preparedStatement.setString(6, t.getCout());
       
            preparedStatement.setTime(7, t.getTemps_preparation()); 
            preparedStatement.setTime(8, t.getTemps_repos()); 
            preparedStatement.setTime(9, t.getTemps_cuisson()); 
            
            preparedStatement.setInt(10, t.getNb_personne()); 
            preparedStatement.setString(11, t.getDifficulte());
            preparedStatement.setString(12, t.getAstuces());      
            preparedStatement.setString(13, t.getIngredients());  
            preparedStatement.setString(14, t.getEtapes()); 
            preparedStatement.setInt(15, t.getId());           

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer r) {
     String req = "delete from recette where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Recette findById(Integer r) {
      Recette recette = null;
        String req = "select * from recette where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               recette= new Recette(resultSet.getInt(1),
                       new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      
                      
                      ); }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return recette;
    }

    @Override
    public List<Recette> getAll() {
     List<Recette> recettes = new ArrayList<>();
        String req = "select * from recette ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Recette recette= new Recette(resultSet.getInt(1),
                       new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      
                      
                      );
                recettes.add(recette); 
            }
        } catch (SQLException ex) {
        }
        return recettes ;
    }

      @Override
    public ObservableList<Recette> DisplayAll(){
             ObservableList<Recette> listeMesRecettes=FXCollections.observableArrayList();
       String req="select * from recette ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                       new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                    );
               listeMesRecettes.add(r);     
           }
       }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return listeMesRecettes;   
    }
    
    
    
    
    
    
    
    
    
        @Override
    public ObservableList<Recette> RechercheFiltrer(String ValueType1,String ValueCout1,String ValueDiff1){
       ObservableList<Recette> listeMesRecettes=FXCollections.observableArrayList(); 
       System.out.println("***");     
       System.out.println(ValueType1);
       System.out.println(ValueCout1);
       System.out.println(ValueDiff1);

       
        if(!"".equals(ValueType1) && !"".equals(ValueCout1) && !"".equals(ValueDiff1)){
            String req="select * from recette where type=? AND cout=? AND difficulte=?";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            preparedStatement.setString(1,ValueType1);
            preparedStatement.setString(2,ValueCout1);
           preparedStatement.setString(3,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        } else if(!"".equals(ValueType1) && !"".equals(ValueCout1) && "".equals(ValueDiff1)){
            String req="select * from recette where type=? AND cout=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            preparedStatement.setString(1,ValueType1);
            preparedStatement.setString(2,ValueCout1);
          // preparedStatement.setString(3,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }else if(!"".equals(ValueType1) && "".equals(ValueCout1) && !"".equals(ValueDiff1)){
            String req="select * from recette where type=? AND difficulte=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            preparedStatement.setString(1,ValueType1);
           // preparedStatement.setString(2,ValueCout1);
            preparedStatement.setString(2,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }else if(!"".equals(ValueType1) && "".equals(ValueCout1) && "".equals(ValueDiff1)){
            String req="select * from recette where type=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            preparedStatement.setString(1,ValueType1);
           // preparedStatement.setString(2,ValueCout1);
           // preparedStatement.setString(3,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }else if("".equals(ValueType1) && !"".equals(ValueCout1) && "".equals(ValueDiff1)){
            String req="select * from recette where cout=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            //preparedStatement.setString(1,ValueType1);
            preparedStatement.setString(1,ValueCout1);
           // preparedStatement.setString(3,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }else if("".equals(ValueType1) && "".equals(ValueCout1) && !"".equals(ValueDiff1)){
            String req="select * from recette where difficulte=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            //preparedStatement.setString(1,ValueType1);
            //preparedStatement.setString(1,ValueCout1);
            preparedStatement.setString(1,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }else if("".equals(ValueType1) && !"".equals(ValueCout1) && !"".equals(ValueDiff1)){
            String req="select * from recette where cout=? AND difficulte=? ";
            PreparedStatement preparedStatement;
            try {
            preparedStatement=connection.prepareStatement(req);

            //preparedStatement.setString(1,ValueType1);
            preparedStatement.setString(1,ValueCout1);
            preparedStatement.setString(2,ValueDiff1);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      );
               listeMesRecettes.add(r);  
            }
            }catch (SQLException ex){
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           }
        }
     
        return listeMesRecettes;   
    }

     @Override
   public ObservableList<Recette> findByNom(String nom ){
            ObservableList<Recette> listeMesRecettes=FXCollections.observableArrayList();
       String req="select * from recette where nom=? ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setString(1,nom);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Recette r= new Recette(resultSet.getInt(1),
                      new UserService().findById(resultSet.getInt(2)),
                      resultSet.getString(3),
                      resultSet.getString(4),
                      resultSet.getString(5),
                      resultSet.getString(6),
                      resultSet.getString(7),
                      resultSet.getTime(8) , 
                      resultSet.getTime(9) ,
                      resultSet.getTime(10) ,
                      resultSet.getInt(11) ,
                       resultSet.getString(12),
                      resultSet.getString(13),
                      resultSet.getString(14),
                      resultSet.getString(15)
                      
                      
                      );
               listeMesRecettes.add(r);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeMesRecettes;
             
    } 
    @Override
    public int CountType(String type){
        int v1=0;
        String req1 = "select count(*) from recette where type =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, type);
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
    public int CountCout(String cout){
        int v1=0;
        String req1 = "select count(*) from recette where cout =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, cout);
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
    public int CountDiff(String diff){
        int v1=0;
        String req1 = "select count(*) from recette where difficulte=?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setString(1, diff);
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
    public int NbTotalR(){
        int v1=0;
        String req1 = "select count(*) from recette ";
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
    
    @Override
    public int countCommentOf1Recette(int idrecette){
        int v1=0;
        String req1 = "select count(*) from commentaire where idrecette=? ";
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
}
