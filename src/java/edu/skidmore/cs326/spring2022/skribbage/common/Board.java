package edu.skidmore.cs326.spring2022.skribbage.common;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.gamification.BattleSpot;
import edu.skidmore.cs326.spring2022.skribbage.gamification.JumpSpot;
import edu.skidmore.cs326.spring2022.skribbage.gamification.PrizeSpot;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import us.daveread.edu.graphics.shape.impl.Image;

/**
 * @author Sten Leinasaar
 *         Code reviewed by Jonah Marcus on April 11, 2022.
 *         Comment by Jonah:
 *         "Commented out an import that was causing an error for some reason."
 *         Last edited by Henry Wilson.
 */
public class Board {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    /**
     * Board image attribute.
     */
    @SuppressWarnings("unused")
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
     * Random number generator for spot generation.
     */
    private Random rand = new Random();

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
        NUMROWS = 120;
        NUMCOL = 3;
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
        // System.out.println("Creating new grid of size ["
        // + NUMROWS + "][" + NUMCOL + "]");
        grid = new Spot[NUMROWS][NUMCOL];
        // each player has two pegs.
        pegs = new Peg[NUMCOL * 2];

        initializeGrid();
        // TODO, the grid has to be populated with pegs and spots.
        // TODO separate method?

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
        LOG.debug("Returning an array of pegs.");
        return pegs;
    }

    /**
     * This method checks the game grid and returns the positions with pegs.
     * 
     * @return An array of occupied spots of type Spot
     */
    public Spot[] getOccupiedSpots() {
        LOG.trace("Returning occupied spots as an array of spots.");
        // if peg location is equal to spot location, then it is occupied.
        // Each peg is a column. assuming that Peg[0] is the first column in
        // grid.
        List<Spot> occupied = new ArrayList<Spot>();
        for (Peg peg : pegs) {
            for (int i = 0; i < NUMROWS; i++) {
                // if the location of a spot in the
                // column of that peg, for any row is equal
                // to the location of the peg we are looking,
                // then it is occupied spot.
                // TODO this handles one peg per column right now.
                if (grid[i][peg.getSpot().getLocation().getColumn()]
                    .getLocation() == peg.getSpot().getLocation()) {
                    occupied
                        .add(grid[i][peg.getSpot().getLocation().getColumn()]);
                }
            }

        }

        Spot[] listOfOccupied;
        listOfOccupied = (Spot[]) occupied.toArray();
        LOG.info("Returning an array of occupied spots.");
        return listOfOccupied;
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
     * Initialize the grid of spots.
     */
    public void initializeGrid() {
        for (int i = 0; i < NUMROWS; i++) {
            for (int j = 0; j < NUMCOL; j++) {
                grid[i][j] = new Spot(new Location(i, j));
            }
        }
    }

    /**
     * This method assigns a random spot to be a prize spot and returns the grid
     * location of that spot. The type of that spot will be changed to PRIZE.
     * 
     * @return a priceSpot location of type spot.
     */
    public Spot assignPrizeSpot() {
        LOG.trace("Returning a location of a prizeSpot.");
        int row = rand.nextInt(120);
        int col = rand.nextInt(3);
        Location loc = new Location(row, col);
        grid[row][col] = new PrizeSpot(loc);
        return grid[row][col];

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

        Spot[] spotLocations = new Spot[8];
        int row;
        int col;

        for (int i = 0; i < 8; i++) {
            row = (i + 1) * 15 - 1;
            for (int j = 0; j < NUMCOL; j++) {
                col = j;
                // System.out.println("i = " + i + ", j = " + j);
                Location loc = new Location(row, col);
                grid[row][col] = new BattleSpot(loc);
                spotLocations[i] = grid[row][col];
            }
        }

        return spotLocations;

    }

    /**
     * This method assigns a random spot to be a jump spot and returns the grid
     * location of that spot. The type of that spot will be changed to JUMP.
     * 
     * @return a jumpSpot location of type spot.
     */
    public Spot assignJumpSpot() {
        LOG.trace("Returning a location of a jumpSpot.");
        int row = rand.nextInt(120);
        int col = rand.nextInt(3);
        Location loc = new Location(row, col);
        grid[row][col] = new JumpSpot(loc);
        return grid[row][col];

    }

    /**
     * Calls battle spot methods when a player lands on a battle spot.
     * 
     * @param pegOne
     * @param pegTwo
     */
    public void landsOnBattleSpot(Peg pegOne, Peg pegTwo) {

        ((BattleSpot) (pegOne.getSpot())).decideWinner(pegOne.getOwner(),
            pegTwo.getOwner());

    }
    /**
     * Calls jump spot methods when a player lands on a battle spot.
     * 
     * @param peg
     */
    public void landsOnJumpSpot(Peg peg) {
        
        ((JumpSpot) (peg.getSpot())).jump(peg.getOwner());

    }
    /**
     * Calls prize spot methods when a player lands on a battle spot.
     * 
     * @param peg
     */
    public void landsOnPrizeSpot(Peg peg) {
        
        ((PrizeSpot) (peg.getSpot())).rewardPlayer(peg.getOwner());

    }

}
