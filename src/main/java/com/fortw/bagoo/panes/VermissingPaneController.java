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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author gilli
 */
public class VermissingPaneController implements Initializable {

    @FXML
    private Button knopVervers;
    @FXML
    private Button knopVervers1;
    @FXML
    private Button knopVervers2;
    @FXML
    private Button knopVervers3;
    @FXML
    private TableView<?> vermissingTableView;
    @FXML
    private TableColumn<?, ?> vluchthavenAITA;
    @FXML
    private TableColumn<?, ?> klantID;
    @FXML
    private TableColumn<?, ?> bagageID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleVerversAction(ActionEvent event) {
    }
    
}
