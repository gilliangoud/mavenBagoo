
/* Programma: MavenBagoo    
*  @Author Ramon Mocking
*  Soort: fxml Controller
*  Doel: In deze class worden de getters en setters voor klantendata gemaakt,
*  deze gebruik ik om de data in een tableview weer te geven. 
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KlantOpzoekenSchermController implements Initializable {

    @FXML
    private TableView<KlantenData> KlantenTable;
    @FXML
    private AnchorPane klantOpzoeken;
    @FXML
    private TableColumn<KlantenData, String> columnBagageNummer;
    private TableColumn<KlantenData, String> columnFlightNummer;
    @FXML
    private TableColumn<KlantenData, String> columnAchternaam;
    @FXML
    private TableColumn<KlantenData, String> columnVoornaam;
    @FXML
    private TableColumn<KlantenData, String> columnCheckInDatum;

    @FXML
    private Button LoadKlantenData;

    // Maak een observable list aan voor de database data
    private ObservableList<KlantenData> data;
    private DbConnection dc;

    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleZoekAction(ActionEvent event) {
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HoofdSchermService.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) klantOpzoeken.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();

            // Execute query en sla deze op in een resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM c2bagoo.bagage");
            ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM c2bagoo.klant");
            while (rs.next()) {
                data.add(new KlantenData(rs.getString(1), rs.getString(12),
                        rs2.getString(4), rs2.getString(2), rs2.getString(12)));
            }

            // bagagenummer = bagage
            // flightnummer = bagage
            // achternaam = klant
            // voornaam = klant
            // check in datum = list moet nog toegevoegd worden aan klant: rij 12
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Zet de value van KlantenData.java om in tableview data. Hiervoor 
        // gebruik je de valuefactory. 
        columnBagageNummer.setCellValueFactory(new PropertyValueFactory<KlantenData, String>("bagageNummer"));
        columnFlightNummer.setCellValueFactory(new PropertyValueFactory<KlantenData, String>("flightNummer"));
        columnAchternaam.setCellValueFactory(new PropertyValueFactory<KlantenData, String>("achternaam"));
        columnVoornaam.setCellValueFactory(new PropertyValueFactory<KlantenData, String>("voornaam"));
        columnCheckInDatum.setCellValueFactory(new PropertyValueFactory<KlantenData, String>("checkInDatum"));

        KlantenTable.setItems(null);
        KlantenTable.setItems(data);
    }

}
