package edu.skidmore.cs326.spring2022.skribbage.frontend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.LoginPage;
import edu.skidmore.cs326.spring2022.skribbage.frontend.PageManager;
import edu.skidmore.cs326.spring2022.skribbage.frontend.PageType;

/**
 * Test PageManager.
 * 
 * @author Sten Leinasaar
 */
public class PageManagerTest {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    /**
     * Testinstance to test.
     */
    private PageManager testInstance;

    /**
     * User instance to play with.
     */
    private User userInstance;
    /**
     * LoginPage instance.
     */
    private LoginPage logPage;

    /**
     * Create the Logger.
     */
    static {
        LOG = Logger.getLogger(PageManagerTest.class);
    }

    /**
     * Setup for testing.
     */
    @Before
    public void setup() {
        testInstance = PageManager.getInstance();
        userInstance =
            new User("slei@gmail.com", "sleinasa", UserRole.AUTHORIZED);
    }

    /**
     * Verify instance is created and returned.
     */
    @Test
    public void testGetInstance() {
        LOG.debug("Running test");
        assertEquals(PageManager.getInstance(), testInstance);
    }

    /**
     * Verify that the getInstance() method is returning the same object with
     * each call.
     */
    @Test
    public void testGetLoggedInUser() {
        LOG.debug("Running test");
        testInstance.setLoggedInUser(userInstance);
        assertEquals(testInstance.getLoggedInUser(), userInstance);
        testInstance.setLoggedInUser(null);
        LOG.debug("Test completed");
    }

    /**
     * Verify that the BoardManager is creating and returning a board object.
     */
    @Test
    public void testSetLoggedInUser() {
        LOG.debug("Running test");
        assertNull(testInstance.getLoggedInUser());

    }

    /**
     * Verify there is only one board.
     * TODO This test will be replaced when multiple boards are supported.
     */
    @Test
    public void testCreatePage() {
        LOG.debug("Running test");
        logPage = (LoginPage) testInstance.createPage(PageType.LOGIN_PAGE);
        assertNotNull(logPage);
    }
}
