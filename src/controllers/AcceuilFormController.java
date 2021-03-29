package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;
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
import utilities.Utilitie;

public class AcceuilFormController implements Initializable{

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
public void handleClicks(ActionEvent actionEvent) throws IOException {
	/*AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/AcceuilFormView.fxml"));
	pane.getInfosReservationAgentStylesheet();
	System.out.print(pane.getStylesheets());*/
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
    	if(!depart.isEmpty() && !destination.isEmpty() && !date.toString().isEmpty() && !this.nbPlace.getText().isEmpty()) {
    		//int nbPlace = Integer.parseInt(this.nbPlace.getText());
    		//@todo handle the serach request
    	}
    	
    }
    
    @FXML
    void close(MouseEvent event) {
		System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.date.setValue(LocalDate.now());
		this.dateTextField.setText(LocalDate.now().toString());
		
		
		
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
            	Utilitie.error(AcceuilFormController.class.getName(), e);
            }
        }
        
        date.setOnAction(event->{
        	LocalDate date = this.date.getValue();
        	this.dateTextField.setText(date.toString());
        });
		
	}

}
