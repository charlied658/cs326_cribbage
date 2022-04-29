package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * @author Declan Morris & Alex Carney
 */
@SuppressWarnings("serial")
public class UserLoginResponseEvent extends AccountResponseEvent {

    /**
     * Event type.
     */
    private static final EventType EVENTTYPE = EventType.USER_LOGIN_RESPONSE;

    /**
     * Logger Instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserLoginResponseEvent.class);
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
        super(source, EVENTTYPE, (User) args[0],
            (AccountResponse) args[1]);
        LOG.info("Constructor reached. Calling super");
    }

    /**
     * Allows other classes to read EventType of the event.
     */
    @Override
    public EventType getEventType() {
        LOG.info("Returning an event type.");
        return EVENTTYPE;
    }

    /**
     * Allows other classes to read LoginResponse of the event.
     */
    @Override
    public AccountResponse getAccountResponse() {
        LOG.info(" Returning an accountResponse.");
        return accountResponse;
    }
}
