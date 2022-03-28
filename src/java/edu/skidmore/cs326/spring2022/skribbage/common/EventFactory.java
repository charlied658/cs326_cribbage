package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.LobbyEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;

/**
 * This class creates an event of type PropertyChangeEvent
 * from the metadata given in EventType enum.
 * 
 * @author Sten Leinasaar
 *         Last Edit: March 23, 2022
 */
public class EventFactory {

    /**
     * Singleton instance of a EventFactory.
     * Instance can be accessed through EventFactory.getInstance()
     */
    private static final EventFactory INSTANCE;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(EventFactory.class);
        INSTANCE = new EventFactory();
    }

    /**
     * EventFactory private constructor.
     */
    private EventFactory() {

    }

    /**
     * Synchronized getInstance of a EventFactory method.
     * 
     * @return Singleton instance of the factory.
     */
    public static synchronized EventFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Creates an event of type PropertyChangeEvent based on the
     * EventType enum value being passed.
     * 
     * @param event
     *            Type of an event as specified from the ENUM.
     * @param source
     *            Source that fired the update.
     * @param args
     *            Vararg of Object type.
     * @return An event of type that was specified.
     */
    public PropertyChangeEvent createEvent(EventType event, Object source,
        Object... args) {

        Object[] eventArgumentList = event.getArgumentList();

        for (int i = 0; i < eventArgumentList.length; i++) {
            if (args[i].getClass() != eventArgumentList[i].getClass()) {
                LOG.error("Illegal argument: Argument data types do not match enum");
                throw new IllegalArgumentException("Argument data types do not match enum");
            }
        }
        switch (event) {
            case USER_CREATE_ACCOUNT:
                LOG.trace(
                    "Returning a new instance of UserCreateAccount. "
                        + "Requested by:  " + source.toString());
                return new UserCreateAccountEvent(source, args);
            case USER_DELETE_ACCOUNT:
                LOG.trace(
                    "Returning a new instance of UserDeleteAccount. "
                        + "Requested by:  " + source.toString());
                return new UserDeleteAccountEvent(source, args);
            case USER_LOGIN:
                LOG.trace(
                    "Returning a new instance of UserLogin. "
                        + "Requested by:  " + source.toString());
                return new UserLoginEvent(source, args);
            case USER_LOGIN_HASHED:
                LOG.trace(
                    "Returning a new instance of UserLoginHashed. "
                        + "Requested by:  " + source.toString());
                // PLACEHOLDER as NO EVENT CREATED YET
                return null;
            case USER_LOGIN_RESPONSE:
                LOG.trace(
                    "Returning a new instance of UserLoginResponse. "
                        + "Requested by:  " + source.toString());
                return null; // PLACEHOLDER... will be --> return new
                             // UserLoginResponseEvent(source, user);
            case USER_CHANGE_PASSWORD:
                LOG.trace(
                    "Returning a new instance of UserChangePassword. "
                        + "Requested by:  " + source.toString());
                /**
                 * @TODO Come back and figure out how to pass a new password.
                 */
                return new UserChangePasswordEvent(source, args);
            case LOBBY_EVENT:
                LOG.trace(
                    "Returning a new instance of LobbyEvent. Reguested by: "
                        + source.toString());
                return new LobbyEvent(source);
            default:
                break;
        }

        return null;

    }

}
