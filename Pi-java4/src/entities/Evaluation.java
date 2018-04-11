/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Siala
 */
@Entity
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
    , @NamedQuery(name = "Evaluation.findById", query = "SELECT e FROM Evaluation e WHERE e.id = :id")
    , @NamedQuery(name = "Evaluation.findByMail", query = "SELECT e FROM Evaluation e WHERE e.mail = :mail")
    , @NamedQuery(name = "Evaluation.findByLocal", query = "SELECT e FROM Evaluation e WHERE e.local = :local")
    , @NamedQuery(name = "Evaluation.findByService", query = "SELECT e FROM Evaluation e WHERE e.service = :service")
    , @NamedQuery(name = "Evaluation.findByNoteprix", query = "SELECT e FROM Evaluation e WHERE e.noteprix = :noteprix")
    , @NamedQuery(name = "Evaluation.findByNoteproduit", query = "SELECT e FROM Evaluation e WHERE e.noteproduit = :noteproduit")
    , @NamedQuery(name = "Evaluation.findByDecor", query = "SELECT e FROM Evaluation e WHERE e.decor = :decor")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "local")
    private int local;
    @Basic(optional = false)
    @Column(name = "service")
    private int service;
    @Basic(optional = false)
    @Column(name = "noteprix")
    private int noteprix;
    @Basic(optional = false)
    @Column(name = "noteproduit")
    private int noteproduit;
    @Basic(optional = false)
    @Column(name = "decor")
    private int decor;
    @JoinColumn(name = "patisserie_id", referencedColumnName = "idPatisserie")
    @ManyToOne
    private Patisserie patisserieId;

    public Evaluation() {
    }

    public Evaluation(Integer id) {
        this.id = id;
    }

    public Evaluation(Integer id, String mail, int local, int service, int noteprix, int noteproduit, int decor) {
        this.id = id;
        this.mail = mail;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
    }

    public Evaluation(Patisserie patisserieId,String mail, int local, int service, int noteprix, int noteproduit, int decor) {
        this.mail = mail;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
        this.patisserieId = patisserieId;
    }

    public Evaluation(String mail, int local, int service, int noteprix, int noteproduit, int decor) {
        this.mail = mail;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
    }

    public Evaluation(Integer id, Patisserie patisserieId, String mail, int local, int service, int noteprix, int noteproduit, int decor) {
        this.id = id;
        this.mail = mail;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
        this.patisserieId = patisserieId;
    }

    public Evaluation(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

 

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getNoteprix() {
        return noteprix;
    }

    public void setNoteprix(int noteprix) {
        this.noteprix = noteprix;
    }

    public int getNoteproduit() {
        return noteproduit;
    }

    public void setNoteproduit(int noteproduit) {
        this.noteproduit = noteproduit;
    }

    public int getDecor() {
        return decor;
    }

    public void setDecor(int decor) {
        this.decor = decor;
    }

    public Patisserie getPatisserieId() {
        return patisserieId;
    }

    public void setPatisserieId(Patisserie patisserieId) {
        this.patisserieId = patisserieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Evaluation(Integer id, int local, int service, int noteprix, int noteproduit, int decor, Patisserie patisserieId) {
        this.id = id;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
        this.patisserieId = patisserieId;
    }

    @Override
    public String toString() {
        return patisserieId.getNom();
    }
    
}
