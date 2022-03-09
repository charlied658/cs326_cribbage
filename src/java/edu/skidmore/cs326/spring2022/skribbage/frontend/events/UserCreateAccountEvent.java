package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

public class UserCreateAccountEvent extends AccountEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source         the bean that fired the event
     * @param associatedUser The email, username, and password supplied with the new account request
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserCreateAccountEvent(Object source, User associatedUser) {
        super(source, EventType.USER_CREATE_ACCOUNT.toString(), associatedUser);
    }
}
