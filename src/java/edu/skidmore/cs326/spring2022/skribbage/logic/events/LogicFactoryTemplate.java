package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountResponseEvent;

import org.apache.log4j.Logger;

/**
 * Subclass of FactoryTemplate that overwrites the eventCreation method to
 * handle logic specific events.
 * 
 * @author Declan Morris
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
            case USER_VALIDATION_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new UserValidationResponseEvent(source, args);
            case USER_CREATE_ACCOUNT_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new CreateAccountResponseEvent(source, args);
            case USER_CHANGE_PASSWORD_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new UserChangePasswordResponseEvent(source, args);
            case USER_CHANGE_PASSWORD_VALIDATION_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new ValidateChangeResponseEvent(source, args);
            case USER_DELETE_ACCOUNT_RESPONSE:
                LOG.trace("Returning: " + event.getName());
                return new UserDeleteAccountResponseEvent(source, args);
            default:
                LOG.warn("Event passed + " + event.getName()
                    + " was not one of logic events ");
                return null;
        }
    }

}
