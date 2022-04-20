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
public class UserChangePasswordResponseEvent extends AccountResponseEvent {

    protected UserChangePasswordResponseEvent(Object source,
        EventType eventType, User user, AccountResponse loginResponse) {
        super(source, eventType, user, loginResponse);
        // TODO Auto-generated constructor stub
    }

    // protected UserChangePasswordResponseEvent(Object source, Object...args) {
    // //super(source, EventType.USER_CHANGE_PASSWORD, args[0], args[1]);
    // // TODO Auto-generated constructor stub
    // }

    @Override
    public EventType getEventType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AccountResponse getAccountResponse() {
        // TODO Auto-generated method stub
        return null;
    }

}
