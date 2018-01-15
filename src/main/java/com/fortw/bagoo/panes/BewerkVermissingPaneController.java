/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.BagageDao;
import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.Dao.UserDao;
import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.Dao.VluchtDao;
import com.fortw.bagoo.Dao.VluchthavenDao;
import com.fortw.bagoo.helpers.AutoCompleteComboBoxListener;
import com.fortw.bagoo.helpers.XmlLoader;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Bagage;
import com.fortw.bagoo.models.BagageType;
import com.fortw.bagoo.models.Klant;
import com.fortw.bagoo.models.Kleur;
import com.fortw.bagoo.models.User;
import com.fortw.bagoo.models.Vermissing;
import com.fortw.bagoo.models.Vlucht;
import com.fortw.bagoo.models.Vluchthaven;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private GridPane nieuwPane;
    @FXML
    private DatePicker fieldDatum;
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
    @FXML
    private Label labelTitle;

    private static Vermissing vermissing;
    @FXML
    private TextField fieldAdresHuisnummer;
    @FXML
    private TextField fieldAchternaam;
    @FXML
    private DatePicker fieldCheckInDatum;
    @FXML
    private ComboBox<Kleur> fieldBagageKleur2;
    @FXML
    private TextField fieldBagageGewicht;
    @FXML
    private TextField fieldBagageBreedte;
    @FXML
    private TextField fieldBagageHoogte;
    @FXML
    private TextField fieldBagageDiepte;

    private ObservableList<Vluchthaven> vluchthavens
            = FXCollections.observableArrayList();

    private ObservableList<Vlucht> vluchten
            = FXCollections.observableArrayList();

    private ObservableList<Kleur> kleuren
            = FXCollections.observableArrayList();

    private ObservableList<BagageType> types
            = FXCollections.observableArrayList();
    @FXML
    private AnchorPane bewerkAnchorPane;
    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void initFields(Vermissing vermissing) {
        labelTitle.setText("Vermissing nr: " + vermissing.getVermissingNr());

        fieldDatum.setValue(vermissing.getAangemaakt().toLocalDate());
        fieldLuchthaven.setValue(vermissing.getVluchthaven());
        fieldNaam.setText(vermissing.getKlant().getVoorNaam());
        fieldAchternaam.setText(vermissing.getKlant().getAchterNaam());
        fieldAdres.setText(vermissing.getKlant().getStraat());
        fieldAdresHuisnummer.setText(vermissing.getKlant().getHuisNummer());
        fieldWoonplaats.setText(vermissing.getKlant().getWoonplaats());
        fieldPostcode.setText(vermissing.getKlant().getPostcode());
        fieldLand.setText(vermissing.getKlant().getLand());
        fieldTelefoon.setText(vermissing.getKlant().getTelefoonNr());
        fieldEmail.setText(vermissing.getKlant().getEmail());
        fieldCheckInDatum.setValue(vermissing.getKlant().getCheckInDatum().toLocalDate());
        fieldLabelNr.setText(Integer.toString(vermissing.getBagageLabel()));
        fieldVluchtNr.setValue(vermissing.getVlucht());
        fieldBestemming.setText(vermissing.getVlucht().getNaar());
        fieldBestemming.setDisable(true);
        fieldBagageType.setValue(types.get(vermissing.getBagage().getType()));
        fieldBagageMerk.setText(vermissing.getBagage().getMerk());
        
        int RAL = vermissing.getBagage().getKleur();
        Kleur kleur = new Kleur();
        for(Kleur p : kleuren){
            if(p.getRAL() == RAL){
                kleur = p;
            }
        }
        fieldBagageKleur.setValue(kleur);
        int RAL2 = vermissing.getBagage().getKleur2();
        Kleur kleur2 = new Kleur();
        for(Kleur p : kleuren){
            if(p.getRAL() == RAL2){
                kleur2 = p;
            }
        }
        fieldBagageKleur2.setValue(kleur2);
        fieldBagageGewicht.setText(vermissing.getBagage().getGewicht());
        fieldBagageBreedte.setText(vermissing.getBagage().getBreedte());
        fieldBagageHoogte.setText(vermissing.getBagage().getHoogte());
        fieldBagageDiepte.setText(vermissing.getBagage().getDiepte());
        fieldBagageKenmerken.setText(vermissing.getBagage().getOpmerking());
        
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
            Klant klant = KlantDao.getKlant(vermissing.getKlant().getKlantNr());
            klant.setVoorNaam(fieldNaam.getText());
            klant.setAchterNaam(fieldAchternaam.getText());
            klant.setWoonplaats(fieldWoonplaats.getText());
            klant.setStraat(fieldAdres.getText());
            klant.setHuisNummer(fieldAdresHuisnummer.getText());
            klant.setPostcode(fieldPostcode.getText());
            klant.setLand(fieldLand.getText());
            klant.setTelefoonNr(fieldTelefoon.getText());
            klant.setEmail(fieldEmail.getText());
            klant.setCheckInDatum(Date.valueOf(fieldCheckInDatum.getValue()));

            // maak een nieuw bagagestuk aan en vul deze
            Bagage bagage = BagageDao.getBagage(vermissing.getBagage().getBagageNr());
            BagageType type = fieldBagageType.getSelectionModel().getSelectedItem();
            bagage.setType(type.getTypeId());
            bagage.setMerk(fieldBagageMerk.getText());
            bagage.setKleur(fieldBagageKleur.getSelectionModel().getSelectedItem().getRAL());
            bagage.setKleur2(fieldBagageKleur2.getSelectionModel().getSelectedItem().getRAL());
            bagage.setGewicht(fieldBagageGewicht.getText());
            bagage.setOpmerking(fieldBagageKenmerken.getText());
            bagage.setBreedte(fieldBagageBreedte.getText());
            bagage.setHoogte(fieldBagageHoogte.getText());
            bagage.setDiepte(fieldBagageDiepte.getText());
            bagage.setVluchtNr(fieldVluchtNr.getSelectionModel().getSelectedItem().getVluchtNr());
            bagage.setLabelNr(Integer.valueOf(fieldLabelNr.getText()));

            KlantDao.updateKlant(klant);
            BagageDao.updateBagage(bagage);

            this.parentController.displayStatusMessage("Saving");

            vermissing.setAangemaakt(Date.valueOf(fieldDatum.getValue()));
            vermissing.setVluchthaven(fieldLuchthaven.getSelectionModel().
                    getSelectedItem());
            vermissing.setBagageLabel(Integer.valueOf(fieldLabelNr.getText()));
            vermissing.setVlucht(fieldVluchtNr.getSelectionModel().
                    getSelectedItem());
            vermissing.setKlant(klant);
            vermissing.setBagage(bagage);
            User currentUser = UserDao.getUser(2);
            vermissing.setUserBewerkt(currentUser);

            if (VermissingDao.updateVermissing(vermissing)) {
                this.parentController.notifyChildHasUpdated();
                this.parentController.notifyCloseChild();
            } else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error Dialog");
                alert2.setHeaderText("Look, an Error Dialog");
                alert2.setContentText("Ooops, couldnt be saved!");

                alert2.showAndWait();
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }

    public void setParentContext(ParentControllerContext pC, Vermissing v) {
        this.vermissing = v;
        this.parentController = pC;
        this.initPane();
        pC.displayStatusMessage("status message 404");
        this.initFields(vermissing);
    }

    private void initPane() {
        kleuren = FXCollections.observableArrayList(XmlLoader.loadKleurData());
        types = FXCollections.observableArrayList(XmlLoader.loadBagageTypeData());
        vluchthavens = FXCollections.observableArrayList(VluchthavenDao.getAllVluchthavens());
        vluchten = FXCollections.observableArrayList(VluchtDao.getAllVluchten());        
        fieldLuchthaven.setItems(vluchthavens);
        new AutoCompleteComboBoxListener(fieldLuchthaven);
        fieldVluchtNr.setItems(vluchten);
        new AutoCompleteComboBoxListener(fieldVluchtNr);
        fieldBagageKleur.setItems(kleuren);
        fieldBagageKleur2.setItems(kleuren);
        new AutoCompleteComboBoxListener(fieldBagageKleur);
        new AutoCompleteComboBoxListener(fieldBagageKleur2);
        fieldBagageType.setItems(types);
        new AutoCompleteComboBoxListener(fieldBagageType);
    }

}
