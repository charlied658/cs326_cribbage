package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.logic.HandManager;
import java.util.*;
//import org.apache.log4j.Logger;
import java.util.Random;

/**
 * GameManager contains methods to manipulate the data in Game. It includes
 * methods to initialize a list of players, add a player to the player list,
 * add a value to the pegging total, add a card to the pone's pegging cards,
 * add a card to the dealer's pegging cards, initialize the pegging total, and
 * determines the index in the player list where the dealer is. A key
 * assumption for this class is that there are only two players.
 *
 * @author Michael Shriner
 */
public class GameManager implements GameManagerInterface {

    /**
     * A Game to access the data this class is designed to manipulate.
     */
    private Game g;

    private HandManager handManager = new HandManager();

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
        // g = new Game(numPlayers);
        this.g = game;
    }
    
    /**
     * Constructor.
     */
    public GameManager() {
        g = new Game();
    }

    // /**
    // * GameManager constructor that initializes a Game using the
    // * empty constructor in Game.
    // */
    // public GameManager(Game g) {
    // g = new Game();
    // }

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

    // /**
    //  * Initializes the ArrayList of Player objects given the
    //  * number of players for this game. However, there is
    //  * the assumption, for now, that the number of players
    //  * is 2.
    //  *
    //  * @param numPlayers
    //  *            is the number of players.
    //  * @param playerList
    //  *            is the list of players.
    //  */
    // public void initPlayers(int numPlayers, ArrayList<Player> playerList) {
    //
    //     for (int i = 0; i < numPlayers; i++) {
    //         addPlayer(new Player(), playerList);
    //     }
    // }

    // /**
    //  * Adds a player to the player list.
    //  *
    //  * @param p
    //  *            is the player to add to the player list.
    //  * @param playerList
    //  *            is the list of players.
    //  */
    // public void addPlayer(Player p, ArrayList<Player> playerList) {
    //     playerList.add(p);
    // }

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
    public void addPonePeggingCard(Card c) {
        Hand ponePegCards = g.getPonePeggingCards();
        handManager.addCardToHand(ponePegCards, c);
        g.setPonePeggingCards(ponePegCards);
    }

    /**
     * Add the parameter Card to the dealer's pegging cards.
     *
     * @param c
     *            is the Card to add to the list of the dealer's
     *            pegging cards.
     */
    public void addDealerPeggingCard(Card c) {
        Hand dealerPegCards = g.getDealerPeggingCards();
        handManager.addCardToHand(dealerPegCards, c);
        g.setDealerPeggingCards(dealerPegCards);
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
     * @param playerList
     *            is the list of players.
     * @return the index in playerList where the dealer is or
     *         -1 if there is no dealer.
     */
    public int getDealerIdx(List <Player> playerList) {
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
        g.getStandardDeck().clear();
        g.getCardsInDeck().clear();
        g.getCardsInPlay().clear();
        g.getCardsInHand().clear();
        g.getCardsInCrib().clear();
        g.getCardsInOpponentHand().clear();
        
        for (int i = 0; i < numcards; i++) {
            g.getStandardDeck().add(new Card(i));
            g.getCardsInDeck().add(g.getStandardDeck().get(i));
        }
    }
    
    /**
     * Return whether the deck is sorted.
     * @return boolean
     */
    public boolean deckIsSorted() {
        if (g.getCardsInDeck().size() != g.getStandardDeck().size()) {
            return false;
        }
        
        for (int i = 0; i < g.getCardsInDeck().size(); i++) {
            if (g.getCardsInDeck().get(i) != g.getStandardDeck().get(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Reset the cards to their starting positions.
     */
    public void resetCards() {
        g.getCardsInDeck().clear();
        g.getCardsInPlay().clear();
        g.getCardsInHand().clear();
        g.getCardsInCrib().clear();
        g.getCardsInOpponentHand().clear();
        for (int i = 0; i < numcards; i++) {
            g.getCardsInDeck().add(g.getStandardDeck().get(i));
        }
    }
    
    /**
     * Shuffle the cards.
     */
    public void shuffleCards() {
        resetCards();
        
        Random rand = new Random();
        Card temp;
        int index1;
        int index2;
        
        for (int i = 0; i < 100; i++) {
            index1 = rand.nextInt(numcards);
            index2 = rand.nextInt(numcards);
            temp = g.getCardsInDeck().get(index1);
            g.getCardsInDeck().set(
                index1, g.getCardsInDeck().get(index2));
            g.getCardsInDeck().set(index2, temp);
        }
    }
    
    /**
     * Deal cards to the player.
     * @param num
     */
    public void dealPlayerCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getCardsInDeck().size() > 0) {
                Card temp = g.getCardsInDeck().remove(0);
                g.getCardsInHand().add(temp);
            }
        }
    }
    
    /**
     * Deal cards to opponent.
     * @param num
     */
    public void dealOpponentCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getCardsInDeck().size() > 0) {
                Card temp = g.getCardsInDeck().remove(0);
                g.getCardsInOpponentHand().add(temp);
            }
        }
    }
    
    /**
     * Deal cards to the center of the board.
     * @param num
     */
    public void dealPlayCards(int num) {
        for (int i = 0; i < num; i++) {
            if (g.getCardsInDeck().size() > 0) {
                Card temp = g.getCardsInDeck().remove(0);
                g.getCardsInPlay().add(temp);
            }
        }
    }
    
    /**
     * Add card from the play field to your hand.
     * This should not be used in the final game.
     * @param index
     */
    public void addCardToHand(int index) {
        if (g.getCardsInPlay().size() > 0) {
            Card temp = g.getCardsInPlay().remove(index);
            g.getCardsInHand().add(temp);
        }
    }
    
    /**
     * Play a card from your hand to the center of the board.
     * @param index
     */
    public void playCard(int index) {
        if (g.getCardsInHand().size() > 0) {
            Card temp = g.getCardsInHand().remove(index);
            g.getCardsInPlay().add(temp);
        }
    }
    
    /**
     * Have the opponent pick a random card to play.
     */
    public void opponentPlayCard() {
        Random rand = new Random();
        int index = rand.nextInt(g.getCardsInOpponentHand().size());
        if (g.getCardsInOpponentHand().size() > 0) {
            Card temp = g.getCardsInOpponentHand().remove(index);
            g.getCardsInPlay().add(temp);
        }
    }

}
