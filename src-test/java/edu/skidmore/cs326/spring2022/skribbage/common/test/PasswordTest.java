package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
     * Method to set up testing env
     */
    @Before
    public void setup() {
        testInstance = new Password(TEST_PASSWORD_VALUE);

        //Grab the password hasher instance
        passwordHasher = PasswordHasher.getInstance();

    }

    @Test
    public void testPasswordValue() {
        assertNotNull(testInstance);
        assertEquals(testInstance.getPasswordValue(), TEST_PASSWORD_VALUE);
    }

    @Test
    public void testResettingPasswordValue() {
        testInstance.setPasswordValue(TEST_PASSWORD_VALUE + TEST_PASSWORD_VALUE);
        assertEquals(testInstance.getPasswordValue(), TEST_PASSWORD_VALUE + TEST_PASSWORD_VALUE);
    }

    @Test
    public void testHashingPassword() {
        testInstance.setHashed(true);
        assertTrue(testInstance.isHashed());
    }

    @Test
    public void testAddingSaltedPassword() {
        //TODO: Why is password hasher all protected??
//        testInstance.setSalt();
    }




}
