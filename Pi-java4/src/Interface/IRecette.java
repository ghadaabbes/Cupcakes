/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Recette;
import entities.User;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Siala
 */
public interface IRecette extends IService <Recette, Integer>{
     ObservableList<Recette> getByUser(int Iduser );
      ObservableList<Recette> DisplayAll(); 
      ObservableList<Recette> RechercheFiltrer(String ValueType1,String ValueCout1,String ValueDiff1);
      ObservableList<Recette> findByNom(String nom );
      public int CountType(String type);
      public int CountCout(String cout);
      public int CountDiff(String diff);
      public int NbTotalR();
       public int countCommentOf1Recette(int idrecette);
   /*  
     
      
     public Recette findById( int i); */
    
}
