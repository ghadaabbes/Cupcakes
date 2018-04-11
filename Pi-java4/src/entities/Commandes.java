/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author beryl kristina
 */
public class Commandes {
     private int id;
     private User user_id;
     private Date  date;
     private float prixtotal;
     private Utilisateurs_Adresses adresse_id; 

    public int getId() {
        return id;
    }

    public Utilisateurs_Adresses getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(Utilisateurs_Adresses adresse_id) {
        this.adresse_id = adresse_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(float prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Commandes(int id, User user_id, Date date, float prixtotal,Utilisateurs_Adresses adresse_id) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.prixtotal = prixtotal;
        this.adresse_id = adresse_id;
    }
    public Commandes( User user_id, Date date, float prixtotal,Utilisateurs_Adresses adresse_id) {
        
        this.user_id = user_id;
        this.date = date;
        this.prixtotal = prixtotal;
        this.adresse_id = adresse_id;
    }

    @Override
    public String toString() {
        return "Commandes{" + "id=" + id + ", user_id=" + user_id + ", date=" + date + ", prixtotal=" + prixtotal + ", adresse_id=" + adresse_id + '}';
    }

   
   
     
     
     
    
}
