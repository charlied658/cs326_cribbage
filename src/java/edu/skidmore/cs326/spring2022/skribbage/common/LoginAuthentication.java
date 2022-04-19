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
     * @param enteredPassword
     */
    void loginAttempt(User user, String enteredPassword);

    /**
     * If the user enters the correct original password,
     * change the password to the newPassword.
     * 
     * @param user
     * @param newPassword
     */
    void changePasswordAttempt(User user, String newPassword);

    /**
     * Creates a new user whose data will be stored in database.
     * Calls hashNewPassword on password entered before passing to database.
     * 
     * @param user
     * @param password
     */
    void createNewUser(User user, String password);
    
    /**
     * Generate random salt for a previously unhashed password & hash it.
     * @param password
     * @return hashedPassword
     */
    Password hashNewPassword(String password);
    
    /**
     * Use PasswordHasher to encode a password.
     * @param password
     */
    void encodeExistingPassword(Password password);

}
