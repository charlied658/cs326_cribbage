package edu.skidmore.cs326.spring2022.skribbage.logic;
import java.util.ArrayList;

/**
* PeggingPlay contains methods to run the pegging play phase of the game.
* This class is incomplete. It contains methods to check some player claims
* for points (e.g., a play may claim to have a pair of cards) and play a card
* during the pegging phase.
* It assumes there are only two players.
* @author Michael Shriner
*/
public class PeggingPlay {

    /** a Game object to access the state of the game. */
    private Game game;

    /**
     * Constructor that sets the class Game object to the parameter
     * Game object.
     * @param g is a Game object.
     */
    public PeggingPlay(Game g) {
        this.game = g;
    }

     /**
     * Takes a card and a player and adds the card's point value to the total
     * value during pegging play unless 31 < peggingTotal + the value of
     * the card to add. If the card is played during pegging play, the card is
     * temporarily removed from the player's hand who played it.
     *
     * @param cardToAdd is the card whose point value will be added to the
     * total if it meets the condition described above.
     * @param p is the player who is trying to play the card
     */
    public void addCardToPeggingTotal(Card cardToAdd, Player p) {

        int theCardValue = cardToAdd.getPointValue();

        if (game.addToPeggingTotal(theCardValue)) {
            // if here, the card was added to the pegging total

            // remove the card from the player's hand and place it in pegging
            // cards
            p.getHand().removeCardFromHand(cardToAdd);

            if (p.isDealer()) {
                game.addDealerPeggingCard(cardToAdd);
            } else {
                game.addPonePeggingCard(cardToAdd);
            }

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
     * @param claim is the claim the player makes.
     * @param p is the player who made the claim.
     */
    public void checkClaim(String claim, Player p) {

        if (claim.equalsIgnoreCase("15")) {
            check15(p);
        } else if (claim.equalsIgnoreCase("31")) {
            check31(p);
        } else if (claim.equalsIgnoreCase("pair")) {
            checkPair(p);
        } else if (claim.equalsIgnoreCase("3 pair")) {
            check3Pair(p);
        } else if (claim.equalsIgnoreCase("4 pair")) {
            check4Pair(p);
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
     * @param p is the player making the claim that he or she
     * placed a card that brought the pegging total to 15.
     */
    public void check15(Player p) {

        // assumption: Card c from checkClaim() has been added to peggingCards
        // already
        // assumption: check15() is called before the next player plays a card

        if (game.getPeggingTotal() == 15) {
            p.addPoints(2);
        }

        // if (sumTotalPeggingCards() == 15) {
        //     p.addPoints(2);
        // } else {
        //     // FRONT END
        //     // indicate to the player that the claim was not valid
        // }

    }

    // public int sumTotalPeggingCards() {
    //
    //     int sum = 0;
    //     ArrayList<Card> dealerPeggingCards = game.getDealerPeggingCards();
    //     ArrayList<Card> ponePeggingCards = game.getPonePeggingCards();
    //
    //     for (int i = 0; i < dealerPeggingCards.size(); i++) {
    //         Card tempCard = dealerPeggingCards.get(i);
    //         sum += tempCard.getPointValue();
    //     }
    //
    //     for (int i = 0; i < ponePeggingCards.size(); i++) {
    //         Card tempCard = ponePeggingCards.get(i);
    //         sum += tempCard.getPointValue();
    //     }
    //
    //     return sum;
    //
    // }

    /**
     * If the player passed as a parameter placed a card during the pegging
     * phase that brought the pegging total to 31, the player is
     * awarded 2 points. Otherwise, the player is awarded no points.
     *
     * @param p is the player making the claim that he or she placed a card
     * that brought the pegging total to 31.
     */
    public void check31(Player p) {

        // assumption: Card c from checkClaim() has been added to peggingCards
        // already
        // assumption: check15() is called before the next player plays a card

        if (game.getPeggingTotal() == 31) {
            p.addPoints(2);
        }

        //
        // if (sumTotalPeggingCards() == 31) {
        //     p.addPoints(2);
        // } else {
        //     // FRONT END
        //     // indicate to the player that the claim was not valid
        // }

    }

    /**
    * Checks if the cards in the list have the same identifier and returns
    * true if they do. Otherwise, it returns false.
    *
    * @param cards is the list of cards to check.
    * @return true if the cards in the list have the same identifier;
    * otherwise, return false.
    */
    public boolean isPair(ArrayList<Card> cards) {

        if (cards.size() == 0 || cards.size() == 1) {
            return false;
        }

        char id = cards.get(0).getIdentifier();

        for (int i = 1; i < cards.size(); i++) {
            char idToCompare = cards.get(i).getIdentifier();
            if (id != idToCompare) {
                return false;
            }
        }

        return true;

    }

    /**
     * If the player passed as a parameter placed a card that immediately
     * followed a card with the same numerical value, the player is awarded
     * 2 points. Otherwise, the player is awarded no points.
     *
     * @param p is the player who made the claim of having a pair
     * during the pegging phase.
     */
    public void checkPair(Player p) {
        // assumption: Card c from checkClaim() has been added to peggingCards
        // already
        // assumption: check15() is called before the next player plays a card

        ArrayList<Card> dealerPeggingCards = game.getDealerPeggingCards();
        ArrayList<Card> ponePeggingCards = game.getPonePeggingCards();
        ArrayList<Card> checkIfPair = new ArrayList<Card>();

        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size() - 1));
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size() - 1));

        if (isPair(checkIfPair)) {
            p.addPoints(2);
        }
    }

    /**
     * If the player passed as a parameter placed a card that immediately
     * followed two cards with the same numerical values, the player is
     * awarded 6 points. Otherwise, the player is awarded no points.
     *
     * @param p is the player who made the claim of having a 3 pair
     * during the pegging phase.
     */
    public void check3Pair(Player p) {
        // assumption: Card c from checkClaim() has been added to peggingCards
        // already
        // assumption: check15() is called before the next player plays a card

        ArrayList<Card> dealerPeggingCards = game.getDealerPeggingCards();
        ArrayList<Card> ponePeggingCards = game.getPonePeggingCards();
        ArrayList<Card> checkIfPair = new ArrayList<Card>();

        if (p.isDealer()) {
            // if the person making the claim is the dealer, the dealer
            //played a
            // card
            // first, then the pone, then the dealer again
            // so, check two cards from dealer and one from pone
            if (dealerPeggingCards.size() >= 2) {
                checkIfPair
                  .add(dealerPeggingCards.get(dealerPeggingCards.size() - 1));
                checkIfPair
                  .add(dealerPeggingCards.get(dealerPeggingCards.size() - 2));
                checkIfPair
                  .add(ponePeggingCards.get(ponePeggingCards.size() - 1));
            }
        } else {
            if (ponePeggingCards.size() >= 2) {
                checkIfPair
                  .add(ponePeggingCards.get(ponePeggingCards.size() - 1));
                checkIfPair
                  .add(ponePeggingCards.get(ponePeggingCards.size() - 2));
                checkIfPair
                  .add(dealerPeggingCards.get(dealerPeggingCards.size() - 1));
            }
        }

        if (isPair(checkIfPair)) {
            p.addPoints(6);
        }

    }

  /**
  * If the player passed as a parameter placed a card that immediately
  * followed 3 cards with the same numerical values, the player is
  * awarded 12 points. Otherwise, the player is awarded no points.
  *
  * @param p is the player who made the claim of having a 3 pair
  * during the pegging phase.
  *
  */
    public void check4Pair(Player p) {
    //assumption: Card c from checkClaim() has been added to peggingCards
    //already
    //assumption: check15() is called before the dealer plays a card

        ArrayList <Card> dealerPeggingCards = game.getDealerPeggingCards();
        ArrayList <Card> ponePeggingCards = game.getPonePeggingCards();
        ArrayList<Card> checkIfPair = new ArrayList <Card>();

        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size() - 1));
        checkIfPair.add(dealerPeggingCards.get(dealerPeggingCards.size() - 2));
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size() - 1));
        checkIfPair.add(ponePeggingCards.get(ponePeggingCards.size() - 2));

        if (isPair(checkIfPair)) {
            p.addPoints(12);
        }

    }

//see PeggingPlay.java in my local downloads folder for the methods I wrote
//but have not added to this class yet

}
