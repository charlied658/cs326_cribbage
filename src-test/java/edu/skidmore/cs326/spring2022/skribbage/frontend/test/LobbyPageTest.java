package edu.skidmore.cs326.spring2022.skribbage.frontend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.LobbyPage;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.test.LobbyEventTest;
import us.daveread.edu.utilities.Utility;

/**
 * Tests lobby page add and remove functionality.
 * @author Jonah Marcus
 *      Last Edited 29 April 2022
 */

public class LobbyPageTest {
    
    /**
     * testInstance - Test Instance.
     */
    private LobbyPage testInstance;
    
    /**
     * source - Source to be passed with methods.
     */
    private Object source;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(LobbyEventTest.class);
    }

    /**
     * Setup.
     */
    public void setup() {
        testInstance = new LobbyPage();
    }
    
    /**
     * Unit Test 1.
     */
    public void unitTest1() {
        LOG.trace("Entered LobbyPageTest unitTest1");
        Utility.pause(1000);
        testInstance.addPlayer(new User(null, "Dummy User (Test)", 
            UserRole.AUTHORIZED));
        Utility.pause(1000);
        testInstance.removePlayer(testInstance.getPlayers().get(0));
        Utility.pause(1000);
        testInstance.removePlayer(testInstance.getPlayers().get(0));
        Utility.pause(1000);
        testInstance.removePlayer(testInstance.getPlayers().get(0));
        Utility.pause(1000);
        testInstance.addPlayer(testInstance.getHost());
        Utility.pause(1000);
        testInstance.addPlayer(testInstance.getCPU());
        Utility.pause(1000);
        testInstance.addPlayer(new User(null, "I̴͂͜ ̵̨́L̴̡͋I̴̽͜V̴͔͐E̸͕̾"
            + " ̶͙͒I̴͕͝N̴̨̊ ̸̹͝Y̷̞̿O̴̧̚U̸̖̔R̶͎̋ ̶̩̎W̷̠̎A̷͈͆L̶͚̃L̷̗͆S̸̘̽", 
            UserRole.AUTHORIZED));
    }

}
