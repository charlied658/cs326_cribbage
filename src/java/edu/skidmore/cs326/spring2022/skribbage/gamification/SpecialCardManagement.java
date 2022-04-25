package edu.skidmore.cs326.spring2022.skribbage.gamification;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * Special Card's logic management interface.
 * @author Muaded Almheiri
 *
 */
public interface SpecialCardManagement {

    /**
     * Method to signal use of special card based on given Special Card Type.
     * 
     * @param specialCardType
     *            Type of special card.
     * @param playerOne
     *            Player one.
     * @param playerTwo
     *            Player two.
     */
    void signalUse(SpecialCard specialCardType, Player playerOne,
        Player playerTwo);

    /**
     * Method to update special card user's inventory.
     * 
     * @param specialCardPlayer
     */
    void updateInventory(Player specialCardPlayer);

}
