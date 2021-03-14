package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.UserDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import models.User;
import utilities.Utilitie;

public class LoginFormController implements Initializable{
	
	private UserDao userDao = new UserDao();
	
	@FXML
    private Pane contentArea;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label forgotPasswordBtn;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label openRegistrationBtn;

    @FXML
    private FontAwesomeIcon closeBtn;

    @FXML
    void closeApp(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {
    	String mail = email.getText();
    	String password = this.password.getText();
    	if(!mail.trim().isEmpty() && !password.trim().isEmpty()) {
			User user = new User(mail,password);
			try {
				ResultSet rs = userDao.request("SELECT * FROM users WHERE mail='"+user.getMail()+"' AND password='"+user.getPassword()+"'");
				if(rs.next()) {
					Main.userConnected = new User(rs.getInt("id"), rs.getString("numCni"), rs.getString("name"),rs.getString("lastName"),rs.getString("phone"),rs.getString("mail"),rs.getString("password"),rs.getString("picture"),rs.getBoolean("isAdmin"),rs.getBoolean("isActive"));
					//@Todo open Main View
				}else {
					Alert dialog = new Alert(AlertType.ERROR);
					dialog.setTitle("Erreur");
					dialog.setHeaderText("Erreur Base de Données");
					dialog.setContentText("L'adresse mail et / ou le mot de passe sont incorrects");
					dialog.showAndWait();
				}
			} catch (SQLException ex) {
				Utilitie.error(UserDao.class.getName(), ex);
			}
		}else {
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Erreur");
			dialog.setContentText("Veuillez remplir tous les champs");
			dialog.showAndWait();
		}
    }

    @FXML
    void openRegistrationForm(MouseEvent event) throws IOException {
    	Parent root = (Parent)FXMLLoader.load(getClass().getResource("/views/RegistrationForm.fxml"));
    	contentArea.getChildren().removeAll();
    	Utilitie.makeTransition(root, contentArea);
    	contentArea.getChildren().setAll(root);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
	}

}

