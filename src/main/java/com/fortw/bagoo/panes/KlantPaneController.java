/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Klant;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class KlantPaneController implements Initializable, ParentControllerContext {

    @FXML
    private Button knopVervers;
    @FXML
    private Button knopNieuweKlant;
    @FXML
    private Button knopVerwijderKlant;
    @FXML
    private AnchorPane nieuweKlantPane;
    @FXML
    private StackPane stackPaneKlantPane;
    @FXML
    private NieuweKlantPaneController nieuweKlantPaneController;
    @FXML
    private AnchorPane anchorPaneKlantPane;
    @FXML
    private AnchorPane listKlantPane;
    private static ChildControllerContext listController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void setChildContext(ChildControllerContext cC) {
        listController = cC;
    }

    private void hideAllPanes() {
        listKlantPane.setVisible(false);
        nieuweKlantPane.setVisible(false);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        listController.notifyRefresh();
    }

    @FXML
    private void handleNieuweKlantAction(ActionEvent event) {
        hideAllPanes();
        nieuweKlantPane.setVisible(true);
        nieuweKlantPaneController.setParentContext(this);
    }

    @FXML
    private void handleVerwijderKlantAction (ActionEvent event) {
        Klant selectedItem = (Klant) listController.getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Oops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting: " + selectedItem.getKlantNr());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //labelStatus.setText("Deleted luggage with nr: " + selectedItem.getGebruikersnaam());
                //foundLuggageList.remove(selectedItem);
                KlantDao.deleteKlant(selectedItem.getKlantNr());
                this.listController.notifyRefresh();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @Override
    public void notifyCloseChild() {
        hideAllPanes();
        listKlantPane.setVisible(true);
    }

    @Override
    public void notifyChildHasUpdated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
