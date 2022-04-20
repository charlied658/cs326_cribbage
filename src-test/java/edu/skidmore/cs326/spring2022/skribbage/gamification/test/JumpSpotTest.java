package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.gamification.JumpSpot;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * Tests the functionality in the jump spot class.
 * 
 * @author Henry Wilson
 */
public class JumpSpotTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(JumpSpotTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private JumpSpot testInstance;

    /**
     * Player being jumped.
     */
    private Player testPlayer;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new JumpSpot();
        testPlayer = new Player();
    }

    /**
     * Test to ensure all possible outcomes of jump spot are reachable.
     */
    @Test
    public void testJumpSpot() {

        int backTwo = 0;
        int backOne = 0;
        int upZero = 0;
        int upOne = 0;
        int upTwo = 0;
        int upThree = 0;
        int numTests = 0;

        while (numTests < 100) {
            testPlayer.addPoints(2);
            testInstance.jump(testPlayer);
            System.out.println(testPlayer.getPoints());
            assertTrue(
                testPlayer.getPoints() >= 0 && testPlayer.getPoints() <= 5);
            switch (testPlayer.getPoints()) {

                case 0:
                    backTwo++;
                    break;
                case 1:
                    backOne++;
                    break;
                case 2:
                    upZero++;
                case 3:
                    upOne++;
                    break;
                case 4:
                    upTwo++;
                    break;
                case 5:
                    upThree++;
                    break;
                default:
                    LOG.info("Switch failed");
            }
            testPlayer.addPoints(testPlayer.getPoints() * -1);
            numTests++;
        }

        assertTrue(backTwo > 0);
        assertTrue(backOne > 0);
        assertTrue(upZero > 0);
        assertTrue(upOne > 0);
        assertTrue(upTwo > 0);
        assertTrue(upThree > 0);

    }

}
