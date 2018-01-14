/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rayman
 */
public class ListKlantPaneController implements Initializable {

    @FXML
    private AnchorPane anchorPaneListKlant;
    @FXML
    private TableColumn<?, ?> columnKlantNr;
    @FXML
    private TableColumn<?, ?> columnVoornaam;
    @FXML
    private TableColumn<?, ?> columnTussenvoegsel;  
    @FXML
    private TableColumn<?, ?> columnAchternaam;
    @FXML
    private TableColumn<?, ?> columnPostcode;
    @FXML
    private TableColumn<?, ?> columnHuisNr;
    @FXML
    private TableColumn<?, ?> columnTelefoon;
    @FXML
    private TableColumn<?, ?> columnEmail;
    @FXML
    private TableColumn<?, ?> columnCheckin;
    @FXML
    private TableView<?> tableViewListKlant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
