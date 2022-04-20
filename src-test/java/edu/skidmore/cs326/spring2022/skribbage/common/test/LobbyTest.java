package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * Test class for the lobby java bean.
 * 
 * @author Declan Morris
 */
public class LobbyTest {

    /**
     * Variable to house test instance.
     */
    private Lobby testInstance;

    /**
     * Variable to house extra user to be added to test instance.
     */
    private User user2;

    /**
     * Initialize variables necessary for testing.
     */
    @Before
    public void setup() {
        User host = new User(null, "MrTestUser", null);
        user2 = new User(null, "2ndUser", null);
        testInstance = new Lobby(host);
    }

    /**
     * Test that getUsers() works properly.
     */
    @Test
    public void testGetUsers() {
        assertEquals(1, testInstance.getUsers().length);
        assertEquals("MrTestUser", testInstance.getUsers()[0].getUserName());
    }

    /**
     * Test that addUser() is causing the number
     * of users in test instance lobby to increase.
     */
    @Test
    public void testAddUser() {
        testInstance.addUser(user2);
        assertEquals(2, testInstance.getUsers().length);
    }

}
