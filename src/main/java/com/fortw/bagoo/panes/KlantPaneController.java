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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleRefreshAction(ActionEvent event) {
    }

    @FXML
    private void handleNieuweKlantAction(ActionEvent event) {
    }

    @FXML
    private void handleVerwijderKlantAction(ActionEvent event) {
    }

    
}
