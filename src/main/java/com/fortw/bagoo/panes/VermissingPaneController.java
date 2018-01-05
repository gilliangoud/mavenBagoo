/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author gilli
 */
public class VermissingPaneController implements Initializable, ParentControllerContext{

    @FXML
    private StackPane stackPane;
    private Button knopVervers;
    private Button knopBewerk;
    private Button knopVerwijder;
    private Button knopNieuw;
    private AnchorPane nieuweAnchorPane;
    private AnchorPane bewerkVermissingPane;
    private AnchorPane listPane;
    private static ChildControllerContext listController;
    private Label labelStatus;
    // Hieronder hoort dit te staan, dankzij scenebuilder kan dit misschien verwijderd worden.
    //    @FXML
    //    private MedewerkerEditPaneController medewerkerEditPaneController;
    private BewerkVermissingPaneController bewerkVermissingPaneController;
    @FXML
    private AnchorPane klantenPane;
    @FXML
    private Button knopVerversKlant;
    @FXML
    private Button knopBewerkKlant;
    @FXML
    private Button knopVerwijderKlant;
    @FXML
    private Button knopNieuweKlant;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        // show the main data, main screen
//        listPane.setVisible(true);
    } 
    
    public static void setChildContext(ChildControllerContext cC){
        listController = cC;
    }
    
    private void hideAllPanes() {
        listPane.setVisible(false);
        nieuweAnchorPane.setVisible(false);
        bewerkVermissingPane.setVisible(false);
        
        // Enable all buttons
        knopVervers.setDisable(false);
        knopBewerk.setDisable(false);
        knopVerwijder.setDisable(false);
        knopNieuw.setDisable(false);
    }

    @FXML
    private void handleVerversAction(ActionEvent event) {
        this.listController.notifyRefresh();
    }

    @FXML
    private void handleBewerkAction(ActionEvent event) {
        Vermissing selectedItem = listController.getSelectedItem();
        
        knopVervers.setDisable(true);
        knopBewerk.setDisable(false);
        knopVerwijder.setDisable(true);
        knopNieuw.setDisable(true);
        
        if (selectedItem == null) {
            //niks geselecteerd
        } else {
            bewerkVermissingPaneController.setParentContext(this, selectedItem);
            hideAllPanes();
            bewerkVermissingPane.setVisible(true);
        }
    }


    @FXML
    private void handleNieuwAction(ActionEvent event) {
        hideAllPanes();
        nieuweAnchorPane.setVisible(true);
        NieuwVermissingPaneController.setParentContext(this);
        knopVervers.setDisable(true);
        knopBewerk.setDisable(true);
        knopVerwijder.setDisable(true);
        knopNieuw.setDisable(false);
    }

    @FXML
    private void handleVerwijderAction(ActionEvent event) {
        Vermissing selectedItem = listController.getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting user: " + selectedItem.getVermissingNr());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //labelStatus.setText("Deleted luggage with nr: " + selectedItem.getGebruikersnaam());
                //foundLuggageList.remove(selectedItem);
                VermissingDao.deleteVermissing(selectedItem.getVermissingNr());
                this.listController.notifyRefresh();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @Override
    public void notifyCloseChild() {
        hideAllPanes();
        listPane.setVisible(true);
    }

    @Override
    public void notifyChildHasUpdated() {
        this.listController.notifyRefresh();
    }

    @Override
    public void displayStatusMessage(String message) {
        labelStatus.setText(message);
    }
    
}
