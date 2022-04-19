package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Methods for authenticating a user attempting to log in.
 * 
 * @author Declan Morris
 */
public interface LoginAuthentication {

    /**
     * Determine whether a user's entered password matches what
     * they have in the database.
     * 
     * @param user
     */
    void validateLoginAttempt(User user);

    /**
     * If the user enters the correct original password,
     * change the password to the newPassword.
     * 
     * @param user
     * @param newPassword
     */
    void changePasswordAttempt(User user, Password newPassword);

    /**
     * Create a new user whose data will be stored in database.
     * 
     * @param user
     */
    void createNewUser(User user);

}
