/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.helpers;

import com.fortw.bagoo.LoginController;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Giel
 */
public class FileSelector {
    public static File selectFile(String defaultFileName){
        Stage stage = LoginController.mainStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        return fileChooser.showOpenDialog(stage);
    }
    
}
