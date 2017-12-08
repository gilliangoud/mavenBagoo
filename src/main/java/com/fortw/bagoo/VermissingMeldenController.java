/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
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
 * @author Anouar
 */
public class VermissingMeldenController implements Initializable {

    @FXML
    private AnchorPane schermVermissingMelden;
    @FXML
    private TextField textAchternaam;
    @FXML
    private TextField textVoornaam;
    @FXML
    private TextField textAdres;
    @FXML
    private TextField textPostcode;
    @FXML
    private TextField textPlaats;
    @FXML
    private TextField textLand;
    @FXML
    private TextField textTelefoon;
    @FXML
    private TextField textmail;

    private Connection conn = null;
    private PreparedStatement pst = null;
    @FXML
    private TextField textTussenvoegsel;

    @FXML
    private TextField texthuisnummer;
    @FXML
    private Text extMail;
    @FXML
    private ComboBox comboSoortBagage;
    @FXML
    private ComboBox Combokleur;
    @FXML
    private TextField tijd;
    @FXML
    private ComboBox comboMateriaal;
    @FXML
    private ComboBox comboMerk;
    @FXML
    private Text extMail1;
    @FXML
    private TextField textmail1;
    @FXML
    private Text vluchthavenITA;
    @FXML
    private ComboBox comboVluchthavenITA;
    // inhoud comboboxen
    ObservableList<String> bagageSoort = FXCollections.observableArrayList("Handbagage", "koffer");
    ObservableList<String> bagageKleur = FXCollections.observableArrayList("Rood", "Oranje", "Geel", "Groen", "Blauw", "Zwart", "bruin", "Wit", "Grijs");
    ObservableList<String> bagageMateriaal = FXCollections.observableArrayList("Leer", "Plastic", "Kunststof", "Metaal", "Gestofeerd");
    ObservableList<String> bagageMerk = FXCollections.observableArrayList("Samsonite", "American Tourister", "Delsey", "Titan", "Rimowa", "Tumi", "Carryon", "Eastpack", "Carlton", "SuitSuit", "Enrico Benetti", "Princess", "b-hppy", "Kipling","Overig");
    @FXML
    private TextField textGewicht;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = DbConnection.Connect();
        comboSoortBagage.setItems(bagageSoort);
        Combokleur.setItems(bagageKleur);
        comboMateriaal.setItems(bagageMateriaal);
        comboMerk.setItems(bagageMerk);
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HoofdSchermService.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) schermVermissingMelden.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void handleOpslaanAction(ActionEvent event) throws SQLException {
        String queryKlant = "INSERT INTO klant(voornaam,tussenvoegsel,achternaam,woonplaats,straat,huisnummer,postcode,land,telefoon,email) Values (?,?,?,?,?,?,?,?,?,?)";

        String achternaam = textAchternaam.getText();
        String tussenvoegsel = textTussenvoegsel.getText();
        String voornaam = textVoornaam.getText();
        String adres = textAdres.getText();
        String huisnummer = texthuisnummer.getText();
        String postcode = textPostcode.getText();
        String plaats = textPlaats.getText();
        String land = textLand.getText();
        String telefoonnummer = textTelefoon.getText();
        String email = textmail.getText();

        try {
            pst = conn.prepareStatement(queryKlant);

            pst.setString(1, voornaam);
            pst.setString(2, tussenvoegsel);
            pst.setString(3, achternaam);
            pst.setString(4, plaats);
            pst.setString(5, adres);
            pst.setString(6, huisnummer);
            pst.setString(7, postcode);
            pst.setString(8, land);
            pst.setString(9, telefoonnummer);
            pst.setString(10, email);

            int i = pst.executeUpdate();

            if (i == 1) {
                System.out.println("Data in database");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VermissingMeldenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String queryBagage = "INSERT INTO bagage(type,merk,kleur,gewicht)Values(?,?,?,?)";

        String type =   comboSoortBagage.getId();
        String merk =   comboMerk.getId();
        String kleur =   Combokleur.getId();
        String gewicht =  textGewicht.getText();

        try {
            pst = conn.prepareStatement(queryBagage);
            pst.setObject(1, type);
            pst.setString(2, merk);
            pst.setString(3, kleur);
            pst.setString(4, gewicht);
            
            int i = pst.executeUpdate();
            if (i == 1) 
                System.out.println("Data in database");
            
        } catch (SQLException ex) {
             Logger.getLogger(VermissingMeldenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String queryVerissing = "INSERT INTO vermissing(klant_idklant,bagage_idbagage) Values (?,?)";
         
         
         
         try {
            
        } catch (Exception e) {
        }
         
         

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
                                  InternetAddress.parse(textmail.getText()));//naar email
            message.setSubject("Bevestiging vermissing");//titel in email
            message.setContent("<h:body style=background-color:white;font-family:verdana;color:#000000>"
            + "Beste, Meneer en/of Mevrouw " + textAchternaam.getText()
            + "\n "
            + "\n Hierbij ontvangt u een bevestiging van uw gemelde vermissing."
            + "\n Dit zijn uw persoonlijke gegevens: "
            + "\n Naam: " + textVoornaam.getText() + " " + textTussenvoegsel.getText()
            + " " + textAchternaam.getText()
            + "\n Adres: " + textAdres.getText() + " " + texthuisnummer.getText()
            + ", " + textPostcode.getText() + " " + textPlaats.getText()
            + "\n Telefoonnummer: " + textTelefoon.getText()
            + "\n Dit zijn uw bagage gegevens"
            + "\n Bagage id: " + textmail1.getText()
            + "\n Soort bagage: " + comboSoortBagage.getAccessibleText() 
            + "\n Soort merk: " + comboMerk.getAccessibleText()
            + "\n Kleur: " + Combokleur.getAccessibleText()
            + "\n Materiaal: " + comboMateriaal.getAccessibleText()
            + "\n Gewicht: " + textGewicht.getText()
            + "\n Klopt een van de bovenstaande gegevens niet, mail dan naar lostandfound@corendon.nl"        
            + "Wij hopen u hiermee voldoende geïnformeerd te hebben."
            + "\n"
            + "\n Met Vriendelijke Groet,"
            + "\n Het Corendon Serviceteam"
            + "\n"
            + "\n"
            + "\n P.S. Dit is een automatisch gegenereerde e-mail. Reageren op deze e-mail is daarom niet mogelijk." + "<br/><br/>"
            + "</body>", "text/html; charset=utf-8");//set de content in de email
            Transport.send(message);//verzend alles
            
            System.out.println("was the email send: Done");//verifieerd het
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);//als het email niet bestaat
        }
        //einde van de email code
        
    }
    
    
    
    

}
