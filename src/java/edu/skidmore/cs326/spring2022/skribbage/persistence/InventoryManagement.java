package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * inventory management.
 * 
 * @author ??
 */
public interface InventoryManagement {

    /**
     * display inventory.
     * 
     * @param user
     * @return the hashmap.
     */
    HashMap<String, Item> displayInventory(User user);

    /**
     * add item.
     * 
     * @param user
     * @param item
     * @param quantity
     * @return ??
     */
    boolean addItem(User user, String item, int quantity);

    /**
     * remove item.
     * 
     * @param user
     * @param item
     * @param quantity
     * @return ??
     */
    boolean removeItem(User user, String item, int quantity);

    /**
     * transfer item.
     * 
     * @param sender
     * @param recipient
     * @param item
     * @return ??
     */

    boolean transferItem(User sender, User recipient, String item);

    /**
     * display wallet.
     * 
     * @param user
     * @return ??
     */
    String displayWallet(User user);

}
