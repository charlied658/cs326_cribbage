package edu.skidmore.cs326.spring2022.skribbage.logic.events.test;

import org.junit.Before;

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
     * Set up for testing and instantiate test instance.
     */
    @Before
    public void setup() {
        testInstance = new UserLoginResponseEvent(this);
    }

}
