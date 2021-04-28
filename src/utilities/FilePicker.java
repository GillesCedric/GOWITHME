package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;

public class FilePicker {
	private final FileChooser fileChooser = new FileChooser();
	private static Desktop desktop = Desktop.getDesktop();

	public FilePicker(String title,String ...extentions) {
		fileChooser.setTitle(title);
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		for (String extention : extentions)
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(extention.toUpperCase(), "*."+extention.toLowerCase()));
	}
	
	public File chooseFile() {
		return fileChooser.showOpenDialog(null);
	}	
	
	public static void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
        	Utilitie.error(FilePicker.class.getName(), ex);
        }
    }
	
}
