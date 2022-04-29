package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.ValidateForChangePassword;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
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
        LOG.trace("AccountController Event: " + evt);
        // Step 2: Handle each type of account event accordingly. There is
        // likely
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
                // password from the user hashed, Then register user to
                // database.
                if (PersistenceFacade.getInstance().userCreate(associatedUser,
                    ucae.getPassword())) {
                    accountResponse =
                        new AccountResponse("Account created!", false);
                } else {
                    accountResponse =
                        new AccountResponse("Account not created...", true);
                }
                // when succesful, then return response event as
                // rejectionStatues
                CreateAccountResponseEvent responseEventUCA =
                    (CreateAccountResponseEvent) eventFactory.createEvent(
                        EventType.USER_CREATE_ACCOUNT_RESPONSE, this,
                        associatedUser, accountResponse);
                eventFactory.fireEvent(responseEventUCA);
                break;
            case USER_DELETE_ACCOUNT:
                LOG.debug("Caught a delete account event");
                UserDeleteAccountEvent del = ((UserDeleteAccountEvent) evt);
                // if correct password. 
                if (isPasswordCorrect(associatedUser, del.getPassword())) {
                    Password toDelete = LoginAuthenticator.getInstance()
                        .hashNewPassword(del.getPassword());
                    if (PersistenceFacade.getInstance().userDelete(
                        associatedUser, toDelete)) {
                        accountResponse =
                            new AccountResponse("Account deleted!", false);
                    } else {
                        accountResponse =
                            new AccountResponse("Account not deleted", true);
                    }
                } else {
                    accountResponse = new AccountResponse(
                        "Account not deleted. User not verified", true);
                }
                UserDeleteAccountResponseEvent res =
                    (UserDeleteAccountResponseEvent) eventFactory.createEvent(
                        EventType.USER_DELETE_ACCOUNT_RESPONSE, this,
                        associatedUser, accountResponse);
                eventFactory.fireEvent(res);
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
            case VALIDATE_USERNAME:
                LOG.debug("caught a user validation event " + evt);
                // If the username is appropriate
                if (PersistenceFacade.getInstance()
                    .validateUsername(associatedUser)) {
                    if (PersistenceFacade.getInstance()
                        .userNameExists(associatedUser)) {
                        // fire event w rejectionStatus true
                        LOG.debug("determined username exists in database");
                        accountResponse =
                            new AccountResponse("Username already exists!",
                                true);
                    } else {
                        // fire event w rejectionStatus false.
                        LOG.debug(
                            "determined username does not exist in database");
                        accountResponse =
                            new AccountResponse("Username is available", false);
                    }
                } else {
                    LOG.debug("Username is inapproiate.");
                    accountResponse =
                        new AccountResponse("UserName is inapproiate:", true);
                }
                UserValidationResponseEvent responseEventVU =
                    (UserValidationResponseEvent) eventFactory.createEvent(
                        EventType.USER_VALIDATION_RESPONSE, this,
                        associatedUser, accountResponse);
                eventFactory.fireEvent(responseEventVU);
                break;
            case USER_CHANGE_PASSWORD_VALIDATION:
                LOG.debug(
                    "Caught a user validated before change password method.");

                ule = ((UserLoginEvent) evt);
                if (isPasswordCorrect(associatedUser, ule.getPassword())) {
                    // Validation is same as logging in validation.
                    ValidateForChangePassword call =
                        ((ValidateForChangePassword) evt);
                    if (isPasswordCorrect(associatedUser, call.getPassword())) {
                        ValidateChangeResponseEvent responseEventPV =
                            (ValidateChangeResponseEvent) eventFactory
                                .createEvent(EventType.
                                    USER_CHANGE_PASSWORD_VALIDATION_RESPONSE,
                                    this);
                        eventFactory.fireEvent(responseEventPV);
                    }
                    break;

                }
                ValidateForChangePassword call =
                    ((ValidateForChangePassword) evt);
                if (isPasswordCorrect(associatedUser, call.getPassword())) {
                    LOG.debug("User Password validated");
                    accountResponse = new AccountResponse(
                        "User validated for changing password", false);
                } else {
                    LOG.debug("User Password not validated");
                    accountResponse = new AccountResponse(
                        "User not validated for changing password", true);
                }
                ValidateChangeResponseEvent responseEventPV =
                    (ValidateChangeResponseEvent) eventFactory
                        .createEvent(
                            EventType.USER_CHANGE_PASSWORD_VALIDATION_RESPONSE,
                            this, associatedUser, accountResponse);
                eventFactory.fireEvent(responseEventPV);
                break;

            default:
                LOG.warn("caught unhandled event");
                break;


        }
    }
}
