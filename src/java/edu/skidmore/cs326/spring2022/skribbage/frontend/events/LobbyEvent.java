package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: March 23, 2022
 */
@SuppressWarnings("serial")
public class LobbyEvent extends CribbageEvent {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LobbyEvent.class);
    }

    /**
     * Constructor method for LobbyEvent.java.
     * 
     * @param source
     *            The bean that fired the event
     *            
     */
    public LobbyEvent(Object source) {
        super(source, EventType.LOBBY_EVENT.getName());
        LOG.trace("Constructor reached in LobbEvent.java");
        
    }

    /**
     * @return The name of the event of type String.
     */
    public String getEventName() {
        LOG.trace("Returning a event name for Lobby Event");
        return EventType.LOBBY_EVENT.getName();
    }

}
