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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.RecetteService;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author Siala
 */
public class InterfaceClientProfile_ModifierRecetteController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private VBox ChangeItGirls;
    @FXML
    private Text username;
    @FXML
    private TextField nom;
    @FXML
    private ComboBox<String> type;
    @FXML
    private TextArea description;
    @FXML
    private Button AddImage;
 //   private Label LabelAlertPersonne;
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
    //private Label LabelAlert;
  //  private Label LabelAlertTemp;
    @FXML
    private ImageView close;
    @FXML
    private Button CModifierButton;

       RecetteService Rs = new RecetteService();
    Recette r= new Recette();

    /**
     * Initializes the controller class.
     */
    ObservableList<String> types = FXCollections.observableArrayList("Biscuits","Chocolat","Gateux et Entremets","Cremes et Confitures","Tartes","Spécialités Tunisiennes","Traiteur(salé)","Pains et Viennoiseries","Recettes de base","Diététiques");
    ObservableList<String> couts = FXCollections.observableArrayList("Pas cher","Adorable","assez cher");   
    ObservableList<String> difficultes = FXCollections.observableArrayList("Facile","Medium","Difficile");
    @FXML
    private Text emptyimageName;
    @FXML
    private Text emptyIdRecette;
    @FXML
    private Text LabelAlert;
    @FXML
    private Text LabelAlertPersonne;
    @FXML
    private Text LabelAlertTemp;
    @FXML
    private Text LabelImg;
   
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.setItems(types);
        cout.setItems(couts);
        difficulte.setItems(difficultes);
        username.setText(Session.LoggedUser.getUsername());
        LabelAlert.setText("");
        LabelAlertPersonne.setText("");
        LabelAlertTemp.setText("");
       //  LabelAlertTemp.setText("");
         LabelImg.setText("");
    }    
     
    @FXML
    private void ModifierRecette(MouseEvent event) throws MalformedURLException , SQLException, IOException{
        LabelAlert.setText("");
       LabelAlertPersonne.setText("");
       LabelAlertTemp.setText("");
       int test=0;
       RecetteService Rs1 = new RecetteService();
       Recette R1 =  new Recette();
       
       R1.setIduser(Session.LoggedUser); 
       R1.setId(Integer.valueOf(emptyIdRecette.getText()));
        
        if(valide(nom.getText())){
            R1.setNom(nom.getText());
            LabelAlert.setText("");
        }else{
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
                 
        if(type.getValue()!= null){
        R1.setType(type.getValue());
        LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
         
        if(valide(description.getText())){
            R1.setDescription(description.getText());
            LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
         
        if(validePersonne(nbPersonne.getText())){
            R1.setNb_personne(Integer.valueOf(nbPersonne.getText()));
            LabelAlert.setText("");
        }else {
            test++; 
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
            // LabelAlertPersonne.setText("nombre de personnes doit etre sup à 0");
        }
         
        if(cout.getValue()!= null){
            R1.setCout(cout.getValue());
            LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        } 
         
        if(difficulte.getValue()!=null){
        R1.setDifficulte(difficulte.getValue());
        LabelAlert.setText("");
        }else {
            test++; 
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
        
        if(valide(Tpreparation.getText())){
            R1.setTemps_preparation(Time.valueOf(Tpreparation.getText()));
            LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
             
        if(valide(Trepos.getText())){
            R1.setTemps_repos(Time.valueOf(Trepos.getText()));
            LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
           
        if(valide(Tcuisson.getText())){
          R1.setTemps_cuisson(Time.valueOf(Tcuisson.getText()));
          LabelAlert.setText("");
        }else {
            test++; 
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
          
        if(valide(ingredients.getText())){
            R1.setIngredients(ingredients.getText());
            LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
           
        if(valide(astuces.getText())){
        R1.setAstuces(astuces.getText());
        LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
           
        if(valide(etapes.getText())){
        R1.setEtapes(etapes.getText());
        LabelAlert.setText("");
        }else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
       
        if(valide(r.getNom_image())) {
           R1.setNom_image(r.getNom_image());
           LabelAlert.setText("");
        }
        else {
            test++;
            LabelAlert.setText("Veuillez Remplir Tout les champs !");
        }
         
            
          /*  Rs1.update(R1); 
            System.out.println("success");
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Recette Modifiée ");
            alert.setHeaderText(null);
           
      
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
           
                
               Stage stage = (Stage)
              close.getScene().getWindow();
    // do what you have to do
    stage.close();
           
        } */
           if(test==0 && "".equals(LabelAlertPersonne.getText()) && "".equals(LabelAlertTemp.getText()) && "".equals(LabelImg.getText()) )
        {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("confirmer la modification de votre recette");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("equals");
               Rs1.update(R1);
              Stage stage = (Stage)
              close.getScene().getWindow();
            // do what you have to do
            stage.close();
            } 
            
         } 
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Veuillez Remplir tous les champs afin de modifier votre recettte");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 

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
            
           emptyimageName.setText( imageFile);
          LabelImg.setText("");

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("file doesn't exist ");
            alert.setHeaderText(null);
           
      
            Optional<ButtonType> result = alert.showAndWait();
           //LabelAlert.setText("file doesn't exist");
           emptyimageName.setText( r.getNom_image());
          LabelImg.setText("");
        } 
      
    }

    @FXML
    private void clickClose(MouseEvent event) {
          Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void ControlNom(MouseEvent event) {
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
        
     void initData(Recette r) {
              
                nom.setText(r.getNom());
                username.setText(r.getIduser().getUsername());
                type.setValue(r.getType());
                description.setText(r.getDescription());
                nbPersonne.setText(String.valueOf(r.getNb_personne()));
                cout.setValue(r.getCout());
                difficulte.setValue(r.getDifficulte());
                Tpreparation.setText(String.valueOf(r.getTemps_preparation()));
                Trepos.setText(String.valueOf(r.getTemps_repos()));
                Tcuisson.setText(String.valueOf(r.getTemps_cuisson()));
                ingredients.setText(r.getIngredients());
                etapes.setText(r.getEtapes());
                astuces.setText(r.getAstuces());
              //  String ImageFile=r.getNom_image();
              emptyimageName.setText(r.getNom_image());
              emptyIdRecette.setText(String.valueOf(r.getId()));
              
                
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

}