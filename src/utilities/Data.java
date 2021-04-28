package utilities;

/*
 * @since 28/11/2020
 * @authors ANOUMEDEM NGUEFACK Gilles Cédric, NSIA FOTUE Rene, TCHITAKE GNIZE Alain, WELEHELA Patricia
 * @class Parameter
 * @description Cette est utilisé pour gérer tous les paramètres de  l'application
 * @public
 */
public class Data {
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String OSNAME = System.getProperty("os.name");
    public static final String OSARCH = System.getProperty("os.arch");
    public static final String SYSTEMNAME = System.getProperty("user.name");
    public static final String LOCATION = "C:"+SEPARATOR+"Users"+SEPARATOR+""+SYSTEMNAME+""+SEPARATOR;
    //public static final String LOCATION = "E:"+SEPARATOR;
    public static final String APPNAME = "GOWITHME";
    public static final String LOG = SYSTEMNAME+".log";
    public static final String PARAMETER = "parameter.data";
    public static final String DBNAME = "gowithme";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String DBPORT = "3308";
    public static final String DBHOST = "localhost";
    public static final int PORT = 3000;
    public static final String HOST = "127.0.0.1";
}
