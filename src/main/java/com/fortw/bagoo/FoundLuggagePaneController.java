/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gilli
 */
public class FoundLuggagePaneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private ParentControllerContext parentController;
    private FoundLuggage foundLuggage;

    void setParentContext(ParentControllerContext pC, FoundLuggage selectedItem) {
        this.parentController = pC;
        this.foundLuggage = selectedItem;
        this.initFields(selectedItem);
        pC.displayStatusMessage("Editing found luggage...");
    }
    
    @FXML
    private Label registrationNr;
    @FXML
    private TextField dateFound;
    @FXML
    private TextField timeFound;
    @FXML
    private TextField luggageType;
    @FXML
    private TextField brand;

    private void initFields(FoundLuggage selectedItem) {
        registrationNr.setText("test");
//        System.out.println("][" + selectedItem.getRegistrationNr());
//        registrationNr.setText(String.valueOf(selectedItem.getRegistrationNr()));
//        dateFound.setText(selectedItem.getDateFound());
//        timeFound.setText(selectedItem.getTimeFound());
//        luggageType.setText(selectedItem.getLuggageType());
//        brand.setText(selectedItem.getBrand());
    }
    
}
