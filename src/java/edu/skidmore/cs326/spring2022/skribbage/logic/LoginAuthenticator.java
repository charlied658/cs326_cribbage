package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * Singleton class used to
 * Check given login/account creation information, hash passwords,
 * and communicate the info between front end and persistence code.
 *
 * @author Declan Morris
 */
public class LoginAuthenticator {

    /**
     * The only instance of this class that should ever exist.
     */
    private static LoginAuthenticator instance = null;

    /**
     * Only constructor should be private and only accessed when the
     * instance object is first created.
     */
    private LoginAuthenticator() {

    }

    /**
     * Get method for the singleton instance. Populates instance variable
     * if it has not been populated already (should only happen once)
     *
     * @return returns the instance
     */
    public static LoginAuthenticator getInstance() {
        if (instance == null) {
            instance = new LoginAuthenticator();
        }
        return instance;
    }

    /**
     * Hashes a new password when a new account is created.
     * 
     * @param newPassword
     *            The requested password to be set to the user.
     * @return
     *         The hashed password.
     */
    public String hashNewPassword(String newPassword) {
        return PasswordHasher.getInstance().hashNewPassword(newPassword);
    }
    
    /**
     * 
     * @param user
     * @param attemptedPassword
     * @return
     */
    public boolean checkPassword(User user, String attemptedPassword) {
        return true;
    }

}
