package edu.skidmore.cs326.spring2022.skribbage.frontend;


import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handles
 */
public class AccountResponseController implements PropertyChangeListener {

    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PlayableGame.class);
    }

    public AccountResponseController() {
        LOG.trace("Account response controller instantiated");

    }

    /**
     * Called from EventManager whenever the properties this
     * @param evt The event to fire
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("Account response controller fired property change");


    }
}

