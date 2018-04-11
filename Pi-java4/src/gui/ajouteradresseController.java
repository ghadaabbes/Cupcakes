/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateurs_Adresses;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.UtilisateursService;


/**
 *
 * @author beryl kristina
 */
public class ajouteradresseController implements Initializable{

    

     
       @FXML
    private JFXTextField telephone;
      @FXML
    private JFXTextField adresse;
       @FXML
    private JFXTextField cp;
      @FXML
    private JFXTextField pays;
      @FXML
    private JFXTextField ville;
       @FXML
    private JFXTextField complement;
    @FXML
    private AnchorPane anco;
    @FXML
    private JFXButton ajouter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @FXML
     public void ajouterAdresse()
             {
         try {
             
             Utilisateurs_Adresses ua = new Utilisateurs_Adresses();
             ua.setAdresse(adresse.getText());
             ua.setTelephone(Integer.parseInt(telephone.getText()));
             ua.setCp(cp.getText());
             ua.setPays(pays.getText());
             ua.setVille(ville.getText());
             ua.setComplement(complement.getText());
             ua.setUser_id(InterfaceLoginController.user);
             UtilisateursService us = new UtilisateursService();
             us.add(ua);
             
             FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheadresse.fxml"));
             
             Parent root = loader.load();
             
             anco.getScene().setRoot(root);
               } catch (IOException ex) {
             Logger.getLogger(ajouteradresseController.class.getName()).log(Level.SEVERE, null, ex);
                 }

             }
     
     
    
}
