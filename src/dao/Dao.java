/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import system.Log;
import utilities.Parameter;

/**
 *
 * @author Gilles Cédric
 */
public abstract class Dao {
    private Connection connection = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private String port = null;
    private String host = null;
    private String dbName = null;

  
  public Dao() {   
	this.dbName = Parameter.DBNAME;
        this.username = Parameter.USERNAME;
        this.password = Parameter.PASSWORD;
        this.port = Parameter.PORT;
        this.host = Parameter.HOST;
        this.url = "jdbc:mysql://" + this.host+ ":"+this.port+"/"+this.dbName+"?characterEncoding=utf8";
  }

   
    protected Connection connectionDatabase() {

     try {
       Class.forName("com.mysql.jdbc.Driver");    
       this.connection = DriverManager.getConnection(""+this.url,this.username, this.password);
       Log.addLog(new Log(Dao.class.getName(),"Connexion à la base de données"));
     } catch (ClassNotFoundException | SQLException e) {
         JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
     }
     return this.connection;
   }
    
    protected void closeConnection(){
        try {
            this.connection.close();
            Log.addLog(new Log(Dao.class.getName(),"Fermeture de la connexion à la base de données"));
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     *
     * @param list
     * @param classe
     * @return
     */
    public abstract Object isExists(ArrayList list, Object classe);
    
    /**
     *
     * @param list
     * @param objects
     */
    public abstract void insert(ArrayList list, Object ...objects);
    
    /**
     *
     * @return
     */
    public abstract ArrayList list();
    
    public abstract void update(Object object);
    
    public abstract void delete(Object object);
    
}
