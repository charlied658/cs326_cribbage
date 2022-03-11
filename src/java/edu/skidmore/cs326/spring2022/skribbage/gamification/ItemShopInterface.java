//package edu.skidmore.cs326.spring2022.skribbage.gamification;
//
//import org.apache.log4j.Logger;
//
//import java.io.*;
//import java.util.HashMap;
//
///**
// *  Item Shop Interface
// *  TODO Add update methods to update player tokens after purchase and update player inventory.
// * @author Muaded Almheiri
// *
// */
//public interface ItemShopInterface {
//	
//    /**
//     * Hash map with store items being sold with their token price.
//     */
//	public HashMap<String, Integer> storeItems = new HashMap<String, Integer>();
//	
//	/**
//	 * Print Item name, price, and description.
//	 */
//	public void getItemInfo();
//	
//	/**
//	 * Buy's item if player has enough tokens.
//	 * @param playerTokens Tokens held by player.
//	 */
//	public void buyItem(int playerTokens);
//	
//	/**
//	 * Getter method for special card/item name.
//	 * @return special card/item name
//	 */
//	public String getName();
//	
//	/**
//	 * Getter method for special card/item token price.
//	 * @return item token price
//	 */
//	public int getPrice();
//	
//	/**
//	 * Getter method for special card/item description.
//	 * @return special card/item description/use.
//	 */
//	public String getDescription();
//}
