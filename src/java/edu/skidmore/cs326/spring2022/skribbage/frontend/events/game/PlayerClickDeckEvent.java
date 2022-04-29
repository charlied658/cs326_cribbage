package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.CardImage;

/**
 * Event fired when the user clicks 'start game' for the first time.
 */
@SuppressWarnings("serial")
public class PlayerClickDeckEvent extends CribbageEvent {

    /**
     * This event type.
     */
    private static final EventType EVENT_TYPE =
        EventType.PLAYER_CLICK_DECK;
    
    /**
     * Associated card image.
     */
    private CardImage cardImage;
    
    /**
     * Index of card that has been clicked.
     */
    private Integer clickedCardIndex;

    /**
     * Event associated with a user attempting to start a game.
     *
     * @param source
     *            bean that fired the event.
     * @param args
     *            Player object
     * @author Alex Carney
     */
    public PlayerClickDeckEvent(Object source, Object... args) {
        super(source, EVENT_TYPE, (Player) args[0]);
        this.cardImage = (CardImage) args[1];
        this.clickedCardIndex = (Integer) args[2];
    }

    /**
     * @return event type.
     */
    @Override
    public EventType getEventType() {
        return EVENT_TYPE;
    }
    
    /**
     * Get the card image.
     * @return cardImage
     */
    public CardImage getCardImage() {
        return cardImage;
    }
    
    /**
     * Get the clicked card index.
     * @return clickedCardIndex
     */
    public int getClickedCardIndex() {
        return clickedCardIndex;
    }
    
}
