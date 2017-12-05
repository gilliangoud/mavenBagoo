
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
    private TableColumn columnBagageNummer;
    private TableColumn columnFlightNummer;
    @FXML
    private TableColumn columnAchternaam;
    @FXML
    private TableColumn columnVoornaam;
    @FXML
    private TableColumn columnCheckInDatum;

    @FXML
    private Button LoadKlantenData;

    // Maak een observable list aan voor de database data
    private Connection conn = null;
    private ObservableList<KlantenData> data;
    
   

    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = DbConnection.Connect();
        SetCell();
         data =FXCollections.observableArrayList();
    }

         private void SetCell(){
         columnBagageNummer.setCellValueFactory(new PropertyValueFactory<>("bagageNummer"));
         columnFlightNummer.setCellValueFactory(new PropertyValueFactory<>("flightNummer"));
         columnVoornaam.setCellValueFactory(new PropertyValueFactory<>("bagageNummer"));
         columnAchternaam.setCellValueFactory(new PropertyValueFactory<>("achternaam"));
         columnCheckInDatum.setCellValueFactory(new PropertyValueFactory<>("checkInDatum"));
        
         
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


            // bagagenummer = bagage
            // flightnummer = bagage
            // achternaam = klant
            // voornaam = klant
   
    }


