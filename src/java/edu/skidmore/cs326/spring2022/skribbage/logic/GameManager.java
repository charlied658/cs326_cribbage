package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.List;
import java.util.Random;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * GameManager contains methods to manage the data in Game.
 *
 * @author Michael Shriner
 *         Last edited by Charlie Davidson.
 */
public class GameManager implements GameManagerInterface {

    /**
     * A Game to access the data this class is designed to manage.
     */
    private Game g;

    /**
     * Hand manager.
     */
    private HandManager handManager = new HandManager();

    /**
     * Deck manager.
     */
    private DeckManipulator deckManager = new DeckManipulator();

    /**
     * GameManager constructor that initializes a Game.
     *
     * @param game is the Game to set the class Game to.
     */
    public GameManager(Game game) {
        this.g = game;
    }

    /**
     * Returns the Game used for this class.
     *
     * @return the Game used for this class.
     */
    public Game getGame() {
        return g;
    }

    /**
     * Sets the Game used for this class.
     *
     * @param game is a Game object.
     */
    public void setGame(Game game) {
        g = game;
    }

    /**
     * Takes in the amount to add to the pegging total
     * and adds it to the pegging total if the amount
     * to add plus the current pegging total does not exceed 31.
     * If it exceeds 31, this method returns false.
     * Otherwise, it returns true.
     *
     * @param amountToAdd is the amount of points to add
     * to the pegging total.
     * @return true iff amountToAdd + the pegging total <= 31.
     */
    public boolean addToPeggingTotal(int amountToAdd) {

        int peggingTotal = g.getPeggingTotal();

        if (amountToAdd + peggingTotal > 31) {
            return false;
        } else {
            peggingTotal += amountToAdd;
            g.setPeggingTotal(peggingTotal);
            return true;
        }
    }

    /**
     * Initializes the pegging total to 0.
     */
    public void initPeggingTotal() {
        g.setPeggingTotal(0);
    }

    /**
     * Returns the index in playerList where the dealer is or
     * -1 if there is no dealer.
     *
     * @param playerList is the list of players.
     * @return the index in playerList where the dealer is or
     * -1 if there is no dealer.
     */
    public int getDealerIdx(List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).isDealer()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Test whether the deck is reset.
     *
     * @return if the deck is reset or not
     */
    public boolean deckIsReset() {
        if (g.getDeck().getDeck().size() != 52) {
            return false;
        }

        for (int i = 0; i < g.getDeck().getDeck().size(); i++) {
            if (g.getDeck().getDeck().get(i).getCardID() != i) {
                return false;
            }
        }

        return true;

    }

    /**
     * Reset the cards to their starting positions.
     */
    public void resetCards() {
        g.setDeck(new Deck());
        g.setCardsInPlay(new Hand());
        g.getPlayerList().get(0).setHand(new Hand());
        g.getPlayerList().get(1).setHand(new Hand());
        g.setCribCards(new Hand());
    }

    /**
     * Shuffle the cards.
     */
    public void shuffleCards() {
        resetCards();
        deckManager.shuffle(g.getDeck());
    }

    /**
     * Deal cards to the player.
     *
     * @param num
     */
    public void dealPlayerCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getDeck().getDeck().size() > 0) {
                Card temp = deckManager.removeTopCard(g.getDeck());
                handManager.addCardToHand(
                    g.getPlayerList().get(0).getHand(), temp);
            }
        }
    }

    /**
     * Deal cards to opponent.
     *
     * @param num
     */
    public void dealOpponentCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getDeck().getDeck().size() > 0) {
                Card temp = deckManager.removeTopCard(g.getDeck());
                handManager.addCardToHand(
                    g.getPlayerList().get(1).getHand(), temp);
            }
        }
    }

    /**
     * Deal cards to the center of the board.
     *
     * @param num
     */
    public void dealPlayCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getDeck().getDeck().size() > 0) {
                Card temp = deckManager.removeTopCard(g.getDeck());
                handManager.addCardToHand(g.getCardsInPlay(), temp);
            }
        }
    }

    /**
     * Play a card from your hand to the center of the board.
     *
     * @param index
     * @return Card that was played
     */
    public Card playCard(int index) {
        if (g.getPlayerList().get(0).getHand().getCardsInHand().length > 0) {
            Card temp = handManager.removeCardFromHand(
                g.getPlayerList().get(0).getHand(),
                g.getPlayerList().get(0).getHand().getCardsInHand()[index]);
            handManager.addCardToHand(g.getCardsInPlay(), temp);
            return temp;
        } else {
            return new Card(null, null);
        }
    }

    /**
     * Have the opponent pick a random card to play.
     *
     * @return card the opponent played.
     */
    public Card opponentPlayCard() {
        if (g.getPlayerList().get(1).getHand().getCardsInHand().length > 0) {
            Random rand = new Random();
            int index = rand.nextInt(
                g.getPlayerList().get(1).getHand().getCardsInHand().length);
            Card temp = handManager.removeCardFromHand(
                g.getPlayerList().get(1).getHand(),
                g.getPlayerList().get(1).getHand().getCardsInHand()[index]);
            handManager.addCardToHand(g.getCardsInPlay(), temp);
            return temp;
        } else {
            return null;
        }
    }
}
