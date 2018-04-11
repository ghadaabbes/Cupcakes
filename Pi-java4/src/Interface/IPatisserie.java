/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Patisserie;
import entities.User;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author CSS
 */
public interface IPatisserie {
       public void add(Patisserie patisserie);
     public void  remove(int idPatisserie);
         public List<Patisserie> getAll();
    public ObservableList<Patisserie> getByUser(int Iduser );
    public Patisserie findById(Integer r);
    public void update(Patisserie patisserie);
    public Patisserie findByNom(String n);
     public List<Patisserie> findByUser(int user);
     public ObservableList<Patisserie> DisplayAll() ;
     public ObservableList<Patisserie> DisplayByNom(String nom) ;
         public List<Patisserie> findAll();
}
