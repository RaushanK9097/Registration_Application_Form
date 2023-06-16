package com.Register.Form.Login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
   private static Connection con = null;
   public DbConnection() {
	
    }
   static {
   try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 con= DriverManager.getConnection
				 ("jdbc:oracle:thin:@localhost:1521:orcl","system","kumar");
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public static Connection getCon() {
	   return con;
   }
   
}
