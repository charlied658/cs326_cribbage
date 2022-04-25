package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.ValidateForChangePassword;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;

/**
 * Use events and listeners to facilitate login processes.
 * 
 * @author Declan Morris & Alex Carney
 */
public class AccountController implements PropertyChangeListener {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(AccountController.class);
    }

    // @Override
    // public void propertyChange(PropertyChangeEvent evt) {
    // // Temporary to resolve errors until database is up and running.
    //
    // }

    // /**
    // * Temporary instance of database manager used as tracer bullet.
    // */
    // private DatabaseManager dbManager = new DatabaseManager();

    /**
     * Factor instance for this class.
     */
    private EventFactory eventFactory = EventFactory.getInstance();

    /**
     * UserLoginEvent object.
     */
    private UserLoginEvent ule;

    /**
     * Determine whether a user is validated from database.
     *
     * @param userToValidate
     *            The user attempting to manage their account.
     * @param inputPassword
     *            The password for this request to login.
     * @return
     *         Whether or not the user is validated.
     */
    private boolean isPasswordCorrect(User userToValidate,
        String inputPassword) {

        return LoginAuthenticator.getInstance().passwordMatches(userToValidate,
            inputPassword);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*
         * Step 1: Perform actions that are shared among events that this
         * controller
         * manages
         * For example, every single Account management action requires
         * validation
         * that the user exists (including CreateAccountEvent, can't make an
         * account
         * if it already exists!)
         * So instead of writing 4 separate listeners for each Account event,
         * we can write a single Controller and have it subscribe to a list of
         * account-related events, handling each one accordingly after
         * executing shared logic.
         */

        /*
         * Requires downcasting from PropertyChangeEvent,this is where usingan
         * AccountEvent abstract class is helpful --We can share functionality
         * between all account events to do similar tasks like these ones.
         * (hashing
         * and validating)
         */
        LOG.trace("AccountController Event: " + evt);

        /*
         * Step 2: Handle each type of account event accordingly. There is
         * likely
         */
        AccountEvent accountEvent = (AccountEvent) evt;
        User associatedUser = accountEvent.getUser();
        AccountResponse accountResponse = null;

        switch (accountEvent.getEventType()) {
            case USER_LOGIN:
                LOG.debug("caught a login event");
                ule = ((UserLoginEvent) evt);

                UserLoginResponseEvent responseEvent;

                if (isPasswordCorrect(associatedUser, ule.getPassword())) {

                    accountResponse =
                        new AccountResponse("Login successful!", false);

                } else {
                    accountResponse =
                        new AccountResponse("Login unsuccessful...", true);
                }
                responseEvent =
                    (UserLoginResponseEvent) eventFactory
                        .createEvent(EventType.USER_LOGIN_RESPONSE, this,
                            associatedUser, accountResponse);
                eventFactory.fireEvent(responseEvent);
                break;

            case USER_CREATE_ACCOUNT:
                UserCreateAccountEvent ucae = ((UserCreateAccountEvent) evt);
                LOG.debug("caught a create account event");
                // password from the user hashed.
                // Then register user to database.
                if (PersistenceFacade.getInstance().userCreate(associatedUser,
                    ucae.getPassword())) {
                    accountResponse =
                        new AccountResponse("Account created!", false);
                } else {
                    accountResponse =
                        new AccountResponse("Account not created...", true);
                }

                // when succesful, then return response event as rejectionStatus
                // being false.

                CreateAccountResponseEvent responseEventUCA =
                    (CreateAccountResponseEvent) eventFactory.createEvent(
                        EventType.USER_CREATE_ACCOUNT_RESPONSE, this,
                        associatedUser, accountResponse);
                eventFactory.fireEvent(responseEventUCA);

                break;
            case USER_DELETE_ACCOUNT:
                LOG.debug("caught a delete account event");

                accountResponse =
                    new AccountResponse("Attempting to delete user",
                        PersistenceFacade.getInstance()
                            .userDelete(associatedUser, null));
                break;
            case USER_CHANGE_PASSWORD:
                LOG.debug("caught a change password event");
                UserChangePasswordEvent chan = ((UserChangePasswordEvent) evt);
                if (PersistenceFacade.getInstance().passwordChange(
                    associatedUser,
                    chan.getNewPassword())) {
                    accountResponse =
                        new AccountResponse("Password change succesful!",
                            false);
                } else {
                    accountResponse =
                        new AccountResponse("Password change unsuccesful!",
                            true);
                }

                UserChangePasswordResponseEvent response =
                    (UserChangePasswordResponseEvent) eventFactory.createEvent(
                        EventType.USER_CHANGE_PASSWORD_RESPONSE, this,
                        associatedUser, accountResponse);
                eventFactory.fireEvent(response);

                break;
            // To do: rename to clarify event's purpose
            // (check_username_existence)
            case VALIDATE_USERNAME:
                LOG.debug("caught a user validation event " + evt);
                if (PersistenceFacade.getInstance()
                    .userNameExists(associatedUser)) {
                    // fire event w rejectionStatus true
                    LOG.debug("determined username exists in database");
                    accountResponse =
                        new AccountResponse("Username already exists!", true);
                    UserValidationResponseEvent responseEventVU =
                        (UserValidationResponseEvent) eventFactory.createEvent(
                            EventType.USER_VALIDATION_RESPONSE, this,
                            associatedUser, accountResponse);
                    eventFactory.fireEvent(responseEventVU);
                } else {
                    // fire event w rejectionStatus false.
                    LOG.debug("determined username does not exist in database");
                    accountResponse =
                        new AccountResponse("Username already exists!", false);
                    UserValidationResponseEvent responseEventVU =
                        (UserValidationResponseEvent) eventFactory.createEvent(
                            EventType.USER_VALIDATION_RESPONSE, this,
                            associatedUser, accountResponse);
                    eventFactory.fireEvent(responseEventVU);
                }
                break;
            case USER_CHANGE_PASSWORD_VALIDATION:
                LOG.debug(
                    "Caught a user validated before change password method.");
                // Validation is same as logging in validation.
                ValidateForChangePassword call =
                    ((ValidateForChangePassword) evt);
                if (isPasswordCorrect(associatedUser, call.getPassword())) {
                    ValidateChangeResponseEvent responseEventPV =
                        (ValidateChangeResponseEvent) eventFactory.createEvent(
                            EventType.USER_CHANGE_PASSWORD_VALIDATION_RESPONSE,
                            this);
                    // eventFactory.fireEvent(responseEvent);
                    eventFactory.fireEvent(responseEventPV);

                }

                break;
            default:
                LOG.warn("caught unhandled event");
        }

    }
}
