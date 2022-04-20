package edu.skidmore.cs326.spring2022.skribbage.common.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;

import java.beans.PropertyChangeEvent;

/**
 * An abstract representation of an Event used to communicate data between
 * modules.
 * Extends the built in PropertyChangeEvent, hiding some of its unused
 * functionality
 * Yes this is what it does
 *
 * @author Alex Carney
 *         Reviewed
 */
@SuppressWarnings("serial")
public abstract class CribbageEvent extends PropertyChangeEvent {

    /**
     * Game object, all subclasses of cribbage event contain one.
     */
    private final Game game;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param eventType
     *            event type of subclass
     * @param game
     *            a game object, all cribbage events have access to
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    protected CribbageEvent(Object source, EventType eventType, Game game) {
        super(source, eventType.toString(), null, null);
        this.game = game;
    }

    /**
     * Returns game object associated with event.
     * 
     * @return game object stored with this event
     */
    public Game getGame() {
        return game;
    }

    /**
     * Method that returns a string format of the event name.
     *
     * @return String type of the event name.
     */
    public abstract EventType getEventType();
}
