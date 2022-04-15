package edu.skidmore.cs326.spring2022.skribbage.frontend;

import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handles responses to events involving the game started.
 * Note that all of the functionality of this class is blocked
 * by logic tier as of 4/14.
 * @author Alex Carney
 */
public class GameStartedResponseController implements PropertyChangeListener {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(GameStartedResponseController.class);
    }

    /**
     * Constructor method.
     */
    public GameStartedResponseController() {
        LOG.trace("Game started response controller created");
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("Game response controller fired property change");
        CribbageEvent cribbageEvent = (CribbageEvent) evt;

        switch (cribbageEvent.getEventType()) {
            case LOBBY_START_GAME:
                LOG.debug("lobby started a game");
                break;
            default:
                LOG.warn("caught unhandled event");
        }
    }
}
