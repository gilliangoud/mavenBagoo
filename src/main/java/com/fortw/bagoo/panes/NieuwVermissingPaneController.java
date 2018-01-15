/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.interfaces.ParentControllerContext;
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
 * @author gilli
 */
public class NieuwVermissingPaneController implements Initializable {
    
    private static ParentControllerContext parentController;

    @FXML
    private StackPane stackPane;
    @FXML
    private GridPane nieuwPane;
    @FXML
    private AnchorPane nieuweAnchorPane;
    @FXML
    private TextField fieldDatum;
    @FXML
    private TextField fieldTijd;
    @FXML
    private Button knopBevestigen;
    @FXML
    private Button knopAnnuleren;
    @FXML
    private TextField fieldLuchthaven;
    @FXML
    private TextField fieldNaam;
    @FXML
    private TextField fieldAdres;
    @FXML
    private TextField fieldWoonplaats;
    @FXML
    private TextField fieldPostcode;
    @FXML
    private TextField fieldLand;
    @FXML
    private TextField fieldTelefoon;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldLabelNr;
    @FXML
    private TextField fieldVluchtNr;
    @FXML
    private TextField fieldBestemming;
    @FXML
    private TextField fieldBagageType;
    @FXML
    private TextField fieldBagageMerk;
    @FXML
    private TextField fieldBagageKleur;
    @FXML
    private TextField fieldBagageKenmerken;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static void setParentContext(ParentControllerContext pC){
        parentController = pC;
        pC.displayStatusMessage("status message 404");
    }

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }
    
}
