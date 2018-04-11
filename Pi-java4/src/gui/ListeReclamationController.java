/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.DataSource;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Anouar
 */

public class ListeReclamationController implements Initializable {

    @FXML
    private TableColumn<Reclamation, String> nompatis;
    @FXML
    private TableColumn<Reclamation, String> desc;
    @FXML
    private TableView<Reclamation> listrec;
    ReclamationService serveur = new ReclamationService();
   DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
     ObservableList<Reclamation> data = FXCollections.observableArrayList();
    @FXML
    private Text list;
    @FXML
    private TableColumn<Reclamation, String> mail;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TextField filterInput;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ScaleTransition transition = new ScaleTransition(Duration.seconds(4), list );
        
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
        try {
            viewAll();
            listrec.setRowFactory(new Callback<TableView<Reclamation>, TableRow<Reclamation>>() {
                @Override
                public TableRow<Reclamation> call(TableView<Reclamation> tableView) {
                    final TableRow<Reclamation> row = new TableRow<>();
                    final ContextMenu contextMenu = new ContextMenu();
                    final MenuItem removeMenuItem = new MenuItem("Supprimer");
                    removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                                   supprimer(row.getItem().getId());

                        }

                    });
                    contextMenu.getItems().add(removeMenuItem);
                     row.contextMenuProperty().bind(
                            Bindings.when(row.emptyProperty())
                                    .then((ContextMenu) null)
                                    .otherwise(contextMenu)
                    );
                     return row;
                }
            
            });
            
        } catch (Exception e) {
        }
        
    }    

    @FXML
    private void retour(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource("InterfaceResponsable.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
    }

    private void viewAll() {
      ReclamationService serveur = new ReclamationService(); 
      nompatis.setCellValueFactory(new Callback<CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Reclamation, String> param) {
                return new SimpleStringProperty(param.getValue().getPatisserieId().getNom().toString());
            }
        });
       mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
      desc.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("description"));
      listrec.setItems((ObservableList<Reclamation>) serveur.getAll());
    }
    private void supprimer(int id) {
        try {
 ReclamationService es=new ReclamationService();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation");
            alert.setHeaderText("vous etes sur de supprimer!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
              
               es.delete(listrec.getItems().get(listrec.getSelectionModel().getFocusedIndex()).getId());
                ObservableList<Reclamation> items = FXCollections.observableArrayList(findReclamation());
                listrec.setItems(items);
                listrec.getItems().remove(listrec.getSelectionModel().getFocusedIndex());
            }

        } catch (Exception ex) {
            Logger.getLogger(ListeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private List<Reclamation> findReclamation() throws SQLException {
         ReclamationService es=new ReclamationService();
        return es.getAll();
   }

    

    @FXML
    private void searchRecord(KeyEvent event) throws SQLException {
        String choix = "mail";
        ReclamationService s = new ReclamationService();
        if (choix.equals("mail")) {

            if (filterInput.getText() == null) {
                viewAll();
            } else {
                
                data.clear();
                String sql = "SELECT * FROM `reclamation` WHERE mail LIKE '%" + filterInput.getText() + "%' ";
                PreparedStatement statement = conn.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                
                
                    data.add(new Reclamation(rs.getInt(1), s.getPatisseriebyId(rs.getInt(2)),
                        rs.getString(3),
                        rs.getString(4))
                       );
                     listrec.setItems(data);
                    System.out.println(data);
                }


            }
        }
    }
}





