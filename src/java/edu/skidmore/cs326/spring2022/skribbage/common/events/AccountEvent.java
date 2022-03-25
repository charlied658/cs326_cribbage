package edu.skidmore.cs326.spring2022.skribbage.common.events;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

/**
 * An abstract representation of an Event used to communicate data between
 * modules. Extends the built in PropertyChangeEvent, hiding some of its unused
 * functionality
 *
 * @author Alex Carney Reviewed by Sten Leinasaar
 */
@SuppressWarnings("serial")
public abstract class AccountEvent extends PropertyChangeEvent {

    /**
     * Private static final instance of a Logger for this class.
     */
    private static final Logger LOG;
    /**
     * Static block to initialize a static final variables.
     */
    static {
        LOG = Logger.getLogger(AccountEvent.class);
    }

    /**
     * @param source
     *            the bean that fired the event.
     * @param eventName
     *            the string format of the event name.
     * @param associatedUser
     *            An user who is associated with this accountEvent.
     * @throws IllegalArgumentException
     *             if {@code source} is {@code null}
     */
    public AccountEvent(Object source, String eventName, User associatedUser) {
        super(source, eventName, null, null);
        LOG.trace("Constructor method reached and super class called");
    }

    /**
     * Method that returns an object of type User.
     * 
     * @return a object of type User.
     */
    public abstract User getUser();

    /**
     * Method that returns a string format of the event name.
     * 
     * @return String type of the event name.
     */
    public abstract String getEventName();

}
