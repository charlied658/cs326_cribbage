package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 * If a player lands on a prize spot they get a random prize.
 * 
 * @author Henry Wilson
 */
public class PrizeSpot {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(PrizeSpot.class);
    }
    
    private Die die;

    /**
     * Gives the player a prize when they land on the prize spot.
     * 
     * @param player
     */
    public void rewardPlayer(Player player) {

        int diceRoll = die.rollDie(6, 0, true);
        LOG.info("rewardPenalty: Dice roll is " + diceRoll);
        

    }

}
