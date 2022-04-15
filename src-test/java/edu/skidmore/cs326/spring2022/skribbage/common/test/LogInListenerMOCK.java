package edu.skidmore.cs326.spring2022.skribbage.common.test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;

/**
 * 
 */
public class LogInListenerMOCK implements PropertyChangeListener {
    /**
     * 
     */
    private UserLoginEvent test;

    /**
     * 
     * 
     */
    public LogInListenerMOCK() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UserLoginEvent test = (UserLoginEvent) evt;

    }

    /**
     * @return Returns an UserLoginEvent.
     */
    public UserLoginEvent getUserLoginEvent() {
        return test;
    }

}
