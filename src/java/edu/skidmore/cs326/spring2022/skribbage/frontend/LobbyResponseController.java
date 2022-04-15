package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

/**
 * @author Sten Leinasaar
 *         Last Edited : 29 March, 2022
 */
public class LobbyResponseController {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PlayableGame.class);
    }

    /**
     * Constructor method.
     */
    public LobbyResponseController() {
        LOG.trace("Lobby response controller instantiated");

    }

    /**
     * Called from EventManager whenever the properties this.
     * 
     * @param evt
     *            The event to fire
     */
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("LObby response controller fired property change");

    }
}
