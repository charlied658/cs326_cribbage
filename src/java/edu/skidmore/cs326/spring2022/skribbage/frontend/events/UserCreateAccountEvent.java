package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * The UserCreateAccountEvent implements an event class that extends
 * AccountEvent abstract class.
 * 
 * @
 *   @author Alex Carney
 *   Reviewed, commented, Logging added bv Sten Leinasaar
 */
@SuppressWarnings("serial")
public class UserCreateAccountEvent extends AccountEvent {
    /**
     * Private static final Logger variable.
     */
    private static final Logger LOG;

    /**
     * Input password associated with login request.
     */
    private final Password password;

    static {
        LOG = Logger.getLogger(UserCreateAccountEvent.class);
    }

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param args
     *            list of arguments based on enum.
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     *             source, User associatedUser
     */
    public UserCreateAccountEvent(Object source, Object... args) {
        super(source, EventType.USER_CREATE_ACCOUNT, (User) args[0]);
        password = (Password) args[1];
        LOG.trace(" Constructor reached.");
    }

    /**
     * @return return password associated with event.
     */
    public Password getPassword() {
        return password;
    }

    @Override
    public EventType getEventType() {
        LOG.trace("Returning an event name");
        return EventType.USER_CREATE_ACCOUNT;
    }
}
