package system;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import utilities.Data;
import utilities.Keyword;

/*
 * @since 28/11/2020
 * @authors ANOUMEDEM NGUEFACK Gilles Cédric, NSIA FOTUE Rene, TCHITAKE GNIZE Alain, WELEHELA Patricia
 * @class GestionFile
 * @description Cette classe permet la gestion des fichiers nécéssaires à l'application
 * @public
 */
public class GestionFile {
	private ArrayList<String> files = new ArrayList<String>();

    /*
     * @constructor
     * @description constructeur permettant d'ajouter des fichiers sur une liste
     * @public
     */
    public GestionFile() {
    	files.add(Data.LOG);
        files.add(Data.PARAMETER);
    }

    /*
     * @private
     * @method isExist
     * @returns boolean
     * @param File file le fichier dont on va tester l'existence
     * @description cette méthode permet de verifier l'existence d'un fichier
     */
    private boolean isExist(File file) {
        return file.exists();
    }

    /*
     * @public
     * @method writeChars
     * @returns void
     * @param String filename le fichier dans lequel seront ecris les caracteres, String data les caracteres qui seront à ecrire dans le fcihier
     * throws IOException
     * @description cette méthode permet de ecrire les caracteres dans un fichier
     */
    public static void writeChars(String data) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(Data.LOCATION + Data.APPNAME+ Data.SEPARATOR + Data.LOG,true)))) {
            printWriter.println(data);
        } catch (IOException ex) {
        	Alert dialog = new Alert(AlertType.ERROR);
 			dialog.setTitle("Erreur");
 			dialog.setContentText(ex.getMessage());
 			dialog.showAndWait();
        }
    }

    /*
     * @public
     * @method readChars
     * @returns ArrayList<String>
     * @param String filename le fichier dans lequel seront lus les caracteres
     * @throws IOException
     * @description cette méthode permet de lire les caracteres dans un fichier
     */
    public static ArrayList<String> readChars() {
        ArrayList<String> logs = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(Data.LOCATION + Data.APPNAME+ Data.SEPARATOR + Data.LOG)))) {
            while (scanner.hasNextLine()){
                logs.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
        	Alert dialog = new Alert(AlertType.ERROR);
 			dialog.setTitle("Erreur");
 			dialog.setContentText(ex.getMessage());
 			dialog.showAndWait();
        }
        return logs;
    }
    
    /*
     * @public
     * @method readBinary
     * @returns ArrayList
     * @param String filename le fichier dans lequel seront lus les octects
     * @throws IOException,ClassNotFoundException,InterruptedException
     * @description cette méthode permet de lire les octets serialises dans un fichier
     */
    @SuppressWarnings("unchecked")
	public static ArrayList<Parameter> readBinary() {
    	ArrayList<Parameter> parameters = new ArrayList<Parameter>();
        FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(Data.LOCATION + Data.APPNAME+ Data.SEPARATOR + Data.PARAMETER);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        parameters = (ArrayList<Parameter>) objectInputStream.readObject();
	        objectInputStream.close();
		} catch (ClassNotFoundException | IOException ex) {
			Alert dialog = new Alert(AlertType.ERROR);
 			dialog.setTitle("Erreur");
 			dialog.setContentText(ex.getMessage());
 			dialog.showAndWait();
		}	
        return parameters;
    }
    
    /*
     * @public
     * @method writeBinary
     * @returns void
     * @param String filename le fichier dans lequel seront ecris les octects
     * @throws IOException,ClassNotFoundException,InterruptedException
     * @description cette méthode permet de serialiser les objets dans un fichier
     */
    @SuppressWarnings("unchecked")
	public static void writeBinary(Object data,boolean empty){
    	ArrayList<Parameter> oldData = new ArrayList<Parameter>();
    	if(!empty) {
    		oldData = readBinary();
    	}
        if(data instanceof ArrayList){
            oldData = (ArrayList<Parameter>) data;
        }else{
            oldData.add((Parameter)data);
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(Data.LOCATION + Data.APPNAME+ Data.SEPARATOR + Data.PARAMETER);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(oldData);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException ex) {
			Alert dialog = new Alert(AlertType.ERROR);
 			dialog.setTitle("Erreur");
 			dialog.setContentText(ex.getMessage());
 			dialog.showAndWait();
		}	

    }

    /*
     * @private
     * @method createFile
     * @returns void
     * @throws IOException, ClassNotFoundException, InterruptedException, NoSuchAlgorithmException
     * @description cette méthode permet de creer les fichiers
     */
    private void createFile() {
    	for (String filename : this.files) {
    		File file = new File(Data.LOCATION + Data.APPNAME+ Data.SEPARATOR + filename);
            if (!file.exists()) {
                try {
                    if (!file.createNewFile()) {
                    	Alert dialog = new Alert(AlertType.ERROR);
             			dialog.setTitle("Erreur");
             			dialog.setContentText("Impossible de creer les fichiers nécéssaire à l'application");
             			dialog.showAndWait();
                    }
                    if (filename.equals(Data.PARAMETER)) this.insertParameters();
                } catch (IOException ex) {
                    Alert dialog = new Alert(AlertType.ERROR);
        			dialog.setTitle("Erreur");
        			dialog.setContentText(ex.getMessage());
        			dialog.showAndWait();
                }
            }
    	}
    }

    private void insertParameters() {
    	 ArrayList<Parameter> parameters = new ArrayList<Parameter>();
    	 parameters.add(new Parameter(Keyword.lang,Lang.fr));
    	 parameters.add(new Parameter(Keyword.theme,Theme.dark));
    	 writeBinary(parameters,true);
	}

	/*
     * @public
     * @method run
     * @returns String
     * @throws IOException, ClassNotFoundException, InterruptedException, NoSuchAlgorithmException
     * @description cette méthode permet de creer un fichier dans un repertoire si ce repertoire existe sinon creer d'abord le repertoire
     */
    public void run() {
        File directory = new File(Data.LOCATION+ Data.APPNAME);
        if (isExist(directory)) {
            createFile();
        } else {
            if (directory.mkdir()) {
                createFile();
            } else {
                Alert dialog = new Alert(AlertType.ERROR);
    			dialog.setTitle("Erreur");
    			dialog.setContentText("Impossible de créer les fichiers de base de l'application");
    			dialog.showAndWait();
            }
        }
    }
    
    
}
