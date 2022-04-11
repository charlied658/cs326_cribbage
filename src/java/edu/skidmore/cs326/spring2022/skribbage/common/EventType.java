package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

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
    USER_LOGIN("User Login Event", User.class),
    /**
     * Fired when.
     */
    USER_LOGIN_HASHED("User Login Hashed Event", User.class),
    /**
     * Fired from logic tier when user's login request has been handled.
     */
    USER_LOGIN_RESPONSE("User Login Response Event",
        User.class, Boolean.class, String.class),
    /**
     * Fired when a user attempts to change their password via login page.
     */
    USER_CHANGE_PASSWORD("User Change Password Event", User.class,
        String.class),
    /**
     * Fired when a user attempts to create an account via login page.
     */
    USER_CREATE_ACCOUNT("User Create Account Event", User.class),
    /**
     * Fired when a user attempts to delete their account.
     */
    USER_DELETE_ACCOUNT("User Delete Account Event"),
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
        LOG.trace("Returning a name of an event");
        return name;
    }

    /**
     * Return the arguments list.
     * 
     * @return The argument list.
     */
    public Object[] getArgumentList() {
        LOG.trace("Returning arguments list of an event");
        return args;
    }

}
