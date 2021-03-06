package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;

/**
 * Event fired when the user clicks 'start game' for the first time.
 */
@SuppressWarnings("serial")
public class PlayerSendCardsToCribEvent extends CribbageEvent {

    /**
     * This event type.
     */
    private static final EventType EVENT_TYPE =
        EventType.PLAYER_SEND_CARD_TO_CRIB;

    /**
     * Event associated with a user attempting to start a game.
     *
     * @param source bean that fired the event.
     * @param args   Player object
     * @author Alex Carney
     */
    public PlayerSendCardsToCribEvent(Object source, Object... args) {
        super(source, EVENT_TYPE, (Player) args[0]);
    }

    /**
     * @return event type.
     */
    @Override
    public EventType getEventType() {
        return EVENT_TYPE;
    }
}
