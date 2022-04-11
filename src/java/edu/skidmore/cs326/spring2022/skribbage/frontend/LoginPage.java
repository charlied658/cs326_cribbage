package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
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
     * ule - UserLoginEvent object.
     */
    private UserLoginEvent ule;

    /**
     * evtFactory - EventFactory object.
     */
    private EventFactory evtFactory = EventFactory.getInstance();

    /**
     * currentUser - User object.
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
        LOG.trace("Entered constructor of a LoginPage.java");
        loginPage = new MainFrame(this, "Skribbage Battle Royale Login", 900,
            900, true);
        setup();
    }

    /**
     * setup method.
     * creates the createAccount, login, changePassword, and
     * homeScreenButton buttons as well as the logo object.
     */
    public void setup() {

        LOG.trace("Setup method in LOginPage.java");
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
        createdPassword = getUserInput("New User", "Enter password",
            DialogPosition.CENTER_ALL, true);
        verifyCreatedPassword = getUserInput("New User",
            "Enter password again", DialogPosition.CENTER_ALL, true);
        if (createdPassword.equals(verifyCreatedPassword)) {
            userCreatedCallback();
            
        }
    }
    
    /**
     * userCreatedCallback - method to verify a new user is created.
     */
    public void userCreatedCallback() {
        showMessage("User: " + createdUsername + " created.", 
            "New account created.", DialogType.INFORMATION);
    }
    
    /**
     * getUsername method.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * getpassword method.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * loggedIn method.
     * 
     * @return if the user is logged in
     */
    public boolean loggedIn() {
        if (!username.isEmpty() && !password.isEmpty()) {
            return true;
        } else {
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
            addMessage("Login button clicked");
            username = getUserInput("Login", "Enter username",
                DialogPosition.CENTER_ALL);
            //
            
            
            password = getUserInput("Login", "Enter password for: " + username,
                DialogPosition.CENTER_ALL, true);
            if (loggedIn()) {
                // currentUser = new User(null, username, password, null);
                // ule = (UserLoginEvent) evtFactory.createEvent(
                // EventType.USER_LOGIN, this, currentUser);
                // evtFactory.fireEvent(ule);
                showMessage("User: " + username, "Successful Log In",
                    DialogType.INFORMATION);
                navPage = new NavigationPage();
            } else {
                showMessage("User not found", "Unsuccessful Log In",
                    DialogType.ERROR);
            }
        } else if (e == changePassword) {
            changePassword.setFillColor(Color.GREEN);
            //change password = 0
            buttonClicked(0, "Change Password", "Enter new password");
            if (passwordToChange.equals(verifyPasswordToChange)) {
                addMessage("Passwords are the same");
                password = passwordToChange;
                username = usernameToChange;
            } else {
                addMessage("Passwords are not the same");
                while (!passwordToChange.equals(verifyPasswordToChange)) {
                    buttonClicked(1, "Passwords did not match",
                        "Enter new password");
                }
            }
        } else if (e == homeScreenButton) {
            addMessage("Go back");
            returnToHome();
        } else if (e == createAccount) {
            //create account = 2
            createAccount.setFillColor(Color.GREEN);
            buttonClicked(2, "New User", "Enter username");
            if (!createdPassword.equals(verifyCreatedPassword)) {
                buttonClicked(1, "Passwords did not match", "Enter password");
            }
        }
    }

    /**
     * goToNextPage method - once a user is logged in,
     * shows the navigation page.
     */
    public void goToNextPage() {
        new NavigationPage();
    }

    /**
     * returnToHome method handles if a user needs
     * to return to the main menu.
     */
    public void returnToHome() {
        homeScreen = new HomeScreen();
        loginPage.dispose();
    }

    /**
     * main method to initialize a new LoginPage object.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Main method in loginPage.java");
        new LoginPage();
    }
}
