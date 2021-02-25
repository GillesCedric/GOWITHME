package system;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilities.Parameter;

/*
 * @since 28/11/2020
 * @authors ANOUMEDEM NGUEFACK Gilles C�dric, NSIA FOTUE Rene, TCHITAKE GNIZE Alain, WELEHELA Patricia
 * @class GestionFile
 * @description Cette classe permet la gestion des fichiers n�c�ssaires � l'application
 * @public
 */
public class GestionFile {


    /*
     * @constructor
     * @description constructeur permettant d'ajouter des fichiers sur une liste
     * @public
     */
    public GestionFile() {

    }

    /*
     * @private
     * @method isExist
     * @returns boolean
     * @param File file le fichier dont on va tester l'existence
     * @description cette m�thode permet de verifier l'existence d'un fichier
     */
    private boolean isExist(File file) {
        return file.exists();
    }

    /*
     * @public
     * @method writeChars
     * @returns void
     * @param String filename le fichier dans lequel seront ecris les caracteres, String data les caracteres qui seront � ecrire dans le fcihier
     * throws IOException
     * @description cette m�thode permet de ecrire les caracteres dans un fichier
     */
    public static void writeChars(String data) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(Parameter.LOCATION + Parameter.APPNAME+ Parameter.SEPARATOR + Parameter.LOG,true)))) {
            printWriter.println(data);
        } catch (IOException ex) {
            Logger.getLogger(GestionFile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * @public
     * @method readChars
     * @returns ArrayList<String>
     * @param String filename le fichier dans lequel seront lus les caracteres
     * @throws IOException
     * @description cette m�thode permet de lire les caracteres dans un fichier
     */
    public static ArrayList<String> readChars() {
        ArrayList<String> logs = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(Parameter.LOCATION + Parameter.APPNAME+ Parameter.SEPARATOR + Parameter.LOG)))) {
            while (scanner.hasNextLine()){
                logs.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return logs;
    }

    /*
     * @private
     * @method createFile
     * @returns void
     * @throws IOException, ClassNotFoundException, InterruptedException, NoSuchAlgorithmException
     * @description cette m�thode permet de creer les fichiers
     */
    private void createFile() {
        File file = new File(Parameter.LOCATION + Parameter.APPNAME+ Parameter.SEPARATOR + Parameter.LOG);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Impossible de creer les fichiers n�c�ssaire � l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(GestionFile.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*
     * @public
     * @method run
     * @returns String
     * @throws IOException, ClassNotFoundException, InterruptedException, NoSuchAlgorithmException
     * @description cette m�thode permet de creer un fichier dans un repertoire si ce repertoire existe sinon creer d'abord le repertoire
     */
    public void run() {
        File directory = new File(Parameter.LOCATION+ Parameter.APPNAME);
        if (isExist(directory)) {
            createFile();
        } else {
            if (directory.mkdir()) {
                createFile();
            } else {
                JOptionPane.showMessageDialog(null, "Impossible de cr�er les fichiers de base de l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
