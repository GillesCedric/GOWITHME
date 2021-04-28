package controllers;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import system.Handler;
import utilities.Keywords;
import utilities.Utilitie;

public class ItemController {

    @FXML
    private Pane pane;

    @FXML
    private ImageView image;

    @FXML
    private Label nom;

    @FXML
    private Label depart;

    @FXML
    private Label heureDepart;

    @FXML
    private Label arrivee;

    @FXML
    private Label note;

    @FXML
    private Label heureArrivee;

    @FXML
    private Label place;

    @FXML
    private Label montant;

    @FXML
    private Label id;

    @FXML
    void moreInfo(MouseEvent event) {
    	
    }
    
    public void setData(ResultSet resultSet) throws SQLException {
    	this.nom.setText(resultSet.getString("name"));
    	this.depart.setText(resultSet.getString("departure").split(" ")[0]);
    	this.heureDepart.setText(resultSet.getString("departureTime"));
    	this.depart.setText(resultSet.getString("arrival").split(" ")[0]);
    	this.place.setText(resultSet.getString("seat"));
    	this.montant.setText(resultSet.getString("amount"));
    	this.id.setText(resultSet.getString("id"));
    	this.heureArrivee.setText(resultSet.getString("departureDate"));
    	this.note.setText(String.valueOf(Math.round(resultSet.getDouble("mark") * 100.0) / 100.0));
    	Main.handleServer.write(new Handler<>(Keywords.getImageUser, null,resultSet.getString("picture")));
    	Utilitie.sleep(3000);
    	this.image.setImage(new Image(new ByteArrayInputStream(Main.handleServer.getImage())));
    }

}
