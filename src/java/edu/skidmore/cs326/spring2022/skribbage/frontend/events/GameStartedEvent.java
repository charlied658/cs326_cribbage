package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;

import java.beans.PropertyChangeEvent;

/**
 *
 */
public class GameStartedEvent extends PropertyChangeEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param eventType the programmatic name of the property that was changed
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public GameStartedEvent(Object source, EventType eventType) {
        super(source, eventType.toString(), null, null);
    }

}
