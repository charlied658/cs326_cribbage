package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * Spot class.
 * 
 * @author Zoe Beals 4/6/2022
 * 
 *      Code reviewed by Jonah Marcus on April 11, 2022
 *      Comment by Jonah:
 *      "I don't know if this could be a problem, but neither SpotType nor
 *      Location have toString methods. Not entirely sure if that could
 *      cause problems for this class's toString method, but it might not
 *      be a bad idea to implement in those classes. Unless I'm just completely 
 *      wrong here in which case just ignore this lmao."
 */
public class Spot {
    /**
     * spotType - holds the type of the spot.
     */
    private SpotType spotType;

    /**
     * location - holds the location of the spot.
     */
    private Location location;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(Spot.class);
    }

    /**
     * Spot constructor.
     * 
     * @param loc Location in the grid.
     */
    public Spot(Location loc) {
        LOG.trace("Entered Spot Constructor");
        this.location = loc;
    }

    /**
     * getType method return the type of the spot.
     * 
     * @return the spot type
     */
    public SpotType getType() {
        LOG.trace("getType method in Spot class");
        return spotType;
    }

    /**
     * getLocation method returns the location of the spot.
     * 
     * @return the location.
     */
    public Location getLocation() {
        LOG.trace("getLocation method in Spot class");
        return location;
    }
    
    @Override
    public String toString() {
        return "Spot: " + this.spotType + ", " + this.location;
    }

}
