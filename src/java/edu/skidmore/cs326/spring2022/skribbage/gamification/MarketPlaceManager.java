// package edu.skidmore.cs326.spring2022.skribbage.gamification;
//
// import java.util.HashMap;
//
// import org.apache.log4j.Logger;
//
/// **
// * Market Place manager. Implements Market Place management interface.
// *
// * @author Muaded Almheiri
// */
// public class MarketPlaceManager implements MarketPlaceManagement {
//
// /**
// * Logger for the class.
// */
// private static final Logger LOG;
//
// /**
// * Create static resources.
// */
// static {
// LOG = Logger.getLogger(ReBattleCard.class);
// }
//
// /**
// * Hash map to hold items bought before being updated to inventory.
// */
// private HashMap<String, Integer> cart = new HashMap<String, Integer>();
//
// /**
// * Special Card's name.
// */
// private String specialCardType;
//
// /**
// * Special Card's price.
// */
// private int specialCardPrice;
//
// /**
// * Special Card's description/use.
// */
// private String specialCardDescription;
//
// /**
// * MarketPlaceManager constructor.
// * @param specialCardType
// */
// public MarketPlaceManager(SpecialCard specialCardType) {
//
// switch (specialCardType) {
//
// case REBATTLECARD:
// setName(SpecialCard.REBATTLECARD.getType());
// setPrice(SpecialCard.REBATTLECARD.getPrice());
// setDescription(SpecialCard.REBATTLECARD.getDescription());
// break;
//
// case LASTPLAYERSHOWCARD:
// setName(SpecialCard.LASTPLAYERSHOWCARD.getType());
// setPrice(SpecialCard.LASTPLAYERSHOWCARD.getPrice());
// setDescription(SpecialCard.LASTPLAYERSHOWCARD.getDescription());
// break;
//
// case SKIPPLAYERTURNCARD:
// setName(SpecialCard.SKIPPLAYERTURNCARD.getType());
// setPrice(SpecialCard.SKIPPLAYERTURNCARD.getPrice());
// setDescription(SpecialCard.SKIPPLAYERTURNCARD.getDescription());
// break;
//
// case THROWAWAYPICKUPCARD:
// setName(SpecialCard.THROWAWAYPICKUPCARD.getType());
// setPrice(SpecialCard.THROWAWAYPICKUPCARD.getPrice());
// setDescription(
// SpecialCard.THROWAWAYPICKUPCARD.getDescription());
// break;
//
// case MIRROR:
// setName(SpecialCard.MIRROR.getType());
// setPrice(SpecialCard.MIRROR.getPrice());
// setDescription(SpecialCard.MIRROR.getDescription());
// break;
//
// case DISARM:
// setName(SpecialCard.DISARM.getType());
// setPrice(SpecialCard.DISARM.getPrice());
// setDescription(SpecialCard.DISARM.getDescription());
// break;
//
// case PICKPOCKET:
// setName(SpecialCard.PICKPOCKET.getType());
// setPrice(SpecialCard.PICKPOCKET.getPrice());
// setDescription(SpecialCard.PICKPOCKET.getDescription());
// break;
//
// case AUTOPILOT:
// setName(SpecialCard.AUTOPILOT.getType());
// setPrice(SpecialCard.AUTOPILOT.getPrice());
// setDescription(SpecialCard.AUTOPILOT.getDescription());
// break;
//
// case COPYCAT:
// setName(SpecialCard.COPYCAT.getType());
// setPrice(SpecialCard.COPYCAT.getPrice());
// setDescription(SpecialCard.COPYCAT.getDescription());
// break;
//
// default:
// LOG.error("Invalid special card type.");
// break;
//
// }
//
// LOG.info("Type, price, and description set for " + getName());
//
// boolean isEntry = false;
//
// /*
// * Loop through Hash map to check if card already exists in market
// * place.
// */
// for (HashMap.Entry<String, Integer> entry : STORE_ITEMS.entrySet()) {
//
// if (entry.getKey().equals(getName())) {
//
// /* Card already in store. */
// isEntry = true;
// }
// }
// /* Card is not in store, place in store with value. */
// if (!isEntry) {
// STORE_ITEMS.put(getName(), getPrice());
// LOG.info(getName() + " placed in store with price " + getPrice());
// }
//
// }
//
// /**
// * Buy's card at given price based on amount of tokens held by player.
// * TODO if special card bought. Update tokens.
// */
// @Override
// public void buySpecialCard(int playerTokens) {
//
// if (getPrice() <= playerTokens) {
// LOG.info(getName() + " bought for " + getPrice() + " tokens");
// playerTokens -= getPrice();
// LOG.info(getPrice() + " Tokens subtracted from player's wallet.");
// LOG.info(getName() + " bought at price " + getPrice()
// + ". Player now holds " + playerTokens);
// addSpecialCard(cart);
// } else {
// LOG.info("Not enough tokens to buy a " + getName());
// }
// }
//
// /**
// * Getter method for special card name.
// *
// * @return special card name
// */
// @Override
// public String getName() {
//
// LOG.info("Returning special card name.");
// return specialCardType;
// }
//
// /**
// * Getter method for special card token price.
// *
// * @return Special card token price
// */
// @Override
// public int getPrice() {
//
// LOG.info("Returning special card price.");
// return specialCardPrice;
// }
//
// /**
// * Getter method for special card description.
// *
// * @return special card description/use.
// */
// @Override
// public String getDescription() {
//
// LOG.info("Returning special card description.");
// return specialCardDescription;
//
// }
//
// /**
// * Setter method for special card name.
// *
// * @param name
// * special card name.
// */
// public void setName(String name) {
//
// specialCardType = name;
//
// }
//
// /**
// * Setter method for special card price.
// *
// * @param price
// * special card price
// */
// public void setPrice(int price) {
//
// specialCardPrice = price;
//
// }
//
// /**
// * Setter method for special card description.
// *
// * @param description
// * special card description.
// */
// public void setDescription(String description) {
//
// specialCardDescription = description;
//
// }
//
// /**
// * Method to update player inventory with item bought.
// *
// * @param cart
// * HashMap holding items bought.
// */
// public void addSpecialCard(HashMap<String, Integer> cart) {
//
// InventoryPrototype inventoryObj = new InventoryPrototype();
// cart.put(getName(), getPrice());
// inventoryObj.addItem(cart, getName());
//
// }
//
// }
