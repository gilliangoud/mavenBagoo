/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.panes;

import com.fortw.bagoo.interfaces.ChildControllerContext;
import com.fortw.bagoo.models.Bagage;
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
 * @author Anouar
 */
public class ListBagagePaneController implements Initializable,ChildControllerContext {

    private ObservableList<Bagage> bagagelist = FXCollections.observableArrayList();
    @FXML
    private AnchorPane listBagageAnchorPane;
    @FXML
    private TableView <Bagage> listBagageTableview;
    @FXML
    private TableColumn columnIDBagage;
    @FXML
    private TableColumn columnTypeBagge;
    @FXML
    private TableColumn columnMerk;
    @FXML
    private TableColumn columnKleur;
    @FXML
    private TableColumn columnLocatie;
    @FXML
    private TableColumn columnGewicht;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         BagagePaneController.setChildContext(this);
        listBagageTableview.setItems(this.bagagelist);

        // associeer elke kolom met het juiste atribuut uit de "Klant" class
        for (int cnr = 0; cnr < listBagageTableview.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) listBagageTableview.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                // dit gaat ervan uit dat de class getters en setters heeft 
                // die in naam matchen met de naam van het atribuut in de 
                //fx:id van de kolom
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached column" + propertyName + "in tableview to matching attribute");
            }
        }
    }

    @Override
    public void notifyRefresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
