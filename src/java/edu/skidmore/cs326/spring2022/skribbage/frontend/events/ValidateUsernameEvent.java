package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to create a new account.
 * When the user enters a username, that username is immediately checked
 * for validation and appropriateness.
 *
 * @author Alex Carney
 */
@SuppressWarnings("serial")
public class ValidateUsernameEvent extends AccountEvent {
    /**
     * Private static final Logger instance.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserLoginEvent.class);
    }

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param args
     *            List of arguments.
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public ValidateUsernameEvent(Object source, Object... args) {
        super(source, EventType.VALIDATE_USERNAME, (User) args[0]);
        LOG.trace("Constructor method reached");
    }

    /**
     * @return Event name of type string.
     */
    @Override
    public EventType getEventType() {
        LOG.trace("Returning a name of the event.");
        return EventType.VALIDATE_USERNAME;
    }

}
