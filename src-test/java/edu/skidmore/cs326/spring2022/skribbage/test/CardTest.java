import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;

/**
* Unit tests for the Card class
* @author Declan Morris
*/
public class CardTest{

  /**
  * Attribute to house the test instance.
  */
  private Card testInstance;

  /**
  * Test scaffold set up. Creates the test instance.
  */
  @Before
  public void setup() {
      testInstance = new Card('J', Suit.HEARTS);
  }

  /**
  * Test that the setSuit method worked as expected during the constructor call
  */
  @Test
  public void testSetSuit() {
      assertEqual(Suit.HEARTS, testInstance.getSuit());
  }

  /**
  * Test that the setIdentifier method worked as expected during the constructor call
  */
  @Test
  public void testSetIdentifier() {
    assertEqual('J', testInstance.getIdentifier());
  }
}
