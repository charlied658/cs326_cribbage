package edu.skidmore.cs326.spring2022.skribbage.logic;

import java.util.List;
import java.util.Random;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

/**
 * GameManager contains methods to manipulate the data in Game. It includes
 * methods to initialize a list of players, add a player to the player list,
 * add a value to the pegging total, add a card to the pone's pegging cards,
 * add a card to the dealer's pegging cards, initialize the pegging total, and
 * determines the index in the player list where the dealer is. A key
 * assumption for this class is that there are only two players.
 *
 * @author Michael Shriner
 *         Last edited by Charlie Davidson
 */
public class GameManager implements GameManagerInterface {

    /**
     * A Game to access the data this class is designed to manipulate.
     */
    private Game g;

    /**
     * handManager.
     */
    @SuppressWarnings("unused")
    private HandManager handManager = new HandManager();

    /**
     * Deck manager.
     */
    private DeckManipulator deckManager = new DeckManipulator();
    
    /**
     * Number of cards in the deck.
     */
    private final int numcards = 52;

    /**
     * GameManager constructor that initializes a Game.
     *
     * @param game
     *            is the Game to set the class Game to.
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
     * @param game
     *            is a Game object.
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
     * @param amountToAdd
     *            is the amount of points to add
     *            to the pegging total.
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
     * Add the parameter Card to the pone's pegging cards.
     *
     * @param c
     *            is the Card to add to the list of the pone's pegging cards.
     */
    // public void addPonePeggingCard(Card c) {
    //     Hand ponePegCards = g.getPonePeggingCards();
    //     handManager.addCardToHand(ponePegCards, c);
    //     g.setPonePeggingCards(ponePegCards);
    // }

    /**
     * Add the parameter Card to the dealer's pegging cards.
     *
     * @param c
     *            is the Card to add to the list of the dealer's
     *            pegging cards.
     */
    // public void addDealerPeggingCard(Card c) {
    //     Hand dealerPegCards = g.getDealerPeggingCards();
    //     handManager.addCardToHand(dealerPegCards, c);
    //     g.setDealerPeggingCards(dealerPegCards);
    // }

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
     * @param playerList
     *            is the list of players.
     * @return the index in playerList where the dealer is or
     *         -1 if there is no dealer.
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
     * Initialize the state of the cards.
     */
    public void initializeDeck() {
        g.getStandardDeck().getDeck().clear();
        g.getCardsInDeck().getDeck().clear();
        g.getCardsInPlay().getCardsInHand().clear();
        g.getCardsInHand().getCardsInHand().clear();
        g.getCardsInCrib().getCardsInHand().clear();
        g.getCardsInOpponentHand().getCardsInHand().clear();

        for (int i = 0; i < numcards; i++) {
            g.getStandardDeck().getDeck().add(new Card(i));
            g.getCardsInDeck().getDeck()
            .add(g.getStandardDeck().getDeck().get(i));
        }
    }

    /**
     * Return whether the deck is sorted.
     *
     * @return boolean
     */
    public boolean deckIsSorted() {
        if (g.getCardsInDeck().getDeck().size() 
            != g.getStandardDeck().getDeck().size()) {
            return false;
        }

        for (int i = 0; i < g.getCardsInDeck().getDeck().size(); i++) {
            if (g.getCardsInDeck().getDeck().get(i) 
                != g.getStandardDeck().getDeck().get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reset the cards to their starting positions.
     */
    public void resetCards() {
        g.getCardsInDeck().getDeck().clear();
        g.getCardsInPlay().getCardsInHand().clear();
        g.getCardsInHand().getCardsInHand().clear();
        g.getCardsInCrib().getCardsInHand().clear();
        g.getCardsInOpponentHand().getCardsInHand().clear();
        for (int i = 0; i < numcards; i++) {
            g.getCardsInDeck().getDeck()
            .add(g.getStandardDeck().getDeck().get(i));
        }
    }

    /**
     * Shuffle the cards.
     */
    public void shuffleCards() {
        resetCards();
        deckManager.shuffle(g.getCardsInDeck());
    }

    /**
     * Deal cards to the player.
     *
     * @param num
     */
    public void dealPlayerCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getCardsInDeck().getDeck().size() > 0) {
                Card temp = g.getCardsInDeck().getDeck().remove(0);
                g.getCardsInHand().getCardsInHand().add(temp);
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
            if (g.getCardsInDeck().getDeck().size() > 0) {
                Card temp = g.getCardsInDeck().getDeck().remove(0);
                g.getCardsInOpponentHand().getCardsInHand().add(temp);
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
            if (g.getCardsInDeck().getDeck().size() > 0) {
                Card temp = g.getCardsInDeck().getDeck().remove(0);
                g.getCardsInPlay().getCardsInHand().add(temp);
            }
        }
    }

    /**
     * Add card from the play field to your hand.
     * This should not be used in the final game.
     *
     * @param index
     */
    public void addCardToHand(int index) {
        if (g.getCardsInPlay().getCardsInHand().size() > 0) {
            Card temp = g.getCardsInPlay().getCardsInHand().remove(index);
            g.getCardsInHand().getCardsInHand().add(temp);
        }
    }

    /**
     * Play a card from your hand to the center of the board.
     *
     * @param index
     */
    public void playCard(int index) {
        if (g.getCardsInHand().getCardsInHand().size() > 0) {
            Card temp = g.getCardsInHand().getCardsInHand().remove(index);
            g.getCardsInPlay().getCardsInHand().add(temp);
        }
    }

    /**
     * Have the opponent pick a random card to play.
     */
    public void opponentPlayCard() {
        Random rand = new Random();
        int index = rand.nextInt(
            g.getCardsInOpponentHand().getCardsInHand().size());
        if (g.getCardsInOpponentHand().getCardsInHand().size() > 0) {
            Card temp = g.getCardsInOpponentHand()
                .getCardsInHand().remove(index);
            g.getCardsInPlay().getCardsInHand().add(temp);
        }
    }



}
