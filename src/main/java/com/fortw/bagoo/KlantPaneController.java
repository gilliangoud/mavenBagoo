/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import com.fortw.bagoo.interfaces.KlantDao;
import com.fortw.bagoo.models.Klant;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class KlantPaneController implements Initializable {

    @FXML
    private Button knopVervers;
    @FXML
    private Button knopNieuweKlant;
    @FXML
    private Button knopVerwijderKlant;
    @FXML
    private Button knopVeranderKlant;
    @FXML
    private TextField veldZoeken;
    @FXML
    private TableView klantTableView;
    @FXML
    private TableColumn klantNr;
    @FXML
    private TableColumn voorNaam;
    @FXML
    private TableColumn achterNaam;
    
    private ObservableList<Klant> klantenList 
            = FXCollections.observableArrayList(KlantDao.getAllKlanten());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        klantTableView.setItems(klantenList);
        
        // associate every tableview collum with its data
        for (int cnr = 0; cnr < klantTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) klantTableView.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // this assumes that the class has getters and setters that match
                // propertyname in the fx:id of the table column in the fxml view
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                //System.out.println("attached column '" + propertyName + "'");
            }
        }
    }    
    
    public void refreshKlantTableView(){
        ObservableList<Klant> tempList 
            = FXCollections.observableArrayList(KlantDao.getAllKlanten());
        //System.out.println("Updated");
        klantenList = null;
        klantenList = tempList;
        klantTableView.setItems(klantenList);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        refreshKlantTableView();
    }

    @FXML
    private void handleNieuweKlantAction(ActionEvent event) {
    }

    @FXML
    private void handleVerwijderKlantAction(ActionEvent event) {
        Klant selectedItem = (Klant) klantTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting klant: " + selectedItem.getKlantNr());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //labelStatus.setText("Deleted luggage with nr: " + selectedItem.getGebruikersnaam());
                //foundLuggageList.remove(selectedItem);
                KlantDao.deleteKlant(selectedItem.getKlantNr());
                refreshKlantTableView();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @FXML
    private void handleVeranderKlantAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchInput(KeyEvent event) {
        String query = veldZoeken.getText();
        List<Klant> queryList = null;
        if(query != null && query.length() >1 ){
        queryList = KlantDao.getKlantenByField("voornaam",query);
        }
        if(queryList != null){
            ObservableList<Klant> tempList 
            = FXCollections.observableArrayList(queryList);
            //System.out.println("Updated");
            klantenList = null;
            klantenList = tempList;
            klantTableView.setItems(klantenList);
        } else {
            refreshKlantTableView();
        }
    }
    
}
