/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gilli
 */
public class ListVermissingPaneController implements Initializable, ChildControllerContext {

    @FXML
    private TableView theTableView;
    @FXML
    private TableColumn vermissingNr;
    @FXML
    private TableColumn userAangemaakt;

    private ObservableList<Vermissing> tableList = FXCollections.observableArrayList();
    @FXML
    private TableColumn klant;
    @FXML
    private TableColumn vluchthaven;
    @FXML
    private TableColumn vlucht;
    @FXML
    private TableColumn aangemaakt;
    @FXML
    private TableColumn bagageLabel;
    @FXML
    private AnchorPane listPane;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VermissingPaneController.setChildContext(this);
        tableList = FXCollections.observableArrayList(VermissingDao.getAllVermissingen());
        //theTableView.setItems(this.tableList);
        

        // associate every tableview collum with its data
        for (int cnr = 0; cnr < theTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) theTableView.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // this assumes that the class has getters and setters that match
                // propertyname in the fx:id of the table column in the fxml view
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
            }
        }
        
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Vermissing> filteredData = new FilteredList<>(tableList, p -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(vermissing -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (vermissing.getKlant().getVoorNaam().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (vermissing.getKlant().getAchterNaam().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Vermissing> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(theTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        theTableView.setItems(sortedData);
    }

    private void refreshTable() {
        tableList = FXCollections.observableArrayList(VermissingDao.getAllVermissingen());
        //tableList.addAll(VermissingDao.getAllVermissingen());
        theTableView.setItems(this.tableList);
    }

    @Override
    public void notifyRefresh() {
        refreshTable();
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vermissing getSelectedItem() {
        Vermissing selectedItem = (Vermissing) theTableView.getSelectionModel().getSelectedItem();
        return selectedItem;
    }

}
