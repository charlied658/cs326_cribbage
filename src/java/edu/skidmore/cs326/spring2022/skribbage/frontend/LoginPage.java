package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;
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
public class LoginPage extends DrawingSurface {
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
     * PersistenceFacade event.
     */
    private final PersistenceFacade persistence;

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
        currentUser = new User(null);
        persistence = PersistenceFacade.getInstance();
        evtFactory = EventFactory.getInstance();
        hasher = PasswordHasher.getInstance();

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
     * method to handle different button clicks.
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

                currentUser.setUserName(usernameToChange);
                currentPassword = new Password(
                    hasher.hashNewPassword(password));

                // verify if this user exists.
                // loggedIn returns true if this user and password exists in the
                // database.
                // False otherwise.
                if (loggedIn()) {
                    passwordToChange = getUserInput(popupTitle, popupMessage,
                        DialogPosition.CENTER_ALL, true);
                    verifyPasswordToChange = getUserInput(popupTitle,
                        popupMessage + " again", DialogPosition.CENTER_ALL,
                        true);
                    newPassword =
                        new Password(hasher.hashNewPassword(passwordToChange));
                    // forChecking is the password from createNewUser. We Should
                    // not
                    // Allow changing password before they are verified.
                    if (passwordToChange.equals(verifyPasswordToChange)) {
                        persistence.passwordChange(currentUser, currentPassword,
                            newPassword);
                        showMessage("Password changed succesfully", "Success!",
                            DialogType.ERROR);

                    } else {
                        showMessage("Passwords did not match",
                            "Unsuccessful password change",
                            DialogType.ERROR);
                        buttonClicked(1, popupTitle, popupMessage);
                    }
                } else {
                    showMessage(
                        "User does not exist. Cannot change the password",
                        "Create a new account.",
                        DialogType.ERROR);
                }
                break;

            case 1:
                passwordToChange = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL, true);
                verifyPasswordToChange = getUserInput(popupTitle,
                    popupMessage + " again", DialogPosition.CENTER_ALL, true);
                newPassword = new Password(hasher.hashNewPassword(passwordToChange));
                if (passwordToChange.equals(verifyPasswordToChange)) {
                    persistence.passwordChange(currentUser, currentPassword,
                        newPassword);
                } else {
                    showMessage("Passwords did not match",
                        "Unsuccessful password change",
                        DialogType.ERROR);
                    buttonClicked(1, popupTitle, popupMessage);
                }

                break;

            // create account
            case 2:
                createdUsername = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL);
                // currentUser = new User(null, createdUsername, null, null);
                // ule = (UserCreateAccountEvent) evtFactory.createEvent(
                // EventType.USER_CREATE_ACCOUNT, this, currentUser);
                // evtFactory.fireEvent(ule);

                currentUser.setUserName(createdUsername);

                // Verify if username is available. If so, call password
                // setting.
                if (persistence.validateUsername(currentUser)) {
                    createNewUser();
                } else {
                    showMessage("Username taken", "Please try again",
                        DialogType.ERROR);
                    buttonClicked(2, popupTitle, popupMessage);
                }

                break;
            default:
                break;
        }
    }

    /**
     * verifyNewUserCallback - method to verify a new user is available.
     */
    public void createNewUser() {
        LOG.trace("verifyNewUserCallback method in LoginPage.java");
        createdPassword = getUserInput("New User", "Enter password",
            DialogPosition.CENTER_ALL, true);
        verifyCreatedPassword = getUserInput("New User",
            "Enter password again", DialogPosition.CENTER_ALL, true);

        if (createdPassword.equals(verifyCreatedPassword)) {
            currentPassword = new Password(hasher.hashNewPassword(createdPassword));
            persistence.userCreate(currentUser, currentPassword);
            userCreatedCallback();
            // currentUser =
            // new User(null, createdUsername, forChecking, null);
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
        // currentUser = new User(null, createdUsername, createdPassword, null);
        // ule = (UserCreateAccountEvent) evtFactory
        // .createEvent(EventType.USER_CREATE_ACCOUNT, this, currentUser);
        // evtFactory.fireEvent(ule);
    }

    // /**
    // * getUsername method.
    // *
    // * @return the username
    // */
    // public String getUsername() {
    // LOG.trace("getUsername method in LoginPage.java");
    // if (currentUser == null) {
    // return username;
    // } else {
    // return currentUser.getUserName();
    // }
    // }

    // /**
    // * getpassword method.
    // *
    // * @return the password
    // */
    // public String getPassword() {
    // LOG.trace("getPasswrod method in LoginPage.java");
    // return password;
    // }

    /**
     * THIS HERE SHOULD BE COMMUNICATION WITH THE BACKEND.
     * 1) Create a user
     * 2) Get an instance of the eventFactory.
     * 3)Create an instance of type USERLOGIN second argument being User
     * 4) fire the event.
     */

    /**
     * loggedIn method.
     *
     * @return if the user is logged in
     */
    public boolean loggedIn() {
        LOG.debug("Calling backend facade for a login method.");
        return persistence.login(currentUser, currentPassword);

        // if (currentUser != null) {
        // if (username.equals(currentUser.getUserName())
        // && password.equals(currentUser.getPassword())) {
        // return true;
        // } else {
        // return false;
        // }
        // } else {
        // System.out
        // .println(
        // "FALSE username: " + username + " password: " + password);
        // return false;
        // }
    }

    /**
    *
    */
    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("Drawable mouseclick method in LoginPage.java");
        /**
         * If Login is pressed. UserName and password need to be asked.
         * Then event is created and fired.
         * I
         * If succesful login, then close the login page and open a navigation
         * page.
         * If not succesful, then prompt them a dialog that says, create a user.
         */
        if (e == loginButton) {
            /**
             * Login Button press starts the following steps:
             * 1) User input for username and password.
             * 2) Password is used to create a new Password object with the
             * string input.
             * 3) Username is used to set it as a usernam for this user object.
             * 4) loggedIn() is called that communicates with back end.
             * a. If succesful show message of succesful log in and open a
             * navigation page and close loginPage.
             * b. Else it shows an error message. Prompts them to make an
             * account.
             */
            loginButton.setFillColor(Color.GREEN);
            username = getUserInput("Login", "Enter username",
                DialogPosition.CENTER_ALL);
            password =
                getUserInput("Login", "Enter password for: " + username,
                    DialogPosition.CENTER_ALL, true);
            currentPassword = new Password(hasher.hashNewPassword(password));
            currentUser.setUserName(username);

            if (loggedIn()) {
                showMessage("User: " + username, "Successful Log In",
                    DialogType.INFORMATION);
                // navPage = NavigationPageManager.getInstance().getNavPage();
                navPage = new NavigationPage();
                closeWindow();
            } else {
                showMessage(
                    "User does not exist. "
                        + "Please create a new account or try again.",
                    "Unsuccessful Log In",
                    DialogType.ERROR);

            }
        } else if (e == changePasswordButton) {
            changePasswordButton.setFillColor(Color.GREEN);
            buttonClicked(0, "Change Password", "Enter new password");
            // if (passwordToChange.equals(verifyPasswordToChange)) {
            // password = passwordToChange;
            // username = usernameToChange;
            // } else {
            // while (!passwordToChange.equals(verifyPasswordToChange)) {
            // buttonClicked(1, "Passwords did not match",
            // "Enter new password");
            // }
            // }
        } else if (e == createAccountButton) {
            createAccountButton.setFillColor(Color.GREEN);
            buttonClicked(2, "New User", "Enter username");

            // if (!createdPassword.equals(verifyCreatedPassword)) {
            // buttonClicked(1, "Passwords did not match", "Enter password");
            // }
        } else if (e == homeScreenButton) {
            returnToHome();
        } else if (e == startGameButton) {
            backdoor = new StartGamePage();
            closeWindow();

        }
    }

    /**
     * verifyUsernameExists - checks if a user that's logging in exists.
     */
    // public void verifyUsernameExists() {
    // LOG.trace("verifyUsernameExists method in LoginPage.java");
    // currentUser = new User(null, username, null, null);
    // lEvt = (UserLoginEvent) evtFactory
    // .createEvent(EventType.USER_LOGIN, this, currentUser);
    // evtFactory.fireEvent(lEvt);
    // }

    /**
     * verifyUserExists - checks if a user object exists.
     */
    // public void verifyUserExists() {
    // LOG.trace("verifyUserExists method in LoginPage.java");
    // currentUser = new User(null, username, password, null);
    // lEvt = (UserLoginEvent) evtFactory.createEvent(EventType.USER_LOGIN,
    // this, currentUser);
    // }

    /**
     * goToNextPage method - once a user is logged in,
     * shows the navigation page.
     */
    // public void goToNextPage() {
    // LOG.trace("goToNextPage method in LoginPage.java");
    //// navPage = NavigationPageManager.getInstance().getNavPage();
    // navPage = new NavigationPage();
    // closeWindow();
    // }

    /**
     * returnToHome method handles if a user needs
     * to return to the main menu.
     */
    public void returnToHome() {
        LOG.trace("returnToHome method in LoginPage.java");
        homeScreen = new HomeScreen();
        closeWindow();
        // loginPage.dispose();
    }

    /**
     * close the window.
     */
    public void closeWindow() {
        loginPage.dispose();
    }

    /**
     * main method to initialize a new LoginPage object.
     *
     * @param args
     */
    // public static void main(String[] args) {
    // LOG.trace("Main method in loginPage.java");
    // new Logi();
    // }
}
