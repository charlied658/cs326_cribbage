package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.BattleSpot;
import edu.skidmore.cs326.spring2022.skribbage.logic.Player;

/**
 * Tests the battle spot class.
 * 
 * @author Henry Wilson
 */
public class BattleSpotTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(BattleSpotTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private BattleSpot testInstance;

    /**
     * The first player.
     */
    private Player p1;

    /**
     * The second player.
     */
    private Player p2;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new BattleSpot();
        p1 = new Player();
        p2 = new Player();
    }

    /**
     * 
     */
    @Test
    public void testDecideWinner() {

        int playerOneWins = 0;
        int playerTwoWins = 0;

        int loserBackThree = 0;
        int loserBackTwo = 0;
        int loserBackOne = 0;
        int winnerUpOne = 0;
        int winnerUpTwo = 0;
        int winnerUpThree = 0;

        int numTests = 0;

        while (numTests < 100) {
            p1.addPoints(3);
            p2.addPoints(3);
            testInstance.decideWinner(p1, p2);
            if (p1.getPoints() > 3) {
                assertTrue(p2.getPoints() == 3);
                assertTrue(p1.getPoints() > 3 && p1.getPoints() < 7);
                playerOneWins++;
                switch (p1.getPoints()) {

                    case 4:
                        winnerUpOne++;
                        break;
                    case 5:
                        winnerUpTwo++;
                        break;
                    case 6:
                        winnerUpThree++;
                        break;
                    default:
                        LOG.info("switch statement failed.");
                }
            }
            if (p1.getPoints() == 3) {
                assertTrue(p2.getPoints() != 3);
                if (p2.getPoints() > 3) {
                    assertTrue(p1.getPoints() == 3);
                    assertTrue(p2.getPoints() > 3 && p1.getPoints() < 7);
                    playerTwoWins++;
                    switch (p2.getPoints()) {

                        case 4:
                            winnerUpOne++;
                            break;
                        case 5:
                            winnerUpTwo++;
                            break;
                        case 6:
                            winnerUpThree++;
                            break;
                        default:
                            LOG.info("switch statement failed.");
                    }
                } else {
                    assertTrue(p2.getPoints() >= 0);
                    playerOneWins++;
                    switch (p2.getPoints()) {

                        case 2:
                            loserBackOne++;
                            break;
                        case 1:
                            loserBackTwo++;
                            break;
                        case 0:
                            loserBackThree++;
                            break;
                        default:
                            LOG.info("switch statement failed.");
                    }
                }
            }
            if (p1.getPoints() < 3) {
                assertTrue(p2.getPoints() == 3);
                assertTrue(p1.getPoints() >= 0);
                playerTwoWins++;
                switch (p1.getPoints()) {

                    case 2:
                        loserBackOne++;
                        break;
                    case 1:
                        loserBackTwo++;
                        break;
                    case 0:
                        loserBackThree++;
                        break;
                    default:
                        LOG.info("switch statement failed.");
                }
            }
            p1.addPoints(p1.getPoints() * -1);
            p2.addPoints(p2.getPoints() * -1);
            numTests++;
            System.out.println(numTests);
        }

        assertTrue(playerOneWins > 0);
        assertTrue(playerTwoWins > 0);
        assertTrue(winnerUpOne > 0);
        assertTrue(winnerUpTwo > 0);
        assertTrue(winnerUpThree > 0);
        assertTrue(loserBackOne > 0);
        assertTrue(loserBackTwo > 0);
        assertTrue(loserBackThree > 0);

    }

}
