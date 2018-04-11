/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Siala
 */
public class Commentaire {
    private int id;
    private Recette idrecette;
    private User iduser;
    
    private String comment;

    public Commentaire(int id,Recette idrecette, User iduser,  String comment) {
        this.id = id;
        this.idrecette = idrecette;
        this.iduser = iduser;
        
        this.comment = comment;
    }

    public Commentaire(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Commentaire(Recette idrecette,User iduser, String comment) {
        this.idrecette = idrecette;
        this.iduser = iduser;
        
        this.comment = comment;
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        public Recette getIdrecette() {
        return idrecette;
    }

    public void setIdrecette(Recette idrecette) {
        this.idrecette = idrecette;
    }
    
    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.idrecette);
        hash = 71 * hash + Objects.hashCode(this.iduser);
        
        hash = 71 * hash + Objects.hashCode(this.comment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
         if (!Objects.equals(this.idrecette, other.idrecette)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", idrecette=" + idrecette +", iduser=" + iduser +  ", comment=" + comment + '}';
    }
    
}
