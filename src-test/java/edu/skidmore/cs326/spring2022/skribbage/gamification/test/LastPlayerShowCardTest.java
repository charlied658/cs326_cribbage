//package edu.skidmore.cs326.spring2022.skribbage.gamification.test;
//
//import java.util.HashMap;
//
//import org.apache.log4j.Logger;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.LastPlayerShowCard;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCard;
//
///**
// * Unit tests for the LastPlayerShowCard class.
// * 
// * @author Muaded Almheiri
// */
//public class LastPlayerShowCardTest {
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
//        LOG = Logger.getLogger(LastPlayerShowCardTest.class);
//    }
//
//    /**
//     * Attribute to house the test instance.
//     */
//    private LastPlayerShowCard testInstance;
//
//    /**
//     * Create RebattleCard instance.
//     */
//    @Before
//    public void setup() {
//        LOG.info("Setup for test");
//        testInstance = new LastPlayerShowCard();
//    }
//
//    /**
//     * Test that if player has enough tokens and item is bought, player tokens
//     * is properly updated.
//     * TODO If item bought, test that item was sent to inventory.
//     */
//    @Test
//    public void testBuyItem() {
//
//        int playerTokensTest = 20;
//
//        testInstance.buyItem(playerTokensTest);
//        assertEquals(20, playerTokensTest);
//
//    }
//
//    /**
//     * Test that proper card name is returned and is not null.
//     */
//    @Test
//    public void testGetName() {
//
//        assertNotNull("Item name is null",
//            testInstance.getName());
//        assertEquals(SpecialCard.LASTPLAYERSHOWCARD.getType(),
//            testInstance.getName());
//    }
//
//    /**
//     * Test that correct price is returned when method is called.
//     */
//    @Test
//    public void testGetPrice() {
//        testInstance.setPrice(SpecialCard.LASTPLAYERSHOWCARD.getPrice());
//        assertEquals(SpecialCard.LASTPLAYERSHOWCARD.getPrice(),
//            testInstance.getPrice());
//    }
//
//    /**
//     * Test that proper card description is returned and is not null.
//     */
//    @Test
//    public void testGetDescription() {
//
//        assertNotNull("Item description is null",
//            testInstance.getDescription());
//        assertEquals(SpecialCard.LASTPLAYERSHOWCARD.getDescription(),
//            testInstance.getDescription());
//    }
//
//    /**
//     * Test that proper card name is set.
//     */
//    @Test
//    public void testSetName() {
//
//        testInstance.setName(SpecialCard.LASTPLAYERSHOWCARD.getType());
//        assertEquals(testInstance.getName(),
//            SpecialCard.LASTPLAYERSHOWCARD.getType());
//
//    }
//
//    /**
//     * Test that proper card price is set.
//     */
//    @Test
//    public void testSetPrice() {
//
//        testInstance.setPrice(SpecialCard.LASTPLAYERSHOWCARD.getPrice());
//        assertEquals(testInstance.getPrice(),
//            SpecialCard.LASTPLAYERSHOWCARD.getPrice());
//
//    }
//
//    /**
//     * Test that proper card description is set.
//     */
//    @Test
//    public void testSetDescription() {
//
//        testInstance
//            .setDescription(SpecialCard.LASTPLAYERSHOWCARD.getDescription());
//        assertEquals(testInstance.getDescription(),
//            SpecialCard.LASTPLAYERSHOWCARD.getDescription());
//
//    }
//
//    /**
//     * Test that inventory is properly updated.
//     */
//    @Test
//    public void testAddSpecialCard() {
//
//        HashMap<String, Integer> testMap = new HashMap<String, Integer>();
//        InventoryPrototype testInv = new InventoryPrototype();
//        testMap.put("testItem", 50);
//        testInstance.addSpecialCard(testMap);
//        assertEquals(50,
//            testInv.searchForItem(testMap, "testItem"));
//
//    }
//
//}
