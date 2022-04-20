package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;

//import java.util.Random;
import org.apache.log4j.Logger;

/**
 * If a player lands on a prize spot they get a random prize.
 * 
 * @author Henry Wilson
 *         Last edited by Muaded Almheiri
 */
public class PrizeSpot extends Spot {
    /**
     * Constructor for prize spot.
     * @param location
     */
    public PrizeSpot(Location location) {
        super(location);
        this.spotType = SpotType.PRIZE;
        
    }

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
    /**
     * Type of spot.
     */
    private SpotType spotType;
    
    /**
     * Die.
     */
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
    
    /**
     * Returns type of spot.
     * @return type of spot
     */
    public SpotType getType() {
        return this.spotType;
    }

}
