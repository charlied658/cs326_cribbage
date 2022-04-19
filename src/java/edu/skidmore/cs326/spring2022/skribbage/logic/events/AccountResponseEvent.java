package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

import java.beans.PropertyChangeEvent;

/**
 * @author Declan Morris & Alex Carney
 */
@SuppressWarnings("serial")
public abstract class AccountResponseEvent extends PropertyChangeEvent {

    /**
     * Contains String message and boolean rejection status sent with the event.
     */
    protected LoginResponse loginResponse;

    /**
     * The user associated with the event.
     */
    private final User user;

    /**
     * Default Constructor.
     * 
     * @param source
     *            The bean that fired the event.
     * @param eventType
     *            The string format of the event name.
     * @param user
     *            The user who is associated with this event.
     * @param loginResponse
     *            The message and rejection status communicated by the event.
     */
    protected AccountResponseEvent(Object source, EventType eventType,
        User user,
        LoginResponse loginResponse) {
        super(source, eventType.toString(), null, null);
        this.user = user;
        this.loginResponse = loginResponse;
    }

    /**
     * Allows outside code to see the event's user.
     * 
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Allows outside code to see the event type.
     * 
     * @return eventType
     */
    public abstract EventType getEventType();

    /**
     * Allows outside code to see LoginResponse.
     * 
     * @return loginResponse
     */
    public abstract LoginResponse getLoginResponse();
}
