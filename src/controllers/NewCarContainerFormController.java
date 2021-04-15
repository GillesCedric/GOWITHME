package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import application.Main;
import dao.CarDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import models.Car;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.Utilitie;

public class NewCarContainerFormController implements Initializable{
	
	public static Car car = new Car();
	private NewTravelContainerFormController newTravelContainerFormController;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXButton precedent;

    @FXML
    private JFXButton suivant;

    @FXML
    private FontAwesomeIcon nextIcon;

    @FXML
    private FontAwesomeIcon lockdownButton;

    @FXML
    private JFXButton saveButton;

    @FXML
    private FontAwesomeIcon saveIcon;

    @FXML
    private Pane pane1;

    @FXML
    private JFXTextField immatriculation;

    @FXML
    private Pane pane2;

    @FXML
    private JFXTextField brand;

    @FXML
    private Pane pane3;

    @FXML
    private JFXTextField model;

    @FXML
    private Pane pane4;

    @FXML
    private JFXTextField color;

    @FXML
    void cancel(ActionEvent event) {
    	close(null);
    }

    @FXML
    void close(MouseEvent event) {
    	Main.newCarStage.close();
    }

    int show = 0;
    @FXML
    void next(ActionEvent event) {
    	switch (show) {
		case 0:		
			String immatriculation = this.immatriculation.getText();
			if (!immatriculation.isEmpty()) {
				car.setRegistration(immatriculation);
				this.cancel.setVisible(false);
	    		this.precedent.setVisible(true);
				Utilitie.translateAnimation(pane2, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir l'immatriculation de votre véhicule", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 1:
			String brand = this.brand.getText();
			if (!brand.isEmpty()) {
				car.setBrand(brand);
				Utilitie.translateAnimation(pane3, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir la marque de votre véhicule", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 2:
			String model = this.model.getText();
			if (!model.isEmpty()) {
				car.setModel(model);
				this.suivant.setVisible(false);
	    		this.nextIcon.setVisible(false);
	    		this.saveButton.setVisible(true);
	    		this.saveIcon.setVisible(true);
				Utilitie.translateAnimation(pane4, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir le modèle de votre véhicule", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
    	}
    }

    @FXML
    void previous(ActionEvent event) {
    	switch (show) {
		case 1:
			this.cancel.setVisible(true);
			this.precedent.setVisible(false);
			Utilitie.translateAnimation(pane2, false,-600);
			show--;
			break;
		case 2:
			Utilitie.translateAnimation(pane3, false,-600);
			show--;
			break;
		case 3:
			this.suivant.setVisible(true);
			this.nextIcon.setVisible(true);
			this.saveButton.setVisible(false);
			this.saveIcon.setVisible(false);
			Utilitie.translateAnimation(pane4, false,-600);
			show--;
			break;
    	}
    }

    @FXML
    void save(ActionEvent event) {
    	String color = this.color.getText();
		car.setColor(color);
		car.setUserId(Main.userConnected.getId());
		int id = new CarDao().insert(car);
		if (id != 0) {
			Utilitie.showNotification("Enregistrement effectué", "Votre véhicule a été enregistré avec succès",
					AnimationType.POPUP, NotificationType.SUCCESS, 3000);
			Utilitie.translateAnimation(pane2, false, -600);
			show = 0;
			Utilitie.changeScreen("newVoyage", null);
			this.newTravelContainerFormController.resetCars();
			Main.newCarStage.close();
		} else
			Utilitie.showNotification("Erreur", "Impossible d'enregistrer ce véhicule", AnimationType.POPUP,
					NotificationType.ERROR, 3000);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Utilitie.translateAnimation(pane2, false,600);
		Utilitie.translateAnimation(pane3, false,600);
		Utilitie.translateAnimation(pane4, false,600);
	}
	
	public void setData(NewTravelContainerFormController newTravelContainerFormController) {
    	this.newTravelContainerFormController = newTravelContainerFormController;
    }

}
