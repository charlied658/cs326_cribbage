package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 * When a player lands on a jump spot, a six sided die is rolled with values
 * from -2 to 3. The player is then jumped forward or backward that number of
 * spaces
 * 
 * @author Henry Wilson
 */
public class JumpSpot {
    
    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(JumpSpot.class);
    }
    /**
     * Die to determine jump spot outcome.
     */
    private Die die = new Die();

    /**
     * Jumps the player backward or forward depending on a dice roll when they
     * land on the jump spot.
     *
     * @param player
     *            being jumped
     */
    public void jump(Player player) {

        int diceRoll = die.rollDie(3, -2, true);
        System.out.println(diceRoll);
        LOG.info("rewardPenalty: Dice roll is " + diceRoll);
        player.addPoints(diceRoll);
       

    }

}
