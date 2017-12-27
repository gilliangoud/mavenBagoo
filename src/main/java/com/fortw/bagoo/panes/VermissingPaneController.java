/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.interfaces.ChildControllerContext;
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
 * @author gilli
 */
public class VermissingPaneController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Button knopVervers;
    @FXML
    private Button knopBewerk;
    @FXML
    private Button knopVerwijder;
    @FXML
    private Button knopNieuw;
    @FXML
    private AnchorPane nieuweAnchorPane;
    @FXML
    private AnchorPane listPane;
    
    private static ChildControllerContext listController;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        // show the main data, main screen
        listPane.setVisible(true);
    } 
    
    public static void setChildContext(ChildControllerContext cC){
        listController = cC;
    }
    
    private void hideAll() {
        listPane.setVisible(false);
        nieuweAnchorPane.setVisible(false);
    }

    @FXML
    private void handleVerversAction(ActionEvent event) {
        this.listController.notifyRefresh();
    }

    @FXML
    private void handleBewerkAction(ActionEvent event) {
        hideAll();
        listPane.setVisible(true);
    }


    @FXML
    private void handleNieuwAction(ActionEvent event) {
        hideAll();
        nieuweAnchorPane.setVisible(true);
    }

    @FXML
    private void handleVerwijderAction(ActionEvent event) {
    }
    
}
