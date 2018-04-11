/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.CategorieService;
import service.ProduitService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class EspaceCategController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private Button btn0;
    @FXML
    private TableView<Categorie> Table;

    @FXML
    private TableColumn<Categorie, String> nom;
    @FXML
    private TableColumn<Categorie, String> pat;
        ObservableList<Categorie> Liste_MesCategories = FXCollections.observableArrayList();
    @FXML
    private Text username;
    @FXML
    private TableColumn<Categorie, Integer> idcateg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(Session.LoggedUser.getUsername());
        // TODO
              Liste_MesCategories = FXCollections.observableArrayList(Session.iCategorieService.getByUser(Session.LoggedUser.getId()));
        Table.setItems(Liste_MesCategories);
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        pat.setCellValueFactory((TableColumn.CellDataFeatures<Categorie, String> param) -> new SimpleStringProperty(param.getValue().getPatisserie().getNom()));
       idcateg.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        idcateg.cellFactoryProperty();
    }    

    @FXML
    private void Acceuil(MouseEvent event) throws IOException {
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

    @FXML
    private void addcateg(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FormCateg.fxml"));
       
             Parent root = loader.load();
            Scene scene = new Scene(root);
           
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }


    @FXML
    private void Delete(MouseEvent event) throws IOException {
                                 CategorieService t2 = new CategorieService();
         if (!Table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer cette categorie");
            alert.setHeaderText("Etes vous sur de vouloir supprimer cette categorie : " + Table.getSelectionModel().getSelectedItem().getNom() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           Categorie selectedP = Table.getSelectionModel().getSelectedItem();
                System.out.println(selectedP);
              Session.iCategorieService.remove(selectedP.getId_Categorie());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceCateg.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
            }
        }
    }

    @FXML
    private void btnDelete(MouseDragEvent event) {
    }
    
}
