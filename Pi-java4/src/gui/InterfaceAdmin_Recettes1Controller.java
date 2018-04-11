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
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import service.VoteService;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceAdmin_Recettes1Controller implements Initializable {

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
    private ImageView imgRecherche;
    @FXML
    private TableView<Recette> Table;
    @FXML
    private TableColumn<Recette, String> username;
    private PieChart myPieChart;
    @FXML
    private Text nb_recettes;
    @FXML
    private Text nb_comments;
    @FXML
    private ImageView ALL_recettes;
    @FXML
    private TextField recherche_recettes;
    @FXML
    private TableColumn<Recette, String> nom;
    @FXML
    private Text nb_votes;
    @FXML
    private PieChart PieChartCout;
    @FXML
    private PieChart PieChartDiff;
    ObservableList<Recette> Liste_Recettes = FXCollections.observableArrayList();
    @FXML
    private BarChart<String,Number> myBarChart;
    @FXML
    private Pane PaneCoutPercentage;
    @FXML
    private Text PasCherPourcentage;
    @FXML
    private Text AdorablePourcentage;
    @FXML
    private Text AssezCherPourcentage;
    @FXML
    private Pane PaneDiffPourcentage;
    @FXML
    private Text FacilePourcentage;
    @FXML
    private Text MoyenPourcentage;
    @FXML
    private Text DifficilePourcentage;
    @FXML
    private Pane PaneDetails;
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
    private Text commentDetails;
    @FXML
    private Text noteDetails;
    @FXML
    private ImageView btnCloseDetails;
   // Connection connection ;
    /**
     * Initializes the controller class.
     */
    /* public void StartConnection(){
    
    connection = DataSource.getInsatance().getConnection();
    } */
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // buildPieChartData();
      
        Admin_Name.setText(Session.LoggedUser.getUsername());
        recherche_recettes.setText("Recherche de recettes...");
        Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.DisplayAll());
        Table.setItems(Liste_Recettes);
       // id.setCellValueFactory(new PropertyValueFactory<>("id"));
       // id.cellFactoryProperty();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        username.setCellValueFactory((TableColumn.CellDataFeatures<Recette, String> param) -> new SimpleStringProperty(param.getValue().getIduser().getUsername()));
        
        nb_recettes.setText(String.valueOf(Session.iRecetteService.NbTotalR()));
        nb_comments.setText(String.valueOf(Session.iCommentaireService.NbTotalC()));
         VoteService vs = new VoteService();
        nb_votes.setText(String.valueOf(vs.NbTotalV()));
            
        MakeBarGraph() ;
        buildPieChartDataCout();
        buildPieChartDataDiff();
        PaneCoutPercentage.setVisible(false);
        PaneDiffPourcentage.setVisible(false);
        PaneDetails.setVisible(false); 
      
             
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
    private void hideRecherche(MouseEvent event) {
        recherche_recettes.setText("");
    }

    @FXML
    private void DisplayAllRecettes(MouseEvent event) {
        Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.DisplayAll());
        Table.setItems(Liste_Recettes);
    }

    @FXML
    private void RechercheRecetteByName(MouseEvent event) {
          String x= recherche_recettes.getText();
        if("".equals(x)){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Tapez le nom que vous voulez chercher");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) { 
                  System.out.println("ok");
                }
        }
        else{
        Liste_Recettes = FXCollections.observableArrayList(Session.iRecetteService.findByNom(x));
        Table.setItems(Liste_Recettes);
        }
    }
  

    
    private void buildPieChartDataCout() {
        ObservableList<PieChart.Data> details =
            FXCollections.observableArrayList(
            new PieChart.Data("Pas cher", Session.iRecetteService.CountCout("Pas cher")),
            new PieChart.Data("Adorable", Session.iRecetteService.CountCout("Adorable")),
            new PieChart.Data("assez cher", Session.iRecetteService.CountCout("assez cher"))
            );
    PieChartCout.setData(details);
    PieChartCout.setLabelLineLength(10);
    
    }
    
    private void buildPieChartDataDiff() {
             ObservableList<PieChart.Data> details =
            FXCollections.observableArrayList(
            new PieChart.Data("Facile", Session.iRecetteService.CountDiff("Facile")),
            new PieChart.Data("Medium", Session.iRecetteService.CountDiff("Medium")),
            new PieChart.Data("Difficile", Session.iRecetteService.CountDiff("Difficile"))
           
            );  
         
    PieChartDiff.setData(details);
    PieChartDiff.setLabelLineLength(10);
    }
    
    private Number Number(int COUT) {
        return COUT ; 
    }
    private void MakeBarGraph() {
     
    final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc;
        bc = new BarChart<>(xAxis,yAxis); 
         ObservableList<XYChart.Series< String,Number>> chartData = FXCollections.observableArrayList();

        XYChart.Series<String,Number> series = new XYChart.Series<>();
       
        xAxis.setLabel("Type");       
       yAxis.setLabel("Nb Recette");
 
      //  XYChart.Series series1 = new XYChart.Series();
      //  series1.setName("Biscuits");       
        series.getData().add(new XYChart.Data("Biscuits", Number(Session.iRecetteService.CountType("Biscuits"))));
           
        
       // XYChart.Series series2 = new XYChart.Series();
        //series2.setName("Chocolat");
        series.getData().add(new XYChart.Data("Chocolat", Number(Session.iRecetteService.CountType("Chocolat"))));
       
        
      //  XYChart.Series series3 = new XYChart.Series();
      //  series3.setName("Gateux et Entremets");
        series.getData().add(new XYChart.Data("Gateux et Entremets", Number(Session.iRecetteService.CountType("Gateux et Entremets"))));

 
       // XYChart.Series series4 = new XYChart.Series();
       // series4.setName("Cremes et Confitures");       
        series.getData().add(new XYChart.Data("Cremes et Confitures", Number(Session.iRecetteService.CountType("Cremes et Confitures"))));
           
        
        //XYChart.Series series5 = new XYChart.Series();
       // series5.setName("Tartes");
        series.getData().add(new XYChart.Data("Tartes",Number(Session.iRecetteService.CountType("Tartes"))));
       
        
        //XYChart.Series series6 = new XYChart.Series();
        //series6.setName("Spécialités Tunisiennes");
        series.getData().add(new XYChart.Data("Spécialités Tunisiennes", Number(Session.iRecetteService.CountType("Spécialités Tunisiennes"))));   
        
       // XYChart.Series series7 = new XYChart.Series();
        //series7.setName("Traiteur(salé)");
        series.getData().add(new XYChart.Data("Traiteur(salé)", Number(Session.iRecetteService.CountType("Traiteur(salé)"))));

 
       // XYChart.Series series8 = new XYChart.Series();
       // series8.setName("Pains et Viennoiseries");       
        series.getData().add(new XYChart.Data("Pains et Viennoiseries", Number(Session.iRecetteService.CountType("Pains et Viennoiseries"))));
           
        
      //  XYChart.Series series9 = new XYChart.Series();
        //series9.setName("Recettes de base");
        series.getData().add(new XYChart.Data("Recettes de base", Number(Session.iRecetteService.CountType("Recettes de base"))));
       
        
       // XYChart.Series series10 = new XYChart.Series();
       // series10.setName("Diététiques");
        series.getData().add(new XYChart.Data("Diététiques", Number(Session.iRecetteService.CountType("Diététiques"))));  
        
        
      // myBarChart.getData().addAll(series1, series2, series3,series4, series5, series6,series7, series8, series9,series10);
           chartData.add(series);
            myBarChart.getData().addAll(chartData);
            
            


   
    }    

    @FXML
    private void HideCoutPerc(MouseEvent event) {
        PaneCoutPercentage.setVisible(false);
    }

    @FXML
    private void ShowCoutPerc(MouseEvent event) {
        PaneCoutPercentage.setVisible(true);
        int C1=Session.iRecetteService.CountCout("Pas cher");
        int C2=Session.iRecetteService.CountCout("Adorable");
        int C3=Session.iRecetteService.CountCout("assezCher");
        int CTotal= C1+C2+C3;
                //Session.iRecetteService.NbTotalR();
        ///////
        double CP1=0.0;
        if(C1==0 || CTotal==0){
            CP1=0;
        }else{
         CP1=((double)C1/(double)CTotal)*100; 
         CP1=(double) Math.round(CP1 * 100) / 100; 	
        }
        //////
        double CP2=0.0;
        if(C2==0 || CTotal==0){
            CP2=0;
        }else{
         CP2=((double)C2/(double)CTotal)*100; 
         CP2=(double) Math.round(CP2 * 100) / 100; 	
        }
        ///////
        double CP3=0.0;
        if(C3==0 || CTotal==0){
            CP3=0;
        }else{
         CP3=((double)C3/(double)CTotal)*100; 
         CP3=(double) Math.round(CP3 * 100) / 100; 	
        }
        ///////
        
        PasCherPourcentage.setText(String.valueOf(CP1)+"%");
        AdorablePourcentage.setText(String.valueOf(CP2)+"%");
        AssezCherPourcentage.setText(String.valueOf(CP3)+"%");
    }

    @FXML
    private void HideDiffPerc(MouseEvent event) {
        PaneDiffPourcentage.setVisible(false);
    }

    @FXML
    private void ShowDiffPerc(MouseEvent event) {
        PaneDiffPourcentage.setVisible(true);
        int D1=Session.iRecetteService.CountDiff("Facile");
        int D2=Session.iRecetteService.CountDiff("Medium");
        int D3= Session.iRecetteService.CountDiff("Difficile");
        int DTotal= D1+D2+D3;
                //Session.iRecetteService.NbTotalR();
        ///////
        double DP1=0.0;
        if(D1==0 || DTotal==0){
            DP1=0;
        }else{
         DP1=((double)D1/(double)DTotal)*100; 
         DP1=(double) Math.round(DP1 * 100) / 100; 	
        }
        //////
        double DP2=0.0;
        if(D2==0 || DTotal==0){
            DP2=0;
        }else{
         DP2=((double)D2/(double)DTotal)*100; 
         DP2=(double) Math.round(DP2 * 100) / 100; 	
        }
        ///////
        double DP3=0.0;
        if(D3==0 || DTotal==0){
            DP3=0;
        }else{
         DP3=((double)D3/(double)DTotal)*100; 
         DP3=(double) Math.round(DP3 * 100) / 100; 	
        }
        ///////
        
        FacilePourcentage.setText(String.valueOf(DP1)+"%");
        MoyenPourcentage.setText(String.valueOf(DP2)+"%");
        DifficilePourcentage.setText(String.valueOf(DP3)+"%");
    }

    @FXML
    private void DetailsRecettes(MouseEvent event) {
         if(Table.getSelectionModel().getSelectedItem()!=null){
         PaneDetails.setVisible(true);
         Recette selectedRecette =Table.getSelectionModel().getSelectedItem();
         nomDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getNom());
             typeDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getType());
             coutDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getCout());
             difficulteDetails.setText(Session.iRecetteService.findById(selectedRecette.getId()).getDifficulte());
             try{ 
                 imageDetails.setImage(new Image(Session.iRecetteService.findById(selectedRecette.getId()).getNom_image()));}
             catch(Exception e){
                 Image image2 = new Image("file:/C:/wamp64/www/java_DOC/mscupcake6.jpg");
                 imageDetails.setImage(image2);
                }
         
             Vote vot= new Vote();
             VoteService VS = new VoteService();
             double LastVote= VS.noteRecette(Session.iRecetteService.findById(selectedRecette.getId()).getId());
             String lastvote= String.valueOf(LastVote) +"/5";
             noteDetails.setText(lastvote); 
             
             commentDetails.setText(String.valueOf(Session.iRecetteService.countCommentOf1Recette(selectedRecette.getId())));
         
         
         
         }
         else{
            PaneDetails.setVisible(false); 
         }
    }

    @FXML
    private void closeDetails(MouseEvent event) {
        PaneDetails.setVisible(false); 
    }

    
}
