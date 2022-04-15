package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

public interface InventoryManagement {

	public HashMap<String, Item> displayInventory(User user);

	public boolean addItem(User user, String item, int quantity);

	public boolean removeItem(User user, String item, int quantity);

	public boolean transferItem(User sender, User recipient, String item);

	public String displayWallet(User user);

}
