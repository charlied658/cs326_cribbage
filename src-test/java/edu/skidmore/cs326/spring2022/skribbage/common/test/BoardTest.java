package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import us.daveread.edu.graphics.shape.impl.Image;

/**
 * @author sleinasa
 */
public class BoardTest {
    /**
     * Testinstance of Board.
     */
    private Board testInstance;
    /**
     * Image of a board.
     */
    private Image board;

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
        LOG.trace("Beginning a setup in BoardTest.");
        testInstance = Board.getInstance();
        // Must be edited when board image changes.
        board = new Image("board.png", new Point(0, 0), null);

    }

    /**
     * Method to test singleton pattern implemented in Board.
     */
    @Test
    public void testGetInstance() {
        LOG.trace("Beginning testGetInstance in Board.");
        assertEquals(testInstance, Board.getInstance());
        LOG.trace("testGetInstance finished.");
        
    }
    
    

}
