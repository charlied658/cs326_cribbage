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
    boolean passwordChange(User userToUpdate, Password currentPassword,
        Password newPassword);

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
    boolean login(User user, Password password);

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
}
