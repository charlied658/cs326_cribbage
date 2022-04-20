package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.PlayableGame;
import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;

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
        LOG = Logger.getLogger(PlayableGame.class);
    }

    // @Override
    // public void propertyChange(PropertyChangeEvent evt) {
    // // Temporary to resolve errors until database is up and running.
    //
    // }

    /**
     * Temporary instance of database manager used as tracer bullet.
     */
    private DatabaseManager dbManager = new DatabaseManager();

    /**
     * Factor instance for this class.
     */
    private EventFactory eventFactory = EventFactory.getInstance();

    /**
     * Determine whether a user is validated from database.
     *
     * @param userToValidate
     *            The user attempting to manage their account.
     * @return
     *         Whether or not the user is validated.
     */
    public boolean validateUser(User userToValidate) {
        return dbManager.userAuthenticate(userToValidate.getUserName(),
            userToValidate.getPassword());
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
        System.out.println("AccountController Event: " + evt);
        User associatedUser = ((AccountEvent) evt).getUser();

        /**
         * variable to assure validateUser is only run once.
         */
        boolean userIsValid = validateUser(associatedUser);

        /*
         * Step 2: Handle each type of account event accordingly. There is
         * likely
         */
        AccountEvent accountEvent = (AccountEvent) evt;

        switch (accountEvent.getEventType()) {
            case USER_CREATE_ACCOUNT:
                LOG.debug("caught a create account event");
                break;
            case USER_LOGIN:
                LOG.debug("caught a login event");
                if (validateUser(associatedUser)) {
                    UserLoginResponseEvent responseEvent =
                        (UserLoginResponseEvent) eventFactory
                            .createEvent(EventType.USER_LOGIN_RESPONSE, this);
                }
                break;
            default:
                LOG.warn("caught unhandled event");
        }

    }
}
