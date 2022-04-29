package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.log4j.Logger;

/**
 * A singleton manager class that handles registering listeners to listen to
 * events, along with implementing the 'notify' method, which fires an
 * event for all attached listeners to handle.
 *
 * @author Alex Carney
 * @EditedAndReviewed: Sten leinasaar
 */
public final class EventManager {
    /**
     * Private static final instance for eager singelton.
     */
    private static final EventManager INSTANCE;

    /**
     * Private static final instance of a Logger for this class.
     */
    private static final Logger LOG;

    static {

        LOG = Logger.getLogger(EventManager.class);
        INSTANCE = new EventManager();

    }

    /**
     * Handles the mapping between EventType and Registered listeners
     * automatically.
     */
    private final PropertyChangeSupport support;

    /**
     * Private constructor to implement eager singelton.
     */
    private EventManager() {
        LOG.info("Private Constructor of EventManager reached.");
        support = new PropertyChangeSupport(this);
    }

    /**
     * Registers a new property change listener, mapped to a specific event
     * type.
     *
     * @param eventType From the EventType enum.
     * @param pcl       A new instance of an event listener, which implements
     *                  PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl,
        EventType... eventType) {
        for (EventType event : eventType) {
            support.addPropertyChangeListener(event.toString(), pcl);
        }
    }

    /**
     * Unregisters a property change listener.
     *
     * @param eventTypeAsString Requires a key lookup, must supply one of the
     *                          events that this listener is listening for,
     *                          as a STRING
     * @param pcl               The event listener
     *                          (implementing PropertyChangeListener) to
     *                          unregister
     */
    public void removePropertyChangeListener(String eventTypeAsString,
        PropertyChangeListener pcl) {
        LOG.debug("Removing a listener: " + pcl.toString());
        support.removePropertyChangeListener(eventTypeAsString, pcl);
    }

    /**
     * Fires the input event, for all registered listeners to handle.
     *
     * @param evt Event to fire - Any subtype of CribbageEvent (or
     *            PropertyChangeEvent)
     */
    public void notify(PropertyChangeEvent evt) {
        LOG.trace("EVENT: " + evt);
        support.firePropertyChange(evt);
    }

    /**
     * Following from the Singleton design pattern, ensures that only
     * a single instance of EventManager exists.
     *
     * @return The single instance of EventManager
     */
    public static synchronized EventManager getInstance() {
        return INSTANCE;
    }

}
