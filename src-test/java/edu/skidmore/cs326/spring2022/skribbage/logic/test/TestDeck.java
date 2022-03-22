//package edu.skidmore.cs326.spring2022.skribbage.logic.test;
//
//import java.util.ArrayList;
//
//import edu.skidmore.cs326.spring2022.skribbage.logic.Deck;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;
//
//public class TestDeck {
//
//    private Deck testInstance;
//
//    private Deck testInstanceOrdered;
//
//    @Before
//    public void setup() {
//        testInstance = new Deck();
//        testInstanceOrdered = new Deck();
//    }// end setup
//
//    @Test
//    public void testOne() {
//        // test 1 deck constructor
//        // see if there's 52 cards
//        assertNotNull(testInstance);
//        assertEquals(testInstance.getDeck().size(), 52);
//
//    }// end testOne
//
//    @Test
//    public void testTwo() {
//        // test 2 shuffle
//        // see if cards are in random order
//        assertNotEquals(testInstance.shuffle(), testInstanceOrdered);
//
//    }// end testTwo
//
//    @Test
//    public void testThree() {
//        // test 3 cut
//        // make sure the returned card is the card of choice
//        assertEquals(testInstance.cut(20), testInstance.getDeck().get(20));
//    }// end testThree
//
//    @Test
//    public void testFour() {
//        // test 4 getDeck
//        // print the order of both decks and make sure they're the same
//
//    }// end testFour
//
//    @Test
//    public void testFive() {
//        // test 5 remove top card
//        // print the size and order, make sure the top card is BANISHED
//
//    }// end testFive
//
//    @Test
//    public void testSix() {
//        // test 6 move to top
//        // make sure the chosen card is in the correct place
//        assertEquals(testInstance.moveToTop(20), testInstance.getDeck().get(0));
//    }// end testSix
//
//}// end class TestDeck
