package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;

/**
 * Class to manage the rendering of objects on the StartGamePage.
 * Edit this file if you need to.
 * 
 * @author cdavidso
 */
public class GameRenderManager {

    /**
     * Logger.
     */
    private static final Logger LOG;

    /**
     * Singleton instance of this class.
     */
    private static final GameRenderManager INSTANCE;

    /**
     * GameManager instance.
     */
    private GameManager gameManager;

    /**
     * Arraylist of card images.
     */
    private ArrayList<CardImage> standardDeck;

    /**
     * Cards currently displayed in the deck.
     */
    private ArrayList<CardImage> cardsInDeck;

    /**
     * Cards currently displayed in center of board.
     */
    private ArrayList<CardImage> cardsInPlay;

    /**
     * Cards currently displayed in the player's hand.
     */
    private ArrayList<CardImage> cardsInHand;

    /**
     * Cards currently displayed in the crib.
     */
    private ArrayList<CardImage> cardsInCrib;

    /**
     * Cards currently displayed in the opponent's hand.
     */
    private ArrayList<CardImage> cardsInOpponentHand;

    /**
     * Initialize the static instance.
     */
    static {
        LOG = Logger.getLogger(GameRenderManager.class);
        INSTANCE = new GameRenderManager();
    }

    /**
     * GameRenderManager constructor.
     */
    private GameRenderManager() {
        LOG.debug("Instance created");
    }

    /**
     * getInstance method.
     *
     * @return the instance of the class.
     */
    public static GameRenderManager getInstance() {
        return INSTANCE;
    }

    /**
     * Get the Card object associated with the CardImage that has been clicked.
     * 
     * @param e drawable image
     * @return card
     */
    public Card getClickedCard(Drawable e) {
        if (e instanceof Image) {
            for (int i = 0; i < getStandardDeck().size(); i++) {
                if (e == getStandardDeck().get(i)) {
                    return getStandardDeck().get(i).getCard();
                }
            }
        }
        return null;
    }

    /**
     * When a card has been clicked, update the game state and animate the card
     * movement.
     * 
     * @param e
     *            Drawable that has been passed in
     */
    public void manageClickedCard(Drawable e) {

        // Loop through the entire player's hand
        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInHand().size(); i++) {

            // Check that the card that has been clicked is within the player's
            // hand. We don't want the player to be able to click on cards not
            // in the player's hand.
            if (e == GameRenderManager.getInstance()
                .getCardsInHand().get(i)) {

                // Set the cards to not be clickable
                AnimationManager.getInstance().setCardsClickable(false);

                // Play the card that has been clicked to the center of the
                // board and play an animation
                gameManager.playCard(i);
                AnimationManager.getInstance().updateCardPositions();
                AnimationManager.getInstance().moveCards(50);

                // Opponent plays a random card, then play an animation
                gameManager.opponentPlayCard();
                AnimationManager.getInstance().updateCardPositions();
                AnimationManager.getInstance().moveCards(50);

                // Once the players have played all their cards, count the
                // points and move the pegs. Each player has 6 cards so this
                // happens when the number of cards in play equals 12
                if (gameManager.getGame().getCardsInPlay()
                    .getCardsInHand().size() == 12) {

                    // Move each peg 5 spaces. This is a temporary test feature.
                    // In the real game the pegs should move according to the
                    // number of points earned during the play phase
                    AnimationManager.getInstance().movePeg(0, 5);
                    AnimationManager.getInstance().movePeg(1, 5);

                    // If the location of either peg
                    // is at the final spot, end the game.
                    if (AnimationManager.getInstance()
                        .getPegLocations()[0] == 120
                        || AnimationManager.getInstance()
                            .getPegLocations()[1] == 120) {
                        AnimationManager.getInstance().getStartGamePage()
                            .closeWindow();
                    }

                    // Deal 6 cards to each player again to start the next
                    // round.
                    AnimationManager.getInstance().dealCards();
                }

                // Set the cards to be clickable again then end the method.
                AnimationManager.getInstance().setCardsClickable(true);
                return;
            }
        }
    }

    /**
     * Set the game manager instance.
     * @param gameManager game manager to set
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    
    /**
     * Get the standard deck.
     * 
     * @return standardDeck
     */
    public ArrayList<CardImage> getStandardDeck() {
        return standardDeck;
    }

    /**
     * Set the standard deck.
     * 
     * @param standardDeck standard deck
     */
    public void setStandardDeck(ArrayList<CardImage> standardDeck) {
        this.standardDeck = standardDeck;
    }

    /**
     * Get cards in the deck.
     * 
     * @return cardsInDeck
     */
    public ArrayList<CardImage> getCardsInDeck() {
        return cardsInDeck;
    }

    /**
     * Set cards in the deck.
     * 
     * @param cardsInDeck cards in deck
     */
    public void setCardsInDeck(ArrayList<CardImage> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    /**
     * Get cards in play.
     * 
     * @return cardsInPlay
     */
    public ArrayList<CardImage> getCardsInPlay() {
        return cardsInPlay;
    }

    /**
     * Set cards in play.
     * 
     * @param cardsInPlay cards in play
     */
    public void setCardsInPlay(ArrayList<CardImage> cardsInPlay) {
        this.cardsInPlay = cardsInPlay;
    }

    /**
     * Get cards in player's hand.
     * 
     * @return cardsInHand
     */
    public ArrayList<CardImage> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * Set cards in player's hand.
     * 
     * @param cardsInHand cards in hand
     */
    public void setCardsInHand(ArrayList<CardImage> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    /**
     * Get cards in the crib.
     * 
     * @return cardsInCrib
     */
    public ArrayList<CardImage> getCardsInCrib() {
        return cardsInCrib;
    }

    /**
     * Set cards in the crib.
     * 
     * @param cardsInCrib cards in crib
     */
    public void setCardsInCrib(ArrayList<CardImage> cardsInCrib) {
        this.cardsInCrib = cardsInCrib;
    }

    /**
     * Get cards in opponent's hand.
     * 
     * @return cardsInOpponentHand
     */
    public ArrayList<CardImage> getCardsInOpponentHand() {
        return cardsInOpponentHand;
    }

    /**
     * Set cards in opponent's hand.
     * 
     * @param cardsInOpponentHand cards in opponent hand
     */
    public void setCardsInOpponentHand(
        ArrayList<CardImage> cardsInOpponentHand) {
        this.cardsInOpponentHand = cardsInOpponentHand;
    }

}
