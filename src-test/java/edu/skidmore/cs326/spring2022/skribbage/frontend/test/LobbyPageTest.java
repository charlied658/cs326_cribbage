package edu.skidmore.cs326.spring2022.skribbage.frontend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.LobbyPage;


/**
 * Tests lobby page add and remove functionality.
 * 
 * @author Jonah Marcus
 *         Last Edited 29 April 2022
 */

public class LobbyPageTest {

    /**
     * testInstance - Test Instance.
     */
    private LobbyPage testInstance;
    /**
     * List of player being modified. 
     */
    private List<User> playerList;
    /**
     * Private user instance to be added and removed from Lobby.
     */
    private User userInstance;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(LobbyPageTest.class);
    }

    /**
     * Setup.
     */
    @Before
    public void setup() {

        LOG.trace("Entered LobbyPageTest setup");

        LOG.info("Setup for testing");

        testInstance = new LobbyPage();
        playerList = new ArrayList<User>();
        userInstance = new User("s@g.com", "testUser", UserRole.AUTHORIZED);
    }

    /**
     * Method to test if constructor works.
     */
    @Test
    public void testLobbyPage() {
        LOG.info("Constructor testing");
        assertNotNull(testInstance);
        LOG.info("Constructor testing finished.");
    }

    /**
     * Method to test if player is added correctly.
     */
    @Test
    public void testAddPlayer() {
        LOG.info("Testing addPLayers method.");
        assertNull(playerList);

        testInstance
            .addPlayer(userInstance);
        assertNotNull(playerList);
        LOG.info("Add player testing finished");
    }
    /**
     * Method to test removePlayer.
     */
    @Test
    public void testRemovePlayer() {
        LOG.info("Testing removePLayers method.");
        assertNull(playerList);
        
        testInstance
            .addPlayer(userInstance);
        assertNotNull(playerList);
        
        testInstance.removePlayer(userInstance);
        assertNull(playerList);
        LOG.info("Remove player testing finished");
    }


}
