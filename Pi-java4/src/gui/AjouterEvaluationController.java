/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.DataSource;
import entities.Evaluation;
import entities.Patisserie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.EvaluationService;
import service.SendMail;
import service.ServicePatisseries;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class AjouterEvaluationController implements Initializable {
    EvaluationService es=new EvaluationService();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;

    @FXML
    private ComboBox<Patisserie> patis;
    private TextField mail;
    @FXML
    private Text local;
    @FXML
    private ComboBox<Integer> comloc;
    @FXML
    private Text service;
    @FXML
    private Text noteprd;
    @FXML
    private ComboBox<Integer> comserv;
    @FXML
    private ComboBox<Integer> compri;
    @FXML
    private ComboBox<Integer> comprd;
    @FXML
    private ComboBox<Integer> comdec;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServicePatisseries s=new ServicePatisseries();
        patis.getItems().addAll(s.getAll());
         ScaleTransition transition = new ScaleTransition(Duration.seconds(4), logo);
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
         comloc.getItems().removeAll(comloc.getItems());
    comloc.getItems().addAll(0,1,2,3,4,5);

     comserv.getItems().removeAll(comserv.getItems());
    comserv.getItems().addAll(0,1,2,3,4,5);
 
     compri.getItems().removeAll(compri.getItems());
    compri.getItems().addAll(0,1,2,3,4,5);

     comprd.getItems().removeAll(comprd.getItems());
    comprd.getItems().addAll(0,1,2,3,4,5);

     comdec.getItems().removeAll(comdec.getItems());
    comdec.getItems().addAll(0,1,2,3,4,5);


    
    
    
    }    
    

    
    @FXML
    private void patis(ActionEvent event) throws SQLException {
          boolean test = false;
        String message = "";

//        if (mail.getText().length() == 0) {
//            test = true;
//            message = "Champs mail obligatoire";
//        }
//          String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
//                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"; 
//        if(!mail.getText().equals(masque) ) { 
//            
//            
//                test = true;
//                message = "Champs mail incorrecte"; 
//            
//}
       
        if (test) {
            showMessage(message);
        }
       else {
        Patisserie patisserieId = patis.getSelectionModel().getSelectedItem();

        int local= comloc.getSelectionModel().getSelectedItem();
        int service= comserv.getSelectionModel().getSelectedItem();
        int prix= compri.getSelectionModel().getSelectedItem();
        int produi= comprd.getSelectionModel().getSelectedItem();
        int decor= comdec.getSelectionModel().getSelectedItem();
        String maill=Session.LoggedUser.getEmail();
        Evaluation e = new Evaluation( patisserieId,maill, local, service, prix, produi, decor);
        
        es.createEvaluation(e);
        
SendMail sm=new SendMail(maill, "Confirmation", "Votre evaluation a été envoyée avec succés!!!");
    }
    }

    @FXML
    private void Menu(ActionEvent event) {
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

    private void showMessage(String message) {
 Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(message);
        alert.show();    }

    @FXML
    private void handleClearButtonClick(ActionEvent event) {
        mail.clear();
        
      
    }
    
    
}

