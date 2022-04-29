package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.HashMap;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * The Facade will have the methods that require communication with the
 * database. It will call methods in the DatabaseManager class to communicate
 * with the database.
 *
 * @author Ricardo Rosario Last Edit: April 10, 2022
 */

public final class PersistenceFacade
    implements UserManagement , GameManagement , InventoryManagement {

    /**
     * Singleton instance of PersistenceFacade. Instance can be accessed through
     * PersistenceFacade.getInstatnce()
     */
    private static final PersistenceFacade INSTANCE;

    /**
     * Logger for the class.
     */
    @SuppressWarnings("unused")
    private static final Logger LOG;

    /**
     * proxy.
     */
    private static final UsernameProxy PROXY;

    /**
     * dm.
     */
    private static final DatabaseManager DM;

    /**
     * Initializing Logger and the instance of PersistenceFacade
     */
    static {
        LOG = Logger.getLogger(PersistenceFacade.class);
        INSTANCE = new PersistenceFacade();
        PROXY = new UsernameProxy();
        DM = new DatabaseManager();
    }

    /**
     * getInstance.
     * 
     * @return the instance.
     */
    public static PersistenceFacade getInstance() {
        return INSTANCE;
    }

    /**
     * This will take in a user and a password and create a new user.
     *
     * @param userToCreate
     *            The user that is to be created
     * @param password
     *            The password that is connected to the user being created
     * @return boolean True or False depending if the method worked or failed
     */
    @Override
    public boolean userCreate(User userToCreate, Password password) {
        String username = userToCreate.getUserName();
        String passwordtemp = password.getBase64SaltAndPasswordHash();

        DM.createUser(username, passwordtemp);

        return userNameExists(userToCreate);
    }

    /**
     * This will take in a user and delete it.
     * 
     * @param userToDelete
     *            The user that is going to be deleted
     * @return boolean Returns true or false depending on whether the method
     *         worked
     */
    @Override
    public boolean userDelete(User userToDelete, Password password) {

        DM.deleteUser(userToDelete.getUserName(),
            password.getBase64PasswordHash());
        return true;
    }

    /**
     * This will take in a current user, current password and the new password
     * in
     * order to change passwords.
     * 
     * @param userToUpdate
     *            This is the user that want to change their password
     * @param newPassword
     *            This is the new password that they want to change
     * @return boolean true or false depending if the method worked or failed.
     */
    @Override
    public boolean passwordChange(User userToUpdate, Password newPassword) {

        DM.changepass(userToUpdate.getUserName(),
            newPassword.getBase64SaltAndPasswordHash());

        String pass = getPassword(userToUpdate).getBase64SaltAndPasswordHash();

        if (pass.equals(newPassword.getBase64SaltAndPasswordHash())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This will take in a user and the arg of what needs to be change and
     * change
     * it.
     * 
     * @param userToChange
     *            The user that wants to change something
     * @param args
     *            The thing that they want to change
     * @return boolean depending on whether the method worked or not
     */
    public boolean userChange(User userToChange, Object... args) {

        return true;
    }

    /**
     * This will return the saved game of the user that retrieved it.
     * 
     * @param userName
     *            The name of the user that wants the game
     * @param whichGame
     *            The saved game that is being retrieved
     * @return Game The saved game
     */
    @Override
    public Game retrieveGame(User userName, Game whichGame) {

        return whichGame;
    }

    /**
     * This will saved the users current game that they are playing.
     * 
     * @param userName
     *            The name of the user that we are saving the game
     * @param currentGame
     *            The current game that we are saving
     * @return boolean True or false depending if the method worked
     */
    @Override
    public boolean saveGame(Game currentGame) {
        return true;
    }

    @Override
    public boolean validateUsername(User user) {
        String username = user.getUserName();

        // username is inappropriate
        if (!PROXY.usernameCheck(username)) {
            LOG.error("Password contains inappropriate words");
        }
        return PROXY.usernameCheck(username);
    }

    /**
     * Obtain the password of a user.
     * 
     * @param user
     *            the user whose password we want to retrieve
     * @return Password the password of the user we selected
     */
    @Override
    public Password getPassword(User user) {

        if (DM.getPassword(user) == null) {
            return null;
        } else {
            Password accepted = DM.getPassword(user);
            return accepted;
        }

    }

    /**
     * This checks the database to see if the user name exists already.
     * 
     * @param user
     * @return boolean depending if the user name already exists
     */
    public boolean userNameExists(User user) {

        boolean doesExist = DM.accountExists(user.getUserName());

        return doesExist;
    }

    @Override
    public HashMap<String, Item> displayInventory(User user) {

        HashMap<String, Item> tempMap = DM.inventoryQuery(user.getUserId());
        System.out.println(tempMap.toString());
        return tempMap;
    }

    @Override
    public String displayWallet(User user) {

        return DM.walletQuery(user.getUserId());
    }

    @Override
    public boolean addItem(User user, String item, int quantity) {
        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public boolean removeItem(User user, String item, int quantity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean transferItem(User sender, User recipient, String item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getUserSaltBase64(User user) {
        return DM.getUserSaltBase64(user.getUserName());
    }

}
