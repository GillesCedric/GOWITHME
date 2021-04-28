package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import utilities.Utilitie;

public class BreakpointsController {

    @FXML
    private Label ville;

    @FXML
    private Label quartier;

    @FXML
    private Label heure;

    @FXML
    private FontAwesomeIcon more;

    @FXML
    void moreInfo(MouseEvent event) {

    }

	public void setData(ResultSet resultSet) {
		try {
			this.ville.setText(resultSet.getString("point"));
			this.quartier.setText(resultSet.getString("point").split(" ")[1]);
			this.heure.setText(resultSet.getString("time"));
		} catch (SQLException e) {
			Utilitie.error(BreakpointsController.class.getName(), e);
		}
		
	}

}
