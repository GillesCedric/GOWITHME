package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NewTravelPointArretContainerFormController {
	
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXButton suivant;

    @FXML
    private JFXButton precedent;

    @FXML
    private Label label1;

    @FXML
    private JFXCheckBox chekbox1;

    @FXML
    private Label label2;

    @FXML
    private JFXCheckBox chekbox2;

    @FXML
    private Label label3;

    @FXML
    private JFXCheckBox chekbox3;

    @FXML
    private Label label4;

    @FXML
    private JFXCheckBox chekbox4;

    @FXML
    void next(ActionEvent event) {
    	this.newTravelContainerFormController.next("/views/NewTravelDepartDateForm.fxml","departDate");
    }

    @FXML
    void previous(ActionEvent event) {
    	this.newTravelContainerFormController.previous("/views/NewTravelDestinationDepotForm.fxml","destinationDepot");
    }
    
    public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }


}
