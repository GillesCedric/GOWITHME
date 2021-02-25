package utilities;

/*
 * @since 28/11/2020
 * @authors ANOUMEDEM NGUEFACK Gilles Cédric, NSIA FOTUE Rene, TCHITAKE GNIZE Alain, WELEHELA Patricia
 * @class Parameter
 * @description Cette est utilisé pour gérer tous les paramètres de  l'application
 * @public
 */
public class Parameter {
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String SYSTEMNAME = System.getProperty("user.name");
    //public static final String LOCATION = "C:"+separator+"Users"+separator+""+System.getProperty("user.name")+""+separator;
    public static final String LOCATION = "E:"+SEPARATOR;
    public static final String APPNAME = "Covoiturage App";
    public static final String LOG = SYSTEMNAME+".log";
    public static final String DBNAME = "covoiturageapp";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String PORT = "3308";
    public static final String HOST = "localhost";
}
