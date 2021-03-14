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
import system.Log;
import utilities.Data;
import utilities.Utilitie;

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
	this.dbName = Data.DBNAME;
        this.username = Data.USERNAME;
        this.password = Data.PASSWORD;
        this.port = Data.PORT;
        this.host = Data.HOST;
        this.url = "jdbc:mysql://" + this.host+ ":"+this.port+"/"+this.dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8";
  }

   
    protected void connectionDatabase() {

     try {  
       Log.addLog(new Log(Dao.class.getName(),"Connexion à la base de données"));
       this.connection = DriverManager.getConnection(""+this.url,this.username, this.password);
     } catch (SQLException ex) {
    	 Utilitie.error(Dao.class.getName(), ex);
     }

   }
    
    protected void closeConnection(){
        try {
            this.connection.close();
            this.connection = null;
            Log.addLog(new Log(Dao.class.getName(),"Fermeture de la connexion à la base de données"));
        } catch (SQLException ex) {
        	Utilitie.error(Dao.class.getName(), ex);
        }
    }
    
    protected int getLastID(String tableName){
    	this.connectionDatabase();
        String sql = "SELECT COUNT(id) FROM "+tableName;
        int id = 0;
        try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                ResultSet rs = prepareStatement.executeQuery();
                while(rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException ex) {
            	Utilitie.error(Dao.class.getName(), ex);
            }
        this.closeConnection();
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
    
    public ResultSet request(String sql) {
    	this.connectionDatabase();
    	 try {
             PreparedStatement prepareStatement = connection.prepareStatement(sql);
             ResultSet rs = prepareStatement.executeQuery();
             return rs;
         } catch (SQLException ex) {
        	Utilitie.error(Dao.class.getName(), ex);
         }
    	 this.closeConnection();
    	 return null;
    }
    
}
