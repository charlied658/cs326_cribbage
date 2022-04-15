package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * @author Sten Leinasaar
 *         Last Edited: March 29, 2022
 */
public class UserTest {
    /**
     * Test instance of type User for testing.
     */
    private User testInstance;
    
    

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserTest.class);
    }

    /**
     * Method to set up testing environment.
     */
    @Before
    public void setup() {
        LOG.trace("Setup method in test class reached.");
        testInstance =
            new User("sleinasa@skidmore.edu", "sleinasa",
                "password", UserRole.AUTHORIZED);
        LOG.trace("Setup finished");
    }

    /**
     * Method to test the constructor of a User class.
     */
    @Test
    public void testUser() {
        LOG.trace("Testing constructor of a User class.");
        assertNotNull(testInstance);
        LOG.trace("Finished testing the user class.");

    }

    /**
     * Testing getEmail method in User class.
     */
    @Test
    public void testGetEmail() {
        LOG.trace("Testing getEmail method in User class.");
        assertEquals(testInstance.getEmail(), "sleinasa@skidmore.edu");
        LOG.trace(" Testing get email finished.");
    }

    /**
     * Testing getUsername method in User class.
     */
    @Test
    public void testGetUserName() {
        LOG.trace("Testing getUsername method in User class.");
        assertEquals(testInstance.getUserName(), "sleinasa");
        LOG.trace("Testing getUserName finished.");
    }

    /**
     * Testing getPassword method in User class.
     */
    @Test
    public void testGetPassword() {
        LOG.trace("Testing getPassword method in User class");
        assertEquals(testInstance.getPassword(), "password");
        LOG.trace("Testing getPassword finished.");
    }

    /**
     * Testing isAuthorized method in User Class.
     */
    @Test
    public void testIsAuthorized() {
        LOG.trace("Testing isAuthorized method in User class.");
        assertEquals(testInstance.getUserRole(), UserRole.AUTHORIZED);
        LOG.trace(" Testing isAuthorized.");
    }


}
