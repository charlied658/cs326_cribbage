package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;

/**
 * Singleton class used to
 * Check given login/account creation information, hash passwords,
 * and communicate the info between front end and persistence code.
 *
 * @author Declan Morris
 */
public class LoginAuthenticator implements LoginAuthentication {

    /**
     * Logger instance.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LoginAuthenticator.class);
    }

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

    @Override
    public void loginAttempt(User user, String enteredPassword) {

    }

    @Override
    public void changePasswordAttempt(User user, String newPassword) {

    }

    /**
     * Determine if a given password in string form entered by a user matches
     * what is stored in the database.
     * 
     * @param userToValidate
     * @param inputPassword
     * @return doesPasswordMatch
     */
    public boolean passwordMatches(User userToValidate,
        String inputPassword) {

        Password storedPassword =
            PersistenceFacade.getInstance().getPassword(userToValidate);

        byte[] saltedPasswordBytes =
            PasswordHasher.getInstance().base64Decode(
                storedPassword.getBase64PasswordHash());

        byte[] saltBytes = PasswordHasher.getInstance()
            .base64Decode(storedPassword.getBase64Salt());

        return PasswordHasher.getInstance()
            .doesPasswordMatch(inputPassword,
                saltedPasswordBytes, saltBytes);
    }

    @Override
    public void createNewUser(User user, String password) {

        if (!PersistenceFacade.getInstance().userCreate(user,
            hashNewPassword(password))) {
            LOG.trace("Unable to create new user");
        }
    }

    @Override
    public Password hashNewPassword(String password) {

        String hashedStringPassword =
            PasswordHasher.getInstance().hashNewPassword(password);

        Password newPassword = new Password(hashedStringPassword);

        return newPassword;
    }

    @Override
    public void encodeExistingPassword(Password password) {
        // TODO Auto-generated method stub

    }

}
