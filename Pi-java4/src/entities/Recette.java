/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Time;
import java.util.Objects;
import javafx.scene.image.Image;


/**
 *
 * @author Siala
 */
public class Recette {
     private int id=10;
     private User iduser;
     private String nom;
     private String type;
     private String description;
     private String nom_image;
     private String cout;
     private Time temps_preparation;
     private Time temps_repos;
     private Time temps_cuisson;
     private int nb_personne;
     private String difficulte;
     private String astuces;
     private String ingredients;
     private String etapes;

    public Recette(int id, User iduser, String nom, String type, String description, String nom_image, String cout, Time temps_preparation, Time temps_repos, Time temps_cuisson, int nb_personne, String difficulte, String astuces, String ingredients, String etapes) {
        this.id = id;
        this.iduser = iduser;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.nom_image = nom_image;
        this.cout = cout;
        this.temps_preparation = temps_preparation;
        this.temps_repos = temps_repos;
        this.temps_cuisson = temps_cuisson;
        this.nb_personne = nb_personne;
        this.difficulte = difficulte;
        this.astuces = astuces;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette(User iduser, String nom, String type, String description, String nom_image, String cout, Time temps_preparation, Time temps_repos, Time temps_cuisson, int nb_personne, String difficulte, String astuces, String ingredients, String etapes) {
        this.iduser = iduser;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.nom_image = nom_image;
        this.cout = cout;
        this.temps_preparation = temps_preparation;
        this.temps_repos = temps_repos;
        this.temps_cuisson = temps_cuisson;
        this.nb_personne = nb_personne;
        this.difficulte = difficulte;
        this.astuces = astuces;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public Time getTemps_preparation() {
        return temps_preparation;
    }

    public void setTemps_preparation(Time temps_preparation) {
        this.temps_preparation = temps_preparation;
    }

    public Time getTemps_repos() {
        return temps_repos;
    }

    public void setTemps_repos(Time temps_repos) {
        this.temps_repos = temps_repos;
    }

    public Time getTemps_cuisson() {
        return temps_cuisson;
    }

    public void setTemps_cuisson(Time temps_cuisson) {
        this.temps_cuisson = temps_cuisson;
    }

    public int getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public String getAstuces() {
        return astuces;
    }

    public void setAstuces(String astuces) {
        this.astuces = astuces;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getEtapes() {
        return etapes;
    }

    public void setEtapes(String etapes) {
        this.etapes = etapes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.iduser);
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.nom_image);
        hash = 29 * hash + Objects.hashCode(this.cout);
        hash = 29 * hash + Objects.hashCode(this.temps_preparation);
        hash = 29 * hash + Objects.hashCode(this.temps_repos);
        hash = 29 * hash + Objects.hashCode(this.temps_cuisson);
        hash = 29 * hash + this.nb_personne;
        hash = 29 * hash + Objects.hashCode(this.difficulte);
        hash = 29 * hash + Objects.hashCode(this.astuces);
        hash = 29 * hash + Objects.hashCode(this.ingredients);
        hash = 29 * hash + Objects.hashCode(this.etapes);
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
        final Recette other = (Recette) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nb_personne != other.nb_personne) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.nom_image, other.nom_image)) {
            return false;
        }
        if (!Objects.equals(this.cout, other.cout)) {
            return false;
        }
        if (!Objects.equals(this.difficulte, other.difficulte)) {
            return false;
        }
        if (!Objects.equals(this.astuces, other.astuces)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        if (!Objects.equals(this.etapes, other.etapes)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        if (!Objects.equals(this.temps_preparation, other.temps_preparation)) {
            return false;
        }
        if (!Objects.equals(this.temps_repos, other.temps_repos)) {
            return false;
        }
        if (!Objects.equals(this.temps_cuisson, other.temps_cuisson)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recette{" + "id=" + id + ", iduser=" + iduser + ", nom=" + nom + ", type=" + type + ", description=" + description + ", nom_image=" + nom_image + ", cout=" + cout + ", temps_preparation=" + temps_preparation + ", temps_repos=" + temps_repos + ", temps_cuisson=" + temps_cuisson + ", nb_personne=" + nb_personne + ", difficulte=" + difficulte + ", astuces=" + astuces + ", ingredients=" + ingredients + ", etapes=" + etapes + '}';
    }

    public String setTemps_cuisson(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNom_image(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
             
}
