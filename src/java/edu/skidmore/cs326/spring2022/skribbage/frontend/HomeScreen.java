package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * @author Zoe Beals
 *         Completed for Spring 1 Requirements 3/10/2022
 *         HomeScreen class holds functionality to to allow the user to peruse
 *         between pages (have not implemented the ability to go back yet)
 *         Reviewd by Sten Leinasaar
 *         ToDo homeScreen, loginPage, rulesPage, and pastGamesPage private
 *         instances
 *         are not used.
 *         To be determined if we need to initialize them globally or under
 *         methods.
 *         JavaDoc comment sentence need to end with full stop, otherwise it is
 *         a
 *         checkstyle error.
 *         If there are fatal or warning states of code, check for them and add
 *         LOG.warn or LOG.fatal comment.
 *    Last Edited: Zoe Beals at March 22, 2022
 */
public class HomeScreen extends DrawingSurface {

    /**
     * logo - Image to hold the temporary game logo.
     */
    private Image logo;

    /**
     * homeScreen - MainFrame window to hold the UI attributes.
     */
    private MainFrame homeScreen;

    /**
     * loginPage - LoginPage window to be presented upon button click.
     */
    private LoginPage loginPage;

    /**
     * rulesPageButton - Text variable that represents the button to go to
     * rules.
     * page
     */
    private Text rulesPageButton;

    /**
     * loginPageButton - Text variable that represents the button to go to the.
     * login page
     */
    private Text loginPageButton;

    /**
     * pastGamesPageButton - Text variable that represents the button to go to
     * the past games page.
     */
    private Text pastGamesPageButton;

    /**
     * rulesPage - RulesPage window to be presented upon button click.
     */
    private RulesPage rulesPage;

    /**
     * pastGamesPage - PastGamesPage window to be presented upon button click.
     */
    private PastGamesPage pastGamesPage;
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(HomeScreen.class);
    }

    /**
     * HomeScreen constructor.
     * Initializes the MainFrame window
     */
    public HomeScreen() {
        LOG.trace("HomeScreen.java constructor");
        homeScreen =
            new MainFrame(this, "Skribbage Battle Royale Home", 900, 900, true);
        setup();
    }

    /**
     * Setup method.
     * creates the loginPageButton, rulesPageButton, and pastGamesPageButton
     * Text buttons
     */
    public void setup() {
        LOG.trace("Setup method in HomeScreen.java");

        logo = new Image("logo.png", new Point(150, 0), .6, null);
        loginPageButton = new Text("Login Page",
            new Point(logo.getLocation().x + 225, logo.getLocation().y + 375),
            20, Color.black, Color.blue);
        rulesPageButton = new Text("Rules Page",
            new Point(loginPageButton.getLocation().x,
                loginPageButton.getLocation().y + 50),
            20, Color.black, Color.blue);
        pastGamesPageButton = new Text("Past Games Page",
            new Point(rulesPageButton.getLocation().x - 27,
                rulesPageButton.getLocation().y + 50),
            20, Color.black, Color.blue);
        add(loginPageButton);
        add(rulesPageButton);
        add(pastGamesPageButton);
        add(logo);
    }

    /**
     * override from DrawingSurface class.
     * 
     * @param e
     *            - Drawable object
     *            checks for a mousclick on the DrawingSurface, then determines
     *            if the clickable surface was any of the buttons created.
     *            if loginPageButton, displays the login page
     *            if rulesPageButton, displays the rules page
     *            if pastGamesPageButton, displays the past games page
     */
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in HomeScreen.java");
        if (e == loginPageButton) {
            loginPage = new LoginPage();
            closeCurrentWindow();
        } else if (e == rulesPageButton) {
            rulesPage = new RulesPage();
            closeCurrentWindow();
        } else if (e == pastGamesPageButton) {
            pastGamesPage = new PastGamesPage();
            closeCurrentWindow();
        }
    }
    /**
     * 
     */
    public void closeCurrentWindow() {
        homeScreen.dispose();
    }

    /**
     * main method to initialize a new HomeScreen object.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Main method in HomeScreen.java");
        new HomeScreen();
    }
}
