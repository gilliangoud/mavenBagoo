/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class KlantOpzoekenSchermController implements Initializable {

    @FXML
    private AnchorPane klantOpzoeken;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleZoekAction(ActionEvent event) {
    }

    @FXML
    private void handleAnnulerenAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermService.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stageVolgende = new Stage();
    stageVolgende.setScene(new Scene (root1));
    Stage stageHuidige = (Stage) klantOpzoeken.getScene().getWindow();
    stageHuidige.close();
    stageVolgende.show();
    }
    
}
