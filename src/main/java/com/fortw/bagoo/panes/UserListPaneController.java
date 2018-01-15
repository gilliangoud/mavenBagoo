/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.Dao.UserDao;
import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.User;
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
 * @author Giel
 */
public class UserListPaneController implements Initializable, ChildControllerContext {
    
    private ObservableList<User> medewerkerList 
            = FXCollections.observableArrayList();

    @FXML
    private AnchorPane hoofdSchermService;
    @FXML
    private TableView medewerkerTableView;
    @FXML
    private TableColumn personeelNr;
    @FXML
    private TableColumn gebruikersnaam;
    @FXML
    private TableColumn aangemaaktDatum;
    @FXML
    private TableColumn level;
    @FXML
    private TableColumn wachtwoord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserPaneController.setChildContext(this);
        medewerkerList = FXCollections.observableArrayList(UserDao.getAllUsers());
        medewerkerTableView.setItems(this.medewerkerList);
        
        // associate every tableview collum with its data
        for (int cnr = 0; cnr < medewerkerTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) medewerkerTableView.getColumns().get(cnr);
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
        medewerkerList = FXCollections.observableArrayList(UserDao.getAllUsers());
        medewerkerTableView.setItems(this.medewerkerList);
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
    public User getSelectedItem() {
        User selectedItem = (User) medewerkerTableView.getSelectionModel().getSelectedItem();
        return selectedItem;
    }
    
}
