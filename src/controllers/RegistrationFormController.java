package controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.IdentifierDao;
import dao.UserDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Identifier;
import models.User;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.IdentifierType;
import utilities.Utilitie;

public class RegistrationFormController {
	private UserDao userDao = new UserDao();
	private boolean visible = false;

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField cni;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton registrationBtn;

    @FXML
    private FontAwesomeIcon closeBtn;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField tel;

    @FXML
    private FontAwesomeIcon backBtn;
    
    @FXML
    private JFXTextField passwordVisible;
    
    @FXML
    private FontAwesomeIcon makePasswordVisibleBtn;

    @FXML
    void backToLoginForm(MouseEvent event) throws IOException {
    	backToLogin();
    }
    
    private void backToLogin() {
    	Parent root;
		try {
			root = (Parent)FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
			root.getStylesheets().add(getClass().getResource(Main.css).toExternalForm());
	    	Main.loginStage.getScene().setRoot(root);
		} catch (IOException ex) {
			Utilitie.error(RegistrationFormController.class.getName(), ex);
		}
    }

    @FXML
    void closeApp(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void registration(ActionEvent event) {
    	String name = this.name.getText();
    	String lastName = this.lastName.getText();
    	String cni = this.cni.getText();
    	String email = this.email.getText();
    	String password = this.password.getText();
    	String tel = this.tel.getText();
    	
    	if(!name.trim().isEmpty() && !lastName.trim().isEmpty() && !cni.trim().isEmpty() && !password.trim().isEmpty() && !email.trim().isEmpty() && !tel.trim().isEmpty()) {
    		if(name.length() > 3) {
    			if(lastName.length() > 3) {
    				if(cni.length() == 17 || cni.length() == 9) {
    					if(Utilitie.match(email, Utilitie.EMAIL_REGEX)) {
    						if(Utilitie.match(password, Utilitie.PASSWORD_REGEX)) {
    							if(Utilitie.match(tel, Utilitie.TEL_REGEX)) {
    								User user = new User(name, lastName, password, false, false);
    								int id = userDao.insert(user);
    								if(id != 0) {
    									ArrayList<Identifier> identifiers = new ArrayList<>();
    									identifiers.add(new Identifier(IdentifierType.cni, cni, id));
    									identifiers.add(new Identifier(IdentifierType.email, email, id));
    									identifiers.add(new Identifier(IdentifierType.phone, tel, id));
    									new IdentifierDao().insert(identifiers);
    									backToLogin();
        								Utilitie.showNotification("Inscription effectué", "Votre inscription a été effectué avec succès", AnimationType.POPUP, NotificationType.SUCCESS, 3000);
    								}else
    									Utilitie.showNotification("Erreur", "Impossible d'enregistrer votre compte", AnimationType.POPUP, NotificationType.ERROR, 3000);
    							}else {
    	    	        			Utilitie.showNotification("Erreur", "Votre numéro de téléphone n'est pas au format approprié.\nVeuillez ajouter l'indicatif national", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	    	        		}
        	    			}else {
        	        			Utilitie.showNotification("Erreur", "Votre mot de passe doit être entre 8 et 12 caractères\net contenir aumoins 1 chiffre", AnimationType.POPUP, NotificationType.ERROR, 3000);
        	        		}
    	    			}else {
    	        			Utilitie.showNotification("Erreur", "Votre addresse mail n'est pas au format approprié", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	        		}
        			}else {
            			Utilitie.showNotification("Erreur", "Votre numéro de CNI doit contenir 11 ou 17 caractères", AnimationType.POPUP, NotificationType.ERROR, 3000);
            		}
    			}else {
        			Utilitie.showNotification("Erreur", "Votre prénom doit comporter aumoins 4 caractères", AnimationType.POPUP, NotificationType.ERROR, 3000);
        		}
    		}else {
    			Utilitie.showNotification("Erreur", "Votre nom doit comporter aumoins 4 caractères", AnimationType.POPUP, NotificationType.ERROR, 3000);
    		}
    	}else {
    		Utilitie.showNotification("Erreur", "Veuillez remplir tous les champs", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	}
    }
    
    @FXML
    void makePasswordVisible(MouseEvent event) {
    	if(!visible) {
    		passwordVisible.setText(password.getText());
        	passwordVisible.setVisible(true);
        	password.setVisible(false);
    	}else {
    		password.setText(passwordVisible.getText());
    		password.setVisible(true);
        	passwordVisible.setVisible(false);
    	}
    	this.visible = !this.visible;
    	
    }

}
