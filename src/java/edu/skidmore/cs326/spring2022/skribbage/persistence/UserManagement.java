package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * user management interface.
 * 
 * @author Ricardo Rosario
 */
public interface UserManagement {

    /**
     * usercreate.
     * 
     * @param userToCreate
     * @param password
     * @return the user.
     */
    boolean userCreate(User userToCreate, Password password);

    /**
     * userDelete.
     * 
     * @param userToDelete
     * @param password
     * @return the user.
     */
    boolean userDelete(User userToDelete, Password password);

    /**
     * password change.
     * 
     * @param userToUpdate
     * @param currentPassword
     * @param newPassword
     * @return the password.
     */
    boolean passwordChange(User userToUpdate, Password newPassword);

    /**
     * userChange.
     * 
     * @param userToChange
     * @param args
     * @return the user.
     */
    boolean userChange(User userToChange, Object... args);

    /**
     * login.
     * 
     * @param user
     * @param password
     * @return the login.
     */
    Password getPassword(User user);

    /**
     * validate user.
     * 
     * @param user
     * @return the user.
     */
    boolean validateUsername(User user);

    /**
     * Check if the user name exists.
     * 
     * @param user
     *            as a user
     * @return boolean depending if the user name exists
     */
    boolean userNameExists(User user);

    /**
     * Get the user's password Base64-encoded salt.
     * 
     * @param user
     *            The user's whose password salt is to be obtained
     * @return The password salt or null if the user's account is not found
     */
    String getUserSaltBase64(User user);
}
