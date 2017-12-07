package com.fortw.bagoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Ramon
 */
public class HoofdSchermSchadeAfhandelaarController implements Initializable {

    @FXML
    private Button knopClaim1;
    @FXML
    private Button knopClaim2;
    @FXML
    private Button knopClaim;
    @FXML
    private Button knopClaim3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClaimAction(ActionEvent event) {
    }

    @FXML
    private void handleMailAction(ActionEvent event) {
        //start van de email code
        final String username = "4TWbagoo@gmail.com";
        final String password = "Gieljansen";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");//smtp server adres
        props.put("mail.smtp.port", "587");//port voor smtp server
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);//om je email te verifieren
                    }
                            
                });
        
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("4TWbagoo@gmail.com"));//van email adres
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ramon.mocking@hva.nl"));//naar email
            message.setSubject("you've got mail");//titel in email
            message.setContent("<h:body style=background-color:white;font-family:verdana;color:#000000>"
            +"aandacht" + "<br/><br/>"
            + "</body>", "text/html; charset=utf-8");//set de content in de email
            Transport.send(message);//verzend alles
            
            System.out.println("was the email send: Done");//verifieerd het
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);//als het email niet bestaat
        }
        //einde van de email code
    }
    
}
