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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.User;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.Utilitie;

public class LoginFormController implements Initializable{
	
	private UserDao userDao = new UserDao();
	
		@FXML
		private AnchorPane container;
		
	    @FXML
	    private Label welcome;

	    @FXML
	    private Pane contentArea;

	    @FXML
	    private Label welcomeMessage;

	    @FXML
	    private Label welcomeSecondMessage;

	    @FXML
	    private JFXTextField email;

	    @FXML
	    private JFXPasswordField password;

	    @FXML
	    private Label forgotPasswordBtn;

	    @FXML
	    private JFXButton loginBtn;

	    @FXML
	    private Label newMessage;

	    @FXML
	    private Label openRegistrationBtn;

	    @FXML
	    private FontAwesomeIcon closeBtn;

    @FXML
    void closeApp(MouseEvent event) {
    	System.exit(0);
    }
    
    private void loadLang() {
    	//Main.resourceBundle = ResourceBundle.getBundle("properties.lang", new Locale("en"));
    	welcome.setText(Main.resourceBundle.getString("welcome"));
    	//Utilitie.setParameter(new Parameter(Keyword.lang,Lang.fr));
    	//Utilitie.setParameter(new Parameter(Keyword.theme,Theme.dark));
    }

    @FXML
    void login(ActionEvent event) throws IOException {
    	loadLang();
    	String mail = email.getText();
    	String password = this.password.getText();
    	/*if(!mail.trim().isEmpty() && !password.trim().isEmpty()) {
			User user = new User(mail,password);
			try {
				ResultSet rs = userDao.request("SELECT * FROM users WHERE mail='"+user.getMail()+"'");
				if(rs.next()) {
					User userConnected = new User(rs.getInt("id"), rs.getString("cni"), rs.getString("name"),rs.getString("lastName"),rs.getString("phone"),rs.getString("mail"),rs.getString("password"),rs.getString("picture"),rs.getBoolean("isAdmin"),rs.getBoolean("isActive"));
					if(Utilitie.checkPassword(password, userConnected.getPassword())) {
						Main.userConnected = userConnected;
						if(userConnected.isAdmin()) {
							// @todo Open Admin Main Interface
						}else { 
							Utilitie.changeScreen("acceuil", Main.loginStage);
						}
					}else {
						Utilitie.showNotification("Erreur", "Veuillez vérifiez votre mot de passe", AnimationType.POPUP, NotificationType.ERROR, 3000);
					}
				}else {
					Utilitie.showNotification("Erreur", "Veuillez vérifiez votre adresse mail", AnimationType.POPUP, NotificationType.ERROR, 3000);
				}
			} catch (SQLException ex) {
				Utilitie.error(LoginFormController.class.getName(), ex);
			}
		}else {
            Utilitie.showNotification("Erreur", "Veuillez remplir tous les champs", AnimationType.POPUP, NotificationType.ERROR, 3000);
		}*/
    }

    @FXML
    void openRegistrationForm(MouseEvent event) {
    	Parent root;
		try {
			root = (Parent)FXMLLoader.load(getClass().getResource("/views/RegistrationForm.fxml"));
			contentArea.getChildren().removeAll();
	    	Utilitie.makeTransitionRandom(root, contentArea);
	    	contentArea.getChildren().setAll(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Utilitie.error(LoginFormController.class.getName(), e);
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadLang();
		
	}

}

