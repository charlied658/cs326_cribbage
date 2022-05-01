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
                player.getInventoryManager().addItem(SpecialCard.MIRROR.getType(), 1);
                break;
            case 1:
                player.getInventoryManager().addItem(SpecialCard.REBATTLECARD.getType(), 1);
                break;
            case 2:
                player.getInventoryManager().addItem(SpecialCard.LASTPLAYERSHOWCARD.getType(),
                    1);
                break;
            case 3:
                player.getInventoryManager().addItem(SpecialCard.THROWAWAYPICKUPCARD.getType(),
                    1);
                break;
            case 4:
                player.getInventoryManager().addItem(SpecialCard.DISARM.getType(), 1);
                break;
            case 5:
                player.getInventoryManager().addItem(SpecialCard.PICKPOCKET.getType(), 1);
                break;
            case 6:
                player.getInventoryManager().addItem(SpecialCard.AUTOPILOT.getType(), 1);
                break;
            case 7:
                player.getInventoryManager().addItem(SpecialCard.COPYCAT.getType(), 1);
                break;
            case 8:
                player.getInventoryManager().addItem(SpecialCard.SKIPPLAYERTURNCARD.getType(),
                    1);
            default:
                LOG.error("Error with prize spot");
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
