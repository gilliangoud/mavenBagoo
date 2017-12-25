
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.service;

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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.fortw.bagoo.Dao.Auth;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class HoofdSchermServiceController implements Initializable {

    @FXML
    private AnchorPane hoofdSchermService;
    @FXML
    private Button klantzoeken;
    @FXML
    private Button knopVermissingMelden;
    @FXML
    private Button knnopOpenLogboek;
    @FXML
    private Button knopClaim;
    @FXML
    private Button knopLoguit;
    @FXML
    private StackPane contentPane;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
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

    @FXML
    private void handleOpenKlantZoeken(ActionEvent event) {
    }

    @FXML
    private void handleOpenlogBoekAction(ActionEvent event) {
    }

    @FXML
    private void handleVermissingAction(ActionEvent event) {
    }

    @FXML
    private void handleClaimAction(ActionEvent event) {
    }

}
