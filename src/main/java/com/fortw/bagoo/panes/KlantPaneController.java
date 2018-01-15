/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class KlantPaneController implements Initializable {

    @FXML
    private Button knopVervers;
    @FXML
    private Button knopNieuweKlant;
    @FXML
    private Button knopVerwijderKlant;
    @FXML
    private AnchorPane anchorPaneKlantPane;
    @FXML
    private StackPane stackPaneKlantPane;
    @FXML
    private AnchorPane anchorPaneNKlant;
    @FXML
    private AnchorPane anchorPaneListKlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void hideAllPanes() {
        anchorPaneListKlant.setVisible(false);
        anchorPaneNKlant.setVisible(false);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleNieuweKlantAction(ActionEvent event) {
        hideAllPanes();
        anchorPaneNKlant.setVisible(true);
    }

    @FXML
    private void handleVerwijderKlantAction(ActionEvent event) {
    }

}
