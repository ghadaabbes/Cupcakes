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
public class Vote {
    private int id;
    private Recette idrecette;
    private int rating;

    public Vote(int id, Recette idrecette, int rating) {
        this.id = id;
        this.idrecette = idrecette;
        this.rating = rating;
    }

    public Vote(Recette idrecette, int rating) {
        this.idrecette = idrecette;
        this.rating = rating;
    }

    public Vote(int rating) {
        this.rating = rating;
    }

    public Vote() {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.idrecette);
        hash = 59 * hash + this.rating;
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
        final Vote other = (Vote) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.idrecette, other.idrecette)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", idrecette=" + idrecette + ", rating=" + rating + '}';
    }
    
    
}
