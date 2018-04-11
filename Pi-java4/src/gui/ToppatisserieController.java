/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.DataSource;
import entities.Evaluation;
import entities.Patisserie;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.eclipse.persistence.jpa.jpql.parser.Expression;
import service.EvaluationService;
import service.ServicePatisseries;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class ToppatisserieController implements Initializable {

    @FXML
    private TableColumn<Patisserie, String> nompatis;
    @FXML
    private TableColumn<Patisserie,BigDecimal> note;
    @FXML
    private Button menu;
    @FXML
    private TableView<Patisserie> tab;
    ServicePatisseries service = new ServicePatisseries();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
     ObservableList<Evaluation> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Patisserie, Integer> id;
    @FXML
    private Text top;
    @FXML
    private ImageView logo;
    @FXML
    private Button showYoutube;
    @FXML
    private TableColumn<Patisserie, String> desc;
    @FXML
    private TableColumn<Patisserie, String> adress;
    @FXML
    private Text nott;
    @FXML
    private Text name;
    @FXML
    private Text adrr;
    @FXML
    private Text descrp;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         viewAll();
        // TODO
       
         ScaleTransition transition = new ScaleTransition(Duration.seconds(4), logo );
        
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
          
        
           transition = new ScaleTransition(Duration.seconds(4), top);
           transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
        transition = new ScaleTransition(Duration.seconds(4), name);
           transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
//        
       
        
    }    

    @FXML
    private void Menu(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource("home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
    }

    private void viewAll() {
        ServicePatisseries service = new ServicePatisseries();
         nompatis.setCellValueFactory(new PropertyValueFactory<Patisserie,String>("nom"));
         note.setCellValueFactory(new PropertyValueFactory<Patisserie,BigDecimal>("note"));
            adress.setCellValueFactory(new PropertyValueFactory<Patisserie,String>("adresse"));
               desc.setCellValueFactory(new PropertyValueFactory<Patisserie,String>("description"));
         id.setCellValueFactory(new PropertyValueFactory<Patisserie,Integer>("idPatisserie"));
       tab.setItems((ObservableList<Patisserie>) service.getAll());
    }

    @FXML
    private void triepatisserie(ActionEvent event)throws SQLException  {
         ServicePatisseries service = new ServicePatisseries();
        ObservableList<Patisserie> items = FXCollections.observableArrayList(service.TriePatisserie());
            tab.setItems(items);
    }

    @FXML
    private void filt(MouseEvent event) {
       name.setText(tab.getItems().get(tab.getSelectionModel().getSelectedIndex()).getNom());
     
       adrr.setText(tab.getItems().get(tab.getSelectionModel().getSelectedIndex()).getAdresse());
         descrp.setText(tab.getItems().get(tab.getSelectionModel().getSelectedIndex()).getDescription());
    }

    @FXML
    private void showYoutube(ActionEvent event) throws IOException {
       YoutubeFXMLController.nom =name.getText();
          Stage stage = (Stage) name.getScene().getWindow();
      
       Stage window  = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("youtubeFXML.fxml")));
window.setScene(scene);
window.show();
    }
    

 
    
}
