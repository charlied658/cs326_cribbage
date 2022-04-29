package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * An object that represents an individual peg on the Skribbage board.
 * 
 * @author Jonah Marcus
 *         Last Updated April 11 2022
 *         Code updated by Lois on April 25, 2022
 *         Comment by Lois: "Needed to add override for equals and hashcode to 
 *         fix assigned bug."
 */
public class Peg {
    /**
     * role - Keeps track of whether a peg is a front peg or a back peg.
     */
    private PegType role;

    /**
     * spot - Keeps track of a peg's spot on the board.
     */
    private Spot spot;

    /**
     * owner - The player who "owns" the peg.
     */
    private Player owner;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(Peg.class);
    }

    /**
     * Peg constructor.
     * 
     * @param sp
     *            Spot of a Peg.
     */
    public Peg(Spot sp) {
        LOG.trace("Peg.java constructor");
        this.spot = sp;

    }

    /**
     * @return role
     */
    public PegType getRole() {
        LOG.trace("Peg.java getRole()");
        return role;
    }
    
    /**
     * sets PegType.
     * @param pt
     */
    public void setRole(PegType pt) {
        this.role = pt;
    }

    /**
     * @return spot
     */
    public Spot getSpot() {
        LOG.trace("Peg.java getSpot()");
        return spot;
    }
    /**
     * sets the peg's spot.
     * @param spot
     */
    public void setSpot(Spot spot) {
        this.spot = spot;
        
    }

    /**
     * @return owner
     */
    public Player getOwner() {
        LOG.trace("Peg.java getOwner()");
        return owner;
    }
    
    /**
     * sets the peg's owner.
     * @param owner
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Moves the peg a specified number of spaces on the board.
     * 
     * @param numSpaces
     * @throws Errors - Handles errors for the peg's movement
     * across the board.
     */
    public void movePeg(int numSpaces) throws Error {
        LOG.trace("Peg.java movePeg()");
        Location currentLoc = this.spot.getLocation();
        Spot[][] grid = BoardManager.getInstance().getBoard().getGrid();
        

        int newRow = 0;
        int newCol = 0;
        
        // These nested loops run through the grid of spots, and upon each
        // iteration, checks if it has run through the number of spots
        // specified in the parameter of this method. I'm not 100% sure if
        // two if statements are entirely necessary, but I did it just to avoid
        // a potential off by 1 error. Worst case scenario, it's just slightly 
        // redundant.
        outerloop:
        for (int i = currentLoc.getRow(); i < grid.length; i++) {
            if ((i + currentLoc.getColumn()) - (currentLoc.getRow() 
                + currentLoc.getColumn()) == numSpaces) {
                newRow = i;
                newCol = currentLoc.getColumn();
                break outerloop;
            }
            for (int j = currentLoc.getColumn(); j < grid[i].length; j++) {
                if ((i + j) - (currentLoc.getRow() + currentLoc.getColumn()) 
                    == numSpaces) {
                    newRow = i;
                    newCol = j;
                    break outerloop;
                }
            }
        }
        
        // In this instance, we have exited the loop without updating newRow
        // or newCol. Unless numSpaces = 0, something went wrong and we were
        // unable to update the Peg's spot.
        if (newRow == currentLoc.getRow() && newCol == currentLoc.getColumn() 
            && numSpaces > 0) {
            throw new Error("Unable to update Peg's spot.");
        }
        
        this.spot = grid[newRow][newCol];
    }

    /**
     * Compares the owner of two pegs.
     * 
     * @return boolean
     * @param tempPeg
     */
    @Override
    public boolean equals(Object tempPeg) {
        if (tempPeg instanceof Peg) {
            return this.getOwner() == ((Peg) tempPeg).getOwner();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.getOwner() + " " + this.getOwner()).hashCode();
    }

}
