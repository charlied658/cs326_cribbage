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
        
        int newCol = 0;
        int newRow = 0;
        int spacesRemaining = 0;
        
        for (int i = currentLoc.getColumn(); i < grid.length; i++) {
            for (int j = currentLoc.getRow(); j < grid[i].length; j++) {
                newCol = i;
                newRow = j;
                spacesRemaining++;
            }
        }
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
