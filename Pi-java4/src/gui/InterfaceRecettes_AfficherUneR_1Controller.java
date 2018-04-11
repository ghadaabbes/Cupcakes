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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.CommentaireService;
import service.RecetteService;
import service.VoteService;
import utils.Session;


//PRINTER DETECTOR
import java.io.*;
import javax.print.*;
import javax.print.attribute.*; 
import javax.print.attribute.standard.*; 
  

import java.awt.Desktop;
import java.io.IOException;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



import org.apache.poi.xwpf.usermodel.*;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceRecettes_AfficherUneR_1Controller implements Initializable {

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
    private ImageView image;
    @FXML
    private Text username;
    @FXML
    private Text type;
    @FXML
    private Text description;
    @FXML
    private Text nbPersonne;
    @FXML
    private Text Tcuisson;
    @FXML
    private Text Trepos;
    @FXML
    private Text cout;
    @FXML
    private Text ingredients;
    @FXML
    private Text etapes;
    @FXML
    private Text astuces;
    @FXML
    private TableView<Commentaire> TableCommentaire;
    @FXML
    private TableColumn<Commentaire, String> usernameColumn;
    @FXML
    private TableColumn<Commentaire, String> comment;
    @FXML
    private Pane btnAddComment;
     ObservableList<Commentaire> Liste_Commentaires = FXCollections.observableArrayList();
    @FXML
    private ImageView close;
    @FXML
    private Text Tpreparation;
    @FXML
    private Text difficulte;
    @FXML
    private Text nom;
    @FXML
    private Text idrecette;
    @FXML
    private TextArea CommentArea;
   
    RecetteService Rs = new RecetteService();
    Recette r = new Recette();
    @FXML
    private Pane MyComment;
    @FXML
    private ImageView modifyComment;
    @FXML
    private ImageView deleteComment;
    @FXML
    private Pane ABCD;
    @FXML
    private TextArea commentABCD;
    @FXML
    private Button modifyABCD;
    @FXML
    private ImageView closeABCD;
    @FXML
    private ImageView Noter;
    @FXML
    private Pane PaneNote;
    @FXML
    private ImageView IconCloseNote;
    @FXML
    private Text idVote;
    @FXML
    private Text VoteHidden;
    @FXML
    private ImageView noteFinale;
    @FXML
    private Button btnAddVote;
    @FXML
    private HBox StarsBox;
    @FXML
    private ImageView S4;
    @FXML
    private ImageView S5;
    @FXML
    private ImageView S1;
    @FXML
    private ImageView S2;
    @FXML
    private ImageView S3;
    
    int UneNote=0;
    @FXML
    private Pane yellowStars;
    @FXML
    private ImageView yS1;
    @FXML
    private ImageView yS2;
    @FXML
    private ImageView yS3;
    @FXML
    private ImageView yS4;
    @FXML
    private ImageView yS5;
    @FXML
    private ImageView doc;
   // private Pane PanePrinter;
   // private Text PrinterMessage;
   
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     private boolean valide(String s){  
    boolean v =true ;
    if ( s.equals(""))
        v= false ;
    return v ; 
   }
  
    @FXML
    private void AddComment(MouseEvent event) throws IOException {
    
      
        CommentaireService Cm = new CommentaireService();
        Commentaire C1 = new Commentaire();
        C1.setIdrecette(Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())));
        C1.setIduser(Session.LoggedUser); 
     
       if(valide(CommentArea.getText())){
        C1.setComment(CommentArea.getText());
        Cm.add(C1);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Le commentaire est bien ajoutée ");
            alert.setHeaderText("veuillez rafraichir la page pour voir votre comentaire");
            Optional<ButtonType> result = alert.showAndWait();
        
            if (result.get() == ButtonType.OK) {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));   
              Parent root = loader.load();
              anco.getScene().setRoot(root); 
             InterfaceRecettes_AfficherUneR_1Controller controller = 
                 loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
                 controller.initData(Rs.findById(Integer.valueOf(idrecette.getText())));
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention!");
            alert.setHeaderText("Le commentaire ne doit pas etre vide ");
            Optional<ButtonType> result = alert.showAndWait();
       }
    }
    /************************** void initData ************************************/
    void initData(Recette r) {
        idrecette.setText(String.valueOf(r.getId()));
        System.out.println(idrecette);
        nom.setText(r.getNom());
        username.setText(r.getIduser().getUsername());
        type.setText(r.getType());
        description.setText(r.getDescription());
        nbPersonne.setText(String.valueOf(r.getNb_personne()));
        cout.setText(r.getCout());
        difficulte.setText(r.getDifficulte());
        Tpreparation.setText(String.valueOf(r.getTemps_preparation()));
        Trepos.setText(String.valueOf(r.getTemps_repos()));
        Tcuisson.setText(String.valueOf(r.getTemps_cuisson()));
        ingredients.setText(r.getIngredients());
        etapes.setText(r.getEtapes());
        astuces.setText(r.getAstuces());
        try{ 
            String imageFile = (r.getNom_image());
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            image.setImage(image1);}
        catch(Exception e){
            Image image2 = new Image("file:/C:/wamp64/www/java_DOC/mscupcake6.jpg");
            image.setImage(image2);
        }
        Liste_Commentaires = FXCollections.observableArrayList(Session.iCommentaireService.getByRecette(Integer.parseInt(idrecette.getText())));
        TableCommentaire.setItems(Liste_Commentaires);
        
      
        usernameColumn.setCellValueFactory((TableColumn.CellDataFeatures<Commentaire, String> param) -> new SimpleStringProperty(param.getValue().getIduser().getUsername()));
        
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        comment.cellFactoryProperty();
        MyComment.setVisible(false);
        ABCD.setVisible(false);
        PaneNote.setVisible(false);
        DropShadow dropShadow = new DropShadow();
                   dropShadow.setRadius(5.0);
                   dropShadow.setOffsetX(3.0);
                   dropShadow.setOffsetY(3.0);
                   dropShadow.setColor(Color.color(0.4, 0.5, 0.5)); 
        Image image3= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        S1.setImage(image3);
        S1.setEffect(dropShadow);
        S2.setImage(image3);
        S2.setEffect(dropShadow);
        S3.setImage(image3);
        S3.setEffect(dropShadow);
        S4.setImage(image3);
        S4.setEffect(dropShadow);
        S5.setImage(image3);
        S5.setEffect(dropShadow);
        yellowStars.setVisible(false);
        Vote vot= new Vote();
        VoteService VS = new VoteService();
        double LastVote= VS.noteRecette(r.getId());
        if(LastVote>0 && LastVote<=0.5){
           
      
            noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar0.5.png"));
            noteFinale.setEffect(dropShadow);
        }else if(LastVote>0.5 && LastVote<=1.0){
           noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar1.png"));
            noteFinale.setEffect(dropShadow);
        }else if(LastVote>1.0 && LastVote<=1.5){
              noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar1.5.png"));
          noteFinale.setEffect(dropShadow);
        }else if(LastVote>1.5 && LastVote<=2.0){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar2.png"));
          noteFinale.setEffect(dropShadow);
        }else if(LastVote>2.0 && LastVote<=2.5){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar2.5.png"));
         
        } else if(LastVote>2.5 && LastVote<=3.0){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar3.png"));
          noteFinale.setEffect(dropShadow);
        }else if(LastVote>3.0 && LastVote<=3.5){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar3.5.png"));
          noteFinale.setEffect(dropShadow);
        }else if(LastVote>3.5 && LastVote<=4.0){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar4.png"));
          noteFinale.setEffect(dropShadow);
        }else if(LastVote>4.0 && LastVote<=4.5){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar4.5.png"));
          noteFinale.setEffect(dropShadow);
        }else if (LastVote>4.5 && LastVote<=5.0){
               noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar5.png"));
          noteFinale.setEffect(dropShadow);
        } else{
            noteFinale.setImage(new Image("file:/C:/wamp64/www/java_DOC/msStar0.png"));
             noteFinale.setEffect(dropShadow);
        }
    
  }

   

    @FXML
    private void clickClose1(MouseEvent event) {
           Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void modifyMyComment(MouseEvent event) throws IOException {
    
       ABCD.setVisible(true);
                Commentaire selectedComment = TableCommentaire.getSelectionModel().getSelectedItem();

       commentABCD.setText(selectedComment.getComment());
    }

    @FXML
    private void deleteMyComment(MouseEvent event) throws IOException {
         CommentaireService t2 = new CommentaireService();
         if (!TableCommentaire.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Commentaire");
            alert.setHeaderText("Etes vous sur de vouloir supprimer le commentaire : " + TableCommentaire.getSelectionModel().getSelectedItem().getComment() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
          Commentaire selectedCommentaire = TableCommentaire.getSelectionModel().getSelectedItem();
                System.out.println(selectedCommentaire);
              Session.iCommentaireService.remove(selectedCommentaire.getId());
             
              
              
               FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));   
                Parent root = loader.load();
                
                anco.getScene().setRoot(root); 
              
         
             InterfaceRecettes_AfficherUneR_1Controller controller = 
             loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
             controller.initData(Rs.findById(Integer.valueOf(idrecette.getText())));
           
        }
         }
    }

    @FXML
    private void tableOnClick(MouseEvent event) {
         Commentaire selectedComment = TableCommentaire.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 1){
        
       if(selectedComment.getIduser().getId()== Session.LoggedUser.getId()){
             MyComment.setVisible(true);
         }
       else if(selectedComment.getIduser().getId()!= Session.LoggedUser.getId()){
             MyComment.setVisible(false);
             }
        }
    }

    @FXML
    private void closemycommentPalett(MouseEvent event) {
        //not needed for delete 
    }

    @FXML
    private void finalCommentModifyABCD(MouseEvent event) throws IOException {
           CommentaireService Co1 = new CommentaireService();
      Commentaire C1 =  new Commentaire();
        Commentaire selectedCommentaire = TableCommentaire.getSelectionModel().getSelectedItem();
        
        C1.setId(selectedCommentaire.getId());
        C1.setIdrecette(Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())));
        C1.setIduser(Session.LoggedUser);
       if(!"".equals(commentABCD.getText())){
        C1.setComment(commentABCD.getText());
   
         
            
            Co1.update(C1); 
            System.out.println("success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Commentaire Modifiée ");
            alert.setHeaderText(null);
           
      
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           
              ABCD.setVisible(false);
           //
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));   
                Parent root = loader.load();
                
                anco.getScene().setRoot(root); 
              
         
             InterfaceRecettes_AfficherUneR_1Controller controller = 
             loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
             controller.initData(Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())));
           //
        }
       }
    }

    @FXML
    private void closeModifyCommentABCD(MouseEvent event) {
         ABCD.setVisible(false);
        
    }

    @FXML
    private void onClickNoter(MouseEvent event) {

        PaneNote.setVisible(true);

    }

    @FXML
    private void CloseNote(MouseEvent event) {
        PaneNote.setVisible(false);
    }

    @FXML
    private void onMouseClickAddVote(MouseEvent event) throws IOException {
       System.out.println(Session.LoggedUser.getId());
       int xx= Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())).getIduser().getId();
       System.out.println(Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())).getIduser().getId());
        if(Session.LoggedUser.getId()==xx){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("Vous n'avez pas droit de noter votre propre Recette!");
             Optional<ButtonType> result = alert.showAndWait();
              if (result.get() == ButtonType.OK) {
                 System.out.println("ok"); 
              }
              
        } else{      
         VoteService Cm = new VoteService();
        Vote C1 = new Vote();
        C1.setIdrecette(Session.iRecetteService.findById(Integer.valueOf(idrecette.getText())));
         C1.setRating(UneNote); 
     
       if(UneNote!=0){
        
        Cm.add(C1);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("Merci d'avoir Noter cette Recette!");
              Optional<ButtonType> result = alert.showAndWait();
        
               if (result.get() == ButtonType.OK) {
                   PaneNote.setVisible(false);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));   
                Parent root = loader.load();
                
                anco.getScene().setRoot(root); 
              
         
             InterfaceRecettes_AfficherUneR_1Controller controller = 
             loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
             controller.initData(Rs.findById(Integer.valueOf(idrecette.getText())));
         
            }
        
         }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention!");
            alert.setHeaderText("La Notene doit pas etre vide ");
            Optional<ButtonType> result = alert.showAndWait();
    }
        } 
        
    }

    @FXML
    private void clickStar4(MouseEvent event) {
        StarsBox.setVisible(false);
        yellowStars.setVisible(true);
        Image grey= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        Image yellow= new Image("file:/C:/wamp64/www/java_DOC/msStarYellow.png");
       
        yS1.setImage(yellow);
        yS2.setImage(yellow);
        yS3.setImage(yellow);
        yS4.setImage(yellow);
        yS5.setImage(grey); 
         VoteHidden.setText("4");
          UneNote=4; 
        
    }

    @FXML
    private void clickStar5(MouseEvent event) {
         StarsBox.setVisible(false);
 yellowStars.setVisible(true);
        Image grey= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        Image yellow= new Image("file:/C:/wamp64/www/java_DOC/msStarYellow.png");
       
        yS1.setImage(yellow);
        yS2.setImage(yellow);
        yS3.setImage(yellow);
        yS4.setImage(yellow);
        yS5.setImage(yellow); 
         VoteHidden.setText("5");
          UneNote=5; 
    }

    @FXML
    private void clickStar1(MouseEvent event) {
         StarsBox.setVisible(false);
        yellowStars.setVisible(true);
        Image grey= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        Image yellow= new Image("file:/C:/wamp64/www/java_DOC/msStarYellow.png");
       
        yS1.setImage(yellow);
        yS2.setImage(grey);
        yS3.setImage(grey);
        yS4.setImage(grey);
        yS5.setImage(grey); 
          
       
         VoteHidden.setText("1");
        UneNote=1; 
    }

    @FXML
    private void clickStar2(MouseEvent event) {
         StarsBox.setVisible(false);
        yellowStars.setVisible(true);
        Image grey= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        Image yellow= new Image("file:/C:/wamp64/www/java_DOC/msStarYellow.png");
       
        yS1.setImage(yellow);
        yS2.setImage(yellow);
        yS3.setImage(grey);
        yS4.setImage(grey);
        yS5.setImage(grey); 
          
         VoteHidden.setText("2");
          UneNote=2; 
    }

    @FXML
    private void clickStar3(MouseEvent event) {
        StarsBox.setVisible(false);
       yellowStars.setVisible(true);
        Image grey= new Image("file:/C:/wamp64/www/java_DOC/msStarGrey.png");
        Image yellow= new Image("file:/C:/wamp64/www/java_DOC/msStarYellow.png");
       
        yS1.setImage(yellow);
        yS2.setImage(yellow);
        yS3.setImage(yellow);
        yS4.setImage(grey);
        yS5.setImage(grey); 
          
        VoteHidden.setText("3");
        UneNote=3; 
    }

    @FXML
    private void getinDOC(MouseEvent event) throws FileNotFoundException, IOException {
         //Path path = Paths.get("C:/Users/crist/Documents/GitHub/Pi-java4/src/icons/some.docx");
	XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        //////////////
     
        String LeText= "         Nom: "+nom.getText()+
                "\n Proposée par: "+username.getText()+
                "\n Type: "+type.getText()+
                "\n Description: "+description.getText()+
                "\n Nombre de Personne: "+nbPersonne.getText()+
                "\n Cout: "+ cout.getText()+
                "\n Difficulté:"+difficulte.getText()+
                "\n Temps de Préparation: "+Tpreparation.getText()+
                "\n Temps de Préparation:"+Trepos.getText()+
                "\n Temps de Cuisson: "+Tcuisson.getText()+
                "\n Ingrédients: "+ ingredients.getText()+
                "\n Etapes: "+etapes.getText()+
                "\n Astuce: "+astuces.getText();
         for (String str : LeText.split("\n")) {
            
        tmpRun.setText(str);
        tmpRun.addBreak();
        tmpRun.setColor("9966ff"); 
        
        
    }
    
       
        tmpRun.setFontSize(18);
        
        document.write(new FileOutputStream(new File("C:/wamp64/www/java_DOC/ms"+idrecette.getText()+".docx")));

        File fileToPrint = new File("C:/wamp64/www/java_DOC/ms"+idrecette.getText()+".docx");
		Desktop.getDesktop().print(fileToPrint);
	
    ///////////////////////Ref
   
    }

  
    
}
