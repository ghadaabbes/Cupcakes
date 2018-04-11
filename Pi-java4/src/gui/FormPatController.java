/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.Animation;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import entities.Patisserie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import service.PatisserieService;
import utils.Session;


/**
 * FXML Controller class
 *
 * @author CSS
 */
public class FormPatController implements Initializable,  MapComponentInitializedListener {
   private GoogleMap map;
    @FXML
    private GoogleMapView mapView;
    private Marker marker;
     @FXML
    private TextField altitude;

    @FXML
    private TextField langitude;
    private AnchorPane anco;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tadresse;
    @FXML
    private TextField tdescription;
    @FXML
    private Button btnimg;
    @FXML
    private ImageView img;
    @FXML
    private Button btnadd;
    String imageFile;
     PatisserieService Ps = new PatisserieService();
    Patisserie p = new Patisserie();
    @FXML
    private ImageView acceuil;
    @FXML
    private ImageView logout;
    @FXML
    private Label LabelAlert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     LabelAlert.setText("");
         mapView.addMapInializedListener(this);
        // TODO
    }   
          


    @FXML
    private void addpat(ActionEvent event) throws IOException {
        LabelAlert.setText("");
         int test=0;
      //  System.out.println(img.getImage());
      Patisserie P1= new Patisserie();
     
       if(valide(tnom.getText())){
        P1.setNom(tnom.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
       
      
       if(valide(tadresse.getText())){
        P1.setAdresse(tadresse.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
      
       if(valide(tdescription.getText())){
        P1.setDescription(tdescription.getText());
         }else{
             test++;
             LabelAlert.setText("Veuillez Remplir Tout les champs !");
         }
      P1.setUser(Session.LoggedUser);

      P1.setLongitude(langitude.getText());
      P1.setAltitude(altitude.getText());
     P1.setNomImage(imageFile);
      
//                if(valide(P1.getNomImage())) {
//       P1.setNomImage(P1.getNomImage()); }
//          else {
//               test++;
//              LabelAlert.setText("Veuillez Remplir Tout les champs !");
//          }
//       

         
       //   System.out.println("ajoute");
        if(test==0)
        {  
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
            alert.setHeaderText("Confirmer l'ajout de votre Patisserie!");
            Optional<ButtonType> result = alert.showAndWait(); 

           

            if (result.get() == ButtonType.OK )/*{ if( Ps.findByUser(Session.LoggedUser) != null )*/ {
               
//            alert.setTitle("");
//            alert.setHeaderText("Vous possedez deja une patisserie");
//         
//            } else {


                System.out.println("equals");
               Ps.add(P1);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EspacePat.fxml"));
                Parent root = loader.load();
             //  anco.getScene().setRoot(root); 
               
                    Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();}}
             
           
       else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Veuillez Remplir tous les champs afin d'ajouter votre patisserie");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
                System.out.println("ok");
            }
       }        
          
          
      
    }
  


    @FXML
    private void uploadimage (ActionEvent event) throws MalformedURLException {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
          
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);

            img.setImage(image);
            
        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void acceuil(MouseEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceResponsable.fxml"));
                
                Parent root = loader.load();
                    Scene scene = new Scene(root);  
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

               //anco.getScene().setRoot(root);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
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

    @Override
    public void mapInitialized() {
         System.out.println("here");
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(33.8869, 9.5375))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(6);

        map = mapView.createMap(mapOptions);

        map.addUIEventHandler(UIEventType.click, (jso) -> {
            System.out.println("click");
            JSObject ob = (JSObject) jso.getMember("latLng");
            System.out.println();
            Double lat = Double.valueOf(ob.call("lat").toString());
            Double lng = Double.valueOf(ob.call("lng").toString());
            
            GeocodingService s = new GeocodingService();
            s.reverseGeocode(lat, lng, (grs, gs) -> {
                if (gs.equals(gs.OK)) {
                    LatLong clickedLocation = new LatLong(lat, lng);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(clickedLocation);
                    markerOptions.animation(Animation.DROP);
                    if (marker != null) {
                        map.removeMarker(marker);
                        marker = new Marker(markerOptions);
                        map.addMarker(marker);
                    } else {
                        marker = new Marker(markerOptions);
                        map.addMarker(marker);

                    }
                    String adress = grs[0].getAddressComponents().get(1).getLongName() + ", " + grs[0].getAddressComponents().get(2).getLongName();
                    tadresse.setText(adress);
                    
                    langitude.setText(lng.toString());
                    altitude.setText(lat.toString());
                    Patisserie p=new Patisserie();
                    p.setAdresse(tadresse.getText());
                 p.setAltitude(altitude.getText());
                 p.setLongitude(langitude.getText());
                 
                 
                    
                    System.out.println(grs[0].getAddressComponents().get(1).getLongName() + ", " + grs[0].getAddressComponents().get(2).getLongName());

                }
            });

        });
    }
    
    }
  

    

