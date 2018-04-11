/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Commandes;
import entities.Ligne_Commande;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import service.CommandesServices;
import service.LigneServices;
import service.UserService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class AfficheComandeController implements Initializable {

    @FXML
    private TableColumn<Commandes, Integer> id;
    @FXML
    private TableColumn<Commandes, java.util.Date> date;
    @FXML
    private TableColumn<Commandes, Float> prixtotal;
    @FXML
    private TableColumn<Commandes, String> user;
    @FXML
    private TableView<Commandes> liste;
    @FXML
    private JFXTextField recherche;
  
    ObservableList<Commandes> champs  = FXCollections.observableArrayList();
     ObservableList<Ligne_Commande> lis = FXCollections.observableArrayList();
  
    @FXML
    private TableColumn<Commandes, String> adresse;
    @FXML
    private AnchorPane anco;
    @FXML
    private JFXButton details;
    @FXML
    private ImageView rech;
    @FXML
    private JFXButton suppression;
    private AnchorPane an;
    
    private TableView<Ligne_Commande> list;
    private TableColumn<Ligne_Commande, Integer> idd;
    private TableColumn<Ligne_Commande, Date> datee;
    private TableColumn<Ligne_Commande, String> produit;
    private TableColumn<Ligne_Commande, Integer> quantite;
    private TableColumn<Ligne_Commande, Float> prix;
    @FXML
    private Button gotoacceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        champs = FXCollections.observableArrayList(Session.iCommandes.getAll());
        liste.setItems(champs);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
     
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        prixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
       
        user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getUser_id().getUsername());
            }
        });
        
        adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getAdresse_id().affichA());
            }
        });
       
        
    }
    
    @FXML
   private void onRecherche(MouseEvent event) {
        String x= recherche.getText();
       
       
        if("".equals(x)){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Tapez le nom d'utilisateur que vous voulez chercher");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
        }else if("Tous".equals(x) ){
           champs = FXCollections.observableArrayList(Session.iCommandes.DisplayAll());
        liste.setItems(champs);
        }
        else{
            UserService service = new UserService();
            List<User> us = service.getAll();
            User u = new User();
            for(int i = 0; i < us.size(); i++)
            {
                if(us.get(i).getUsername().equals(x))
                {
                    u = us.get(i);
                }
            }
        champs = FXCollections.observableArrayList(Session.iCommandes.findBy(u));
            liste.setItems(champs);
        }
    }
    @FXML
    private void Supprimercom(MouseEvent event) {
        if (!liste.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Commande");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la commande " + liste.getSelectionModel().getSelectedItem().getId() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Session.iCommandes.remove(liste.getSelectionModel().getSelectedItem().getId());

                //Reclamation r= new Reclamation();
                //TableReclamation.setItems(());
                 ObservableList<Commandes> champs = FXCollections.observableArrayList(Session.iCommandes.DisplayAll());
                 System.out.println(champs);
                 
                 id.setCellValueFactory(new PropertyValueFactory<>("id"));
                 date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
                 prixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
       
                 user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getUser_id().getUsername());
                }
                });
                
               adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commandes, String>, ObservableValue<String>>() {
               @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Commandes, String> param) {
                return new SimpleStringProperty(param.getValue().getAdresse_id().affichA());
            }
        });
       
                liste.setItems(champs);
            }
        }
    }
    
     @FXML
     public void detailscom(MouseEvent event)
    {
    if (!liste.getSelectionModel().isEmpty()){
       
        lis = FXCollections.observableArrayList(Session.iLignes.getBycom(list.getSelectionModel().getSelectedItem().getId()));
        list.setItems(lis);
        
        idd.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        datee.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne_Commande, Date>, ObservableValue<Date>>() {
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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsaffiche.fxml"));
                
                Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficheComandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                an.getScene().setRoot(root);
    
    }


    private void ok(MouseEvent event) throws SQLException, IOException{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeaffichage.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void gotoacceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
        
    }
    
    
}
