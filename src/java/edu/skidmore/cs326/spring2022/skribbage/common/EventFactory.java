package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;

/**
 * This class creates an event of type PropertyChangeEvent
 * from the metadata given in EventType enum.
 * 
 * @author Sten Leinasaar
 */
public class EventFactory {

    /**
     * 
     */
    private static final EventFactory INSTANCE;

    /**
     * 
     */
    private PropertyChangeEvent event;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(EventFactory.class);
        INSTANCE = new EventFactory();
    }

    /**
     * 
     */
    private EventFactory() {

    }

    /**
     * @return Singelton instance of the factory.
     */
    public static synchronized EventFactory getInstance() {
        return INSTANCE;
    }

    /**
     * @param source
     *            Source that fired the update.
     * @param user
     *            User instance related to an event.
     * @param event
     *            Type of an event as specified from the ENUM.
     * @return An event of type that was specified.
     */
    public PropertyChangeEvent createAccountEvent(Object source, User user,
        EventType event) {

        return null;
    }

    /**
     * @param source
     * @param user
     * @param event
     * @return A Cribbage event of type PropertyChangeEvent.
     */
    public PropertyChangeEvent createCribbageEvent(Object source, User user,
        EventType event) {
        return null;
    }

}
