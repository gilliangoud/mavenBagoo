
/* Programma: MavenBagoo    
*  @Author Ramon Mocking
*  Soort: fxml Controller
*  Doel: Dit is de Controller voor het scherm "klantenopzoekenscherm", 
*  LoadDataFromDatabase laadt de database query in de tableview
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.fortw.bagoo.models.KlantOpzoeken;
import com.fortw.bagoo.interfaces.BagageDao;
import com.fortw.bagoo.interfaces.KlantOpzoekenDao;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class KlantOpzoekenSchermController implements BagageDao, KlantOpzoekenDao,
        Initializable {

    @FXML
    private AnchorPane klantOpzoeken;

//    private ObservableList<KlantOpzoeken> klantOpzoekenList
//            = FXCollections.observableArrayList(KlantOpzoekenDao.getAllKlantenOpzoeken());
    
    @FXML
    private TableView KlantenTable;
    @FXML
    private TableColumn klantNr;
    @FXML
    private TableColumn achternaam;
    @FXML
    private TableColumn voornaam;
    @FXML
    private TableColumn checkInDatum;
    
    @FXML
    private TableColumn bagageNr;
    @FXML
    private TableColumn vluchtNr;
    @FXML
    private TextField zoekVeld;
    
    @FXML
    private Button AnnulerenButton;
    @FXML
    private Button RefreshKlantenOpzoeken;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        KlantenTable.setItems(this.klantOpzoekenList);
//
//        for (int cnr = 0; cnr < KlantenTable.getColumns().size(); cnr++) {
//            TableColumn tc = (TableColumn) KlantenTable.getColumns().get(cnr);
//            String propertyName = tc.getId();
//            if (propertyName != null && !propertyName.isEmpty()) {
//                // this assumes that the class has getters and setters that match
//                // propertyname in the fx:id of the table column in the fxml view
//                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
//                //System.out.println("attached column '" + propertyName + "'");
//            }
//        }
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


    // Klanten is tijdelijk, dit is proof of concept
    @FXML
    private void handleZoekVeldAction(KeyEvent event) {
        ObservableList<KlantOpzoeken> tempList
                = FXCollections.observableArrayList(KlantOpzoekenDao.getAllKlantenOpzoeken());
    }

    @FXML
    private void handleRefreshKlantenOpzoekenAction(ActionEvent event) {
    }

}

