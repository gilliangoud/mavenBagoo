/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

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
    private TableView<?> tableLogboek;
    @FXML
    private TableColumn<?, ?> columDate;
    @FXML
    private TableColumn<?, ?> columEvent;
    @FXML
    private TableColumn<?, ?> columOpmerking;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    @FXML
    private TextField textDatum;
    private TextField textid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       conn = MysqlConnection.connector();
               
    }    
    
    @FXML
    private void handleOpslaanAction(ActionEvent event) {
        String query = "INSERT INTO mydb.logboek(datum,event,opmerking)Values (?,?,?)";
        

  
        String datum = textDatum.getText();
        String eventlog = textEvent.getText();
        String opmerking = textOpmerking.getText();
        
        try {
            
            pst = conn.prepareStatement(query);
         
            pst.setString(1, datum);
            pst.setString(2, eventlog);
            pst.setString(3, opmerking);
            
            int i = pst.executeUpdate();
            
           if (i == 1) System.out.println("Data in database");
            
        } catch (SQLException ex) {
            Logger.getLogger(LogoekSchermController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAnullerenAction(ActionEvent event) {
        
    }
    
}
