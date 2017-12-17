/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class RapportenController implements Initializable {
     @FXML
    private TextField textVermissingenNu;
    @FXML
    private TextField textVermissingenVorigJaar;
    @FXML
    private Button buttonRefreshNu;
    @FXML
    private Button buttonRefreshVorigJaar;
    
    private Connection conn ;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @FXML
    private TableView<Vermissing> tableVermissingPerVliegveld;
    @FXML
    private TableView<Vermissing> tableVermissingPerVlucht;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = DbConnection.Connect();
        
    }   
  
  @FXML
    private void handleRefreshNuAction(ActionEvent event) {
        try{ // selecteert en telt de rijen van het attribuut klantID uit tabel vermissingen
       // 
      String sql = "SELECT count(idvermissing) FROM c2bagoo.vermissing";
  pst=conn.prepareStatement(sql);
  rs=pst.executeQuery();
  if (rs.next()){
      
  /** weergeeft het aantal rijen van het atribuut klant_id uit het tabel van 
   *  vermissingen in een textfield. 
  **/ 
      String count=rs.getString("count(idvermissing)");
      textVermissingenNu.setText(count);
      
  }
    
 }catch (SQLException e){
     Logger.getLogger(RapportenController.class.getName()).log(Level.SEVERE, null, e);
  
  }
    }

    @FXML
    private void handleRefreshVorigJaarAction(ActionEvent event) {
    }

    
    
    
}
