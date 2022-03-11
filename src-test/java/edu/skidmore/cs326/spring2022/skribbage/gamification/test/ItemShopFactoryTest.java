package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.ItemShopFactory;
import edu.skidmore.cs326.spring2022.skribbage.gamification.ReBattleCard;
import edu.skidmore.cs326.spring2022.skribbage.gamification.StoreItems;
import edu.skidmore.cs326.spring2022.skribbage.gamification.ItemShopInterface;

/**
* Unit tests for the ReBattleCard class.
*/
public class ItemShopFactoryTest {

   /**
    * Logger for the class.
    */
   private static final Logger LOG;

   /**
    * Create static resources.
    */
   static {
       LOG = Logger.getLogger(ItemShopFactoryTest.class);
   }

   /**
    * Attribute to house the test instance.
    */
   private ItemShopFactory testInstance;

   /**
    * Create ItemShopFactory instance.
    */
   @Before
   public void setup() {
       LOG.info("Setup for test");
       testInstance = new ItemShopFactory();
   }

   /**
    * Test that object being created is of the right concrete class.
    */
   @Test
   public void testCreateItem() {

   	ReBattleCard expected = new ReBattleCard();

   	assertEquals(expected ,
   			testInstance.createItem("Re-Battle Card"));


   }



}
