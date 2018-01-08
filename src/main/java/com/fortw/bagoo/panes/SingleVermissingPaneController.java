/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.LogboekDao;
import com.fortw.bagoo.helpers.XmlLoader;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.BagageType;
import com.fortw.bagoo.models.Kleur;
import com.fortw.bagoo.models.Logboek;
import com.fortw.bagoo.models.Vermissing;
import com.fortw.bagoo.models.Vlucht;
import com.fortw.bagoo.models.Vluchthaven;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class SingleVermissingPaneController implements Initializable {

    private ParentControllerContext parentController;
    private Vermissing vermissing;
    private int logboekPositie;
    private boolean isNieuwe = false;

    private final ObservableList<Kleur> kleuren
            = FXCollections.observableArrayList(XmlLoader.loadKleurData());
    private final ObservableList<BagageType> types
            = FXCollections.observableArrayList(XmlLoader.loadBagageTypeData());
    private ObservableList<Logboek> logboeken
            = FXCollections.observableArrayList();

    @FXML
    private DatePicker fieldDatum;
    @FXML
    private Button knopAnnuleren;
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
    private TextField fieldBagageMerk;
    @FXML
    private TextField fieldBagageKenmerken;
    @FXML
    private ComboBox<Vluchthaven> fieldLuchthaven;
    @FXML
    private ComboBox<Vlucht> fieldVluchtNr;
    @FXML
    private ComboBox<BagageType> fieldBagageType;
    @FXML
    private ComboBox<Kleur> fieldBagageKleur;
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
    @FXML
    private Label labelTitle;
    @FXML
    private TextField fieldLogboekNr;
    @FXML
    private DatePicker fieldDatumLogboek;
    @FXML
    private ComboBox<Logboek> fieldLogboekEvent;
    @FXML
    private TextArea fieldLogboekOpmerking;
    @FXML
    private Button buttonVorige;
    @FXML
    private Button buttonVolgende;
    @FXML
    private Button buttonOpslaan;
    @FXML
    private Button buttonBewerken;
    @FXML
    private Label fieldLogboekGrootte;
    @FXML
    private AnchorPane singleVermissingPane;
    @FXML
    private StackPane sstackPane;
    @FXML
    private GridPane SinglePane;
    @FXML
    private Button buttonOpslaan1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setParentContext(ParentControllerContext pC, Vermissing v) {
        this.vermissing = v;
        this.parentController = pC;
        this.isNieuwe = false;
        this.logboeken = FXCollections.observableArrayList(LogboekDao.getAllByVermissing(vermissing.getVermissingNr()));
        pC.displayStatusMessage("status message 404");
        this.initVermissingFields(vermissing);
        Logboek laatste = null;
        if (!logboeken.isEmpty()) {
            logboekPositie = logboeken.size() - 1;
            laatste = logboeken.get(logboekPositie);
            this.initFields(laatste);
        } else {
            logboekPositie = 0;
            laatste = new Logboek();
            clearFields();
            logboeken.add(laatste);
            
            fieldLogboekNr.setDisable(true);
            fieldDatumLogboek.setDisable(false);
            fieldLogboekEvent.setDisable(false);
            fieldLogboekOpmerking.setDisable(false);
            fieldLogboekOpmerking.setEditable(true);
        }
        //this.initPane();
    }

    private void initPane() {
//        fieldLuchthaven.setItems(vluchthavens);
//        new AutoCompleteComboBoxListener(fieldLuchthaven);
    }

    private void initVermissingFields(Vermissing vermissing) {
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
        fieldBagageType.setValue(types.get(vermissing.getBagage().getType()));
        fieldBagageMerk.setText(vermissing.getBagage().getMerk());

        int RAL = vermissing.getBagage().getKleur();
        Kleur kleur = new Kleur();
        for (Kleur p : kleuren) {
            if (p.getRAL() == RAL) {
                kleur = p;
            }
        }
        fieldBagageKleur.setValue(kleur);
        int RAL2 = vermissing.getBagage().getKleur2();
        Kleur kleur2 = new Kleur();
        for (Kleur p : kleuren) {
            if (p.getRAL() == RAL2) {
                kleur2 = p;
            }
        }
        fieldBagageKleur2.setValue(kleur2);
        fieldBagageGewicht.setText(vermissing.getBagage().getGewicht());
        fieldBagageBreedte.setText(vermissing.getBagage().getBreedte());
        fieldBagageHoogte.setText(vermissing.getBagage().getHoogte());
        fieldBagageDiepte.setText(vermissing.getBagage().getDiepte());
        fieldBagageKenmerken.setText(vermissing.getBagage().getOpmerking());

        fieldLogboekEvent.setConverter(new StringConverter<Logboek>() {
            @Override
            public String toString(Logboek object) {
                if (object == null) {
                    return null;
                }
                return object.getEvent();
            }

            @Override
            public Logboek fromString(String string) {
                Logboek logboek = new Logboek();
                logboek.setEvent(string);
                return logboek;
            }
        });
    }

    private void initFields(Logboek logboek) {
        // haal alles weg
        fieldLogboekNr.clear();
        fieldDatumLogboek.getEditor().clear();
        fieldLogboekEvent.getEditor().clear();
        fieldLogboekOpmerking.clear();

        // disable alles
        fieldLogboekNr.setDisable(true);
        fieldDatumLogboek.setDisable(true);
        fieldLogboekEvent.setDisable(true);
        fieldLogboekOpmerking.setDisable(false);
        fieldLogboekOpmerking.setEditable(false);

        // set alles
        int positie = logboeken.lastIndexOf(logboek) + 1;
        fieldLogboekGrootte.setText("(" + positie + " van de " + logboeken.size() + ")");
        fieldLogboekNr.setText(logboek.getLogboekNr().toString());
        fieldDatumLogboek.setValue(logboek.getDatum().toLocalDate());
        fieldLogboekEvent.setValue(logboek);
        fieldLogboekOpmerking.setText(logboek.getOpmerking());
    }
    
    private void clearFields() {
        // haal alles weg
        fieldLogboekNr.clear();
        fieldDatumLogboek.getEditor().clear();
        fieldLogboekEvent.getEditor().clear();
        fieldLogboekOpmerking.clear();
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) {
        parentController.notifyCloseChild();
    }

    @FXML
    private void handleZieVorigeLogboek(ActionEvent event) {
        Logboek logboek = null;
        logboekPositie--;
        if (!logboeken.isEmpty()) {
            if (logboekPositie >= 0) {
                logboek = logboeken.get(logboekPositie);
                this.initFields(logboek);
            } else {
                logboekPositie++;
            }
        }
    }

    @FXML
    private void handleZieVorlgendeLogboek(ActionEvent event) {
        Logboek logboek = null;
        logboekPositie++;
        if (!logboeken.isEmpty()) {
            if (logboekPositie < logboeken.size()) {
                logboek = logboeken.get(logboekPositie);
                this.initFields(logboek);
            } else {
                logboekPositie--;
            }
        }
    }

    @FXML
    private void handleOpslaanLogboek(ActionEvent event) {
        Logboek logboek = logboeken.get(logboekPositie);
        logboek.setDatum(Date.valueOf(fieldDatumLogboek.getValue()));
        //logboek.setEvent(fieldLogboekEvent.getValue().getEvent());
        logboek.setEvent("1");
        logboek.setOpmerking(fieldLogboekOpmerking.getText());
        logboek.setVermissingNr(vermissing.getVermissingNr());
        if (fieldLogboekNr.getText().length() == 0) {
            LogboekDao.insert(logboek);
        } else {
            logboek.setLogboekNr(Integer.valueOf(fieldLogboekNr.getText()));
            LogboekDao.update(logboek);
        }
        logboeken = FXCollections.observableArrayList(LogboekDao.getAllByVermissing(vermissing.getVermissingNr()));
        logboekPositie = logboeken.size() - 1;
        logboek = logboeken.get(logboekPositie);
        this.initFields(logboek);
    }

    @FXML
    private void handleBewerkenLogboek(ActionEvent event) {
        if (!fieldLogboekOpmerking.isEditable()) {
            fieldLogboekOpmerking.setEditable(true);
            buttonBewerken.setText("Annuleren");
        } else {
            fieldLogboekOpmerking.setEditable(false);
            this.initFields(logboeken.get(logboekPositie));
            buttonBewerken.setText("Bewerken");
        }
    }

    @FXML
    private void handleNieuwLogboek(ActionEvent event) {
        if (!isNieuwe) {
            isNieuwe = true;
            Logboek logboek = new Logboek();
            logboeken.add(logboek);
            int positie = logboeken.lastIndexOf(logboek) + 1;
            logboekPositie = positie-1;
            fieldLogboekGrootte.setText("(" + positie + " van de " + logboeken.size() + ")");
            clearFields();
            fieldLogboekNr.setDisable(true);
            fieldDatumLogboek.setDisable(false);
            fieldLogboekEvent.setDisable(false);
            fieldLogboekOpmerking.setDisable(false);
            fieldLogboekOpmerking.setEditable(true);
        }
    }
}
