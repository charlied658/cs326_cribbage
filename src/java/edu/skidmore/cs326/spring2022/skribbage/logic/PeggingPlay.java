
package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Claim;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
//import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import java.util.ArrayList;
import java.util.List;

/**
* PeggingPlay contains methods to run the pegging play phase of the game.
* This class is incomplete. It contains methods to check some player claims
* for points (e.g., a play may claim to have a pair of cards) and play a card
* during the pegging phase.
* It assumes there are only two players (for now).
* @author Michael Shriner
*/
public class PeggingPlay implements PeggingPlayInterface {

    /** a Game object to access the state of the game. */
    private Game game;

    /** Object used to manage the Game data. */
    private GameManager gameManager;

    /** Object used to manage a Hand. */
    private HandManager handManager;

    /** the cards played during PeggingPlay so far. */
    private List <Card> cardsPlayedSoFar;

    /**
    * Constructor that sets the class Game object to the parameter
    * Game object.
    * @param g is a Game object.
    */
    public PeggingPlay(Game g) {

        cardsPlayedSoFar = new ArrayList <Card>();

        //initialize the game manager
        gameManager = new GameManager(g);
        //initialize game
        game = g;

        handManager = new HandManager();
    }

    /**
    * Takes a card and a player and adds the card's point value to the total
    * value during pegging play unless 31 < peggingTotal + the value of
    * the card to add. If the card is played during pegging play, the card is
    * temporarily removed from the player's hand who played it.
    *
    * requires the players in the player list to have an assigned user id  
    *
    *
    * @param cardToAdd is the card whose point value will be added to the
    * total if it meets the condition described above.
    * @param p is the player who is trying to play the card.
    * @return true iff the card was added to the pegging total.
    */
    public boolean addCardToPeggingTotal(Card cardToAdd, Player p) {

        //get the point value of the card to add
        int theCardValue = cardToAdd.getRank().getPointValue();

        if (gameManager.addToPeggingTotal(theCardValue)) {
            // if here, the card was added to the pegging total

            // remove the card from the player's hand
            handManager.removeCardFromHand(p.getHand(), cardToAdd);

            // save the card removed in the appropriate Hand in
            // peggingCardsPlayed
            int idxOfPlayerPeggingCards = game.getIdxPlayerPegCards(p);
            Hand pegHand = game.getPeggingCards(idxOfPlayerPeggingCards);
            handManager.addCardToHand(pegHand, cardToAdd);

            //add the card to cardsPlayedSoFar
            cardsPlayedSoFar.add(cardToAdd);

            return true;

        } else {
            return false;
        }
    }

    /**
    * Takes a claim and awards the player who made the claim the points earned
    * for the claim made if the claim is valid.
    *
    * claims that can be made and are currently available:
    * "15"
    * "31"
    * "pair"
    * "3 pair"
    * "4 pair".
    *
    * @param c is the claim the player makes.
    * @param p is the player who made the claim.
    * @return true iff the claim made was valid
    */
    public boolean checkClaim(Claim c, Player p) {

        if (c == Claim.FIFTEEN) {
            return check15(p);
        } else if (c == Claim.THIRTYONE) {
            return check31(p);
        } else if (c == Claim.PAIR) {
            return checkPair(p);
        } else if (c == Claim.THREEPAIR) {
            return check3Pair(p);
        } else if (c == Claim.FOURPAIR) {
            return check4Pair(p);
        } else {
            return false;
        }
    // else if(claim.equalsIgnoreCase("run of 3")){
    // checkRunOf3(p);
    // }
    // else if (claim.equalsIgnoreCase("run of 4")){
    // checkRunOf4(p);
    // }
    // else if (claim.equalsIgnoreCase("run of 5")){
    // checkRunOf5(p);
    // }
    // else if (claim.equalsIgnoreCase("run of 6")){
    // checkRunOf6(p);
    // }
    // else if (claim.equalsIgnoreCase("run of 7")){
    // checkRunOf7(p);
    // }
    }

    /**
    * If the player passed as a parameter placed a card during
    * the pegging phase that brought the pegging total to 15,
    * the player is awarded 2 points. Otherwise, the player is
    * awarded no points.
    *
    * assumption: Card c from checkClaim() has been added to peggingCards
    * already.
    * assumption: check15() is called before the next player plays a card.
    *
    * @param p is the player making the claim that he or she
    * placed a card that brought the pegging total to 15.
    * @return true iff the player has 15
    */
    public boolean check15(Player p) {

        if (game.getPeggingTotal() == 15) {
            p.addPoints(2);
            return true;
        } else {
            return false;
        }
    }

    /**
    * If the player passed as a parameter placed a card during the pegging
    * phase that brought the pegging total to 31, the player is
    * awarded 2 points. Otherwise, the player is awarded no points.
    *
    * assumption: Card c from checkClaim() has been added to peggingCards
    * already
    * assumption: check31() is called before the next player plays a card
    *
    * @param p is the player making the claim that he or she placed a card
    * that brought the pegging total to 31.
    * @return true iff the player has 31
    */
    public boolean check31(Player p) {

        if (game.getPeggingTotal() == 31) {
            p.addPoints(2);
            return true;
        } else {
            return false;
        }
    }

    /**
    * If the player passed as a parameter placed a card that immediately
    * followed a card with the same numerical value, the player is awarded
    * 2 points. Otherwise, the player is awarded no points.
    *
    * assumption: Card c from checkClaim() has been added to peggingCards
    * already
    *
    * assumption: checkPair() is called before the next player plays a card
    *
    * @param p is the player who made the claim of having a pair
    * during the pegging phase.
    * @return true iff the player has a pair
    */
    public boolean checkPair(Player p) {

      //need record of the last two cards played

        if (cardsPlayedSoFar.size() < 2) {
          //if there are fewer than two cards played during
          //the pegging phase, then there isn't a valid claim to a pair
            return false;
        }


        Card firstCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 2);
        Card secondCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 1);

        ArrayList<Card> checkIfPair = new ArrayList<Card>();
        checkIfPair.add(firstCard);
        checkIfPair.add(secondCard);

        if (isPair(checkIfPair)) {
            p.addPoints(2);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Checks if the cards in the list have the same identifier and returns
    * true if they do. Otherwise, it returns false.
    *
    * @param cards is the list of cards to check.
    * @return true if the cards in the list have the same identifier;
    * otherwise, return false.
    */
    public boolean isPair(List<Card> cards) {

        String id = cards.get(0).getRank().getSymbol();

        for (int i = 1; i < cards.size(); i++) {
            String idToCompare = cards.get(i).getRank().getSymbol();
            if (!id.equals(idToCompare)) {
                return false;
            }
        }

        return true;
    }


    /**
    * If the player passed as a parameter placed a card that immediately
    * followed two cards with the same numerical values, the player is
    * awarded 6 points. Otherwise, the player is awarded no points.
    *
    * @param p is the player who made the claim of having a 3 pair
    * during the pegging phase.
    * @return true iff the player has a 3 pair
    */
    public boolean check3Pair(Player p) {
    // assumption: Card c from checkClaim() has been added to peggingCards
    // already
    // assumption: check15() is called before the next player plays a card

        if (cardsPlayedSoFar.size() < 3) {
          //we need at least 3 cards to have a 3 pair
            return false;
        }

        Card firstCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 3);
        Card secondCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 2);
        Card thirdCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 1);

        ArrayList<Card> checkIfPair = new ArrayList<Card>();
        checkIfPair.add(firstCard);
        checkIfPair.add(secondCard);
        checkIfPair.add(thirdCard);

        if (isPair(checkIfPair)) {
            p.addPoints(6);
            return true;
        } else {
            return false;
        }

    }


    /**
    * If the player passed as a parameter placed a card that immediately
    * followed 3 cards with the same numerical values, the player is
    * awarded 12 points. Otherwise, the player is awarded no points.
    *
    * @param p is the player who made the claim of having a 3 pair
    * during the pegging phase.
    * @return true iff the player has a 4 pair
    */
    public boolean check4Pair(Player p) {
    //assumption: Card c from checkClaim() has been added to peggingCards
    //already
    //assumption: check15() is called before the dealer plays a card

        if (cardsPlayedSoFar.size() < 4) {
          //we need at least 3 cards to have a 3 pair
            return false;
        }

        Card firstCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 4);
        Card secondCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 3);
        Card thirdCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 2);
        Card fourthCard = cardsPlayedSoFar.get(cardsPlayedSoFar.size() - 1);

        ArrayList<Card> checkIfPair = new ArrayList<Card>();
        checkIfPair.add(firstCard);
        checkIfPair.add(secondCard);
        checkIfPair.add(thirdCard);
        checkIfPair.add(fourthCard);

        if (isPair(checkIfPair)) {
            p.addPoints(12);
            return true;
        } else {
            return false;
        }

    }

//
// see PeggingPlay.java in my local downloads folder for the methods I wrote
// but have not added to this class yet

}
