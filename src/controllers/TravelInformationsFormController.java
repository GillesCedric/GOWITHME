package controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import application.Main;
import dao.BreakpointDao;
import dao.TravelDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import system.Handler;
import utilities.Keywords;
import utilities.Utilitie;

public class TravelInformationsFormController {
	private int travelId;
	private TravelDao travelDao = new TravelDao();

	@FXML
	private Label date;

	@FXML
	private Label amount;

	@FXML
	private Pane user;

	@FXML
	private Label username;

	@FXML
	private Label mark;

	@FXML
	private ImageView image;

	@FXML
	private Label description;

	@FXML
	private VBox pnItems;

	@FXML
	private FontAwesomeIcon lockdownButton;

	@FXML
	private JFXButton reservationBtn;

	@FXML
	private ImageView imageCar;

	@FXML
	private Label brand;

	@FXML
	private Label color;

	@FXML
	private HBox preferences;

	@FXML
	void close(MouseEvent event) {
		Main.travelInsformationsStage.close();
	}

	@FXML
	void openUser(MouseEvent event) {

	}

	@FXML
	void reserve(ActionEvent event) {
		Utilitie.changeScreen("paymentMode", Main.travelInsformationsStage);
	}

	public void setData(int id) {
		this.travelId = id;
		String sql = "SELECT users.name,users.lastName,users.picture AS userPicture,travels.departureDate,travels.amount,travels.description,COUNT(marks.mark) AS totalMarks,AVG(marks.mark) AS avgMarks,cars.brand,cars.model,cars.color,cars.picture AS carPicture FROM users INNER JOIN travels ON users.id=travels.userId LEFT JOIN marks ON users.id=marks.userIdMarkee INNER JOIN cars ON users.id=cars.userId WHERE travels.id="
				+ id;
		ResultSet resultSet = travelDao.request(sql);
		try {
			if (resultSet.next()) {
				this.date.setText(resultSet.getString("departureDate"));
				this.amount.setText(String.valueOf(resultSet.getInt("amount")) + " Fcfa");
				this.description.setText(resultSet.getString("description"));
				this.brand.setText(resultSet.getString("brand") + " " + resultSet.getString("model"));
				this.color.setText(resultSet.getString("color"));
				this.mark.setText(String.valueOf(Math.round(resultSet.getDouble("avgMarks") * 100.0) / 100.0)
						+ " / 5 - " + resultSet.getString("totalMarks") + " avis");
				Main.handleServer.write(new Handler<>(Keywords.getImageUser, null, resultSet.getString("userPicture")));
				Utilitie.sleep(500);
				this.image.setImage(new Image(new ByteArrayInputStream(Main.handleServer.getImage())));
				Main.handleServer.write(new Handler<>(Keywords.getImageCar, null, resultSet.getString("carPicture")));
				Utilitie.sleep(500);
				this.imageCar.setImage(new Image(new ByteArrayInputStream(Main.handleServer.getImage())));
			}
		} catch (SQLException e) {
			Utilitie.error(TravelInformationsFormController.class.getName(), e);
		}

		sql = "SELECT breakpoints.point,breakpoints.time FROM breakpoints WHERE breakpoints.travelId=" + id;
		resultSet = new BreakpointDao().request(sql);
		ArrayList<Node> nodes = new ArrayList<Node>();
		try {
			int i = 0;
			while (resultSet.next()) {
				FXMLLoader breakpoint = new FXMLLoader(getClass().getResource("/views/Breakpoints.fxml"));
				Node node = breakpoint.load();
				BreakpointsController controller = breakpoint.getController();
				controller.setData(resultSet);
				nodes.add(i, node);
				
				// give the items some effect
				pnItems.getChildren().add(nodes.get(i));
				i++;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			Utilitie.error(TravelInformationsFormController.class.getName(), e);
		}
	}

	public int getTravelId() {
		return travelId;
	}

}
