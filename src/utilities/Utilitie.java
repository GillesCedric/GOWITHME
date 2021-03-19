package utilities;


import java.util.ArrayList;
import java.util.regex.Pattern;

import application.Main;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import system.BCrypt;
import system.GestionFile;
import system.Log;
import system.Parameter;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Utilitie {
	private static double x,y;
	private static final int DURATION = 1;
	public static final String EMAIL_REGEX = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	public static final String PASSWORD_REGEX = "^(?=.*\\d).{8,16}$";
	public static final String TEL_REGEX = "^\\+[0-9]+(6|2)[0-9]+";
	
	public static void makeTransition(Parent p, Scene s) {
		p.setLayoutX(0);
		p.setLayoutY(0);
		Timeline timeline = new Timeline();
		KeyValue keyvalue;
		KeyFrame keyframe;
		
		if(generateNumber(1,2) == 1) {
			p.translateYProperty().set(s.getHeight());
	 		keyvalue = new KeyValue(p.translateYProperty(),0,Interpolator.EASE_IN);
		}else {
			p.translateXProperty().set(s.getWidth());
	 		keyvalue = new KeyValue(p.translateXProperty(),0,Interpolator.EASE_IN);
		}
		
		//roots.get(i).rotateProperty().set(360);
		keyframe = new KeyFrame(Duration.seconds(DURATION),keyvalue);
		timeline.getKeyFrames().add(keyframe);
		
		timeline.play();
	}

	public static void makeTransition(Parent p, Pane pane) {
		p.setLayoutX(0);
		p.setLayoutY(0);
		Timeline timeline = new Timeline();
		KeyValue keyvalue;
		KeyFrame keyframe;
		if(generateNumber(1,2) == 1) {
			p.translateYProperty().set(pane.getHeight());
	 		keyvalue = new KeyValue(p.translateYProperty(),0,Interpolator.EASE_IN);
		}else {
			p.translateXProperty().set(pane.getWidth());
	 		keyvalue = new KeyValue(p.translateXProperty(),0,Interpolator.EASE_IN);
		}
		//p.rotateProperty().set(360);
		keyframe = new KeyFrame(Duration.seconds(DURATION),keyvalue);
		timeline.getKeyFrames().add(keyframe);
		
		timeline.play();
	}
	
	public static int generateNumber(int min,int max) {
		return  min + (int) (Math.random() * ((max - min) + 1));
	}
	
	public static void autoriseDeplacement(Parent p,Stage stage) {
		p.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});
		p.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - x);
			stage.setY(event.getScreenY() - y);
			stage.setOpacity(0.7f);
		});
		p.setOnDragDone(event -> {
			stage.setOpacity(1.0f);
		});
		p.setOnMouseReleased(event -> {
			stage.setOpacity(1.0f);
		});
		/*roots.get(i).getStylesheets().removeAll();
		roots.get(i).getStylesheets().add(getClass().getResource("application.css").toExternalForm());*/
	}
	
	public static void error(String className,Exception ex) {
		Log.addLog(new Log(className,ex.toString()+" : "+ex.getMessage()));
   	 	Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Erreur");
			dialog.setContentText(ex.getMessage());
			dialog.showAndWait();
	}
	
	public static void showNotification(String title,String message,AnimationType animationType,NotificationType notificationType,int duration) {
		TrayNotification tray = new TrayNotification();
        tray.setAnimationType(animationType);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notificationType);
        tray.showAndDismiss(Duration.millis(duration));
	}
	
	public static Parameter getParameter(Keyword name) {
		for (Parameter parameter : Main.parameters) {
			if(parameter.getName().equals(name)) return parameter;
		}
		return null;
	}
	
	public static void setParameter(Parameter parameter) {
		ArrayList<Parameter> parameters = Main.parameters;
		for (int i = 0; i < parameters.size(); i++) {
			Parameter p = parameters.get(i);
			if(p.getName().equals(parameter.getName())) {
				parameters.remove(p);
				parameters.add(parameter);
			}
		}
		
		GestionFile.writeBinary(parameters,false);
	}
	
	public static ArrayList<Parameter> readParameters() {
		return GestionFile.readBinary();
	}
	
	public static String encyptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String password,String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}
	
	public static void changeScreen(String ecran,Stage lock) {
		switch(ecran) {
			case "acceuil" :
				Main.stages.get(1).setScene(Main.scenes.get(1));
				makeTransition(Main.roots.get(1),Main.scenes.get(1));
				Main.stages.get(1).show();
				lock.close();
			break;
			case "login" :
				Main.stages.get(0).setScene(Main.scenes.get(0));
				//makeTransition(0,scenes.get(0));
				Main.stages.get(0).show();
				lock.close();
			break;
			case "setting" :
				Main.stages.get(2).setScene(Main.scenes.get(2));
				Main.stages.get(2).show();
		}
	}
	
	public static boolean match(String sequence,String regex) {
		return Pattern.compile(regex).matcher(sequence).matches();
	}

}
