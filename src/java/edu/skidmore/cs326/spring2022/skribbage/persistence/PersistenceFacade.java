package edu.skidmore.cs326.spring2022.skribbage.persistence;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;




/**
 * Will contain the methods for an event listener and call the methods in the DatabaseManager
 *
 * @author Ricardo Rosario
 * Last Edit: April 10, 2022
 */
public final class PersistenceFacade implements UserManagement, GameManagement{
	
	/**
	 * Singleton instance of PersistenceFacade
	 * Instance can be accessed through PersistenceFacade.getInstatnce()
	 */
	private static final PersistenceFacade INSTANCE;
	
	/**
	 * Logger for the class
	 */
	private static final Logger LOG;
	
	/**
	 * Initializing Logger and the instance of PersistenceFacade
	 */
	static {
		LOG = Logger.getLogger(PersistenceFacade.class);
		INSTANCE = new PersistenceFacade();
	}
	
	/**
	 * This will take in a user and a password and create a new user
	 * @param userToCreate The user that is to be created
	 * @param password The password that is connected to the user being created
	 * 
	 * @return boolean True or False depending if the method worked or failed
	 */
	@Override
	public boolean userCreate(User userToCreate, Password password) {
		
	}
	
	/**
	 * This will take in a user and delete it
	 * @param userToDelete The user that is going to be deleted
	 * 
	 * 
	 * @return boolean Returns true or false 
	 * 		   depending on whether the method worked
	 */
	@Override
	public boolean userDelete(User userToDelete) {
		
		return true;
	}
	
	/**
	 * This will take in a current user, current password and the new password
	 * in order to change passwords
	 * @param userToUpdate This is the user that want to change their password
	 * @param currentPassword This is the current password that they have in their account
	 * @param newPassword This is the new password that they want to change
	 * 
	 * @return boolean true or false depending if the method worked or failed.
	 */
	@Override
	public boolean passwordChange(User userToUpdate, Password currentPassword, Password newPassword) {
		
		return true;
	}
	
	
	/**
	 * 
	 * @param whichGame
	 * 
	 * @return
	 */
	public Game retrieveGame(Game whichGame);
	
	
	
	
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
