package edu.skidmore.cs326.spring2022.skribbage.gamification;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;

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
    
    @Override
    public void signalUse(SpecialCard specialCardType, Player playerOne,
        Player playerTwo) {

        switch (specialCardType) {

            case REBATTLECARD:
                if (playerOne.getInventoryManager()
                    .searchForItem(SpecialCard.REBATTLECARD.getType()) > 0
                    && playerTwo.getInventoryManager().searchForItem(
                        SpecialCard.REBATTLECARD.getType()) > 0) {
                    //TODO check for 0, 0 | 1, 0 | 0, 1 | and 1, 1.
                } else {
                    LOG.info("Neither players are holding a " + SpecialCard.REBATTLECARD.getType());
                }
                break;

            case LASTPLAYERSHOWCARD:
                break;

            case SKIPPLAYERTURNCARD:
                break;

            default:
                LOG.error("Invalid special card type.");
                break;

        }

    }

    @Override
    public void updateInventory(Player specialCardPlayer) {
        // TODO Auto-generated method stub

    }

}
