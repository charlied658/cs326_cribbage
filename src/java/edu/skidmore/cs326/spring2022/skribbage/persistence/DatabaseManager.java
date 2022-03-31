package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * Please note that this file will not function without first opening the keyhole to the connection within your terminal.
 * To achieve this type ssh cs326mysql@bits.monead.com
 * 
 * 
 */
public class DatabaseManager {

	static final String DB_URL = DatabaseProperties.getInstance().getValue("DBUrl");
	static final String USER = DatabaseProperties.getInstance().getValue("UserID");
	static final String PASS = DatabaseProperties.getInstance().getValue("AppPassword");
	static final String QUERY = "SELECT * FROM prototype_table";

	private static Connection dbConnection;

	public boolean userAuthenticate(String username, String password) {

		String tempQuery = "SELECT * FROM player_account WHERE username='" + username + "'";
		// Connection conn = dbConnect();
		String storedPassword = "";

		try {
			Connection conn = getDB();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(tempQuery);

			rs.next();
			storedPassword = rs.getString("Password");

		} catch (SQLException e) {
			System.out.println("Account not found");
			e.printStackTrace();

		}

		if (storedPassword.compareTo(password) == 0) {
			System.out.println("Password Accepted");
			return true;
		} else {
			System.out.println("Incorrect Password");
			return false;
		}

	}

	/*
	 * This is a function to access the connection singleton
	 *
	 */
	public String inventoryQuery(int playerID) {

		String tokenQuery = "SELECT * FROM player_inventory WHERE player_id='" + playerID + "'";
		// Connection conn = dbConnect();
		int netWorth = 0;

		try {
			Connection conn = getDB();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(tokenQuery);

			rs.next();
			netWorth = rs.getInt("token_value");

		} catch (SQLException e) {
			System.out.println("Account not found");
			e.printStackTrace();

		}

		return "player coin value: " + netWorth;

	}

	
	
	
	///example code
	
	
	
public void update(String toChange, String changeTo, int user_id)  {
	
	Connection conn = null;
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
 	try {
//	 System.out.println("Run a prepared database query");
//	 Class.forName("com.mysql.jdbc.Driver");
 		conn = getDB();
	
 		ps = conn.prepareStatement("UPDATE player_account SET ? = ?  WHERE PersonID = ?");
 				
 		ps.setString(1, toChange);
 		ps.setString(2, changeTo);
 		ps.setInt(3, user_id);
 		
 		System.out.println(ps);	
 		System.out.println(ps.executeUpdate());	
		 
		  
 		} catch (SQLException sqle) {
	
			sqle.printStackTrace();
			//LOGGER.error("Database Interaction Failure", sqle);
			
 		} finally {
		 if (rs != null) { try { rs.close(); }		 catch (SQLException sqle) {
			// 	LOGGER.error("Failed to close result set", sqle);
		 
		 }
		 
		 }
		 
		 if (ps != null) { try { ps.close(); }
		 		catch (SQLException sqle) {
		 	//	LOGGER.error("Failed to close prepared statement", sqle);
		 	}
		 }
		 if (conn != null) { try { conn.close(); }
		 		catch (SQLException sqle) {
		 	//		LOGGER.error("Failed to close connection", sqle);
		 		}
		 	}
		}
 	 }
	/*
	 * This is a function to access the connection singleton
	 *
	 */
	private Connection getDB() {

		if (dbConnection == null) {
			try {
				dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

			} catch (SQLException e) {
				System.out.println("Failed to establish connection with database");
				e.printStackTrace();
			}
			System.out.println("Connected");
			return dbConnection;
		} else {
			System.out.println("Already Connected");
			return dbConnection;
		}

	}
	
	/*
	 * This is a function to access the connection singleton
	 *
	 */
	private static Connection getDB() {

		if (dbConnection == null) {
			try {
				dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

			} catch (SQLException e) {
				System.out.println("Failed to establish connection with database");
				e.printStackTrace();
			}
			System.out.println("Connected");
			return dbConnection;
		} else {
			System.out.println("Already Connected");
			return dbConnection;
		}

	}

	/*
	 * This is a function to disconnect the connection passed into the
	 * "theConnection" parameter
	 * 
	 * @param theConnection: the connection passed in to be terminated
	 */
	private void dbDisconnect(Connection theConnection) {

		try {
			theConnection.close();
		} catch (SQLException e) {
			System.out.println("Failed to close connection to database");
			e.printStackTrace();
		}

	}

	/*
	 * Just Kidding, you know what this does
	 * 
	 */
	public static void main(String[] args) {

	
//		// Open a connection
//		System.out.println("Testing");
//		//getDB();
//		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(QUERY);
//
//		) {
//			while (rs.next()) {
//				// Display values
//				System.out.print(" ID: " + rs.getInt("person_id"));
//				System.out.print(", Name: " + rs.getString("person_name"));
//
//			}
//			conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		DatabaseManager instance = new DatabaseManager();
		instance.update("Password","new password",325);

		//userAuthenticate("nchantzi", "ILoveSQL");

	}

}
