/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import entities.Patisserie;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleObjectProperty;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import service.PatisserieService;

import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class EspacePatController implements Initializable {
    @FXML
    private Button btn0;
    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private TableView<Patisserie> Table;
    @FXML
    private TableColumn<Patisserie, String> nom;
    @FXML
    private TableColumn<Patisserie, String> desc;
    @FXML
    private TableColumn<Patisserie, String> adress;
    @FXML
    private ImageView btnModify;
    @FXML
    private AnchorPane anco;
    ObservableList<Patisserie> Liste_MesPatisserie = FXCollections.observableArrayList();
 
    @FXML
    private Text username;
    @FXML
    private Button partagerFb;
    @FXML
    private TableColumn<Patisserie, Integer> idpat;
   
   
     


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          TranslateTransition transition = new TranslateTransition ();
          transition.setDuration(Duration.seconds(4));
          transition.setNode(partagerFb);
          transition.setToY(-200);
          transition.setAutoReverse(true);
            transition.setCycleCount(TranslateTransition.INDEFINITE);
          transition.play();
          
          
         username.setText(Session.LoggedUser.getUsername());
        // TODO
        Liste_MesPatisserie = FXCollections.observableArrayList(Session.iPatisserieService.getByUser(Session.LoggedUser.getId()));
        Table.setItems(Liste_MesPatisserie);

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        adress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adress.cellFactoryProperty();
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        desc.cellFactoryProperty();
        
       idpat.setCellValueFactory(new PropertyValueFactory<>("idPatisserie"));
       idpat.cellFactoryProperty();
//       
//       Patisserie cp=new Patisserie();
//         columnimg.setCellValueFactory(new PropertyValueFactory<Patisserie, Image>("File:\\C:\\wamp\\www\\siw\\web\\images\\"+cp.getNomImage()));
//        columnimg.setPrefWidth(60);
//              tabimage.getColumns().add(columnimg);
    //    tabimage.setItems(imgList);

    }
    
    
  
 
        

    @FXML
    private void addpat(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormPat.fxml"));
       
             Parent root = loader.load();
            Scene scene = new Scene(root);
           
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

       
    }

    @FXML
    private void Acceuil(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
    }

    @FXML
    private Stage Modify(MouseEvent event) throws IOException {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("FormModifyPat_1.fxml"));

          Stage stage2 = new Stage(StageStyle.TRANSPARENT);
          // scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
          stage2.setScene(
          new Scene((AnchorPane) loader2.load()));
 
        Patisserie selectedP = Table.getSelectionModel().getSelectedItem();
         // idP.setText(String.valueOf(Session.iPatisserieService.findById(selectedP.getIdPatisserie()));
        //  System.out.println(selectedP);
          
           // System.out.println(selectedP.getIdPatisserie());
        FormModifyPatController controller = 
         loader2.<FormModifyPatController>getController();
         controller.initData( Session.iPatisserieService.findById(selectedP.getIdPatisserie()));
 
         stage2.show();

         return stage2;
    }
//
   @FXML
    private void Delete(MouseEvent event) throws IOException {
                 PatisserieService t2 = new PatisserieService();
         if (!Table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer cette patisserie");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la patisserie : " + Table.getSelectionModel().getSelectedItem().getNom() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           Patisserie selectedP = Table.getSelectionModel().getSelectedItem();
                System.out.println(selectedP);
              Session.iPatisserieService.remove(selectedP.getIdPatisserie());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("EspacePat.fxml"));
                
                Parent root = loader.load();
                
                anco.getScene().setRoot(root);
            }
        }

  
//
//        if (!Table.getSelectionModel().isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation");
//            alert.setHeaderText("Etes-vous sûr de vouloir supprimer?");
//
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == ButtonType.OK) {
//                PatisserieService iss = new PatisserieService();
////                int id=Integer.parseInt(tfSearch.getAccessibleHelp());
//
//                iss.remove(Table.getSelectionModel().getSelectedItem().getIdPatisserie());
//              FXMLLoader loader = new FXMLLoader(getClass().getResource("EspacePat.fxml"));
//                
//                Parent root = loader.load();
//               
//               anco.getScene().setRoot(root);
//            } else {
//                // ... user chose CANCEL or closed the dialog
//            }
//        } else {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning");
//            alert.setHeaderText("Veuillez Selectionner une promotion!");
//            alert.showAndWait();
//        }
  }

    @FXML
    private void btnDelete(MouseDragEvent event) {
    }
    @FXML
    void PartagersurFB(ActionEvent event)  {

        Patisserie sharefb;
        
       sharefb = Table.getSelectionModel().getSelectedItem();
        String cl = "VOTRE Patisserie \t"+sharefb.getNom()+"\n "+sharefb.getAdresse()+"\n "+sharefb.getNom();
        String accessToken = "EAAF29KZCwQl0BAMt2gKFZB5VfPYUmyJibJ0s7uQpSUiHYymjiZCmAZAmih3l6I5yMpHThc3Qtcd94lVei5ZAgz9i7ZCzhrsZBwvr00c7pCZAjSd1B3ZCjdZCLL1Vqgm6uM2jXGBcxVnckGpI4VrRNg3NVjZCRAIT1EMVZC5KjsZBQ0X0koZAcbUfIcJfUrpLC3YVyPZCT8ZC1zptwU8fXQZDZD";
        FacebookClient fbClient = new DefaultFacebookClient (accessToken);
        FacebookType response = fbClient.publish("me/feed",FacebookType.class,Parameter.with("message",cl+"\n Developped by Siwar"));
        System.out.println("succesfull posting on facebook");

    
    }
    
    
    
    
    
    
    
    
}
