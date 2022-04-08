package edu.skidmore.cs326.spring2022.skribbage.common.test;

import org.apache.log4j.Logger;
import org.junit.Before;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;

/**
 * @author sleinasa
 */
public class BoardTest {
    /**
     * Testinstance of Board.
     */
    private Board testInstance;

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
        testInstance = BoardManager.getInstance().getBoard();
    }
}
