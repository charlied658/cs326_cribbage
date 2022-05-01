//package edu.skidmore.cs326.spring2022.skribbage.gamification.test;
//
//import org.apache.log4j.Logger;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import edu.skidmore.cs326.spring2022.skribbage.common.Player;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.MarketPlaceManager;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCard;
//import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCardManager;
//
///**
// * Unit tests for the MarketPlaceManger class.
// * 
// * @author Muaded Almheiri
// */
//public class SpecialCardManagerTest {
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
//        LOG = Logger.getLogger(SpecialCardManagerTest.class);
//    }
//    
//    /**
//     * Attribute to house the test instance.
//     */
//    private SpecialCardManager testInstance;
//
//    /**
//     * Create SpecialCardManagerTest instance.
//     */
//    @Before
//    public void setup() {
//        LOG.info("Setup for test");
//        testInstance = new SpecialCardManager();
//    }
//
//    /**
//     * Test signalUse method.
//     */
//    @Test
//    public void testSignalUse() {
//        Player playerOne = new Player();
//        Player playerTwo = new Player();
//        testInstance.signalUse(SpecialCard.REBATTLECARD, Player playerOne, Player playerTwo);
//        assertEquals(24, playerTokensTest);
//
//    }
//
//}
