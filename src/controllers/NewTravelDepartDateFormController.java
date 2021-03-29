package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class NewTravelDepartDateFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXTextField dateTextField;

    @FXML
    private DatePicker date;

    @FXML
    private JFXButton suivant;

    @FXML
    private JFXButton precedent;

    @FXML
    void next(ActionEvent event) {
    	this.newTravelContainerFormController.next("/views/NewTravelDepartHeureForm.fxml","departHeure");
    }

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous("/views/NewTravelPointArretContainerForm.fxml","pointArretContainer");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

}