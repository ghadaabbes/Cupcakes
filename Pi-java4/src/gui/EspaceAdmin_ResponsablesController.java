/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Patisserie;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class EspaceAdmin_ResponsablesController implements Initializable {

    @FXML
    private SplitPane Panel;
    @FXML
    private ImageView CHomePage;
    @FXML
    private VBox CBoxAdminHome;
    @FXML
    private VBox CBoxClients;
    @FXML
    private Text Cclients;
    @FXML
    private VBox CBoxResponsables;
    @FXML
    private VBox CBoxProuits;
    @FXML
    private VBox CBoxRecettes;
    @FXML
    private Text Crecettes;
    @FXML
    private VBox CBoxPrmotion;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private Text Admin_Name;
    @FXML
    private ImageView btnClose;
    @FXML
    private TableView<User> TablePatisserie;
    @FXML
    private TableColumn<User, String> NomPat;
    @FXML
    private TableColumn<User, String> ResponsableNomPat;
    @FXML
    private Pane PaneProd;
    @FXML
    private PieChart myPieChart;

    
    ObservableList<User> Liste_Patisserie = FXCollections.observableArrayList();
    @FXML
    private AnchorPane anco;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Admin_Name.setText(Session.LoggedUser.getUsername());
        // initialize patisserie table
        Liste_Patisserie = FXCollections.observableArrayList(Session.iuserService.DisplayAllResponsables());
        TablePatisserie.setItems(Liste_Patisserie);
        NomPat.setCellValueFactory(new PropertyValueFactory<>("username"));
        NomPat.cellFactoryProperty();
        //ici mail
        ResponsableNomPat.setCellValueFactory(new PropertyValueFactory<>("email"));
        ResponsableNomPat.cellFactoryProperty();
        ////////////////////////////
        // Stat //
        buildPieChart();
    }    

   
    @FXML
    private void goToHome(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    

    @FXML
    private void goToClients(MouseEvent event)  throws SQLException, IOException  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Clients.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToResponsables(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Responsables.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToProduits(MouseEvent event)  throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Prod.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToRecettes(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Recettes1.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToPromotion(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Promotion.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToReclamation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Reclamation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToEvaluation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Evaluation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void goToPanier(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeaffichage.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void LogOut(MouseEvent event) throws SQLException, IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }
    @FXML
    private void Close(MouseEvent event) {
           Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

     private void buildPieChart() {
        ObservableList<PieChart.Data> details =
            FXCollections.observableArrayList(
            new PieChart.Data("Admins", Session.iuserService.CountUserByRoles("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")),
            new PieChart.Data("Clients", Session.iuserService.CountUserByRoles("a:1:{i:0;s:11:\"ROLE_CLIENT\";}")),
            new PieChart.Data("Responsables", Session.iuserService.CountUserByRoles("a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}"))
            );
    myPieChart.setData(details);
    myPieChart.setLabelLineLength(10);
    
    }
}
