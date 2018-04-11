/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entities.Ligne_Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entities.Produit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.Session;
/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class PanierController implements Initializable {

    @FXML
    private ListView<VBox> panier;
    @FXML
    private Label totalProduit;
    @FXML
    private JFXButton continuer;
    @FXML
    private JFXButton validerCommande;
    @FXML
    private Label nombre;
    @FXML
    private AnchorPane anco;
    @FXML
    private Button goToAcceuil;
   
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
                    afficherPanier();
    }   
    public void afficherPanier()
    {
        ObservableList<Produit>list=FXCollections.observableArrayList();
        
        for(Produit p: InterfaceShopController.produit)
        {
            FileInputStream input = null;
            try {
                list.add(p);
                TextField tf = new TextField("1");
                Button supp = new Button("supprimer");
               
                p.setQuantite(1);
                 InterfaceShopController.produit.get(InterfaceShopController.produit.indexOf(p)).setQuantite(1);
                HBox hbox = new HBox();                
                input = new FileInputStream(p.getNomImage());
                Image imge = SwingFXUtils.toFXImage(ImageIO.read(input), null);
                ImageView im= new ImageView();            
                im.setImage(imge);
                im.setFitHeight(100);
                im.setFitWidth(100);
                double prix=0f;
               if(tf.getText()!=null)
               {
                 prix= p.getPrix()*Float.parseFloat(tf.getText());
               }
             
               supp.setOnMouseClicked((event) -> {
                   InterfaceShopController.produit.remove(p);
                    try {
                        paniershow(event);
                    } catch (SQLException ex) {
                        Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               });
               hbox.getChildren().add(im);
               hbox.getChildren().add(new Label(p.getNom()));
               hbox.getChildren().add(new Label(Double.toString(p.getPrix())));
               hbox.getChildren().add(tf);
               hbox.getChildren().add(new Label(Double.toString(prix)));
               hbox.getChildren().add(supp);
               VBox b = new VBox(hbox);
                panier.getItems().add(b);
                tf.setOnKeyReleased((event)->{
                      double prixp=0f;
                  try
                  {
                   
                     prixp= p.getPrix()*Float.parseFloat(tf.getText());
                     int index = InterfaceShopController.produit.indexOf(p);
                      System.out.println("in"+index);
                      p.setPrix(prixp);
                       p.setQuantite(Integer.parseInt(tf.getText()));
                
                     InterfaceShopController.produit.get(index).setPrix(prixp);
                     InterfaceShopController.produit.get(index).setQuantite(p.getQuantite());
                      System.out.println(InterfaceShopController.produit);
                     hbox.getChildren().set(4,new Label(Double.toString(prixp)));
                     Float total = calculTotal(InterfaceShopController.produit);
                     totalProduit.setText(total.toString());
                    
                      
                  }
                  catch(NumberFormatException ex)
                  {
                      System.out.println("");
                  }
                
                   
                });
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
         Float total = calculTotal(InterfaceShopController.produit);
         totalProduit.setText(total.toString());
        nombre.setText(Integer.toString(InterfaceShopController.produit.size()));
    }
    public float calculTotal(List<Produit> prod)
    {
       float total=0f; 
     for(Produit p: prod)
    {  
       total+=p.getPrix();   
    }
      return total;
    }
    
    @FXML
    private void adresseshow(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheadresse.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    
    private void paniershow(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Lepanier.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    @FXML
    private void achatshow(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceShop.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToAcceuil(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    
}
