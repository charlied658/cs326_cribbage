package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * An enum representing all possible events. Whenever a new event type is
 * written, its associated title must be included with this enum.
 *
 * @author Alex Carney
 * Reviewed Sten Leinasaar @at March 22, 2022
 * Metadata and code to access it added by Sten Leinasaar @at March 22 2022
 */
public enum EventType {
    /**
     * User Login event.
     */
    USER_LOGIN("User Login Event"),
    /**
     * User Login event with hashed password.
     */
    USER_LOGIN_HASHED("User Login Hashed Event"),
    /**
     * User login event response.
     */
    USER_LOGIN_RESPONSE("User Login Response Event"),
    /**
     * User password change event.
     */
    USER_CHANGE_PASSWORD("User Change Password Event"),
    /**
     * User Create account event.
     */
    USER_CREATE_ACCOUNT("User Create Account Event"),
    /**
     * User delete account. 
     */
    USER_DELETE_ACCOUNT("User Delete Account Event");
    
    /**
     * The name of the event.
     */
    private String name;
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(EventType.class);
    }
    
    
    /**
     * 
     * @param name
     *          The name of the event.
     */
    EventType(String name) {
        this.name = name;
        
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

}



