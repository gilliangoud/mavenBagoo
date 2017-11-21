/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author gilli
 */
public class SecondSceneController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Button addItemButton;
    @FXML
    private Button deleteItemButton;
    @FXML
    private Label label;
    @FXML
    private Label labelStatus;
    @FXML
    private TableView foundLuggageTableView;
    @FXML
    private TableColumn registrationNr;
    @FXML
    private TableColumn dateFound;
    @FXML
    private TableColumn timeFound;
    @FXML
    private TableColumn luggageType;
    @FXML
    private TableColumn brand;

    @FXML
    private TextField fieldRegistrationNr;

    private final ObservableList<FoundLuggage> foundLuggageList
            = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // add dummy
        foundLuggageList.add(new FoundLuggage(1000, "xxx", "xxx", "xxx", "xxx"));

        // test database conn
        //MyJDBC.createTestDatabase("AirlineDemo");

        // associate items with the tableview
        foundLuggageTableView.setItems(this.foundLuggageList);

        // associate every tableview collum with its data
        for (int cnr = 0; cnr < foundLuggageTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) foundLuggageTableView.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // this assumes that the class has getters and setters that match
                // propertyname in the fx:id of the table column in the fxml view
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("attached column '" + propertyName + "'");
            }
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleButtonAddItem() {
        // add dummy
        //fieldRegistrationNr.getText()
        foundLuggageList.add(new FoundLuggage());
    }

    @FXML
    private void handleButtonDeleteItem() {
        FoundLuggage selectedItem = (FoundLuggage) foundLuggageTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, you didn't select anything!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete item");
            alert.setHeaderText("Deleting item with nr: " + selectedItem.getRegistrationNr());
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                labelStatus.setText("Deleted luggage with nr: " + selectedItem.getRegistrationNr());
                foundLuggageList.remove(selectedItem);
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }

    }

}
