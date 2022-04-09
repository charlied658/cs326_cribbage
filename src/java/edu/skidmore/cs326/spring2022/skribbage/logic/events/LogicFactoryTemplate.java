package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;
import org.apache.log4j.Logger;

/**
 * Subclass of FactoryTemplate that overwrites the eventCreation method to
 * handle logic specific events.
 * 
 * @author Declan Morris
 *
 * @author Alex Carney
 */
public class LogicFactoryTemplate extends FactoryTemplate {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LogicFactoryTemplate.class);
    }

    @Override
    public PropertyChangeEvent eventCreation(EventType event, Object source,
        Object... args) {
        switch (event) {
            case USER_LOGIN_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new UserLoginResponseEvent(source, args);
            default:
                LOG.warn("Event passed was not one of logic events");
                return null;
        }
    }

}
