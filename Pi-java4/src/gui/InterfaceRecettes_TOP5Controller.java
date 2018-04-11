/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Recette;
import entities.Vote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.RecetteService;
import service.VoteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceRecettes_TOP5Controller implements Initializable {

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
    private Pane R1;
    @FXML
    private Pane R2;
    @FXML
    private Pane R3;
    @FXML
    private Pane R4;
    @FXML
    private Pane R5;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private Text idrecette1;
    @FXML
    private Text idrecette2;
    @FXML
    private Text idrecette3;
    @FXML
    private Text idrecette4;
    @FXML
    private Text idrecette5;
    @FXML
    private Text nomR3;
    @FXML
    private Text nomR4;
    @FXML
    private Text nomR5;
    @FXML
    private Text nomR1;
    @FXML
    private Text nomR2;
    @FXML
    private Text usernameR1;
    @FXML
    private Text usernameR2;
    @FXML
    private Text usernameR3;
    @FXML
    private Text usernameR4;
    @FXML
    private Text usernameR5;
    @FXML
    private Text ScoreR1;
    @FXML
    private Text ScoreR2;
    @FXML
    private Text ScoreR3;
    @FXML
    private Text ScoreR4;
    @FXML
    private Text ScoreR5;
        Vote vot= new Vote();
        VoteService VS = new VoteService();
        Recette recette = new Recette();
        RecetteService RS = new RecetteService();
    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // TOP1
        idrecette1.setText(String.valueOf(RS.findById(VS.TOP1()).getId()));
        usernameR1.setText(RS.findById(VS.TOP1()).getIduser().getUsername());
        nomR1.setText(RS.findById(VS.TOP1()).getNom());
        //image1.setImage(new Image(RS.findById(VS.TOP1()).getNom_image()));
        ScoreR1.setText(String.valueOf(VS.getScoreVote(RS.findById(VS.TOP1()).getId())));
         try{ 
            String imageFile = (RS.findById(VS.TOP1()).getNom_image());
            System.out.println(imageFile);
            Image imageA = new Image(imageFile);
           image1.setImage(imageA);
         }
        catch(Exception e){
            Image imageB = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
            image1.setImage(imageB);
        }
        //TOP2
        idrecette2.setText(String.valueOf(RS.findById(VS.TOP2()).getId()));
        usernameR2.setText(RS.findById(VS.TOP2()).getIduser().getUsername());
        nomR2.setText(RS.findById(VS.TOP2()).getNom());
        ScoreR2.setText(String.valueOf(VS.getScoreVote(RS.findById(VS.TOP2()).getId())));
         try{ 
            String imageFile = (RS.findById(VS.TOP2()).getNom_image());
            System.out.println(imageFile);
            Image imageA = new Image(imageFile);
           image2.setImage(imageA);
         }
        catch(Exception e){
            Image imageB = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
            image2.setImage(imageB);
        }
         //TOP3
        idrecette3.setText(String.valueOf(RS.findById(VS.TOP3()).getId()));
        usernameR3.setText(RS.findById(VS.TOP3()).getIduser().getUsername());
        nomR3.setText(RS.findById(VS.TOP3()).getNom());
        ScoreR3.setText(String.valueOf(VS.getScoreVote(RS.findById(VS.TOP3()).getId())));
         try{ 
            String imageFile = (RS.findById(VS.TOP3()).getNom_image());
            System.out.println(imageFile);
            Image imageA = new Image(imageFile);
           image3.setImage(imageA);
         }
        catch(Exception e){
            Image imageB = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
            image3.setImage(imageB);
        }
         //TOP4
        idrecette4.setText(String.valueOf(RS.findById(VS.TOP4()).getId()));
        usernameR4.setText(RS.findById(VS.TOP4()).getIduser().getUsername());
        nomR4.setText(RS.findById(VS.TOP4()).getNom());
        ScoreR4.setText(String.valueOf(VS.getScoreVote(RS.findById(VS.TOP4()).getId())));
         try{ 
            String imageFile = (RS.findById(VS.TOP4()).getNom_image());
            System.out.println(imageFile);
            Image imageA = new Image(imageFile);
           image4.setImage(imageA);
         }
        catch(Exception e){
            Image imageB = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
            image4.setImage(imageB);
        }
         //TOP5
        idrecette5.setText(String.valueOf(RS.findById(VS.TOP5()).getId()));
        usernameR5.setText(RS.findById(VS.TOP5()).getIduser().getUsername());
        nomR5.setText(RS.findById(VS.TOP5()).getNom());
        ScoreR5.setText(String.valueOf(VS.getScoreVote(RS.findById(VS.TOP5()).getId())));
         try{ 
            String imageFile = (RS.findById(VS.TOP5()).getNom_image());
            System.out.println(imageFile);
            Image imageA = new Image(imageFile);
           image5.setImage(imageA);
         }
        catch(Exception e){
            Image imageB = new Image("file:/C:/wamp64/www/java_DOC/mscupcake2.jpg");
            image5.setImage(imageB);
        }         
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
    private void goToR1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
        InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(RS.findById(VS.TOP1()));
   
    }

    @FXML
    private void goToR2(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
        InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(RS.findById(VS.TOP2()));
    }

    @FXML
    private void goToR3(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
        InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(RS.findById(VS.TOP3()));
    }

    @FXML
    private void goToR4(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
        InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(RS.findById(VS.TOP4()));
    }

    @FXML
    private void goToR5(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceRecettes_AfficherUneR_1.fxml"));

         Parent root = loader.load();
                
               anco.getScene().setRoot(root);
        InterfaceRecettes_AfficherUneR_1Controller controller = 
        loader.<InterfaceRecettes_AfficherUneR_1Controller>getController();
        controller.initData(RS.findById(VS.TOP5()));
    }
}
