package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utilities.Utilitie;

public class RegistrationFormController {
	
	private boolean visible = false;

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField cni;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton registrationBtn;

    @FXML
    private FontAwesomeIcon closeBtn;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField tel;

    @FXML
    private FontAwesomeIcon backBtn;
    
    @FXML
    private JFXTextField passwordVisible;
    
    @FXML
    private FontAwesomeIcon makePasswordVisibleBtn;

    @FXML
    void backToLoginForm(MouseEvent event) throws IOException {
    	Parent root = (Parent)FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
    	Main.stage.getScene().setRoot(root);
    	Utilitie.autoriseDeplacement(root, Main.stage);
    }

    @FXML
    void closeApp(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void registration(ActionEvent event) {

    }
    
    @FXML
    void makePasswordVisible(MouseEvent event) {
    	if(!visible) {
    		passwordVisible.setText(password.getText());
        	passwordVisible.setVisible(true);
        	password.setVisible(false);
        	this.visible = true;
    	}else {
    		password.setText(passwordVisible.getText());
    		password.setVisible(true);
        	passwordVisible.setVisible(false);
        	this.visible = false;
    	}
    	
    }

}
