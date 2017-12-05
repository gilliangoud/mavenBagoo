/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane login;
    
    


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
    private void handleLoginAction(ActionEvent event) throws IOException {
     if (loginmodel.islogin(gebruikersnaam.getText(), wachtwoord.getText())){ 
     status.setText("goed");
     
       // Volgende Scherm.
    FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermService.fxml"));
    FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HoofdSchermManagement.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stageVolgende = new Stage();
    stageVolgende.setScene(new Scene (root1));
    Stage stageHuidige = (Stage) login.getScene().getWindow();
    stageHuidige.close();
    stageVolgende.show();
     }
       
      
    }}