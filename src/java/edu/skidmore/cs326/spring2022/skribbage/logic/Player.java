
import java.util.ArrayList;

import java.util.Random;

/**
 * @author lappiaha
 */
public class Player {
	boolean isDealer;
	String pone;
	String dealer;
	int points = 0; 

	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Card> withdrawn = new ArrayList<Card>();
	private Hand hand = new Hand();
	private Deck thedeck = new Deck();
	


	public Player() {
	//initializes the player 
		
	//initializes the deck
		this.thedeck = new Deck();
	
	}
/**
 * Get the name of the player
 * 
 */
	public void getName() {
		//need info from frontEnd 
		//		player1 = name1.getName();
		//		player2 = name2.getName();
		//claims the player name 
	}
/**
 * Set the name of the player
 * 
 */
	public void setName() {
		
	}
	public void setHand(Hand playerHand) {

//		thedeck.removeTopCard();
		hand = playerHand ; 

	}

/**
 * Get the hand
 * @return hand
 *  
 */
	public Hand getHand() {
		return hand;
	}



//	public void CountPoints() {
//		points act as counter
//		boolean is3OAK;
//		boolean ispair;
//		//get deck
//		//count player points
//
//		//pairs
//		ArrayList<Card> firsttwo = new ArrayList<Card>(hand.getHand().subList(0, 1));
//		for(int i=0; i < firsttwo.size(); i++) {
//			if(firsttwo.get(i).getIdentifier()==(firsttwo.get(i+1).getIdentifier())) {
//				ispair = true;
//			}
//		}
//
//		ArrayList<Card> secondtwo = new ArrayList<Card>(hand.getHand().subList(1, 2));
//		for(int i=0; i < secondtwo.size(); i++) {
//			if(secondtwo.get(i).getIdentifier()==(secondtwo.get(i+1).getIdentifier())) {
//				ispair = true;
//			}
//		}
//
//		ArrayList<Card> middletwo = new ArrayList<Card>(hand.getHand().subList(2, 3));
//		for(int i=0 ; i < middletwo.size(); i++) {
//			if(middletwo.get(i).getIdentifier()==(middletwo.get(i+1).getIdentifier())) {
//				ispair = true;
//			}
//		}
//		ArrayList<Card> lasttwo = new ArrayList<Card>(hand.getHand().subList(2, 3));
//		for(int i=0 ; i < lasttwo.size(); i++) {
//			if(lasttwo.get(i).getIdentifier()==(lasttwo.get(i+1).getIdentifier())) {
//				ispair = true;
//			}
//		}
//
//		if(ispair = true) {
//			points += 2;
//		}
//
//
//
//		//3OAK
//		ArrayList<Card> firstthree = new ArrayList<Card>(hand.getHand().subList(0, 2));
//
//		for(int i=0; i < firstthree.size(); i++) {
//			if(firstthree.get(i).getIdentifier()==(firstthree.get(i+1).getIdentifier())) {
//				is3OAK = true;
//			}
//
//		}
//
//		ArrayList<Card> middlethree = new ArrayList<Card>(hand.getHand().subList(1, 3));
//
//		for(int i=0; i < middlethree.size(); i++) {
//			if(middlethree.get(i).getIdentifier()==(middlethree.get(i+1).getIdentifier())) {
//				is3OAK = true;
//			}
//		}
//
//		ArrayList<Card> lastthree = new ArrayList<Card>(hand.getHand().subList(2, 4));
//
//		for(int i=0; i < lastthree.size(); i++) {
//			if(lastthree.get(i).getIdentifier()==(lastthree.get(i+1).getIdentifier())) {
//				is3OAK = true;
//			}
//		}
//
//		if(is3OAK = true) {
//			points += 6;
//		}

		//Straights/Runs
		//Run of Three
		//		boolean isstraight;
		//		ArrayList<Cards> firstthreecards = new ArrayList<Card>(cards.subList(0, 2));
		//
		//
		//		for(int i=0; i < firstthreecards.size(); i++) {
		//			if(firstthreecards.getPointValue(i).equals(firstthreecards.getPointValue(i+1)+1) && firstthreecards.getPointValue(i) != 9||8 ) {
		//				isstraight = true;
		//			}
		//
		//		}
		//
		//		ArrayList<Cards> middlethreecards = new ArrayList<Card>(cards.subList(1, 3));
		//
		//
		//		for(int i=0; i < middlethreecards.size(); i++) {
		//			if(middlethreecards.getPointValue(i).equals(middlethreecards.getPointValue(i+1)+1) && middlethreecards.getPointValue(i) != 9||8 ) {
		//				isstraight = true;
		//			}
		//
		//		}
		//		ArrayList<Cards> lastthreecards = new ArrayList<Card>(cards.subList(1, 3));
		//
		//
		//		for(int i=0; i < lastthreecards.size(); i++) {
		//			if(lastthreecards.getPointValue(i).equals(lastthreecards.getPointValue(i+1)+1) && lastthreecards.getPointValue(i) != 9||8 ) {
		//				isstraight = true;
		//			}
		//
		//		}	
		//		
		//		//starting with the #8
		//		
		//		ArrayList<Cards> firstis8 = new ArrayList<Card>(cards.subList(0, 2));
		//
		//
		//		for(int i=0; i < firstis8.size(); i++) {
		//			if(firstis8.getPointValue(i).equals(firstis8.getPointValue(i+1)+1) && firstis8.getPointValue(i) == 8 && firstis8.getCardIdentifier(2) == JACK ) {
		//				isstraight = true;
		//			}
		//
		//		}	
		//
		//		ArrayList<Cards> firstis8 = new ArrayList<Card>(cards.subList(1, 3));
		//
		//
		//		for(int i=0; i < firstis8.size(); i++) {
		//			if(firstis8.getPointValue(i).equals(firstis8.getPointValue(i+1)+1) && firstis8.getPointValue(i) == 8 && firstis8.getCardIdentifier(2) == JACK ) {
		//				isstraight = true;
		//			}
		//
		//		}	


		//Total of 15
		//Go
	//}
	
/**
 * Get the player points	
 * @return points
 * 
 */
	
	public int getPoints() {
		return points;
	}
/**
 * Add the player points 
 * @param pointsToAdd
 * 
 */
	public void addPoints(int pointsToAdd) {
		points += pointsToAdd;

	}
	

}
