/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  entities;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ghada
 */
@Entity
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findById", query = "SELECT p FROM Promotion p WHERE p.id = :id")
    , @NamedQuery(name = "Promotion.findByDateDebutPromotion", query = "SELECT p FROM Promotion p WHERE p.dateDebutPromotion = :dateDebutPromotion")
    , @NamedQuery(name = "Promotion.findByDateFinPromotion", query = "SELECT p FROM Promotion p WHERE p.dateFinPromotion = :dateFinPromotion")
    , @NamedQuery(name = "Promotion.findByPourcentage", query = "SELECT p FROM Promotion p WHERE p.pourcentage = :pourcentage")})
@SuppressWarnings("ValidAttributes")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_debut_promotion")
    @Temporal(TemporalType.DATE)
    private Date dateDebutPromotion;
    @Basic(optional = false)
    @Column(name = "date_fin_promotion")
    @Temporal(TemporalType.DATE)
    private Date dateFinPromotion;
    @Basic(optional = false)
    @Column(name = "pourcentage")
    private int pourcentage;
    @JoinColumn(name = "patisserie_id", referencedColumnName = "idPatisserie")
    @ManyToOne
    private Patisserie patisserieId;
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    @OneToOne
    private Image imageId;
    @JoinColumn(name = "produit_id", referencedColumnName = "idProduit")
    @ManyToOne
    private Produit produitId;
    public Blob promoimag;
    public String imagePath;
    public Promotion() {
    }

  

//    public Promotion(Patisserie pt2, Produit p1, Date datef, Date datef0, int s, byte[] data) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
public ImageView getImage2() {
        File F1 = new File(imagePath);
        javafx.scene.image.Image image2 = new javafx.scene.image.Image(F1.toURI().toString());

        ImageView image = new ImageView();

        image.setFitWidth(130);
        image.setFitHeight(140);
        image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

        image.setImage(image2);
        image.setLayoutX(45);
        image.setLayoutY(-35);
        return image;
    }
public Blob getImage(){
return promoimag;
}
// public void setImage(Blob image) {
//        this.promoimag = image ;
//    }
public void setImage(Blob image) {
        this.promoimag = (Blob) (Image) promoimag;
    }
    public Promotion(Integer id) {
        this.id = id;
    }

//    public Promotion(Integer id, Date dateDebutPromotion, Date dateFinPromotion, int pourcentage) {
//        this.id = id;
//        this.dateDebutPromotion = dateDebutPromotion;
//        this.dateFinPromotion = dateFinPromotion;
//        this.pourcentage = pourcentage;
//    }
public Promotion( Patisserie patisserieId,Produit produitId,Date dateDebutPromotion, Date dateFinPromotion, int pourcentage,  Blob promoimag, String imagePath) {
        this.produitId=produitId;
        this.patisserieId=patisserieId;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.pourcentage = pourcentage;
        this.imagePath=imagePath;
        this.promoimag=promoimag;
    }
public Promotion( Integer id,Patisserie patisserieId,Produit produitId,Date dateDebutPromotion, Date dateFinPromotion, int pourcentage,  Blob promoimag, String imagePath) {
        this.produitId=produitId;
        this.patisserieId=patisserieId;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.pourcentage = pourcentage;
        this.imagePath=imagePath;
        this.promoimag=promoimag;
        this.id=id;
    }
public Promotion( Patisserie patisserieId,Produit produitId,Date dateDebutPromotion, Date dateFinPromotion, int pourcentage,String imagePath) {
        this.produitId=produitId;
        this.patisserieId=patisserieId;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.pourcentage = pourcentage;
        this.imagePath=imagePath;
        
    }
public Promotion( Integer id,Patisserie patisserieId,Produit produitId,Date dateDebutPromotion, Date dateFinPromotion, int pourcentage) {
        this.produitId=produitId;
        this.patisserieId=patisserieId;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.pourcentage = pourcentage;
        this.id=id;
        
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebutPromotion() {
        return dateDebutPromotion;
    }

    public void setDateDebutPromotion(Date dateDebutPromotion) {
        this.dateDebutPromotion = dateDebutPromotion;
    }

    public Date getDateFinPromotion() {
        return dateFinPromotion;
    }

    public void setDateFinPromotion(Date dateFinPromotion) {
        this.dateFinPromotion = dateFinPromotion;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Patisserie getPatisserieId() {
        return patisserieId;
    }

    public void setPatisserieId(Patisserie patisserieId) {
        this.patisserieId = patisserieId;
    }

    public Image getImageId() {
        return imageId;
    }
   
public String getImagePath() {
        return imagePath;
    }
 public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setImageId(Image imageId) {
        this.imageId = imageId;
    }

    public Produit getProduitId() {
        return produitId;
    }

    public void setProduitId(Produit produitId) {
        this.produitId = produitId;
    }
    public String getNomProduit()
{
    return produitId.getNom();
             
}
//public void SetNomProduit(Promotion p)
//{
//    this.produitId.getNom().equalsIgnoreCase(p.produitId.getNom());
//            
//}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Promotion[ id=" + id + " ]";
    }
    
}
