package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * Unit tests for methods in LoginAuthenticator.
 * NOTE: assumes everything in PasswordHasher is working properly
 * (to do: write unit tests for PasswordHasher)
 * 
 * @author Declan Morris
 */
public class LoginAuthenticatorTest {

    /**
     * Attribute to reference the LoginAuthenticator singleton.
     */
    private LoginAuthenticator testInstance;

    /**
     * Dummy user used for testing.
     */
    @SuppressWarnings("unused")
    private User testUser;

    /**
     * Password mocking the one passed in from Persistence when requesting the
     * stored password of a user (is hashed and salted).
     */
    private Password mockStoredPassword;

    /**
     * String entered by user creating new password.
     */
    private String mockOriginalPassword;

    /**
     * String containing correct password entered by a user attempting to log
     * in.
     */
    @SuppressWarnings("unused")
    private String mockEnteredCorrectPassword;

    /**
     * String containing incorrect password entered by a user attempting to log
     * in.
     */
    @SuppressWarnings("unused")
    private String mockEnteredIncorrectPassword;

    /**
     * Initialize attributes for testing.
     */
    @Before
    public void setup() {
        testInstance = LoginAuthenticator.getInstance();
        testUser = new User(null, "testUsername", null);
        mockStoredPassword = null;
        mockOriginalPassword = "password";
        mockEnteredCorrectPassword = "password";
        mockEnteredIncorrectPassword = "notPassword";
    }

    /**
     * Determines that hashNewPassword successfully populates attributes of new
     * password object.
     */
    @Test
    public void testHashNewPassword() {
        mockStoredPassword = testInstance.hashNewPassword(mockOriginalPassword);
        assertNotEquals(mockStoredPassword.getBase64SaltAndPasswordHash(),
            null);
    }

    /**
     * Determines that passwordMatches returns true when passed a password that
     * matches the mock password and false when passed an incorrect password.
     */
    @Test
    public void testPasswordMatches() {
        
    }
}
