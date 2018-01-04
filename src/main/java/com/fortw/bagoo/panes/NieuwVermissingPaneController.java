/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.Dao.VluchtDao;
import com.fortw.bagoo.Dao.VluchthavenDao;
import com.fortw.bagoo.helpers.AutoCompleteComboBoxListener;
import com.fortw.bagoo.helpers.XmlLoader;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.BagageType;
import com.fortw.bagoo.models.Kleur;
import com.fortw.bagoo.models.Vermissing;
import com.fortw.bagoo.models.Vlucht;
import com.fortw.bagoo.models.Vluchthaven;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private DatePicker fieldDatum;
    @FXML
    private TextField fieldTijd;
    @FXML
    private Button knopBevestigen;
    @FXML
    private Button knopAnnuleren;
    @FXML
    private ComboBox<Vluchthaven> fieldLuchthaven;
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
    private ComboBox<Vlucht> fieldVluchtNr;
    @FXML
    private TextField fieldBestemming;
    @FXML
    private ComboBox<BagageType> fieldBagageType;
    @FXML
    private TextField fieldBagageMerk;
    @FXML
    private ComboBox<Kleur> fieldBagageKleur;
    @FXML
    private TextField fieldBagageKenmerken;
    
    private ObservableList<Vluchthaven> vluchthavens
            = FXCollections.observableArrayList(VluchthavenDao.getAllVluchthavens());
    
    private ObservableList<Vlucht> vluchten
            = FXCollections.observableArrayList(VluchtDao.getAllVluchten());
    
    private ObservableList<Kleur> kleuren
            = FXCollections.observableArrayList(XmlLoader.loadKleurData());
    
    private ObservableList<BagageType> types
            = FXCollections.observableArrayList(XmlLoader.loadBagageTypeData());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldLuchthaven.setItems(vluchthavens);
        new AutoCompleteComboBoxListener(fieldLuchthaven);
        fieldVluchtNr.setItems(vluchten);
        new AutoCompleteComboBoxListener(fieldVluchtNr);
        fieldBagageKleur.setItems(kleuren);
        new AutoCompleteComboBoxListener(fieldBagageKleur);
        fieldBagageType.setItems(types);
        new AutoCompleteComboBoxListener(fieldBagageType);
    }    
    
    public static void setParentContext(ParentControllerContext pC){
        parentController = pC;
        pC.displayStatusMessage("status message 404");
    }

    @FXML
    private void handleBevestigenAction(ActionEvent event) {
        // maak een nieuwe klant aan en vul deze
        // sla de klant op en vraag het klantnr ervan
        // maak een nieuw bagagestuk aan en vul deze
        // sla het bagagestuk op en vraag het bagagenr er van
        
        // maak een nieuwe vermissing en vul deze
        // voeg de bovenstaande nr's toe
        // voeg vlucht, gebruiker en vluchthaven toe
        
        
        
        
        
        
        
        
        
        
        
        
        Vermissing vermissing = new Vermissing();
        
        vermissing.setDatumGevonden(fieldDatum.getValue().toString());
        vermissing.setTijdGevonden(fieldTijd.getText());
        vermissing.getVluchthaven().setIata(fieldLuchthaven.getSelectionModel().
                getSelectedItem().toString());
        vermissing.getKlant().setVoorNaam(fieldNaam.getText());
        vermissing.getKlant().setStraat(fieldAdres.getText());
        //vermissing.getKlant().setHuisNummer();
        vermissing.getKlant().setWoonplaats(fieldWoonplaats.getText());
        vermissing.getKlant().setPostcode(fieldPostcode.getText());
        vermissing.getKlant().setLand(fieldLand.getText());
        vermissing.getKlant().setTelefoonNr(fieldTelefoon.getText());
        vermissing.getKlant().setEmail(fieldEmail.getText());
        //vermissing.getBagage().setLabelNr(fieldLabelNr.getText());
        vermissing.getVlucht().setVluchtNr(fieldVluchtNr.getSelectionModel().
                getSelectedItem().toString());
        vermissing.getVlucht().setNaar(fieldBestemming.getText());
        vermissing.getBagage().setType(fieldBagageType.getSelectionModel().
                getSelectedItem().toString());
        vermissing.getBagage().setMerk(fieldBagageMerk.getText());
        vermissing.getBagage().setKleur(fieldBagageKleur.getSelectionModel().
                getSelectedItem().toString());
        vermissing.getBagage().setOpmerking(fieldBagageKenmerken.getText());       
        
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Opslaan");
            alert.setHeaderText("");
            alert.setContentText("Wee je zeker dat je helemaal klaar bent?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                this.parentController.displayStatusMessage("Saving");
                if(VermissingDao.insertVermissing(vermissing)){
                    this.parentController.notifyChildHasUpdated();
                    this.parentController.notifyCloseChild();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
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
    
}
