/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class VermissingMeldenController implements Initializable {

    @FXML
    private AnchorPane schermVermissingMelden;
    @FXML
    private Text extMail;
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
    @FXML
    private TextField textFlightnummer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleAnnulerenAction(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermService.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stageVolgende = new Stage();
    stageVolgende.setScene(new Scene (root1));
    Stage stageHuidige = (Stage) schermVermissingMelden.getScene().getWindow();
    stageHuidige.close();
    stageVolgende.show();
    }

    @FXML
    private void handleOpslaanAction(ActionEvent event) {
    }
    
}
