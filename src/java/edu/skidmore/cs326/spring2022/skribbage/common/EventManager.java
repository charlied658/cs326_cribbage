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
 */
public final class EventManager {

    private static final EventManager INSTANCE;
    private static final Logger LOG;
    static {
    	INSTANCE = new EventManager();
    	LOG = Logger.getLogger(EventManager.class);
    }

    //Handles the mapping between EventType and registered Listeners automatically
    private final PropertyChangeSupport support;

    private EventManager() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Registers a new property change listener, mapped to a specific event type
     *
     * @param eventType From the EventType enum.
     * @param pcl A new instance of an event listener, which implements PropertyChangeListener
     */
    public void addPropertyChangeListener(EventType eventType, PropertyChangeListener pcl) {
        support.addPropertyChangeListener(eventType.toString(), pcl);
    }

    /**
     * Unregisters a property change listener
     *
     * @param pcl The event listener (implementing PropertyChangeListener) to unregister
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    /**
     * Fires the input event, for all registered listeners to handle.
     *
     * @param evt Event to fire - Any subtype of CribbageEvent (or PropertyChangeEvent)
     */
    public void notify(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    /**
     * Following from the Singleton design pattern, ensures that only
     * a single instance of EventManager exists.
     *
     * @return The single instance of EventManager
     */
    public synchronized static EventManager getInstance() {
        return INSTANCE;
    }

}
