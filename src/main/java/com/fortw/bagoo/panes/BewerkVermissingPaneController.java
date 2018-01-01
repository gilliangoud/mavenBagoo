/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class BewerkVermissingPaneController implements Initializable {

    private static ParentControllerContext parentController;
    @FXML
    private AnchorPane nieuweAnchorPane;
    @FXML
    private StackPane stackPane;
    @FXML
    private GridPane nieuwPane;
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
    @FXML
    private Label labelTitle;
    
    private static Vermissing vermissing;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initFields(vermissing);
    }    
    
    private void initFields(Vermissing vermissing) {
        labelTitle.setText("Vermissing nr: " + vermissing.getVermissingNr());
        
        fieldDatum.setText(vermissing.getAangemaakt());
        fieldTijd.setText("");
        fieldLuchthaven.setText(vermissing.getVluchthaven().toString());
        fieldNaam.setText(vermissing.getKlant().getNaam());
        fieldAdres.setText(vermissing.getKlant().getStraat() + " " 
                + vermissing.getKlant().getHuisNummer());
        fieldWoonplaats.setText(vermissing.getKlant().getWoonplaats());
        fieldPostcode.setText(vermissing.getKlant().getPostcode());
        fieldLand.setText(vermissing.getKlant().getLand());
        fieldTelefoon.setText(vermissing.getKlant().getTelefoonNr());
        fieldEmail.setText(vermissing.getKlant().getEmail());
        fieldLabelNr.setText(vermissing.getBagage().getLabelNr().toString());
        fieldVluchtNr.setText(vermissing.getVlucht().getVluchtNr());
        fieldBestemming.setText(vermissing.getVlucht().getNaar());
        fieldBagageType.setText(vermissing.getBagage().getType());
        fieldBagageMerk.setText(vermissing.getBagage().getMerk());
        fieldBagageKleur.setText(vermissing.getBagage().getKleur());
        fieldBagageKenmerken.setText(vermissing.getBagage().getOpmerking());
    }

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }
    
    public static void setParentContext(ParentControllerContext pC, Vermissing v){
        vermissing = v;
        parentController = pC;
        pC.displayStatusMessage("status message 404");
    }
    
}
