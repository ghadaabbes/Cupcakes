/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author beryl kristina
 */
public class Utilisateurs_Adresses {
    
    private int id;
    private User user_id;
    private int telephone;
    private String adresse;
    private String cp;
    private String pays;
    private String ville;
    private String complement;

    public int getId() {
        return id;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Utilisateurs_Adresses{" + "id=" + id + ", user_id=" + user_id + ", telephone=" + telephone + ", adresse=" + adresse + ", cp=" + cp + ", pays=" + pays + ", ville=" + ville + ", complement=" + complement + '}';
    }

    public Utilisateurs_Adresses(int id, User user_id, int telephone, String adresse, String cp, String pays, String ville, String complement) {
        this.id = id;
        this.user_id = user_id;
        this.telephone = telephone;
        this.adresse = adresse;
        this.cp = cp;
        this.pays = pays;
        this.ville = ville;
        this.complement = complement;
    }

    public Utilisateurs_Adresses() {
    }
    
    public String affichA()
    {
        return this.pays+","+this.ville+","+this.adresse;
    
    }
                         
    
    
    
    
}
