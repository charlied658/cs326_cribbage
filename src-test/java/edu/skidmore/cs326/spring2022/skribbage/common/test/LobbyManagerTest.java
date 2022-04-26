package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.LobbyManager;

/**
 * Unit tests for LobbyManager class.
 * 
 * @author Declan Morris
 */
public class LobbyManagerTest {
    
    /**
     * Reference to LobbyManager instance used for testing.
     */
    private LobbyManager testInstance;
    
    /**
     * Initialize variables for testing.
     */
    @Before
    private void setup() {
        testInstance = LobbyManager.getInstance();
    }
    
    /**
     * Test that getInstance initialized the instance from null.
     */
    @Test
    private void testGetInstance() {
        assertNotNull(testInstance);
    }

}
