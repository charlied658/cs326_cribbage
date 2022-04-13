package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Contains the methods that connect to the database. Creates, edits, and
 * deletes profiles.
 * Please note that this file will not function without first opening the
 * keyhole to the connection within your terminal.
 * To achieve this type ssh cs326mysql@bits.monead.com
 * Please also note that queries are placeholders and will be injected into code
 * when finally completed
 */
public class DatabaseManager {

    /**
     * Database URL.
     */
    static final String DB_URL =
        DatabaseProperties.getInstance().getValue("DBUrl");

    /**
     * UserID.
     */
    static final String USER =
        DatabaseProperties.getInstance().getValue("UserID");

    /**
     * App Password.
     */
    static final String PASS =
        DatabaseProperties.getInstance().getValue("AppPassword");
    
    /**
     * Query String.
     */
    static final String QUERY = "SELECT * FROM prototype_table";

    
	/**
	 * Logger for the class
	 */
	private static final Logger LOG;
	
	/**
	 * Initializing Logger
	 *
	 */
	static {
		LOG = Logger.getLogger(DatabaseManager.class);
	}
	
    /**
     * Database Connection.
     */
    private static Connection dbConnection;

    /**
     * This is a function to check the database for a specific user and check
     * whether the password functions.
     * 
     * @author Tinaye Mawocha
     * @param username
     *            : the username of the desired user
     * @param password
     *            : the inputted password
     * @return Whether password was accepted
     */

    public boolean userAuthenticate(String username, String password) {

        String tempQuery =
            "SELECT * FROM player_account WHERE username='" + username + "'";
        //Connection conn = dbConnect();
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
    
    
    /**
     * This is a function to query the inventory items held by a player.
     * 
     * @author Tinaye Mawocha
     * @param playerID :
     *            the id of the player to check the value
     * @return Query result
     */
    public HashMap<String,Item> inventoryQuery(int playerID) {

    	System.out.println("we here");
        String tokenQuery = "SELECT * FROM inventory WHERE PersonID = ? ";

        PreparedStatement ps = null;
        Connection conn = null;
        int netWorth = 0;
        HashMap<String,Item> playerInventory = new HashMap();
        
        try {

            conn = getDB();
            ps = dbConnection.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);

            // System.out.println(ps);
            ResultSet rs = ps.executeQuery();
           
            
            
            while(rs.next()) {
            	
            	Item tempItem = null;
            	String tempType = rs.getString("item_type");
            	dbDisconnect(conn);  tempItem.setItemType(ItemTypes.valueOf(tempType));
                tempItem.setQuantityHeld(rs.getInt("quantity"));
                
                playerInventory.put(tempType,tempItem);
                
            }
            
            dbDisconnect(conn);
            return playerInventory;

        }
        catch (SQLException e) {
            // System.out.println("AccountinventoryQuery not found");
            e.printStackTrace();
            dbDisconnect(conn);
            LOG.error("Account not found");
            return playerInventory;
        }

       
      

    }

    
    
    

    /**
     * This is a function to query the token value held by a player.
     * 
     * @author Tinaye Mawocha
     * @param playerID :
     *            the id of the player to check the value
     * @return Query result
     */
    public String walletQuery(int playerID) {

        String tokenQuery = "SELECT * FROM player_account WHERE PersonID = ? ";

        PreparedStatement ps = null;
        Connection conn = null;
        int netWorth = 0;

        try {

            conn = getDB();
            ps = dbConnection.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);

            // System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            rs.next();
            netWorth = rs.getInt("Wallet");

        }
        catch (SQLException e) {
            // System.out.println("AccountinventoryQuery not found");
            e.printStackTrace();
            dbDisconnect(conn);
            return "Account not found";

        }

        dbDisconnect(conn);
        return "player coin value: " + netWorth;

    }

    /**
     * This is a method to change a value on the player_account table.
     *
     * @author Tinaye Mawocha
     * @param toChange
     *            : the name of the column you wish to change
     * @param changeTo
     *            : the new value you wish to input into the aforementioned
     *            table
     * @param userId
     *            : the account id of the account you wish to change
     */
    public void update(String toChange, String changeTo, int userId) {

        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            // System.out.println("Run a prepared database query");
            // Class.forName("com.mysql.jdbc.Driver");
            conn = getDB();

            String script =
                "UPDATE player_account SET " + toChange
                    + "= ?  WHERE PersonID = ?";
            ps = conn.prepareStatement(script);

            ps.setString(1, changeTo);
            ps.setInt(2, userId);

            System.out.println(ps);
            System.out.println(ps.executeUpdate());

        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
            // LOGGER.error("Database Interaction Failure", sqle);

        }
        finally {
            if (rs != null) {
                try {
                    rs.close();	
                }
                catch (SQLException sqle) {
                    // LOGGER.error("Failed to close result set", sqle);

                }

            }

            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException sqle) {
                    // LOGGER.error("Failed to close prepared statement", sqle);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException sqle) {
                    // LOGGER.error("Failed to close connection", sqle);
                }
            }
        }
    }

    /**
     * This is a function to access the connection singleton.
     *
     * @return Connection
     * @author Tinaye Mawocha
     */
    private static Connection getDB() {

        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

            }
            catch (SQLException e) {
                // System.out.println("Failed to establish connection with
                // database");
                e.printStackTrace();
            }
            System.out.println("Connected");
            return dbConnection;
        } else {
            // System.out.println("Already Connected");
            return dbConnection;
        }

    }

    /**
     * This is a function to disconnect the connection passed into the
     * "theConnection" parameter.
     *
     * @param theConnection
     *            the connection passed in to be terminated
     * @author Tinaye Mawocha
     */
    public void dbDisconnect(Connection theConnection) {

        try {
            theConnection.close();
        }
        catch (SQLException e) {
            System.out.println("Failed to close connection to database");
            e.printStackTrace();
        }

    }
    
    public boolean createUser(String userName, String password) {
    	
    	//INSERT INTO player_account (personID, LastName, FirstName, UserName, Password, AvatarURL, Email)
    	//VALUES (/* comma separated values in the exact order of the above columns*/ ); 
    	
    	return true;
    }
    
    public static void main(String[] args) {
		//dm.inventoryQuery(236);
		
    	DatabaseManager test = new DatabaseManager();
    	
    	test.userAuthenticate("tmawocha", "0000f");
		
		
		
		
		
	}

}
