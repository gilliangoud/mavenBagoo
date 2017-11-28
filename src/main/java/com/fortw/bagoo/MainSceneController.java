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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class MainSceneController implements Initializable {

    @FXML
    private TextField gebruikersnaam;
    @FXML
    private PasswordField wachtwoord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "8XSrt+sa");
            if (conn != null) {
                System.out.println("connected to database succesfully");
            }
        } catch (Exception e) {
            System.out.println("connection to database was unsuccesfull");
        }
    }
}
