package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponse;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponseEvent;

/**
 * Response controller for UserChangePassword Event.
 * 
 * @author Sten Leinasaar
 */
@SuppressWarnings("serial")
public class UserDeleteAccountResponseEvent extends AccountResponseEvent {

    /**
     * Constructor of UserChangePasswordController. Responsible for calling the
     * super method.
     * 
     * @param source
     * @param args
     *            A list of arguments.
     *            A list of arguments.
     *            Object at args[0] --> User object.
     *            Object at args[1] --> account response
     */
    public UserDeleteAccountResponseEvent(Object source, Object... args) {
        super(source, EventType.USER_DELETE_ACCOUNT_RESPONSE, (User) args[0],
            (AccountResponse) args[1]);

    }

    /**
     * Allows other classes to read the eventType of this Event.
     */
    @Override
    public EventType getEventType() {
        return EventType.USER_DELETE_ACCOUNT_RESPONSE;
    }

    /**
     * Allows other classes to read ChangePassword Event response.
     */
    @Override
    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

}
