


public class PeggingTest{

  /**
   * Attribute to house the test instance.
   */
  private PeggingPlay pPlay;

  /**
   * Test scaffold set up. Creates the test instance.
   */
  @Before
  public void setup() {
    pPlay = new PeggingPlay();
    //need to setup Game.java
    Game.initPeggingTotal();
  }

  /**
   * Test the method to add a card to hand.
   */
  @Test
  public void testAddCardToPeggingTotal() {
    Card c = new Card('A', Suit.HEARTS);
    Player p = new Player ();
    Hand h = p.getHand();
    h.addCardToHand(c);

    //cases
    //p is not the dealer and the card can be added
    //p is the dealer and the card can be added
    //the card cannot be added

    //p is not the dealer
    p.isDealer = false;
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(c.getPointValue() == Game.getPeggingTotal());

    //p is the dealer
    p.isDealer = true;
    Game.setPeggingTotal(0);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(c.getPointValue() == Game.getPeggingTotal());

    //the card cannot be added
    Game.setPeggingTotal(31);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue((c.getPointValue() + 31) != Game.getPeggingTotal());

  }

}
