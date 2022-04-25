package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;

//import java.util.Random;
import org.apache.log4j.Logger;

/**
 * When a player lands on a jump spot, a six sided die is rolled with values
 * from -2 to 3. The player is then jumped forward or backward that number of
 * spaces
 * 
 * @author Henry Wilson
 *         Last Edited by Muaded Almheiri [Fixed checkstyle]
 */
public class JumpSpot extends Spot {
    
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
     * Type of spot.
     */
    private SpotType spotType;
    
    /**
     * Constructor for jump spot. 
     * @param location
     */
    public JumpSpot(Location location) {
        super(location);
        this.spotType = SpotType.JUMP;
       
    }
    
    /**
     * Returns type of spot.
     * @return type of spot
     */
    public SpotType getType() {
        return this.spotType;
    }
    
    /**
     * Die for jump spot.
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
