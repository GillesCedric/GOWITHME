package application;
	
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.User;
import system.Client;
import system.GestionFile;
import system.HandleServer;
import system.Parameter;
import utilities.Scheme;
import utilities.Theme;
import utilities.Utilitie;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application{
	public static HandleServer handleServer = null;
	public static Stage stage = null;
	public static User userConnected = null;
	public static ArrayList<Parameter> parameters = null; 
	public static ResourceBundle resourceBundle = null;
	public static String css = null;
	public static List<Parent> roots = new ArrayList<Parent>();
	public static List<Stage> stages = new ArrayList<Stage>();
	public static List<Scene> scenes = new ArrayList<Scene>();
	public static List<?> controllers = new ArrayList<>();
	public static Stage loginStage = new Stage();
	public static Stage acceuilStage = new Stage();
	public static Stage settingContainerStage = new Stage();
	public static Stage newVoyageStage = new Stage();
	public static Stage newPointStage = new Stage();
	public static Stage newCarStage = new Stage();
	public static Stage travelInsformationsStage = new Stage();
	public static Stage paymentModeStage = new Stage();

		@Override
		public void start(Stage primaryStage) {
			new GestionFile().run();
			handleServer = new Client("127.0.0.1",3000).launch();
			if(handleServer == null) System.exit(1);
			parameters = Utilitie.readParameters();
			resourceBundle = ResourceBundle.getBundle("properties.lang", new Locale(Utilitie.getParameter(Scheme.lang).getValue().name()));	
			if(Utilitie.getParameter(Scheme.theme).getValue().equals(Theme.dark)) {
				css = "/css/styleDark.css";
			}else {
				css = "/css/styleMain.css";
			}
			try {
				//root.getStylesheets().removeAll();
				//root.getStylesheets().add(getClass().getResource(css).toExternalForm());
				FXMLLoader login = new FXMLLoader(getClass().getResource("/views/LoginForm.fxml"));
				FXMLLoader acceuil = new FXMLLoader(getClass().getResource("/views/AcceuilFormView.fxml"));
				FXMLLoader setting = new FXMLLoader(getClass().getResource("/views/SettingContainerForm.fxml"));
				FXMLLoader travelContainer = new FXMLLoader(getClass().getResource("/views/NewTravelContainerForm.fxml"));
				FXMLLoader travelPoint = new FXMLLoader(getClass().getResource("/views/NewTravelPointArretForm.fxml"));
				FXMLLoader addCar = new FXMLLoader(getClass().getResource("/views/NewCarContainerForm.fxml"));
				FXMLLoader travelInformations = new FXMLLoader(getClass().getResource("/views/TravelInformationsForm.fxml"));
				FXMLLoader paymentMode = new FXMLLoader(getClass().getResource("/views/PaymentModeForm.fxml"));
				
				roots.add(login.load());
				roots.add(acceuil.load());
				roots.add(setting.load());
				roots.add(travelContainer.load());
				roots.add(travelPoint.load());
				roots.add(addCar.load());
				roots.add(travelInformations.load());
				roots.add(paymentMode.load());
				
				controllers.add(login.getController());
				controllers.add(acceuil.getController());
				controllers.add(setting.getController());
				controllers.add(travelContainer.getController());
				controllers.add(travelPoint.getController());
				controllers.add(addCar.getController());
				controllers.add(travelInformations.getController());
				controllers.add(paymentMode.getController());

				stages.add(loginStage);
				stages.add(acceuilStage);
				stages.add(settingContainerStage);
				stages.add(newVoyageStage);
				stages.add(newPointStage);
				stages.add(newCarStage);
				stages.add(travelInsformationsStage);
				stages.add(paymentModeStage);
				
				for(Stage s : stages) {
					s.initStyle(StageStyle.UNDECORATED);
					s.getIcons().add(new Image("/img/logo.png"));
				}
				
				for(int i = 0; i < roots.size(); i++) {
					scenes.add(new Scene(roots.get(i)));
					Utilitie.autoriseDeplacement(roots.get(i), stages.get(i));
					stages.get(i).setScene(scenes.get(i));
					stages.get(i).centerOnScreen();
					stages.get(i).setResizable(false);
				}

				stages.get(0).show();
			} catch(Exception e) {
				Utilitie.error(Main.class.getName(), e);
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}
