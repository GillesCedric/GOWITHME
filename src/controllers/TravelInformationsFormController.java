package controllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TravelInformationsFormController {
	private int travelId;

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

    }

    @FXML
    void openUser(MouseEvent event) {

    }

    @FXML
    void reserve(ActionEvent event) {

    }

	/**
	 * @return the travelId
	 */
	public int getTravelId() {
		return travelId;
	}

	/**
	 * @param travelId the travelId to set
	 */
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
    
}
