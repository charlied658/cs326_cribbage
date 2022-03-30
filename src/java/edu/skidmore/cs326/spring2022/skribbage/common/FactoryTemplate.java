package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

/**
 * Template for factory method that allows each subclass to overwrite the
 * eventCreation method.
 * 
 * @author Sten Leinasaar
 */
public abstract class FactoryTemplate {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(FactoryTemplate.class);
    }

    /**
     * Creates an event of type PropertyChangeEvent based on the
     * EventType enum value being passed.
     * 
     * @param event
     *            Type of an event as specified from the ENUM.
     * @param source
     *            Source that fired the update.
     * @param args
     *            Vararg of Object type.
     * @return An event of type that was specified.
     */
    public PropertyChangeEvent createEvent(EventType event, Object source,
        Object... args) {
        LOG.trace("Calling a hook method from createEvent method.");
        return eventCreation(event, source, args);

    }

    /**
     * Abstract eventCreation method called by the Factory Template.
     * Subclass that extends this abstract class will overwrite this
     * 
     * @param event
     *            Type of an event as specified from the enumeration.
     * @param source
     *            Source that fired the update.
     * @param args
     *            List of arguments of type Object.
     * @return An event of type that was specified.
     */
    public abstract PropertyChangeEvent eventCreation(EventType event,
        Object source,
        Object... args);
}
