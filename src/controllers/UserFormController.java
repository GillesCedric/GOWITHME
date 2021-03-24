package controllers;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class UserFormController {

    @FXML
    private Label nom;

    @FXML
    private Label compte;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private ImageView image;

    @FXML
    private JFXButton modifButton;

    @FXML
    void cancel(ActionEvent event) {
    	Main.settingContainerStage.close();
    }

    @FXML
    void modifier(ActionEvent event) {

    }

}
