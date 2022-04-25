package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;

/**
 * Unit tests for the Inventory class.
 *
 * @author Indra Irvin
 */
public class InventoryPrototypeTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(InventoryPrototypeTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private InventoryPrototype testInstance;
    
    /**
     * Instance for a player.
     */
    private Player player = new Player();

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = player.getInventoryManager();
    }

    /**
     * Test that once once updated the inventory is filled.
     */
    @Test
    public void testUpdateInventory() {
        //HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory();
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("Mirror") == 1);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("Re-Battle") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("LastPlayerShowCard") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("autoPilot") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("copyCat") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("Copy") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("PickPocket") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("Disarm") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("ThrowAwayPickUp") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem("Swap-Card") == 0);
    }

    /**
     * Test search function.
     */
    @Test
    public void testAvatarAssignment() {
        //HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory();
        assertTrue("Avatar not assigned to player properly",
            testInstance.searchForItem("Mirror") == 1);
    }

    /**
     * Test that an item can be removed from the Inventory.
     */
    @Test
    public void testUsingItem() {
        //HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory();
        testInstance.useItem("Mirror");
        assertTrue("Item was not used",
            testInstance.searchForItem("Mirror") == 0);
    }

    /**
     * Test that an item can be added to the Inventory.
     */
    @Test
    public void testAddingItem() {
        //HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory();
        testInstance.addItem("Mirror", 1);
        assertTrue("Item was not added",
            testInstance.searchForItem("Mirror") == 2);
    }

}
