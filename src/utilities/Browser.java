package utilities;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser {

    public static void open() {
        OUT("\nWelcome to Multi Brow Pop.\nThis aims to popup a browsers in multiple operating systems.\nGood luck!\n");

        String url = "http://www.birdfolk.co.uk/cricmob";
        OUT("We're going to this page: "+ url);

        String myOS = System.getProperty("os.name").toLowerCase();
        OUT("(Your operating system is: "+ myOS +")\n");

        try {
            if(Desktop.isDesktopSupported()) { // Probably Windows
                OUT(" -- Going with Desktop.browse ...");
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else { // Definitely Non-windows
                Runtime runtime = Runtime.getRuntime();
                if(myOS.contains("mac")) { // Apples
                    OUT(" -- Going on Apple with 'open'...");
                    runtime.exec("open " + url);
                } 
                else if(myOS.contains("nix") || myOS.contains("nux")) { // Linux flavours 
                    OUT(" -- Going on Linux with 'xdg-open'...");
                    runtime.exec("xdg-open " + url);
                }
                else 
                    OUT("I was unable/unwilling to launch a browser in your OS :( #SadFace");
            }
            OUT("\nThings have finished.\nI hope you're OK.");
        }
        catch(IOException | URISyntaxException eek) {
            OUT("**Stuff wrongly: "+ eek.getMessage());
        }
    }

    private static void OUT(String str) {
        System.out.println(str);
    }
}
