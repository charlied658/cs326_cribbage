package edu.skidmore.cs326.spring2022.skribbage.frontend.events;



import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to login.
 * @author Alex Carney
 * 
 * Reviewed and logging added by Sten Leinasaar @at March 22, 2022
 */
public class UserLoginEvent extends AccountEvent {

    /**
     * Private instance of a user object of type User.
     */
    private final User user;
    
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
     * @param source       the bean that fired the event
     * @param user The un-authorized user associated with the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserLoginEvent(Object source, User user) {
        super(source, EventType.USER_LOGIN, user);
        this.user = user;
        LOG.trace("Constructor method reached");
    }
    /**
     * @return an object of user of type User.
     */
    @Override
    public User getUser() {
        LOG.trace("Returning an user object.");
        return user;
    }
    /**
     * @return Event name of type string.
     */
    @Override
    public String getEventName() {
        LOG.trace("Returning a name of the event.");
        return null;
    }


}
