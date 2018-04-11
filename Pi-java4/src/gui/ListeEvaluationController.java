/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.DataSource;
import entities.Evaluation;
import entities.Patisserie;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import service.EvaluationService;


/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class ListeEvaluationController implements Initializable {

    @FXML
    private TableView<Evaluation> tab;
    @FXML
    private TableColumn<Evaluation, String> nompatis;
    @FXML
    private TableColumn<Evaluation, String> mail;
    EvaluationService serveur = new EvaluationService();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
     ObservableList<Evaluation> data = FXCollections.observableArrayList();
    @FXML
    private TextField filterInput;
    @FXML
    private MenuBar fileMenu;
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
    private Text liste;
     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          viewAll();
          ScaleTransition transition = new ScaleTransition(Duration.seconds(4), liste );
        
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
        // TODO
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
//       filterInput.textProperty().addListener(new ChangeListener() {
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                filterList((String) oldValue, (String) newValue);
//               tab.refresh();
//            }
//        }); 
//       filterInput.textProperty().addListener(new ChangeListener() {
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                filterList((String) oldValue, (String) newValue);
//               tab.refresh();
//            }
//        }); 
    }
    
//     public void filterList(String oldValue, String newValue) {
//        ObservableList<Evaluation> filteredList = FXCollections.observableArrayList();
//        EvaluationService evv=new EvaluationService();
//        
//       if(filterInput ==  null || (newValue.length() < oldValue.length()) || newValue == null) {
//         evv.getAll();
//           tab.setItems(data);
//            tab.refresh();
//          tab.setItems(filteredList);
//        }
//        else {
//            newValue = newValue.toUpperCase();
//            for(Evaluation ev : tab.getItems()) {
//                String filterMail = ev.getMail();
//                
//                if(filterMail.toUpperCase().contains(newValue)) {
//                    filteredList.add(ev);
//                }
//            }
//            tab.setItems(data);
//            tab.setItems(filteredList);
//            tab.refresh();
//        }
//   }
    @FXML
    private void retour(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource("InterfaceResponsable.fxml"));
        } catch (IOException e) {
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
    }

    private void viewAll() {
       EvaluationService serveurr = new EvaluationService();

nompatis.setCellValueFactory(new Callback<CellDataFeatures<Evaluation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Evaluation, String> param) {
                return new SimpleStringProperty(param.getValue().getPatisserieId().getNom().toString());
            }
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

  

    @FXML
    private void handleSave(ActionEvent event) {
         Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer liste des évaluation");
        
//        fileChooser.setInitialDirectory(new File(System.getProperty("C:\\Users\\Anouar\\Documents\\NetBeansProjects\\anwarpi\\src")));
//        if(data.isEmpty()) {
//            secondaryStage.initOwner(this.fileMenu.getScene().getWindow());
//            Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "table vide", ButtonType.OK);
//            emptyTableAlert.setContentText("fichier invalide");
//            emptyTableAlert.initModality(Modality.APPLICATION_MODAL);
//            emptyTableAlert.initOwner(this.fileMenu.getScene().getWindow());
//            emptyTableAlert.showAndWait();
//            if(emptyTableAlert.getResult() == ButtonType.OK) {
//                emptyTableAlert.close();
//            }
//        }
//        else {
            File file = fileChooser.showSaveDialog(secondaryStage);
            if(file != null) {
                saveFile(tab.getItems(), file);
//            }
        }
    }
    public void saveFile(ObservableList<Evaluation> observableEvaluationsList, File file) {
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

            for(Evaluation students : observableEvaluationsList) {
                outWriter.write("nom patisserie"+students.getPatisserieId().getNom()+"Mail"+students.getMail()+"Note local"+students.getLocal()+"Note Produit"+students.getNoteproduit());
                outWriter.newLine();
            }
            System.out.println("Liste Evaluation");
            outWriter.close();
        } catch (IOException e) {
            
        }
    }
    

    @FXML
    private void closeApp(ActionEvent event) {
         Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm", ButtonType.OK, ButtonType.CANCEL);
        Stage stage = (Stage) fileMenu.getScene().getWindow();
        exitAlert.setContentText("Vous ete sur?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.initOwner(stage);
        exitAlert.showAndWait();

        if(exitAlert.getResult() == ButtonType.OK) {
            Platform.exit();
        }
        else {
            exitAlert.close();
        }
    }

    @FXML
    private void filterList(KeyEvent event) throws SQLException {
         String choix = "mail";
        EvaluationService s = new EvaluationService();
        if (choix.equals("mail")) {

            if (filterInput.getText() == null) {
                viewAll();
            } else {
                
                data.clear();
                String sql = "SELECT * FROM `evaluation` WHERE mail LIKE '%" + filterInput.getText() + "%' ";
                PreparedStatement statement = conn.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    s.getPatisseriebyId(rs.getInt(2));
                
                    data.add(new Evaluation(rs.getInt(1),s.getPatisseriebyId(rs.getInt(2)),
                        rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
                     tab.setItems(data);
                    System.out.println(data);
                }


            }

        }
//        EvaluationService ss = new EvaluationService();
//        tab.setItems(ss.getAllBynom(filterInput.getText()));
//        tab.refresh();
    }

    @FXML
    private void trilocal(ActionEvent event) throws SQLException {
         EvaluationService service = new  EvaluationService();
        ObservableList<Evaluation> items = FXCollections.observableArrayList(service.Trienotelocal());
            tab.setItems(items);
    }

    @FXML
    private void triservic(ActionEvent event) throws SQLException {
          EvaluationService service = new  EvaluationService();
        ObservableList<Evaluation> items = FXCollections.observableArrayList(service.Tritriservic());
            tab.setItems(items);
    }

    @FXML
    private void triprix(ActionEvent event) throws SQLException {
          EvaluationService service = new  EvaluationService();
        ObservableList<Evaluation> items = FXCollections.observableArrayList(service.Tritriprix());
            tab.setItems(items);
    }

    @FXML
    private void triprd(ActionEvent event) throws SQLException {
          EvaluationService service = new  EvaluationService();
        ObservableList<Evaluation> items = FXCollections.observableArrayList(service.Tritriprd());
            tab.setItems(items);
    }

    
    
}
