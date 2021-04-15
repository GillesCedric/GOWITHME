package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.BreakpointDao;
import dao.CarDao;
import dao.TravelDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import models.Breakpoint;
import models.Car;
import models.Travel;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.Utilitie;

public class NewTravelContainerFormController implements Initializable {

	public static ArrayList<Breakpoint> breakpoints = new ArrayList<>();
	public static Travel travel = new Travel();
	public static final int WIDTH = 600;
	private CarDao carDao = new CarDao();
	private ObservableList<Car> liste = FXCollections.observableArrayList();

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
	private JFXTextField departure;

	@FXML
	private Pane pane2;

	@FXML
	private JFXTextField departureGet;

	@FXML
	private Pane pane3;

	@FXML
	private JFXTextField arrival;

	@FXML
	private Pane pane4;

	@FXML
	private JFXTextField arrivalPut;

	@FXML
	private Pane pane5;

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
	private Pane pane6;

	@FXML
	private JFXTextField departureDateTextField;

	@FXML
	private DatePicker departureDateDateField;

	@FXML
	private Pane pane7;

	@FXML
	private JFXTextField departureTime;

	@FXML
	private Pane pane9;

	@FXML
	private JFXTextField seat;

	@FXML
	private Pane pane10;

	@FXML
	private JFXTextField price;

	@FXML
	private Pane pane11;

	@FXML
	private TextArea description;

	@FXML
	private Pane pane8;
	
	@FXML
	private Pane carPane;

	@FXML
	private JFXComboBox<Car> car;

	@FXML
	private Label noCarLabel;

	@FXML
	private Label addCarLabel;

	@FXML
	void addCar(MouseEvent event) {
		Utilitie.changeScreen("newCar", Main.newVoyageStage);
		NewCarContainerFormController controller = (NewCarContainerFormController) Main.controllers.get(5);
		controller.setData(this);
	}

	@FXML
	void cancel(ActionEvent event) {
		close(null);
	}

	@FXML
	void close(MouseEvent event) {
		Main.newVoyageStage.close();
	}

	@FXML
	void openAddPointForm(MouseEvent event) {
		Utilitie.changeScreen("newPoint", Main.newVoyageStage);
		NewTravelPointArretFormController controller = (NewTravelPointArretFormController) Main.controllers.get(4);
		controller.setData(this);
	}

	int show = 0;

	@FXML
	void next(ActionEvent event) {
		switch (show) {
		case 0:
			String departure = this.departure.getText();
			if (!departure.isEmpty()) {
				travel.setDeparture(departure);
				this.cancel.setVisible(false);
				this.precedent.setVisible(true);
				Utilitie.translateAnimation(pane2, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir la ville de départ", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 1:
			String departureGet = this.departureGet.getText();
			if (!departureGet.isEmpty()) {
				travel.setDeparture(travel.getDeparture() + " " + departureGet);
				Utilitie.translateAnimation(pane3, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez le lieu où vous shouaitez prendre vos clients",
						AnimationType.POPUP, NotificationType.ERROR, 3000);
			}
			break;
		case 2:
			String arrival = this.arrival.getText();
			if (!arrival.isEmpty()) {
				travel.setArrival(arrival);
				Utilitie.translateAnimation(pane4, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir la ville de destination", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 3:
			String arrivalPut = this.arrivalPut.getText();
			if (!arrivalPut.isEmpty()) {
				travel.setArrival(travel.getArrival() + " " + arrivalPut);
				Utilitie.translateAnimation(pane5, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir le lieu où vous shouaitez déposer vos clients",
						AnimationType.POPUP, NotificationType.ERROR, 3000);
			}
			break;
		case 4:
			Utilitie.translateAnimation(pane6, false, -600);
			show++;
			break;
		case 5:
			String departureDate = this.departureDateTextField.getText();
			if (!departureDate.isEmpty()) {
				try {
					travel.setDepartureDate(Date.valueOf(departureDate));
					Utilitie.translateAnimation(pane7, false, -600);
					show++;
				} catch (IllegalArgumentException e) {
					Utilitie.error(NewTravelContainerFormController.class.getName(), e);
				}
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir la date de départ", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 6:
			String departureTime = this.departureTime.getText();
			if (!departureTime.isEmpty()) {
				travel.setDepartureTime(departureTime);
				Utilitie.translateAnimation(pane8, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir l'heure de départ", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 7:
			Car car = this.car.getValue();
			if (car != null) {
				travel.setCarId(car.getId());
				Utilitie.translateAnimation(pane9, false, -600);
				show++;
			} else {
				Utilitie.showNotification("Erreur", "Veuillez choisir un véhicule", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 8:
			String seat = this.seat.getText();
			if (!seat.isEmpty()) {
				try {
					travel.setSeat(Integer.parseInt(seat));
					Utilitie.translateAnimation(pane10, false, -600);
					show++;
				} catch (NumberFormatException e) {
					Utilitie.error(NewTravelContainerFormController.class.getName(), e);
				}
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir l'heure de départ", AnimationType.POPUP,
						NotificationType.ERROR, 3000);
			}
			break;
		case 9:
			String price = this.price.getText();
			if (!price.isEmpty()) {
				try {
					travel.setAmount(Integer.parseInt(price));
					this.suivant.setVisible(false);
					this.nextIcon.setVisible(false);
					this.saveButton.setVisible(true);
					this.saveIcon.setVisible(true);
					Utilitie.translateAnimation(pane11, false, -600);
					show++;
				} catch (NumberFormatException e) {
					Utilitie.error(NewTravelContainerFormController.class.getName(), e);
				}
			} else {
				Utilitie.showNotification("Erreur", "Veuillez saisir l'heure de départ", AnimationType.POPUP,
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
			Utilitie.translateAnimation(pane2, false, 600);
			show--;
			break;
		case 2:
			Utilitie.translateAnimation(pane3, false, 600);
			show--;
			break;
		case 3:
			Utilitie.translateAnimation(pane4, false, 600);
			show--;
			break;
		case 4:
			Utilitie.translateAnimation(pane5, false, 600);
			show--;
			break;
		case 5:
			Utilitie.translateAnimation(pane6, false, 600);
			show--;
			break;
		case 6:
			Utilitie.translateAnimation(pane7, false, 600);
			show--;
			break;
		case 7:
			Utilitie.translateAnimation(pane8, false, 600);
			show--;
			break;
		case 8:
			Utilitie.translateAnimation(pane9, false, 600);
			show--;
			break;
		case 9:
			Utilitie.translateAnimation(pane10, false, 600);
			show--;
			break;
		case 10:
			this.suivant.setVisible(true);
			this.nextIcon.setVisible(true);
			this.saveButton.setVisible(false);
			this.saveIcon.setVisible(false);
			Utilitie.translateAnimation(pane11, false, 600);
			show--;
			break;
		}
	}

	@FXML
	void save(ActionEvent event) {
		String description = this.description.getText();
		travel.setDescription(description);
		travel.setUserId(Main.userConnected.getId());
		int id = new TravelDao().insert(travel);
		if (id != 0) {
			for (Breakpoint breakpoint : breakpoints) {
				breakpoint.setTravelId(id);
			}
			new BreakpointDao().insert(breakpoints);
			Utilitie.showNotification("Enregistrement effectué", "Votre voyage a été enregistré avec succès",
					AnimationType.POPUP, NotificationType.SUCCESS, 3000);
			Utilitie.translateAnimation(pane2, false, -600);
			show = 0;
			Main.newVoyageStage.close();
		} else
			Utilitie.showNotification("Erreur", "Impossible d'enregistrer ce voyage", AnimationType.POPUP,
					NotificationType.ERROR, 3000);
	}

	int i = 1;
	public void savePoint(String point, String time) {
		breakpoints.add(new Breakpoint(point, time));
		if (i == 1) {
			this.label1.setText(point);
			this.label1.setVisible(true);
			this.chekbox1.setSelected(true);
			this.chekbox1.setVisible(true);
			// this.addPoint.setLayoutY(this.addPoint.getLayoutY()+40);
		} else if (i == 2) {
			this.label2.setText(point);
			this.label2.setVisible(true);
			this.chekbox2.setSelected(true);
			this.chekbox2.setVisible(true);
			// this.addPoint.setLayoutY(this.addPoint.getLayoutY()+30);
		} else if (i == 3) {
			this.label3.setText(point);
			this.label3.setVisible(true);
			this.chekbox3.setSelected(true);
			this.chekbox3.setVisible(true);
			// this.addPoint.setLayoutY(this.addPoint.getLayoutY()+30);
		} else if (i == 4) {
			this.label4.setText(point);
			this.label4.setVisible(true);
			this.chekbox4.setSelected(true);
			this.chekbox4.setVisible(true);
			this.addPoint.setVisible(false);
		} else {
			return;
		}
		this.addPoint.setLayoutY(this.addPoint.getLayoutY() + 35);
		i++;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Utilitie.translateAnimation(pane2, false, 600);
		Utilitie.translateAnimation(pane3, false, 600);
		Utilitie.translateAnimation(pane4, false, 600);
		Utilitie.translateAnimation(pane5, false, 600);
		Utilitie.translateAnimation(pane6, false, 600);
		Utilitie.translateAnimation(pane7, false, 600);
		Utilitie.translateAnimation(pane8, false, 600);
		Utilitie.translateAnimation(pane9, false, 600);
		Utilitie.translateAnimation(pane10, false, 600);
		Utilitie.translateAnimation(pane11, false, 600);
		
		resetCars();

		this.departureDateDateField.setOnAction(event -> {
			LocalDate date = this.departureDateDateField.getValue();
			this.departureDateTextField.setText(date.toString());
		});

	}
	
	public void resetCars() {
		ArrayList<Car> cars = carDao.list();
		if (!cars.isEmpty()) {
			liste.setAll(cars);
			this.car.setItems(liste);
			this.carPane.setVisible(true);
			this.car.setVisible(true);
			this.noCarLabel.setVisible(false);
			this.addCarLabel.setVisible(false);
		} else {
			this.carPane.setVisible(false);
			this.car.setVisible(false);
			this.noCarLabel.setVisible(true);
			this.addCarLabel.setVisible(true);
		}
	}

}
