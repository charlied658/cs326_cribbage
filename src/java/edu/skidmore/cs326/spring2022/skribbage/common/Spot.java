package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * Spot class.
 * 
 * @author Zoe Beals 4/6/2022
 *         Code reviewed by Jonah Marcus on April 11, 2022
 *         Comment by Jonah:
 *         "I don't know if this could be a problem, but neither SpotType nor
 *         Location have toString methods. Not entirely sure if that could
 *         cause problems for this class's toString method, but it might not
 *         be a bad idea to implement in those classes. Unless I'm just
 *         completely
 *         wrong here in which case just ignore this lmao."
 *         Code updated by Lois on April 25, 2022
 *         Comment by Lois: "Needed to add override for equals and hashcode to 
 *         fix assigned bug." 
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
     * @param loc
     *            Location in the grid.
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
     * Sets the type of a spot.
     * @param type
     */
    public void setType(SpotType type) {
        this.spotType = type;
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
    /**
     * Compares the location of two Spots.
     * @return boolean
     * @param tempSpot
     */
    @Override
    public boolean equals(Object tempSpot) {
        if (tempSpot instanceof Spot) {
            return this.getLocation() == ((Spot) tempSpot).getLocation(); 
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return (this.getLocation() + " " + this.getLocation()).hashCode();
    }

}
