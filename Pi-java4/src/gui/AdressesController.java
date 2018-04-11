/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import entities.User;
import entities.Utilisateurs_Adresses;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.UtilisateursService;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class AdressesController implements Initializable {
    public static String choixAddr;
    public static Utilisateurs_Adresses adress;

    @FXML
    private JFXButton poursuivreC;
    private VBox adresses;
    private JFXTextField nom;
    private JFXTextField prenom;
    private JFXTextField telephone;
    private JFXTextField adresse;
    private JFXTextField cp;
    private JFXTextField pays;
    private JFXTextField ville;
    private JFXTextField complement;
    @FXML
    private JFXButton ajoutadresse;
    private VBox utilisateuradresse;
    @FXML
    private VBox utilisateuradresse1;
    @FXML
    private Label nombre;
    @FXML
    private AnchorPane anco;
    
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficheAdresse();
        
    }    
    
    public void afficheAdresse()
    {
        utilisateuradresse = new VBox();
       
        nombre.setText(Integer.toString(InterfaceShopController.produit.size()));
        User u1 = new User();
        List<Utilisateurs_Adresses> ua1 = new ArrayList<>();
        u1=  InterfaceLoginController.user;
        System.out.println("usr"+u1);
        UtilisateursService u = new UtilisateursService();
        ua1 = u.GetByUsersId(u1);
        ToggleGroup toggle = new ToggleGroup();
        for (Utilisateurs_Adresses addr : ua1) 
        {
            UtilisateursService ui = new UtilisateursService();
            JFXRadioButton btn = new JFXRadioButton(addr.affichA());
             Button bou = new Button("supprimer adresse");
             bou.setOnMouseClicked((MouseEvent event) -> {
              ui.remove(addr.getId());
                try {
                    adressshow(event);
                } catch (SQLException ex) {
                    Logger.getLogger(AdressesController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AdressesController.class.getName()).log(Level.SEVERE, null, ex);
                }
             });
            btn.setToggleGroup(toggle);
           btn.setOnMouseClicked((MouseEvent event) -> {
               if(btn.isSelected())
               {
                   poursuivreC.setDisable(false);
                   choixAddr=btn.getText();
                   adress = addr;
               }
            });
           
            utilisateuradresse.getChildren().add(btn);
            utilisateuradresse1.getChildren().add(btn);
             utilisateuradresse.getChildren().add(bou);
            utilisateuradresse1.getChildren().add(bou);
        }
        System.out.println("add"+utilisateuradresse.getChildren().toString());
    
    }
    
    @FXML
    
     private void ajoutshow(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouteradresse.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
     
     private void adressshow(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheadresse.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
     private void validerAdresse(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("recapitulatif.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    
     
            
}
