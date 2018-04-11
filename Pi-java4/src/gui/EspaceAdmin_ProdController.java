/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Patisserie;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
public class EspaceAdmin_ProdController implements Initializable {

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
    private ImageView ALL_Patisseries;
    @FXML
    private TextField recherche_patisseries;
    @FXML
    private ImageView imgRecherchePat;
    @FXML
    private Pane PaneProd;
    @FXML
    private ImageView ALL_prod;
    @FXML
    private TextField recherche_Produit;
    @FXML
    private ImageView imgRechercheProduits;
    @FXML
    private TableView<Patisserie> TablePatisserie;
    @FXML
    private TableColumn<Patisserie, String> NomPat;
    @FXML
    private TableColumn<Patisserie, String> ResponsableNomPat;
    @FXML
    private TableView<Produit> TableauProduits;
    @FXML
    private TableColumn<Produit, String> NomProduit;
    @FXML
    private TableColumn<Produit, Integer> prixProduit;

     ObservableList<Patisserie> Liste_Patisserie = FXCollections.observableArrayList();
     ObservableList<Produit> Liste_MesProduits = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Produit, String> categ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Admin_Name.setText(Session.LoggedUser.getUsername());
        // initialize patisserie table
        Liste_Patisserie = FXCollections.observableArrayList(Session.iPatisserieService.DisplayAll());
        TablePatisserie.setItems(Liste_Patisserie);
        NomPat.setCellValueFactory(new PropertyValueFactory<>("nom"));
        NomPat.cellFactoryProperty();
        //ici description pas le nom du responsable
        ResponsableNomPat.setCellValueFactory(new PropertyValueFactory<>("description"));
        ResponsableNomPat.cellFactoryProperty();
         // initialize produits table
          Liste_MesProduits = FXCollections.observableArrayList(Session.iProduitService.DisplayAll());
        TableauProduits.setItems(Liste_MesProduits);
       

        NomProduit.setCellValueFactory(new PropertyValueFactory<>("nom"));
        NomProduit.cellFactoryProperty();
        prixProduit.setCellValueFactory(new PropertyValueFactory<>("prix"));
        prixProduit.cellFactoryProperty();
       
       categ.setCellValueFactory((TableColumn.CellDataFeatures<Produit, String> param) -> new SimpleStringProperty(param.getValue().getCategorie().getNom()));
    }  
        
        
        // TODO
       

 
    @FXML
    private void goToHome(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }
    

    @FXML
    private void goToClients(MouseEvent event)  throws SQLException, IOException  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Clients.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToResponsables(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Responsables.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToProduits(MouseEvent event)  throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("EspaceAdmin_Prod.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToRecettes(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Recettes1.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToPromotion(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Promotion.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToReclamation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Reclamation.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToEvaluation(MouseEvent event)  throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin_Evaluation.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void goToPanier(MouseEvent event) throws SQLException, IOException  {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeaffichage.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void LogOut(MouseEvent event) throws SQLException, IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                ChangeItGirls.getScene().setRoot(root);
    }

    @FXML
    private void Close(MouseEvent event) {
          Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

   


    @FXML
    private void DisplayALL_prod(MouseEvent event) {
        Liste_MesProduits = FXCollections.observableArrayList(Session.iProduitService.DisplayAll());
        TableauProduits.setItems(Liste_MesProduits);
    }

    @FXML
    private void RechercheProduitsByName(MouseEvent event) {
        Liste_MesProduits = FXCollections.observableArrayList(Session.iProduitService.DisplayByNom(recherche_Produit.getText()));
        TableauProduits.setItems(Liste_MesProduits);
    }

    @FXML
    private void DisplayAllPats(MouseEvent event) {
        Liste_Patisserie = FXCollections.observableArrayList(Session.iPatisserieService.DisplayAll());
        TablePatisserie.setItems(Liste_Patisserie);
    }

    @FXML
    private void RecherchePatByName(MouseEvent event) {
         Liste_Patisserie = FXCollections.observableArrayList(Session.iPatisserieService.DisplayByNom(recherche_patisseries.getText()));
        TablePatisserie.setItems(Liste_Patisserie);
    }

    
}
