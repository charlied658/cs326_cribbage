package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerClickDeckEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerPlayCardEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.logic.DeckManipulator;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.surface.DialogPosition;
import us.daveread.edu.graphics.surface.DialogType;

/**
 * Class to manage the rendering of objects on the StartGamePage.
 * Edit this file if you need to.
 * 
 * @author cdavidso
 */
public class GameRenderManager {

    /**
     * check if the crib button has been clicked.
     */
    private boolean cribClicked = false;

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
     * Cards (up to 2) that will be discarded to the crib.
     */
    private ArrayList<CardImage> selectedCardsForDiscarding;

    /**
     * The current human player to be rendered.
     */
    private Player activePlayer;

    /**
     * DeckManipulator instance.
     */
    private DeckManipulator deckManager = new DeckManipulator();

    /**
     * computer points.
     */
    private int cPoints;

    /**
     * player points.
     */
    private int pPoints;

    /**
     * Only discard 2 cards to the crib at once.
     */
    private static final int MAX_DISCARD_TO_CRIB_SIZE = 2;

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
     * setCribClick.
     * 
     * @param clicked
     */
    public void setCribClick(boolean clicked) {
        this.cribClicked = clicked;
    }

    /**
     * getCribClick.
     * 
     * @return if crib button was clicked.
     */
    public boolean getCribClick() {
        return cribClicked;
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
     * 
     * @param points
     */
    public void setPlayerPoints(int points) {
        this.pPoints = points;
    }

    /**
     * setcomputerpoints.
     * 
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

        // If card clicked is in the deck, fite a PlayerClickDeckEvent
        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInDeck().size(); i++) {

            if (e == GameRenderManager.getInstance()
                .getCardsInDeck().get(i)) {

                PlayerClickDeckEvent playerClickDeckEvent =
                    (PlayerClickDeckEvent) EventFactory.getInstance()
                        .createEvent(
                            EventType.PLAYER_CLICK_DECK, this,
                            GameRenderManager.getInstance().getActivePlayer(),
                            (CardImage) e, (Integer) i);
                EventFactory.getInstance().fireEvent(playerClickDeckEvent);
                return;

            }

        }

        // If card clicked is in player hand, fire a PlayerPlayCardEvent
        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInHand().size(); i++) {

            if (e == GameRenderManager.getInstance()
                .getCardsInHand().get(i)) {
                calculatePoints(true,
                    GameRenderManager.getInstance().getCardsInHand().get(i)
                        .getCard());
                PlayerPlayCardEvent playerPlayCardEvent =
                    (PlayerPlayCardEvent) EventFactory.getInstance()
                        .createEvent(
                            EventType.PLAYER_PLAY_CARD, this,
                            GameRenderManager.getInstance().getActivePlayer(),
                            (CardImage) e, (Integer) i);
                EventFactory.getInstance().fireEvent(playerPlayCardEvent);
                return;

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
        if (player && getCribClick()) {
            System.out.println("Player chose: " + cardChosen.getRank() + " of "
                + cardChosen.getSuit());
            System.out.println("Points before: " + pPoints);
            pPoints += cardChosen.getRank().getPointValue();
            System.out.println("Points after: " + pPoints);
        } else if (!player) {
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
     * Initialize the cards.
     */
    public void initializeCards() {

        standardDeck = new ArrayList<>();
        cardsInDeck = new ArrayList<>();
        cardsInPlay = new ArrayList<>();
        cardsInHand = new ArrayList<>();
        cardsInOpponentHand = new ArrayList<>();
        cardsInCrib = new ArrayList<>();
        selectedCardsForDiscarding = new ArrayList<>();

    }

    /**
     * Update the card positions based on the data in the Game object.
     */
    public void updateCardPositions() {
        cardsInDeck.clear();
        cardsInPlay.clear();
        cardsInHand.clear();
        cardsInOpponentHand.clear();
        cardsInCrib.clear();

        List<Card> gameCardsInDeck =
            gameManager.getGame().getDeck().getDeck();
        Card[] gameCardsInPlay =
            gameManager.getGame().getCardsInPlay().getCardsInHand();
        Card[] gameCardsInHand = gameManager.getGame()
            .getPlayerList().get(0).getHand().getCardsInHand();
        Card[] gameCardsInOpponentHand = gameManager.getGame()
            .getPlayerList().get(1).getHand().getCardsInHand();
        Card[] gameCardsInCrib =
            gameManager.getGame().getCribCards().getCardsInHand();

        for (Card card : gameCardsInDeck) {
            CardImage cardImage = standardDeck.get(card.getCardID());
            cardsInDeck.add(cardImage);
            cardImage.setCardPosition(CardPosition.DECK);
        }

        for (Card card : gameCardsInPlay) {
            CardImage cardImage = standardDeck.get(card.getCardID());
            cardsInPlay.add(cardImage);
            cardImage.setCardPosition(CardPosition.IN_PLAY);
        }

        for (Card card : gameCardsInHand) {
            CardImage cardImage = standardDeck.get(card.getCardID());
            cardsInHand.add(cardImage);
            cardImage.setCardPosition(CardPosition.PLAYER_HAND);
        }

        for (Card card : gameCardsInOpponentHand) {
            CardImage cardImage = standardDeck.get(card.getCardID());
            cardsInOpponentHand.add(cardImage);
            cardImage.setCardPosition(CardPosition.OPPONENT_HAND);
        }

        for (Card card : gameCardsInCrib) {
            CardImage cardImage = standardDeck.get(card.getCardID());
            cardsInCrib.add(cardImage);
            cardImage.setCardPosition(CardPosition.IN_CRIB);
        }

    }

    /**
     * Reset card positions.
     */
    public void resetCards() {
        if (!gameManager.deckIsReset()) {
            gameManager.resetCards();
            AnimationManager.getInstance().moveCardsToStandardPositions(50);
        }
    }

    /**
     * Shuffle the deck.
     */
    public void shuffleCards() {
        resetCards();
        gameManager.shuffleCards();
        AnimationManager.getInstance().moveCardsToStandardPositions(50);
    }

    /**
     * Deal the cards.
     */
    public void dealCards() {
        shuffleCards();

        for (int i = 0; i < 6; i++) {
            if (cardsInDeck.size() > 0) {
                gameManager.dealPlayerCards(1);
                AnimationManager.getInstance().moveCardsToStandardPositions(20);
            }
            if (cardsInDeck.size() > 0) {
                gameManager.dealOpponentCards(1);
                AnimationManager.getInstance().moveCardsToStandardPositions(20);
            }
        }
    }

    /**
     * Select a card to discard to the crib.
     * 
     * @param card
     */
    public void selectCardToDiscardToCrib(CardImage card) {
        // If the card is already selected, unselect it
        if (selectedCardsForDiscarding.contains(card)) {

            // Set the button to not be clickable
            AnimationManager.getInstance().setButtonClickable(AnimationManager
                .getInstance().getStartGamePage().getSendCardsToCribButton(),
                false);

            // Remove card from selected cards
            selectedCardsForDiscarding.remove(card);

            // Play animation
            AnimationManager.getInstance().selectCards();

            return;
        }

        // Add the card to be selected
        selectedCardsForDiscarding.add(card);

        // If more than 2 cards are selected, remove the other selected cards
        if (selectedCardsForDiscarding.size() > MAX_DISCARD_TO_CRIB_SIZE) {
            selectedCardsForDiscarding.remove(0);
            selectedCardsForDiscarding.remove(0);
        }

        // Set the send cards to crib button to be clickable
        AnimationManager.getInstance().setButtonClickable(
            AnimationManager.getInstance().getStartGamePage()
                .getSendCardsToCribButton(),
            selectedCardsForDiscarding.size() == MAX_DISCARD_TO_CRIB_SIZE);

        // Play animation to select cards
        AnimationManager.getInstance().selectCards();
    }

    /**
     * Play the card that the player clicked on.
     * 
     * @param clickedCardIndex
     * @return number of cards in play
     */
    public int playerPlayCard(int clickedCardIndex) {

        // Play the card that has been clicked to the center of
        // the board and play an animation
        AnimationManager.getInstance().getGameManager()
            .playCard(clickedCardIndex);
        
        AnimationManager.getInstance().setStandardCardDestinations();
        cardsInDeck.get(0).setUpdateShowing(true);
        AnimationManager.getInstance()
            .cardGlideAnimation(50);

        // Opponent plays a random card, then play an animation
        AnimationManager.getInstance().getGameManager().opponentPlayCard();
        AnimationManager.getInstance().setStandardCardDestinations();
        cardsInDeck.get(0).setUpdateShowing(true);
        AnimationManager.getInstance()
            .cardGlideAnimation(50);

        return AnimationManager.getInstance().getGameManager().getGame()
            .getCardsInPlay().getCardsInHand().length;
    }

    /**
     * Calculate score and move pegs on the board.
     */
    public void movePegs() {
        // Move each peg 5 spaces.

        // TODO
        // In the real game the pegs should more according
        // to the number of points earned during the play
        // phase.
        AnimationManager.getInstance().movePegGlideAnimation(0, 5);
        AnimationManager.getInstance().movePegGlideAnimation(1, 5);

        // If either peg is at the final space, end the
        // game.
        if (AnimationManager.getInstance().getPegLocations()[0] == 120
            || AnimationManager.getInstance().getPegLocations()[1] == 120) {
            AnimationManager.getInstance().getStartGamePage().closeWindow();
        }

        // Deal the cards for the next round
        dealCards();

        // Add the button to send cards to the crib
        AnimationManager.getInstance().getStartGamePage().add(AnimationManager
            .getInstance().getStartGamePage().getSendCardsToCribButton());
        AnimationManager.getInstance().setButtonClickable(AnimationManager
            .getInstance().getStartGamePage().getSendCardsToCribButton(),
            false);
    }

    /**
     * Send the selected cards to the crib and have opponent select 2 random
     * cards to send.
     */
    public void discardCards() {

        for (CardImage cardImage : selectedCardsForDiscarding) {
            int index = cardsInHand.indexOf(cardImage);
            Card card =
                AnimationManager.getInstance().getGameManager().getGame()
                    .getPlayerList().get(0).getHand().getCardsInHand()[index];
            AnimationManager.getInstance().getGameManager().getGame()
                .getPlayerList().get(0).getHand().removeCard(card);
            cardsInHand.remove(index);
            AnimationManager.getInstance().getGameManager().getGame()
                .getCribCards().addCard(card);
        }
        selectedCardsForDiscarding.clear();

        AnimationManager.getInstance().moveCardsToStandardPositions(50);

        for (int i = 0; i < 2; i++) {
            int handSize =
                AnimationManager.getInstance().getGameManager().getGame()
                    .getPlayerList().get(1).getHand().getCardsInHand().length;
            Random rand = new Random();
            int index = rand.nextInt(handSize);
            Card card =
                AnimationManager.getInstance().getGameManager().getGame()
                    .getPlayerList().get(1).getHand().getCardsInHand()[index];
            AnimationManager.getInstance().getGameManager().getGame()
                .getPlayerList().get(1).getHand().removeCard(card);
            AnimationManager.getInstance().getGameManager().getGame()
                .getCribCards().addCard(card);
        }

        AnimationManager.getInstance()
            .moveCardsToStandardPositions(50);

    }

    /**
     * Determine the dealer based on who picked the lower card.
     * 
     * @param clickedCardIndex
     */
    public void determineDealer(int clickedCardIndex) {
        Card card1 = AnimationManager.getInstance().getGameManager().getGame()
            .getDeck().getDeck().remove(clickedCardIndex);
        AnimationManager.getInstance().getGameManager().getGame()
            .getPlayerList().get(0).getHand().addCard(card1);

        AnimationManager.getInstance().setStandardCardDestinations();
        AnimationManager.getInstance().setDestinationOfCards(cardsInDeck, 550,
            330, 550, 0);
        AnimationManager.getInstance().cardGlideAnimation(50);

        Random rand = new Random();
        int index = rand.nextInt(51);
        Card card2 = AnimationManager.getInstance().getGameManager().getGame()
            .getDeck().getDeck().remove(index);
        AnimationManager.getInstance().getGameManager().getGame()
            .getPlayerList().get(1).getHand().addCard(card2);

        AnimationManager.getInstance().setStandardCardDestinations();
        AnimationManager.getInstance().setDestinationOfCards(cardsInDeck, 550,
            330, 550, 0);
        AnimationManager.getInstance().setCardsShowing(cardsInOpponentHand,
            true);
        AnimationManager.getInstance().cardGlideAnimation(50);

        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            LOG.trace("Exception " + e);
        }

        if (card1.getRank().getPointValue() <= card2.getRank()
            .getPointValue()) {
            AnimationManager.getInstance().getStartGamePage().showMessage(
                "Dealer information", "You are the dealer",
                DialogPosition.CENTER_ALL, DialogType.INFORMATION);
        } else {
            AnimationManager.getInstance().getStartGamePage().showMessage(
                "Dealer information", "Opponent is the dealer",
                DialogPosition.CENTER_ALL, DialogType.INFORMATION);
        }

    }

    /**
     * Select the starter card based on what the player clicked.
     * 
     * @param clickedCardIndex
     */
    public void selectStarterCard(int clickedCardIndex) {
        deckManager.moveToTop(
            AnimationManager.getInstance().getGameManager().getGame().getDeck(),
            clickedCardIndex);
        
        AnimationManager.getInstance().setStandardCardDestinations();
        cardsInDeck.get(0).setUpdateShowing(true);
        AnimationManager.getInstance().cardGlideAnimation(50);
        
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
     * Get cards in play.
     * 
     * @return cardsInPlay
     */
    public ArrayList<CardImage> getCardsInPlay() {
        return cardsInPlay;
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
     * Get cards in the crib.
     * 
     * @return cardsInCrib
     */
    public ArrayList<CardImage> getCardsInCrib() {
        return cardsInCrib;
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
}
