
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.service;

import com.fortw.bagoo.Dao.Auth;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.User;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class HoofdSchermServiceController implements Initializable, ParentControllerContext {

    @FXML
    private AnchorPane hoofdSchermService;
    @FXML
    private Button knopLoguit;

    private double startMoveX = -1, startMoveY = -1, startX = -1, startY = -1;
    private Boolean dragging = false;
    @FXML
    private Tab medewerkerTab;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        User currentUser = Auth.getUser();
        if(currentUser.getLevel() == 1){medewerkerTab.setDisable(true);}
    }

    private void hideAllPanes() {
//        medewerkerTableView.setVisible(false);
//        vboxMedewerker.setVisible(false);
    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fortw/bagoo/Login.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @Override
    public void notifyCloseChild() {
        hideAllPanes();
    }

    @Override
    public void notifyChildHasUpdated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void handleCloseAction(MouseEvent event) {
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
    }

    @FXML
    private void endMoveWindow(MouseEvent event) {
        startMoveX = 0;
        startMoveY = 0;
        startX = 0;
        startY = 0;
        dragging = false;
    }

    @FXML
    private void handleMoveWindow(MouseEvent event) {
        startMoveX = event.getScreenX();
        startMoveY = event.getScreenY();
        Window w = hoofdSchermService.getScene().getWindow();
        startX = w.getX();
        startY = w.getY();
        dragging = true;
    }

    @FXML
    private void moveWindow(MouseEvent event) {
        if (dragging) {
            double endMoveX = event.getScreenX();
            double endMoveY = event.getScreenY();
            Window w = hoofdSchermService.getScene().getWindow();
            w.setX(startX + (endMoveX - startMoveX));
            w.setY(startY + (endMoveY - startMoveY));
        }
    }

}
