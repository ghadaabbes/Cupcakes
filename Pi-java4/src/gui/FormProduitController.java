/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.CategorieService;
import service.PatisserieService;
import service.ProduitService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class FormProduitController implements Initializable {

    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tprix;
    @FXML
    private TextField tstock;
    @FXML
    private Button btnimg;
    @FXML
    private ImageView img;
    @FXML
    private ComboBox<String> combo;
        private ObservableList<String> categ = FXCollections.observableArrayList();
    @FXML
    private Button btn0;
       String imageFile;
     ProduitService Ps = new ProduitService();

    @FXML
    private AnchorPane anco;
    @FXML
    private Label LabelAlert;
    @FXML
    private Label AlertPrix;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
                
              CategorieService Cs= new CategorieService();
                //get string from db,whichever way 
                List<Categorie> pats=Ps.findByUser(Session.LoggedUser.getId());
                List<String>nomsPats=new ArrayList<>();
                pats.forEach(p->{
                    categ.add (p.getNom());
                        });

       // combo.setItems(null);
        combo.setItems(categ);


    }    

    @FXML
    private void acceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                    Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void uploadimage(ActionEvent event) throws MalformedURLException {
          FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
          
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);

            img.setImage(image);
            
        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void btnadd(ActionEvent event) throws IOException {
               LabelAlert.setText("");
         AlertPrix.setText("");
         int test=0;
         // Get current value

CategorieService cs = new CategorieService();
      
      Produit P1= new Produit();
     
       if(valide(tnom.getText())){
        P1.setNom(tnom.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
       
       if(validePrix(tprix.getText())){
      P1.setPrix(Double.valueOf(tprix.getText()));}
      else {
             test++; 
         // LabelAlert.setText("Veuillez Remplir Tout les champs !");
            AlertPrix.setText("prix doit etre superieur à 0");
         }
      
      
    
       if(valide(tstock.getText())){
        P1.setStock(tstock.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
       
       P1.setCategorie(Session.iCategorieService.findByNom(String.valueOf(combo.getValue())));
     
   
      
      
      P1.setNomImage(imageFile);
  if(test==0 && "".equals(AlertPrix.getText()) ){
         
       //   System.out.println("ajoute");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Confirmer l'ajout de votre Produit!");

            Optional<ButtonType> result = alert.showAndWait(); 

            if (result.get() == ButtonType.OK )/*{ if( Ps.findByUser(Session.LoggedUser) != null )*/ {
               
//            alert.setTitle("");
//            alert.setHeaderText("Vous possedez deja une patisserie");
//         
//            } else {


                System.out.println("equals");
               Ps.add(P1);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceProd.fxml"));
                Parent root = loader.load();
             //  anco.getScene().setRoot(root); 
               
                    Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();} }
            else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Veuillez Remplir tous les champs afin d'ajouter votre produit");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("ok");
            }
       } 

    }
    
    
    private boolean validePrix(String a){
    boolean v =false ;
    try {
     Integer.parseInt(a);
     if (Integer.parseInt(a) >0){
       v=true;
      }
    } catch (NumberFormatException e) {
       v=false;
       System.out.println("Wrong number");
    }
    return v ; 
}
  
    private boolean valide(String s){
    boolean v =true ;
    if ( "".equals(s))
        v= false ;
    return v ; 
}
    
    private void ControlPrix(MouseEvent event) {
          if(validePrix(tprix.getText())){
             AlertPrix.setText("");
        }else {
              
          //  LabelAlert.setText("Veuillez Remplir Tout les champs !");
            AlertPrix.setText("Prix doit etre sup à 0");
         }
    }

 
    
}
