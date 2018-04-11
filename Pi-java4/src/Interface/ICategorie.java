/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Categorie;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author CSS
 */
public interface ICategorie {
     public void add(Categorie categorie);
               public void  remove(int id_Categorie) ;
                   public ObservableList<Categorie> DisplayAll();
   // public List<Categorie> getByPatisserie(int IdUser);
                            public Categorie findByNom(String n);
                                   public Categorie findById(Integer r);
                                       public List<Categorie> findAll();
                                       public ObservableList<Categorie> getByUser(int Iduser );
}
