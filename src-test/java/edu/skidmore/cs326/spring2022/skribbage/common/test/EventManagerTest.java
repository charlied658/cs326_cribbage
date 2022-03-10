package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;

/**
 * 
 * @author Sten Leinasaar
 *
 */
public class EventManagerTest {
	/**
	 * Logger to keep track of the order of events happening in this test class.
	 * Includes static block to initialize a Logger.
	 */
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(EventManagerTest.class);
	}
 
	private EventManager testInstance;

	/**
	 * @BEFORE 
	 * 
	 * TO set up necessary objects and variables that will be used during testing. 
	 * Runs before each test method is run.
	 */
	@Before
	public void setUp() {
		testInstance = EventManager.getInstance();
		
		
		LOG.info("SetUp method completed");
	}
	
	/**
	 * Test method to test the eager singelton instance. 
	 */
	@Test
	public void testGetInstance() {
		LOG.info("Beginning the testGetInstance");
		assertEquals(testInstance, EventManager.getInstance());
		LOG.info("testGetInstance completed");
	}
	
	/**
	 * Test case to test addPropertChangeListener method. 
	 * This test ensures that PropertyChangeListener is added to the list of propertyChangeListeners. 
	 * It is verified by checking if notify fires an update.
	 */
	@Test
	public void testAddPropertyChangeListener() {
		LOG.info("Beginning to test addPropertyChangeListener");
	}
	
	/**
	 * Test case to test if PropertyChangeListener was removed correctly.
	 */
	@Test
	public void testRemovePropertyChangeListener() {
		LOG.info("Beginning to test removePropertyChangeListener");
	}
	/**
	 * Test case to notify all the added PropertyChangeListeners.
	 */
	@Test
	public void testNotify() {
		LOG.info("Began testing notify method");
	}
	
	/**
	 * @AFTER method that runs after each test case. 
	 * 
	 * Currently created just in case some tearDown is needed
	 */
	@After
	public void tearDown() {
		
	}
	
	
}
