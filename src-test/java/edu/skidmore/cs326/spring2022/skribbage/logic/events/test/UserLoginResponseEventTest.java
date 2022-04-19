package edu.skidmore.cs326.spring2022.skribbage.logic.events.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserLoginResponseEvent;

/**
 * Unit tests for UserLoginResponseEventTest.
 * 
 * @author Declan Morris
 */
public class UserLoginResponseEventTest {

    /**
     * Instance for testing.
     */
    private UserLoginResponseEvent testInstance;
    
    /**
     * Logger instance for logging.
     * 
     */
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(UserLoginResponseEventTest.class);
    }

    /**
     * Set up for testing and instantiate test instance.
     */
    @Before
    public void setup() {
        LOG.debug("Setting up");
        testInstance = new UserLoginResponseEvent(this);

    }
    /**
     * 
     */
    @Test
    public void test() {
        assertEquals(EventType.USER_LOGIN_RESPONSE.getName(), 
            testInstance.getEventType());
    }

}
