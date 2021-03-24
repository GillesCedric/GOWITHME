package controllers;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CardFormController {

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton modifButton;

    @FXML
    private Label stripeLabel;

    @FXML
    private Label paypalLabel;

    @FXML
    void cancel(ActionEvent event) {
    	Main.settingContainerStage.close();
    }

    @FXML
    void openPaypal(MouseEvent event) {

    }

    @FXML
    void openStripe(MouseEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

}
