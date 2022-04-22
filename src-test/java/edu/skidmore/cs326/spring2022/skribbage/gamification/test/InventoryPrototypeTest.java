package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

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
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new InventoryPrototype();
    }

    /**
     * Test that once once updated the inventory is filled.
     */
    @Test
    public void testUpdateInventory() {
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory(inventory);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "Mirror") == 1);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "Re-Battle") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "LastPlayerShowCard") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "autoPilot") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "copyCat") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "Copy") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "PickPocket") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "Disarm") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "ThrowAwayPickUp") == 0);
        assertTrue("Inventory is still empty",
            testInstance.searchForItem(inventory, "Swap-Card") == 0);
    }

    /**
     * Test search function.
     */
    @Test
    public void testAvatarAssignment() {
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory(inventory);
        assertTrue("Avatar not assigned to player properly",
            testInstance.searchForItem(inventory, "Mirror") == 1);
    }

    /**
     * Test that an item can be removed from the Inventory.
     */
    @Test
    public void testUsingItem() {
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory(inventory);
        testInstance.useItem(inventory, "Mirror");
        assertTrue("Item was not used",
            testInstance.searchForItem(inventory, "Mirror") == 0);
    }

    /**
     * Test that an item can be added to the Inventory.
     */
    @Test
    public void testAddingItem() {
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        testInstance.updateInventory(inventory);
        testInstance.addItem(inventory, "Mirror");
        assertTrue("Item was not added",
            testInstance.searchForItem(inventory, "Mirror") == 2);
    }

}
