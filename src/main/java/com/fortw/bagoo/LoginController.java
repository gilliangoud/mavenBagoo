
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import com.fortw.bagoo.Dao.Auth;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.fortw.bagoo.models.User;
import com.fortw.bagoo.Dao.UserDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class LoginController implements Initializable {

    @FXML
    private TextField gebruikersnaam;
    @FXML
    private PasswordField wachtwoord;

    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

//        if (loginmodel.isDbConnected()) {
//            status.setText("Connected");
//        } else {
//            status.setText("not connected");
//        }
        //sendNextScene(1);
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        login();
    }
    
    @FXML
    private void handleKeyPressedAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login();
        }
    }
    
    private void login(){
        User user = UserDao.getUserByUserNameAndPassword(gebruikersnaam.getText(), wachtwoord.getText());
        if (user != null) {
            Auth.setUser(user);
            sendNextScene(user.getLevel());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops!");
            alert.setContentText("De gebruikersnaam, wachtwoord of de "
                    + "combinatie er van is niet goed.");
            alert.showAndWait();
        }
    }
    
    private void sendNextScene(int userLevel) {
        String doel;
        switch(userLevel){
//            case 5: doel = "/com/fortw/bagoo/manager/HoofdSchermManagement.fxml";
//            break;
            default: doel = "/com/fortw/bagoo/service/HoofdSchermService.fxml";         
        }
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("com.fortw.bagoo.locale.Locale");
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource(doel), bundle);
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageVolgende = new Stage();
            stageVolgende.setScene(new Scene(root1));
            Stage stageHuidige = (Stage) ap.getScene().getWindow();
            stageHuidige.close();
            stageVolgende.initStyle(StageStyle.TRANSPARENT);
            stageVolgende.show();
            //stageVolgende.setMaximized(true);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

