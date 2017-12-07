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
import com.fortw.bagoo.interfaces.UserDao;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.fortw.bagoo.models.Klant;
import com.fortw.bagoo.interfaces.KlantDao;

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
    
    private final ObservableList<User> medewerkerList 
            = FXCollections.observableArrayList();
    private ObservableList<User> medewerkerList 
            = FXCollections.observableArrayList(UserDao.getAllUsers());
    @FXML
    private VBox vboxMedewerker;
    @FXML
    private Button knopRefreshMedewerker;
    @FXML
    private Button knopNieuweMedewerker;
    @FXML
    private Button knopVerwijderMedewerker;
    @FXML
    private Button knopVeranderMedewerker;
    @FXML
    private TableColumn klantNr;
    
    private ObservableList<Klant> klantenList 
            = FXCollections.observableArrayList(KlantDao.getAllKlanten());
    @FXML
    private TableView klantTableView;
    @FXML
    private TableColumn voorNaam;
    @FXML
    private TableColumn email;
    @FXML
    private TableColumn land;
    @FXML
    private TableColumn telefoon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        medewerkerList.add(new User("giel", "giel", 5));
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
                System.out.println("attached column '" + propertyName + "'");
                //System.out.println("attached column '" + propertyName + "'");
            }
        }
        
        // associate items with the tableview
        klantTableView.setItems(this.klantenList);
        
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

    @FXML
    private void handleLoginAction(ActionEvent event) {
    private void handleLoginAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("MainScene.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene (root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }
    
    private void allPanesInvisible(){
        this.klantTableView.setVisible(false);
        this.vboxMedewerker.setVisible(false);
        this.medewerkerTableView.setVisible(false);
        this.vboxMedewerker.setVisible(false);
    }

    @FXML
    private void handleHoofdMenuAction(ActionEvent event) {
        allPanesInvisible();
        this.kpiPane.setVisible(true);
    }

    @FXML
    private void handleLogboekAction(ActionEvent event) {
    }

    @FXML
    private void handleMedewerkersAction(ActionEvent event) {
        allPanesInvisible();
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
        allPanesInvisible();
        this.klantTableView.setVisible(true);
    }

    @FXML
    private void handleRefreshMedewerkerAction(ActionEvent event) {
        refreshMedewerkerTableView();
    }

    @FXML
    private void handleNieuweMedewerkerAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MedewerkerPane.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Nieuwe medewerker");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HoofdSchermManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refreshMedewerkerTableView(){
        ObservableList<User> tempList 
            = FXCollections.observableArrayList(UserDao.getAllUsers());
        //System.out.println("Updated");
        medewerkerList = null;
        medewerkerList = tempList;
        medewerkerTableView.setItems(medewerkerList);
    }

    @FXML
    private void handleVerwijderMedewerkerAction(ActionEvent event) {
        User selectedItem = (User) medewerkerTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting user: " + selectedItem.getGebruikersnaam());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //labelStatus.setText("Deleted luggage with nr: " + selectedItem.getGebruikersnaam());
                //foundLuggageList.remove(selectedItem);
                UserDao.deleteUser(selectedItem.getPersoneelNr());
                refreshMedewerkerTableView();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @FXML
    private void handleVerandersMedewerkerAction(ActionEvent event) {
    }
    
}
