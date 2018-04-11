/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entities.Commandes;
import entities.Ligne_Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import service.LigneServices;

/**
 *
 * @author beryl kristina
 */
public class DetailsController  implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   /* @FXML
    private AnchorPane an;
    @FXML
    private TableView<Ligne_Commande> list;
    @FXML
    private TableColumn<Ligne_Commande, Integer> id;
    @FXML
    private TableColumn<Ligne_Commande, Date> date;
    @FXML
    private TableColumn<Ligne_Commande, String> produit;
    @FXML
    private TableColumn<Ligne_Commande, Integer> quantite;
    @FXML
    private TableColumn<Ligne_Commande, Float> prix;
    @FXML
    private JFXButton ok;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        detailscom();
        
    
    }
    
     public void detailscom()
    {
    if (!AfficheComandeController.liste.getSelectionModel().isEmpty()){
        LigneServices service = new LigneServices();
        ObservableList<Ligne_Commande> lis = FXCollections.observableArrayList(service.getBycom(list.getSelectionModel().getSelectedItem().getId()));
        list.setItems(lis);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne_Commande, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Ligne_Commande, Date> param) {
                return new SimpleObjectProperty(param.getValue().getCommande().getDate());
            }
        });
        produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne_Commande, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Ligne_Commande, String> param) {
                return new SimpleStringProperty(param.getValue().getProduit().getNom());
            }
        });
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        System.out.println(lis);
        
    }
    }

    @FXML
    private void ok(MouseEvent event) throws SQLException, IOException{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeaffichage.fxml"));
                
                Parent root = loader.load();
                
                an.getScene().setRoot(root);
    }*/
    
}
