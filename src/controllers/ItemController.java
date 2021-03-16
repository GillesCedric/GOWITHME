package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    void moreInfo(MouseEvent event) {

    }

}
