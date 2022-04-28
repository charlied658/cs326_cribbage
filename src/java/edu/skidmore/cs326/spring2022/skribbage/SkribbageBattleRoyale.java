package edu.skidmore.cs326.spring2022.skribbage;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.GameController;
import edu.skidmore.cs326.spring2022.skribbage.frontend.AccountResponseController;
import edu.skidmore.cs326.spring2022.skribbage.frontend.GameStartedResponseController;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.HomeScreen;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountController;

/**
 * The game of Cribbage, with a few twists and turns.
 */
public class SkribbageBattleRoyale implements Runnable {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * HomeScreen instance to start the home page from driver class.
     */
    @SuppressWarnings("unused")
    private HomeScreen homePage;

    /**
     * Singleton eventManager instance.
     */
    private EventManager eventManager;

    /**
     * Singleton eventFactory instance.
     */
    @SuppressWarnings("unused")
    private EventFactory eventFactory;

    /*
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(SkribbageBattleRoyale.class);
    }

    /**
     * No-argument constructor, sets up the program using default values.
     */
    public SkribbageBattleRoyale() {
        LOG.info("Initializing");
    }

    @Override
    public void run() {
        LOG.warn(getWelcomeMessage());
        LOG.info("Run method started");
        LOG.info("homePage started by initializing it.");
        // Instantiate required class instances
        homePage = new HomeScreen();
        eventFactory = EventFactory.getInstance();
        eventManager = EventManager.getInstance();
        eventManager
            .addPropertyChangeListener(new AccountResponseController(),
                EventType.USER_LOGIN_RESPONSE,
                EventType.USER_VALIDATION_RESPONSE,
                EventType.USER_CHANGE_PASSWORD_VALIDATION_RESPONSE,
                EventType.USER_CHANGE_PASSWORD_RESPONSE,
                EventType.USER_CREATE_ACCOUNT_RESPONSE,
                EventType.USER_DELETE_ACCOUNT_RESPONSE);

        eventManager
            .addPropertyChangeListener(new AccountController(),
                EventType.USER_LOGIN, EventType.USER_CREATE_ACCOUNT,
                EventType.VALIDATE_USERNAME,
                EventType.USER_CHANGE_PASSWORD_VALIDATION,
                EventType.USER_CHANGE_PASSWORD, EventType.USER_DELETE_ACCOUNT);

        eventManager
            .addPropertyChangeListener(new GameStartedResponseController(),
                EventType.LOBBY_START_GAME);

        eventManager
            .addPropertyChangeListener(
                GameController.getInstance(),
                EventType.PLAYER_CLICK_DECK,
                EventType.PLAYER_CLICK_START_GAME,
                EventType.PLAYER_SEND_CARD_TO_CRIB,
                EventType.PLAYER_PLAY_CARD,
                EventType.PLAYER_SELECT_START_CARD);

    }

    /**
     * Get the application's initial welcome message.
     *
     * @return Welcome message
     */
    public String getWelcomeMessage() {
        return "Skribbage Battle Royale: Under Construction";
    }

    /**
     * The starting point of the Cribbage application.
     *
     * @param args
     *            Command line argument - not currently used
     */
    public static void main(String[] args) {
        new Thread(new SkribbageBattleRoyale()).start();
    }
}
