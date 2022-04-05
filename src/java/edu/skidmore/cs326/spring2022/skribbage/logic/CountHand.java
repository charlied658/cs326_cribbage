//
//import java.util.ArrayList;
//import java.util.Collections;
///**
// * 
// * @author lappiaha
// *
// */
//
//public class CountHand {
//	/**
//	 * boolean to check if player has three of a kind
//	 */
//	boolean threeOAK = false; 
//	/**
//	 * boolean to check if player has a pair
//	 */
//	boolean ispair = false; 
//	/**
//	 * boolean to check if player has a four of a kind
//	 */
//	boolean fourOAK = false;
//	/**
//	 * boolean to check if there is a flush
//	 */
//	boolean checkflush = false;
//	/**
//	 * player object to call methods in the player class 
//	 */
//
//	private Player p = new Player();
//
//	public CountHand () {
//		this.p = new Player ();
//	}
//	/**
//	 * Check if player has a pair in their hand 
//	 */
//	public void CheckforRepeatCards() {
//
//		for (int i =0; i < p.getHand().getHand().size(); i++){
//			int count = Collections.frequency(p.getHand().getHand(),i+1);
//			//should this be .getidentifier
//			if(count = 2) {
//				ispair=true;
//			}
//			if (count = 3) {
//				threeOAK = true; 
//			}
//
//			if (count = 4) {
//				fourOAK = true; 
//			}
//
//		}
//
//		if(ispair = true) {
//			p.addPoints(2);
//		}
//
//		if(threeOAK = true) {
//			p.addPoints(6);
//		}
//		if(fourOAK = true) {
//			p.addPoints(12);
//		}
//	}
//	public void checkRuns() {
//		// Run of 3
//		//	for()
//	}
//	public void checkFlush() {
//		ArrayList<Card> Flusharr = new ArrayList<Card>(p.getHand().getHand());
//		//does get identifier give suit
//
//		for (int i =0; i < Flusharr.size(); i++){
//			if(Flusharr.get(i).getIdentifier()== Flusharr.get(i+1).getIdentifier()) {
//				checkflush = true;
//			}
//
//			if(checkflush = true) {
//				p.addPoints(5);
//			}
//			//if check flush = false && Flusharr.get(i).getIdentifier()== Flusharr.get(i+1).getIdentifier()
//			//
//		}
//
//
//		ArrayList<Card> firsttwo = new ArrayList<Card>(p.getHand().getHand().subList(0, 1));
//		for(int i=0; i < firsttwo.size(); i++) {
//			if(firsttwo.get(i).getIdentifier()==(firsttwo.get(i+1).getIdentifier())) {
//				ispair = true;
//			}
//		}
//	}
//	//
//	//			ArrayList<Card> secondtwo = new ArrayList<Card>(p.getHand().getHand().subList(1, 2));
//	//			for(int i=0; i < secondtwo.size(); i++) {
//	//				if(secondtwo.get(i).getIdentifier()==(secondtwo.get(i+1).getIdentifier())) {
//	//					ispair = true;			}
//	//			}
//	//
//	//			ArrayList<Card> middletwo = new ArrayList<Card>(p.getHand().getHand().subList(2, 3));
//	//			for(int i=0 ; i < middletwo.size(); i++) {
//	//				if(middletwo.get(i).getIdentifier()==(middletwo.get(i+1).getIdentifier())) {
//	//					ispair = true;
//	//				}
//	//			}
//	//			ArrayList<Card> lasttwo = new ArrayList<Card>(playerHand.getHand().getHand.subList(2, 3));
//	//			for(int i=0 ; i < lasttwo.size(); i++) {
//	//				if(lasttwo.get(i).getIdentifier()==(lasttwo.get(i+1).getIdentifier())) {
//	//					ispair = true;
//	//				}
//	//			}
//	//			if(ispair = true) {
//	//				p.addPoints(2);
//	//			}
//	//		}
//
//
//
//
//
//
//	/**
//	 * Check if the sum of player cards if 15
//	 */
//	private void Checkfor15() {
//		if (p.getPoints() == 15) {
//
//		}
//	}
//
//}