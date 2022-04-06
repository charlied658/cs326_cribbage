package edu.skidmore.cs326.spring2022.skribbage;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.frontend.AccountResponseController;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.HomeScreen;

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
    private HomeScreen homePage;

    /**
     * Singleton eventManager instance.
     */
    private EventManager eventManager;

    /**
     * Singleton eventFactory instance.
     */
    private EventFactory eventFactory;

    /**
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
        System.out.println(getWelcomeMessage());
        LOG.info("Run method started");
        LOG.info("homePage started by intilizing it.");
        // Instantiate required class instances
        this.homePage = new HomeScreen();
        this.eventFactory = EventFactory.getInstance();
        this.eventManager = EventManager.getInstance();

        this.eventManager
            .addPropertyChangeListener(new AccountResponseController());



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
     * @param args Command line argument - not currently used
     */
    public static void main(String[] args) {
        new Thread(new SkribbageBattleRoyale()).start();
    }
}
