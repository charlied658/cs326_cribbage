package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.ValidateUsernameEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserLoginResponseEvent;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.UserValidationResponseEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordEvent;


import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DialogPosition;
import us.daveread.edu.graphics.surface.DialogType;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * @author Zoe Beals updated as of 3/22/2022
 *         Code reviewed and updated by Sten Leinasaar on April 15, 2022.
 *         Edits made (Sten) :
 *         1) I changed the flow of the buttonClick and DrawableClick detection.
 *         2) The buttons are now connected to the backend facade
 *         3) I added a prompt for a user to write their current password and
 *         username before attempting to change the password.
 *         Before prompted to change the password, backend method is called to
 *         verify if this user exists.
 *         4) Some code is commented out as it wasn't used. I kept it just in
 *         case we might need it when we start adding things.
 */
@SuppressWarnings("serial")
public class LoginPage extends DrawingSurface implements Page {
    /**
     * loginPage - MainFrame window to hold the UI attributes.
     */
    private MainFrame loginPage;

    /**
     * Object of type StartGamePage to act as a Backdoor until loggin is
     * functional.
     */
    @SuppressWarnings("unused")
    private StartGamePage backdoor;

    /**
     * homeScreen - HomeScreen window to hold the home screen.
     */
    @SuppressWarnings("unused")
    private HomeScreen homeScreen;

    /**
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;

    /**
     * createAccount - Text variable that represents the create account button.
     */
    private Text createAccountButton;

    /**
     * Object of type Text that represents the login button.
     */
    private Text loginButton;

    /**
     * BACKDOOR FOR LOGIC AND GAMIFICATION.
     */
    private Text startGameButton;

    /**
     * Object of type Text that represents the change password button.
     */
    private Text changePasswordButton;

    /**
     * Object of type Text that represents the button for returning to the home
     * screen.
     */
    private Text homeScreenButton;

    /**
     * Object of type Password that represents the current password.
     */
    private Password currentPassword;

    /**
     * Object of type Password that represents the new password when password is
     * being changed.
     */
    private Password newPassword;

    /**
     * evtFactory - EventFactory object.
     */
    @SuppressWarnings("unused")
    private EventFactory evtFactory;

    /**
     * ule - UserCreateAccountEvent object.
     */
    @SuppressWarnings("unused")
    private UserCreateAccountEvent ule;

    /**
     * lEvt - UserLoginEvent object.
     */
    @SuppressWarnings("unused")
    private UserLoginEvent lEvt;

    /**
     * currentUser - User object being changed as the user interacts with the
     * GUI.
     */
    private User currentUser;

    /**
     * createdUsername - String variable that holds the new username.
     */
    private String createdUsername;

    /**
     * createdPassword - String variable that holds the new password.
     */
    private String createdPassword;

    /**
     * verifyCreatedPassword - String variable that holds the verified new
     * password.
     */
    private String verifyCreatedPassword;

    /**
     * username - String variable that holds the user inputted username.
     */
    private String username;

    /**
     * usernameToChange - String variable that holds the user inputted username.
     * in the case of a changePassword event
     */
    private String usernameToChange;

    /**
     * password - String variable that holds the user inputted password.
     */
    private String password;

    /**
     * Private object of type passwordhasher.
     */
    private PasswordHasher hasher;

    /**
     * String variable that holds the user inputed password.
     * Used for changePassword event.
     */
    private String passwordToChange;

    /**
     * String variable that holds the user inputed
     * password to verify it in the case of a changePassword event.
     */
    private String verifyPasswordToChange;

    /**
     * Variable of type Image to hold the temporary game logo.
     */
    private Image logo;

    /**
     * PageManager instance to manage creation of pages.
     */
    private PageManager pageManager;

    /**
     * UserChangePasswordEvent instance.
     */
    private UserChangePasswordEvent evt;

    /**
     * Logger instance for logging..
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LoginPage.class);
    }

    /**
     * LoginPage constructor Initializes the MainFrame window and all the
     * objects listed in the attributes.
     * All the buttons are added to the mainframe.
     */
    public LoginPage() {

        LOG.debug("Instance created");
        evtFactory = EventFactory.getInstance();
        hasher = PasswordHasher.getInstance();
        pageManager = PageManager.getInstance();
        setup();
    }

    @Override
    public void setup() {
        loginPage = new MainFrame(this, "Skribbage Battle Royale Login", 900,
            900, false);
        createAccountButton =
            new Text("Create Account", new Point(375, 360), 20,
                Color.black, Color.blue);
        loginButton =
            new Text("Login", new Point(425, 400), 20, Color.black, Color.blue);
        changePasswordButton =
            new Text("Change Password", new Point(369, 440), 20,
                Color.black, Color.blue);
        homeScreenButton =
            new Text("Back", new Point(10, 25), 20, Color.black, Color.blue);
        logo = new Image("logo.png", new Point(150, 0), 0.6, null);

        // PLACEHOLDER FOR LOGIC AND GAMIFICATION TO WORK ON GAME. BACKDOOR IF
        // YOU WILL.
        startGameButton =
            new Text("Start GAME", new Point(425, 480), 20, Color.black,
                Color.blue);
        add(logo);
        add(homeScreenButton);
        add(loginButton);
        add(changePasswordButton);
        add(createAccountButton);
        add(startGameButton);

    }

    /**
     * Method to handle different button clicks.
     *
     * @param popupType
     *            - integer variable that is used to determine
     *            the type of popup to display.
     * @param popupTitle
     *            - String variable that will be used to set
     *            the title of the popup window.
     * @param popupMessage
     *            - String variable that will be used to set
     *            the message of the popup window.
     */
    public void buttonClicked(int popupType, String popupTitle,
        String popupMessage) {
        LOG.trace("ChangePassword method in LoginPage.java");
        switch (popupType) {
            // change Password
            case 0:
                usernameToChange = getUserInput(popupTitle, "Enter username",
                    DialogPosition.CENTER_ALL);
                password = getUserInput(popupTitle,
                    "Enter your current password", DialogPosition.CENTER_ALL,
                    true);

                currentPassword =
                    LoginAuthenticator.getInstance().hashNewPassword(password);

                currentUser = new User(null, usernameToChange,
                    UserRole.UNAUTHORIZED);

                ValidateForChangePassword eventLogin =
                    (ValidateForChangePassword) evtFactory.createEvent(
                        EventType.USER_CHANGE_PASSWORD_VALIDATION, this,
                        currentUser, currentPassword);
                evtFactory.fireEvent(eventLogin);

                break;

            case 1:
                passwordToChange = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL, true);
                verifyPasswordToChange = getUserInput(popupTitle,
                    popupMessage + " again", DialogPosition.CENTER_ALL, true);

                if (passwordToChange.equals(verifyPasswordToChange)) {
                    newPassword = LoginAuthenticator.getInstance()
                        .hashNewPassword(passwordToChange);
                    evt =
                        (UserChangePasswordEvent) evtFactory.createEvent(
                            EventType.USER_CHANGE_PASSWORD,
                            this, currentUser, newPassword);
                    evtFactory.fireEvent(evt);

                } else {
                    showMessage("Passwords did not match",
                        "Unsuccessful password change. Try Again!",
                        DialogType.ERROR);
                    buttonClicked(1, popupTitle, popupMessage);
                }

                break;

            // create account
            case 2:
                createdUsername = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL);

                currentUser = new User(null, createdUsername,
                    UserRole.UNAUTHORIZED);
                ValidateUsernameEvent event =
                    (ValidateUsernameEvent) evtFactory.createEvent(
                        EventType.VALIDATE_USERNAME, this, currentUser);
                evtFactory.fireEvent(event);

                break;
            default:
                break;
        }
    }

    /**
     * Called by AccountResponseController.
     * 
     * @param event
     *            incoming event containing information
     * @author Alex Carney
     */
    public void validateUsernameCallback(
        UserValidationResponseEvent event) {

        if (!event.getAccountResponse()
            .isRejectionStatus()) {
            createNewUser();
        } else {
            showMessage("Invalid Username",
                "Username is taken or is a bad word, try again",
                DialogType.ERROR);
            //createNewUser();
        }

    }

    /**
     * Called by AccountResponseController to verify user for password change.
     * 
     * @param event
     */
    public void validateForChangePassword(ValidateChangeResponseEvent event) {
        if (!event.getAccountResponse().isRejectionStatus()) {
            passwordToChange =
                getUserInput("Change Password", "Enter new password",
                    DialogPosition.CENTER_ALL, true);
            verifyPasswordToChange = getUserInput("Change Password",
                "Enter new password again", DialogPosition.CENTER_ALL,
                true);

            if (passwordToChange.equals(verifyPasswordToChange)) {
                newPassword = LoginAuthenticator.getInstance()
                    .hashNewPassword(passwordToChange);
                evt = (UserChangePasswordEvent) evtFactory.createEvent(
                    EventType.USER_CHANGE_PASSWORD, this, currentUser,
                    newPassword);
                evtFactory.fireEvent(evt);

            } else {
                showMessage("Passwords did not match",
                    "Unsuccessful password change",
                    DialogType.ERROR);
                buttonClicked(1, "Change Password", "Enter New Password");
            }
        }

    }

    /**
     * Called by AccountResponseController.
     * 
     * @param event
     *            Incoming event containing information.
     */
    public void validateLoginCallback(UserLoginResponseEvent event) {
        LOG.trace("validateLoginCallback called with event " + event);
        LOG.trace("validateLoginCallback has response " +
            event.getAccountResponse());
        if (!event.getAccountResponse().isRejectionStatus()) {
            showMessage("User: " + username, "Successful Log In",
                DialogType.INFORMATION);
            // navPage = NavigationPageManager.getInstance().getNavPage();
            navPage = (NavigationPage) pageManager
                .createPage(PageType.NAVIGATION_PAGE);
            closeWindow();
        } else {
            showMessage(
                "User does not exist. "
                    + "Please create a new account or try again.",
                "Unsuccessful Log In",
                DialogType.ERROR);
        }

    }

    /**
     * Called by AccountResponseController to verify Create account success.
     * 
     * @param event
     */
    public void validateCreateAccountCallback(
        CreateAccountResponseEvent event) {
        if (!event.getAccountResponse().isRejectionStatus()) {
            userCreatedCallback();
        } else {
            LOG.error("Failed to create an user.");
        }

    }

    /**
     * Called by AccountResponseController.
     * 
     * @param evt
     *            --> Incoming event containing information.
     */
    public void validateChangePasswordCallback(
        UserChangePasswordResponseController evt) {
        if (!evt.getAccountResponse().isRejectionStatus()) {
            showMessage("Password change was succesful.", "You are beautiful!",
                DialogType.INFORMATION);
        } else {
            LOG.error("FAILED to change password");
            showMessage(" Couldn't change your password!",
                "Username or Password is wrong.", DialogType.ERROR);
        }
    }

    /**
     * verifyNewUserCallback - method to verify a new user is available.
     */
    public void createNewUser() {
        LOG.debug("Creating a new user");
        createdPassword = getUserInput("New User", "Enter password",
            DialogPosition.CENTER_ALL, true);
        verifyCreatedPassword = getUserInput("New User",
            "Enter password again", DialogPosition.CENTER_ALL, true);

        if (createdPassword.equals(verifyCreatedPassword)) {
            currentUser = new User(null, createdUsername,
                UserRole.UNAUTHORIZED);
            currentPassword = LoginAuthenticator.getInstance()
                .hashNewPassword(createdPassword);
            UserCreateAccountEvent evt =
                (UserCreateAccountEvent) evtFactory.createEvent(
                    EventType.USER_CREATE_ACCOUNT, this, currentUser,
                    currentPassword);
            evtFactory.fireEvent(evt);

        } else {
            showMessage("Passwords you entered, do not match",
                "Please try again",
                DialogType.ERROR);
            createNewUser();

        }
    }

    /**
     * userCreatedCallback - method to verify a new user is created.
     */
    public void userCreatedCallback() {
        LOG.trace("userCreatedCallback method in Loginpage.java");
        showMessage("User: " + createdUsername + " created.",
            "New account created.", DialogType.INFORMATION);
    }

    /**
    *
    */
    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("Drawable mouseclick method in LoginPage.java");
        // User Login.
        if (e == loginButton) {

            loginButton.setFillColor(Color.GREEN);
            username = getUserInput("Login", "Enter username",
                DialogPosition.CENTER_ALL);
            password =
                getUserInput("Login", "Enter password for: " + username,
                    DialogPosition.CENTER_ALL, true);
            currentUser = new User(null, username,
                UserRole.UNAUTHORIZED);

            currentPassword =
                LoginAuthenticator.getInstance().hashNewPassword(password);
            UserLoginEvent eventLogin =
                (UserLoginEvent) evtFactory.createEvent(
                    EventType.USER_LOGIN, this, currentUser, currentPassword);
            evtFactory.fireEvent(eventLogin);

        } else if (e == changePasswordButton) {
            changePasswordButton.setFillColor(Color.GREEN);
            buttonClicked(0, "Change Password", "Enter new password");

        } else if (e == createAccountButton) {
            createAccountButton.setFillColor(Color.GREEN);
            buttonClicked(2, "New User", "Enter username");

        } else if (e == homeScreenButton) {
            returnToHome();
        } else if (e == startGameButton) {
            backdoor = (StartGamePage) pageManager
                .createPage(PageType.START_GAME_PAGE);
            closeWindow();

        }
    }

    /**
     * returnToHome method handles if a user needs
     * to return to the main menu.
     */
    public void returnToHome() {
        LOG.trace("returnToHome method in LoginPage.java");
        homeScreen =
            (HomeScreen) pageManager.createPage(PageType.HOMESCREEN_PAGE);
        closeWindow();
    }

    /**
     * Method to close the window.
     */
    public void closeWindow() {
        loginPage.dispose();
    }

}
