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
 * 
 * @author PersistenceTeam Edited by Jonah Marcus on 20 April 2022 to address
 *         Bug #48.
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
    // static final String QUERY = "SELECT * FROM prototype_table";

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

    // /**
    // * Database Connection.
    // */
    // private static Connection dbConnection;

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
            // Class.forName("com.mysql.jdbc.Driver");
            conn = getDbConnection();

            String script = "UPDATE player_account SET " + toChange
                + "= ?  WHERE PersonID = ?";
            ps = conn.prepareStatement(script);

            ps.setString(1, changeTo);
            ps.setInt(2, userId);

            ps.executeUpdate();

        }
        catch (SQLException sqle) {
            // sqle.printStackTrace();
            LOG.error("Database Interaction Failure" + sqle);

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

            dbDisconnect(conn);

        }
    }

    /**
     * changePassword method.
     * 
     * @param user
     * @param newPassword
     */
    public void changepass(String user, String newPassword) {

        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conn = getDbConnection();

            String script =
                "UPDATE player_account SET Password = ?  WHERE UserName = ?";
            ps = conn.prepareStatement(script);

            ps.setString(1, newPassword);
            ps.setString(2, user);

            ps.executeUpdate();

        }
        catch (SQLException sqle) {
            // sqle.printStackTrace();
            LOG.error("Database Interaction Failure: " + sqle);

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

            dbDisconnect(conn);

        }
    }

    /**
     * This is a function to check the database for a specific user and check
     * whether the password functions.
     * 
     * @author Tinaye Mawocha
     * @param user
     *            : the username of the desired user
     * @return Whether password was accepted
     */
    public Password getPassword(User user) {

        String username = user.getUserName();
        Password returningPassword;

        String tempQuery =
            "SELECT * FROM player_account WHERE username='" + username + "'";
        // Connection conn = dbConnect();
        String storedPassword = "";

        try {
            Connection conn = getDbConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(tempQuery);

            rs.next();
            storedPassword = rs.getString("Password");

            dbDisconnect(conn);

        }
        catch (SQLException e) {
            LOG.error("Getting passwork didn't work: " + e);
            // e.printStackTrace();

        }

        if (storedPassword.equals("")) {
            return null;
        } else {
            returningPassword = new Password(storedPassword);
            return returningPassword;
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
    @SuppressWarnings("unused")
    public HashMap<String, Item> inventoryQuery(int playerID) {

        String tokenQuery =
            "SELECT * FROM inventory INNER JOIN player_account ON "
                + "player_account.PersonID=inventory.PersonID "
                + "INNER JOIN item_table ON inventory.ItemID=item_table.item_ID"
                + " WHERE player_account.PersonID = 3";

        PreparedStatement ps = null;
        Connection conn = null;
        int netWorth = 0;
        HashMap<String, Item> playerInventory = new HashMap<String, Item>();

        try {

            conn = getDbConnection();
            ps = conn.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);

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
            // e.printStackTrace();
            dbDisconnect(conn);
            LOG.error("Account not found");
            return playerInventory;
        }

    }

    /**
     * This is a function to access the database.
     *
     * @author Nikoleta Chantzi
     * @return dbConnection
     */
    public static Connection getDbConnection() {
        Connection dbConnection = null;
        try {
            dbConnection =
                DriverManager.getConnection(DB_URL, USER, PASS);

        }
        catch (SQLException e) {
            LOG.error("Cannot create connection to database", e);
        }

        return dbConnection;

    }

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

            conn = getDbConnection();

            ps = conn.prepareStatement(tokenQuery);
            ps.setInt(1, playerID);

            ResultSet rs = ps.executeQuery();

            rs.next();
            netWorth = rs.getInt("Wallet");

        }
        catch (SQLException e) {
            e.printStackTrace();

            return "Account not found";

        }
        finally {
            dbDisconnect(conn);
        }

        return "player coin value: " + netWorth;

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
            // set account to active when creating a user
            conn = getDbConnection();

            String script =
                "INSERT INTO player_account "
                    + "(Username, Password, account_status) "
                    + "VALUES (?, ?, 1)";
            ps = conn.prepareStatement(script);

            ps.setString(1, userName);
            ps.setString(2, password);

            ps.executeUpdate();

        }
        catch (SQLException sqle) {
            LOG.error("Database Interaction Failure", sqle);

        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqle) {
                    LOG.error("Failed to close result set", sqle);

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

            dbDisconnect(conn);
        }
    }

    /**
     * This is a method to delete an existent player from the player_account
     * table.
     * 
     * @author Nikoleta Chantzi
     * @param userName
     *            : the name of the user deleted, can only occur if you're
     *            logged in
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

        // set account to inactive when deleting a user
        try {
            // set flag to inactive
            conn = getDbConnection();

            String script =
                "UPDATE player_account "
                    + "SET account_status = 0 WHERE Username = ?";
            ps = conn.prepareStatement(script);

            ps.setString(1, userName);

            ps.executeUpdate();

        }
        catch (SQLException sqle) {
            LOG.error("Database Interaction Failure", sqle);
            sqle.printStackTrace();

        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqle) {
                    LOG.error("Failed to close result set", sqle);

                }

            }

            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException sqle) {
                    LOG.error("Failed to close prepared statement", sqle);
                }
            }

            dbDisconnect(conn);
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
        if (theConnection != null) {
            try {
                theConnection.close();
            }
            catch (SQLException e) {
                LOG.error("Failed to close connection", e);
            }
        } else {
            LOG.error("Attempting to close null connection");

        }

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
        Connection conn = null;

        try {
            conn = getDbConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(tempQuery);

            rs.next();
            storedPassword = rs.getString("Password");

            dbDisconnect(conn);

        }
        catch (SQLException e) {
            LOG.error("Account not found");
            e.printStackTrace();

        }
        finally {
            dbDisconnect(conn);
        }

        if (storedPassword.compareTo(password.getBase64PasswordHash()) == 0) {
            user.setUserRole(UserRole.AUTHORIZED);
            return true;
        } else {
            user.setUserRole(UserRole.UNAUTHORIZED);
            return false;
        }

    }

    /**
     * This is a function to check.
     * 
     * @author Nikoleta Chantzi
     * @param username
     *            : the id of the player to check if exists
     * @return whether account exists in the database
     * @throws SQLException
     */

    public boolean accountExists(String username) {

        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        boolean exists = false;

        try {
            conn = getDbConnection();

            String tempQuery = "SELECT * FROM player_account WHERE username= ?";

            ps = conn.prepareStatement(tempQuery);

            ps.setString(1, username);

            rs = ps.executeQuery();

            // if result contains player's username, this will return true
            // (account found)
            // if result is empty, this will return false (account not found)
            exists = rs.next();

        }
        catch (SQLException e) {
            LOG.error("Account not found");

        }
        finally {

            try {
                rs.close();
            }
            catch (SQLException sqle) {

            }
            finally {
                dbDisconnect(conn);
            }

        }

        // if we reach this line, we run into a SQLException
        return exists;
    }

    /**
     * Retrieve the user's Base64-encoded password salt.
     * 
     * @author Dave Read
     * @param username
     *            : the id of the user whose salt is to be obtained
     * @return The Base64-encoded user's salt or null if the user is not found
     * @throws SQLException
     */
    public String getUserSaltBase64(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String salt = null;

        try {
            conn = getDbConnection();

            String tempQuery =
                "SELECT Password FROM player_account WHERE username= ?";
            ps = conn.prepareStatement(tempQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                salt = new Password(rs.getString(1)).getBase64Salt();
            }
        }
        catch (SQLException e) {
            LOG.error("Error obtaining user's password salt", e);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqle) {
                    LOG.error("Error closing database connection", sqle);
                }
            }
        }

        return salt;
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
     *            : the user account to add to
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

        try {
            HashMap<String, Item> userInventory =
                inventoryQuery(user.getUserId());
            if (userInventory.containsKey(itemType.toString())) {
                Item tempItem = userInventory.get(itemType.toString());
                quantity += tempItem.getQuantityHeld();
                // delete item from db
                // inventoryDelete();
            }

            String script = "INSERT INTO player_account (ItemID, PersonID, "
                + "ItemType, Quantity, LastModified ) VALUES (?,?,?,?,?)";
            conn = getDbConnection();
            ps = conn.prepareStatement(script);

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
            dbDisconnect(conn);
        }
    }
}
