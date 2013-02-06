package com.demo.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnection {	 
	public static MySqlConnection instance;
	
	public static MySqlConnection getInstance(){
		if(instance == null){
			instance = new MySqlConnection();
		}
		return instance;
	}
     
     /**
      * Constructor
      */
     private MySqlConnection() {
     }

     
     
     /**
      * db conn
      * 
      * Make sure you add a reference library (external jar in build path) JDBC Connector - 
      * You will see I put it in /opt/classpath/mysql-connector-java-5.1.5/mysql-connector-java-5.1.5-bin.jar
      * 
      * @return Connection
      */
     public Connection getConn() {
     
                 Connection conn     = null;
                 
                 // figure out what server this application is being hosted on
                 String url          = getServerURL();
                 
                 String db           = "test1";
                 String driver       = "com.mysql.jdbc.Driver";
                 String user         = "root";
                 String pass         = "root";
                 
                 try {
                   
                     Class.forName(driver).newInstance();
                     conn = DriverManager.getConnection(url+db, user, pass);
                   
                 } catch (Exception e) {
                     
                     // error
                     System.err.println("Mysql Connection Error: ");
                     
                     // for debugging error
                     e.printStackTrace();
                 }
             
                 return conn;
     }
     
     /**
      * get string url for server location
      * find out what computer this is own, then make the db url string
      * 
      * @return
      */
     private String getServerURL() {
             String url = "jdbc:mysql://127.0.0.1:3306/";
            
             return url;
     }
     
     /*
      * get recordset row count
      * 
      * static will allow you to use it independently, persay, 
      * you don't have to init the class into an object to use this method
      */
     protected static int getResultSetSize(ResultSet resultSet) {
         int size = -1;

         try {
             resultSet.last();
             size = resultSet.getRow();
             resultSet.beforeFirst();
         } catch(SQLException e) {
             return size;
         }

         return size;
     }
             


}
