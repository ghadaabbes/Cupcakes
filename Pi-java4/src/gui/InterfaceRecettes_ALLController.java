/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Commentaire;
import entities.Recette;
import entities.Vote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.VoteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceRecettes_ALLController implements Initializable {

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
    private ImageView btnClose;
    @FXML
    private TableView<Recette> TableRecette;

    @FXML
    private TableColumn<Recette, String> nom;
    @FXML
    private TableColumn<Recette, String> username;

    
    ObservableList<Recette> Liste_Recettes = FXCollections.observableArrayList();
    @FXML
    private TextField RechercheNom;
    @FXML
    private ImageView btnRechercheNom;
    @FXML
    private Pane PaneDetails;
    @FXML
    private Text idRecette;
    @FXML
    private ImageView imageDetails;
    @FXML
    private Text nomDetails;
    @FXML
    private Text typeDetails;
    @FXML
    private Text coutDetails;
    @FXML
    private Text difficulteDetails;
    @FXML
    private Text noteDetails;
    @FXML
    private ImageView goRecette;
    @FXML
    private VBox PaneFiltrer;
    @FXML
    private ImageView Type1;
    @FXML
    private ImageView Type2;
    @FXML
    private ImageView Type3;
    @FXML
    private ImageView Type4;
    @FXML
    private ImageView Type5;
    @FXML
    private ImageView Type6;
    @FXML
    private ImageView Type7;
    @FXML
    private ImageView Type8;
    @FXML
    private ImageView Type9;
    @FXML
    private ImageView Type10;
    @FXML
    private ImageView Cout1;
    @FXML
    private ImageView Cout2;
    @FXML
    private ImageView Cout3;
    @FXML
    private ImageView Difficulte1;
    @FXML
    private ImageView Difficulte2;
    @FXML
    private ImageView Difficulte3;
    @FXML
    private Pane btnChercherF;
    String T1_Biscuits="";
    String T2_Chocolat="";
    String T3_Gateaux="";
    String T4_Cremes="";
    String T5_Tartes="";
    String T6_Tn="";
    String T7_Traiteurs="";
    String T8_Pains="";
    String T9_Base="";
    String T10_Diet="";
    String C1_PasCher="";
    String C2_Adorable="";
    String C3_AssezCher="";
    String D1_Facile="";
    String D2_Medium="";
    String D3_Difficile="";
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RechercheNom.setText("Je cherche une recette...");
        Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.DisplayAll());
        
        TableRecette.setItems(Liste_Recettes);
       


        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        username.setCellValueFactory((TableColumn.CellDataFeatures<Recette, String> param) -> new SimpleStringProperty(param.getValue().getIduser().getUsername()));
       PaneDetails.setVisible(false);
      Image a = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");
       Type1.setImage(a);
       Type2.setImage(a);
       Type3.setImage(a);
       Type4.setImage(a);
       Type5.setImage(a);
       Type6.setImage(a);
       Type7.setImage(a);
       Type8.setImage(a);
       Type9.setImage(a);
       Type10.setImage(a);
       Cout1.setImage(a);
       Cout2.setImage(a);
       Cout3.setImage(a);
       Difficulte1.setImage(a);
       Difficulte2.setImage(a);
       Difficulte3.setImage(a);
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
    private void onMouseClickClose(MouseEvent event) {
                   Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void ConsulterDetails(MouseEvent event) {
     //no need  
    }

    @FXML
    private void ConsulterRecette(MouseEvent event) throws IOException {
        if(event.getClickCount()==1){
             PaneDetails.setVisible(true);
             Recette selectedRecette = TableRecette.getSelectionModel().getSelectedItem();
             //System.out.println(selectedRecette);
             Session.iRecetteService.findById(selectedRecette.getId());
             idRecette.setText(String.valueOf(Session.iRecetteService.findById(selectedRecette.getId()).getId()));
             nomDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getNom());
             typeDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getType());
             coutDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getCout());
             difficulteDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getDifficulte());
             try{ 
                 imageDetails.setImage(new Image(Session.iRecetteService.findById(selectedRecette.getId()).getNom_image()));}
             catch(Exception e){
                 Image image2 = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
                 imageDetails.setImage(image2);
                }
         
             Vote vot= new Vote();
             VoteService VS = new VoteService();
             double LastVote= VS.noteRecette(Session.iRecetteService.findById(selectedRecette.getId()).getId());
             String lastvote= String.valueOf(LastVote) +"/5";
             noteDetails.setText(lastvote); 
        }
        else if(event.getClickCount()==2){
             PaneDetails.setVisible(false);
        }
 
    }

    @FXML
    private void MouseClickButtonRechercheNom(MouseEvent event) {
        String x= RechercheNom.getText();
        if("".equals(x)){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Tapez le nom que vous voulez chercher");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
        }else if("Toutes".equals(x) || "Tous".equals(x) || "Toutes les recettes".equals(x) || "toutes".equals(x)){
            Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.DisplayAll());
        TableRecette.setItems(Liste_Recettes);
        }
        else{
        Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.findByNom(x));
        TableRecette.setItems(Liste_Recettes);
        }
    }

    @FXML
    private void HideConsulterDetails(MouseEvent event) {
     //no need  
    }

    @FXML
    private void goToRecette(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
 
        Recette selectedRecette = TableRecette.getSelectionModel().getSelectedItem();
        System.out.println(selectedRecette);
            
       InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(Session.iRecetteService.findById(selectedRecette.getId()));
    }

    @FXML
    private void MouseClickType1(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T2_Chocolat) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type1.setImage(val);
             T1_Biscuits="Biscuits";
            }
        
        }else if(event.getClickCount()==2){
            Type1.setImage(grey);
            T1_Biscuits="";
        }

    }

    @FXML
    private void MouseClickType2(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type2.setImage(val);
             T2_Chocolat="Chocolat";
            }
        
        }else if(event.getClickCount()==2){
            Type2.setImage(grey);
            T2_Chocolat="";
        }
    }

    @FXML
    private void MouseClickType3(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T2_Chocolat)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type3.setImage(val);
             T3_Gateaux="Gateux et Entremets";
            }
        
        }else if(event.getClickCount()==2){
            Type3.setImage(grey);
            T3_Gateaux="";
        }

    }

    @FXML
    private void MouseClickType4(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T2_Chocolat)|| !"".equals(T3_Gateaux) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type4.setImage(val);
             T4_Cremes="Cremes et Confitures";
            }
        
        }else if(event.getClickCount()==2){
            Type4.setImage(grey);
            T4_Cremes="";
        }
    }

    @FXML
    private void MouseClickType5(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T2_Chocolat) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type5.setImage(val);
             T5_Tartes="Tartes";
            }
        
        }else if(event.getClickCount()==2){
            Type5.setImage(grey);
            T5_Tartes="";
        }
    }

    @FXML
    private void MouseClickType6(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T2_Chocolat)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type6.setImage(val);
             T6_Tn="Spécialités Tunisiennes";
            }
        
        }else if(event.getClickCount()==2){
            Type6.setImage(grey);
            T6_Tn="";
        }
    }

    @FXML
    private void MouseClickType7(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T2_Chocolat)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type7.setImage(val);
             T7_Traiteurs="Traiteur(salé)";
            }
        
        }else if(event.getClickCount()==2){
            Type7.setImage(grey);
            T7_Traiteurs="";
        }
    }

    @FXML
    private void MouseClickType8(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T2_Chocolat) || !"".equals(T9_Base)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type8.setImage(val);
             T8_Pains="Pains et Viennoiseries";
            }
        
        }else if(event.getClickCount()==2){
            Type8.setImage(grey);
            T8_Pains="";
        }
    }

    @FXML
    private void MouseClickType9(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T2_Chocolat)|| !"".equals(T10_Diet)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type9.setImage(val);
             T9_Base="Recettes de base";
            }
        
        }else if(event.getClickCount()==2){
            Type9.setImage(grey);
            T9_Base="";
        }
    }

    @FXML
    private void MouseClickType10(MouseEvent event) {
                Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(T1_Biscuits) || !"".equals(T3_Gateaux)|| !"".equals(T4_Cremes) ||
                    !"".equals(T5_Tartes) || !"".equals(T6_Tn)|| !"".equals(T7_Traiteurs)||
                    !"".equals(T8_Pains) || !"".equals(T9_Base)|| !"".equals(T2_Chocolat)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 type ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Type10.setImage(val);
             T10_Diet="Diététiques";
            }
        
        }else if(event.getClickCount()==2){
            Type10.setImage(grey);
            T10_Diet="";
        }
    }

    @FXML
    private void MouseClickCout1(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(C2_Adorable) || !"".equals(C3_AssezCher)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 cout ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Cout1.setImage(val);
             C1_PasCher="Pas cher";
            }
        
        }else if(event.getClickCount()==2){
            Cout1.setImage(grey);
            C1_PasCher="";
        }
    }

    @FXML
    private void MouseClickCout2(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(C1_PasCher) || !"".equals(C3_AssezCher)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 cout ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Cout2.setImage(val);
             C2_Adorable="Adorable";
            }
        
        }else if(event.getClickCount()==2){
            Cout2.setImage(grey);
            C2_Adorable="";
        }
    }

    @FXML
    private void MouseClickCout3(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(C1_PasCher) || !"".equals(C2_Adorable)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 cout ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Cout3.setImage(val);
             C3_AssezCher="assez cher";
            }
        
        }else if(event.getClickCount()==2){
            Cout3.setImage(grey);
            C3_AssezCher="";
        }
    }

    @FXML
    private void MouseClickDifficulte1(MouseEvent event) {
        Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
        Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(D2_Medium) || !"".equals(D3_Difficile)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 difficulté ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Difficulte1.setImage(val);
             D1_Facile="Facile";
            }
        
        }else if(event.getClickCount()==2){
            Difficulte1.setImage(grey);
            D1_Facile="";
        }
    }

    @FXML
    private void MouseClickDifficulte2(MouseEvent event) {
         Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
         Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(D1_Facile) || !"".equals(D3_Difficile)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 difficulté ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Difficulte2.setImage(val);
             D2_Medium="Medium";
            }
        
        }else if(event.getClickCount()==2){
            Difficulte2.setImage(grey);
            D2_Medium="";
        }
   
    }

    @FXML
    private void MouseClickDifficulte3(MouseEvent event) {
         Image val = new Image("file:/C:/wamp64/www/java_DOC/msValide1.png");
         Image grey = new Image("file:/C:/wamp64/www/java_DOC/msValide2.png");      
        if(event.getClickCount()==1){
            if(!"".equals(D1_Facile) || !"".equals(D2_Medium)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("vous n'avez pas droit de choisir plus que 1 difficulté ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
            }else {
             Difficulte3.setImage(val);
             D3_Difficile="Difficile";
            }
        
        }else if(event.getClickCount()==2){
            Difficulte3.setImage(grey);
              D3_Difficile="";
        }
       
    }

    @FXML
    private void MouseClickBtnChercherF(MouseEvent event) {
        String ValueType1="";
        Boolean Bol_T1=true;
        
        String ValueCout1="";
        Boolean Bol_C1=true;
        
        
        String ValueDiff1="";
        Boolean Bol_D1=true;
        
        
        //Setting the valide value of type 1
        if(!"".equals(T1_Biscuits) ){
            ValueType1=T1_Biscuits;
        }else if( !"".equals(T2_Chocolat)){
            ValueType1=T2_Chocolat;
        }else if(!"".equals(T3_Gateaux)){
            ValueType1=T3_Gateaux;
        }else if( !"".equals(T4_Cremes) ){
            ValueType1=T4_Cremes;
        }else if(!"".equals(T5_Tartes)){
            ValueType1=T5_Tartes;
        }else if( !"".equals(T6_Tn)){
            ValueType1=T6_Tn;
        }else if( !"".equals(T7_Traiteurs)){
            ValueType1=T7_Traiteurs;
        } else if(!"".equals(T8_Pains) ){
            ValueType1=T8_Pains;
        } else if(!"".equals(T9_Base)){
            ValueType1=T9_Base;
        } else if(!"".equals(T10_Diet)){
            ValueType1=T10_Diet;
        }else{
           Bol_T1=false; 
           System.out.println("aucune type selectionne");
        }
       
        // Setting value of cout 1 
         if(!"".equals(C1_PasCher) && "".equals(C2_Adorable)&& "".equals(C3_AssezCher)){
            ValueCout1=C1_PasCher;
           
        }else if("".equals(C1_PasCher) && !"".equals(C2_Adorable)&& "".equals(C3_AssezCher)){
            ValueCout1=C2_Adorable;
          
        }else if("".equals(C1_PasCher) && "".equals(C2_Adorable)&& !"".equals(C3_AssezCher)){
            ValueCout1=C3_AssezCher;
           
        }else{
            //indique que la recheche se fait sans cout
            
            Bol_C1=false;
            System.out.println("aucune cout selectionne");
        }
        
        // Setting value of difficulte 
         if(!"".equals(D1_Facile) && "".equals(D2_Medium)&& "".equals(D3_Difficile)){
            ValueDiff1=D1_Facile;
           
        }else if("".equals(D1_Facile) && !"".equals(D2_Medium)&& "".equals(D3_Difficile)){
            ValueDiff1=D2_Medium;
          
        }else if("".equals(D1_Facile) && "".equals(D2_Medium)&& !"".equals(D3_Difficile)){
            ValueDiff1=D3_Difficile;
           
        }else{
            //indique que la recheche se fait sans difficulte
            
            Bol_D1=false;
            System.out.println("aucune difficulte selectionne");
        }
        if(!Bol_T1 && !Bol_C1  && !Bol_D1  ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("vous devez choisir un ou + élements pour faire la recherche ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("ok");
            } 
        } else{
            Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.RechercheFiltrer(ValueType1,ValueCout1,ValueDiff1));
            TableRecette.setItems(Liste_Recettes);
        }
        
       
        
          
    }


    @FXML
    private void MouseEnterCacherText1(MouseEvent event) {
        RechercheNom.setText("");
    }

    @FXML
    private void MouseEnterAfficherText1(MouseEvent event) {
        RechercheNom.setText("Je Cherche Une Recette...");
    }

    
}
