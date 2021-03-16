package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AcceuilFormController implements Initializable{

    @FXML
    private ImageView userProfile;

    @FXML
    private Label userName;

    @FXML
    private JFXButton acceuilButton;

    @FXML
    private JFXButton newReservationButton;

    @FXML
    private JFXButton listeChambresButton;

    @FXML
    private JFXButton listeClientsButton;

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
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }
    
    @FXML
    void close(MouseEvent event) {
		System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/views/Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}

}
