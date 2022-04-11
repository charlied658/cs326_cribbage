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
        LOG = Logger.getLogger(BattleSpot.class);
    }
    /**
     * Method to get a die roll with a specified number of sides.
     * @param upperBound
     * @param lowerBound
     * @param allowZero
     * @return die roll
     */
    public int rollDie(int upperBound, int lowerBound, boolean allowZero) {
        int numSides = upperBound - lowerBound;
        if (allowZero) {
            numSides++;
        }
        int randInt = rand.nextInt(numSides);
        System.out.println("randint is " + randInt);
        LOG.info("Die: random integer is " + randInt);
        if (lowerBound > 0) {
            LOG.info("Die: dice roll is " + randInt + 1);
            return randInt + 1;
        }
        if (lowerBound == 0) {
            LOG.info("Die: dice roll is " + randInt);
            return randInt;
        }
        if (lowerBound < 0) {
            if (allowZero) {
                LOG.info("Die: dice roll is " + (randInt + lowerBound));
                return randInt + lowerBound;
            } else {
                if (randInt + lowerBound == 0) {
                    int oneOrNegOne = rand.nextInt(2);
                    if (oneOrNegOne == 1) {
                        LOG.info("Die: dice roll is 1");
                        return 1;
                    } else {
                        LOG.info("Die: dice roll is -1");
                        return -1;
                    }
                } else {
                    LOG.info("Die: dice roll is " + (randInt + lowerBound));
                    return randInt + lowerBound;
                }
            }
        }
        
        return randInt;
        
        
        
    }

}
