/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.CategorieService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class FormModifyProdController implements Initializable {

    @FXML
    private AnchorPane anco;
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
    private ComboBox<Integer> combo;
    @FXML
    private Button btn0;
    @FXML
    private Label LabelAlert;
    @FXML
    private Label AlertPrix;
    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    String imageFile;
    @FXML
    private Text emptyIdproduit;
    @FXML
    private Text emptyimageName;
     
     ProduitService Ps = new ProduitService();
 private ObservableList<Integer> categ= FXCollections.observableArrayList();
    @FXML
    private ImageView close;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
 String dbUsername = "root";
        String dbPassword = "";
        String dbURL = "jdbc:mysql://localhost:3306/pibase";
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
      
            // Execute query and store result in a resultset
            //SELECT nom FROM categorie c JOIN patisserie p  WHERE p.user=Session.getLoggedUser();
           ResultSet rs = conn.createStatement().executeQuery("SELECT id_Categorie FROM categorie ");
            while (rs.next()) {
                //get string from db,whichever way 
                categ.add(rs.getInt("id_Categorie"));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }

        combo.setItems(null);
        combo.setItems(categ);

        // TODO
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
    private void btnadd(ActionEvent event) {
           ProduitService Ps = new ProduitService();
           CategorieService cs = new CategorieService();
           Produit P1= new Produit();
           
             P1.setIdProduit(Integer.valueOf(emptyIdproduit.getText()));
             P1.setNom(tnom.getText());
             P1.setPrix(Double.valueOf(tprix.getText()));
             P1.setStock(tstock.getText());
            P1.setCategorie(cs.findById(combo.getValue()));
             P1.setNomImage(emptyimageName.getText());
             
              Ps.update(P1); 
              
               System.out.println("success");
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Produit Modifiée ");
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

    @FXML
    private void logout(MouseEvent event) throws IOException {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    
    
         void initData(Produit p) {
              emptyIdproduit.setText(String.valueOf(p.getIdProduit()));
              tnom.setText(p.getNom());
              tprix.setText(String.valueOf(p.getPrix()));
              tstock.setText(p.getStock());
              combo.setValue(p.getCategorie().getId_Categorie());
              emptyimageName.setText(p.getNomImage());
   
              
                
     }

    @FXML
    private void close(MouseEvent event) {
    }
}
