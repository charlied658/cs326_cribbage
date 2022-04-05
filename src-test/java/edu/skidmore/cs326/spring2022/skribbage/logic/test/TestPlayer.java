
package edu.skidmore.cs326.spring2022.skribbage.logic.test;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Before;
import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;


public class TestPlayer {
	/**
	 * Tests for the player class instance for the
	 */
	private Player testInstance ;
	/**
	 * Card instance to refer to methods in the card class
	 */
	public Card c;
	/**
	 * Hand instance to refer to methods in the hand class
	 */
	public Hand h;
	
	/**
	 * Setup for the Player testing
	 */
	@Before
	public void setup(){
		testInstance = new Player();
		testInstance.setName("abby");
		c = new Card('J', Suit.HEARTS);
		h.addCardToHand(c);
		testInstance.setHand(h);
		testInstance.initializePoints(0);
		testInstance.addPoints(2);
		testInstance.getPoints(2);
	}
	
	/**
	 * Test getName method
	 */
	@Test
	public void testGetName() {
		assertEquals("abby",testInstance.getName());
	}
	/**
	 * Test setHand method
	 */
	@Test
	public void testSetHand() {
		assertEquals(h, testInstance.setHand());
	}
	/**
	 * Test addPoints method
	 */
	public void testAddPoints() {
		assertEquals(2, testInstance.addPoints());
	}
	/**
	 * Test getPoints method 
	 */
	public void testGetPoints() {
		assertEquals(2, testInstance.getPoints());
	}
	/**
	 * test intitalizePoints method 
	 */
	public void initializePoints() {
		assertEquals(0, testInstance.initializePoints());
	}

}
