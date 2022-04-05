package edu.skidmore.cs326.spring2022.skribbage.frontend;

import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handles the responses to any event subclassing from 'AccountResponseEvent'.
 *
 * @author Alex Carney
 * Code Review by: Sten Leinasaar, 3/24/2022
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
     *
     * @param evt The event to fire
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.trace("Account response controller fired property change");
        //AccountResponseEvent responseEvent = (AccountResponseEvent) evt;
        AccountEvent accountEvent = (AccountEvent) evt;

        switch (accountEvent.getEventType()) {
            case USER_LOGIN_RESPONSE:
                LOG.debug("caught a login response event");
                break;
            default:
                LOG.warn("caught unhandled event");
        }

    }
}
