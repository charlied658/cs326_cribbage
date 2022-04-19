package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import java.util.Objects;

/**
 * A simple bean representing data associated with a User.
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
     * @reviewed Alex Carney added final back, it should be immutable
     */
    private final String userName;

    /**
     * Private string attribute to store a userId of a user.
     * 
     * @reviewed Tinaye Mawocha removed keyword final as username may need to
     *           change
     * @reviewed Alex Carney this field is mutable ONLY because this information
     *           is not known when the bean is instantiated
     */
    private int userId;

    /**
     * @return the user's ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Functionality to update user's ID. Should only ever be called once
     * 
     * @param id new role.
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
        LOG.debug("Email value set to:" + email);
        this.userName = userName;
        LOG.debug("userName value set to: " + userName);
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
