package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import java.util.Objects;

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
     * 
     * @reviewed Tinaye Mawocha removed keyword final as username may need to
     *           change
     */
    private String userName;

    /**
     * Private string attribute to store a userId of a user.
     * 
     * @reviewed Tinaye Mawocha removed keyword final as username may need to
     *           change
     */
    private int userId;

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
        this.userId = id;
    }

    /**
     * Password.
     */
    private final Password password;

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
     * @param password
     *            Password submitted
     * @param userRole
     *            Determines whether or not the user is logged in.
     * @see UserRole
     */
    public User(String email, String userName, Password password,
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
    public Password getPassword() {
        LOG.debug("Returning the password of a user");
        return password;
    }

    /**
     * @return The authorization status of this user.
     */
    public UserRole getUserRole() {
        LOG.debug("Returning a user role");
        return userRole;
    }

    /**
     * setUserName method.
     * 
     * @param username
     *            to set.
     */
    public void setUserName(String username) {
        this.userName = username;
    }

    /**
     * Functionality to update user's permission level.
     * 
     * @param userRole
     *            new role.
     */
    public void setUserRole(
        UserRole userRole) {
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
        return Objects.hash(email, userName);
    }

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\''
            + ", userName='" + userName + '\''
            + ", userRole=" + userRole
            + '}';
    }
}
