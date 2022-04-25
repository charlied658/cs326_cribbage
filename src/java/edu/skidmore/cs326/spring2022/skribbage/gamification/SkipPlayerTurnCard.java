//package edu.skidmore.cs326.spring2022.skribbage.gamification;
//
//import java.util.HashMap;
//
//import org.apache.log4j.Logger;
//
///**
// * Skip-Player-Turn Card item shop class.
// * 
// * @author Muaded Almheiri
// */
//public class SkipPlayerTurnCard implements ItemShopInterface {
//
//    /**
//     * Logger for the class.
//     */
//    private static final Logger LOG;
//
//    /**
//     * Create static resources.
//     */
//    static {
//        LOG = Logger.getLogger(SkipPlayerTurnCard.class);
//    }
//
//    /**
//     * Hash map to hold items bought before being updated to inventory.
//     */
//    private HashMap<String, Integer> cart = new HashMap<String, Integer>();
//
//    /**
//     * SpecialCardType variable to hold card/item name.
//     */
//    private String specialCardType;
//
//    /**
//     * Integer variable to hold card/item token price.
//     */
//    private int specialCardPrice;
//
//    /**
//     * String variable to hold card/item description.
//     */
//    private String specialCardDescription;
//
//    /**
//     * ReBattleCard constructor.
//     */
//    public SkipPlayerTurnCard() {
//        LOG.info("Creating new Re-battle card");
//
//        /* Set card type, price, and description. */
//        setName(SpecialCard.SKIPPLAYERTURNCARD.getType());
//        setPrice(SpecialCard.SKIPPLAYERTURNCARD.getPrice());
//        setDescription(SpecialCard.SKIPPLAYERTURNCARD.getDescription());
//
//        LOG.info("Name, price, and description set for "
//            + "Skip-Player-Turn- Card.");
//        LOG.info(
//            "Name, price, and description set for Skip-Player-Turn- Card.");
//
//        boolean isEntry = false;
//
//        /*
//         * Loop through Hash map to check if card already exists in item shop.
//         */
//        for (HashMap.Entry<String, Integer> entry : STORE_ITEMS.entrySet()) {
//
//            if (entry.getKey().equals(getName())) {
//
//                /* Card already in store. */
//                isEntry = true;
//            }
//        }
//        /* Card is not in store, place in store with value. */
//        if (!isEntry) {
//            STORE_ITEMS.put(getName(), getPrice());
//            LOG.info("Skip-Player-Turn Card placed in store with value 100");
//        }
//
//    }
//
//    /**
//     * Buy's card at given price based on amount of tokens held by player.
//     * TODO If item bought, update player inventory and tokens.
//     */
//    @Override
//    public void buyItem(int playerTokens) {
//
//        if (getPrice() <= playerTokens) {
//            LOG.info("Skip-Player-Turn Card bought for 100 tokens");
//            playerTokens -= getPrice();
//            LOG.info("100 Tokens subtracted from player's tokens.");
//            LOG.info(getName() + " bought at price " + getPrice()
//                + ". Player now holds " + playerTokens);
//            addSpecialCard(cart);
//        } else {
//            LOG.info("Not enough tokens to buy a Skip-Player-Turn Card.");
//        }
//    }
//
//    /**
//     * Getter method for special card/item name.
//     * 
//     * @return special card/item name
//     */
//    @Override
//    public String getName() {
//
//        LOG.info("Returning card name.");
//        return specialCardType;
//    }
//
//    /**
//     * Getter method for special card/item token price.
//     * 
//     * @return item token price
//     */
//    @Override
//    public int getPrice() {
//
//        LOG.info("Returning card price.");
//        return specialCardPrice;
//    }
//
//    /**
//     * Getter method for special card/item description.
//     * 
//     * @return special card/item description/use.
//     */
//    @Override
//    public String getDescription() {
//
//        LOG.info("Returning card description.");
//        return specialCardDescription;
//
//    }
//
//    /**
//     * Setter method for card/item name.
//     * 
//     * @param name
//     *            card/item name.
//     */
//    public void setName(String name) {
//
//        specialCardType = name;
//
//    }
//
//    /**
//     * Setter method for card/item price.
//     * 
//     * @param price
//     *            card/item price
//     */
//    public void setPrice(int price) {
//
//        specialCardPrice = price;
//
//    }
//
//    /**
//     * Setter method for card/item description.
//     * 
//     * @param description
//     *            card/item description.
//     */
//    public void setDescription(String description) {
//
//        specialCardDescription = description;
//
//    }
//
//    /**
//     * Method to update player inventory with item bought.
//     * 
//     * @param cart
//     *            HashMap holding items bought.
//     */
//    public void addSpecialCard(HashMap<String, Integer> cart) {
//
//        InventoryPrototype inventoryObj = new InventoryPrototype();
//        cart.put(getName(), getPrice());
//        inventoryObj.addItem(cart, getName());
//
//    }
//
//}
