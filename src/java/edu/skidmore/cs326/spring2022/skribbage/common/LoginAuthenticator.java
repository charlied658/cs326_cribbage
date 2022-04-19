package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Singleton class used to
 * Check given login/account creation information, hash passwords,
 * and communicate the info between front end and persistence code.
 *
 * @author Declan Morris
 */
public class LoginAuthenticator implements LoginAuthentication {

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
    public void validateLoginAttempt(User user) {

    }

    @Override
    public void changePasswordAttempt(User user, Password newPassword) {

    }

    @Override
    public void createNewUser(User user) {

    }

    @Override
    public Password hashNewPassword(String password) {

        String hashedString = PasswordHasher.getInstance().hashNewPassword(
            password);

        String[] stringArray = hashedString.split(
            PasswordHasher.getInstance().SALT_AND_PASSWORD_BASE64_SEPARATOR);

        Password newPassword = new Password(stringArray[1]);
        newPassword.setSalt(stringArray[0]);

        return newPassword;

    }

    @Override
    public void encodeExistingPassword(Password password) {
        // TODO Auto-generated method stub

    }

}
