/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private StackPane stackPane;
    @FXML
    private GridPane nieuwPane;
    private TextField fieldDatum;
    private TextField fieldTijd;
    @FXML
    private Button knopBevestigen;
    @FXML
    private Button knopAnnuleren;
    private TextField fieldLuchthaven;
    private TextField fieldNaam;
    private TextField fieldAdres;
    private TextField fieldWoonplaats;
    private TextField fieldPostcode;
    private TextField fieldLand;
    private TextField fieldTelefoon;
    private TextField fieldEmail;
    private TextField fieldLabelNr;
    private TextField fieldVluchtNr;
    private TextField fieldBestemming;
    private TextField fieldBagageType;
    private TextField fieldBagageMerk;
    private TextField fieldBagageKleur;
    private TextField fieldBagageKenmerken;
    private Label labelTitle;
    
    private static Vermissing vermissing;
    @FXML
    private AnchorPane anchorPaneNKlant;
    @FXML
    private TextField fieldNaamNKlant;
    @FXML
    private TextField fieldAdresNKlant;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initFields(vermissing);
    }    
    
    private void initFields(Vermissing vermissing) {
        labelTitle.setText("Vermissing nr: " + vermissing.getVermissingNr());
        
        fieldDatum.setText(vermissing.getDatumGevonden());
        fieldTijd.setText(vermissing.getTijdGevonden());
        fieldLuchthaven.setText(vermissing.getVluchthaven().getIata());
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
        vermissing.setDatumGevonden(fieldDatum.getText());
        vermissing.setTijdGevonden(fieldTijd.getText());
        vermissing.getVluchthaven().setIata(fieldLuchthaven.getText());
        vermissing.getKlant().setVoorNaam(fieldNaam.getText());
        vermissing.getKlant().setStraat(fieldAdres.getText());
        //vermissing.getKlant().setHuisNummer();
        vermissing.getKlant().setWoonplaats(fieldWoonplaats.getText());
        vermissing.getKlant().setPostcode(fieldPostcode.getText());
        vermissing.getKlant().setLand(fieldLand.getText());
        vermissing.getKlant().setTelefoonNr(fieldTelefoon.getText());
        vermissing.getKlant().setEmail(fieldEmail.getText());
        //vermissing.getBagage().setLabelNr(fieldLabelNr.getText());
        vermissing.getVlucht().setVluchtNr(fieldVluchtNr.getText());
        vermissing.getVlucht().setNaar(fieldBestemming.getText());
        vermissing.getBagage().setType(fieldBagageType.getText());
        vermissing.getBagage().setMerk(fieldBagageMerk.getText());
        vermissing.getBagage().setKleur(fieldBagageKleur.getText());
        vermissing.getBagage().setOpmerking(fieldBagageKenmerken.getText());       
        
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Opslaan");
            alert.setHeaderText("");
            alert.setContentText("Wee je zeker dat je helemaal klaar bent?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                this.parentController.displayStatusMessage("Saving");
                if(VermissingDao.updateVermissing(vermissing)){
                    this.parentController.notifyChildHasUpdated();
                    this.parentController.notifyCloseChild();
                } else {
                    Alert alert2 = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, couldnt be saved!");

                    alert.showAndWait();
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }
    
    public void setParentContext(ParentControllerContext pC, Vermissing v){
        this.vermissing = v;
        this.parentController = pC;
        pC.displayStatusMessage("status message 404");
        this.initFields(vermissing);
    }
    
}
