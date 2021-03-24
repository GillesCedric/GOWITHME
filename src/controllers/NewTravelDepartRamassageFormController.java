package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewTravelDepartRamassageFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXTextField ramassage;

    @FXML
    private JFXButton suivant;

    @FXML
    private JFXButton precedent;

    @FXML
    void next(ActionEvent event) {
    	this.newTravelContainerFormController.next("/views/NewTravelDestinationForm.fxml","destination");
    }

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous(null,"depart");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

}
