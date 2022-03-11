//package edu.skidmore.cs326.spring2022.skribbage.gamification.test;
//
//import static org.junit.Assert.assertTrue;
//
//import org.apache.log4j.Logger;
//
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import edu.skidmore.cs326.spring2022.skribbage.gamification.ReBattleCard;
//
///**
// * Unit tests for the ReBattleCard class.
// */
//public class ReBattleCardTest {
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
//        LOG = Logger.getLogger(ReBattleCardTest.class);
//    }
//
//    /**
//     * Attribute to house the test instance.
//     */
//    private ReBattleCard testInstance;
//
//    /**
//     * Create RebattleCard instance.
//     */
//    @Before
//    public void setup() {
//        LOG.info("Setup for test");
//        testInstance = new ReBattleCard();
//    }
//
//    /**
//     * Test that message and is printed correctly when method is called.
//     */
//    @Test
//    public void testGetItemInfo() {
//        assertNotNull("Item info message is null",
//            testInstance.getItemInfo());
//        assertEquals("Card/Item: " + testInstance.getName() + "\nPrice: " + testInstance.getPrice() + "\nDescription: " + testInstance.getDescription(),
//            testInstance.getItemInfo());
//    }
//    
//    /**
//     * Test that if player has enough tokens and item is bought, player tokens is properly updated.
//     * TODO If item bought, test that item was sent to inventory.
//     */
//    @Test
//    public void testBuyItem() {
//    	
//    	int playerTokensTest = 50;
//    	
//    	testInstance.buyItem(playerTokensTest);
//    	assertEquals(50 - testInstance.getPrice(), playerTokensTest);
//    	
//    	playerTokensTest = 24;
//    	
//    	testInstance.buyItem(playerTokensTest);
//    	assertEquals(24, playerTokensTest);
//    	
//    }
//    
//    /**
//     * Test that proper card name is returned and is not null.
//     */
//    @Test
//    public void testGetName() {
//    	
//    	assertNotNull("Item name is null",
//    	        testInstance.getName());
//    	assertEquals("Re-Battle Card", 
//    			testInstance.getName());
//    }
//    
//    /**
//     * Test that correct price is returned when method is called.
//     */
//    @Test
//    public void testGetPrice() {
//    	
//    	assertEquals("25", testInstance.getPrice());
//    }
//    
//    /**
//     * Test that proper card description is returned and is not null.
//     */
//    @Test
//    public void testGetDescription() {
//    	
//    	assertNotNull("Item description is null",
//    	        testInstance.getDescription());
//    	assertEquals("Use this card to get another chance of battling opponent after a battle.", 
//    			testInstance.getDescription());
//    }
//    	
//    	
//}
