/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    protected Connection connection = null;
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

   
    protected void connectionDatabase() {

     try {
       Class.forName("com.mysql.jdbc.Driver");    
       Log.addLog(new Log(Dao.class.getName(),"Connexion à la base de données"));
       this.connection = DriverManager.getConnection(""+this.url,this.username, this.password);
     } catch (ClassNotFoundException | SQLException e) {
         JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
     }

   }
    
    protected void closeConnection(){
        try {
            this.connection.close();
            this.connection = null;
            Log.addLog(new Log(Dao.class.getName(),"Fermeture de la connexion à la base de données"));
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected int getLastID(String tableName){
        String sql = "SELECT COUNT(id) FROM "+tableName;
        int id = 0;
        try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                ResultSet rs = prepareStatement.executeQuery();
                while(rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                 Log.addLog(new Log(UserDao.class.getName(),"Erreur "+ex.getMessage()));
            }
        return id;
    }
    
    /**
     *
     * @param list
     * @param classe
     * @return
     */
    public abstract Object isExists(ArrayList<?> list, Object object);
    
    /**
     *
     * @param list
     * @param objects
     */
    public abstract void insert(ArrayList<?> list);
    
    /**
     *
     * @return
     */
    public abstract ArrayList<?> list();
    
    public abstract void update(Object object);
    
    public abstract void delete(Object object);
    
}
