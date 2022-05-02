package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponse;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserLoginResponseEvent;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Mock instance of listener on logic's end. Listens for the proper
 * events from the front end tier, validates user, then sends
 * an event back to the front end to handle.
 * 
 * @author Alex Carney
 */
public class AccountControllerMOCK implements PropertyChangeListener {

    /**
     * Mock user received from login event.
     */
    private User receivedUser;
    /**
     * Incoming event, upcasted to AccountEvent.
     */
    private AccountEvent incomingEvent;

    /**
     * Outgoing event, upcasted to AccountResponseEvent.
     */
    private AccountResponseEvent outgoingEvent;

    /**
     * Borrow event factory instance for testing.
     */
    private final EventFactory eventFactoryTestInstance =
        EventFactory.getInstance();

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(AccountControllerMOCK.class);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt
     *            A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        incomingEvent = (AccountEvent) evt;
        LOG.debug("Caught incoming event in AccountController MOCK" + evt);

        switch (incomingEvent.getEventType()) {
            case USER_LOGIN:
                LOG.info("Handling user login event");
                receivedUser = incomingEvent.getUser();
                receivedUser.setUserRole(UserRole.AUTHORIZED);
                outgoingEvent =
                    (UserLoginResponseEvent) eventFactoryTestInstance
                        .createEvent(
                            EventType.USER_LOGIN_RESPONSE,
                            this,
                            receivedUser,
                            new AccountResponse("Success Login", false));
                LOG.debug("OutgoingEvent being fired  is:  "
                    + outgoingEvent.getEventType().getName());
                eventFactoryTestInstance.fireEvent(outgoingEvent);
                break;
            case USER_CREATE_ACCOUNT:
                LOG.debug("Handled create account event.");
                receivedUser = incomingEvent.getUser();
                break;
            default:
                LOG.error("Illegal logical flow from event: " + evt);
                throw new IllegalArgumentException("Cant handle this event");
        }
    }

    /**
     * Return "logged in" user.
     * 
     * @return User object
     */
    public User getUser() {
        LOG.debug("Returning user attribute");
        return receivedUser;
    }

  
}
