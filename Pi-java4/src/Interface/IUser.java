/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.util.List;
import entities.User;
import javafx.collections.ObservableList;

/**
 *
 * @author Siala
 */
public interface IUser extends IService <User, Integer> {

   
    public boolean findByLogin (String s);
    public User findByLogin1 (String s);
    public User UserByLogin (String s);
    public boolean findByPassword (String s);
    public String Getrole(String s);
    public ObservableList<User> DisplayAllClients();
    public ObservableList<User> findClientsByUserNom(String nom );
    public int getnombreClients();
    public double getPourcentageClients();
    public int Client_NbRecettes(int id);
    public int Client_NbComment(int id);
      /////////////////////////////////////
    public ObservableList<User> DisplayAllResponsables();
    public int CountUserByRoles(String Role);
    ////////////////////////////////////
    
}
