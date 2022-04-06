package edu.skidmore.cs326.spring2022.skribbage.gamification;

<<<<<<< HEAD
=======
import org.apache.log4j.Logger;

>>>>>>> d958264d8ed289e71237f09ac44320b11d99edf8
import java.util.HashMap;


import org.apache.log4j.Logger;

/**
 * Prototype for each special card and item in the shop.
 * 
 * @author Muaded Almheiri
 *
 */
public class ReBattleCard implements ItemShopInterface {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(ReBattleCard.class);
    }
    
   /**
    * Hash map to hold items bought before being updated to inventory.
    */
    private HashMap<String, Integer> cart = new HashMap<String, Integer>();

    /**
     * String variable to hold card/item name.
     */
    private String specialCardName;

    /**
     * Integer variable to hold card/item token price.
     */
    private int specialCardPrice;

    /**
     * String variable to hold card/item description.
     */
    private String specialCardDescription;

    /**
     * ReBattleCard constructor.
     */
    public ReBattleCard() {
        LOG.info("Creating new Re-battle card");

        /* Set card name, price, and description. */
        setName("Re-Battle Card");
        setPrice(25);
        setDescription("Use this card to get another chance of "
            + "battling opponent after a battle.");
        setDescription(
            "Use this card to get another chance of battling "
            + "opponent after a battle.");

        LOG.info("Name, price, and description set for Re-battle card.");

        boolean isEntry = false;
   
        /*
         * Loop through Hash map to check if card already exists in item shop.
         */
        for (HashMap.Entry<String, Integer> entry : STORE_ITEMS.entrySet()) {

            if (entry.getKey().equals(getName())) {

                /* Card already in store. */
                isEntry = true;
            }
        }
        /* Card is not in store, place in store with value. */
        if (!isEntry) {
            STORE_ITEMS.put(getName(), getPrice());
            LOG.info("Re-battle card placed in store with value 25");
        }

    }


    /**
     * Buy's card at given price based on amount of tokens held by player.
     * TODO If item bought, update player inventory and tokens.
     */
    @Override
    public void buyItem(int playerTokens) {

        if (getPrice() <= playerTokens) {
            LOG.info("Re-battle card bought for 25 tokens");
            playerTokens -= getPrice();
            LOG.info("25 Tokens subtracted from player's tokens.");
            System.out.println(getName() + " bought at price " + getPrice()
                + ". Player now holds " + playerTokens);
            addItemToInventory(cart);
        } else {
            LOG.info("Not enough tokens to buy a Re-battle card.");
            System.out.println("Not enough tokens to buy " + getName());
        }
    }

    /**
     * Getter method for special card/item name.
     * 
     * @return special card/item name
     */
    @Override
    public String getName() {

        LOG.info("Returning card name.");
        return specialCardName;
    }

    /**
     * Getter method for special card/item token price.
     * 
     * @return item token price
     */
    @Override
    public int getPrice() {

        LOG.info("Returning card price.");
        return specialCardPrice;
    }

    /**
     * Getter method for special card/item description.
     * 
     * @return special card/item description/use.
     */
    @Override
    public String getDescription() {

        LOG.info("Returning card description.");
        return specialCardDescription;

    }
  
  /**
   * Setter method for card/item name.
   * @param name card/item name.
   */
    public void setName(String name) {
      
        specialCardName = name;
      
    }
  
  /**
   * Setter method for card/item price.
   * @param price card/item price
   */
    public void setPrice(int price) {
      
        specialCardPrice = price;
      
    }
  
  /**
   * Setter method for card/item description.
   * @param description card/item description.
   */
    public void setDescription(String description) {
      
        specialCardDescription = description;
      
    }
    
    /**
     * Method to update player inventory with item bought.
     * @param cart HashMap holding items bought.
     */
    public void addItemToInventory(HashMap<String, Integer> cart) {
      
      InventoryPrototype inventoryObj = new InventoryPrototype();
      cart.put(getName(), getPrice());
      inventoryObj.addItem(cart, getName());
    
    }
    

}
