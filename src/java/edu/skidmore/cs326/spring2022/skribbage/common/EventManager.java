package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class EventManager {

    private static EventManager INSTANCE;

    private final PropertyChangeSupport support;

    public EventManager() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(EventType eventType, PropertyChangeListener pcl) {
        support.addPropertyChangeListener(eventType.toString(), pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notify(PropertyChangeEvent evt) {
        System.out.println(evt);
        support.firePropertyChange(evt);
    }

    public synchronized static EventManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EventManager();
        }

        return INSTANCE;
    }

}
