/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Produit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.ProduitService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class InterfaceShopController implements Initializable {

    @FXML
    private ImageView CHome;
    @FXML
    private ImageView CclientIcon;
    @FXML
    private ImageView CrecetteIcon;
    @FXML
    private ImageView CPatisserieIcon;
    @FXML
    private ImageView CShopIcon;
    @FXML
    private ImageView CPromoIcon;
    @FXML
    private ImageView CReclamationIcon;
    @FXML
    private ImageView CEvaluationIcon;
    @FXML
    private ImageView CPanierIcon;
    @FXML
    private ImageView CLogoutIcon;
    @FXML
    private VBox CBoxHome;
    @FXML
    private ImageView CHomeIcon;
    @FXML
    private Text LabelHome;
    @FXML
    private VBox CBoxClient;
    @FXML
    private Text LabelClient;
    @FXML
    private VBox CBoxRecette;
    @FXML
    private Text LabelRecette;
    @FXML
    private VBox CBoxPatisserie;
    @FXML
    private VBox CBoxShop;
    @FXML
    private VBox CBoxPromo;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private ImageView btnClose;
    @FXML
    private GridPane listeproduits;
    public static List<Produit> produit = new ArrayList<>();
    @FXML
    private Label nombre;
    @FXML
    private AnchorPane anco;
    @FXML
    private Text nbProduits;
//        public static List<Integer> listProduitPanierId = new ArrayList<>();
//
//    public static HashMap<Integer, Integer> HashMapProduitPanier = new HashMap<>();
    
    @FXML
    private ImageView imgRechercheProd;
    
   
    
    List<Produit> listeproduit = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
        // TODO
        
         ProduitService ps = new ProduitService();
          List<Produit> listeproduit = ps.findAll();
          
           
          for (int i = 0; i < listeproduit.size(); i++) {
          
        // Produit pr = new Produit();
       
try {
               FileInputStream input = new FileInputStream("C:/wamp64/www/java_DOC/"+listeproduit.get(i).getNomImage());
               Image img = SwingFXUtils.toFXImage(ImageIO.read(input), null);
               ImageView im= new ImageView();
               Button bout=new Button("ajouter au panier");
            im.setImage(img);
            im.setFitHeight(50);
            im.setFitWidth(50);
             if(InterfaceShopController.produit.contains(listeproduit.get(i)))
              {
                   bout.setDisable(true);
              }
             else
             {
                 bout.setDisable(false);
             }
            GridPane p = new GridPane();
            p.add(im,0,0);
            p.add(new Label(listeproduit.get(i).getNom()+" "+listeproduit.get(i).getPrix()),0,1);
            p.add(bout,0,2);
            listeproduits.add(p,0,i);
            final int j=i;
          
            bout.setOnMouseClicked(((event) -> {
                   try {  
                       
                           Produit prd= new Produit();
                           prd=listeproduit.get(j);
                           prd.setNomImage("C:/wamp64/www/java_DOC/"+listeproduit.get(j).getNomImage());
                                     
                       produit.add(listeproduit.get(j));
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("Lepanier.fxml"));
                       Parent root = loader.load();
                       anco.getScene().setRoot(root);
                   } catch (IOException ex) {
                       Logger.getLogger(InterfaceShopController.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }));

           } catch (FileNotFoundException ex) {
               Logger.getLogger(InterfaceShopController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex ) {
               Logger.getLogger(InterfaceShopController.class.getName()).log(Level.SEVERE, null, ex);
           }
                    }
        
        nombre.setText(Integer.toString(InterfaceShopController.produit.size()));
        
               }
    
       @FXML
    private void GoToHome(MouseEvent event) throws SQLException, IOException{
         
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToClientProfile(MouseEvent event) throws SQLException, IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientProfile.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

     @FXML
    private void GoToRecettes(MouseEvent event) throws SQLException, IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPatisseries(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientPat.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    @FXML
    private void GoToShop(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceShop.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPromo(MouseEvent event) throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePromo.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToReclamation(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToEvaluation(MouseEvent event) throws SQLException, IOException{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceEvaluation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPanier(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Lepanier.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void LogOut(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    @FXML
    private void onMouseClickClose(MouseEvent event) {
                   Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    }    

    
    
    

