package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to login.
 * 
 * @author Alex Carney
 *         Reviewed and logging added by Sten Leinasaar @at March 22, 2022
 */
@SuppressWarnings("serial")
public class UserLoginEvent extends AccountEvent {
    /**
     * Private static final Logger instance.
     */
    private static final Logger LOG;

    /**
     * Input password associated with login request.
     */
    private final String password;

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
    public UserLoginEvent(Object source, Object... args) {
        super(source, EventType.USER_LOGIN, (User) args[0]);
        password = (String) args[1];
        LOG.trace("Constructor method reached");
    }

    /**
     * @return Password associated with event.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return Event name of type string.
     */
    @Override
    public EventType getEventType() {
        LOG.trace("Returning a name of the event.");
        return EventType.USER_LOGIN;
    }

}
