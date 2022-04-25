package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.*;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.ValidateUsernameEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponse;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Full test of event functionality. Mocks an interaction between
 * a user logging in on the front end, and being authenticated and
 * returned by the back end.
 *
 * @author Alex Carney
 */
public class ValidateUsernameEventLoopTest {
    /**
     * Borrow an instance of event factory for testing.
     */
    private EventFactory testFactoryInstance;

    /**
     * Borrow an instance of event manager for testing.
     */
    private EventManager eventManagerInstance;

    /**
     * Mockup version of AccountController for testing.
     */
    private AccountControllerMOCK accountControllerMOCK;

    /**
     * Mockup version of AccountResponseController for testing.
     */
    private AccountResponseControllerMOCK accountResponseControllerMOCK;

    /**
     * Mock user.
     */
    private User testUser;

    /**
     * Bad user with BAD username.
     */
    private User testBadUser;

    /**
     * Mock username for mock user.
     */
    private static final String TEST_USERNAME = "acarney";

    /**
     * Bad word username.
     */
    private static final String TEST_BAD_USERNAME = "boobs";


    /**
     * Mock login event.
     */
    private ValidateUsernameEvent testEventInstance;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(ValidateUsernameEventLoopTest.class);
    }

    /**
     * Sets up testing environment.
     */
    @Before
    public void setUp() {
        testFactoryInstance = EventFactory.getInstance();
        LOG.trace("test factory instance obtained");
        eventManagerInstance = EventManager.getInstance();
        LOG.trace("test manager instance obtained");
        accountControllerMOCK = new AccountControllerMOCK();
        LOG.trace("test controller mock instance Created");
        accountResponseControllerMOCK = new AccountResponseControllerMOCK();
        LOG.trace("test response controller mock instance Created");
        assertNotNull(accountControllerMOCK);
        assertNotNull(accountResponseControllerMOCK);

        LOG.trace("added account controller mock to listeners");
        eventManagerInstance.addPropertyChangeListener(
            accountControllerMOCK,
            EventType.VALIDATE_USERNAME);
        LOG.trace("added account response controller mock to listeners");
        eventManagerInstance.addPropertyChangeListener(
            accountResponseControllerMOCK,
            EventType.USER_VALIDATION_RESPONSE);

        testUser = new User(null, TEST_USERNAME, UserRole.UNAUTHORIZED);

        testBadUser = new User(null, TEST_BAD_USERNAME, UserRole.UNAUTHORIZED);

        // Actually fire the event
        testEventInstance = (ValidateUsernameEvent) testFactoryInstance
            .createEvent(EventType.VALIDATE_USERNAME, this, testUser);
        assertNotNull(testEventInstance);
        LOG.trace("created event " + testEventInstance);
        testFactoryInstance.fireEvent(testEventInstance);
        LOG.trace("fired said event");

    }

    /**
     * Determines whether the mock controller received the mock event.
     * Additionally, ensures User object is the same
     */
    @Test
    public void testListenerCaughtCorrectUser() {
        User caughtUser = accountControllerMOCK.getReceivedUserFromLogin();
        assertNotNull(caughtUser);
        assertEquals(caughtUser, testUser);
    }

    /**
     * Determines if the response controller catches the Response event
     * correctly.
     */
    @Test
    public void testReceiverCaughtCorrectUser() {
        User caughtUser = accountResponseControllerMOCK.getReceivedUserFromLogin();
        assertNotNull(caughtUser);
        assertEquals(caughtUser, testUser);
    }

    /**
     * Ensure that a proper account response is returned, and that it is false.
     */
    @Test
    public void responseMessageAccepted() {
        AccountResponse accountResponse =
            accountResponseControllerMOCK.getAccountResponseMessage();
        assertFalse(accountResponse.isRejectionStatus());
    }

}
