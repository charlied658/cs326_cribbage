package edu.skidmore.cs326.spring2022.skribbage.common;

import java.awt.Point;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import us.daveread.edu.graphics.shape.impl.Image;

/**
 * @author Sten Leinasaar
 */
public class Board {
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
    private Peg[] pegs;

    /**
     * An Array of spots that form a grid.
     */
    private Spot[][] grid;

    /**
     * Constant number of rows.
     */
    public static final Integer NUMROWS;

    /**
     * PLACEHOLDER VALUE.
     */
    public static final Integer NUMCOL;

    static {
        LOG = Logger.getLogger(Board.class);
        NUMROWS = 100;
        NUMCOL = 5;
    }

    /**
     * Package-level constructor. BoardManager should manage creation of
     * instances.
     */
    public Board() {
        LOG.debug("Instance created");
        board = new Image("board.png", new Point(0, 0), null);
        /**
         * @TODO If game calls board and passes itself, the column number could
         *       be easily retrieved. as Shows.
         */
        // NUMCOL = p.getPlayerList().size();
        grid = new Spot[NUMROWS][NUMCOL];
        // each player has two pegs.
        pegs = new Peg[NUMCOL * 2];

    }

    /**
     * @return grid consisting of spots.
     */
    public Spot[][] getGrid() {
        LOG.debug("Grid-array of spot-returned");
        return grid;

    }

    /**
     * @return An array of pegs.
     */
    public Peg[] getPegs() {
        return pegs;
    }

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

    /**
     * Method to find a spot of a specified peg.
     * 
     * @param p
     *            specified peg.
     * @return a spot of that specified peg.
     */
    public Spot getSpot(Peg p) {
        return p.getSpot();
    }

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
