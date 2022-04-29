package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.ArrayList;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerClickDeckEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerPlayCardEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
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
    @SuppressWarnings("unused")
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
     * Cards (up to 2) that will be discarded to the crib.
     */
    private ArrayList<CardImage> selectedCardsForDiscarding;

    /**
     * The current human player to be rendered.
     */
    private Player activePlayer;

    /**
     * computer points.
     */
    private int cPoints;

    /**
     * player points.
     */
    private int pPoints;

    /*
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
     * @param e
     *            drawable image
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
     * getPlayerPoints.
     * 
     * @return the points.
     */
    public int getPlayerPoints() {
        return pPoints;
    }
    
    /**
     * setplayerpoints.
     * @param points
     */
    public void setPlayerPoints(int points) {
        this.pPoints = points;
    }
    
    /**
     * setcomputerpoints.
     * @param points
     */
    public void setComputerPoints(int points) {
        this.cPoints = points;
    }

    /**
     * getComputerPoints.
     *
     * @return computer points.
     */
    public int getComputerPoints() {
        return cPoints;
    }

    /**
     * When a card has been clicked, update the game state and animate the card
     * movement.
     * 
     * @param e
     *            Drawable that has been passed in
     */
    public void manageClickedCard(Drawable e) {

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInDeck().size(); i++) {

            if (e == GameRenderManager.getInstance()
                .getCardsInDeck().get(i)) {

                PlayerClickDeckEvent playerClickDeckEvent =
                    (PlayerClickDeckEvent) EventFactory.getInstance()
                        .createEvent(
                            EventType.PLAYER_CLICK_DECK, this,
                            GameRenderManager.getInstance().getActivePlayer());
                EventFactory.getInstance().fireEvent(playerClickDeckEvent);

            }

        }

        // Loop through the entire player's hand
        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInHand().size(); i++) {

            // Check that the card that has been clicked is within the player's
            // hand. We don't want the player to be able to click on cards not
            // in the player's hand.
            if (e == GameRenderManager.getInstance()
                .getCardsInHand().get(i)) {
                PlayerPlayCardEvent playerPlayCardEvent =
                    (PlayerPlayCardEvent) EventFactory.getInstance()
                        .createEvent(
                            EventType.PLAYER_PLAY_CARD, this,
                            GameRenderManager.getInstance().getActivePlayer(),
                            (CardImage) e, (Integer) i);
                EventFactory.getInstance().fireEvent(playerPlayCardEvent);

            }
        }
    }

    /**
     * calculates the points.
     * 
     * @param player
     *            - true if the player chose it, false, if computer
     * @param cardChosen
     *            - the chosen card
     */
    public void calculatePoints(boolean player, Card cardChosen) {
        if (player) {
            System.out.println("Player chose: " + cardChosen.getRank() + " of "
                + cardChosen.getSuit());
            System.out.println("Points before: " + pPoints);
            pPoints += cardChosen.getRank().getPointValue();
            System.out.println("Points after: " + pPoints);
        } else {
            System.out
                .println("Computer chose: " + cardChosen.getRank() + " of "
                    + cardChosen.getSuit());
            System.out.println("Points before: " + cPoints);
            cPoints += cardChosen.getRank().getPointValue();
            System.out.println("Points after: " + cPoints);
        }
    }

    /**
     * checks for total score to ensure that 31 has not been met.
     * 
     * @param player
     *            - player score.
     * @param cpu
     *            - cpu score.
     * @return true if a hand can continue, false if 31 has been reached.
     */
    public boolean checkForTotalScore(int player, int cpu) {
        if (player + cpu < 31) {
            LOG.trace("Check for total score");
            /**
             * @TODO create functionality to check if a user has a card that
             *       will add up to less than 31, or if an opponent does
             */
            // return true for now.
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the game manager instance.
     * 
     * @param gameManager
     *            game manager to set
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
     * @param standardDeck
     *            standard deck
     */
    public void setStandardDeck(ArrayList<CardImage> standardDeck) {
        this.standardDeck = standardDeck;
    }

    /**
     * Sets an array of selected cards for discarding.
     * 
     * @param selectedCardsForDiscarding
     *            array to add
     */
    public void setSelectedCardsForDiscarding(
        ArrayList<CardImage> selectedCardsForDiscarding) {
        this.selectedCardsForDiscarding = selectedCardsForDiscarding;
    }

    /**
     * Gets the array of selected cards for discarding.
     * 
     * @return SelectedCardsForDiscarding
     */
    public ArrayList<CardImage> getSelectedCardsForDiscarding() {
        return selectedCardsForDiscarding;
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
     * @param cardsInDeck
     *            cards in deck
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
     * @param cardsInPlay
     *            cards in play
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
     * @param cardsInHand
     *            cards in hand
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
     * @param cardsInCrib
     *            cards in crib
     */
    public void setCardsInCrib(ArrayList<CardImage> cardsInCrib) {
        this.cardsInCrib = cardsInCrib;
    }

    /**
     * Gets active player.
     * 
     * @return Player object
     */
    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * Sets active player.
     * 
     * @param activePlayer
     *            new player object to set
     */
    public void setActivePlayer(
        Player activePlayer) {
        this.activePlayer = activePlayer;
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
     * @param cardsInOpponentHand
     *            cards in opponent hand
     */
    public void setCardsInOpponentHand(
        ArrayList<CardImage> cardsInOpponentHand) {
        this.cardsInOpponentHand = cardsInOpponentHand;
    }

}
