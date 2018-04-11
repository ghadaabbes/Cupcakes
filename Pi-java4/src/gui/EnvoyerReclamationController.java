/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.Patisserie;

import service.ServicePatisseries;

import utils.DataSource;
import entities.Reclamation;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javax.swing.event.ChangeEvent;
import service.ReclamationService;
import service.SendMail;


/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class EnvoyerReclamationController implements Initializable {
    
    ReclamationService rse=new ReclamationService();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    


    @FXML
    private TextField mail;
    @FXML
    private TextArea desc;
    @FXML
    private Button envo;
    @FXML
    private ComboBox<Patisserie> combobox;
    @FXML
    private ImageView logo;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicePatisseries s=new ServicePatisseries();
        combobox.getItems().addAll(s.getAll());
        ScaleTransition transition = new ScaleTransition(Duration.seconds(4), logo);
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
//       
         ReclamationService rse=new ReclamationService();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt = null;
    ResultSet rs; 
       
           
           
        
    }    

    @FXML
    private void envoyer(ActionEvent event) throws SQLException {
         boolean test = false;
        String message = "";

        if (mail.getText().length() == 0) {
            test = true;
            message = "Champs mail obligatoire";
        }
//      String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
//                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"; 
//        if(!mail.getText().equals(masque) ) { 
//            
//            
//                test = true;
//                message = "Champs mail incorrecte"; 
//            
//}
        if (desc.getText().length() == 0) {
            test = true;
            message = "Champs description obligatoire";
        }
        if (test) {
            showMessage(message);
        }
       else {
         
           Patisserie patisserieId = combobox.getSelectionModel().getSelectedItem();
        Reclamation rec=new Reclamation(patisserieId,mail.getText(), desc.getText());
        rse.createReclamation(rec);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
     SendMail sm=new SendMail(mail.getText(), "Confirmation", "Votre Reclamation a été envoyée avec succés!!");
    }
        
    }

    @FXML
    private void selectPatisserie(ActionEvent event) {
       
    }
    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(message);
        alert.show();
    }

    @FXML
    private void retour(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource("InterfaceClient.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
    }

    @FXML
    private void handleClearButtonClick(ActionEvent event) {
         mail.clear();
        desc.clear();
    }
    
}
