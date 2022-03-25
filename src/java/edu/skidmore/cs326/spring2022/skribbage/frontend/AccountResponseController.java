package edu.skidmore.cs326.spring2022.skribbage.frontend;


import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handles an account response.
 * 
 * @author Alex Carney
 *  Code Review by: Sten Leinasaar, 3/24/2022
 */
public class AccountResponseController implements PropertyChangeListener {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PlayableGame.class);
    }
    /**
     * Constructor method.
     */
    public AccountResponseController() {
        LOG.trace("Account response controller instantiated");

    }

    /**
     * Called from EventManager whenever the properties this.
     * @param evt The event to fire
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("Account response controller fired property change");


    }
}

