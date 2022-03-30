package edu.skidmore.cs326.spring2022.skribbage.common.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;

import java.beans.PropertyChangeEvent;

/**
 * An abstract representation of an Event used to communicate data between
 * modules.
 * Extends the built in PropertyChangeEvent, hiding some of its unused
 * functionality
 * Yes this is what it does
 *
 * @author Alex Carney
 * Reviewed
 */
public abstract class CribbageEvent extends PropertyChangeEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source    the bean that fired the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public CribbageEvent(Object source, EventType eventType, Game game) {
        super(source, eventType.toString(), null, null);

    }
}
