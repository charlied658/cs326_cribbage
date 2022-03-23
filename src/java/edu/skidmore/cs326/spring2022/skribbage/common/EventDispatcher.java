package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;

public interface EventDispatcher {

    /**
     * Any class that will fire events implements EventDispatcher. The fireEvent
     * implementation should always include notifying the event manager that the
     * event is fired.
     *
     * It is not recommended to instantiate the event inside the fireEvent class.
     * Instead, create an instance of the event somewhere outside, then use
     * fireEvent(event)
     *
     * @param event The event to be fired. Can be any subclass of PropertyChangeEvent,
     *              using Upcasting
     */
    void fireEvent(PropertyChangeEvent event);

}

