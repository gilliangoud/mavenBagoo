/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.BagageDao;
import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.Bagage;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class NieuwBagagePaneController implements Initializable {

    private static ParentControllerContext parentController;

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
    @FXML
    private TextField fieldBagageMerk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setParentContext(ParentControllerContext pC) {
        parentController = pC;
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
            Bagage bagage = new Bagage();
            bagage.setType(Integer.valueOf(fieldType.getText()));
            bagage.setMerk(fieldBagageMerk.getText());
            bagage.setKleur(Integer.valueOf(fieldKleur1.getText()));
            bagage.setKleur2(Integer.valueOf(fieldKleur2.getText()));
            bagage.setGewicht(fieldGewicht.getText());
            bagage.setBreedte(fieldBreedte.getText());
            bagage.setHoogte(fieldHoogte.getText());
            bagage.setDiepte(fieldDiepte.getText());
            bagage.setLocatieNr(Integer.valueOf(fieldLocatieID.getText()));
            bagage.setVluchtNr(fieldVluchtnummer.getText());
            bagage.setLabelNr(Integer.valueOf(fieldLabelNummer.getText()));
            bagage.setOpmerking(fieldLabelOpmerking.getText());

            BagageDao.insertBagage(bagage);
        }
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }

}
