package controllers;

import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Identifier;
import models.User;
import system.Handler;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import utilities.FilePicker;
import utilities.IdentifierType;
import utilities.Keywords;
import utilities.MD5;
import utilities.Utilitie;

public class RegistrationFormController {
	private UserDao userDao = new UserDao();
	private boolean visible = false;
	private File image = null;

	@FXML
    private AnchorPane pane;

    @FXML
    private JFXButton registrationBtn;

    @FXML
    private FontAwesomeIcon closeBtn;

    @FXML
    private FontAwesomeIcon backBtn;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField cni;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField tel;

    @FXML
    private JFXTextField passwordVisible;

    @FXML
    private FontAwesomeIcon makePasswordVisibleBtn;

    @FXML
    private Label fileName;

    @FXML
    private JFXButton fileChooser;

    @FXML
    private FontAwesomeIcon makePasswordInvisibleBtn;
    
    @FXML
    private ImageView loader;

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
    void choose(ActionEvent event) {
    	FilePicker filePicker = new FilePicker("S�lectionnez une image", "jpg","jpeg","png","gif");
    	image = filePicker.chooseFile();
    	if(image != null)
    		this.fileName.setText(image.getName());
    	else {
    		this.fileName.setText("Importer une photo de profil");
    		Utilitie.showNotification("Erreur", "Aucune image n'a �t� s�lection�e", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	}
    }

    @FXML
    void closeApp(MouseEvent event) {
    	Utilitie.closeApplication();
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
    									user.setId(id);
    									user.setPicture(MD5.encrypt(String.valueOf(id))+image.getName().substring(image.getName().lastIndexOf(".")));
    									userDao.update(user);
    									FileInputStream in;
										try {
											in = new FileInputStream(image);
											byte b[] = new byte[in.available()];
	    					                in.read(b);
	    					                Main.handleServer.write(new Handler<byte[]>(Keywords.addImageUser, b,user.getPicture()));
	    					                in.close();
										} catch (IOException e) {
											Utilitie.error(RegistrationFormController.class.getName(), e);
										}
    									ArrayList<Identifier> identifiers = new ArrayList<>();
    									identifiers.add(new Identifier(IdentifierType.cni, cni, id));
    									identifiers.add(new Identifier(IdentifierType.email, email, id));
    									identifiers.add(new Identifier(IdentifierType.phone, tel, id));
    									new IdentifierDao().insert(identifiers);
    									backToLogin();
        								Utilitie.showNotification("Inscription effectu�", "Votre inscription a �t� effectu� avec succ�s", AnimationType.POPUP, NotificationType.SUCCESS, 3000);
    								}else
    									Utilitie.showNotification("Erreur", "Impossible d'enregistrer votre compte", AnimationType.POPUP, NotificationType.ERROR, 3000);
    							}else {
    	    	        			Utilitie.showNotification("Erreur", "Votre num�ro de t�l�phone n'est pas au format appropri�.\nVeuillez ajouter l'indicatif national", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	    	        		}
        	    			}else {
        	        			Utilitie.showNotification("Erreur", "Votre mot de passe doit �tre entre 8 et 12 caract�res\net contenir aumoins 1 chiffre", AnimationType.POPUP, NotificationType.ERROR, 3000);
        	        		}
    	    			}else {
    	        			Utilitie.showNotification("Erreur", "Votre addresse mail n'est pas au format appropri�", AnimationType.POPUP, NotificationType.ERROR, 3000);
    	        		}
        			}else {
            			Utilitie.showNotification("Erreur", "Votre num�ro de CNI doit contenir 11 ou 17 caract�res", AnimationType.POPUP, NotificationType.ERROR, 3000);
            		}
    			}else {
        			Utilitie.showNotification("Erreur", "Votre pr�nom doit comporter aumoins 4 caract�res", AnimationType.POPUP, NotificationType.ERROR, 3000);
        		}
    		}else {
    			Utilitie.showNotification("Erreur", "Votre nom doit comporter aumoins 4 caract�res", AnimationType.POPUP, NotificationType.ERROR, 3000);
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
        	makePasswordVisibleBtn.setVisible(false);
        	makePasswordInvisibleBtn.setVisible(true);
    	}else {
    		password.setText(passwordVisible.getText());
    		password.setVisible(true);
        	passwordVisible.setVisible(false);
        	makePasswordVisibleBtn.setVisible(true);
        	makePasswordInvisibleBtn.setVisible(false);
    	}
    	this.visible = !this.visible;
    	
    }

}
