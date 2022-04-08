package edu.skidmore.cs326.spring2022.skribbage.common;

import org.apache.log4j.Logger;

/**
 * Spot class.
 * 
 * @author Zoe Beals 4/6/2022
 */
public class Spot {
    /**
     * spotType - holds the type of the spot.
     */
    private SpotType spotType;

    /**
     * location - holds the location of the spot.
     */
    // private Location location;\
    
    /**
     * Logger.
     */
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(Spot.class);
    }

    /**
     * Spot constructor.
     */
    public Spot() {
        LOG.trace("Entered Spot Constructor");
    }
    
    /**
     * getType method return the type of the spot.
     * @return the spot type
     */
    public SpotType getType() {
        LOG.trace("getType method in Spot class");
        return spotType;
    }
    
    /**
     * getLocation method returns the location of the spot.
     * @return the location.
     */
//    public Location getLocation() {
//        LOG.trace("getLocation method in Spot class");
//        return location;
//    }

}
