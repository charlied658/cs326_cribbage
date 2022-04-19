package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;

/**
 * Event that will fire when all players are in a lobby, and the host clicks
 * "START".
 * 
 * @author Alex Carney
 */
@SuppressWarnings("serial")
public class LobbyStartGameEvent extends LobbyEvent {
    /**
     * Logger instance.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LobbyStartGameEvent.class);
    }

    /**
     * Constructor method for LobbyEvent.java.
     *
     * @param source
     *            The bean that fired the event
     * @param eventType
     *            The event type associated
     *            Will also require the lobby being destroyed, unless deemed
     *            unnecessary. At the very least, the lobby ID that
     *            called this event will be required.
     */
    public LobbyStartGameEvent(Object source, EventType eventType) {
        super(source, eventType);
        LOG.trace("Constructor method of LobbyStartGameEvent.");
    }

    /**
     * @return Event type as specified in enum.
     */
    @Override
    public EventType getEventType() {
        LOG.trace("EventType returned in LobbyStartGameEvent.java.");
        return EventType.LOBBY_START_GAME;
    }
}
