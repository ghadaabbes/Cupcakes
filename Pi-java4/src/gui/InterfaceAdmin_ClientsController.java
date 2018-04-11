/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Commentaire;
import entities.Recette;
import entities.User;
import entities.Vote;
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
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.UserService;
import service.VoteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceAdmin_ClientsController implements Initializable {

    @FXML
    private AnchorPane anco;
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
    private VBox CBoxResponsables;
    @FXML
    private Text Admin_Name;
    @FXML
    private Text nb_clients;
    @FXML
    private Text pourcentagee_clients;
    @FXML
    private ImageView ALL_clients;
    @FXML
    private Pane top5_clients;
    @FXML
    private Pane activites_clients;
    @FXML
    private TextField recherche_clients;
    @FXML
    private ImageView imgRecherche;
    @FXML
    private TableView<User> Table;
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private ImageView btnClose;
ObservableList<User> Liste_Users = FXCollections.observableArrayList();
    @FXML
    private Pane PnaeTop5;
    @FXML
    private ImageView closeTOPclients;
    @FXML
    private Text clientusername1;
    @FXML
    private Text clientusername2;
    @FXML
    private Text clientusername3;
    @FXML
    private Text clientusername4;
    @FXML
    private Text clientusername5;
    @FXML
    private Text clientRecettes1;
    @FXML
    private Text clientRecettes2;
    @FXML
    private Text clientRecettes3;
    @FXML
    private Text clientRecettes4;
    @FXML
    private Text clientRecettes5;
    @FXML
    private Text clientComment1;
    @FXML
    private Text clientComments2;
    @FXML
    private Text clientComments3;
    @FXML
    private Text clientComments4;
    @FXML
    private Text clientComments5;
    @FXML
    private Pane PaneDetailsUser;
    @FXML
    private Text Detailusername;
    @FXML
    private Text Details_NbRecettes;
    @FXML
    private Text Details_NbComment;
    @FXML
    private TableView<Recette> Details_TableRecette;
    @FXML
    private TableColumn<Recette, String> Details_TableRecette_Column;
    @FXML
    private TableView<Commentaire> Details_TableComment;
    @FXML
    private TableColumn<Commentaire, String> Details_TableComment_Column;
    @FXML
    private ImageView close3;
     ObservableList<Recette> Liste_MesRecettes = FXCollections.observableArrayList();
     ObservableList<Commentaire> Liste_Comment = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      Admin_Name.setText(Session.LoggedUser.getUsername());
        recherche_clients.setText("Recherche de clients...");
        Liste_Users = FXCollections.observableArrayList(Session.iuserService.DisplayAllClients());
        Table.setItems(Liste_Users);
//        id.setCellValueFactory(new PropertyValueFactory<>("id"));
     //   id.cellFactoryProperty();
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        username.cellFactoryProperty();
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.cellFactoryProperty();
        nb_clients.setText(String.valueOf(Session.iuserService.getnombreClients()));
        String pr= String.valueOf(Session.iuserService.getPourcentageClients());
        pourcentagee_clients.setText(pr+"%");
        PnaeTop5.setVisible(false);
        PaneDetailsUser.setVisible(false);
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

    @FXML
    private void DisplayAllClients(MouseEvent event) {
         Liste_Users = FXCollections.observableArrayList(Session.iuserService.DisplayAllClients());
        Table.setItems(Liste_Users);
    }
UserService us2 = new UserService();
    @FXML
    private void DisplayTop5Clients(MouseEvent event) {
        
            PnaeTop5.setVisible(true);
             
             clientusername1.setText(Session.iuserService.findById(us2.ClientTOP1()).getUsername());
             clientRecettes1.setText(String.valueOf(Session.iuserService.Client_NbRecettes(us2.ClientTOP1())));
             clientComment1.setText(String.valueOf(Session.iuserService.Client_NbComment(us2.ClientTOP1())));
             
            
             clientusername2.setText(Session.iuserService.findById(us2.ClientTOP2()).getUsername());
             clientRecettes2.setText(String.valueOf(Session.iuserService.Client_NbRecettes(us2.ClientTOP2())));
             clientComments2.setText(String.valueOf(Session.iuserService.Client_NbComment(us2.ClientTOP2())));
             
            
             clientusername3.setText(Session.iuserService.findById(us2.ClientTOP3()).getUsername());
             clientRecettes3.setText(String.valueOf(Session.iuserService.Client_NbRecettes(us2.ClientTOP3())));
             clientComments3.setText(String.valueOf(Session.iuserService.Client_NbComment(us2.ClientTOP3())));
             
             clientusername4.setText(Session.iuserService.findById(us2.ClientTOP4()).getUsername());
             clientRecettes4.setText(String.valueOf(Session.iuserService.Client_NbRecettes(us2.ClientTOP4())));
             clientComments4.setText(String.valueOf(Session.iuserService.Client_NbComment(us2.ClientTOP4())));
             
             clientusername5.setText(Session.iuserService.findById(us2.ClientTOP5()).getUsername());
             clientRecettes5.setText(String.valueOf(Session.iuserService.Client_NbRecettes(us2.ClientTOP5())));
             clientComments5.setText(String.valueOf(Session.iuserService.Client_NbComment(us2.ClientTOP5())));
            
       
    }

    @FXML
    private void DisplayActivitesClients(MouseEvent event) {
        if(Table.getSelectionModel().getSelectedItem()!=null){
         PaneDetailsUser.setVisible(true);
         
        User selecteduser = Table.getSelectionModel().getSelectedItem();
        int x= selecteduser.getId();
        Detailusername.setText(Session.iuserService.findById(x).getUsername());
        Details_NbRecettes.setText(String.valueOf(Session.iuserService.Client_NbRecettes(x)));
        Details_NbComment.setText(String.valueOf(Session.iuserService.Client_NbComment(x)));
    
        if(Session.iuserService.Client_NbRecettes(x)!=0){
            Details_TableRecette.setVisible(true);
        Liste_MesRecettes = FXCollections.observableArrayList(Session.iRecetteService.getByUser(x));
        Details_TableRecette.setItems(Liste_MesRecettes);
       
      
        Details_TableRecette_Column.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Details_TableRecette_Column.cellFactoryProperty();
        }else{
            Details_TableRecette.setVisible(false);
        }
        /////////////////////////////////////////////////
        if(Session.iuserService.Client_NbComment(x)!=0){
            Details_TableComment.setVisible(true); 
            Liste_Comment= FXCollections.observableArrayList(Session.iCommentaireService.getByUser(x));
            Details_TableComment.setItems(Liste_Comment);
       
      
            Details_TableComment_Column.setCellValueFactory((TableColumn.CellDataFeatures<Commentaire, String> param) -> 
                                                         new SimpleStringProperty(param.getValue().getIdrecette().getNom()));    
        }else{
           Details_TableComment.setVisible(false);  
        }
        }
        
        
      
        
       
        
    }

  /*  @FXML
    private void Display Activités Clients(MouseEvent event) {
    } */

    @FXML
    private void RechercheClientByUserName(MouseEvent event) {
         Liste_Users = FXCollections.observableArrayList(Session.iuserService.findClientsByUserNom(recherche_clients.getText()));
        Table.setItems(Liste_Users);
    }

    @FXML
    private void hideRecherche(MouseEvent event) {
        recherche_clients.setText("");
    }

    @FXML
    private void closeTOPclients(MouseEvent event) {
        PnaeTop5.setVisible(false);
    }

    private void DetailsClose(MouseEvent event) {
      // no need  
    }

    @FXML
    private void close3(MouseEvent event) {
        PaneDetailsUser.setVisible(false);
    }
    
}
