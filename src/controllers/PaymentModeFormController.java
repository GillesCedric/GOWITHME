package controllers;

import application.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import utilities.Browser;

public class PaymentModeFormController {

    @FXML
    private FontAwesomeIcon stripe;

    @FXML
    private FontAwesomeIcon paypal;

    @FXML
    private FontAwesomeIcon lockdownButton;

    @FXML
    void close(MouseEvent event) {
    	Main.paymentModeStage.close();
    }

    @FXML
    void openPaypal(MouseEvent event) {
    	Browser.open("http://localhost/gowithme/paypal");
    }

    @FXML
    void openStripe(MouseEvent event) {
    	Browser.open("http://localhost/gowithme/stripe");
    }

}
