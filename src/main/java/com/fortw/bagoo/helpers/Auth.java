/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.helpers;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author gilli
 */
public class Auth {
    
    public final void logout(AnchorPane ap) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fortw/bagoo/Login.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stageVolgende = new Stage();
        stageVolgende.setScene(new Scene(root1));
        Stage stageHuidige = (Stage) ap.getScene().getWindow();
        stageHuidige.close();
        stageVolgende.show();
    }
    
}
