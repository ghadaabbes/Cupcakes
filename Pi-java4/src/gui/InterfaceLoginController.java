/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import entities.BCrypt;
import entities.User;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import service.UserService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceLoginController implements Initializable {

    @FXML
    private ImageView Background;
    @FXML
    private AnchorPane loginPannel;
    @FXML
    private TextField username;
    @FXML
    private PasswordField Mdp;
    @FXML
    private Button BtnLogin;
    @FXML
    private Hyperlink linkToCreateProfil;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane ancor;
    @FXML
    private Text label;
    @FXML
    private Text msg;
    @FXML
    private ImageView btnClose;
    public static User user;
    
    
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           ScaleTransition transition = new ScaleTransition(Duration.seconds(4), logo);
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
        
                 

    }    

    @FXML
    private void authentifier(MouseEvent event)  throws SQLException, IOException {
        
        UserService us = new UserService();
        
      
         User user = us.UserByLogin(username.getText());
          System.out.println( user);
          System.out.println( Mdp.getText());
         
         
         if (us.findByLogin(username.getText()) && BCrypt.checkpw(Mdp.getText(), user.getPassword())) {
            System.out.println(1);
            
            if (us.Getrole(username.getText()).equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(username.getText()));
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                ancor.getScene().setRoot(root);
                

            } else if (us.Getrole(username.getText()).equals("a:1:{i:0;s:11:\"ROLE_CLIENT\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(username.getText()));
               //Session session = new Session();
               //session.SetLoggedUser(login.getText());
                System.out.println(Session.LoggedUser);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));

                Parent root = loader.load();

                label.getScene().setRoot(root);
                InterfaceLoginController.user = user;

            } else if (us.Getrole(username.getText()).equals("a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(username.getText()));
               //Session session = new Session();
               //session.SetLoggedUser(login.getText());
                System.out.println(Session.LoggedUser);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));

                Parent root = loader.load();

                label.getScene().setRoot(root);

            } 
        }
         else{
        msg.setText("Ce Compte n'existe pas..Vérifier vos données!");
         }
    }

    @FXML
    private void CloseWindow(MouseEvent event) {
         Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
}
