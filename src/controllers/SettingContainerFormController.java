package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import utilities.Utilitie;

public class SettingContainerFormController implements Initializable{

    @FXML
    private JFXButton settingButton;

    @FXML
    private JFXButton userButton;

    @FXML
    private JFXButton cardButton;

    @FXML
    private JFXButton favorisButton;

    @FXML
    private Pane pane;

    @FXML
    void openCard(ActionEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/views/CardForm.fxml"));
			pane.getChildren().removeAll();
			Utilitie.makeTransitionRandom(fxml, pane);
			pane.getChildren().setAll(fxml);
		} catch (IOException e) {
			Utilitie.error(SettingContainerFormController.class.getName(), e);
		}
    }

    @FXML
    void openFavoris(ActionEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PreferencesForm.fxml"));
			pane.getChildren().removeAll();
			Utilitie.makeTransitionRandom(fxml, pane);
			pane.getChildren().setAll(fxml);
		} catch (IOException e) {
			Utilitie.error(SettingContainerFormController.class.getName(), e);
		}
    }

    @FXML
    void openSetting(ActionEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/views/SettingForm.fxml"));
			pane.getChildren().removeAll();
			Utilitie.makeTransitionRandom(fxml, pane);
			pane.getChildren().setAll(fxml);
		} catch (IOException e) {
			Utilitie.error(SettingContainerFormController.class.getName(), e);
		}
    }

    @FXML
    void openUser(ActionEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/views/UserForm.fxml"));
			pane.getChildren().removeAll();
			Utilitie.makeTransitionRandom(fxml, pane);
			pane.getChildren().setAll(fxml);
		} catch (IOException e) {
			Utilitie.error(SettingContainerFormController.class.getName(), e);
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			Parent fxml = (Parent)FXMLLoader.load(getClass().getResource("/views/SettingForm.fxml"));
			pane.getChildren().removeAll();
			Utilitie.makeTransitionRandom(fxml, pane);
			pane.getChildren().setAll(fxml);
		} catch (IOException e) {
			Utilitie.error(SettingContainerFormController.class.getName(), e);
		}
		
	}

}
