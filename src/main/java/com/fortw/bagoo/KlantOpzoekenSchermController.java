
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
import com.fortw.bagoo.models.Klant;
import com.fortw.bagoo.models.Bagage;
import com.fortw.bagoo.interfaces.BagageDao;
import com.fortw.bagoo.interfaces.KlantDao;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class KlantOpzoekenSchermController implements Initializable {
public class KlantOpzoekenSchermController implements BagageDao, KlantDao,
        Initializable {

    @FXML
    private AnchorPane klantOpzoeken;

    private ObservableList<Klant> klantenOpzoekenList
            = FXCollections.observableArrayList(KlantDao.getAllKlanten());
    @FXML
    private TableColumn columnBagageNummer;
    private TableView KlantenTable;
    @FXML
    private TableColumn columnFlightNummer;
    private TableColumn klantNr;
    @FXML
    private TableColumn columnAchternaam;
    private TableColumn achternaam;
    @FXML
    private TableColumn columnVoornaam;
    private TableColumn voornaam;
    @FXML
<<<<<<< HEAD
    private TableColumn columnCheckInDatum;
    @FXML
    private TableColumn columnKlantID;
    
=======
    private TableColumn checkInDatum;
    
    private ObservableList<Bagage> bagageKlantOpzoekenList
            = FXCollections.observableArrayList(BagageDao.getAllBagage());
>>>>>>> 45efb76405848e92706a0bbbd2d078b75c6f5d84
    @FXML
    private Button LoadKlantenData;
    private TableColumn bagageNr;
    @FXML
<<<<<<< HEAD
    private Button ZoekButton;

    // Maak een observable list aan voor de database data
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs1 = null;
    private ObservableList<KlantenData> klantendata;
    
=======
    private TableColumn vluchtNr;
    
    @FXML
    private Button LoadKlantenData;
    @FXML
    private TextField zoekVeld;
>>>>>>> 45efb76405848e92706a0bbbd2d078b75c6f5d84

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
        conn = DbConnection.Connect();
        SetCell();
        klantendata = FXCollections.observableArrayList();
    }
=======
>>>>>>> 45efb76405848e92706a0bbbd2d078b75c6f5d84

        KlantenTable.setItems(this.klantenOpzoekenList);

        for (int cnr = 0; cnr < KlantenTable.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) KlantenTable.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // this assumes that the class has getters and setters that match
                // propertyname in the fx:id of the table column in the fxml view
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                //System.out.println("attached column '" + propertyName + "'");
            }
        }
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
<<<<<<< HEAD
        try {
//          Connection conn = Connection.Connect();
            klantendata = FXCollections.observableArrayList();

            // Execute query en sla deze op in een resultset
            pst = conn.prepareStatement("SELECT * FROM c2bagoo.Ramon_KlantenOpzoekenScherm");
                        
            rs1 = pst.executeQuery();

            while (rs1.next()) {
                klantendata.add(new KlantenData(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5)));
            }

            // klantID = klant
            // bagagenummer = bagage
            // flightnummer = bagage
            // achternaam = klant
            // voornaam = klant
            // check in datum = nog toevoegen aan klanten table
            
        } catch (SQLException ex) {
            Logger.getLogger(LogoekSchermController.class.getName()).log(Level.SEVERE, null, ex);
        }
        KlantenTable.setItems(klantendata);
=======
    }

    // Klanten is tijdelijk, dit is proof of concept
    @FXML
    private void handleZoekVeldAction(KeyEvent event) {
        ObservableList<Klant> tempList
                = FXCollections.observableArrayList(KlantDao.getAllKlanten());
>>>>>>> 45efb76405848e92706a0bbbd2d078b75c6f5d84
    }

}

