package edu.skidmore.cs326.spring2022.skribbage.frontend.events;



import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to change their password.
 * @author Alex Carney
 */
public class UserChangePasswordEvent extends AccountEvent {


    private final User user;
    private final String newPassword;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param user The un-authorized user associated with the event
     * @param newPassword The proposed new password for the user
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserChangePasswordEvent(Object source, User user, String newPassword) {
        super(source, EventType.USER_CHANGE_PASSWORD.toString(), user);
        this.user = user;
        this.newPassword = newPassword;

    }

    public User getUser() {
        return user;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
