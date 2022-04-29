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
     * 
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
    private Die die = new Die();

    /**
     * Gives the player a prize when they land on the prize spot.
     * 
     * @param player
     */
    public void rewardPlayer(Player player) {

        int diceRoll = die.rollDie(8, 0, true);
        LOG.info("rewardPlayer: Dice roll is " + diceRoll);
        switch (diceRoll) {
            case 0:
                player.getInventoryManager().addItem("Mirror", 1);
                break;
            case 1:
                player.getInventoryManager().addItem("Re-Battle Card", 1);
                break;
            case 2:
                player.getInventoryManager().addItem("Last-Player-Show Card",
                    1);
                break;
            case 3:
                player.getInventoryManager().addItem("Throw-Away-Pickup Card",
                    1);
                break;
            case 4:
                player.getInventoryManager().addItem("Disarm", 1);
                break;
            case 5:
                player.getInventoryManager().addItem("Pick Pocket", 1);
                break;
            case 6:
                player.getInventoryManager().addItem("Auto Pilot", 1);
                break;
            case 7:
                player.getInventoryManager().addItem("Copycat", 1);
                break;
            case 8:
                player.getInventoryManager().addItem("Skip-Player-Turn Card",
                    1);
            default:
                LOG.info("Error with prize spot");
        }

    }

    /**
     * Returns type of spot.
     * 
     * @return type of spot
     */
    public SpotType getType() {
        return this.spotType;
    }

}
