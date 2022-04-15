package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * user management.
 * 
 * @author
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
     * @return the user.
     */
    boolean userDelete(User userToDelete);

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
     * userCHange.
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

}
