package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * @author Declan Morris
 */
@SuppressWarnings("serial")
public class CreateAccountResponseEvent extends AccountResponseEvent {

    /**
     * Event type.
     */
    private static final EventType EVENTTYPE =
        EventType.USER_CREATE_ACCOUNT_RESPONSE;

    /**
     * Default constructor.
     * 
     * @param source
     * @param args
     */
    protected CreateAccountResponseEvent(Object source, Object... args) {
        super(source, EVENTTYPE, (User) args[0], (AccountResponse) args[1]);

    }
    
    @Override
    public EventType getEventType() {
        return EVENTTYPE;
    }

    @Override
    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

}
