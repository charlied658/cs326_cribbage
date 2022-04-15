package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Simple class for testing the user bean.
 * 
 * @author Alex Carney
 */
public class PasswordTest {

    /**
     * Test instance of password.
     */
    private Password testInstance;

    /**
     * Grab the instance of password hasher to test salting.
     */
    private PasswordHasher passwordHasher;

    /**
     * Test password value.
     */
    private static final String TEST_PASSWORD_VALUE = "test_password";

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserTest.class);
    }

    /**
     * Method to set up testing env.
     */
    @Before
    public void setup() {
        testInstance = new Password(TEST_PASSWORD_VALUE);

        // Grab the password hasher instance
        passwordHasher = PasswordHasher.getInstance();

    }

    /**
     * Tests getting password value.
     */
    @Test
    public void testPasswordValue() {
        assertNotNull(testInstance);
        assertEquals(testInstance.getPasswordValue(), TEST_PASSWORD_VALUE);
    }

    /**
     * Tests resetting password value.
     */
    @Test
    public void testResettingPasswordValue() {
        testInstance.setPasswordValue(TEST_PASSWORD_VALUE
            + TEST_PASSWORD_VALUE);
        assertEquals(testInstance.getPasswordValue(), TEST_PASSWORD_VALUE
            + TEST_PASSWORD_VALUE);
    }

    /**
     * Tests hashing password. (or at least setting isHashed to true)
     */
    @Test
    public void testHashingPassword() {
        testInstance.setHashed(true);
        assertTrue(testInstance.isHashed());
    }

    /**
     * Test adding salted password. Blocked by Logic tier as
     * of 4/14.
     */
    @Test
    public void testAddingSaltedPassword() {
        // TODO: Why is password hasher all protected??
        // testInstance.setSalt();
    }

}
