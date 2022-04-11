package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * @author Declan Morris & Alex Carney
 */
public class UserLoginResponseEvent extends AccountResponseEvent {

    /**
     * Event type.
     */
    private static final EventType EVENTTYPE = EventType.USER_LOGIN_RESPONSE;

    /**
     * Getter for user.
     * 
     * @return the user
     */
    @Override
    public User getUser() {
        return user;
    }

    /**
     * Default constructor.
     * 
     * @param source
     *            The bean that fired the event.
     * @param args
     *            Expected to include the user, rejectionStatus, and
     *            responseMessage in that order.
     */
    public UserLoginResponseEvent(Object source, Object... args) {
        super(source, EventType.USER_LOGIN_RESPONSE, (User) args[0],
            (Boolean) args[1],
            (String) args[2]);
    }
}
