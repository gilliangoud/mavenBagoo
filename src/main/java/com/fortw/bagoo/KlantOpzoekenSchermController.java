
/* Programma: MavenBagoo    
*  @Author Ramon Mocking
*  Soort: fxml Controller
*  Doel: Dit is de Controller voor het scherm "klantenopzoekenscherm", 
*  LoadDataFromDatabase laadt de database query in de tableview
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KlantOpzoekenSchermController implements Initializable {

    @FXML
    private TableView<KlantenData> KlantenTable;
    @FXML
    private AnchorPane klantOpzoeken;
    @FXML
    private TableColumn columnKlantID;
    @FXML
    private TableColumn columnBagageNummer;
    @FXML
    private TableColumn columnFlightNummer;
    @FXML
    private TableColumn columnAchternaam;
    @FXML
    private TableColumn columnVoornaam;
//    @FXML
//    private TableColumn columnCheckInDatum;

    @FXML
    private Button LoadKlantenData;
    @FXML
    private Button ZoekButton;

    // Maak een observable list aan voor de database data
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs1 = null;
    private ObservableList<KlantenData> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = DbConnection.Connect();
        SetCell();
        data = FXCollections.observableArrayList();
    }

    private void SetCell() {
        columnKlantID.setCellValueFactory(new PropertyValueFactory<>("klantID"));
        columnBagageNummer.setCellValueFactory(new PropertyValueFactory<>("bagageNummer"));
        columnFlightNummer.setCellValueFactory(new PropertyValueFactory<>("flightNummer"));
        columnVoornaam.setCellValueFactory(new PropertyValueFactory<>("bagageNummer"));
        columnAchternaam.setCellValueFactory(new PropertyValueFactory<>("achternaam"));
//      columnCheckInDatum.setCellValueFactory(new PropertyValueFactory<>("checkInDatum"));
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
//          Connection conn = Connection.Connect();
            data = FXCollections.observableArrayList();
            //Connection conn = 
            //data = FXCollections.observableArrayList();

            // Execute query en sla deze op in een resultset
            pst = conn.prepareStatement("SELECT * FROM c2bagoo.Ramon_KlantenOpzoekenScherm");
                        
            rs1 = pst.executeQuery();

            while (rs1.next()) {
                data.add(new KlantenData(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5)));
            }

            // bagagenummer = bagage
            // flightnummer = bagage
            // achternaam = klant
            // voornaam = klant
            // check in datum = list moet nog toegevoegd worden aan klant: rij 12
            
        } catch (SQLException ex) {
            Logger.getLogger(LogoekSchermController.class.getName()).log(Level.SEVERE, null, ex);
        }
        KlantenTable.setItems(data);
    }

}

