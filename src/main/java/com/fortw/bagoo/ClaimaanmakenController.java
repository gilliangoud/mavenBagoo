/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.function.Predicate;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 * FXML Controller class
 *
 * @author Jules
 */
public class ClaimaanmakenController implements Initializable {

    @FXML
    private AnchorPane schermClaim;
    @FXML
    private TextArea textRedenClaim;
    @FXML
    private TextField textKlantennummer;
    @FXML
    private TableView <ClaimLijst> tableClaimAanmaken;
    @FXML
    private TableColumn columnKlantennummer;
    @FXML
    private TableColumn columnDatum;
    @FXML
    private TableColumn columnReden;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList <ClaimLijst> data = FXCollections.observableArrayList();
    
    
    @FXML
    private TextField textDatum;
    @FXML
    private TextField textid;
    @FXML
    private TextField zoekVeld;
    @FXML
    private Button RefreshClaim;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       conn = DbConnection.Connect();
        SetCell();
        data =FXCollections.observableArrayList();
        LoadLogFromDataBase();
        
    }
    
   
    private void SetCell(){
        columnDatum.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        columnKlantennummer.setCellValueFactory(new PropertyValueFactory<>("Klantennummer"));
        columnReden.setCellValueFactory(new PropertyValueFactory<>("Reden"));
    }
    
    private void LoadLogFromDataBase(){
        try {
            pst = conn.prepareStatement("SELECT * FROM c2bagoo.claim");
            rs= pst.executeQuery();
            
            while (rs.next()){
            data.add(new ClaimLijst(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClaimaanmakenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableClaimAanmaken.setItems(data);
    
       
            
        
    }
    
// refresh methode         
    private void refreshTableClaimAanmaken() {

        data.clear();
         try {
            pst = conn.prepareStatement("SELECT * FROM c2bagoo.claim");
            rs= pst.executeQuery();
            
            while (rs.next()){
            data.add(new ClaimLijst(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClaimaanmakenController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    @FXML
    private void handleRefreshClaimAction(ActionEvent event) {
        refreshTableClaimAanmaken();
    }
    
    @FXML
    private void handleOpslaanAction(ActionEvent event) {
        String query = "INSERT INTO c2bagoo.claim(klantennummer,datum,reden)Values (?,?,?)";
        

        String klantennummer = textKlantennummer.getText();
        String datum = textDatum.getText();
        String reden = textRedenClaim.getText();
        
        
        try {
            
            pst = conn.prepareStatement(query);
         
            pst.setString(1, klantennummer);
            pst.setString(2, datum);
            pst.setString(3, reden);
            
            
            int i = pst.executeUpdate();
            
           if (i == 1) System.out.println("Data in database");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClaimaanmakenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTableClaimAanmaken();
        
    }
 

    @FXML
    private void handleAnnuleerAction(ActionEvent event) throws IOException {
              FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermService.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stageVolgende = new Stage();
    stageVolgende.setScene(new Scene (root1));
    Stage stageHuidige = (Stage) schermClaim.getScene().getWindow();
    stageHuidige.close();
    stageVolgende.show();
    }
    
    
    @FXML
    private void handleZoekVeldAction(KeyEvent event) {
        
        // filtert data op basis van klantennummer en reden.
      FilteredList<ClaimLijst> filteredData = new FilteredList<>(data, e -> true);
        zoekVeld.setOnKeyTyped(e->{
            zoekVeld.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filteredData.setPredicate((Predicate<? super ClaimLijst>) claimlijst->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (claimlijst.getKlantennummer().contains(newValue)) {
                    return true;
                } else if (claimlijst.getReden().toLowerCase().contains(lowerCaseFilter)) {
                     return true;

                }
                return false;
                    
                });
            });
            // weergeeft gefilterde data in een gesorteede lijst
            SortedList<ClaimLijst> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tableClaimAanmaken.comparatorProperty());
            tableClaimAanmaken.setItems(sortedData);
        });
        
       
              
    }

    

    
    
}