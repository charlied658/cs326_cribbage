package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;


import java.beans.PropertyChangeEvent;

/**
 * @author Declan Morris & Alex Carney
 */
public abstract class AccountResponseEvent extends PropertyChangeEvent {
    
    /**
     * The type of event.
     */
    private EventType eventType;
    
    /**
     * Message passed back to front end.
     */
    protected final String responseMessage;

    /**
     * Rejection status of event.
     */
    protected final boolean rejected;

    /**
     * The user associated with the event.
     */
    protected final User user;
    
    /**
     * Default Constructor.
     * 
     * @param source
     *            The bean that fired the event.
     * @param eventType
     *            The string format of the event name.
     * @param user
     *            The user who is associated with this event.
     * @param rejectionStatus
     *            Whether the user's request has been rejected.
     * @param responseMessage
     *            The message passed to front end
     */
    public AccountResponseEvent(Object source, EventType eventType, User user,
        boolean rejectionStatus, String responseMessage) {
        super(source, eventType.toString(), null, null);
        this.user = user;
        this.rejected = rejectionStatus;
        this.responseMessage = responseMessage;
    }

    /**
     * Allows outside code to see the event's rejection status.
     * 
     * @return rejected
     */
    public boolean isRejected() {
        return rejected;
    }

    /**
     * Allows outside code to see the event's response message.
     * 
     * @return responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
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
     * @return eventType
     */
    public EventType getEventType() {
        return eventType;
    }

}
