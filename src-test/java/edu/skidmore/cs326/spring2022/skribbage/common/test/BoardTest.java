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
        //HARDCODED FOR 3 PLAYERS.
        testPegs = new Peg[Board.NUMCOL * 2];
    }

    /**
     * Method that tests if grid is returned properly.
     */
    @Test
    public void testGetGrid() {
        LOG.debug("Testing getGrid");
        assertArrayEquals(testInstance.getGrid(), testGrid);

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

    }
    /**
     * This method tests if getSpots returns a correct value.
     */
    @Test
    public void testGetSpots() {

    }
    /**
     * This method tests if AssignPrizeSpot works as intended.
     */
    @Test
    public void testAssignPrizeSpot() {

    }
    /**
     * This method tests assignBattleSpot. 
     */
    @Test
    public void testAssignBattleSpot() {

    }
    /**
     * This method tests assignJumpSpot.
     */
    @Test
    public void testAssignJumpSpot() {

    }

}
