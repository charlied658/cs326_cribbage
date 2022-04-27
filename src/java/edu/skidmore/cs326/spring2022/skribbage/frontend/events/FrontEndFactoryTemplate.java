package edu.skidmore.cs326.spring2022.skribbage.frontend.events;

import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;

/**
 * Subclass of FactoryTemplate that overwrites the eventCreation method to
 * handle frontend specific events.
 * 
 * @author Sten Leinasaar
 *         Last Edited: March 30, 2022
 *         By: Sten Leinasaar
 */
public class FrontEndFactoryTemplate extends FactoryTemplate {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(FrontEndFactoryTemplate.class);
    }

    /**
     * OverWritten eventCreation method from FactoryTemplate. This overwritten
     * method will only manage events created by front end.
     */
    @Override
    public PropertyChangeEvent eventCreation(EventType event, Object source,
        Object... args) {
        LOG.trace("Returning: " + event.getName());
        switch (event) {

            case USER_LOGIN:
                return new UserLoginEvent(source, args);
            case USER_DELETE_ACCOUNT:
                return new UserDeleteAccountEvent(source, args);
            case USER_CREATE_ACCOUNT:
                return new UserCreateAccountEvent(source, args);
            case USER_CHANGE_PASSWORD:
                return new UserChangePasswordEvent(source, args);
            case USER_CHANGE_PASSWORD_VALIDATION:
                return new ValidateForChangePassword(source, args);
            case VALIDATE_USERNAME:
                return new ValidateUsernameEvent(source, args);
            case LOBBY_CREATE_LOBBY:
                return new LobbyCreateEvent(source, args);
            default:
                LOG.warn("Event passed was not one of Front End events");
                return null;
        }

    }

}
