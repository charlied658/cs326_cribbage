package edu.skidmore.cs326.spring2022.skribbage.logic.test;
import static org.junit.Assert.assertTrue;
package edu.skidmore.cs326.spring2022.skribbage.logic;
import org.junit.Before;
import org.junit.Test;

//@author Michael Shriner
public class PeggingTest{

  private PeggingPlay pPlay;
  private Card c;
  private Player p;
  private Hand h;

  /**
   * Test scaffold set up. Creates the test instance.
   * note, this method runs before each test case
   */
  @Before
  public void setup() {
    pPlay = new PeggingPlay();
    p = new Player ();
    c = new Card('A', Suit.HEARTS);
    Hand h = p.getHand();
    h.addCardToHand(c);
    Game.initPeggingTotal();
    Game.setPonePeggingCards(new ArrayList<Card>());
    Game.setDealerPeggingCards(new ArrayList<Card>());
  }

  /**
   * Test the method to add a card to the pegging total.
   */
  @Test
  public void testAddCardToPeggingTotal() {

    //cases to check
    //p is not the dealer and the card can be added
    //p is the dealer and the card can be added
    //the card cannot be added
    //the card is added and removed from the player's hand
    //the card is not added and not removed from the player's hand

    //p is not the dealer
    p.isDealer = false;
    pPlay.addCardToPeggingTotal(c, p);
    //now, you have to add the card back to the player's hand
    //after you assert that the card was removed
    assertTrue(p.getHand().getHand().size() == 0);
    h.addCardToHand(c);
    //check the pegging total
    assertTrue(c.getPointValue() == Game.getPeggingTotal());

    //p is the dealer
    p.isDealer = true;
    Game.setPeggingTotal(0);
    pPlay.addCardToPeggingTotal(c, p);
    //now, you have to add the card back to the player's hand
    //after you assert that the card was removed
    assertTrue(p.getHand().getHand().size() == 0);
    h.addCardToHand(c);
    //check the pegging total
    assertTrue(c.getPointValue() == Game.getPeggingTotal());

    //the card cannot be added
    Game.setPeggingTotal(31);
    pPlay.addCardToPeggingTotal(c, p);
    //check that the card was not removed from the player's hand
    assertTrue(p.getHand().getHand().size() == 1);
    assertTrue((c.getPointValue() + 31) != Game.getPeggingTotal());

  }

  /**
   * Test the method check15.
   * If the player passed as a parameter placed a card during the pegging phase that
   * brought the pegging total to 15, the player is awarded 2 points. Otherwise, the
   * player is awarded no points.
   */
  @Test
  public void testCheck15() {

    //cases
    //the player is a dealer and placed a card that brought the pegging total to 15
    //the player is a pone and placed a card that brought the pegging total to 15
    //the player did not place a card to bring the pegging total to 15

    //the player is a dealer and placed a card that brought the pegging total to 15
    p.isDealer = true;
    Game.setPeggingTotal(14);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() == 2);

    //reset player's hand
    h.addCardToHand(c);

    //reset peggingCards for dealer and pone
    Game.setPonePeggingCards(new ArrayList<Card>());
    Game.setDealerPeggingCards(new ArrayList<Card>());

    //the player is a pone and placed a card that brought the pegging total to 15
    //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    p.isDealer = false;
    Game.setPeggingTotal(14);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() == 2);

    //reset player's hand
    h.addCardToHand(c);

    //reset peggingCards for dealer and pone
    Game.setPonePeggingCards(new ArrayList<Card>());
    Game.setDealerPeggingCards(new ArrayList<Card>());

    //the player did not place a card to bring the pegging total to 15
    //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    Game.setPeggingTotal(0);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() != 2);
  }

  /**
   * Test the method check31.
   * If the player passed as a parameter placed a card during the pegging phase that
   * brought the pegging total to 31, the player is awarded 2 points. Otherwise, the
   * player is awarded no points.
   */
  @Test
  public void testCheck31() {

    //cases
    //the player is a dealer and placed a card that brought the pegging total to 31
    //the player is a pone and placed a card that brought the pegging total to 31
    //the player did not place a card to bring the pegging total to 31

    //the player is a dealer and placed a card that brought the pegging total to 31
    p.isDealer = true;
    Game.setPeggingTotal(30);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() == 2);

    //reset player's hand
    h.addCardToHand(c);

    //reset peggingCards for dealer and pone
    Game.setPonePeggingCards(new ArrayList<Card>());
    Game.setDealerPeggingCards(new ArrayList<Card>());


    //the player is a pone and placed a card that brought the pegging total to 31
    //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    p.isDealer = false;
    Game.setPeggingTotal(30);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() == 2);

    //reset player's hand
    h.addCardToHand(c);

    //reset peggingCards for dealer and pone
    Game.setPonePeggingCards(new ArrayList<Card>());
    Game.setDealerPeggingCards(new ArrayList<Card>());

    //the player did not place a card to bring the pegging total to 31
    //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    Game.setPeggingTotal(0);
    pPlay.addCardToPeggingTotal(c, p);
    assertTrue(Player.getPoints() != 2);
  }

  @Test
  public void testIsPair{
    //cases
    //the method returns true if the cards in the list have the same identifier
    //the method returns false if the cards in the list don't have the same identifier
    ArrayList <Card> cardList = new ArrayList <Card> ();
    Card c1 = new Card ('A', Suit.HEARTS);
    Card c2 = new Card ('A', Suit.DIAMONDS);
    Card c3 = new Card ('A', Suit.CLUBS);
    Card c4 = new Card ('Q', Suit.HEARTS);

    //case: no cards in list
    assertTrue(Game.isPair(cardList) == false);

    //case: 1 card in list
    cardList.add(c1);
    assertTrue(Game.isPair(cardList) == false);

    //case: 2 cards in list that have same identifier
    cardList.add(c2);
    assertTrue(Game.isPair(cardList));

    //case: 3 cards in list that have same identifier
    cardList.add(c3);
    assertTrue(Game.isPair(cardList));

    //case: 4 cards in list where one does not have same identifier
    cardList.add(c4);
    assertTrue(Game.isPair(cardList) == false);

    //case: 2 cards in list where one does not have same identifier
    cardList.removeAll();
    cardList.add(c1);
    cardList.add(c4);
    assertTrue(Game.isPair(cardList) == false);

  }

  @Test
  public void checkPair(){
    
  }



}//end of class
