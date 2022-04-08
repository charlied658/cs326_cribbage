package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;

/**
 * Test the BoardManager.
 * 
 * @author readda
 */
public class BoardManagerTest {
    /**
     * Verify instance is created and returned.
     */
    @Test
    public void testGetInstanceNotNull() {
        BoardManager mgr = BoardManager.getInstance();
        assertNotNull("BoardManager is null", mgr);
    }

    /**
     * Verify that the getInstance() method is returning the same object with
     * each call.
     */
    @Test
    public void testGetInstanceIsSingleton() {
        BoardManager mgr = BoardManager.getInstance();
        BoardManager mgr2 = BoardManager.getInstance();
        assertTrue("BoardManager Instances differ, not a Singleton",
            mgr == mgr2);
    }

    /**
     * Verify that the BoardManager is creating and returning a board object.
     */
    @Test
    public void testGetBoardNotNull() {
        Board b = BoardManager.getInstance().getBoard();
        assertNotNull("Board from BoardManager is null", b);
    }

    /**
     * Verify there is only one board.
     * TODO This test will be replaced when multiple boards are supported.
     */
    @Test
    public void testGetBoardSameInstance() {
        Board b = BoardManager.getInstance().getBoard();
        Board b2 = BoardManager.getInstance().getBoard();

        assertTrue("Board instances differ, not retuirning the same board",
            b == b2);

    }
}
