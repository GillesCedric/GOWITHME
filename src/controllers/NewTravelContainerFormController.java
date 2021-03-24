package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utilities.Utilitie;

public class NewTravelContainerFormController implements Initializable{

    @FXML
    private Pane pane;
    
    @FXML
    private Pane oldPane;

    @FXML
    private FontAwesomeIcon lockdownButton;

    @FXML
    void close(MouseEvent event) {
    	Main.newVoyageStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * try { root = (Parent)FXMLLoader.load(getClass().getResource(
		 * "/views/NewTravelDepartForm.fxml")); pane.getChildren().removeAll();
		 * Utilitie.makeTransitionRandom(root, pane); pane.getChildren().setAll(root);
		 * System.out.print("test"); } catch (IOException e) {
		 * Utilitie.error(NewTravelContainerFormController.class.getName(), e); }
		 */
		
	}
	
    @FXML
    void next(ActionEvent event) {
		this.next("/views/NewTravelDepartRamassageForm.fxml","departRamassage");
    }
    
	public void next(String filename,String target) {
		Pane parent;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
    		parent = loader.load();
    		
    		switch(target) {
    		case "destination":
    			NewTravelDestinationFormController destinationController = loader.getController();
    			destinationController.setData(this);
    			break;
    		case "departDate":
    			NewTravelDepartDateFormController departDateController = loader.getController();
    			departDateController.setData(this);
    			break;
    		case "departRamassage":
    			NewTravelDepartRamassageFormController departRamassageController = loader.getController();
    			departRamassageController.setData(this);
    			break;
    		case "destinationDepot":
    			NewTravelDestinationDepotFormController destinationDepotController = loader.getController();
    			destinationDepotController.setData(this);
    			break;
    		case "pointArretContainer":
    			NewTravelPointArretContainerFormController pointArretContainerController = loader.getController();
    			pointArretContainerController.setData(this);
    			break;
    		case "departHeure":
    			NewTravelDepartHeureFormController departHeureController = loader.getController();
    			departHeureController.setData(this);
    			break;
    		case "vehicule":
    			NewTravelVehiculeFormController vehiculeController = loader.getController();
    			vehiculeController.setData(this);
    			break;
    		case "nombrePlace":
    			NewTravelNombrePlaceFormController nombrePlaceController = loader.getController();
    			nombrePlaceController.setData(this);
    			break;
    		}
    		
			pane.getChildren().removeAll();
	    	Utilitie.makeTransition(parent, pane,false);
	    	pane.getChildren().setAll(parent);
		} catch (IOException e) {
			Utilitie.error(NewTravelContainerFormController.class.getName(), e);
		}
    	
	    	
	}
	
	public void previous(String filename,String target) {
		if(filename == null) {
			pane.getChildren().removeAll();
	    	Utilitie.makeTransition(oldPane, pane,true);
	    	pane.getChildren().setAll(oldPane);
	    	return;
		}
		Pane parent;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
    		parent = loader.load();
    		
    		switch(target) {
    		case "destination":
    			NewTravelDestinationFormController destinationController = loader.getController();
    			destinationController.setData(this);
    			break;
    		case "depart":
    			break;
    		case "departDate":
    			NewTravelDepartDateFormController departDateController = loader.getController();
    			departDateController.setData(this);
    			break;
    		case "departRamassage":
    			NewTravelDepartRamassageFormController departRamassageController = loader.getController();
    			departRamassageController.setData(this);
    			break;
    		case "destinationDepot":
    			NewTravelDestinationDepotFormController destinationDepotController = loader.getController();
    			destinationDepotController.setData(this);
    			break;
    		case "pointArretContainer":
    			NewTravelPointArretContainerFormController pointArretContainerController = loader.getController();
    			pointArretContainerController.setData(this);
    			break;
    		case "departHeure":
    			NewTravelDepartHeureFormController departHeureController = loader.getController();
    			departHeureController.setData(this);
    			break;
    		case "vehicule":
    			NewTravelVehiculeFormController vehiculeController = loader.getController();
    			vehiculeController.setData(this);
    			break;
    			
    		}
    		
			pane.getChildren().removeAll();
	    	Utilitie.makeTransition(parent, pane,true);
	    	pane.getChildren().setAll(parent);
	    	//System.out.print("beta ");
		} catch (IOException e) {
			Utilitie.error(NewTravelContainerFormController.class.getName(), e);
		}
		
	}

}
