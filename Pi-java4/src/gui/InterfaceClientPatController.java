/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.Recette;
import entities.Vote;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

import service.CategorieService;
import service.PatisserieService;
import service.ProduitService;
import service.VoteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author CSS
 */
public class InterfaceClientPatController implements Initializable {

    @FXML
    private AnchorPane anco;
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
    private ImageView CLogoutIcon;
  
   //  ObservableList<Patisserie> Liste_Patisseries = FXCollections.observableArrayList();
    @FXML
    private ImageView acceuil;

    @FXML
    private ImageView btnClose;
 
    @FXML
    private ListView listpat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           PatisserieService ps = new PatisserieService();
          List<Patisserie> listepatisserie = ps.findAll();
           ObservableList<Pane> panes = FXCollections.observableArrayList();
                 for (int i = 0; i < listepatisserie.size(); i++) {
               try {
                   panes.add(layoutListePatisseries(listepatisserie.get(i)));
               } catch (IOException ex) {
                   Logger.getLogger(InterfaceClientPatController.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
               
        listpat.setItems(panes);
        listpat.setSelectionModel(null);
        listpat.getStyleClass().addAll("visible-xs", "visible-sm");
        
       
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
    private void Close(MouseEvent event) {
                           Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

  
    
    private Pane layoutListePatisseries(Patisserie cp) throws FileNotFoundException, IOException {

        PatisserieService patisserie = new PatisserieService();
        // Produit pr = new Produit();
        Pane pane = new Pane();
        pane.getStyleClass().add("listViewPr");

          Image image = new Image( "File:\\C:\\wamp\\www\\siw\\web\\images\\"+cp.getNomImage());
        ImageView imagepat = new ImageView();
            
       imagepat.setImage(image);
        imagepat.setFitWidth(120);
        imagepat.setPreserveRatio(true);
        imagepat.setSmooth(true);
        imagepat.setCache(true);
        imagepat.setLayoutX(20);
        imagepat.setLayoutY(10);
        

        //   String format = df.format(cp.getDate_produit());
       // Label userproduit = new Label("ajouter par: " + cp.getU().getUsername());
       // userproduit.setStyle("-fx-font-size: 12px;");
       // userproduit.setLayoutX(10);
       // userproduit.setLayoutY(105);
	
        Label nompat = new Label( cp.getNom());
        nompat.setLayoutX(150);
        nompat.setLayoutY(0);
        nompat.setStyle( "-fx-text-fill: #DB7093;"
             +"-fx-font-family:Arial\n" );
  
        


        Label adressepat = new Label("Adresse : \n" + cp.getAdresse());
       adressepat.setLayoutX(150);
        adressepat.setLayoutY(20);
         adressepat.setStyle( "-fx-text-fill:#808080;");
      

        Label descpat = new Label("Description:\n " + cp.getDescription() );
       descpat.setLayoutX(150);
        descpat.setLayoutY(100);
        descpat.setStyle( "-fx-text-fill:#808080;");
    
        
        


//        Button local = new Button("Cliquer pour voir la localisation");
//        local.getStyleClass().add("btn-accueil");
//        local.setLayoutX(0);
//        local.setLayoutY(130);
//        local.getStyleClass().add("btn-success");
//        local.setStyle(("-fx-background-color: linear-gradient(#ADD8E6,#E6E6FA);\n"
//                + "    -fx-border-width: 1 1 1 1;\n"
//                + "    -fx-border-color:#F08080\n"
//                + "    -fx-font-size: 1.083333em;\n"
//                 + "    -fx-background-radius: 200;\n"
//                + "    -fx-text-fill: #000000;"));
//        
//    local.setOnMouseClicked((MouseEvent event) -> {

            // je vais faire une map statique avec deux valeurs id de produit acheté + quantité 
            //dans panier afficher les produit + quantité choisix 
            // en cas de validation et payement :
            // if quantité choisix = quantité : 
            //requete delete from produit where id_produit = produit_acheté
            //else
            //reqeuet update produit set produit quantité = quantité - quantité_choisix 
            //génération de commande + PDF 
//            listProduitPanierId.add(cp.getIdProduit());
//
//            HashMapProduitPanier.put(cp.getIdProduit(), choixQuantite.getValue());
//
//            HashMapProduitPanier.forEach((k, v) -> {
//                System.out.println("Id de produit " + k + " quantité choisie: " + v);

//            });

        //    listProduits.getItems().remove(cp.getIdProduit() - i);

//            i++;
//
//            System.err.println("DDDD" + i);
//        });

        pane.getChildren().addAll( nompat, imagepat,adressepat, descpat);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 1px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
    }
    
 
//    
//       public void chargerPatisseries()
//    {
//       PatisserieService service = new PatisserieService();
//       List<Patisserie> pat = service.getAll();
//        
//      
//        for (int i = 0; i<pat.size(); i++)
//        {
//           try {
//               FileInputStream input = new FileInputStream("C:\\wamp\\www\\siw\\web\\images\\"+pat.get(i).getNomImage());
//               Image img = SwingFXUtils.toFXImage(ImageIO.read(input), null);
//               ImageView im= new ImageView();
//               
//            im.setImage(img);
//            im.setFitHeight(50);
//            im.setFitWidth(50);
//           
//           GridPane p = new GridPane();
//            p.add(im,0,0);
//            p.add(new Label(pat.get(i).getNom()+" "+pat.get(i).getAdresse()+" "+pat.get(i).getDescription()),0,1);
//           // p.add(bout,0,2);
//            listpatt.add(p,0,i);}
//
//               catch (FileNotFoundException ex) {
//               Logger.getLogger(InterfaceClientPatController.class.getName()).log(Level.SEVERE, null, ex);}
//                catch (IOException ex ) {
//               Logger.getLogger(InterfaceClientPatController.class.getName()).log(Level.SEVERE, null, ex);}
//           
//          }
//     }
}

