package edu.skidmore.cs326.spring2022.skribbage.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

		   static final String DB_URL = "jdbc:mysql://bits.monead.com:3306/skribbage";
		   static final String USER = "skribbage_adm";
		   static final String PASS = "cFT8Ef^MmRHP";
		   static final String QUERY = "SELECT * FROM prototype_table";
		   	
		   
		   private static Connection dbConnection;
		   
		   
		   //Query Function
		   // static final Stry{
//		   Connection conn  = DriverManager.getConnection(DB_URL, USER, PASS);
//		   return conn;
//	   } catch (SQLException e) {
//		   System.out.println("Failed to establish connection with database");
//		   e.printStackTrace();	   
//	   }
//	   tring QUERY = "SELECT * FROM prototype_table";
		   // function to assert that username and password belongs to an existing user and that they match
		   
		   
		   public static boolean userAuthenticate(String username,  String password) {
	
			
			   String tempQuery = "SELECT * FROM player_account WHERE username='" + username + "'";
			 //  Connection conn = dbConnect(); 
			   String storedPassword = "";
			   
			 try {
				 	Connection conn  = DriverManager.getConnection(DB_URL, USER, PASS);
			       Statement stmt = conn.createStatement();
			       ResultSet rs = stmt.executeQuery(tempQuery);   
			       storedPassword = rs.getString("password");		   
				 
			 } catch(SQLException e) {
				 System.out.println("Account not found");
				 e.printStackTrace();	
				 
			 }
			   
			 if(storedPassword == password) {
				   return true;
			   } else {
				   return false;
			   }
			 
			 	  	   
		   }
		   
		   private Connection Connection() {
			   try{
				   Connection conn  = DriverManager.getConnection(DB_URL, USER, PASS);
				   return conn;
			   } catch (SQLException e) {
				   System.out.println("Failed to establish connection with database");
				   e.printStackTrace();	   
			   }
		   }
		   
		   
		   private Connection getDB() {
			    
			   if(dbConnection == null) {
				  dbConnection = Connection();
				  return dbConnection;
			   } else {
				   return dbConnection;
			   }
 
			   
			   
			   
		   }
		   
		   private void dbDisconnect(Connection theConnection) {
			   		   
			   try {   
				   theConnection.close();		   
			   } catch (SQLException e) {			   
				   System.out.println("Failed to close connection to database");		
				   e.printStackTrace(); 		   
			   }
			   
		   }
		   
		   
		   
		   
		   public static void main(String[] args) {
			      System.out.println("Connecting to a selected database...");
			      // Open a connection
			      //try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 	       
//			         Statement stmt = conn.createStatement();
//			         ResultSet rs = stmt.executeQuery(QUERY);
//			    		  
//			    		  ){		      
//			    		         while(rs.next()){
//			    		            //Display values
//			    		            System.out.print(" ID: " + rs.getInt("person_id"));
//			    		            System.out.print(", Name: " + rs.getString("person_name"));
//			    		            test
//			    		         }
//			    		         conn.close();
//			         
//			         
//			      } catch (SQLException e) {
//			         e.printStackTrace();
//			      }
//
//			      
//			      
//			    
			      
			      
			      
			      
			     userAuthenticate("nchantzi","subject");
			     
			   }

			      
			      

}