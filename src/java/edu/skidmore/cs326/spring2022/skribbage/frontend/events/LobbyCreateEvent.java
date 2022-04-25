package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;

/**
 * 
 * @author ?
 *
 */
//@SuppressWarnings("serial")
//=======
// * Represents the data transfer object associated with the creation
// * of a lobby for the first time.
// *
// * @author Alex Carney
// */
public class LobbyCreateEvent extends LobbyEvent {

    /**
     * Constructor method for LobbyEvent.java.
     *
     * @param source
     *            The bean that fired the event
     * @param args
     *            args[0] is the lobby
     */
    protected LobbyCreateEvent(Object source, Object... args) {
        super(source, EventType.LOBBY_CREATE_LOBBY, (Lobby) args[0]);
    }

    /**
     * @return The name of the event of type String.
     */
    @Override
    public EventType getEventType() {
        return EventType.LOBBY_CREATE_LOBBY;
    }
}
