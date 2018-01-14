/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.KlantDao;
import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.Klant;
import com.fortw.bagoo.models.Vermissing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<?, ?> klant;
    @FXML
    private TableColumn<?, ?> vluchthaven;
    @FXML
    private TableColumn<?, ?> vlucht;
    @FXML
    private AnchorPane anchorPaneListKlant;
    @FXML
    private TableColumn<?, ?> aangemaakt;
    @FXML
    private TableColumn<?, ?> bagageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VermissingPaneController.setChildContext(this);
        theTableView.setItems(this.tableList);
        

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
