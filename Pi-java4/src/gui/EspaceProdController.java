/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.Categorie;
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
import javafx.stage.StageStyle;
import service.ProduitService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class EspaceProdController implements Initializable {

    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private Button btn0;
    @FXML
    private ImageView btnModify;
    @FXML
    private TableView<Produit> Table;

    @FXML
    private TableColumn<Produit, String> nom;
    @FXML
    private TableColumn<Produit, Double> prix;
    @FXML
    private TableColumn<Produit, String> stock;
    @FXML
    private TableColumn<Produit, String> categ;
    @FXML
    private AnchorPane anco;
    ObservableList<Produit> Liste_MesProduits = FXCollections.observableArrayList();
    @FXML
    private Text username;
    @FXML
    private TableColumn<Produit, Integer> idprod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         username.setText(Session.LoggedUser.getUsername());
        // TODO
         Liste_MesProduits = FXCollections.observableArrayList(Session.iProduitService.getByUser(Session.LoggedUser.getId()));
        Table.setItems(Liste_MesProduits);
       

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        prix.cellFactoryProperty();
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stock.cellFactoryProperty();
        idprod.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        idprod.cellFactoryProperty();
       categ.setCellValueFactory((TableColumn.CellDataFeatures<Produit, String> param) -> new SimpleStringProperty(param.getValue().getCategorie().getNom()));

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
    private void addprod(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormProduit.fxml"));
       
             Parent root = loader.load();
            Scene scene = new Scene(root);
           
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

    @FXML
    private void Modify(MouseEvent event) throws IOException {
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("FormModifyProd.fxml"));

          Stage stage2 = new Stage(StageStyle.TRANSPARENT);
          // scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
          stage2.setScene(
          new Scene((AnchorPane) loader2.load()));
 
        Produit selectedP = Table.getSelectionModel().getSelectedItem();
         // idP.setText(String.valueOf(Session.iPatisserieService.findById(selectedP.getIdPatisserie()));
        //  System.out.println(selectedP);
          
           // System.out.println(selectedP.getIdPatisserie());
        FormModifyProdController controller = 
         loader2.<FormModifyProdController>getController();
         controller.initData( selectedP);
 
         stage2.show();

        // return stage2;
    }

    @FXML
    private void Delete(MouseEvent event) throws IOException {
                         ProduitService t2 = new ProduitService();
         if (!Table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer ce produit");
            alert.setHeaderText("Etes vous sur de vouloir supprimer ce produit : " + Table.getSelectionModel().getSelectedItem().getNom() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           Produit selectedP = Table.getSelectionModel().getSelectedItem();
                System.out.println(selectedP);
              Session.iProduitService.remove(selectedP.getIdProduit());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceProd.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
            }
        }
    }

    @FXML
    private void btnDelete(MouseDragEvent event) {
    }
    
}
