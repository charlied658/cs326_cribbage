package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * A simple bean representing data associated with a User.
 * TODO (DSR): manage password separately (not part of general interactions)
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
     */
    private final String userName;

    /**
     * Private string attribute to store a password of a user.
     * //TODO: DEPRECATED; Should be a Password object type soon
     */
    private final String password;

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
     * @param email        User's email
     * @param userName     userName of user
     * @param password     Password submitted
     * @param userRole Determines whether or not the user is logged in.
     * @see UserRole
     */
    public User(String email, String userName, String password,
        UserRole userRole) {
        this.email = email;
        LOG.debug("Email value set to:" + email);
        this.userName = userName;
        LOG.debug("userName value set to: " + userName);
        this.password = password;
        this.userRole = userRole;
        LOG.debug("isAuthorized value was set to: " + userRole);
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
     * @return the user password.
     */
    public String getPassword() {
        LOG.debug("Returning the password of a user");
        return password;
    }

    /**
     * @return The authorization status of this user.
     */
    public UserRole getUserRole() {
        LOG.debug("Returning the boolean value of isAuthorized");
        return userRole;
    }

    /**
     * Functionality to update user's permission level.
     * @param userRole new role.
     */
    public void setUserRole(
        UserRole userRole) {
        this.userRole = userRole;
    }
}
