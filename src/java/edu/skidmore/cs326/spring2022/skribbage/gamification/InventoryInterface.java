package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.HashMap;

/**
 * Prototype for inventory that will store special cards and items.
 */
interface InventoryInterface {
    /**
     * @author Indra
     *         Attributes:
     *         Inventory Object
     *         HashMap containing containg all items and number of itmes a
     *         player has
     *         Methods:
     *         useItem()
     *         addItem()
     *         searchForItem()
     *         updateInventory()
     */

    /**
     * Hash map that stores items and their quantity.
     */
    HashMap<String, Integer> INVENTORY =
        new HashMap<String, Integer>();

    /**
     * When items are used we go to the HashMap and reduce the amount by 1.
     *
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     */
    void useItem(HashMap<String, Integer> map, String key);

    /**
     * When an item is added we access the HashMap and increase the number by 1.
     * implementation may change if we want to purchase multiple items
     * 
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     */
    void addItem(HashMap<String, Integer> map, String key);

    /**
     * A quick search for a player to see the number of items they possess.
     * 
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     * @return val
     *         number of specified item in an inventory
     */
    int searchForItem(HashMap<String, Integer> map, String key);

    /**
     * Update the HashMap with data from our data base.
     * (currently a txt file for demonstration purposes).
     * 
     * @param map
     *            HashMap used as our inventory
     */
    void updateInventory(HashMap<String, Integer> map);
}
