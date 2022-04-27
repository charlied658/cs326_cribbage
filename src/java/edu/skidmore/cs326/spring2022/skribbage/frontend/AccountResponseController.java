package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.AccountResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.CreateAccountResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserLoginResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserValidationResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.ValidateChangeResponseEvent;

import org.apache.log4j.Logger;

/**
 * Handles the responses to any event subclassing from 'AccountResponseEvent'.
 *
 * @author Alex Carney
 *         Code Review by: Sten Leinasaar, 3/24/2022
 */
public class AccountResponseController implements PropertyChangeListener {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    /**
     * The Page Manager so that the active page can be accessed at all times.
     */
    private PageManager pageManager = PageManager.getInstance();

    static {
        LOG = Logger.getLogger(AccountResponseController.class);
    }

    /**
     * Constructor method.
     */
    public AccountResponseController() {
        LOG.debug("Account response controller instantiated");

    }

    /**
     * Called from EventManager whenever the properties this.
     *
     * @param evt
     *            The event to fire
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        LOG.trace("Account response controller fired property change " + evt);
        AccountResponseEvent responseEvent = (AccountResponseEvent) evt;
        Page activePage = pageManager.getActivePage();
        switch (responseEvent.getEventType()) {
            case USER_LOGIN_RESPONSE:
                LOG.debug("caught a login response event");
                ((LoginPage) activePage)
                    .validateLoginCallback((UserLoginResponseEvent) evt);
                break;
            case USER_DELETE_ACCOUNT_RESPONSE:
                LOG.debug("caught a user delete response event");
                ((NavigationPage) activePage).userDeleteAccountResponseCallBack(
                    (UserDeleteAccountResponseEvent) evt);
                break;
            case USER_VALIDATION_RESPONSE:
                LOG.debug("caught user validation response "
                    + responseEvent.getAccountResponse());
                ((LoginPage) activePage).validateUsernameCallback(
                    (UserValidationResponseEvent) evt);
                break;
            case USER_CHANGE_PASSWORD_VALIDATION_RESPONSE:
                LOG.debug("Caught user change password validation response");
                ((LoginPage) activePage)
                    .validateForChangePassword(
                        (ValidateChangeResponseEvent) evt);
                break;
            case USER_CHANGE_PASSWORD_RESPONSE:
                LOG.debug("Caught user change password response.");
                ((LoginPage) activePage).validateChangePasswordCallback(
                    (UserChangePasswordResponseEvent) evt);
                break;
            case USER_CREATE_ACCOUNT_RESPONSE:
                LOG.debug("Caught user create account response.");
                ((LoginPage) activePage).validateCreateAccountCallback(
                    (CreateAccountResponseEvent) evt);
                break;

            default:
                LOG.warn("caught unhandled event");
        }

    }
}
