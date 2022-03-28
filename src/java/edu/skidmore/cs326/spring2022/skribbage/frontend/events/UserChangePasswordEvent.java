package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

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
     * Attribute of User of type User.
     */
    private final User user;

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
    private final String newPassword;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the bean that fired the event
     * @param user
     *            The un-authorized user associated with the event
     * @param newPassword
     *            The proposed new password for the user
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public UserChangePasswordEvent(Object source, User user,
        String newPassword) {
        super(source, EventType.USER_CHANGE_PASSWORD, user);
        this.user = user;
        this.newPassword = newPassword;
        LOG.trace("Constructor method reached");

    }

    /**
     * @return an object of type User.
     */
    @Override
    public User getUser() {
        LOG.trace("Get user method reached");
        return user;
    }

    /**
     * @return string type of a user's new password.
     */
    public String getNewPassword() {
        LOG.trace("Get newPassword method reached");
        return newPassword;
    }

    /**
     * @return String type of a event name.
     */
    @Override
    public String getEventName() {
        LOG.trace("Get event name of a string type");
        return EventType.USER_CHANGE_PASSWORD.getName();
    }
}
