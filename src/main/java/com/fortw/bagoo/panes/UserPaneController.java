/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.UserDao;
import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.User;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class UserPaneController implements Initializable, ParentControllerContext {

    private static ChildControllerContext listController;

    @FXML
    private AnchorPane anchorPaneKlantPane;
    @FXML
    private AnchorPane userListPane;
    @FXML
    private BorderPane nieuweUserPane;
    @FXML
    private AnchorPane bewerkUserPane;
    @FXML
    private Button knopVervers;
    @FXML
    private Button knopNieuw;
    @FXML
    private Button knopVerwijder;
    @FXML
    private StackPane stackPane;
    // Hieronder hoort dit te staan, dankzij scenebuilder kan dit misschien verwijderd worden.
    //    @FXML
    //    private MedewerkerEditPaneController medewerkerEditPaneController;
    @FXML
    private NieuweUserPaneController nieuweUserPaneController;
    @FXML
    private BewerkUserPaneController bewerkUserPaneController;
    @FXML
    private Button knopBewerk;
    @FXML
    private Label status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void hideAllPanes() {
        userListPane.setVisible(false);
        nieuweUserPane.setVisible(false);
        bewerkUserPane.setVisible(false);
        //bewerkVermissingPane.setVisible(false);

        // Enable all buttons
        knopVervers.setDisable(false);
        //knopBewerk.setDisable(false);
        knopVerwijder.setDisable(false);
        knopNieuw.setDisable(false);
    }

    public static void setChildContext(ChildControllerContext cC) {
        listController = cC;
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        listController.notifyRefresh();
    }

    @FXML
    private void handleNieuweAction(ActionEvent event) {
        hideAllPanes();
        nieuweUserPane.setVisible(true);
        nieuweUserPaneController.setParentContext(this);
    }

    @FXML
    private void handleVerwijderAction(ActionEvent event) {
        User selectedItem = (User) listController.getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting: " + selectedItem.getGebruikersnaam());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                UserDao.deleteUser(selectedItem.getPersoneelNr());
                listController.notifyRefresh();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @Override
    public void notifyCloseChild() {
        hideAllPanes();
        userListPane.setVisible(true);
    }

    @Override
    public void notifyChildHasUpdated() {
        listController.notifyRefresh();
    }

    @Override
    public void displayStatusMessage(String message) {
        status.setText(message);
    }

    @FXML
    private void handleBewerkAction(ActionEvent event) {
        User selectedItem = (User) listController.getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            hideAllPanes();
            bewerkUserPane.setVisible(true);
            bewerkUserPaneController.setParentContext(this, selectedItem);
        }
    }

}
