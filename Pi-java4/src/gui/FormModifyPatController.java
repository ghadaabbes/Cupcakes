/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Patisserie;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.PatisserieService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class FormModifyPatController implements Initializable {

    @FXML
    private TextField tnom;
    @FXML
    private TextField tadresse;
    @FXML
    private TextField tdescription;
    @FXML
    private Button btnimg;
    @FXML
    private ImageView img;
    @FXML
    private Button btnadd;
    @FXML
    private ImageView acceuil;
    @FXML
    private Text emptyimageName;
    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView close;
String imageFile;
//    @FXML
//    private Text emptyNote;
    @FXML
    private Text username;
    @FXML
    private Text emptyIdpat;
    @FXML
    private Text emptyNote;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     username.setText(Session.LoggedUser.getUsername());
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
    private void addpat(ActionEvent event) {
        PatisserieService Rs1 = new PatisserieService();
        Patisserie R1 =  new Patisserie();
        
         
        System.out.println(tnom.getText());
         R1.setNom(tnom.getText());
          R1.setAdresse(tadresse.getText());
           R1.setDescription(tdescription.getText());
           
        R1.setNomImage(emptyimageName.getText());
       // R1.setNote(Integer.valueOf(emptyNote.getText()));
        R1.setIdPatisserie(Integer.valueOf(emptyIdpat.getText()));
       
    
         R1.setUser(Session.LoggedUser);
        
            System.out.println(R1);
            
            Rs1.update(R1); 
            System.out.println("success");
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Patisserie Modifiée avec succés ");
            alert.setHeaderText(null);
           
      
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           
                
               Stage stage = (Stage)
              close.getScene().getWindow();
    // do what you have to do
    stage.close();
           
        }
    }

    @FXML
    private void acceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

     void initData(Patisserie r) {
              System.out.println(r.getIdPatisserie());
              emptyIdpat.setText(String.valueOf(r.getIdPatisserie()));
                tnom.setText(r.getNom());
                System.out.println(tnom.getText());
                tadresse.setText(r.getAdresse());
                
                tdescription.setText(r.getDescription());
               emptyimageName.setText(r.getNomImage());
              
              //emptyNote.setText(String.valueOf(r.getNote()));
                
     }
  
    @FXML
    private void close(MouseEvent event) {
              Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
 
}
