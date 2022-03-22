package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;

/**
 * This class creates an event of type PropertyChangeEvent
 * from the metadata given in EventType enum.
 * 
 * @author Sten Leinasaar
 */
@SuppressWarnings("serial")
public class CreateEvent extends PropertyChangeEvent {

    
    
    
    
    
    /**
     * @param source
     * @param propertyName
     * @param oldValue
     * @param newValue
     */
    public CreateEvent(Object source, String propertyName, Object oldValue,
        Object newValue) {
        super(source, propertyName, oldValue, newValue);
        
    }

}
