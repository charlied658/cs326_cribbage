package edu.skidmore.cs326.spring2022.skribbage.common.events;

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
public abstract class CribbageEvent extends PropertyChangeEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param eventName
     *            the string type of the event.
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public CribbageEvent(Object source, String eventName) {
        super(source, eventName, null, null);
    }

}
