package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;

public class LobbyCreateEvent extends LobbyEvent {

    /**
     * Constructor method for LobbyEvent.java.
     *
     * @param source    The bean that fired the event
     * @param args      args[0] is the lobby
     */
    protected LobbyCreateEvent(Object source, Object... args) {
        super(source, EventType.LOBBY_CREATE_GAME, (Lobby) args[0]);
    }

    /**
     * @return The name of the event of type String.
     */
    @Override
    public EventType getEventType() {
        return null;
    }
}