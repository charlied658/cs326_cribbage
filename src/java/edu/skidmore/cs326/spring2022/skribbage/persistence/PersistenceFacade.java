package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;




/**
 * Will contain the methods for an event listener and call the methods in the DatabaseManager
 */
public class PersistenceFacade {
	
	
	/**
	 * Will listen for the events and manage what method is being called
	 * @param eventToHandle the event that is being passed
	 * @param metaData the information that we are going to store
	 * @return if the event was successful or not
	 * 
	 */
    public String EventDBManager(EventType eventToHandle, Object[] metaData) {
        Boolean isSuccess = true;
        switch (eventToHandle) {
            case USER_LOGIN:

                return isSuccess ? "success" : "fail";
            case USER_DELETE_ACCOUNT:
                return isSuccess ? "success" : "fail";
            case USER_CREATE_ACCOUNT:
                return isSuccess ? "success" : "fail";
            case USER_CHANGE_PASSWORD:
                return isSuccess ? "success" : "fail";
            default:
                return "not valid persistence event";
        }

    }
}
