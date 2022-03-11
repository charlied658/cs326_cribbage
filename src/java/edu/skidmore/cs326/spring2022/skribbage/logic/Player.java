import java.util.ArrayList;
import java.util.Random;

/**
 * @author lappiaha
 */
public class Player {
	boolean isDealer;
	String player1;
	String player2;
	private ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Card> dealfive = new ArrayList<Card>();


	public Player() {
		//		//Assuming that he cut happened already
		//		if (PlayerCard.getpointValue() > OpponentCard.getpointValue()) {
		//			isDealer = true;
		//		}
		//		else {
		//			isDealer = false;
		//		}
	}

	public void ClaimName() {
		//		player1 = name1.getName();
		//		player2 = name2.getName();
		//claims the player name 
	}

	public void setHand() {
		Random rand = new Random();

		for(int i = 0; i < cards.size(); i++) {
			i = rand.nextInt(0, cards.size());
			dealfive.add(cards.get(i));
			dealfive.add(cards.get(i));
			dealfive.add(cards.get(i));
			dealfive.add(cards.get(i));
			dealfive.add(cards.get(i));
			cards.remove(i);
		}

	}


public ArrayList<Card> getHand() {
	return dealfive;
}



public void CountPoints() {
	//points act as counter
	int points; 
	boolean is3OAK;
	boolean ispair;
	//get deck
	//count player points

	//pairs
	ArrayList<Card> firsttwo = new ArrayList<Card>(dealfive.subList(0, 1));
	for(int i=0; i < firsttwo.size(); i++) {
		if(firsttwo.getIdentifier().equals(firsttwo.get(i).getIdentifier())) {
			ispair = true;
		}
	}

	ArrayList<Card> secondtwo = new ArrayList<Card>(dealfive.subList(1, 2));
	for(int i=0; i < secondtwo.size(); i++) {
		if(secondtwo.getIdentifier(i).equals(getIdentifier(i+1))) {
			ispair = true;
		}
	}

	ArrayList<Card> middletwo = new ArrayList<Card>(dealfive.subList(2, 3));
	for(int i=0 ; i < middletwo.size(); i++) {
		if(middletwo.getIdentifier(i).equals(middletwo.getIdentifier(i+1))) {
			ispair = true;
		}
	}
	ArrayList<Card> lasttwo = new ArrayList<Card>(dealfive.subList(2, 3));
	for(int i=0 ; i < lasttwo.size(); i++) {
		if(lasttwo.getIdentifier(i).equals(lasttwo.getIdentifier(i+1))) {
			ispair = true;
		}
	}

	if(ispair = true) {
		points += 2;
	}



	//3OAK
	ArrayList<Card> firstthree = new ArrayList<Card>(dealfive.subList(0, 2));

	for(int i=0; i < firstthree.size(); i++) {
		if(firstthree.getCardIdentifier(i).equals(firstthree.getCardIdentifier(i+1))) {
			is3OAK = true;
		}

	}

	ArrayList<Card> middlethree = new ArrayList<Card>(dealfive.subList(1, 3));

	for(int i=0; i < middlethree.size(); i++) {
		if(middlethree.getCardIdentifier(i).equals(middlethree.getCardIdentifier(i+1))) {
			is3OAK = true;
		}
	}

	ArrayList<Card> lastthree = new ArrayList<Card>(dealfive.subList(2, 4));

	for(int i=0; i < lastthree.size(); i++) {
		if(lastthree.getCardIdentifier(i).equals(lastthree.getCardIdentifier(i+1))) {
			is3OAK = true;
		}
	}

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
}
public void PlayCard(ArrayList<Card> cards ) {
	//if card is in player's deck, choose the card, and pick
	//if card value > than 15 or 31 then 
}

}
