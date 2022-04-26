package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.HashMap; //Import HashMap
import org.apache.log4j.Logger;

//import edu.skidmore.cs326.spring2022.skribbage.frontend.PastGamesPage;

/**
 * Prototype for inventory that will store special cards and items.
 */
public class InventoryPrototype {
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
     *         Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
     */

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(InventoryPrototype.class);
    }

    /**
     * HashMap For inventory.
     */
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Initialize HashMap for Inventory.
     */
    public void initializeInventory() {
        map = new HashMap<String, Integer>();
    }

    /**
     * Creates map.
     * 
     * @return
     *         returns HashMap
     */
    public HashMap<String, Integer> createInventory() {
        return map;
    }

    /**
     * When items are used we go to the HashMap and reduce the amount by 1.
     * 
     * @param key
     *            name of the item
     */
    public void useItem(String key) {
        int val = map.get(key);
        if (val <= 0) {
            LOG.info("User does not have the specified item");
            return;
        }
        map.replace(key, val - 1);

        LOG.info("Using card - Decrementing card quantity by one");
    }

    /**
     * When an item is added we access the HashMap and increase the number by 1.
     * implementation may change if we want to purchase multiple items
     * 
     * @param key
     *            name of the item
     * @param quantity
     *            number of items to add
     */
    public void addItem(String key, int quantity) {
        int val = map.get(key);
        map.replace(key, val + quantity);

        LOG.info("Using card - Incrementing card quantity by one");
    }

    /**
     * A quick search for a player to see the number of items they possess.
     * 
     * @param key
     *            name of the item
     * @return val
     *         number of specified item in an inventory
     */
    public int searchForItem(String key) {
        int val = map.get(key);
        LOG.info("Searching HashTable for quantity of " + key);
        return val;
    }

    /**
     * Update the HashMap with data from our data base.
     * (currently hardcodes values to fill the HashTable.
     */
    public void updateInventory() {
        map.put(SpecialCard.LASTPLAYERSHOWCARD.getType(), 0);
        map.put(SpecialCard.REBATTLECARD.getType(), 0);
        map.put(SpecialCard.THROWAWAYPICKUPCARD.getType(), 0);
        map.put(SpecialCard.MIRROR.getType(), 1);
        //map.put(SpecialCard.SW, 0);
        //map.put("Copy", 0);
        map.put(SpecialCard.DISARM.getType(), 0);
        map.put(SpecialCard.PICKPOCKET.getType(), 0);
        map.put(SpecialCard.AUTOPILOT.getType(), 0);
        map.put(SpecialCard.COPYCAT.getType(), 0);
        LOG.info("Players Inventory has been filled with current data");
        // e.printStackTrace();
    }
}
