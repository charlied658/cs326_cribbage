package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * inventory management.
 * 
 * @author Tinaye Mawocha
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
     * @param quantity: quantity of item to add
     * @return True or false whether the item was added successfully
     */
    boolean addItem(User user, String item, int quantity);

    /**
     * remove item.
     * 
     * @param user
     * @param item
     * @param quantity: quantity of item to remove
     * @return True or false whether the item was removed successfully
     */
    boolean removeItem(User user, String item, int quantity);

    /**
     * transfer item.
     * 
     * @param sender
     * @param recipient
     * @param item
     * @return True or false whether the transaction was successful or not
     */

    boolean transferItem(User sender, User recipient, String item);

    /**
     * display token value held by player
     * 
     * @param user: the user to query
     * @return String showing token value
     */
    String displayWallet(User user);

}
