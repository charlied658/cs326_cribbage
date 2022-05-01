package edu.skidmore.cs326.spring2022.skribbage.gamification;

import org.apache.log4j.Logger;

//import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.BattleSpot;

/**
 * Special Card logic manager. Implements SpecialCardManagement interface.
 * 
 * @author Muaded Almheiri
 */
public class SpecialCardManager implements SpecialCardManagement {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(SpecialCardManager.class);
    }

    /**
     * Method to signal use of special card.
     * TODO Ask Loser of Battle spot first. Then call BattleSpot recursively.
     * 
     * @param specialCardType
     *            type of special card signalled.
     * @param playerOne
     *            First player. In case of Battle spot, loser of first battle.
     * @param playerTwo
     *            Second player. Winner of Battle spot battle.
     */
    @Override
    public void signalUse(SpecialCard specialCardType, Player playerOne,
        Player playerTwo) {

        switch (specialCardType) {
            // BattleSpot instance = new BattleSpot();
            case REBATTLECARD:
                if (playerOne.getInventoryManager()
                    .searchForItem(SpecialCard.REBATTLECARD.getType()) > 0
                    && playerTwo.getInventoryManager().searchForItem(
                        SpecialCard.REBATTLECARD.getType()) > 0) {

                    LOG.trace("entered" + SpecialCard.REBATTLECARD.getType());

                } else if (playerOne.getInventoryManager()
                    .searchForItem(SpecialCard.REBATTLECARD.getType()) > 0
                    && playerTwo.getInventoryManager().searchForItem(
                        SpecialCard.REBATTLECARD.getType()) == 0) {
                    LOG.trace("temporary");
                } else if (playerOne.getInventoryManager()
                    .searchForItem(SpecialCard.REBATTLECARD.getType()) == 0
                    && playerTwo.getInventoryManager().searchForItem(
                        SpecialCard.REBATTLECARD.getType()) > 0) {
                    LOG.trace("temporary");

                } else {
                    LOG.warn("Neither players are holding a "
                        + SpecialCard.REBATTLECARD.getType());
                }

                break;

            case LASTPLAYERSHOWCARD:
                if (playerOne.getInventoryManager().searchForItem(
                    SpecialCard.LASTPLAYERSHOWCARD.getType()) > 0) {
                    LOG.trace(
                        "entered" + SpecialCard.LASTPLAYERSHOWCARD.getType());
                    // TODO Choose opponent whose show will be moved.
                }
                break;

            case SKIPPLAYERTURNCARD:
                if (playerOne.getInventoryManager().searchForItem(
                    SpecialCard.SKIPPLAYERTURNCARD.getType()) > 0) {
                    LOG.trace(
                        "entered" + SpecialCard.SKIPPLAYERTURNCARD.getType());
                    // TODO choose opponent whose turn will be skipped.
                }
                break;

            default:
                LOG.error("Invalid special card type.");
                break;

        }

    }

    @Override
    public void updateInventory(Player specialCardPlayer) {

    }

}
