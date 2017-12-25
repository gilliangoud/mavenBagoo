
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.service;

import com.fortw.bagoo.Dao.VermissingDao;
import com.fortw.bagoo.models.Vermissing;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class HoofdSchermServiceController implements Initializable {

    @FXML
    private AnchorPane hoofdSchermService;
    @FXML
    private Button klantzoeken;
    @FXML
    private Button knopVermissingMelden;
    @FXML
    private Button knnopOpenLogboek;
    @FXML
    private Button knopClaim;
    @FXML
    private Button knopLoguit;

    private ObservableList<Vermissing> vermissingList
            = FXCollections.observableArrayList(VermissingDao.getAllVermissingen());

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

        //VermissingTable.setItems(this.vermissingList);

//        for (int cnr = 0; cnr < VermissingTable.getColumns().size(); cnr++) {
//            TableColumn tc = (TableColumn) VermissingTable.getColumns().get(cnr);
//            String propertyName = tc.getId();
//            if (propertyName != null && !propertyName.isEmpty()) {
//                // this assumes that the class has getters and setters that match
//                // propertyname in the fx:id of the table column in the fxml view
//                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
//                System.out.println("attached column '" + propertyName + "'");
//                //System.out.println("attached column '" + propertyName + "'");
//            }
//        }
    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void handleOpenKlantZoeken(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KlantOpzoekenScherm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void handleOpenlogBoekAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogoekScherm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

    @FXML
    private void handleVermissingAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VermissingMelden.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();

    }

    @FXML
    private void handleClaimAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Claimaanmaken.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) hoofdSchermService.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }

}
