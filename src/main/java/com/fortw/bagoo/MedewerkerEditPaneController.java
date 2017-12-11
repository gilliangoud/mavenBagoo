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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.fortw.bagoo.interfaces.ParentControllerContext;
import com.fortw.bagoo.models.User;
import com.fortw.bagoo.interfaces.UserDao;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Giel
 */
public class MedewerkerEditPaneController implements Initializable {

    @FXML
    private TextField textGebruikersnaam;
    @FXML
    private TextField textWachtwoord;
    @FXML
    private Button knopReset;
    @FXML
    private Button knopClear;
    @FXML
    private Button knopCancel;
    @FXML
    private Button knopSave;
    @FXML
    private Label labelMedewerkerNr;
    @FXML
    private Label labelAangemaaktOp;
    
    private ParentControllerContext parentController;
    private User user;
    @FXML
    private ComboBox inputLevel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inputLevel.getItems().addAll(
            "1",
            "2",
            "3",
            "4",
            "5"
        );
    }    
    
    public void setParentContext(ParentControllerContext pC, User user){
        this.parentController = pC;
        this.user = user;
        this.initFields(user);
        pC.displayStatusMessage("Editing gebruiker");
    }
    
    private void initFields(User user){
        labelMedewerkerNr.setText(String.valueOf(user.getPersoneelNr()));
        textGebruikersnaam.setText(user.getGebruikersnaam());
        textWachtwoord.setText(user.getWachtwoord());
        labelAangemaaktOp.setText(user.getAangemaaktDatum());
        inputLevel.setValue(user.getLevel());
    }
    
    private void emptyFields(){
        labelMedewerkerNr.setText(String.valueOf(user.getPersoneelNr()));
        textGebruikersnaam.setText("");
        textWachtwoord.setText("");
        labelAangemaaktOp.setText(user.getAangemaaktDatum());
        inputLevel.setValue("1");
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        initFields(this.user);
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        emptyFields();
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Annuleren");
        alert.setHeaderText("Weet je zeker dat je wilt annuleren?");
        alert.setContentText("Alle onopgeslagen gegevens gaan verloren.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("Cancelled");
            this.parentController.displayStatusMessage("Cancelled editing");
            this.parentController.notifyCloseChild();
            this.user = null;
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        user.setGebruikersnaam(textGebruikersnaam.getText());
        user.setWachtwoord(textWachtwoord.getText());
        String getLevel = inputLevel.getSelectionModel().
                getSelectedItem().toString();
        user.setLevel(Integer.parseInt(getLevel));
        //System.out.println(user.getWachtwoord() + "]]");
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Opslaan");
            alert.setHeaderText("");
            alert.setContentText("Wee je zeker dat je helemaal klaar bent?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                this.parentController.displayStatusMessage("Saving: " + user.getGebruikersnaam());
                if(UserDao.updateUser(user)){
                    this.parentController.notifyChildHasUpdated();
                    this.parentController.notifyCloseChild();
                    System.out.println("done");
                } else {
                    Alert alert2 = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, The user couldnt be saved!");

                    alert.showAndWait();
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }
    }
    
}
