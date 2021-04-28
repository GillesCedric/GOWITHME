package controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.TravelDao;
import dao.UserDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import system.Handler;
import utilities.Keywords;
import utilities.Utilitie;

public class AcceuilFormController implements Initializable {

	private TravelDao travelDao = new TravelDao();
	private UserDao userDao = new UserDao();
	private ResultSet resultSet = null;

	@FXML
	private ImageView userProfile;

	@FXML
	private Label userName;

	@FXML
	private JFXButton acceuilButton;

	@FXML
	private JFXButton newVoyageButton;

	@FXML
	private JFXButton mesVoyagesButton;

	@FXML
	private JFXButton mesReservationsButton;

	@FXML
	private JFXButton parametresButton;

	@FXML
	private JFXButton deconnexionButton;

	@FXML
	private Pane listeReservationsPanel;

	@FXML
	private Pane listeVoyagesPanel;

	@FXML
	private Pane acceuilPanelNew;

	@FXML
	private Label chauffeurLabel;

	@FXML
	private Label nomLabel;

	@FXML
	private Label departLabel;

	@FXML
	private Label heureDepartLabel;

	@FXML
	private Label destinationLabel;

	@FXML
	private Label heureArriveeLabel;

	@FXML
	private Label placeLabel;

	@FXML
	private Label montantLabel;

	@FXML
	private VBox pnItems;

	@FXML
	private JFXTextField depart;

	@FXML
	private JFXTextField destination;

	@FXML
	private JFXTextField nbPlace;

	@FXML
	private JFXTextField dateTextField;

	@FXML
	private JFXButton searchButton;

	@FXML
	private FontAwesomeIcon lockdownButton;

	@FXML
	private DatePicker date;

	@FXML
	public void handleClicks(ActionEvent actionEvent){
		/*
		 * AnchorPane pane =
		 * FXMLLoader.load(getClass().getResource("/views/AcceuilFormView.fxml"));
		 * pane.getInfosReservationAgentStylesheet();
		 * System.out.print(pane.getStylesheets());
		 */
		if (actionEvent.getSource() == acceuilButton) {
			acceuilPanelNew.setStyle("-fx-background-color : #02030A");
			acceuilPanelNew.toFront();
		}
		if (actionEvent.getSource() == this.mesVoyagesButton) {
			this.listeVoyagesPanel.setStyle("-fx-background-color : #02030A");
			listeVoyagesPanel.toFront();
		}
		if (actionEvent.getSource() == mesReservationsButton) {
			mesReservationsButton.setStyle("-fx-background-color : #02030A");
			listeReservationsPanel.toFront();
		}
		if (actionEvent.getSource() == deconnexionButton) {
			Main.userConnected = null;
			Utilitie.changeScreen("login", Main.acceuilStage);
		}
		if (actionEvent.getSource() == parametresButton) {
			Utilitie.changeScreen("setting", null);
		}
		if (actionEvent.getSource() == newVoyageButton) {
			Utilitie.changeScreen("newVoyage", null);
		}
	}

	@FXML
	void search(ActionEvent event) {
		String depart = this.depart.getText();
		String destination = this.destination.getText();
		LocalDate date = this.date.getValue();
		if (!depart.isEmpty() && !destination.isEmpty() && !date.toString().isEmpty()
				&& !this.nbPlace.getText().isEmpty()) {
			int nbPlace = Integer.parseInt(this.nbPlace.getText());
			String sql = "SELECT users.name, users.picture, travels.id, travels.departure, travels.departureDate, travels.departureTime, travels.arrival, travels.seat, travels.amount, AVG(marks.mark) AS mark FROM users INNER JOIN travels ON users.id=travels.userId LEFT JOIN marks ON users.id=marks.userIdMarkee WHERE (travels.departure LIKE \""+depart+"%\" OR travels.id IN (SELECT breakpoints.travelId FROM breakpoints WHERE breakpoints.travelId=travels.id AND breakpoints.point LIKE \""+depart+"%\")) AND (travels.arrival LIKE \""+destination+"%\" OR travels.id IN (SELECT breakpoints.travelId FROM breakpoints WHERE breakpoints.travelId=travels.id AND breakpoints.point LIKE \""+destination+"%\")) AND travels.seat>="+nbPlace+" AND travels.departureDate>CURRENT_DATE ORDER BY marks.mark ASC";
			System.out.println(sql);
			loadData(sql);
		}

	}

	@FXML
	void close(MouseEvent event) {
		Utilitie.closeApplication();
	}
	
	public void loadUser() {
		resultSet = userDao.request("SELECT * FROM users WHERE id="+Main.userConnected.getId());
		if(resultSet != null) {
			try {
				if(resultSet.next()) {
					this.userName.setText(resultSet.getString("lastName")+" "+resultSet.getString("name"));
					Main.handleServer.write(new Handler<>(Keywords.getImageUser, null,resultSet.getString("picture")));
			    	Utilitie.sleep(500);
			    	this.userProfile.setImage(new Image(new ByteArrayInputStream(Main.handleServer.getImage())));
				}
			} catch (SQLException e) {
				Utilitie.error(AcceuilFormController.class.getName(), e);
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.date.setValue(LocalDate.now());
		this.dateTextField.setText(LocalDate.now().toString());

		loadData(null);

		date.setOnAction(event -> {
			LocalDate date = this.date.getValue();
			this.dateTextField.setText(date.toString());
		});

	}

	private void loadData(String sql) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		if (sql == null)
			sql = "SELECT users.name,users.picture,travels.id,travels.departure,travels.departureDate,travels.departureTime,travels.arrival,travels.seat,travels.amount,AVG(marks.mark) AS mark FROM users INNER JOIN travels ON users.id=travels.userId LEFT JOIN marks ON users.id=marks.userIdMarkee";
		resultSet = travelDao.request(sql);
		try {
			int i = 0;
			//if(resultSet.size)
			pnItems.getChildren().removeAll();
			while (resultSet.next()) {
				final int j = i;
				FXMLLoader item = new FXMLLoader(getClass().getResource("/views/Item.fxml"));
				Node node = item.load();
				ItemController controller = item.getController();
				//if(resultSet.getFetchSize() == 0) return;
				controller.setData(resultSet);
				nodes.add(i, node);

				// give the items some effect

				nodes.get(i).setOnMouseEntered(event -> {
					nodes.get(j).setStyle("-fx-background-color : #0A0E3F");
				});
				nodes.get(i).setOnMouseExited(event -> {
					nodes.get(j).setStyle("-fx-background-color : #02030A");
				});
				pnItems.getChildren().add(nodes.get(i));
				i++;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			Utilitie.error(AcceuilFormController.class.getName(), e);
		}

	}

}
