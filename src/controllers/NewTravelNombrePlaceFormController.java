package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewTravelNombrePlaceFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXTextField depart;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton precedent;

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous("/views/NewTravelVehiculeForm.fxml","vehicule");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

    @FXML
    void save(ActionEvent event) {

    }

}
