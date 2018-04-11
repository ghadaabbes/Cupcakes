/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.CategorieService;
import service.PatisserieService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class FormCategController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView background;
    @FXML
    private TextField tnom;

    @FXML
    private Button btnadd;
    @FXML

    private ComboBox<String> combo;
   private ObservableList pat = FXCollections.observableArrayList();
CategorieService cs = new CategorieService();

    @FXML
    private Label labelalert;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         labelalert.setText("");
        
              
        
          
     
            // Execute query and store result in a resultset
    //SELECT nom FROM patisserie p WHERE p.user=Session.getLoggedUser()
   
           
          //  while (rs.next()) {
                
              PatisserieService Ps= new PatisserieService();
                //get string from db,whichever way 
                List<Patisserie> pats=Ps.findByUser(Session.LoggedUser.getId());
                List<String>nomsPats=new ArrayList<>();
                pats.forEach(p->{
                    pat.add (p.getNom());
                        });
       //  pat.add (nomsPats);
            
        

        //combo.setItems(null);
        combo.setItems(pat);
       
        // TODO
        // TODO
    }    

    @FXML
    private void addcateg(ActionEvent event) throws IOException {
        PatisserieService Ps= new PatisserieService();
         Categorie c= new Categorie();
         labelalert.setText("");
       int test=0;
     
      // String value = combo.getValue().toString();
     // c.setPatisserie(Session.iCategorieService.findByNom(tnom.getText()));
            //  Ps.getByUser(combo.getValue()));
    
        c.setPatisserie(Session.iPatisserieService.findByNom(String.valueOf(combo.getValue())));
       if(valide(tnom.getText())){
        c.setNom(tnom.getText());
         }else{
             test++;
             labelalert.setText("Veuillez Remplir Tout les champs !");
         }
       
       
       //   System.out.println("ajoute");
       
         if(test==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
            alert.setHeaderText("Confirmer l'ajout de votre Categorie!");
            Optional<ButtonType> result = alert.showAndWait(); 


            if (result.get() == ButtonType.OK )/*{ if( Ps.findByUser(Session.LoggedUser) != null )*/ {
               
//            alert.setTitle("");
//            alert.setHeaderText("Vous possedez deja une patisserie");
//         
//            } else {


                System.out.println("equals");
               cs.add(c);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceCateg.fxml"));
                Parent root = loader.load();
             //  anco.getScene().setRoot(root); 
               
                    Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();}}
            else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Veuillez Remplir tous les champs afin d'ajouter votre categorie");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("ok");
            }
             
           
            
  
   }}
    
    
    private boolean valide(String s){
    boolean v =true ;
    if ( "".equals(s))
        v= false ;
    return v ; 
}
    private void acceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

}
