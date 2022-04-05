package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;


/**
 * A simple bean representing data associated with a User.
 *
 * TODO (DSR): should isAuthorized be mutable to handle before/after login?
 * TODO (DSR): levels of users (different privileges)?
 * TODO (DSR): manage password separately (not part of general interactions)
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
     * @param email        User's email
     * @param userName     userName of user
     * @param password     Password submitted
     * @param isAuthorized Determines whether or not the user is logged in.
     */
    public User(String email, String userName, String password,
        boolean isAuthorized) {
        this.email = email;
        LOG.debug("Email value set to:" + email);
        this.userName = userName;
        LOG.debug("userName value set to: " + userName);
        this.password = password;
        // TODO (DSR): NEVER LOG PASSWORDS!
        LOG.debug("password value set to: " + password);
        this.isAuthorized = isAuthorized;
        LOG.debug("isAuthorized value was set to: " + isAuthorized);
        LOG.info(
            "The parameters of User constructor were assigned"
                + " to private variable attributes");
    }

    /**
     * @return the user email.
     * TODO (DSR): Avoid unnecessary use of "this"
     */
    public String getEmail() {
        LOG.debug("Returning email of a user");
        return this.email;
    }

    /**
     * @return the user's name
     */
    public String getUserName() {
        LOG.debug("Returning the userName of a user");
        return this.userName;
    }

    /**
     * @return the user password.
     */
    public String getPassword() {
        LOG.debug("Returning the password of a user");
        return this.password;
    }

    /**
     * @return if the user has been authorized.
     */
    public boolean isAuthorized() {
        LOG.debug("Returning the boolean value of isAuthorized");
        return this.isAuthorized;
    }
}
