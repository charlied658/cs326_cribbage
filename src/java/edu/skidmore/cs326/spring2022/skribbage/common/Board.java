package edu.skidmore.cs326.spring2022.skribbage.common;

import java.awt.Point;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.impl.Image;

/**
 * @author Sten Leinasaar
 */
public class Board {
    /**
     * Singleton instance of a board.
     */
    private static final Board INSTANCE;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    /**
     * Board image attribute.
     */
    private Image board;

    /**
     * Array of pegs.
     */
    // private Peg[] pegs;

    private Spot[] grid;

    static {
        LOG = Logger.getLogger(Board.class);
        INSTANCE = new Board();
    }

    /**
     * Private Constructor to ensure Singleton patter.
     */
    private Board() {
        LOG.info("Constructor of a Board class reached.");
        board = new Image("board.png", new Point(0, 0), null);

    }

    /**
     * This method returns a singleton instance of a Board.
     * Enables different layers to edit and work with the same board.
     * 
     * @return Instance of type Board.
     */
    public static synchronized Board getInstance() {
        LOG.trace("Returning an instance of Board.");
        return INSTANCE;
    }

    /**
     * @return grid consisting of spots.
     */
    public Spot[] getGrid() {
        LOG.trace("Returning a grid as an array of spots.");
        return grid;

    }

    // public Peg[] getPegs() {
    //
    // }

    /**
     * This method checks the game grid and returns the positions with pegs.
     * 
     * @return An array of occupied spots of type Spot
     */
    public Spot[] getOccupiedSpots() {
        LOG.trace("Returning occupied spots as an array of spots.");
        return null;
        //
    }

    // public Peg getSpot(Peg p) {
    //
    // }

    /**
     * This method assigns a random spot to be a prize spot and returns the grid
     * location of that spot. The type of that spot will be changed to PRIZE.
     * 
     * @return a priceSpot location of type spot.
     */
    public Spot assignPrizeSpot() {
        LOG.trace("Returning a location of a prizeSpot.");
        return null;

    }

    /**
     * This method assigns random 8 spots to be a battle spot and returns the
     * grid location of that spot. The type of that spot will be changed to
     * BATTLE.
     * 
     * @return a battleSpot location of type spot.
     */
    public Spot[] assignBattleSpot() {
        LOG.trace(
            "Returning a location of a battleSpots as an array of spots.");
        return null;

    }

    /**
     * This method assigns a random spot to be a jump spot and returns the grid
     * location of that spot. The type of that spot will be change to JUMP.
     * 
     * @return a jumpSpot location of type spot.
     */
    public Spot assignJumpSpot() {
        LOG.trace("Returning a location of a jumpSpot.");
        return null;

    }

}
