package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;

/**
 * Contains the methods that connect to the database. Creates, edits, and
 * deletes profiles. Please note that this file will not function without first
 * opening the keyhole to the connection within your terminal. To achieve this
 * type ssh cs326mysql@bits.monead.com Please also note that queries are
 * placeholders and will be injected into code when finally completed
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
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Initializing Logger
     */
    static {
        LOG = Logger.getLogger(DatabaseManager.class);
    }

    /**
     * Database Connection.
     */
    private static Connection dbConnection;

    /**
     * String array containing the column names.
     */
    // static final String[] COLUMN_NAMES = ;

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

//    public boolean userAuthenticate(User user, Password password) {
//
//    	String username = user.getUserName();
//        String tempQuery =
//            "SELECT * FROM player_account WHERE username='" + username + "'";
//        // Connection conn = dbConnect();
//        String storedPassword = "";
//
//        try {
//            Connection conn = getDB();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(tempQuery);
//
//            rs.next();
//            storedPassword = rs.getString("Password");
//
//        }
//        catch (SQLException e) {
//            System.out.println("Account not found");
//            e.printStackTrace();
//
//        }
//
//        if (storedPassword.compareTo(password.getPasswordValue()) == 0) {
//            System.out.println("Password Accepted");
//            return true;
//        } else {
//            System.out.println("Incorrect Password");
//            return false;
//        }
//
//    }

    /**
     * This is a function to query the token value held by a player.
     * 
     * @author Tinaye Mawocha
     * @param playerID
     *            : the id of the player to check the value
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

            String script = "UPDATE player_account SET " + toChange
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
     * This is a method to add a new player to the player_account table.
     *
     * @author Nikoleta Chantzi and Jamie Brunstad
     * @param userName
     *            : the name of the user added
     * @param password
     *            : the password of the new user
     */
    public void createUser(String userName, String password) {
        // INSERT INTO player_account (personID, LastName, FirstName, UserName,
        // Password, AvatarURL, Email)
        // VALUES (/* comma separated values in the exact order of the above
        // columns*/
        // );
        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            // System.out.println("Run a prepared database query");
            // Class.forName("com.mysql.jdbc.Driver");
            conn = getDB();

            String script =
                "INSERT INTO player_account (PersonID, Username, Password) "
                    + "VALUES (RAND()*10000, ?, ?)";
            ps = conn.prepareStatement(script);

            ps.setString(1, userName);
            ps.setString(2, password);

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
     * delete user method.
     * 
     * @param userName
     * @param password
     */
    public void deleteUser(String userName, String password) {
        // INSERT INTO player_account (personID, LastName, FirstName, UserName,
        // Password, AvatarURL, Email)
        // VALUES (/* comma separated values in the exact order of the above
        // columns*/
        // );
        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            // System.out.println("Run a prepared database query");
            // Class.forName("com.mysql.jdbc.Driver");
            conn = getDB();

            String script = "DELETE FROM player_account WHERE Username = ?";

            ps = conn.prepareStatement(script);

            ps.setString(1, userName);

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
        /**
         * This is a method to delete an existent player from the player_account
         * table.
         *
         * @author Nikoleta Chantzi
         * @param userName
         *            : the name of the user deleted, can only occur if you're
         *            logged in
         */

    }

    /**
     * main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // dm.inventoryQuery(236);

        DatabaseManager test = new DatabaseManager();

        // test.userAuthenticate("tmawocha", "0000f");
    }

    /**
     * This is a function to check the database for a specific user and check
     * whether the password functions.
     * 
     * @author Tinaye Mawocha
     * @param user
     *            : the username of the desired user
     * @param password
     *            : the inputted password
     * @return Whether password was accepted
     */
    public boolean userAuthenticate(User user, Password password) {

        String username = user.getUserName();

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

        if (storedPassword.compareTo(password.getPasswordValue()) == 0) {
            System.out.println("Password Accepted");
            user.setUserRole(UserRole.AUTHORIZED);
            return true;
        } else {
            System.out.println("Incorrect Password");
            user.setUserRole(UserRole.UNAUTHORIZED);
            return false;
        }

    }

    /**
     * This is a function to query the inventory items held by a player.
     * 
     * @author Tinaye Mawocha
     * @param playerID
     *            : the id of the player to check the value
     * @return Query result
     */
    public HashMap<String, Item> inventoryQuery(int playerID) {

        String tokenQuery = "SELECT * FROM inventory WHERE PersonID = ? ";

        PreparedStatement ps = null;
        Connection conn = null;
        int netWorth = 0;
        HashMap<String, Item> playerInventory = new HashMap();

        try {

            conn = getDB();
            ps = dbConnection.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);

            // System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Item tempItem = new Item();
                String tempType = rs.getString("itemType");

                tempItem.setItemType(ItemTypes.valueOf(tempType));

                int quantity = rs.getInt("quantity");
                if (playerInventory.containsKey(tempType)) {

                    int existingQuantity =
                        playerInventory.get(tempType).getQuantityHeld();
                    tempItem.setQuantityHeld(quantity + existingQuantity);

                } else {

                    tempItem.setQuantityHeld(quantity);

                }

                playerInventory.put(tempType, tempItem);

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
     * This is a method to add a new item to the inventory table.
     *
     * @author Tinaye Mawocha
     * @param itemType
     *            : the type of item to be added
     * @param quantity
     *            : the quantity of items to be added
     * @param user
     * 			  : the user account to add to
     */
    public void inventoryDeposit(ItemTypes itemType, int quantity, User user) {
    	
        // INSERT INTO player_account (personID, LastName, FirstName, UserName,
        // Password, AvatarURL, Email)
        // VALUES (/* comma separated values in the exact order of the above
        // columns*/
        // );
        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;
        
//        

        try {
            // System.out.println("Run a prepared database query");
            // Class.forName("com.mysql.jdbc.Driver");
            
            
            HashMap<String, Item> userInventory = inventoryQuery(user.getUserId());
            if (userInventory.containsKey(itemType.toString())) {
      	    Item tempItem = userInventory.get(itemType.toString());
            quantity += tempItem.getQuantityHeld();
//      	   delete item from db
//       	   inventoryDelete();
          }
            
            String script =
                "INSERT INTO player_account (ItemID, PersonID, ItemType, Quantity, LastModified ) VALUES (?,?,?,?,?)";
            conn = getDB();
            ps = conn.prepareStatement(script);
            System.out.println("walk");

            ps.setInt(1, itemType.getItemId());
            ps.setInt(2, user.getUserId());
            ps.setString(3, itemType.toString());
            ps.setInt(4, quantity);
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            LocalDateTime now = LocalDateTime.now();             
            ps.setString(5, dtf.format(now));

            
            ps.executeUpdate();
            

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

}
