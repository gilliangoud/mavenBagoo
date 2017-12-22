/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.fortw.bagoo.models.User;
import com.fortw.bagoo.Dao.UserDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * FXML Controller class
 *
 * @author Giel
 */
public class MedewerkerPaneController implements Initializable {

    @FXML
    private Button knopAnnuleren;
    @FXML
    private Button knopBevestigen;
    @FXML
    private BorderPane medewerkerPane;
    @FXML
    private TextField inputGebruikersnaam;
    @FXML
    private TextField inputWachtwoord;
    @FXML
    private TextField inputWachtwoordHerhaal;
    @FXML
    private Label labelWachtwoord;
    @FXML
    private ComboBox inputLevel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inputLevel.getItems().addAll(
            "1",
            "2",
            "3",
            "4",
            "5"
        );
    }    

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        Stage stageHuidige = (Stage) medewerkerPane.getScene().getWindow();
        stageHuidige.close();
    }

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
        String gebruikersnaam = inputGebruikersnaam.getText();
        String wachtwoord = inputWachtwoord.getText();
        String getLevel = inputLevel.getSelectionModel().
                getSelectedItem().toString();
        int level = Integer.parseInt(getLevel);
        User nieuweGebruiker = new User(gebruikersnaam, wachtwoord, level);
        if (UserDao.insertUser(nieuweGebruiker)){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Je nieuwe gebruiker is opgeslagen.");

            alert.showAndWait();
            Stage stageHuidige = (Stage) medewerkerPane.getScene().getWindow();
            stageHuidige.close();
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, its not saving! /n do you have "
                    + "a internet connection?");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleWachtwoordHerhaalInput(KeyEvent event) {
        String wachtwoord1 = inputWachtwoordHerhaal.getText();
        String wachtwoord2 = inputWachtwoord.getText();
        //System.out.println("test");
        if(wachtwoord1.length() > 2 && wachtwoord2.length() > 2){
            if (wachtwoord1 != wachtwoord2){
                labelWachtwoord.setText("Wachtwoorden Matchen!");
                //System.out.println("test2");
            } else {
                labelWachtwoord.setText("De wachtwoorden moeten gelijk zijn!");
                //System.out.println("test3");
            }
        }
    }
    
}
