// package edu.skidmore.cs326.spring2022.skribbage.logic;
// import java.util.ArrayList;
// import java.util.Random;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
//
// public class Deck {
// /**
//  * @author kpolite
//  *
//  * Attributes:
//  * Card Object
//  * ArrayList of Cards
//  *
//  * Methods:
//  * constructor
//  * Void shuffle()
//  * Card cut()
//  * Deck getDeck()
//  * Card removeTopCard()
//  * Card moveToTop()
//  */
// 	private ArrayList<Card> theDeck;
// 	Suit[] theSuits= {Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS, Suit.SPADES};
//
// 	public Deck() {
// 		//Initializes the deck
//
// 		//Attributes
// 		theDeck = new ArrayList<Card>();
//
// 		//Card adding loops
// 		for (int suit = 0; suit <= 3; suit++) {//changes the suit of the added card
//
// 			theDeck.add(new Card('A', theSuits[suit])); //adds an Ace
//
// 			for (int card = 2; card <= 10; card++) {//adds cards 2-10
//
// 			}//end numbered card loop
//
// 			theDeck.add(new Card('J', theSuits[suit])); //adds an Jack
//
// 			theDeck.add(new Card('Q', theSuits[suit])); //adds an Queen
//
// 			theDeck.add(new Card('K', theSuits[suit])); //adds an King
//
// 		}//end suit loop
//
//
//
// 	}//end public Deck
//
// 	public ArrayList<Card> shuffle() {
// 		ArrayList<Card> tempDeck = new ArrayList<Card>();
// 		Random randNumGen = new Random();
//
// 		for(int i = 0; i <= 52; i++) {
// 			int randomInt = randNumGen.nextInt(theDeck.size());
// 			tempDeck.add(theDeck.get(randomInt));
// 			theDeck.remove(randomInt);
// 		}//end for loop
//
// 		theDeck = tempDeck;
// 		return theDeck;
// 	}//end shuffle
//
// 	public Card cut(int whereToCut){
// 		return theDeck.get(whereToCut);
// 	}//end Cut
//
// 	public ArrayList<Card> getDeck() {
// 		return theDeck;
// 	}//end getDeck
//
// 	public Card removeTopCard() {
// 		Card tempCard = theDeck.get(0);
// 		theDeck.remove(0);
// 		return tempCard;
// 	}//end removeTopCard
//
// 	public Card moveToTop(int whatCardToMove) {
// 		Card tempCard = theDeck.get(whatCardToMove + 1);
// 		theDeck.remove(whatCardToMove + 1);
// 		theDeck.add(0, tempCard);
//     return tempCard;
// 	}
//
//
// }//end Deck Class
