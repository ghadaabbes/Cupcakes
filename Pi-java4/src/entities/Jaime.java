/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author USER
 */
public class Jaime {
    private int id_jaime;
    private int jaime;
    private int iduser;
    private int idpub;

    public Jaime(int id_jaime, int jaime, int iduser, int idpub) {
        this.id_jaime = id_jaime;
        this.jaime = jaime;
        this.iduser = iduser;
        this.idpub = idpub;
    }

    public Jaime(int iduser, int idpub) {
        this.iduser = iduser;
        this.idpub = idpub;
    }

    public Jaime(int jaime) {
        this.jaime = jaime;
    }

    public Jaime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_jaime() {
        return id_jaime;
    }

    public void setId_jaime(int id_jaime) {
        this.id_jaime = id_jaime;
    }

    public int getJaime() {
        return jaime;
    }

    public void setJaime(int jaime) {
        this.jaime = jaime;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpub() {
        return idpub;
    }

    public void setIdpub(int idpub) {
        this.idpub = idpub;
    }
    
    
    
    
}
