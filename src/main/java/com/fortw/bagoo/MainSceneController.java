package com.fortw.bagoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainSceneController implements Initializable {
    
    @FXML
    private AnchorPane loginScherm;
    @FXML
    private Button loginKnop;
    @FXML
    private TextField gebruikersnaam;
    @FXML
    private TextField wachtwoord;
    
    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        if(gebruikersnaam.getText().equals("test") && wachtwoord.getText().equals("test"))
            System.out.println("Correct");    
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondScene.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        // scherm aanmaken
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));  
        // oude scherm selecteren
        Stage stageHuidige = (Stage) loginScherm.getScene().getWindow();
        //Scherm sluiten
        stageHuidige.close();
       //nieuwe scherm openen
        stageVolgende.show();
            
    }

    @FXML
    private void handleWachtwoordRecoverAction(ActionEvent event) throws IOException {
         System.out.println("WW vergeten");    
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("wachtwoordRecover.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        // scherm aanmaken
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));  
        // oude scherm selecteren
        Stage stageHuidige = (Stage) loginScherm.getScene().getWindow();
        //Scherm sluiten
        stageHuidige.close();
       //nieuwe scherm openen
        stageVolgende.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
