/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import com.fortw.bagoo.models.User;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class HoofdSchermManagementController implements Initializable {

    @FXML
    private AnchorPane hoofdSchermService;
    @FXML
    private Button knopKlanten;
    @FXML
    private Button knopLogboek;
    @FXML
    private Button knopMedewerkers;
    @FXML
    private Button knopBagage;
    @FXML
    private Button knopRapporten;
    @FXML
    private Button knopLoguit;
    @FXML
    private SplitPane kpiPane;
    @FXML
    private TableColumn personeelNr;
    @FXML
    private TableColumn gebruikersnaam;
    @FXML
    private TableColumn aangemaaktDatum;
    @FXML
    private TableColumn level;
    @FXML
    private TableColumn wachtwoord;
    @FXML
    private Button knopHoofdmenu;
    @FXML
    private TableView medewerkerTableView;
    
    private ObservableList<User> medewerkerList 
            = FXCollections.observableArrayList(User.getAllUsers());
    @FXML
    private VBox vboxMedewerker;
    @FXML
    private Button knopRefreshMedewerker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //medewerkerList.add(new User("giel", "giel","nooit", 5));
        
        // associate items with the tableview
        medewerkerTableView.setItems(this.medewerkerList);
        
        // associate every tableview collum with its data
        for (int cnr = 0; cnr < medewerkerTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) medewerkerTableView.getColumns().get(cnr);
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
    private void handleLoginAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("MainScene.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene (root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void handleHoofdMenuAction(ActionEvent event) {
        this.vboxMedewerker.setVisible(false);
        this.medewerkerTableView.setVisible(false);
        this.kpiPane.setVisible(true);
    }

    @FXML
    private void handleLogboekAction(ActionEvent event) {
    }

    @FXML
    private void handleMedewerkersAction(ActionEvent event) {
        this.kpiPane.setVisible(false);
        this.medewerkerTableView.setVisible(true);
        this.vboxMedewerker.setVisible(true);
    }

    @FXML
    private void handleBagageAction(ActionEvent event) {
    }

    @FXML
    private void handleRapportenAction(ActionEvent event) {
    }

    @FXML
    private void handleKlantenAction(ActionEvent event) {
    }

    @FXML
    private void handleRefreshMedewerkerAction(ActionEvent event) {
        ObservableList<User> tempList 
            = FXCollections.observableArrayList(User.getAllUsers());
        System.out.println("Updated");
        medewerkerList = null;
        medewerkerList = tempList;
        medewerkerTableView.setItems(medewerkerList);
        //System.out.println(tempList);
    }
    
}
