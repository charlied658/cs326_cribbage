package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.HashMap;

/**
 * Market Place Management interface.
 * TODO Update player tokens. Waiting on Token manager class.
 * 
 * @author Muaded Almheiri
 */
public interface MarketPlaceManagement {

    /**
     * Hash map with store items being sold with their token price.
     */
    HashMap<String, Integer> STORE_ITEMS =
        new HashMap<String, Integer>();

    /**
     * Buy's special card if player has enough tokens.
     * 
     * @param playerTokens
     *            Tokens held by player.
     */
    void buySpecialCard(int playerTokens);

    /**
     * Getter method for special card name.
     * 
     * @return special card name
     */
    String getName();

    /**
     * Getter method for special card token price.
     * 
     * @return Special card token price
     */
    int getPrice();

    /**
     * Getter method for special card description.
     * 
     * @return special card description/use.
     */
    String getDescription();

}
