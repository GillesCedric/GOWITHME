package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SettingFormController {

    @FXML
    private JFXToggleButton theme;

    @FXML
    private JFXToggleButton lang;

    @FXML
    private JFXToggleButton favoris;

    @FXML
    private JFXSlider slider;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton saveButton;

    @FXML
    void cancel(ActionEvent event) {
    	Main.settingContainerStage.close();
    }

    @FXML
    void save(ActionEvent event) {

    }

}
