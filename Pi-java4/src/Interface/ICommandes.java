/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Commandes;
import entities.User;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author beryl kristina
 */
public interface ICommandes {
    
    public void remove(Integer id);
    public List<Commandes> getAll();
    public Commandes findById(Integer id); 
    public void add(Commandes t);
    public ObservableList<Commandes> findBy(User user_id);
    public ObservableList<Commandes> DisplayAll();
    
}
