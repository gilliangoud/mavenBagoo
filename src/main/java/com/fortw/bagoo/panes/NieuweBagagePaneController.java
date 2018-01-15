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
public class NieuweBagagePaneController implements Initializable {

    @FXML
    private AnchorPane nieuwBagagePane;
    @FXML
    private StackPane StackPaneBagage;
    @FXML
    private GridPane nieuwPane;
    @FXML
    private Button knopBevestigen;
    @FXML
    private Button knopAnnuleren;
    @FXML
    private TextField fieldType;
    @FXML
    private TextField fieldBagageType;
    @FXML
    private TextField fieldKleur1;
    @FXML
    private TextField fieldKleur2;
    @FXML
    private TextField fieldGewicht;
    @FXML
    private TextField fieldBreedte;
    @FXML
    private TextField fieldHoogte;
    @FXML
    private TextField fieldDiepte;
    @FXML
    private TextField fieldLocatieID;
    @FXML
    private TextField fieldVluchtnummer;
    @FXML
    private TextField fieldLabelNummer;
    @FXML
    private TextField fieldLabelOpmerking;

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
