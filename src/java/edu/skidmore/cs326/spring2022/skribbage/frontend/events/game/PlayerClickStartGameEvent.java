package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;

/**
 * Event fired when the user clicks 'start game' for the first time.
 */
public class PlayerClickStartGameEvent extends CribbageEvent {

    /**
     * This event type.
     */
    private static final EventType EVENT_TYPE =
        EventType.PLAYER_CLICK_START_GAME;

    /**
     * Event associated with a user attempting to start a game.
     *
     * @param source bean that fired the event.
     * @param args   Player object
     * @author Alex Carney
     */
    protected PlayerClickStartGameEvent(Object source, Object... args) {
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
