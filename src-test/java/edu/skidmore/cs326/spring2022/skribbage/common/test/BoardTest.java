package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import edu.skidmore.cs326.spring2022.skribbage.common.Peg;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;
import edu.skidmore.cs326.spring2022.skribbage.gamification.BattleSpot;
import edu.skidmore.cs326.spring2022.skribbage.gamification.JumpSpot;

/**
 * @author sleinasa
 *         Last edited by: Henry Wilson
 */
public class BoardTest {
    /**
     * Testinstance of Board.
     */
    private Board testInstance;

    /**
     * Test grid.
     */
    private Spot[][] testGrid;

    /**
     * Test array of occupied spots.
     */
    private Spot[] occupiedSpots;

    /**
     * Test array of pegs.
     */
    private Peg[] testPegs;

    /**
     * Test instance of player.
     */
    private Player testPlayerOne;

    /**
     * Second test instance of player.
     */
    private Player testPlayerTwo;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(BoardTest.class);
    }

    /**
     * Setup method for Board testing.
     */
    @Before
    public void setUp() {
        LOG.debug("Board setup");
        testInstance = BoardManager.getInstance().getBoard();
        testGrid = new Spot[Board.NUMROWS][Board.NUMCOL];

        // HARDCODED FOR 3 PLAYERS.
        testPegs = new Peg[Board.NUMCOL * 2];
        testPegs[0] = new Peg(testGrid[1][0]);
        testPegs[1] = new Peg(testGrid[1][1]);
        // TODO needs to be changed.
        occupiedSpots = new Spot[10];
        testPlayerOne = new Player();
        testPlayerTwo = new Player();
        testPegs[0].setOwner(testPlayerOne);
        testPegs[1].setOwner(testPlayerTwo);

    }

    /**
     * Method that tests if grid is returned properly.
     */
    @Test
    public void testGetGrid() {
        testInstance.initializeGrid();

        LOG.debug("Testing getGrid");
        assertArrayEquals("Grid is not returned properly",
            testInstance.getGrid(), testGrid);

    }

    /**
     * This method tests if getPegs method is working as intended.
     */
    @Test
    public void testGetPegs() {
        LOG.debug("Testing getPeg");
        assertArrayEquals(testInstance.getPegs(), testPegs);
    }

    /**
     * This method tests if getOccupiedSpots returns a correct value.
     */
    @Test
    public void testGetOccupiedSpots() {
        LOG.debug("Testing getOccupiedSpots.");
        assertArrayEquals(testInstance.getOccupiedSpots(), occupiedSpots);
    }

    /**
     * This method tests if getSpots returns a correct value.
     */
    @Test
    public void testGetSpots() {
        LOG.debug("Test getSpots.");

    }

    /**
     * This method tests if AssignPrizeSpot works as intended.
     */
    @Test
    public void testAssignPrizeSpot() {
        LOG.debug(" Testing assignprizeSpot.");
        for (int i = 0; i < 5; i++) {
            assertEquals(SpotType.PRIZE,
                testInstance.assignPrizeSpot().getType());
        }
        int prizeSpotCounter = 0;
        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < 3; j++) {
                if (testInstance.getGrid()[i][j].getType() == SpotType.PRIZE) {
                    prizeSpotCounter++;
                }
            }

        }
        assertEquals(prizeSpotCounter, 5);

    }

    /**
     * This method tests assignBattleSpot.
     */
    @Test
    public void testAssignBattleSpot() {
        LOG.debug("Testing assignBattleSpot.");
        Spot[] battleSpots = testInstance.assignBattleSpot();
        int battleSpotCounter = 0;
        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < 3; j++) {
                if (testInstance.getGrid()[i][j].getType() == SpotType.BATTLE) {
                    battleSpotCounter++;
                }
            }

        }
        assertEquals(battleSpotCounter, 24);

    }

    /**
     * This method tests assignJumpSpot.
     */
    @Test
    public void testAssignJumpSpot() {
        LOG.debug(" Testing assignJumpSpot.");
        for (int i = 0; i < 5; i++) {
            assertEquals(SpotType.JUMP,
                testInstance.assignJumpSpot().getType());
        }
        int jumpSpotCounter = 0;
        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < 3; j++) {
                if (testInstance.getGrid()[i][j].getType() == SpotType.JUMP) {
                    jumpSpotCounter++;
                }
            }

        }
        assertEquals(jumpSpotCounter, 5);

    }

    /**
     * Tests landing on a battle spot.
     */
    @Test
    public void testLandsOnBattleSpot() {
        
        Location spotLocation = new Location(1, 1);
        Spot battleSpot = (Spot) new BattleSpot(spotLocation);
        testPegs[0].setSpot(battleSpot);
        testPegs[1].setSpot(battleSpot);
        testInstance.landsOnBattleSpot(testPegs[0], testPegs[1]);
        assertTrue(testPegs[0].getOwner().getPoints() != 0
            || testPegs[1].getOwner().getPoints() != 0);
        

    }
    
    /**
     * Tests landing on a battle spot.
     */
    @Test
    public void testLandsOnJumpSpot() {
        
        Location spotLocation = new Location(1, 1);
        Spot jumpSpot = (Spot) new JumpSpot(spotLocation);
        testPegs[0].setSpot(jumpSpot);
        testInstance.landsOnJumpSpot(testPegs[0]);
        assertTrue(testPegs[0].getOwner().getPoints() != 0);
        

    }

}
