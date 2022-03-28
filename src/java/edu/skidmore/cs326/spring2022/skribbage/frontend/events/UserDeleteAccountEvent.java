package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * @author Alex Carney
 *         Edited, reviewed, commented, Logging added by Sten Leinasaar
 */
public class UserDeleteAccountEvent extends AccountEvent {
    /**
     * Private static final instance of a logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserDeleteAccountEvent.class);
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
    public UserDeleteAccountEvent(Object source, Object... args) {
        super(source, EventType.USER_DELETE_ACCOUNT, (User) args[0]);
        LOG.trace("Constructor method reached");
    }

    /**
     * @return Event name of type string.
     */
    @Override
    public String getEventName() {
        LOG.trace("Returning an event name of type String");
        // TODO Auto-generated method stub
        return EventType.USER_DELETE_ACCOUNT.getName();
    }
}
