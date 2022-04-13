package edu.skidmore.cs326.spring2022.skribbage.persistence;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;




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
	 * 
	 * @return
	 */
	public static PersistenceFacade getInstance() {
		return INSTANCE;
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
		
		return true;
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
	 * This will take in a user and the arg of what needs to be change and change it
	 * @param userToChange The user that wants to change something
	 * @param args The thing that they want to change
	 * 
	 * @return boolean depending on whether the method worked or not
	 */
	public boolean userChange(User userToChange, Object... args) {
		
		return true;
	}
	
	
	/**
	 * This will return the saved game of the user that retrieved it
	 * @param userName The name of the user that wants the game
	 * @param whichGame The saved game that is being retrieved
	 * 
	 * @return Game The saved game
	 */
	@Override
	public Game retrieveGame(User userName, Game whichGame) {
		
		
		return whichGame;
	}
	
	/**
	 * This will saved the users current game that they are playing
	 * @param userName The name of the user that we are saving the game
	 * @param currentGame The current game that we are saving
	 * 
	 * @return boolean True or false depending if the method worked
	 */
	@Override
	public boolean saveGame(User userName, Game currentGame) {
		
		return true;
	}
	
	
	
	
	
}
