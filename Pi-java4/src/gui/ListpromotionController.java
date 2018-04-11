/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.Promotion;
import java.awt.image.BufferedImage;
//import java.awt.Image;
import javafx.scene.image.Image ;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.image.ImageView;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import javax.swing.text.html.ImageView;
import service.ServiceProduits;
import service.ServicePromotion;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class ListpromotionController implements Initializable {

    @FXML
    private AnchorPane acServeurMainContent;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnAjouter;
    @FXML
    private TableColumn<Promotion, String> tblClmNom;
    @FXML
    private TableColumn<Promotion, Double> tblClmPrixAvant;
    @FXML
    private TableColumn<Promotion, Integer> tblClmpourcentage;
    @FXML
    private TableColumn<Promotion, Double> tblClmprixvente;
    @FXML
    private TableColumn<Promotion, Button> tblClmop;
    @FXML
    private TableView<Promotion> tblpromo;
    @FXML
    private TableColumn<Promotion,Date> tblClmfin;
    private File file;
    private BufferedImage bufferedImage;
    private Image image;
    private String imagePath;
    final Tooltip tooltip = new Tooltip();
//    Integer n=tblpromo.getSelectionModel().getSelectedItem().getId();
  ServicePromotion serveur = new ServicePromotion();
   DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    final TableCell cell = new TableCell() ;
    ObservableList<Promotion> data = FXCollections.observableArrayList();
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    private TableColumn<Promotion,Integer> ID;
    @FXML
    private TableColumn<Promotion,Integer> IDt;
 /*    
* Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
      
     viewAll();
        
        
    }   
    void viewAll() {
        ServicePromotion s = new ServicePromotion();
        IDt.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id"));
        tblClmfin.setCellValueFactory(new PropertyValueFactory<>("date_fin_promotion"));
        tblClmpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        tblClmfin.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateFinPromotion()));
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
        tblClmNom.setCellValueFactory(new Callback<CellDataFeatures<Promotion, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Promotion, String> param) {
                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
            }
        });
        tblClmop.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
            Button b;

            @Override
            public ObservableValue<Button> call(CellDataFeatures<Promotion, Button> param) {
                return new SimpleObjectProperty(param.getValue().getImage2());
            }
        });

        tblClmPrixAvant.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(CellDataFeatures<Promotion, Double> param) {
//Double d=param.getValue().getProduitId().getPrix();
        //d = Math.floor(d * 100) / 100;
        double x=param.getValue().getProduitId().getPrix();
DecimalFormat df = new DecimalFormat("#.##");
String dx=df.format(x);
x=Double.valueOf(dx);
                return new SimpleDoubleProperty(x);

            }
        });
        tblClmprixvente.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(CellDataFeatures<Promotion, Double> param) {
Double d=param.getValue().getProduitId().getPrix() - ((param.getValue().getProduitId().getPrix() / 100) * param.getValue().getPourcentage());
        d = Math.floor(d * 100) / 100;
                return new SimpleDoubleProperty(d);

            }
        });

        tblpromo.setItems(s.getAllForResponsable());
    }


    @FXML
    private void tfSearchOnKeyReleased(KeyEvent event) {
        ServicePromotion ss = new ServicePromotion();
        tblpromo.setItems(ss.getAllBynom(tfSearch.getText()));
        tblpromo.refresh();
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
//        viewAll();
//       tblpromo.refresh();
    }

    @FXML
    private void btnAjouterOnAction(ActionEvent event) {
        
        InterfaceFxController acc = new InterfaceFxController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/gui/interfaceFx.fxml"));
        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
           InterfaceFxController addAjoutController = fXMLLoader.getController();
//            addAjoutController.btnModifier.setVisible(false);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListpromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnSupprimerOnAction(ActionEvent event)  {

        if (!tblpromo.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Etes-vous sûr de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServicePromotion iss = new ServicePromotion();
//                int id=Integer.parseInt(tfSearch.getAccessibleHelp());

                iss.supprimerPromotion(tblpromo.getSelectionModel().getSelectedItem());
                viewAll();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Veuillez Selectionner une promotion!");
            alert.showAndWait();
        }
    }
    @FXML
    private void btnModifierOnAction(ActionEvent event) throws IOException {
        
       if (!tblpromo.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Etes-vous sûr de vouloir modifier une promotion ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServicePromotion iss = new ServicePromotion();
        ModifPromoController acc = new ModifPromoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        
        fXMLLoader.setLocation(getClass().getResource("/gui/ModifPromo.fxml"));
         
        
       
            fXMLLoader.load();
            ModifPromoController modif= fXMLLoader.getController();
            modif.myData(tblpromo.getSelectionModel().getSelectedItem());
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
          ModifPromoController addAjoutController = fXMLLoader.getController();
          
//                addServeurController.tfLocation.setText(tblserveur.getSelectionModel().getSelectedItem().getNom());
//            addAjoutController.btnModifier.setVisible(false);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
          
       
       
         viewAll();
       

} else {
                // ... user chose CANCEL or closed the dialog
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Veuillez Selectionner une promotion!");
            alert.showAndWait();
        }

    }
    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
       
    }

    private ObservableList<Promotion> getPromotions() {

        ObservableList<Promotion> lft = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM `promotion`"+
             "SELECT nom FROM produit inner JOIN promotion on promotion.produit_id=produit.idProduit";

            PreparedStatement src = cnx.getConnection().prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);
         
            while (res.next()) {
                Promotion c = new Promotion();
//                Produit c2 = new Produit();
//                c2.setNom(res2.getString(2));
                c.setDateFinPromotion(res.getDate(6));
                c.setPourcentage(res.getInt(7));

                lft.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e);
        }
        return lft;

    }
    public int idget()
    { if (btnModifier.isPressed())
    {return tblpromo.getSelectionModel().getSelectedItem().getId();}
    return tblpromo.getSelectionModel().getSelectedItem().getId();
    }     
public Patisserie patget()
    {
    return tblpromo.getSelectionModel().getSelectedItem().getPatisserieId();
    }     
    public Categorie catget()
    {
    return tblpromo.getSelectionModel().getSelectedItem().getProduitId().getCategorieid();
    }
    public Produit prodget()
    {
    return tblpromo.getSelectionModel().getSelectedItem().getProduitId();
    }
}
