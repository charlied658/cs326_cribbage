package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
//import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DialogPosition;
import us.daveread.edu.graphics.surface.DialogType;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * @author Zoe Beals updated as of 3/22/2022
 *         Code reviewed by Jonah Marcus on April 11, 2022.
 *         Comment by Jonah:
 *         "Commented out an import that was creating a warning. Also, the
 *         ButtonClicked method could benefit from a few additional comments
 *         explaining what each case is. I THINK I was able to figure it out
 *         on my own, but it would still be nice to have."
 */
public class LoginPage extends DrawingSurface {

    /**
     * createAccount - Text variable that represents the create account button.
     */
    private Text createAccount;

    /**
     * navPage - NavigationPage window.
     */
    private NavigationPage navPage;

    /**
     * ule - UserCreateAccountEvent object.
     */
    private UserCreateAccountEvent ule;

    /**
     * lEvt - UserLoginEvent object.
     */
    private UserLoginEvent lEvt;

    /**
     * evtFactory - EventFactory object.
     */
    private EventFactory evtFactory = EventFactory.getInstance();

    /**
     * currentUser - User object.
     */
    private static User currentUser;

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
     * logo - Image to hold the temporary game logo.
     */
    private Image logo;

    /**
     * loginPage - MainFrame window to hold the UI attributes.
     */
    private MainFrame loginPage;

    /**
     * login - Text variable that represents the login button.
     */
    private Text login;

    /**
     * username - String variable that holds the user inputted username.
     */
    private String username;

    /**
     * usernameToChange - String variable that holds the user inputted username.
     * in
     * the case of a changePassword event
     */
    private String usernameToChange;

    /**
     * password - String variable that holds the user inputted password.
     */
    private String password;

    /**
     * passwordToChange - String variable that holds the user inputted password.
     * in
     * the case of a changePassword event
     */
    private String passwordToChange;

    /**
     * verifyPasswordToChange - String variable that holds the user inputted
     * password to verify it in the case of a changePassword event.
     */
    private String verifyPasswordToChange;

    /**
     * changePassword - Text variable that represents the change password
     * button.
     */
    private Text changePassword;

    /**
     * homeScreen - HomeScreen window to hold the home screen.
     */
    private HomeScreen homeScreen;

    /**
     * homeScreenButton - Text variable that represents the button to go
     * back to the home screen.
     */
    private Text homeScreenButton;

    /**
     * LOG - logger variable to be able to display logger messages.
     */
    private static final Logger LOG;

    /**
     * instantiation of the logger
     */
    static {
        LOG = Logger.getLogger(LoginPage.class);
    }

    /**
     * LoginPage constructor Initializes the MainFrame window.
     */
    public LoginPage() {
        LOG.debug("Instance created");
        loginPage = new MainFrame(this, "Skribbage Battle Royale Login", 900,
            900, false);
        createAccount = new Text("Create Account", new Point(375, 360), 20,
            Color.black, Color.blue);
        login =
            new Text("Login", new Point(425, 400), 20, Color.black, Color.blue);
        changePassword = new Text("Change Password", new Point(369, 440), 20,
            Color.black, Color.blue);
        homeScreenButton =
            new Text("Back", new Point(10, 25), 20, Color.black, Color.blue);
        logo = new Image("logo.png", new Point(150, 0), 0.6, null);
        add(homeScreenButton);
        add(login);
        add(changePassword);
        add(logo);
        add(createAccount);
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
            case 0:
                usernameToChange = getUserInput(popupTitle, "Enter username",
                    DialogPosition.CENTER_ALL);
                passwordToChange = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL, true);
                verifyPasswordToChange = getUserInput(popupTitle,
                    popupMessage + " again", DialogPosition.CENTER_ALL, true);
                break;
            case 1:
                passwordToChange = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL, true);
                verifyPasswordToChange = getUserInput(popupTitle,
                    popupMessage + " again", DialogPosition.CENTER_ALL, true);
                break;
            case 2:
                createdUsername = getUserInput(popupTitle, popupMessage,
                    DialogPosition.CENTER_ALL);
                // currentUser = new User(null, createdUsername, null, null);
                // ule = (UserCreateAccountEvent) evtFactory.createEvent(
                // EventType.USER_CREATE_ACCOUNT, this, currentUser);
                // evtFactory.fireEvent(ule);
                verifyNewUserCallback();
                break;
            default:
                break;
        }
    }

    /**
     * verifyNewUserCallback - method to verify a new user is available.
     */
    public void verifyNewUserCallback() {
        LOG.trace("verifyNewUserCallback method in LoginPage.java");
        createdPassword = getUserInput("New User", "Enter password",
            DialogPosition.CENTER_ALL, true);
        verifyCreatedPassword = getUserInput("New User",
            "Enter password again", DialogPosition.CENTER_ALL, true);
        if (createdPassword.equals(verifyCreatedPassword)) {
            currentUser =
                new User(null, createdUsername, createdPassword, null);
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

    /**
     * getUsername method.
     *
     * @return the username
     */
    public String getUsername() {
        LOG.trace("getUsername method in LoginPage.java");
        if (currentUser == null) {
            return this.username;
        } else {
            return currentUser.getUserName();
        }
    }

    /**
     * getpassword method.
     *
     * @return the password
     */
    public String getPassword() {
        LOG.trace("getPasswrod method in LoginPage.java");
        return password;
    }

    /**
     * loggedIn method.
     *
     * @return if the user is logged in
     */
    public boolean loggedIn() {
        LOG.trace("loggedIn method in LoginPage.java");
        if (currentUser != null) {
            if (username.equals(currentUser.getUserName())
                && password.equals(currentUser.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out
                .println(
                    "FALSE username: " + username + " password: " + password);
            return false;
        }
    }

    /**
    *
    */
    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("Drawable mouseclick method in LoginPage.java");
        if (e == login) {

            // separate the username and password functionality.
            // outside listener tells me when to run the password method.
            login.setFillColor(Color.GREEN);
            this.username = getUserInput("Login", "Enter username",
                DialogPosition.CENTER_ALL);
            // verifyUsernameExists();
            password = getUserInput("Login", "Enter password for: " + username,
                DialogPosition.CENTER_ALL, true);
            // verifyUserExists();
            if (loggedIn()) {
                currentUser.setUserName(username);
                showMessage("User: " + username, "Successful Log In",
                    DialogType.INFORMATION);
                // navPage = NavigationPageManager.getInstance().getNavPage();
                navPage = new NavigationPage();
                closeWindow();
            } else {
                showMessage("User not found", "Unsuccessful Log In",
                    DialogType.ERROR);
            }
        } else if (e == changePassword) {
            changePassword.setFillColor(Color.GREEN);
            // change password = 0
            buttonClicked(0, "Change Password", "Enter new password");
            if (passwordToChange.equals(verifyPasswordToChange)) {
                password = passwordToChange;
                username = usernameToChange;
            } else {
                while (!passwordToChange.equals(verifyPasswordToChange)) {
                    buttonClicked(1, "Passwords did not match",
                        "Enter new password");
                }
            }
        } else if (e == homeScreenButton) {
            returnToHome();
        } else if (e == createAccount) {
            // create account = 2
            createAccount.setFillColor(Color.GREEN);
            buttonClicked(2, "New User", "Enter username");
            if (!createdPassword.equals(verifyCreatedPassword)) {
                buttonClicked(1, "Passwords did not match", "Enter password");
            }
        }
    }

    /**
     * verifyUsernameExists - checks if a user that's logging in exists.
     */
    public void verifyUsernameExists() {
        LOG.trace("verifyUsernameExists method in LoginPage.java");
        currentUser = new User(null, username, null, null);
        lEvt = (UserLoginEvent) evtFactory
            .createEvent(EventType.USER_LOGIN, this, currentUser);
        evtFactory.fireEvent(lEvt);
    }

    /**
     * verifyUserExists - checks if a user object exists.
     */
    public void verifyUserExists() {
        LOG.trace("verifyUserExists method in LoginPage.java");
        currentUser = new User(null, username, password, null);
        lEvt = (UserLoginEvent) evtFactory.createEvent(EventType.USER_LOGIN,
            this, currentUser);
    }

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
        // closeWindow();
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
