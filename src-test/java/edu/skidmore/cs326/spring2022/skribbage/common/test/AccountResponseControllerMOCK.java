package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponse;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponseEvent;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Mock class for testing if the "logic tier" can communicate a response
 * back to the "front end tier".
 * 
 * @author Alex Carney
 */
public class AccountResponseControllerMOCK implements PropertyChangeListener {

    /**
     * User received from logging in event.
     */
    private User receivedUserFromLogin;

    /**
     * Instance of accountResponse.
     */
    private AccountResponse accountResponse;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(AccountResponseControllerMOCK.class);
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
        LOG.trace("Event in account response controller = " + evt);
        receivedUserFromLogin = ((AccountResponseEvent) evt).getUser();
        accountResponse = ((AccountResponseEvent) evt).getAccountResponse();
    }

    /**
     * Return user that logged in.
     * 
     * @return User object
     */
    public User getReceivedUserFromLogin() {
        LOG.trace("Returning received user from login");
        return receivedUserFromLogin;
    }

    /**
     * Return account response message.
     * @return Account response
     */
    public AccountResponse getAccountResponseMessage() {
        return accountResponse;
    }
}
