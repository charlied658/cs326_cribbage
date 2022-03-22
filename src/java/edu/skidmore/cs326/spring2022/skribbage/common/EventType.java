package edu.skidmore.cs326.spring2022.skribbage.common;



/**
 * An enum representing all possible events. Whenever a new event type is
 * written, its associated title must be included with this enum.
 *
 * @author Alex Carney
 * Reviewed Sten Leinasaar @at March 9, 2022
 */
public enum EventType {
    /**
     * User Login event.
     */
    USER_LOGIN("User Login Event"),
    /**
     * User Login event with hashed password.
     */
    USER_LOGIN_HASHED("User Login Hashed"),
    /**
     * User login event response.
     */
    USER_LOGIN_RESPONSE(""),
    /**
     * User password change event.
     */
    USER_CHANGE_PASSWORD(""),
    /**
     * User Create account event.
     */
    USER_CREATE_ACCOUNT(""),
    /**
     * User delete account. 
     */
    USER_DELETE_ACCOUNT("");
    
    
    private EventType(String name) {
        
    }

}



