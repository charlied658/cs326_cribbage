package edu.skidmore.cs326.spring2022.skribbage.frontend.events.accountevents;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

public class UserDeleteAccountEvent extends AccountEvent {

    private final User user;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source         the bean that fired the event
     * @param associatedUser The logged in user attempting to delete their account
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserDeleteAccountEvent(Object source, User associatedUser) {
        super(source, EventType.USER_DELETE_ACCOUNT.toString(), associatedUser);
        this.user = associatedUser;
    }

    public User getUser() {
        return user;
    }
}
