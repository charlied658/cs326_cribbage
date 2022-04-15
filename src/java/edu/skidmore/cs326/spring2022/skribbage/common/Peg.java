package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.gamification.Player;

/**
 * An object that represents an individual peg on the Skribbage board.
 * 
 * @author Jonah Marcus
 *         Last Updated April 11 2022
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
     * @return spot
     */
    public Spot getSpot() {
        LOG.trace("Peg.java getSpot()");
        return spot;
    }

    /**
     * @return owner
     */
    public Player getOwner() {
        LOG.trace("Peg.java getOwner()");
        return owner;
    }

    /**
     * Moves the peg a specified number of spaces on the board.
     * 
     * @param numSpaces
     */
    public void movePeg(int numSpaces) {
        LOG.trace("Peg.java movePeg()");
        Location current = this.spot.getLocation();
        this.spot = new Spot(new Location(current.getRow() + numSpaces,
            current.getColumn()));
    }

}
