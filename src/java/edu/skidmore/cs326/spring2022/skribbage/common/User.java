package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;
//import org.mortbay.log.Log;

/**
 * A simple bean representing data associated with a User
 *
 * @author Alex Carney
 */
public class User {
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
     */
    private final String password;

    /**
     * Private boolean attribute to store if user is authorized.
     */
    private final boolean isAuthorized;

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
     * @param userName
     * @param password
     * @param isAuthorized
     */
    public User(String email, String userName, String password,
        boolean isAuthorized) {
        this.email = email;
        LOG.debug("Email value set to:" + email);
        this.userName = userName;
        LOG.debug("userName value set to: " + userName);
        this.password = password;
        LOG.debug("passwprd value set to: " + password);
        this.isAuthorized = isAuthorized;
        LOG.debug("isAuthorized value was set to: " + isAuthorized);
        LOG.info(
            "The parameters of User constructor were assigned"
            + " to private variable attributes");
    }

    /**
     * @return
     */
    public String getEmail() {
        LOG.debug("Returning email of a user");
        return email;
    }

    /**
     * @return
     */
    public String getUserName() {
        LOG.debug("Returning the userName of a user");
        return userName;
    }

    /**
     * @return
     */
    public String getPassword() {
        LOG.debug("Returning the password of a user");
        return password;
    }

    /**
     * @return
     */
    public boolean isAuthorized() {
        LOG.debug("Returning the boolean value of isAuthorized");
        return isAuthorized;
    }
}
