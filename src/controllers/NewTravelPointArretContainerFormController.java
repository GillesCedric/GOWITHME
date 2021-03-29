package controllers;

import java.sql.Time;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import utilities.Utilitie;

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
    private Label addPoint;
    
    @FXML
    void openAddPointForm(MouseEvent event) {
    	Utilitie.changeScreen("newPoint", Main.newVoyageStage);
    	NewTravelPointArretFormController controller = (NewTravelPointArretFormController) Main.controllers.get(4);
    	controller.setData(this);
    }

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
    int i = 1;
    public void savePoint(String point,Time time) {
    	if(i == 1) {
    		this.label1.setText(point);
        	this.label1.setVisible(true);
        	this.chekbox1.setSelected(true);
        	this.chekbox1.setVisible(true);
        	//this.addPoint.setLayoutY(this.addPoint.getLayoutY()+40);
    	}else if(i == 2) {
    		this.label2.setText(point);
        	this.label2.setVisible(true);
        	this.chekbox2.setSelected(true);
        	this.chekbox2.setVisible(true);
        	//this.addPoint.setLayoutY(this.addPoint.getLayoutY()+30);
    	}else if(i == 3) {
    		this.label3.setText(point);
        	this.label3.setVisible(true);
        	this.chekbox3.setSelected(true);
        	this.chekbox3.setVisible(true);
        	//this.addPoint.setLayoutY(this.addPoint.getLayoutY()+30);
    	}else if(i == 4){
    		this.label4.setText(point);
        	this.label4.setVisible(true);
        	this.chekbox4.setSelected(true);
        	this.chekbox4.setVisible(true);
        	this.addPoint.setVisible(false);
    	}else {
    		return;
    	}
    	this.addPoint.setLayoutY(this.addPoint.getLayoutY()+35);
    	i++;
    }


}
