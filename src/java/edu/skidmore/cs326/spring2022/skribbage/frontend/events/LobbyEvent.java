package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;

import java.beans.PropertyChangeEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: March 23, 2022
 *         reviewed by Alex Carney - Added lobby
 *         functionality now that the bean is done
 *         April 21, 2022
 */
@SuppressWarnings("serial")
public abstract class LobbyEvent extends PropertyChangeEvent {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    /**
     * The lobby associated with the event.
     */
    private final Lobby lobby;

    static {
        LOG = Logger.getLogger(LobbyEvent.class);
    }

    /**
     * Constructor method for LobbyEvent.java.
     *
     * @param source
     *            The bean that fired the event
     * @param eventType
     *            The event type associated
     * @param lobby
     */
    protected LobbyEvent(Object source, EventType eventType, Lobby lobby) {
        super(source, eventType.toString(), null, null);
        LOG.trace("Constructor reached in LobbEvent.java");
        this.lobby = lobby;

    }

    /**
     * @return The name of the event of type String.
     */
    public abstract EventType getEventType();

    /**
     * getLobby method.
     * 
     * @return the lobby
     */
    public Lobby getLobby() {
        return lobby;
    }

}
