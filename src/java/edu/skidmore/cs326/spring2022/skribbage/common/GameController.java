package edu.skidmore.cs326.spring2022.skribbage.common;

import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
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
public class GameController implements PropertyChangeListener {
    /**
     * Log.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(GameController.class);
    }

    private EventFactory eventFactory = EventFactory.getInstance();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("GameController caught event: " + evt);

        CribbageEvent cribbageEvent = ((CribbageEvent) evt);

        switch(cribbageEvent.getEventType()) {

        }

    }
}
