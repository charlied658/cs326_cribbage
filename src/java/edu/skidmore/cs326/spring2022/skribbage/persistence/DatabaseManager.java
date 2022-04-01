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
 * Please also note that queries are placeholders and will be injected into code when finally completed 
 *  
 */
public class DatabaseManager {

    static final String DB_URL =
        DatabaseProperties.getInstance().getValue("DBUrl");

    static final String USER =
        DatabaseProperties.getInstance().getValue("UserID");

    static final String PASS =
        DatabaseProperties.getInstance().getValue("AppPassword");

    static final String QUERY = "SELECT * FROM prototype_table";

    private static Connection dbConnection;

    
    /* 

	 * This is a function to check the database for a specific user and check whether the password functions 

	 *  

	 *  @author Tinaye Mawocha 

	 *  @param username : the username of the desired user 

	 *	@param password : the inputted password 

	 */ 

	 
    public boolean userAuthenticate(String username, String password) {

        String tempQuery =
            "SELECT * FROM player_account WHERE username='" + username + "'";
        // Connection conn = dbConnect();
        String storedPassword = "";

        try {
            Connection conn = getDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(tempQuery);

            rs.next();
            storedPassword = rs.getString("Password");

        }
        catch (SQLException e) {
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

	 * This is a function to query the token value held by a player  

	 *  

	 *  @author Tinaye Mawocha 

	 *  @param playerID: the id of the player to check the value 

	 * 

	 */ 
    public String inventoryQuery(int playerID) {

        String tokenQuery = "SELECT * FROM player_account WHERE PersonID = ? ";
     
        
        PreparedStatement ps = null;	
        Connection conn = null;
        int netWorth = 0;
      

        try {
        	
        	conn = getDB();
        	ps = dbConnection.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);
                   
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            rs.next();
            netWorth = rs.getInt("Wallet");

        }
        catch (SQLException e) {
            System.out.println("Account not found");
            e.printStackTrace();

        }

        return "player coin value: " + netWorth;

    }

  

    /*
     * This is a method to change a value on the player_account table
     *
     *  @author Tinaye Mawocha
     *  @param toChange : the name of the column you wish to change 
     *  @param changeTo : the new value you wish to input into the aforementioned table
     *  @param user_id : the account id of the account you wish to change
     */
    public void update(String toChange, String changeTo, int user_id) {

        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            //	 System.out.println("Run a prepared database query");
            //	 Class.forName("com.mysql.jdbc.Driver");
            conn = getDB();

            String script =
                "UPDATE player_account SET " + toChange + "= ?  WHERE PersonID = ?";
            ps = conn.prepareStatement(script);

            ps.setString(1, changeTo);
            ps.setInt(2, user_id);

            System.out.println(ps);
            System.out.println(ps.executeUpdate());

        }
        catch (SQLException sqle) {

            sqle.printStackTrace();
            //LOGGER.error("Database Interaction Failure", sqle);

        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqle) {
                    // 	LOGGER.error("Failed to close result set", sqle);

                }

            }

            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException sqle) {
                    //	LOGGER.error("Failed to close prepared statement", sqle);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException sqle) {
                    //		LOGGER.error("Failed to close connection", sqle);
                }
            }
        }
    }

   

    /*
     * This is a function to access the connection singleton
     *
     *  @author Tinaye Mawocha
     *
     */
    private static Connection getDB() {

        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

            }
            catch (SQLException e) {
                System.out
                    .println("Failed to establish connection with database");
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
     * @author Tinaye Mawocha
     */
    private void dbDisconnect(Connection theConnection) {

        try {
            theConnection.close();
        }
        catch (SQLException e) {
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
        System.out.println((instance.inventoryQuery(325)));

        //userAuthenticate("nchantzi", "ILoveSQL");

    }

}
