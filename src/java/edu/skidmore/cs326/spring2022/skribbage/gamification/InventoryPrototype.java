package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.HashMap; //Import HashMap
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.PastGamesPage;

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
     *         
     *         Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
     */

    /**
     * HashMap For inventory.
     */
    private HashMap<String, Integer> map;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(InventoryPrototype.class);
    }

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
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     */
    public void useItem(HashMap<String, Integer> map, String key) {
        int val = map.get(key);
        if (val <= 0) {
            return;
        }
        map.replace(key, val - 1);
    }

    /**
     * When an item is added we access the HashMap and increase the number by 1.
     * implementation may change if we want to purchase multiple items
     * 
     * @param map
     *            HashMap used as our inventory
     * @param key
     *            name of the item
     */
    public void addItem(HashMap<String, Integer> map, String key) {
        int val = map.get(key);
        map.replace(key, val + 1);
    }

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
    public int searchForItem(HashMap<String, Integer> map, String key) {
        int val = map.get(key);
        return val;
    }

    /**
     * Update the HashMap with data from our data base.
     * (currently a txt file for demonstration purposes).
     * 
     * @param map
     *            HashMap used as our inventory
     */
    public void updateInventory(HashMap<String, Integer> map) {
        try {
            File myObj = new File("inventory.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String item = myReader.nextLine();
                int value = Integer.parseInt(myReader.nextLine());
                map.put(item, value);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            LOG.error("inventory.txt not found", e);
        }
    }
}
