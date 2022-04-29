package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Claim;

import java.util.List;

/**
 * Interface for PeggingPlay.
 *
 * @author Michael Shriner
 */
interface PeggingPlayInterface {

    /**
     * Takes a card and a player and adds the card's point value to the total
     * value during pegging play unless 31 < peggingTotal + the value of
     * the card to add. If the card is played during pegging play, the card is
     * temporarily removed from the player's hand who played it.
     *
     * @param cardToAdd
     *            is the card whose point value will be added to the
     *            total if it meets the condition described above.
     * @param p
     *            is the player who is trying to play the card
     * @return true if the card was added; false, otherwise.
     */
    boolean addCardToPeggingTotal(Card cardToAdd, Player p);

    /**
     * Takes a claim and awards the player who made the claim the points earned
     * for the claim made if the claim is valid.
     * claims that can be made and are currently available:
     * "15"
     * "31"
     * "pair"
     * "3 pair"
     * "4 pair".
     *
     * @param claim
     *            is the claim the player makes.
     * @param p
     *            is the player who made the claim.
     * @return true iff the claim made was valid
     */
    boolean checkClaim(Claim claim, Player p);

    /**
     * If the player passed as a parameter placed a card during
     * the pegging phase that brought the pegging total to 15,
     * the player is awarded 2 points. Otherwise, the player is
     * awarded no points.
     *
     * @param p
     *            is the player making the claim that he or she
     *            placed a card that brought the pegging total to 15.
     * @return true iff the player has 15
     */
    boolean check15(Player p);

    /**
     * If the player passed as a parameter placed a card during the pegging
     * phase that brought the pegging total to 31, the player is
     * awarded 2 points. Otherwise, the player is awarded no points.
     *
     * @param p
     *            is the player making the claim that he or she placed a card
     *            that brought the pegging total to 31.
     * @return true iff the player has 31
     */
    boolean check31(Player p);

    /**
     * Checks if the cards in the list have the same identifier and returns
     * true if they do. Otherwise, it returns false.
     *
     * @param cards
     *            is the list of cards to check.
     * @return true if the cards in the list have the same identifier;
     *         otherwise, return false.
     */
    boolean isPair(List<Card> cards);

    /**
     * If the player passed as a parameter placed a card that immediately
     * followed a card with the same numerical value, the player is awarded
     * 2 points. Otherwise, the player is awarded no points.
     *
     * @param p
     *            is the player who made the claim of having a pair
     *            during the pegging phase.
     * @return true iff the player has a pair
     */
    boolean checkPair(Player p);

    /**
     * If the player passed as a parameter placed a card that immediately
     * followed two cards with the same numerical values, the player is
     * awarded 6 points. Otherwise, the player is awarded no points.
     *
     * @param p
     *            is the player who made the claim of having a 3 pair
     *            during the pegging phase.
     * @return true iff the player has a 3 pair
     */
    boolean check3Pair(Player p);

    /**
     * If the player passed as a parameter placed a card that immediately
     * followed 3 cards with the same numerical values, the player is
     * awarded 12 points. Otherwise, the player is awarded no points.
     *
     * @param p
     *            is the player who made the claim of having a 3 pair
     *            during the pegging phase.
     * @return true iff the player has a 4 pair
     */
    boolean check4Pair(Player p);

}
