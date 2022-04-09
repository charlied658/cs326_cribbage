package edu.skidmore.cs326.spring2022.skribbage.gamification;

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
     * Hash ap that stores items and their quantity.
     */
     public HashMap<String, Integer> INVENTORY =
         new HashMap<String, Integer>();

    /**
     * When items are used we go to the HashMap and reduce the amount by 1.
     *
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     */
    public void useItem(HashMap<String, Integer> map, String key);

    /**
     * When an item is added we access the HashMap and increase the number by 1.
     * implementation may change if we want to purchase multiple items
     *
     */
    public void addItem(HashMap<String, Integer> map, String key);

    /**
     * A quick search for a player to see the number of items they possess.
     */
    public int searchForItem(HashMap<String, Integer> map, String key);

    /**
     * Update the HashMap with data from our data base.
     */
    public void updateInventory(HashMap<String, Integer> map);
}
