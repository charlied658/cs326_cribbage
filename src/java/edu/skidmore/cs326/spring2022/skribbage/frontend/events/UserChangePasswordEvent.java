package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to change their password.
 *
 * @author Alex Carney
 *         Reviewed: Sten Leinasaar
 */
@SuppressWarnings("serial")
public class UserChangePasswordEvent extends AccountEvent {

    /**
     * Private static final variable of Logger for UserChangePasswordEvent
     * class.
     */
    private static final Logger LOG;

    /**
     * Static block to initialize static final variables.
     */
    static {
        LOG = Logger.getLogger(UserChangePasswordEvent.class);
    }

    /**
     * Attribute of type string to store the newPassword of a user.
     */
    private final Password newPassword;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            The bean that fired the event.
     * @param args
     *            List of arguments.
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public UserChangePasswordEvent(Object source, Object... args) {
        super(source, EventType.USER_CHANGE_PASSWORD, (User) args[0]);
        newPassword = (Password) args[1];
        LOG.trace("Constructor method reached");

    }

    /**
     * @return string type of a user's new password.
     */
    public Password getNewPassword() {
        LOG.trace("Get newPassword method reached. New password returned.");
        return newPassword;
    }

    /**
     * @return String type of a event name.
     */
    @Override
    public EventType getEventType() {
        LOG.trace("Get event name of a string type");
        return EventType.USER_CHANGE_PASSWORD;
    }
}
