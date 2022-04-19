package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * Creates a die that can be given a specified number of spots and rolled. 
 * @author Henry Wilson
 *
 */
public class Die {
    
    /**
     * Random number generator for die.
     */
    private Random rand = new Random();

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(Die.class);
    }
    
    /**
     * Method to get a die roll with a specified number of sides.
     * @param upperBound
     * @param lowerBound
     * @param allowZero
     * @return die roll
     */
    public int rollDie(int upperBound, int lowerBound, boolean allowZero) {
        
        int diceRoll = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
        if (diceRoll == 0 && (!allowZero)) {
            int oneOrNegOne = rand.nextInt(2);
            if (oneOrNegOne == 1) {
                LOG.info("Die: dice roll is 1");
                return 1;
            } else {
                LOG.info("Die: dice roll is -1");
                return -1;
            }
            
        }
        return diceRoll;
    }
    
    

}
