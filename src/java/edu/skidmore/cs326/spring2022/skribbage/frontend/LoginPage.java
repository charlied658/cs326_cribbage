package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.*;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.*;
import us.daveread.edu.graphics.surface.*;
import us.daveread.edu.graphics.shape.impl.*;

//import us.daveread.edu.graphics.shape.Drawable;
//import us.daveread.edu.graphics.shape.impl.Text;
//import us.daveread.edu.graphics.shape.impl.Image;
//import us.daveread.edu.graphics.surface.DrawingSurface;
//import us.daveread.edu.graphics.surface.MainFrame;
/**
 * @author Zoe Beals
 *         Completed for Sprint 1 Requirements 3/9/2022
 *         LoginPage class holds initial functionality to prompt user to Login
 *         to the Gam
 */
public class LoginPage extends DrawingSurface {
    /**
     * loginPage - MainFrame window to hold the UI attributes
     */
    private MainFrame loginPage;

    /**
     * login - Text variable that represents the login button
     */
    private Text login;

    /**
     * username - String variable that holds the user inputted username
     */
    private String username;

    /**
     * usernameToChange - String variable that holds the user inputted username
     * in the case of a changePassword event
     */
    private String usernameToChange;

    /**
     * password - String variable that holds the user inputted password
     */
    private String password;

    /**
     * passwordToChange - String variable that holds the user inputted password
     * in the case of a changePassword event
     */
    private String passwordToChange;

    /**
     * verifyPasswordToChange - String variable that holds the user inputted
     * password to verify it in the case of a changePassword event
     */
    private String verifyPasswordToChange;

    /**
     * changePassword - Text variable that represents the change password button
     */
    private Text changePassword;

    /**
     * LOG - logger variable to be able to display logger messages
     */
    private static final Logger LOG;

    /**
     * instantiation of the logger
     */
    static {
        LOG = Logger.getLogger(LoginPage.class);
    }

    /**
     * LoginPage constructor
     * Initializes the MainFrame window
     */
    public LoginPage() {
        LOG.trace("Entered constructor of a LoginPage.java");
        loginPage = new MainFrame(this, "Skribbage Battle Royale Login", 900,
            900, true);
        setup();
    }

    /**
     * setup method
     * creates the login and changePassword Text buttons
     */
    public void setup() {
        LOG.trace("Setup method in LOginPage.java");
        login =
            new Text("Login", new Point(50, 50), 20, Color.black, Color.blue);
        changePassword = new Text("Change Password",
            new Point(login.getLocation().x + 100, 50), 20, Color.black,
            Color.blue);
        add(login);
        add(changePassword);
    }

    /**
     * changePasswordButtonClicked method
     * 
     * @param presentUser
     *            - boolean value to check if the username prompt needs to be
     *            shown multiple times
     *            depending on presentUser boolean, presents windows for the
     *            user to verify their new password upon a changePassword button
     *            click
     */
    public void changePasswordButtonClicked(boolean presentUser) {
        LOG.trace("ChangePassword method in LoginPage.java");
        if (presentUser) {
            usernameToChange = getUserInput("Change Password", "Enter username",
                DialogPosition.CENTER_ALL);
        }
        passwordToChange = getUserInput("Change Password", "Enter new password",
            DialogPosition.CENTER_ALL, true);
        verifyPasswordToChange = getUserInput("Change Password",
            "Enter password again", DialogPosition.CENTER_ALL, true);
    }

    /**
     * override from DrawingSurface class
     * 
     * @param e
     *            - Drawable object
     * checks for a mouseclick on the DrawingSurface, then determines
     * if the clickable surface was any of the buttons created.
     * if login button, prompts user to enter username and password
     *            if changePassword button, prompts user to enter their username
     *            depending on the boolean presentUser, and create new password
     *            and verify it.
     */
    public void drawableMouseClick(Drawable e) {
        LOG.trace("Drawable mouseclick method in LoginPage.java");
        if (e == login) {
            login.setFillColor(Color.GREEN);
            addMessage("Login button clicked");
            username = getUserInput("Login", "Enter username",
                DialogPosition.CENTER_ALL);
            password = getUserInput("Login", "Enter password for: " + username,
                DialogPosition.CENTER_ALL, true);
        } else if (e == changePassword) {
            changePassword.setFillColor(Color.GREEN);
            changePasswordButtonClicked(true);
            if (passwordToChange.equals(verifyPasswordToChange)) {
                addMessage("Passwords are the same");
                password = passwordToChange;
                username = usernameToChange;
            } else {
                addMessage("Passwords are not the same");
                while (!passwordToChange.equals(verifyPasswordToChange)) {
                    changePasswordButtonClicked(false);
                }
            }
        }
    }

    /**
     * main method to initialize a new LoginPage object
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Main method in loginPage.java");
        new LoginPage();
    }
}
