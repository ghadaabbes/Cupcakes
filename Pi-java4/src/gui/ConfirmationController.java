/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaMail.EmailAttachmentSender;
import javaMail.SendEmail;
//import javaMail.pdf;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author beryl kristina
 */
public class ConfirmationController implements Initializable {

    @FXML
    private AnchorPane anco;
    @FXML
    private JFXButton pdfe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void creerPdf()
    {
        //pdf.savePdf("facture");
        
    }
    
    public void sendMail()
    {
         String mailFrom = "berylkristina.biedeg@esprit.tn";
        String password = "Allemagne2000";
 
        // message info
        String mailTo = "biedegberyl@gmail.com";
        String subject = "New email with attachments";
        String message = "I have some attachments for you.";
         SendEmail send = new SendEmail();
         
         
        // attachments
        String[] attachFiles = new String[1];
       //attachFiles[0] = "C:/Users/HABOUB/Desktop/althere.jpeg";
        //attachFiles[1] = "C:/Users/HABOUB/Desktop/Prosit_4_Partie1.pdf";
        attachFiles[0] = "‪‪‪‪‪C:/Users/berylkristina/Desktop/Capture.PNG";
       // InputStream input = ConfirmationController.class.getResourceAsStream(attachFiles[0]);
        
        // File file = new File(attachFiles[0]);
       // System.out.println(input.toString());
     
            
            System.out.println("att----------------"+  attachFiles[0]);
            try {
            EmailAttachmentSender.sendEmailWithAttachments( mailFrom, password, mailTo,subject, message, attachFiles);
            System.out.println("Email sent.");
            } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
            }
            
      
    }
}
