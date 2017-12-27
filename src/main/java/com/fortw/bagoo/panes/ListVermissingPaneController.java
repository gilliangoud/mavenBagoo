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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn datumGevonden;
    @FXML
    private TableColumn vluchthavenAITA;
    @FXML
    private TableColumn klantNr;
    @FXML
    private TableColumn bagageNr;
    @FXML
    private TableColumn vluchtNr;
    @FXML
    private TableColumn userAangemaakt;

    private ObservableList<Vermissing> tableList
            = FXCollections.observableArrayList(VermissingDao.getAllVermissingen());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VermissingPaneController.setChildContext(this);
        //theTableView.setItems(this.tableList);

        // associate every tableview collum with its data
        for (int cnr = 0; cnr < theTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) theTableView.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // this assumes that the class has getters and setters that match
                // propertyname in the fx:id of the table column in the fxml view
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                //System.out.println("attached column '" + propertyName + "'");
                //System.out.println("attached column '" + propertyName + "'");
            }
        }
    }
    
    private void refreshTable() {
        tableList
                = FXCollections.observableArrayList(VermissingDao.getAllVermissingen());
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

}
