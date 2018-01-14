/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class NieuweKlantPaneController implements Initializable {

    @FXML
    private AnchorPane anchorPaneNKlant;
    @FXML
    private StackPane stackPaneNKlant;
    @FXML
    private GridPane nieuwPane;
    @FXML
    private Button knopBevestigen;
    @FXML
    private Button knopAnnuleren;
    @FXML
    private TextField fieldNaamNKlant;
    @FXML
    private TextField fieldStraatNKlant;
    @FXML
    private TextField fieldWoonplaatsNKlant;
    @FXML
    private TextField fieldPostcodeNKlant;
    @FXML
    private TextField fieldLandNKlant;
    @FXML
    private TextField fieldTelefoonNKlant;
    @FXML
    private TextField fieldEmailNKlant;
    @FXML
    private TextField fieldCheckInDatumNKlant;
    @FXML
    private TextField fieldHuisnummerNKlant;
    @FXML
    private TextField fieldTussenvoegselNKlant;
    @FXML
    private TextField fieldAchternaamNKlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
    }
    
}
