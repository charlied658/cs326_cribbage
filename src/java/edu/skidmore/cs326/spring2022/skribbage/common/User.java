package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;

import java.util.Objects;

/**
 * A simple bean representing data associated with a User.
 *
 * @author Alex Carney
 */
public class User implements Payload {
    /**
     * Private string attribute to store the email of a user.
     */
    private final String email;

    /**
     * Private string attribute to store a username of a user.
     * 
     * @reviewed Tinaye Mawocha removed keyword final as username may need to
     *           change
     * @reviewed Alex Carney added it back because it should be there
     */
    private final String userName;

    /**
     * Private string attribute to store a userId of a user.
     * 
     * @reviewed Tinaye Mawocha removed keyword final as username may need to
     *           change
     */
    private int userId;
    
    /**
     * Inventory object to manage a users inventory.
     */
    private InventoryPrototype inventoryManager = new InventoryPrototype();

    /**
     * @return the user's ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Functionality to update user's ID.
     * 
     * @param id
     *            new role.
     */
    public void setUserId(int id) {
        userId = id;
    }

    /**
     * Private boolean attribute to store if user is authorized. Mutable.
     */
    private UserRole userRole;

    /**
     * Private static final Logger attribute for logging.
     */
    private static final Logger LOG;

    /**
     * Initializing the instance of Logger.
     */
    static {
        LOG = Logger.getLogger(User.class);
    }

    /**
     * @param email
     *            User's email
     * @param userName
     *            userName of user
     * @param userRole
     *            Determines whether or not the user is logged in.
     * @see UserRole
     */
    public User(String email, String userName,
        UserRole userRole) {
        this.email = email;
        LOG.trace("Email value set to:" + email);
        this.userName = userName;
        LOG.trace("userName value set to: " + userName);
        this.userRole = userRole;
        LOG.trace("isAuthorized value was set to: " + userRole);
        LOG.info(
            "The parameters of User constructor were assigned"
                + " to private variable attributes");
    }

    /**
     * @return the user email.
     */
    public String getEmail() {
        LOG.debug("Returning email of a user");
        return email;
    }

    /**
     * @return the user's name
     */
    public String getUserName() {
        LOG.debug("Returning the userName of a user");
        return userName;
    }


    /**
     * @return The authorization status of this user.
     */
    public UserRole getUserRole() {
        LOG.debug("Returning a user role");
        return userRole;
    }

    /**
     * Functionality to update user's permission level.
     * 
     * @param userRole
     *            new role.
     */
    public void setUserRole(
        UserRole userRole) {
        LOG.info("Assigning a user role.");
        this.userRole = userRole;
    }

    /**
     * Compare two users for equality. Does not compare authorization level
     * or passwords.
     * 
     * @param o
     *            Object to compare to this user.
     * @return True if the users are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        LOG.debug("Comparing two users for equality.");
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return email.equals(user.email) && userName.equals(user.userName);
    }

    /**
     * Generate hash code for this object.
     * 
     * @return int hashcode
     */
    @Override
    public int hashCode() {
        LOG.info("Generating hashcode for this object");
        return Objects.hash(email, userName);
    }

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\''
            + ", userName='" + userName + '\''
            + ", userRole=" + userRole
            + '}';
    }
    
    /**
     * Getter for inventory.
     * @return
     *      returns inventoryManager
     */
    public InventoryPrototype getInventoryManager() {
        return inventoryManager;
    }

}
