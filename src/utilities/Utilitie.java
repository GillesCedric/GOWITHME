package utilities;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.regex.Pattern;
import application.Main;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import system.GestionFile;
import system.Handler;
import system.Log;
import system.Parameter;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Utilitie {
	private static double x,y;
	private static final int DURATION = 1;
	private static final double DURATION2 = DURATION/2;
	public static final String EMAIL_REGEX = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	public static final String PASSWORD_REGEX = "^(?=.*\\d).{8,16}$";
	public static final String TEL_REGEX = "^\\+[0-9]+(6|2)[0-9]+";
	
	public static void makeTransitionRandom(Parent p, Scene s) {
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
	
	public static void translateAnimation(Node node,boolean left,double width) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(DURATION2),node);
		translateTransition.setByX(width);
		translateTransition.play();
	}

	public static void makeTransitionRandom(Parent p, Pane pane) {
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
	
	public static void makeTransition(Parent p, Pane pane,boolean left) {
		Timeline timeline = new Timeline();
		KeyValue keyvalue;
		KeyFrame keyframe;

		//p.setLayoutX(-pane.getWidth());
		if(left) {
			p.translateXProperty().set(-pane.getWidth());
	 		keyvalue = new KeyValue(p.translateXProperty(),0,Interpolator.EASE_IN);
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
			dialog.setHeaderText(className);
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
	
	public static Parameter getParameter(Scheme name) {
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
				makeTransitionRandom(Main.roots.get(1),Main.scenes.get(1));
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
			break;
			case "newVoyage" :
				Main.stages.get(3).setScene(Main.scenes.get(3));
				Main.stages.get(3).show();
			break;
			case "newPoint" :
				Main.stages.get(4).setScene(Main.scenes.get(4));
				Main.stages.get(4).show();
				lock.close();
			break;
			case "newCar" :
				Main.stages.get(5).setScene(Main.scenes.get(5));
				Main.stages.get(5).show();
				lock.close();
			break;
			case "travelInformations" :
				Main.stages.get(6).setScene(Main.scenes.get(6));
				Main.stages.get(6).show();
				lock.close();
			break;
			case "paymentMode" :
				Main.stages.get(7).setScene(Main.scenes.get(7));
				Main.stages.get(7).show();
				lock.close();
			break;
		}
	}
	
	public static boolean match(String sequence,String regex) {
		return Pattern.compile(regex).matcher(sequence).matches();
	}
	
	private static int getAvailableVRAM(){ 
	    // Obtenir le type d'environnement graphique sous lequel tourne la JVM. 
	   GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
	   // Obtenir le périphérique d'affichage (carte graphique). 
	   GraphicsDevice device = environment.getDefaultScreenDevice();  
	   // Calcule le nombre de Méga Octets libres dans la carte graphique. 
	   int bytes = device.getAvailableAcceleratedMemory(); 
	   int mbytes = bytes /1048576;  
	   return mbytes; 
	}
	
	private static double getAvailableProcessor() {
		OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();  
		com.sun.management.OperatingSystemMXBean privateOsMxBean = (com.sun.management.OperatingSystemMXBean) osMxBean;  
		return privateOsMxBean.getProcessCpuLoad();
	}
	
	private static long getAvailableMemory() {
		OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean(); 
		com.sun.management.OperatingSystemMXBean privateOsMxBean = (com.sun.management.OperatingSystemMXBean) osMxBean; 
		return privateOsMxBean.getTotalPhysicalMemorySize();
	}
	
	private static int getNumberOfProcessor() {
		OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean(); 
		return osMxBean.getAvailableProcessors();
	}
	
	public static String genUserUniqueKey() {
		return MD5.encrypt(Data.APPNAME+getAvailableMemory()+Data.OSNAME+getAvailableProcessor()+Data.OSARCH+getAvailableVRAM()+Data.SYSTEMNAME+getNumberOfProcessor());
	}
	
	public static double getDistanceBetween2Points(float lat_a, float lng_a, float lat_b, float lng_b) {
		double d2r = (180 / Math.PI); 
		//double distance = 0; 
		//double dlong = (endpoint.getLon() - startpoint.getLon()) * d2r; 
		//double dlat = (endpoint.getLat() - startpoint.getLat()) * d2r; 
		//double a = Math.pow(Math.sin(dlat / 2.0), 2) + Math.cos(startpoint.getLat() * d2r) * Math.cos(endpoint.getLat() * d2r) * Math.pow(Math.sin(dlong / 2.0), 2); 
		double dlong = (lng_b - lng_a) * d2r; 
		double dlat = (lat_b - lat_a) * d2r; 
		double a = Math.pow(Math.sin(dlat / 2.0), 2) + Math.cos(lat_a * d2r) * Math.cos(lat_b * d2r) * Math.pow(Math.sin(dlong / 2.0), 2); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); 
		double d = 6367 * c; 
		return d;
	}
	
	public static void closeApplication() {
		Main.handleServer.write(new Handler<>(Keywords.close, null));
		Main.handleServer.close();
		System.exit(0);
	}
	
	public static void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			error(Utilitie.class.getName(),e);
		}
	}

}