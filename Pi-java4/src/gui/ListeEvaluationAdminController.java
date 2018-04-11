/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.DataSource;
import entities.Evaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.EvaluationService;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class ListeEvaluationAdminController implements Initializable {

    @FXML
    private TableView<Evaluation> tab;
    @FXML
    private TableColumn<Evaluation, String> nompatis;
    @FXML
    private TableColumn<Evaluation, String> mail;
    @FXML
    private TableColumn<Evaluation, Integer> loc;
    @FXML
    private TableColumn<Evaluation, Integer> serv;
    @FXML
    private TableColumn<Evaluation, Integer> pri;
    @FXML
    private TableColumn<Evaluation, Integer> produit;
    @FXML
    private TableColumn<Evaluation, Integer> decor;
    @FXML
    private TableColumn<Evaluation, Integer> id;
EvaluationService serveur = new EvaluationService();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
     ObservableList<Evaluation> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAll();
         try {
          
            tab.setRowFactory((TableView<Evaluation> tableView) -> {
                final TableRow<Evaluation> row = new TableRow<>();
                final ContextMenu contextMenu = new ContextMenu();
              
                final MenuItem removeMenuItem = new MenuItem("Supprimer");
                
                removeMenuItem.setOnAction((ActionEvent event) -> {
                    supprimer(row.getItem().getId());
                });
              
                contextMenu.getItems().add(removeMenuItem);
                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(contextMenu)
                );
                return row;
            });
        } catch (Exception ex) {
             Logger.getLogger(ListeEvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void menu(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource("InterfaceAdmin.fxml"));
        } catch (IOException e) {
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
    }
      private void viewAll() {
       EvaluationService serveurr = new EvaluationService();
        nompatis.setCellValueFactory((TableColumn.CellDataFeatures<Evaluation, String> param) -> {
           return new SimpleStringProperty(param.getValue().getPatisserieId().getNom());
       });
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
         loc.setCellValueFactory(new PropertyValueFactory<>("local"));
          serv.setCellValueFactory(new PropertyValueFactory<>("service"));
           pri.setCellValueFactory(new PropertyValueFactory<>("noteprix"));
            produit.setCellValueFactory(new PropertyValueFactory<>("noteproduit"));
             decor.setCellValueFactory(new PropertyValueFactory<>("decor"));

       tab.setItems((ObservableList<Evaluation>) serveurr.getAll());
    }
     private void supprimer(int id) {
        try {
 EvaluationService es=new EvaluationService();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation");
            alert.setHeaderText("vous etes sur de supprimer!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
              
               es.delete(tab.getItems().get(tab.getSelectionModel().getFocusedIndex()).getId());
                ObservableList<Evaluation> items = FXCollections.observableArrayList(findEvaluation());
                tab.setItems(items);
                tab.getItems().remove(tab.getSelectionModel().getFocusedIndex());
                       
            }

        } catch (Exception ex) {
            Logger.getLogger(ListeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private List<Evaluation> findEvaluation() throws SQLException {
         EvaluationService es=new EvaluationService();
        return es.getAll();
   }

}
