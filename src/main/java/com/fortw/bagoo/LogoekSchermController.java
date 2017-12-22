/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class LogoekSchermController implements Initializable {

    @FXML
    private AnchorPane schermLogboek;
    @FXML
    private TextArea textOpmerking;
    @FXML
    private TextField textEvent;
    @FXML
    private TableView <LogboekLijst> tableLogboek;
    @FXML
    private TableColumn columDate;
    @FXML
    private TableColumn columEvent;
    @FXML
    private TableColumn columOpmerking;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList <LogboekLijst> data;
    
    
    @FXML
    private TextField textDatum;
    private TextField textid;
    @FXML
    private TextField textVermissingID;
    @FXML
    private TableColumn columVermissingID;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetCell();
        data =FXCollections.observableArrayList();
        LoadLogFromDataBase();
    }
    
    private void SetCell(){
        columDate.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        columEvent.setCellValueFactory(new PropertyValueFactory<>("event"));
        columOpmerking.setCellValueFactory(new PropertyValueFactory<>("opmerking"));
        columVermissingID.setCellValueFactory(new PropertyValueFactory<>("vermissingID"));
    }
    
    private void LoadLogFromDataBase(){
        try {
            pst = conn.prepareStatement("SELECT * FROM c2bagoo.logboek");
            rs= pst.executeQuery();
            
            while (rs.next()){
            data.add(new LogboekLijst(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LogoekSchermController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableLogboek.setItems(data);
    }
    
    @FXML
    private void handleOpslaanAction(ActionEvent event) {
        String query = "INSERT INTO c2bagoo.logboek(datum,event,opmerking,idvermissing)Values (?,?,?,?)";
        

  
        String datum = textDatum.getText();
        String eventlog = textEvent.getText();
        String opmerking = textOpmerking.getText();
        String idVermissing = textVermissingID.getText();
        
        try {
            
            pst = conn.prepareStatement(query);
         
            pst.setString(1, datum);
            pst.setString(2, eventlog);
            pst.setString(3,opmerking);
            pst.setString(4, idVermissing);
            
            int i = pst.executeUpdate();
            
           if (i == 1) System.out.println("Data in database");
            
        } catch (SQLException ex) {
            Logger.getLogger(LogoekSchermController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }

    @FXML
    private void handleAnullerenAction(ActionEvent event) throws IOException {
              FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermService.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stageVolgende = new Stage();
    stageVolgende.setScene(new Scene (root1));
    Stage stageHuidige = (Stage) schermLogboek.getScene().getWindow();
    stageHuidige.close();
    stageVolgende.show();
    }

    
}
