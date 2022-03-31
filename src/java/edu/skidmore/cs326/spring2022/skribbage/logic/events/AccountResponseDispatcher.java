package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;

import edu.skidmore.cs326.spring2022.skribbage.common.EventDispatcher;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * @author Declan Morris & Alex Carney
 */
public class AccountResponseDispatcher implements EventDispatcher {

    /**
     * Single instance of eventManager used.
     */
    private final EventManager eventManager;

    /**
     * Allows other classes to get single instance of eventManager.
     */
    public AccountResponseDispatcher() {
        eventManager = EventManager.getInstance();

    }

    /**
     * Uses LogicFactoryTemplate to create and fire events.
     * 
     * @param eventType
     *            The type of event being fired.
     * @param user
     *            The user associated with the event.
     * @param success
     *            Whether or not the request was rejected.
     * @param responseMessage
     *            The message passed along with the event.
     */
    public void accountEventResponseFactory(EventType eventType,
        User user, boolean success, String responseMessage) {
        PropertyChangeEvent eventToFire;
        switch (eventType) {
            case USER_LOGIN_RESPONSE:
                eventToFire = new UserLoginResponseEvent(eventType, user,
                    success, responseMessage);
                break;

            default:
                throw new IllegalStateException(
                    "Unexpected value: " + eventType);
        }
        fireEvent(eventToFire);
    }

    @Override
    public void fireEvent(PropertyChangeEvent event) {
        eventManager.notify(event);
    }
}
