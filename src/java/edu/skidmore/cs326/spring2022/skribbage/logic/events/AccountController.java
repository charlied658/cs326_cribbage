package edu.skidmore.cs326.spring2022.skribbage.logic.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.events.AccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.logic.PasswordHasher;

/**
 * Use events and listeners to facilitate login processes.
 * 
 * @author Declan Morris & Alex Carney
 */
public class AccountController implements PropertyChangeListener {

    /**
     * Determine whether a user is validated from database.
     * 
     * @param userToValidate
     *            The user attempting to manage their account.
     * @return
     *         Whether or not the user is validated.
     */
    public boolean validateUser(User userToValidate) {

        
    }

//    /**
//     * Call the PasswordHasher instance to hash a user's password.
//     * Should only run when
//     * @param
//     *      Password entered to be hashed
//     */
//    private String hashNewPassword(String enteredPassword) {
//        return LoginAuthenticator.getInstance().hashNewPassword(enteredPassword);
//    }

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
         * Requires downcasting from PropertyChangeEvent, this is where using an
         * AccountEvent abstract class is helpful -- We can share functionality
         * between all account events to do similar tasks like these ones.
         * (hashing
         * and validating)
         */
        User associatedUser = ((AccountEvent) evt).getUser();

        boolean userIsValid = validateUser(associatedUser);

        /*
         * Step 2: Handle each type of account event accordingly. There is
         * likely
         * a better way to implement this, rather than stacks of instanceof
         * statements. I'm open to recommendations. Here's a good place to start
         * https://stackoverflow.com/questions/2790144/avoiding-instanceof-in-
         * java
         * The conclusion I came to from looking through various sources is that
         * a chain of 'instanceof' statements is likely fine, especially for our
         * project. However, I'm totally open to alternative solutions (We
         * should
         * agree on a single standard, however)
         */
        
    }
}
