package controllers;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import utilities.Utilitie;

public class PreferencesFormController {

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton quitBtn;

    @FXML
    private JFXButton favorisBtn;

    @FXML
    private JFXButton preferencesBtn;

    @FXML
    private JFXButton contactBtn;

    @FXML
    private JFXButton dropBtn;

    @FXML
    void cancel(ActionEvent event) {
    	Main.settingContainerStage.close();
    }

    @FXML
    void dropAccount(ActionEvent event) {

    }

    @FXML
    void openContact(ActionEvent event) {

    }

    @FXML
    void openFavoris(ActionEvent event) {

    }

    @FXML
    void openPreferences(ActionEvent event) {

    }

    @FXML
    void quit(ActionEvent event) {
    	Utilitie.closeApplication();
    }

}
