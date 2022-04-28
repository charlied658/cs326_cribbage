package edu.skidmore.cs326.spring2022.skribbage.common.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;

import java.beans.PropertyChangeEvent;

/**
 * An abstract representation of an Event used to communicate data between
 * modules.
 * Extends the built in PropertyChangeEvent, hiding some of its unused
 * functionality
 *
 * @author Alex Carney
 *         Reviewed
 */
@SuppressWarnings("serial")
public abstract class CribbageEvent extends PropertyChangeEvent {

    /**
     * All cribbage events require a player.
     */
    private final Player player;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param eventType
     *            event type of subclass
     * @param player
     *            Player who fired the event
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    protected CribbageEvent(Object source, EventType eventType, Player player) {
        super(source, eventType.toString(), null, null);
        this.player = player;
    }

    /**
     * Return player associated with event.
     * 
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Method that returns a string format of the event name.
     *
     * @return String type of the event name.
     */
    public abstract EventType getEventType();
}
