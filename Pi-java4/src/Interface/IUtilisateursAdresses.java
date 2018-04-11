/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.User;
import entities.Utilisateurs_Adresses;
import java.util.List;

/**
 *
 * @author beryl kristina
 */
public interface IUtilisateursAdresses {
    
    public List<Utilisateurs_Adresses> getAll();
    public void remove(Integer id);
    public void add(Utilisateurs_Adresses t);
    public List<Utilisateurs_Adresses> GetByUsersId(User u1);
    public Utilisateurs_Adresses findById(Integer id);
    public Utilisateurs_Adresses findByAdresse(String adresse);
}
