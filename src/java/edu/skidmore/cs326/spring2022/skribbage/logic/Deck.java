import java.util.ArrayList;
import java.util.Random;

public class Deck {
/**
 * @author kpolite
 *
 * Attributes:
 * Card Object
 * ArrayList of Cards
 *
 * Methods:
 * constructor
 * Void Shuffle()
 * Card Cut()
 * Deck getDeck()
 * Card RemoveTopCard()
 */
	ArrayList<Card> theDeck;
	Suit[] theSuits= {HEARTS, DIAMONDS, CLUBS, SPADES};

	public Deck() {
		//Initializes the deck

		//Attributes
		theDeck = new ArrayList<Card>();

		//Card adding loops
		for (int suit = 0; suit <= 3; suit++) {//changes the suit of the added card

			theDeck.add(new Card(theSuits[suit], 'A')); //adds an Ace

			for (int card = 2; card <= 10; card++) {//adds cards 2-10

			}//end numbered card loop

			theDeck.add(new Card(theSuits[suit], 'J')); //adds an Jack

			theDeck.add(new Card(theSuits[suit], 'Q')); //adds an Queen

			theDeck.add(new Card(theSuits[suit], 'K')); //adds an King

		}//end suit loop



	}//end public Deck

	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		Random randNumGen = new Random();

		for(int i = 0; i <= 52; i++) {
			int randomInt = randNumGen.nextInt(theDeck.size());
			tempDeck.add(theDeck[randomInt]);
			theDeck.remove(randomInt);
		}//end for loop

		theDeck = tempDeck;

	}//end shuffle

	public Card cut(int whereToCut){
		return theDeck[whereToCut];
	}//end Cut

	public Deck getDeck() {
		return theDeck;
	}//end getDeck

	public Card removeTopCard() {
		Card tempCard = theDeck[0];
		theDeck.remove(0);
		return tempCard;
	}//end removeTopCard

	public void moveToTop(int whatCardToMove) {
		Card tempCard = theDeck[whatCardToMove + 1];
		theDeck.remove(whatCardToMove);
		theDeck.add(0, tempCard);
	}


}//end Deck Class
