/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import entities.BCrypt;
import entities.FosUser;
import java.util.Random;
import entities.User;
import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.internet.InternetAddress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import service.SendMail;
import service.UserService;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class RegisterController implements Initializable {

    @FXML
    private Button connexion;
    @FXML
    private PasswordField mdp1;
    @FXML
    private PasswordField mdp2;
    @FXML
    private TextField email;
    @FXML
    private TextField nomuser;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Button Btnvalid;
    UserService vi = new UserService();
//   String ch= vi.activationcode();
//    String ch= activationcode();
//get In
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    @FXML
    private TextField prenomuser;
    String result;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ObservableList<String> list = FXCollections.observableArrayList("ROLE_RESPONSABLE", "ROLE_USER");

            role.setItems(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void authentifier(ActionEvent event) throws SQLException, IOException {

        String nameuser = nomuser.getText();
        String prenomuserr = prenomuser.getText();
        String emailuser = email.getText();
        String mdp1user = mdp1.getText();
//        String mdp2user = mdp2.getText();
        String mdp2user = BCrypt.hashPassword(mdp2.getText());
        String roleuser = role.getSelectionModel().getSelectedItem();

        if (nameuser.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insérer votre nom");
            alert.setHeaderText("Insérer votre nom");
            alert.setContentText("Insérer votre nom");

            alert.showAndWait();

        } else if (prenomuserr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insérer votre prénom");
            alert.setHeaderText("Insérer votre prénom");
            alert.setContentText("Insérer votre prénom");

            alert.showAndWait();
        } else if (!mdp1user.equals(mdp2user)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("mots de passe non identique !");
            alert.setHeaderText("mots de passe non identique !");
            alert.setContentText("mots de passe non identique !");

            alert.showAndWait();
        } else if (emailuser.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insérer votre email");
            alert.setHeaderText("Insérer votre email");
            alert.setContentText("Insérer votre email");

            alert.showAndWait();
        } else if (role.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Veuillez choisir votre role");
            alert.setHeaderText("Veuillez choisir votre role");
            alert.setContentText("Veuillez choisir votre role");

            alert.showAndWait();
        } else {
            User p = new User(nameuser, emailuser, mdp2user, roleuser);
//            String ch="123";
            String ch = UserService.getInsatance().activationcode();
            SendMail sm = new SendMail(p.getEmail(), "Activez votre compte !", "Bonjour  " + p.getUsername() + " " + " Veuillez entrer ce code :" + ch);
            sm.msgEnvoye();
            System.out.println(sm.msgEnvoye());
            int length = sm.msgEnvoye().length();
            result = sm.msgEnvoye().substring(length - 8, length);
            System.out.println(result);

            /* Parent list_page_parent = FXMLLoader.load(getClass().getResource("confirmCompte.fxml"));
            ConfirmCompteController confirmComptecontroller = new ConfirmCompteController();
            confirmComptecontroller.getString(ch);
             */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmCompte.fxml"));
            Parent parent = (Parent) loader.load();
//            ConfirmCompteController confirmComptecontroller = new ConfirmCompteController();
//            confirmComptecontroller.getString(ch);

            Scene list_page_scene = new Scene(parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//		app_stage.hide(); //optional
            app_stage.setScene(list_page_scene);
            app_stage.show();

            //User p=new User( nameuser, nameuser, emailuser, emailuser, 0, mdp2user);
            System.out.println(p);
            UserService userService = new UserService();
            userService.add(p);
            //UserService.getInstance().add(p);

            System.out.println("Email sent");
//		     try {
//            ConfirmCompteController c= new ConfirmCompteController();
//            
//            
//            if(myfunction().equals(c.textCode())){
//                Alert alert1 = new Alert(Alert.AlertType.ERROR);
//                
//                alert1.setTitle("Congratulations ");
//                alert1.setHeaderText("Code valide! ");
//                alert1.setContentText("Compté activé! ");
//                
//                alert1.showAndWait();
//            }else{
//                Alert alert1 = new Alert(Alert.AlertType.ERROR);
//                
//                alert1.setTitle("Code non valide");
//                alert1.setHeaderText("Code non valide! ");
//                alert1.setContentText("Code non valide");
//                alert1.showAndWait();  
//            } } catch (SQLException ex) {
//            Logger.getLogger(ConfirmCompteController.class.getName()).log(Level.SEVERE, null, ex);
//        }				

        }

    }

//     public String chaine1(){
//         
//         return  nomuser.getText();
//   
//        
//     }
    public String myfunction() {
        String nameuser = nomuser.getText();
        String prenomuserr = prenomuser.getText();
        String emailuser = email.getText();
        String mdp1user = mdp1.getText();
        String mdp2user = mdp2.getText();
        String roleuser = role.getSelectionModel().getSelectedItem();
        //label.setText(code);
        User p = new User(nameuser, emailuser, mdp2user, roleuser);
//            String ch="123";
        String ch;
        try {
            ch = UserService.getInsatance().activationcode();
            SendMail sm = new SendMail(p.getEmail(), "Activez votre compte !", "Bonjour  " + p.getUsername() + " " + " Veuillez entrer ce code :" + ch);
            sm.msgEnvoye();
            System.out.println(sm.msgEnvoye());
            int length = sm.msgEnvoye().length();
            return sm.msgEnvoye().substring(length - 8, length);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void goFb(MouseEvent event) throws IOException {
//String baseUrl = "https://www.google.com";

        String appSecret = "ac0268eb32661033f3550a2e286aa46";
        String domain = "http://localhost";
        String appId = "159318941563056";
        String auth = "http://graph.facebook.com/oauth/authorize?type=user_agent&client_id=" + appId + "&redirect_uri=" + domain + "email";
        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");

//WebDriver wd =new ChromeDriver();
//wd.get(baseUrl); 
        WebDriver dr1 = new ChromeDriver();
//        dr1.get(baseUrl);
        String accessToken = null;
        dr1.get(auth);
        while (true) {
            if (!dr1.getCurrentUrl().contains("www.facebook.com")) {

                String url = dr1.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                FacebookClient fbClient = new DefaultFacebookClient(accessToken, appSecret, com.restfb.Version.UNVERSIONED);
                User user = fbClient.fetchObject("me", User.class);
                User m = new User();
                UserService memberService;
                try {
                    memberService = UserService.getInsatance();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
                m.setUsername(user.getUsername());

                if (dr1.getCurrentUrl().contains("localhost")) {
                    return;
                }

                dr1.quit();
                dr1 = null;
            }
        }
    }

    @FXML
    private void connexion(ActionEvent event) {
         Parent pane = null;
        try {
            pane = FXMLLoader.load(
//                    getClass().getResource("AfficheListProduits.fxml"));
                    getClass().getResource("InterfaceLogin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
        
    }
    

    @FXML
    private void authentifier(MouseEvent event) {
    }

    

}
