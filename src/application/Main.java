package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.User;
import system.GestionFile;
import system.Parameter;
import utilities.Utilitie;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application{
	public static Stage stage = null;
	public static User userConnected = null;
	public static ArrayList<Parameter> parameters = null; 

		@Override
		public void start(Stage primaryStage) {
			new GestionFile().run();
			parameters = Utilitie.readParameters();
			try {
				Parent root = (Parent)FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
				Scene scene = new Scene(root);
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.setScene(scene);
				Utilitie.autoriseDeplacement(root, primaryStage);
				stage = primaryStage;
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}
