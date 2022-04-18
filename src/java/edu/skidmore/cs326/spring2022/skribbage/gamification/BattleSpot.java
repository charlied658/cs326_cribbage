package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
//import java.util.Random;
import org.apache.log4j.Logger;

/**
 * When two players are on the battle spot a battle ensues. One of the
 * two is randomly chosen to be the victor. A six sided die is rolled with the
 * values -3, -2, -1, 1, 2, 3. If a negative number is rolled the loser goes
 * back that number of spots. If a positive number is rolled the winner goes
 * forward that number of spots.
 * 
 * @author Henry Wilson
 *         Last edited by Muaded Almheiri
 */
public class BattleSpot {

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
     * Die to be rolled in the battle spot class.
     */
    private Die die = new Die();

   /**
    * Randomly decides the winner when two players land on a battle spot. 
    * @param p1
    * @param p2
    */
    public void decideWinner(Player p1, Player p2) {
        
        int diceRoll = die.rollDie(2, 0, true);
        LOG.info("decideWinner: Dice roll is " + diceRoll);
        System.out.println(diceRoll);

        if (diceRoll == 1) {
            LOG.info("decideWinner: " + p1.getName() + " is the winner");
            System.out.println("Player one wins");
            
            rewardPenalty(p1, p2);
        } else {
            LOG.info("decideWinner: " + p2.getName() + " is the winner");
            System.out.println("Player two wins");
            rewardPenalty(p2, p1);
        }

    }

    /**
     * Rolls a dice and decides whether to reward the winner or penalize the
     * loser
     * and by how much.
     * @param loser
     * @param winner
     */
    public void rewardPenalty(Player loser, Player winner) {

        int diceRoll = die.rollDie(3, -3, false);
        
        LOG.info("rewardPenalty: Dice roll is " + diceRoll);
        if (diceRoll > 0) {
            LOG.info("rewardPenalty: winner moved up " + diceRoll);
            winner.addPoints(diceRoll);
        } else {
            LOG.info("rewardPenalty: loser moved down " + diceRoll);
            loser.addPoints(diceRoll);

        }
    }

}
