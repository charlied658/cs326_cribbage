package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Manages game board instances. Currently the manager only supports one board.
 * This is a Singleton class. To get an instance of the game board call
 * BoardManager.getInstance().getBoard()
 * 
 * @author readda
 */
public class BoardManager {
    /**
     * The Logger for this class.
     */
    private static final Logger LOG;

    /**
     * The Singleton instance of this class.
     */
    private static final BoardManager INSTANCE;

    /**
     * The key for the board.
     * TODO Replace this with key management for multiple boards
     */
    private static final String BOARDKEY;

    /**
     * The game boards being managed. Currently there is only one.
     */
    private HashMap<String, Board> board;

    /**
     * Create the logger and Singleton BoardManager instances.
     */
    static {
        LOG = Logger.getLogger(BoardManager.class);
        BOARDKEY = "TheBoard";
        INSTANCE = new BoardManager();
    }

    /**
     * Create the manager instance and perform initialization of the board map.
     * Constructor is private to support its Singleton design.
     */
    private BoardManager() {
        LOG.debug("Instance created");

        board = new HashMap<>();
        setup();
    }

    /**
     * Get the Singleton instance of the board manager.
     * 
     * @return The board manager instance
     */
    public static BoardManager getInstance() {
        return INSTANCE;
    }

    /**
     * Initialize board management.
     * TODO For multiple boards, this should only create an empty map
     */
    private void setup() {
        board.put(BOARDKEY, new Board());
    }

    /**
     * Returns the board. Currently there is only one board instance.
     * 
     * @return The board instance
     */
    public Board getBoard() {
        return board.get(BOARDKEY);
    }
}
