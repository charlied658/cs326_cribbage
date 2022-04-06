
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//import org.apache.log4j.Logger;
//import org.junit.Before;
//
//public class TestPlayer {
//	/**
//	 * Tests for the player class instance for the
//	 */
//	private Player testInstance;
//	/**
//	 * 	Logger for the class
//	 */
//	private static final Logger LOG;
//	/**
//	 * Create static resources.
//	 */
//	static {
//		LOG = Logger.getLogger(HandTest.class);
//	}
//	/**
//	 * 
//	 */
//	@Before
//	public void setup(){
//		testInstance = new Player();
//	}
//
//	@Test
//	public void testAddPoints() {
//		int points = 2;
//		int pointstoadd = 5;
//		points += pointstoadd;
//	}
//}
package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.logic.Player;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Before;

public class TestPlayer {
    /**
     * Tests for the player class instance for the.
     */
    private Player testInstance;

    /**
     * Logger for the class.
     */
    private static final Logger LOG;
    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(TestPlayer.class);
    }

    /**
     * 
     */
    @Before
    public void setup() {
        testInstance = new Player();
    }

    @Test
    public void testAddPoints() {
        int points = 2;
        int pointstoadd = 5;
        points += pointstoadd;
    }
}
