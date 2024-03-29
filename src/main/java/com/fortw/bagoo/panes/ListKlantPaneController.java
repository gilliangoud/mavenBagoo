/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.Klant;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class ListKlantPaneController implements Initializable, ChildControllerContext {

    @FXML
    private AnchorPane anchorPaneListKlant;
    @FXML
    private TableView<Klant> tableViewListKlant;
    
    private ObservableList<Klant> tableKlantenList
            = FXCollections.observableArrayList();
    @FXML
    private TableColumn klantNr;
    @FXML
    private TableColumn voorNaam;
    @FXML
    private TableColumn tussenVoegsel;
    @FXML
    private TableColumn achterNaam;
    @FXML
    private TableColumn postcode;
    @FXML
    private TableColumn huisNummer;
    @FXML
    private TableColumn telefoonNr;
    @FXML
    private TableColumn email;
    @FXML
    private TableColumn checkInDatum;      // lokale opslag voor klanten

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        KlantPaneController.setChildContext(this);
        tableViewListKlant.setItems(this.tableKlantenList);

        // associeer elke kolom met het juiste atribuut uit de "Klant" class
        for (int cnr = 0; cnr < tableViewListKlant.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) tableViewListKlant.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // dit gaat ervan uit dat de class getters en setters heeft 
                // die in naam matchen met de naam van het atribuut in de 
                //fx:id van de kolom
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached column" + propertyName + "in tableview to matching attribute");
            }
        }
    }

    private void refreshTable() {
        tableKlantenList = FXCollections.observableArrayList(KlantDao.getAllKlanten());
        tableViewListKlant.setItems(this.tableKlantenList);
    }
    
    @Override
    public void notifyRefresh() {
        refreshTable();
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klant getSelectedItem() {
        Klant selectedItem = (Klant) tableViewListKlant.getSelectionModel().getSelectedItem();
        return selectedItem;
    }

}
