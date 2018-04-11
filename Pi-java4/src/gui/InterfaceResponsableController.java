/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import utils.Session;

/**
 *
 * @author Siala
 */
public class InterfaceResponsableController implements Initializable  {

    @FXML
    private AnchorPane anco;
    @FXML
    private Button btn0;
    @FXML
    private Button btn01;
    @FXML
    private Button btn011;
    @FXML
    private Text username;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView logo;
    
     /**
     * Initializes the controller class.
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
         
         username.setText(Session.LoggedUser.getUsername());
    }    
  
    @FXML
    private void espacepat (ActionEvent event) throws IOException {
  
       
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EspacePat.fxml"));
       
        //String css = Main.class.getResource("StyleSiwar.css").toExternalForm();
       // scene.getStylesheets().add(css);
             Parent root = loader.load();
            Scene scene = new Scene(root);
           // anco.getScene().setRoot(root);      
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
     //  String css = Main.class.getResource("styleSiwar.css").toExternalForm();
    //    scene.getStylesheets().add(css);
       
}
    
     
    @FXML
    private void espaceprod (ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceProd.fxml"));
       
        //String css = Main.class.getResource("StyleSiwar.css").toExternalForm();
       // scene.getStylesheets().add(css);
            Parent root = loader.load();
            Scene scene = new Scene(root);
           // anco.getScene().setRoot(root);      
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

}
    
     
    @FXML
    private void espacecateg(ActionEvent event) throws IOException {
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceCateg.fxml"));
       
        //String css = Main.class.getResource("StyleSiwar.css").toExternalForm();
       // scene.getStylesheets().add(css);
             Parent root = loader.load();
            Scene scene = new Scene(root);
           // anco.getScene().setRoot(root);      
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
}

    private void logout(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void onClickClose(MouseEvent event) {
                      Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void LogOut(MouseEvent event) throws IOException {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    
}