package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * Event that is fired to verify the user before change password can be allowed.
 * .
 *
 * @author Sten Leinasaar
 */
@SuppressWarnings("serial")
public class ValidateForChangePassword extends AccountEvent {
    /**
     * Private static final Logger instance.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(ValidateForChangePassword.class);
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
    public ValidateForChangePassword(Object source, Object... args) {
        super(source, EventType.USER_CHANGE_PASSWORD_VALIDATION,
            (User) args[0]);
        LOG.trace("Constructor method reached");
    }

    /**
     * @return Type of the Event.
     */
    @Override
    public EventType getEventType() {
        LOG.trace("Returning a name of the event.");
        return EventType.USER_CHANGE_PASSWORD_VALIDATION;
    }

}
