package edu.skidmore.cs326.spring2022.skribbage.common;

import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.AnimationManager;
import edu.skidmore.cs326.spring2022.skribbage.frontend.GameRenderManager;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerPlayCardEvent;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The finite state machine implementation for the Skribbage game loop.
 * States are represented by the GameState enum, and transitions are
 * events fired from the front end.
 *
 * @author Alex Carney
 */
public final class GameController implements PropertyChangeListener {
    /**
     * Log.
     */
    private static final Logger LOG;

    /**
     * private static final instance for eager singleton.
     */
    private static final GameController INSTANCE;

    static {
        LOG = Logger.getLogger(GameController.class);
        INSTANCE = new GameController();
    }

    /**
     * Only discard 2 cards to the crib at once.
     */
    private static final int MAX_DISCARD_TO_CRIB_SIZE = 2;

    /**
     * State of the game.
     */
    private GameState currentGameState;

    /**
     * Event factory for firing events.
     */
    @SuppressWarnings("unused")
    private final EventFactory eventFactory;

    /**
     * Animation manager for rendering the front end.
     */
    private final AnimationManager animationManager;

    /**
     * Game render manager for rendering front end.
     */
    private final GameRenderManager gameRenderManager;

    /**
     * Private constructor for singleton.
     */
    private GameController() {
        eventFactory = EventFactory.getInstance();
        animationManager = AnimationManager.getInstance();
        currentGameState = GameState.START_GAME;
        gameRenderManager = GameRenderManager.getInstance();
    }

    /**
     * Fired whenever an event that this listener is listening to is caught.
     * Should always be a CribbageEvent game, otherwise a ClassCastException
     * will be thrown
     *
     * @param evt
     *            The caught event.
     * @throws ClassCastException
     *             Caught event is not of type CribbageEvent
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("GameController caught event: " + evt);
        CribbageEvent cribbageEvent = ((CribbageEvent) evt);
        switch (cribbageEvent.getEventType()) {
            case PLAYER_CLICK_START_GAME:
                LOG.debug("caught a player click start game event " + evt);
                if (currentGameState == GameState.START_GAME) {
                    currentGameState = GameState.CUT_DECK;

                    // When the game starts, cards are fanned out to click on
                    animationManager.fanCards();

                }
                break;
            case PLAYER_CLICK_DECK:
                LOG.debug("caught a player click deck game event " + evt);
                switch (currentGameState) {
                    case CUT_DECK:
                        currentGameState = GameState.DISCARD_TO_CRIB;

                        // TODO decide dealer based on who picked the lower card

                        // Deal cards and wait for player to discard cards to
                        // crib
                        gameRenderManager.getSelectedCardsForDiscarding()
                            .clear();
                        gameRenderManager.dealCards();
                        animationManager.getStartGamePage().add(animationManager
                            .getStartGamePage().getSendCardsToCribButton());
                        animationManager.setButtonClickable(animationManager
                            .getStartGamePage().getSendCardsToCribButton(),
                            false);
                        break;
                    case STARTER_CARD:
                        currentGameState = GameState.PLAY_CARD;
                        animationManager.moveCardsToStandardPositions(50);
                        // Put the cards back on the deck, with the top card
                        // flipped
                        // TODO this
                        // animationManager
                        // .moveCardsBackToTopOfDeckWithTopShowing();
                        break;
                    default:
                        break;

                }
                break;

            case PLAYER_PLAY_CARD:
                LOG.debug("player played card to game " + evt);
                // A nicer way to compare multiple things for equality, rather
                // than doing state == a or state == b or ...
                switch (currentGameState) {
                    case DISCARD_TO_CRIB:
                        // downcast CribbageEvent to PlayerPlayCardEvent
                        PlayerPlayCardEvent playerPlayCardEvent =
                            (PlayerPlayCardEvent) cribbageEvent;

                        // Select card to discard to the crib
                        gameRenderManager.selectCardToDiscardToCrib(
                            playerPlayCardEvent.getCardImage());

                        break;
                    case PLAY_CARD:
                        PlayerPlayCardEvent playCardEvent =
                            (PlayerPlayCardEvent) cribbageEvent;

                        int clickedCardIndex =
                            playCardEvent.getClickedCardIndex();

                        // Play card to center of board then have opponent play
                        // a random card
                        int numCardsInPlay =
                            gameRenderManager.playerPlayCard(clickedCardIndex);

                        // Check if there are no more cards to play. Each player
                        // is initially dealt 6 cards so this occurs when the
                        // number of cards in play is 12.
                        if (numCardsInPlay == 12) {

                            // Move each peg 5 spaces. This is a temporary test.
                            // In the real game the pegs should more according
                            // to the number of points earned during the play
                            // phase.
                            animationManager.movePegGlideAnimation(0, 5);
                            animationManager.movePegGlideAnimation(1, 5);

                            // If either peg is at the final space, end the
                            // game.
                            if (animationManager.getPegLocations()[0] == 120
                                || animationManager
                                    .getPegLocations()[1] == 120) {
                                animationManager.getStartGamePage()
                                    .closeWindow();
                            }

                            // Move to discard to crib state again
                            currentGameState = GameState.DISCARD_TO_CRIB;
                            gameRenderManager.dealCards();
                            animationManager.getStartGamePage()
                                .add(animationManager
                                    .getStartGamePage()
                                    .getSendCardsToCribButton());
                            animationManager.setButtonClickable(animationManager
                                .getStartGamePage().getSendCardsToCribButton(),
                                false);
                        }

                        // Set the cards to be clickable again
                        animationManager.setCardsClickable(true);
                        break;
                    default:
                        break;

                }
                break;

            case PLAYER_SEND_CARD_TO_CRIB:
                if (gameRenderManager.getSelectedCardsForDiscarding()
                    .size() == MAX_DISCARD_TO_CRIB_SIZE) {
                    // TODO here
                    // animationManager.discardCards();
                    animationManager.getStartGamePage().remove(animationManager
                        .getStartGamePage().getSendCardsToCribButton());
                    currentGameState = GameState.STARTER_CARD;
                    GameRenderManager.getInstance()
                        .getSelectedCardsForDiscarding().clear();
                    animationManager.fanCards();

                }

            default:
                LOG.error(
                    "Caught an event that could not be handled."
                        + " Reached default statement "
                        + evt);
                break;
        }
    }

    /**
     * Gets the state of this game.
     *
     * @return the state of the game.
     */
    public GameState getCurrentGameState() {
        return currentGameState;
    }

    /**
     * Set the current game state.
     * 
     * @param gameState
     *            state of the game
     */
    public void setCurrentGameState(GameState gameState) {
        this.currentGameState = gameState;
    }

    /**
     * Get instance of singleton.
     *
     * @return Instance
     */
    public static GameController getInstance() {
        return INSTANCE;
    }
}
