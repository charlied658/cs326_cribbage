package edu.skidmore.cs326.spring2022.skribbage.common.events;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

import java.beans.PropertyChangeEvent;

/**
 * An abstract representation of an Event used to communicate data between modules.
 * Extends the built in PropertyChangeEvent, hiding some of its unused
 * functionality
 *
 * @author Alex Carney
 * @reviewedby
 */
public abstract class AccountEvent extends PropertyChangeEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public AccountEvent(Object source, String eventName, User associatedUser) {
        super(source, eventName, null, null);
    }

    public User getUser;
    public String getEventName;



}

