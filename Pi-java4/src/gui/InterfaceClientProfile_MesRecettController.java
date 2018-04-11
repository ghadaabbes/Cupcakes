/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Recette;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import service.RecetteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceClientProfile_MesRecettController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private ImageView CHome;
    @FXML
    private ImageView CclientIcon;
    @FXML
    private ImageView CrecetteIcon;
    @FXML
    private ImageView CPatisserieIcon;
    @FXML
    private ImageView CShopIcon;
    @FXML
    private ImageView CPromoIcon;
    @FXML
    private ImageView CReclamationIcon;
    @FXML
    private ImageView CEvaluationIcon;
    @FXML
    private ImageView CPanierIcon;
    @FXML
    private ImageView CLogoutIcon;
    @FXML
    private VBox CBoxHome;
    @FXML
    private ImageView CHomeIcon;
    @FXML
    private Text LabelHome;
    @FXML
    private VBox CBoxClient;
    @FXML
    private Text LabelClient;
    @FXML
    private VBox CBoxRecette;
    @FXML
    private Text LabelRecette;
    @FXML
    private VBox CBoxPatisserie;
    @FXML
    private VBox CBoxShop;
    @FXML
    private VBox CBoxPromo;
    @FXML
    private VBox CBoxReclamation;
    @FXML
    private VBox CBoxEvaluation;
    @FXML
    private VBox CBoxPanier;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private Text username;
    @FXML
    private TableView<Recette> Table;
  
    @FXML
    private TableColumn<Recette, String> colNom;
 
     ObservableList<Recette> Liste_MesRecettes = FXCollections.observableArrayList();
   
    @FXML
    private ImageView ConsulterRecette;
    @FXML
    private ImageView ModifierRecette;
    @FXML
    private ImageView DeleteRecette;
    @FXML
    private Text ConsulterLabel;
    @FXML
    private Text ModifierLabel;
    @FXML
    private Text DeleteLabel;
    @FXML
    private ImageView btnClose;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        username.setText(Session.LoggedUser.getUsername());
        Liste_MesRecettes = FXCollections.observableArrayList(Session.iRecetteService.getByUser(Session.LoggedUser.getId()));
        Table.setItems(Liste_MesRecettes);
       
      
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNom.cellFactoryProperty();
       
       
    }    

       @FXML
    private void GoToHome(MouseEvent event) throws SQLException, IOException{
         
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToClientProfile(MouseEvent event) throws SQLException, IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientProfile.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToRecettes(MouseEvent event) throws SQLException, IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

 @FXML
    private void GoToPatisseries(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientPat.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToShop(MouseEvent event)throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceShop.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPromo(MouseEvent event) throws SQLException, IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacePromo.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToReclamation(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToEvaluation(MouseEvent event) throws SQLException, IOException{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceEvaluation.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void GoToPanier(MouseEvent event) throws SQLException, IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Lepanier.fxml"));
                
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
    private void OnMouseCliked(MouseEvent event) {
         

            
    }

    @FXML
    private void afficheConsulterLAbel(MouseEvent event) {
    ConsulterLabel.setText("Consulter");
    }

    @FXML
    private void afficheModifierLabel(MouseEvent event) {
        ModifierLabel.setText("Modifier");
    }

    @FXML
    private void afficheDeleteLabel(MouseEvent event) {
        DeleteLabel.setText("Supprimer");
    }

    @FXML
   private void ConsulterRecette(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
 
        Recette selectedRecette = Table.getSelectionModel().getSelectedItem();
        System.out.println(selectedRecette);
            
       InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(Session.iRecetteService.findById(selectedRecette.getId()));

    }

    @FXML
    private Stage ModifierRecette(MouseEvent event) throws IOException {
          FXMLLoader loader2 = new FXMLLoader(getClass().getResource("InterfaceClientProfile_ModifierRecette.fxml"));

          Stage stage2 = new Stage(StageStyle.TRANSPARENT);
          // scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
          stage2.setScene(
          new Scene((AnchorPane) loader2.load()));
 
          Recette selectedRecette = Table.getSelectionModel().getSelectedItem();
          System.out.println(selectedRecette);
            
       InterfaceClientProfile_ModifierRecetteController controller = 
         loader2.<InterfaceClientProfile_ModifierRecetteController>getController();
         controller.initData(Session.iRecetteService.findById(selectedRecette.getId()));
 
         stage2.show();

         return stage2;
    }

    @FXML
    private void SupprimerRecette(MouseEvent event) throws IOException {
         RecetteService t2 = new RecetteService();
         if (!Table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Recette");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la recette numero : " + Table.getSelectionModel().getSelectedItem().getId() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           Recette selectedRecette = Table.getSelectionModel().getSelectedItem();
                System.out.println(selectedRecette);
              Session.iRecetteService.remove(selectedRecette.getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientProfile_MesRecett.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
        }
         }
    }

  /*  @FXML
    private void showImage(MouseEvent event) {
     try{ 
         String imageFile = (Session.iRecetteService.findById(Table.getSelectionModel().getSelectedItem().getId()).getNom_image());
        System.out.println(imageFile);
        Image image1 = new Image(imageFile);
        image.setImage(image1);}
     catch(Exception e){
          Image image2 = new Image("@../icons/mscupcake2.jpg");
        image.setImage(image2);
     }
            
    }
*/
    @FXML
    private void HideConsulterLabel(MouseEvent event) {
        ConsulterLabel.setText("");
    }

    @FXML
    private void HideModifierLabel(MouseEvent event) {
        ModifierLabel.setText("");
    }

    @FXML
    private void HideDeleteLabel(MouseEvent event) {
        DeleteLabel.setText("");
    }

    @FXML
    private void showImage(MouseEvent event) {
    }

    @FXML
    private void onClickClose(MouseEvent event) {
         Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
}
