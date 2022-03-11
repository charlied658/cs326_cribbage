package edu.skidmore.cs326.spring2022.skribbage.common.test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.accountevents.UserLoginEvent;

public class LogInListenerMOCK implements PropertyChangeListener {

    private final EventManager event;
    public LogInListenerMOCK(EventManager events) {
        this.event = events;
    }
    
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UserLoginEvent lol = (UserLoginEvent) evt;
       
        
    }

    
    
}
