package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * @author Alex Carney
 *         Reviewed, commented, Logging added bv Sten Leinasaar
 */
public class UserCreateAccountEvent extends AccountEvent {
    /**
     * Private user instance of type user.
     */
    private final User user;

    /**
     * Private static final Logger variable.
     */
    private static final Logger LOG;

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
        this.user = (User) args[0];
        LOG.trace(" Constructor reached.");
    }

    /**
     * @return An object of type user is returned.
     */
    @Override
    public User getUser() {
        LOG.info(" Returning the user object");
        return user;
    }

    @Override
    public String getEventName() {
        LOG.trace("Returning an event name");
        return EventType.USER_CREATE_ACCOUNT.getName();
    }
}
