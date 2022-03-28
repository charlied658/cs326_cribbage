package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.HashMap;

/**
 * Item Shop Interface
 * TODO Add update methods to update player tokens after purchase and update
 * player inventory.
 * 
 * @author Muaded Almheiri
 */
public interface ItemShopInterface {

    /**
     * Hash map with store items being sold with their token price.
     */
    HashMap<String, Integer> storeItems = 
        new HashMap<String, Integer>();

    /**
     * Print Item name, price, and description.
     */
    void getItemInfo();

    /**
     * Buy's item if player has enough tokens.
     * 
     * @param playerTokens
     *            Tokens held by player.
     */
    void buyItem(int playerTokens);

    /**
     * Getter method for special card/item name.
     * 
     * @return special card/item name
     */
    String getName();

    /**
     * Getter method for special card/item token price.
     * 
     * @return item token price
     */
    int getPrice();

    /**
     * Getter method for special card/item description.
     * 
     * @return special card/item description/use.
     */
    String getDescription();

    /**
     * Setter method for card/item name.
     * 
     * @param name
     *            Card/item name.
     */
    void setName(String name);

    /**
     * Setter method for card/item price.
     * 
     * @param price
     *            Card/item price
     */
    void setPrice(int price);

    /**
     * Setter method for card/item description.
     * 
     * @param description
     *            Card/item description.
     */
    void setDescription(String description);

}
