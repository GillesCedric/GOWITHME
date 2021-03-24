package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewTravelDepartHeureFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXTextField heureTextField;

    @FXML
    private JFXButton suivant;

    @FXML
    private JFXButton precedent;

    @FXML
    void next(ActionEvent event) {
    	this.newTravelContainerFormController.next("/views/NewTravelVehiculeForm.fxml","vehicule");
    }

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous("/views/NewTravelDepartDateForm.fxml","departDate");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

}
