/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.org.apache.xpath.internal.operations.Number;
import entities.Produit;
import entities.Promotion;
import entities.Wishlist;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javax.management.Query.lt;
import service.ServicePromotion;
import service.ServiceWishlist;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class WishlistController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
 
       
    @FXML
    private TableView<Wishlist> tblpromo;
    @FXML
    private TableColumn<Promotion, Button> tblClmNom;
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Wishlist, String> nomProduit;
    @FXML
    private TableColumn<Wishlist, Integer> idWishlist;
    @FXML
    private Button btnClose;
    @FXML
    private TableColumn<Wishlist, String> patisserie;
    @FXML
    private TableColumn<Wishlist, Double> prix;
        
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceWishlist w=new ServiceWishlist();
          idWishlist.setCellValueFactory(new PropertyValueFactory<Wishlist, Integer>("id"));
          
//          nomProduit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
//            Button b;
//
//            @Override
//            public ObservableValue<Button> call(TableColumn.CellDataFeatures<Promotion, Button> param) {
//                return new SimpleObjectProperty(param.getValue().getImage2());
//            }
//        });
//tblClmNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
//             @Override
//             public ObservableValue<Button> call(TableColumn.CellDataFeatures<Promotion, Button> param) {
////                 return new SimpleObjectProperty(param.getValue().getImage2());
//if (param.getValue().getProduitId().getWishlistCollection()==param.getValue().getProduitId()){
//    return new SimpleObjectProperty(param.getValue().getImage2());
//             
//         }}});
      nomProduit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Wishlist, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Wishlist, String> param) {
                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
               
                }
            });
      
//      patisserie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Wishlist, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Wishlist, String> param) {
//                return new SimpleStringProperty(param.getValue().getProduitId().getCategorieid().getPatisserieId().getNom());
//                
//                     
//                }
//            });
//      
       prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Wishlist, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Wishlist, Double> param) {

                return new SimpleDoubleProperty(param.getValue().getProduitId().getPrix());

            }
        });
//        tblpromo.setItems(w.getAll(Session.LoggedUser))
tblpromo.setItems(w.getAll2());
 
    }   
 
//    @FXML
//    private void supprimer(ActionEvent event) {
//    }

     @FXML
    private void supprimer(ActionEvent event)  {
 ServiceWishlist w=new ServiceWishlist();
        if (!tblpromo.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Etes-vous sûr de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
               
//                int id=Integer.parseInt(tfSearch.getAccessibleHelp());

                w.supprimerWishlist(tblpromo.getSelectionModel().getSelectedItem());
               
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Veuillez Selectionner une promotion!");
            alert.showAndWait();
        }
        viewAll();
    }
    public void viewAll(){
     ServiceWishlist w=new ServiceWishlist();
     idWishlist.setCellValueFactory(new PropertyValueFactory<Wishlist, Integer>("id"));
//     nomProduit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
//            Button b;
//
//            @Override
//            public ObservableValue<Button> call(TableColumn.CellDataFeatures<Promotion, Button> param) {
//                return new SimpleObjectProperty(param.getValue().getImage2());
//            }
//        });
//      tblClmNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Wishlist, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Wishlist, String> param) {
//                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
//                }
//            });
//        tblpromo.setItems(w.getAll(Session.LoggedUser))
tblpromo.setItems(w.getAll2());
    
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
