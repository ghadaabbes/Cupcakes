/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


//import com.esprit.entities.Produit_;
import entities.Promotion;
import utils.DataSource;
import com.oracle.jrockit.jfr.Producer;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.*;
import gui.InterfaceFxController;
import gui.PromotionClientController;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;
/**
 *
 * @author Ghada
 */
public class ServicePromotion {
    
private static ServicePromotion ppService;

private File file;
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs  ; 
public static ServicePromotion getInstance() throws SQLException {
        if (ppService == null) {
            return ppService = new ServicePromotion();
        }
        return ppService;
    }
    public ServicePromotion() {
        this.cnx = DataSource.getInsatance();
    }

    public void ajouterPromotion(Promotion p)  {
        try {
            String request = "INSERT INTO `promotion`( `patisserie_id`,`produit_id`,`date_debut_promotion`, `date_fin_promotion`, `pourcentage`,`promoimag`,`imagePath` )VALUES( ?,?,?, ?, ?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(request);
           ps.setDate(3, new java.sql.Date((p.getDateDebutPromotion()).getTime()));
            ps.setDate(4, new java.sql.Date((p.getDateFinPromotion()).getTime()));
            ps.setInt(5, p.getPourcentage());
            ps.setInt(2, p.getProduitId().getIdProduit());
            ps.setInt(1, p.getPatisserieId().getIdPatisserie());
           ps.setString(7, p.getImagePath());
           ps.setBlob(6, p.getImage());
            ps.executeUpdate();
            System.out.println("promo ajoute");
        } catch (SQLException ex) {
             Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
// public ObservableList<Object> afficheimagePromotion() throws SQLException, FileNotFoundException {
//     ObservableList<Object> listimag = FXCollections.observableArrayList();
//        rs=stmt.executeQuery("select promoimag from promotion");
//    if (rs.next()){
//    Blob imageData=rs.getBlob("promoimag");
//    if (imageData !=null){
//    File tmpFile=new File ("promoimag");
//    FileOutputStream fos=new FileOutputStream(tmpFile);
//        
//       
//        
//    }
//    listimag.add(imageData.getBytes(1L,(int)imageData.length()));
//    }
//    return listimag;
//}
    public void modifierPromotion(Promotion a) {
        try {
            String req = "UPDATE `promotion` SET  date_debut_promotion=?, date_fin_promotion=?, pourcentage=? WHERE id=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setDate(1, new java.sql.Date((a.getDateDebutPromotion()).getTime() ));
            ps.setDate(2, new java.sql.Date((a.getDateFinPromotion()).getTime()));
            ps.setInt(3, a.getPourcentage());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
            System.out.println("Promotion modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ServicePromotion.class.getName());
        }
    }

    public void supprimerPromotion(Promotion a) {
        
        try {
            String req;
            req = "DELETE  FROM `promotion` WHERE id=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
              ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("Promotion supprimée");
        } catch (SQLException ex) {
            
            Logger.getLogger(ServicePromotion.class.getName());
        }
    }

//    /**
//     *
//     * @param r
//     * @throws SQLException
//     */
//    public void remove(Integer r) throws SQLException  {
//        try {
//            String requete = "delete promotion where id=?";
//            PreparedStatement ps =cnx.getConnection().prepareStatement(requete);
//
//            ps.setInt(1, r);
//
//            ps.executeUpdate();
//            System.out.println("remove sucess");
//        } catch (SQLException ex) {
//           // ex.printStackTrace();
//        }
//        
//    }

//    public void getPromotion (Promotion p )
//    {
//        try {
//            String query = "SELECT `id`, `produit_id`, `patisserie_id`, `image_id`, `date_debut_promotion`, `date_fin_promotion`, `pourcentage` FROM `promotion$";
//            stmt = conn.createStatement();
//            rs =stmt.executeQuery(query);
//            while (rs.next())
//            {
//       
//            }       } catch (SQLException ex) {
//            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     
//    }
    
    public ObservableList<Produit> getProduitPromo() {
       
          ObservableList<Produit> lft = FXCollections.observableArrayList(); 
    
      
        try {
            String sql = "SELECT nom,prix FROM `produit` inner JOIN `promotion` ON promotion.produit_id=produit.idProduit";

            PreparedStatement src = cnx.getConnection().prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);
            while (res.next()) {
               Produit c = new Produit();
                c.setIdProduit(res.getInt(1));
                c.setNom(res.getString(2));
                
                lft.add(c);
            }
        } catch (Exception e) {
            System.out.println("Erreur " + e);
        }
        return lft;  
    }
//    private ObservableList<Promotion> getPromotions() {
//        
//        ObservableList<Promotion> lft = FXCollections.observableArrayList(); 
//    
//      
//        try {
//            String sql = "SELECT * FROM `promotion`";
//            
//
//            PreparedStatement src = cnx.getConnection().prepareStatement(sql);
//            ResultSet res = src.executeQuery(sql);
//            
//            while (res.next() ) {
//                Promotion c = new Promotion();
//
//                   
//                c.setDateFinPromotion(res.getDate(6));
//                c.setPourcentage(res.getInt(7));
//                
//                lft.add(c);
//            }
//        } catch (Exception e) {
//            System.out.println("Erreur " + e);
//        }
//        return lft;
//        
//    }
            public ObservableList<Promotion> getAll() {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            //SELECT * FROM Produit p JOIN categorie c JOIN patisserie pa on p.Categorie_id=c.id_Categorie and pa.user=1
            ResultSet rs = stmt.executeQuery("Select * from promotion");
            //ResultSet rs=stmt.executeQuery("SELECT * FROM promotion pro  JOIN categorie c JOIN patisserie pa Join Produit p on p.Categorie_id=c.id_Categorie and pa.user=1 and p.idProduit=pro.produit_id ");
            while (rs.next()) {
                Produit p=getProduitbyId(rs.getInt(2));
                Integer i=rs.getInt(1);
                String imag=rs.getString(8);
                System.out.println(8);
                Double d=p.getPrix();
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(i+" "+k+""+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
             public ObservableList<Promotion> getAllForResponsable() {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            //SELECT * FROM Produit p JOIN categorie c JOIN patisserie pa on p.Categorie_id=c.id_Categorie and pa.user=1
            //ResultSet rs = stmt.executeQuery("Select * from promotion");
            ResultSet rs=stmt.executeQuery("SELECT * FROM promotion pro  JOIN categorie c JOIN patisserie pa Join Produit p on p.Categorie_id=c.id_Categorie and pa.user=1 and p.idProduit=pro.produit_id ");
            while (rs.next()) {
                Produit p=getProduitbyId(rs.getInt(2));
                Integer i=rs.getInt(1);
                String imag=rs.getString(8);
                System.out.println(8);
                Double d=p.getPrix();
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(i+" "+k+""+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
            public ObservableList<Promotion> getAllBynom(String nom) {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from promotion,produit where promotion.produit_id=produit.idProduit and `nom` LIKE '%" + nom + "%'");
           
            while (rs.next()) {
                
                Produit p=getProduitbyId(rs.getInt(2));
                
                String imag=rs.getString(8);
                Double d=p.getPrix();
                Integer i=rs.getInt(1);
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(null+k+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag));
                        
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
            //SELECT * FROM `forum_sous_categorie` WHERE  `titre` LIKE '%" + nom + "%'"
    public Produit getProduitbyId(int id) {
        Produit  lft= new Produit();
        try {
            String sql = "SELECT * FROM `produit`  WHERE  `idProduit` = "+id;

            PreparedStatement src = cnx.getConnection().prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);

            while (res.next()) {
//                Produit c = new Produit();
                System.out.println(res.getString(2));
//                 c.setIdProduit(res.getInt(1));
//                c.setNom(res.getString(2));
                lft=new Produit(res.getInt(1), res.getString(2), res.getInt(3), null, null);
             
//                lft.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, e);
        }
        return lft;
    } 
 public ObservableList<Categorie> getAllCategorie() {
        ObservableList<Categorie> list= FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from categorie");
            while (rs.next()) {
                
                Integer i=rs.getInt(2);
                String ch=rs.getString(3);
                
               System.out.println(i+" "+ch);
                list.add(new Categorie(i,ch)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ObservableList<Patisserie> getAllPatisserie() {
        ObservableList<Patisserie> list= FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from patisserie");
            while (rs.next()) {
               
                Integer i=rs.getInt(2);
                String ch=rs.getString(3);
                
               System.out.println(i+" "+ch);
                list.add(new Patisserie(i,ch)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }  
    public ObservableList<Promotion> getAll2( Patisserie pat) {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            //SELECT * FROM Produit p JOIN categorie c JOIN patisserie pa on p.Categorie_id=c.id_Categorie and pa.user=1
            ResultSet rs = stmt.executeQuery("SELECT * FROM `promotion` WHERE promotion.patisserie_id="+pat.getIdPatisserie());
            //ResultSet rs=stmt.executeQuery("SELECT * FROM promotion pro  JOIN categorie c JOIN patisserie pa Join Produit p on p.Categorie_id=c.id_Categorie and pa.user=1 and p.idProduit=pro.produit_id ");
            while (rs.next()) {
                Produit p=getProduitbyId(rs.getInt(2));
                Integer i=rs.getInt(1);
                String imag=rs.getString(8);
                System.out.println(8);
                Double d=p.getPrix();
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(i+" "+k+""+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
    public ObservableList<Promotion> getAll3( Categorie cat) {
        ObservableList<Promotion> listpromo = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM promotion INNER JOIN categorie on categorie.id_Categorie="+cat.getIdCategorie());
            while (rs.next()) {
                Produit p=getProduitbyId(rs.getInt(2));
                Integer i=rs.getInt(1);
                String imag=rs.getString(8);
                System.out.println(8);
                Double d=p.getPrix();
                String k=d.toString();
                String ch=p.getNom();
               System.out.println(i+" "+k+""+rs.getDate(5)+ch+""+rs.getDate(6) + " (" + rs.getInt(7) + ")");
                listpromo.add(new Promotion(i,null,p, rs.getDate(5), rs.getDate(6), rs.getInt(7),null,imag)
                        );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listpromo;
    }
    
    
}

