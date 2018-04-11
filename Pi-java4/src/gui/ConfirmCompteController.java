/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class ConfirmCompteController implements Initializable {

    @FXML
    private Button confirm;
    @FXML
    private AnchorPane alert;
    @FXML
    private TextField codeconfirm;
    
    private String validationString;
    private User user;
   String code;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    @FXML
    void confirm(ActionEvent event) throws SQLException, IOException{
       RegisterController reco=new RegisterController();
        System.out.println(reco.result);
       String ch="";
      if(reco.equals(codeconfirm.getText())){
       Alert alert1 = new Alert(Alert.AlertType.ERROR);

                        alert1.setTitle("Congratulations ");
                        alert1.setHeaderText("Code valide! ");
                        alert1.setContentText("Compté activé! ");

                        alert1.showAndWait();
      }else{
      Alert alert1 = new Alert(Alert.AlertType.ERROR);

                        alert1.setTitle("Code non valide");
                        alert1.setHeaderText("Code non valide! ");
                        alert1.setContentText("Code non valide");
                        alert1.showAndWait();
      }
        
    }
    
    public void getString(String s){
    validationString = s;
    System.out.println("S = "+s);
    }
     public void getUser(User user )
     {
         this.user = user;
         
     }
     RegisterController n = new RegisterController();
     public String textCode(){
        if (confirm.isPressed()){
         return codeconfirm.getText();
        
    }
     return null;}
 }

    


