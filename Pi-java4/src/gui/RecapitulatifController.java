/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Commandes;
import entities.Ligne_Commande;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaMail.SendEmail;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.CommandesServices;
import service.LigneServices;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class RecapitulatifController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label adress;
    @FXML
    private Label nbarticles;
    @FXML
    private Label prixtotal;
    @FXML
    private AnchorPane anco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        recapitulatif();
    }    
   public void recapitulatif()
           
   {
       PanierController pa = new PanierController();
       nom.setText(InterfaceLoginController.user.getUsername());
       adress.setText(AdressesController.choixAddr);
       nbarticles.setText(Integer.toString(InterfaceShopController.produit.size()));
       prixtotal.setText(Float.toString(pa.calculTotal(InterfaceShopController.produit)));
   }
    @FXML
   public void passerCommande() throws IOException
   {
        PanierController pa = new PanierController();
       CommandesServices cmdServices = new CommandesServices();
       LigneServices ligneS= new LigneServices();
       Date d = new Date();
       Commandes com = new Commandes( InterfaceLoginController.user,d,pa.calculTotal(InterfaceShopController.produit ),AdressesController.adress);
       cmdServices.add(com);
       System.out.println(d.toString());
       for(Produit p: InterfaceShopController.produit )
       {
           
           Commandes cmdes =  cmdServices.findByDate(d);
           Ligne_Commande cmd = new Ligne_Commande( p.getPrix(), p.getQuantite(),cmdes, p);
           ligneS.add(cmd);
       }
       
       String mailFrom = "berylkristina.biedeg@esprit.tn";
        String password = "Allemagne2000";
 
        // message info
        String mailTo = "biedegberyl@gmail.com";
        String subject = "Votre Commande";
        String message = "bonjour! merci de nous avoir fait confiance votre commandes a été enregistre avec succes!!";
         SendEmail send = new SendEmail();
         send.sendMail(mailFrom, password, mailTo, subject, message);
       
               FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
       // Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ajout Avec succes", new ButtonType("OK"));
       
   }
   
}

