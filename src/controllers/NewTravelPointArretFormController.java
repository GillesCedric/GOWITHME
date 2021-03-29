package controllers;

import java.sql.Time;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import application.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.Utilitie;

public class NewTravelPointArretFormController{
	private NewTravelPointArretContainerFormController newTravelPointArretContainerFormController;

    @FXML
    private JFXTextField depart;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton cancel;

    @FXML
    private FontAwesomeIcon lockdownButton;

    @FXML
    private JFXTextField heureTextField;

    @FXML
    void cancel(ActionEvent event) {
    	Main.newPointStage.close();
    	Utilitie.changeScreen("newVoyage", null);
    }

    @FXML
    void close(MouseEvent event) {
    	Main.newPointStage.close();
    	Utilitie.changeScreen("newVoyage", null);
    }

    @FXML
    void save(ActionEvent event) {
    	if(!this.depart.getText().trim().isEmpty() && !this.heureTextField.getText().trim().isEmpty()) {
    		String point = this.depart.getText();
        	Time time = Time.valueOf(this.heureTextField.getText()+":00");
        	//@todo save the point
        	this.newTravelPointArretContainerFormController.savePoint(point,time);
        	Utilitie.changeScreen("newVoyage", null);
        	Main.newPointStage.close();
    	}else {
    		 Utilitie.showNotification("Erreur", "Veuillez remplir tous les champs", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	}
    	
    }
    
    public void setData(NewTravelPointArretContainerFormController newTravelPointArretContainerFormController) {
    	this.newTravelPointArretContainerFormController = newTravelPointArretContainerFormController;
    }
    
    @FXML
    void handleKey(KeyEvent event) {
    	if(!event.getCode().equals(KeyCode.BACK_SPACE)) {
			String text = this.heureTextField.getText();
			if(text.length() == 2)											
				this.heureTextField.setText(text+":");
		}
    }

}
