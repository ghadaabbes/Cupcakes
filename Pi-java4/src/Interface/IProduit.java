/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Produit;
import entities.User;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author CSS
 */
public interface IProduit {
        public void add(Produit produit);
        public void remove(int idProduit);
              public List<Produit> findAll();
               public ObservableList<Produit> DisplayAll();
                public Produit findByNom(String r);
                    public List<Produit> findByCategorie(int id_Categorie);
                      public List<Produit> getByUser(int Iduser);
  //  public ObservableList<Produit> getByUser(int Iduser );
    public Produit findById(Integer r);
    public void update(Produit p); 
    public ObservableList<Produit> DisplayByNom(String nom) ;
        public int NbTotalProduit();
       
}
