package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponse;

/**
 * An enum representing all possible events. Whenever a new event type is
 * written, its associated title must be included with this enum.
 *
 * @author Alex Carney
 *         Reviewed Sten Leinasaar @at March 22, 2022
 *         Metadata and code to access it added by Sten Leinasaar @at March 22
 *         2022
 */
public enum EventType {

    /**
     * Fired when a user attempts to create an account via login page.
     */
    USER_LOGIN("User Login Event", User.class, Password.class),
    /**
     * Fired when.
     */
    USER_LOGIN_HASHED("User Login Hashed Event", User.class, Password.class),
    /**
     * Fired from logic tier when user's login request has been handled.
     */
    USER_LOGIN_RESPONSE("User Login Response Event",
        User.class, AccountResponse.class),
    /**
     * Fired when a user types in their username.
     */
    USER_VALIDATION_RESPONSE("User Validation Response Event", User.class),
    /**
     * Fired when a user attempts to change their password via login page.
     */
    USER_CHANGE_PASSWORD("User Change Password Event", User.class,
        Password.class),
    /**
     * Fired when user needs to be verified to change password.
     */
    USER_CHANGE_PASSWORD_VALIDATION("User Change Password Validation",
        User.class),
    /**
     * Fired when user is successfully verified for password change.
     */
    USER_CHANGE_PASSWORD_VALIDATION_RESPONSE(
        "User Change Password Validation Response", User.class),
    /**
     * Fired when password change was succesful.
     */
    USER_CHANGE_PASSWORD_RESPONSE("User Change Password Response"),
    /**
     * Fired when a user attempts to create an account via login page.
     */
    USER_CREATE_ACCOUNT("User Create Account Event", User.class,
        Password.class),
    /**
     * Fired when user create account is succesful.
     */
    USER_CREATE_ACCOUNT_RESPONSE("User Create Account Response", User.class),

    /**
     * Fired when a user is attempting to create an account but just enters
     * their username.
     */
    VALIDATE_USERNAME("Validate Username", User.class),

    /**
     * Fired when a user attempts to delete their account.
     */
    USER_DELETE_ACCOUNT("User Delete Account Event", User.class),
    /**
     * Fired when the host of a lobby clicks 'start game', and all players
     * are added to a new game.
     */
    LOBBY_START_GAME("Lobby Start Game Event");

    /**
     * The name of the event.
     */
    private final String name;

    /**
     * Argument list of the event.
     */
    private final Object[] args;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(EventType.class);
    }

    /**
     * @param name
     *            The name of the event.
     * @param args
     *            A var arg of arguments for this event to take.
     */
    EventType(String name, Object... args) {

        this.name = name;
        this.args = args;

    }

    /**
     * Get the name of event.
     * 
     * @return The name of an event.
     */
    public String getName() {
        LOG.debug("Returning a name of an event");
        return name;
    }

    /**
     * Return the arguments list.
     * 
     * @return The argument list.
     */
    public Object[] getArgumentList() {
        LOG.debug("Returning arguments list of an event");
        return args;
    }
    
    

}
