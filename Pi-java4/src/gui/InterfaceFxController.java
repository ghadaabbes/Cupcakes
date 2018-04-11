/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import static com.sun.javafx.fxml.expression.Expression.and;
import entities.Categorie;
import entities.Patisserie;
import entities.Produit;
import entities.Promotion;
import service.ServicePatisseries;
import service.ServiceProduits;
import service.ServicePromotion;
import utils.DataSource;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.imageio.ImageIO;
import static javax.management.Query.and;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
//import utils.SendMessage;
//import utils.SendSMS2;

/**
 * FXML Controller class
 *
 * @author Ghada
 */

public class InterfaceFxController implements Initializable {

    ServicePromotion vi = new ServicePromotion();
private File file;
    private BufferedImage bufferedImage;
    private Image image;
    private String imagePath;
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    @FXML
    private ComboBox<Patisserie> idpatisserie;
    @FXML
    private ComboBox<Categorie> idCategorie;
    @FXML
    private ComboBox<Produit> idProduit;
    @FXML
    private Button idPromoAdd;
//    ObservableList<String> list=FXCollections.observableArrayList("Masmoudi","Hechicha");
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField pourcentage;
    @FXML
    private ImageView imgViewAttach;
    @FXML
    private Button btnAttach;
   

     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

ServicePatisseries servicePatisseries = new ServicePatisseries();
         idpatisserie.getItems().addAll(servicePatisseries.getAll());
   
//        try {
//            //        // TODO
//
//
//            String query = "Select * from Produit";
//            
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                idProduit.getItems().add(rs.getString("nom"));
//
//            }
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @FXML
    private void selectPatisserie(ActionEvent event) {
                idProduit.getItems().clear();
        ServicePatisseries servicePatisserie = new ServicePatisseries();
idCategorie.getItems().setAll(servicePatisserie.getCategorie(idpatisserie.getSelectionModel().getSelectedItem())) ;
//        String s = idpatisserie.getSelectionModel().getSelectedItem();
//        String sql = "Select * from patisserie where idPatisserie='" + s + "'";
//        String query = "SELECT * FROM categorie where categorie.patisserie_id=' "+ s + "'";
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//
//                idCategorie.getItems().setAll(rs.getString("nom"));
//            }
//        }catch (SQLException ex) {
//                    Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//        if(evt.getStateChange()==ItemEvent.SELECTED)
//        {
//            if(this.idpatisserie.getSelectionModel().getSelectedIndex()>0)
//            {
//                
//            }
//idCategorie.getSelectionModel().clearSelection();
//
//        String patisserieId = idpatisserie.getSelectionModel().getSelectedItem();
//        Integer pt2 = ServicePatisseries.getInstance().get(new Patisserie(patisserieId)).getIdPatisserie();
//        ArrayList<Categorie> list = ServicePatisseries.getInstance().getData(pt2);
//       
//        for(int i = 0; i < list.size(); i++){
////            idCategorie.getItems().add(list.get(i).getNom());
//            while (rs.next()) {
//                idCategorie.getItems().add(list.get(i).getNom());
//
//            }
//       }
//idpatisserie.valueProperty().addListener((obs, oldValue, newValue) -> {
//    if ( newValue== null) {
//        idCategorie.getItems().clear();
//        idCategorie.setDisable(true);
//    } else {
//        // sample code, adapt as needed:
////        List<State> states = stateDAO.getStatesForCountry(newValue);
//                try {
//                    //        // TODO
//
//                    String query = "SELECT * FROM categorie, patisserie WHERE categorie.patisserie_id=patisserie.idPatisserie GROUP BY categorie.nom";
//
//                    stmt = conn.createStatement();
//                    rs = stmt.executeQuery(query);
//                    while (rs.next()) {
//                        idCategorie.setDisable(true);
//                        idCategorie.getItems().setAll(rs.getString("nom"));
////                 idCategorie.getItems().setAll(rs.getString("nom"));       
//                idCategorie.setDisable(false);
//
//
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//        });


    }

    @FXML
    private void selectCategorie(ActionEvent event) {
        ServiceProduits serviceProduits = new ServiceProduits();
        idProduit.getItems().clear();
        idProduit.getItems().addAll(serviceProduits.getAll(idCategorie.getSelectionModel().getSelectedItem()));
    }

    @FXML
    private void selectProduit(ActionEvent event) {


    }

    @FXML
    private void PromoAdd(ActionEvent event) {
        Blob blob;
//        VoiceUtils v=new VoiceUtils("kevin16");
        try {
        
            blob = new SerialBlob(convertFileContentToBlob(imagePath));
            imagePath = file.getAbsolutePath();
            Promotion promotion = new Promotion(idpatisserie.getSelectionModel().getSelectedItem(),
            idProduit.getSelectionModel().getSelectedItem(),Date.valueOf(date_debut.getValue()),
            Date.valueOf(date_fin.getValue()),Integer.valueOf(pourcentage.getText()),blob,imagePath);
            double r=promotion.getProduitId().getPrix()-promotion.getProduitId().getPrix()*promotion.getPourcentage()/100;
           String ch=Integer.toString((int) r);
           java.util.Date current_date= new java.util.Date ();
           java.util.Date date_actuel= new java.sql.Date(current_date.getDate());
           // create a java calendar instance
Calendar calendar = Calendar.getInstance();


           // create a java calendar instance
java.util.Date currentDate = calendar.getTime();
//Date date = Date.from(date_debut.atStartOfDay(ZoneId.systemDefault()).toInstant());
Date d1 =Date.valueOf(date_debut.getValue());
Date d2 =Date.valueOf(date_fin.getValue());
// get a java date (java.util.Date) from the Calendar instance.
// this java date will represent the current date, or "now".


// now, create a java.sql.Date from the java.util.Date
java.sql.Date date = new java.sql.Date(currentDate.getTime());
           if (currentDate.before(d1)){
           
           }
          if (idpatisserie.getSelectionModel().getSelectedItem()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Veuillez choisir une patisserie");
            alert.setHeaderText("Veuillez choisir une patisserie");
            alert.setContentText("Veuillez choisir une patisserie");

            alert.showAndWait();

        } else if (idCategorie.getSelectionModel().getSelectedItem()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Veuillez choisir une catégorie");
            alert.setHeaderText("Veuillez choisir une catégorie");
            alert.setContentText("Veuillez choisir une catégorie");

            alert.showAndWait();
        } else if (idProduit.getSelectionModel().getSelectedItem()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Veuillez choisir un produit!");
            alert.setHeaderText("Veuillez choisir un produit !");
            alert.setContentText("Veuillez choisir un produit!");

            alert.showAndWait();
        } else if (currentDate.before(d1)  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("La date de debut n' est pas valide!");
            alert.setHeaderText("La date de debut n' est pas valide!");
            alert.setContentText("La date de debut n' est pas valide!");

            alert.showAndWait();
        } else if (d1.compareTo(d2 ) == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("date fin n' est pas valide!");
            alert.setHeaderText("date fin n' est pas valide!");
            alert.setContentText("date fin n' est pas valide!");

            alert.showAndWait();}
        else if (Integer.valueOf(pourcentage.getText())>100 &&Integer.valueOf(pourcentage.getText())<0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("pourcentage n' est pas valide!");
            alert.setHeaderText("pourcentage fin n' est pas valide!");
            alert.setContentText("pourcentage n' est pas valide!");

            alert.showAndWait();
        } else {  
           
           
           
//            SendMessage s = new SendMessage();
//            s.sendSms(" Bonjour Offre Boom chez Cupcakes ! consultez notre nouvelle promotion de produit "+promotion.getNomProduit()+ " bénéficer de réduction de " + promotion.getPourcentage()+"prix de "+promotion.getProduitId().getPrix()+ " à baisser jusqu' au "+ch ,"20380940");
//         SendSMS2 sm = new SendSMS2();
//        
//            s.sendSms("Promo ", "20380940");
//         String subject = "Offre Boom chez Cupcakes !";
       
//            s.sendSms(" Bonjour Offre Boom chez Cupcakes ! consultez notre nouvelle promotion de produit "+promotion.getNomProduit()+ " bénéficer de réduction de " + promotion.getPourcentage()+"prix de "+promotion.getProduitId().getPrix()+ " à baisser jusqu' au "+ch ,"20380940");
//         SendSMS2 sm = new SendSMS2();
//        
//            s.sendSms("Promo ", "20380940");
//         String subject = "Offre Boom chez Cupcakes !";
//      sm.SendSms(subject+" | "+"Bonjour Offre Boom chez Cupcakes ! consultez notre nouvelle promotion de produit "+promotion.getNomProduit()+ " bénéficer de réduction de " + promotion.getPourcentage()+"prix de "+promotion.getProduitId().getPrix()+ " à baisser jusqu' au " + ch,"20380940");
            } vi.ajouterPromotion(promotion);
              TrayNotification tray = new TrayNotification("Promotion crée !", "avec succée", NotificationType.SUCCESS);
        tray.showAndDismiss(javafx.util.Duration.seconds(2));  
         try {
             
			// Construct data
			String apiKey = "apikey=lV+Sx8xKoqo-lKDvDyu5UCOmg5BmRHx5Ijrks52osY" ;
			String message = "&message=Promotion" ;
			String sender = "&sender=Cupackes" ;
                        String numbers = "&numbers=+21620380940";
                	
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				//stringBuffer.append(line);
                                JOptionPane.showMessageDialog(null, "message"+line);
                                

                        String[] msg={"Restaurant ajouté!"};
//                                    v.sayMultiple(msg);
                                
			}
			rd.close();
                        System.out.println("envoyé");
			
			//return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
                        JOptionPane.showMessageDialog(null, e);
			//return "Error "+e;
		}
//        SendMessage s = new SendMessage();
//        s.sendSms("hello", "20380940");

        } catch (IOException | SQLException ex ) {
            Logger.getLogger(InterfaceFxController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
      Stage stage = (Stage) idPromoAdd.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void btnAttachOnClick(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png")
        );

        fileChooser.setTitle("Choisir une Image");

        file = fileChooser.showOpenDialog(null);

        if (file != null) {
            System.out.println(file);
            bufferedImage = ImageIO.read(file);
           
            image = SwingFXUtils.toFXImage(bufferedImage, null);
          
            imgViewAttach.setImage(image);
            imagePath = file.getAbsolutePath();
             String imageFile=file.toURI().toString();
        }
        
    }

    public static byte[] convertFileContentToBlob(String filePath) throws IOException {
	// create file object
	File file = new File(filePath);
	// initialize a byte array of size of the file
	byte[] fileContent = new byte[(int) file.length()];
	FileInputStream inputStream = null;
	try {
		// create an input stream pointing to the file
		inputStream = new FileInputStream(file);
		// read the contents of file into byte array
		inputStream.read(fileContent);
	} catch (IOException e) {
		throw new IOException("Unable to convert file to byte array. " + e.getMessage());
	} finally {
		// close input stream
		if (inputStream != null) {
			inputStream.close();
		}
	}
	return fileContent;
}


}
