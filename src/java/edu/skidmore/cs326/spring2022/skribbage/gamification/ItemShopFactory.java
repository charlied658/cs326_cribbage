package edu.skidmore.cs326.spring2022.skribbage.gamification;

import org.apache.log4j.Logger;

/**
 * Factory class to create objects based on item/card name.
 * TODO revisit after approving cards/items and building logic of each item.
 * 
 * @author Muaded Almheiri
 */
public class ItemShopFactory {


 /**
  * Logger for the class.
  */
 private static final Logger LOG;

 /**
  * Create static resources.
  */
 static {
    LOG = Logger.getLogger(ItemShopFactory.class);
   }

 /**
  * Factory method to instantiate item.
  * TODO After setting up special cards/items logic, revisit method to return correct class objects. Maybe consider an Abstract factory
  * @param  item [Name of special card of item]
  * @return  [new Object of type ReBattleCard]
  */
 public ItemShopInterface createItem(String item) {
        
    switch(item) {
      
      case "Re-Battle Card":
          LOG.info("Returning new Re-Battle Card.");
          return new ReBattleCard();

      case "Last-Player-Show Card":
          LOG.info("Returning new Last-Player-Show Card.");
          return new LastPlayerShowCard();

    }
    
    return null;
  
 }

    
}
