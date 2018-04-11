/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Recette;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import service.RecetteService;
import utils.Session;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceClientProfile_AjoutRecetteController implements Initializable {

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
    private TextField nom;
    @FXML
    private ComboBox<String> type;
    @FXML
    private TextArea description;
    @FXML
    private Button AddImage;
    @FXML
    private TextField nbPersonne;
    @FXML
    private ComboBox<String> difficulte;
    @FXML
    private ComboBox<String> cout;
    @FXML
    private TextField Tpreparation;
    @FXML
    private TextField Trepos;
    @FXML
    private TextField Tcuisson;
    @FXML
    private TextArea ingredients;
    @FXML
    private TextArea astuces;
    @FXML
    private TextArea etapes;
     @FXML
    private Button CAjouterButton;
    @FXML
    private Label LabelAlert;
    
    RecetteService Rs = new RecetteService();
    Recette r = new Recette();

    /**
     * Initializes the controller class.
     */
    ObservableList<String> types = FXCollections.observableArrayList("Biscuits","Chocolat","Gateux et Entremets","Cremes et Confitures","Tartes","Spécialités Tunisiennes","Traiteur(salé)","Pains et Viennoiseries","Recettes de base","Diététiques");
    ObservableList<String> couts = FXCollections.observableArrayList("Pas cher","Adorable","assez cher");   
    ObservableList<String> difficultes = FXCollections.observableArrayList("Facile","Medium","Difficile");
    @FXML
    private Label LabelAlertPersonne;
    @FXML
    private Label LabelAlertTemp;
    @FXML
    private Text username;
    @FXML
    private Label LabelImg;
    @FXML
    private ImageView btnClose;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         type.setItems(types);
         cout.setItems(couts);
         difficulte.setItems(difficultes);
         username.setText(Session.LoggedUser.getUsername());
         LabelAlert.setText("");
       //  LabelAlertTemp.setText("");
         LabelImg.setText("test");
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
    if ( "".equals(s))
        v= false ;
    return v ; 
}
private boolean valideTime(String time){
    boolean v =false ;
    if(time.length()==8){
      if(time.indexOf(':')!=-1){
           String filename = time;     // full file name
           String[] parts = filename.split(":");
           String HH=parts[0];
           int foo = Integer.parseInt(HH);
           if(foo>=0 && foo<=60) {
               String time2=time;
               time2 = time2.substring(time2.indexOf(":") + 1); 
                if(time2.indexOf(':')!=-1){
                    String filename2 = time2;     // full file name
 
                    String[] parts2 = filename2.split(":");
                    String mm=parts2[0];
                    int foo2 = Integer.parseInt(mm);
                    if(foo2>=0 && foo2<=60) {
                        String time3=time2;
                        time3 = time3.substring(time3.indexOf(":") + 1); 
                        int foo3 = Integer.parseInt(time3);
                        if(foo3>=0 && foo3<=60) {
                           v=true;
                        }
                    }
                }  
            }
        }
    }
  return v ; 
} 
private boolean validePersonne(String a){
    boolean v =false ;
    try {
     Integer.parseInt(a);
     if (Integer.parseInt(a) >0){
       v=true;
      }
    } catch (NumberFormatException e) {
       v=false;
       System.out.println("Wrong number");
    }
    return v ; 
}
     
    @FXML
    private void AjouterRecette(MouseEvent event) throws MalformedURLException , SQLException, IOException{
       LabelAlert.setText("");
       LabelAlertPersonne.setText("");
       LabelAlertTemp.setText("");
       Recette R1 = new Recette();
       int test=0;
    R1.setIduser(Session.LoggedUser); 
   
       if(valide(nom.getText())){
        R1.setNom(nom.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
                 
        if(type.getValue()!= null){
        R1.setType(type.getValue());
         }else {
              test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
         
         if(valide(description.getText())){
        R1.setDescription(description.getText());
        }else {
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
         
         if(validePersonne(nbPersonne.getText())){
        R1.setNb_personne(Integer.valueOf(nbPersonne.getText()));
        }else {
             test++; 
          LabelAlert.setText("Veuillez Remplir Tout les champs !");
            // LabelAlertPersonne.setText("nombre de personnes doit etre sup à 0");
         }
         
         if(cout.getValue()!= null){
         R1.setCout(cout.getValue());
         }else {
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         } 
         
          if(difficulte.getValue()!=null){
        R1.setDifficulte(difficulte.getValue());
         }else {
              test++; 
              LabelAlert.setText("Veuillez Remplir Tout les champs !");
          }
        
            if(valide(Tpreparation.getText())){
        R1.setTemps_preparation(Time.valueOf(Tpreparation.getText()));
        }else {
                test++;
                LabelAlert.setText("Veuillez Remplir Tout les champs !");
            }
             
           if(valide(Trepos.getText())){
        R1.setTemps_repos(Time.valueOf(Trepos.getText()));
        }else {
              test++;
               LabelAlert.setText("Veuillez Remplir Tout les champs !");
            }
           
        if(valide(Tcuisson.getText())){
          R1.setTemps_cuisson(Time.valueOf(Tcuisson.getText()));
        }else {
              test++; 
              LabelAlert.setText("Veuillez Remplir Tout les champs !");
          }
          
           if(valide(ingredients.getText())){
        R1.setIngredients(ingredients.getText());
         }else {
               test++;
               LabelAlert.setText("Veuillez Remplir Tout les champs !");
           }
           
           if(valide(astuces.getText())){
        R1.setAstuces(astuces.getText());
         }else {
               test++;
               LabelAlert.setText("Veuillez Remplir Tout les champs !");
           }
           
            if(valide(etapes.getText())){
        R1.setEtapes(etapes.getText());
         }else {
                test++;
                LabelAlert.setText("Veuillez Remplir Tout les champs !");
            }
       
          if(valide(r.getNom_image())) {
       R1.setNom_image(r.getNom_image());}
          else {
               test++;
              LabelAlert.setText("Veuillez Remplir Tout les champs !");
          }
       
        if(test==0 && "".equals(LabelAlertPersonne.getText()) && "".equals(LabelAlertTemp.getText()) && "".equals(LabelImg.getText()) )
        {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Confirmer l'ajout de cette Recette! Merci");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
              Rs.add(R1); 
         /////////////////////:// Ref
               
          /////////////////// Ref
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClientProfile_MesRecett.fxml"));
                Parent root = loader.load();
                ChangeItGirls.getScene().setRoot(root); 
            } 
            
         } 
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Veuillez Remplir tous les champs afin d'ajouter votre recettte");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("ok");
            }
       } 
 
    }

    @FXML
    private void addImage(MouseEvent event) throws MalformedURLException, SQLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            String imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            r.setNom_image(imageFile);
           LabelImg.setText("");

        } else {
           LabelAlert.setText("image n'existe pas");
           LabelImg.setText("x");
        } 
      
    }

    @FXML
    private void ControlNom(MouseEvent event) {
       /*    if(valide(nom.getText())){
            LabelAlert.setText("");
         }else{
             
             LabelAlert.setText("entrer un nom !");
         } */
    }

    @FXML
    private void ControlNbPersonne(MouseEvent event) {
          if(validePersonne(nbPersonne.getText())){
             LabelAlertPersonne.setText("");
        }else {
              
          //  LabelAlert.setText("Veuillez Remplir Tout les champs !");
             LabelAlertPersonne.setText("Nombre Personne doit etre sup à 0");
         }
    }

  

    @FXML
    private void ControlTimeP(MouseEvent event) {
             if(valideTime(Tpreparation.getText())){
                   LabelAlertTemp.setText("");   
               }else {
                
                LabelAlertTemp.setText("Temps doit etre sous la forme 00:00:00");
            }
    }

    @FXML
    private void ControlTimeR(MouseEvent event) {
         if(valideTime(Trepos.getText())){
                   LabelAlertTemp.setText("");   
               }else {
                
                LabelAlertTemp.setText("Temps doit etre sous la forme 00:00:00");
            }
    }

    @FXML
    private void ControlTimeC(MouseEvent event) {
         if(valideTime(Tcuisson.getText())){
                   LabelAlertTemp.setText("");   
               }else {
                
                LabelAlertTemp.setText("Temps doit etre sous la forme 00:00:00");
            }
    }

    @FXML
    private void MouseClickClose(MouseEvent event) {
          Stage stage = (Stage) btnClose.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
//////////////////Ref

    
}
