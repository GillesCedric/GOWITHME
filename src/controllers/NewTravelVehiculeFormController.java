package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewTravelVehiculeFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXComboBox<?> vehicule;

    @FXML
    private JFXButton suivant;

    @FXML
    private JFXButton precedent;

    @FXML
    void next(ActionEvent event) {
    	this.newTravelContainerFormController.next("/views/NewTravelNombrePlaceForm.fxml","nombrePlace");
    }

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous("/views/NewTravelDepartHeureForm.fxml","departHeure");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

}
