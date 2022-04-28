package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.CardImage;

/**
 * Event fired when the user clicks 'start game' for the first time.
 */
public class PlayerPlayCardEvent extends CribbageEvent {

    /**
     * This event type.
     */
    private static final EventType EVENT_TYPE =
        EventType.PLAYER_PLAY_CARD;

    /**
     * Associated card image.
     */
    private final CardImage cardImage;

    /**
     * Event associated with a user attempting to start a game.
     *
     * @param source bean that fired the event.
     * @param args   Player object
     * @author Alex Carney
     */
    public PlayerPlayCardEvent(Object source, Object... args) {
        super(source, EVENT_TYPE, (Player) args[0]);
        this.cardImage = (CardImage) args[1];
    }

    /**
     * @return event type.
     */
    @Override
    public EventType getEventType() {
        return EVENT_TYPE;
    }

    /**
     * Returns card image.
     * @return card image.
     */
    public CardImage getCardImage() {
        return cardImage;
    }
}
