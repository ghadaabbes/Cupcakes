/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * 
 *
 * @author Siala
 */
public class Cupcakes1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//             Parent root = FXMLLoader.load(getClass().getResource("envoyerReclamation.fxml")); 
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceLogin.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("InterfaceClient.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root,800,800);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

