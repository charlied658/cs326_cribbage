package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Peg;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;

/**
 * @author sleinasa
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
        // TODO needs to be changed.
        occupiedSpots = new Spot[10];
    }

    /**
     * Method that tests if grid is returned properly.
     */
    @Test
    public void testGetGrid() {
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

}