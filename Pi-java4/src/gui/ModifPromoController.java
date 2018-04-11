/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.Promotion;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServicePromotion;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class ModifPromoController implements Initializable {
 ServicePromotion vi = new ServicePromotion();

    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    @FXML
    private ComboBox<String> idpatisserie;
    @FXML
    private ComboBox<String> idCategorie;
    @FXML
    private ComboBox<String> idProduit;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField pourcentage;
    @FXML
    private Button idPromoMod;
//    private int idPromotion;
    private Promotion promotion= new Promotion();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              
    }

    @FXML
    private void selectCategorie(ActionEvent event) {
    }

    @FXML
    private void selectProduit(ActionEvent event) {
    }

    @FXML
    private void PromoMod(ActionEvent event) {

promotion.setDateDebutPromotion(java.sql.Date.valueOf(date_debut.getValue()));
promotion.setDateFinPromotion(java.sql.Date.valueOf(date_fin.getValue()));
promotion.setPourcentage(Integer.parseInt(pourcentage.getText()));
        ServicePromotion servicePromotion = new ServicePromotion();
        servicePromotion.modifierPromotion(promotion);
        Stage stage = (Stage) idPromoMod.getScene().getWindow();
        stage.close();
    }
    public void myData(Promotion p){
        
        promotion=p;
        
       date_debut.setValue(LocalDate.parse(p.getDateDebutPromotion().toString()));
       date_fin.setValue(LocalDate.parse(p.getDateFinPromotion().toString()));
       pourcentage.setText(String.valueOf(p.getPourcentage()));
        
        
        
        
    }
}
