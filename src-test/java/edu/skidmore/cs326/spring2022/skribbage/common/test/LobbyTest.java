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
     * Hardcoded id assigned to Lobby for testing.
     */
    private int lobbyId;

    /**
     * Initialize variables necessary for testing.
     */
    @Before
    public void setup() {
        User host = new User(null, "MrTestUser", null);
        user2 = new User(null, "2ndUser", null);
        lobbyId = 3;
        testInstance = new Lobby(host, lobbyId);
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
        assertEquals("2ndUser", testInstance.getUsers()[1]);
    }

    /**
     * Test that host was set properly in constructor and
     * that getHost() is returning correct value.
     */
    @Test
    public void testGetHost() {
        assertEquals("MrTestUser", testInstance.getHost().getUserName());
    }

    /**
     * Test that id was set properly in constructor and
     * that getId() is returning correct value.
     */
    @Test
    public void testGetId() {
        assertEquals(3, testInstance.getId());
    }

}
