/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.BagageDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.Bagage;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class BagagePaneController implements Initializable, ParentControllerContext {

    @FXML
    private AnchorPane bagageAnchorPane;
    @FXML
    private Button buttonVerversBagage;
    @FXML
    private Button buttonNieuweBagage;
    @FXML
    private Button buttonVerwijderBagage;
    @FXML
    private AnchorPane listBagagePane;
    @FXML
    private AnchorPane nieuwBagagePane;
    @FXML
    private NieuwBagagePaneController nieuwBagagePaneController;
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
        listBagagePane.setVisible(false);
        nieuwBagagePane.setVisible(false);
    }

    @FXML
    private void handleVerversAction(ActionEvent event) {
        listController.notifyRefresh();
    }

    @FXML
    private void handleNieuweBagageAction(ActionEvent event) {
        hideAllPanes();
        nieuwBagagePane.setVisible(true);
        nieuwBagagePaneController.setParentContext(this);
    }

    @FXML
    private void handleVerwijderBagageAction(ActionEvent event) {
        Bagage selectedItem = (Bagage) listController.getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Oops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting: " + selectedItem.getBagageNr());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                BagageDao.deleteBagage(selectedItem.getBagageNr());
                this.listController.notifyRefresh();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    @Override
    public void notifyCloseChild() {
        hideAllPanes();
        listBagagePane.setVisible(true);
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
