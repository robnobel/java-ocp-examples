package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	 static private final String URL = "jdbc:mysql://localhost:3306/sakila";
	 static private final String USER = "admin";
	 static private final String PW = "welcome01";
	 
	 static public Connection getConnection(){ 
	 
		 Connection conn =null ;
		 try{
		    conn = DriverManager.getConnection(URL,USER,PW);
	     }
	     catch(SQLException e){
		    System.out.println(e.getMessage());
	     }
	     
	     return conn;
	 }
}
