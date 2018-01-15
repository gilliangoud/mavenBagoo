/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Klant;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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

    private static ParentControllerContext parentController;
    
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
    private DatePicker fieldCheckInDatumNKlant;
    @FXML
    private TextField fieldHuisnummerNKlant;
    @FXML
    private TextField fieldTussenvoegselNKlant;
    @FXML
    private TextField fieldAchternaamNKlant;
    @FXML
    private AnchorPane anchorPaneListKlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Opslaan");
        alert.setHeaderText("");
        alert.setContentText("Weet je zeker dat je helemaal klaar bent?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // maak een nieuwe klant aan en vul deze
            Klant klant = new Klant();
            klant.setVoorNaam(fieldNaamNKlant.getText());
            klant.setTussenVoegsel(fieldTussenvoegselNKlant.getText());
            klant.setAchterNaam(fieldAchternaamNKlant.getText());
            klant.setWoonplaats(fieldWoonplaatsNKlant.getText());
            klant.setStraat(fieldStraatNKlant.getText());
            klant.setHuisNummer(fieldHuisnummerNKlant.getText());
            klant.setPostcode(fieldPostcodeNKlant.getText());
            klant.setLand(fieldLandNKlant.getText());
            klant.setTelefoonNr(fieldTelefoonNKlant.getText());
            klant.setEmail(fieldEmailNKlant.getText());
            klant.setCheckInDatum(Date.valueOf(fieldCheckInDatumNKlant.getValue()));

            KlantDao.insertKlant(klant);
            
            parentController.notifyCloseChild();
        }
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }

    public void setParentContext(ParentControllerContext pC) {
        parentController = pC;
    }

}
