package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * @author Alex Carney
 *         Reviewed, commented, Logging added  bv Sten Leinasaar
 */
@SuppressWarnings("serial")
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
     * @param associatedUser
     *            The email, username, and password supplied with the new
     *            account request
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public UserCreateAccountEvent(Object source, User associatedUser) {
        super(source, EventType.USER_CREATE_ACCOUNT.toString(), associatedUser);
        this.user = associatedUser;
        LOG.trace(" Constructor reached.");
    }
    /**
     * @return An object of type user is returned.
     */
    public User getUser() {
        LOG.info(" Returning the user object");
        return user;
    }

    @Override
    public String getEventName() {
        LOG.trace("Returning an event name");
        return null;
    }
}
