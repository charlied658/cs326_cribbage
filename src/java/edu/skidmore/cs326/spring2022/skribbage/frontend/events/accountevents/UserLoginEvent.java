package edu.skidmore.cs326.spring2022.skribbage.frontend.events.accountevents;



import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.common.events.CribbageEvent;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to login.
 * @author Alex Carney
 */
public class UserLoginEvent extends AccountEvent {


    private final User user;


    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param user The un-authorized user associated with the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserLoginEvent(Object source, User user) {
        super(source, EventType.USER_LOGIN.toString(), user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }


}
