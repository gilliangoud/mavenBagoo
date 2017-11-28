/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class MainSceneController implements Initializable {
 public ModleLoginClass loginmodel= new ModleLoginClass();
    
 
 
 
 
 @FXML
    private TextField gebruikersnaam;
    @FXML
    private PasswordField wachtwoord;
    @FXML
    private Label status;
    
    

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         if(loginmodel.isDbConnected()){
          status.setText("Connected");
      }else{
          status.setText("not connected");
      }
    }    
   

    @FXML
    private void handleLoginAction(ActionEvent event) {
        try {
          if(loginmodel.islogin(gebruikersnaam.getText(), wachtwoord.getText())){
        status.setText("Het is goed!");
        
        }else{status.setText("niet goed");}   
     } catch (Exception e) {
         status.setText("niet goed");
        }
       
      
    
    
}
}

