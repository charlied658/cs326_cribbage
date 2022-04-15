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
 *         updated as of 3/22/2022.
 *         HomeScreen class to act as the main menu
 *         of the game of cribbage.
 *         Code reviewed by Jonah Marcus on 3/29/2022
 */
public class HomeScreen extends DrawingSurface {

    /**
     * welcomeMessage - Text variable that holds the welcome message.
     */
    private Text welcomeMessage;

    /**
     * startGamePage - Start game window.
     */
    private StartGamePage startGamePage;

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
     * rules page.
     */
    private Text rulesPageButton;

    /**
     * loginPageButton - Text variable that represents the button to go to the
     * login page.
     */
    private Text loginPageButton;

    /**
     * lobbyPageButton - Text variable that represents the button to go to the
     * lobby page.
     */
    private Text lobbyPageButton;

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
     * lobbyPage - LobbyPage window to be presented upon button click.
     */
    private LobbyPage lobbyPage;

    /**
     * pastGamesPage - PastGamesPage window to be presented upon button click.
     */
    private PastGamesPage pastGamesPage;

    /**
     * startGameButton - Text var to represent starting a game.
     */
    private Text startGameButton;

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
     * Setup method creates the buttons being shown on the home screen.
     */
    public void setup() {
        LOG.trace("Setup method in HomeScreen.java started.");
        LOG.trace("Creating a Logo in HomeScreen.java in setup method.");
        logo = new Image("logo.png", new Point(150, 0), .6, null);

        // LOG.trace(
        // "Creating a RulesPageButton in HomeScreen.java in setup method.");
        // rulesPageButton = new Text("Rules Page",
        // new Point(loginPageButton.getLocation().x,
        // loginPageButton.getLocation().y + 50),
        // 20, Color.black, Color.blue);
        // LOG.trace(
        // "Creating a pastGamesPageButton in homeScreen.java setup method.");
        // pastGamesPageButton = new Text("Past Games Page",
        // new Point(rulesPageButton.getLocation().x - 27,
        // rulesPageButton.getLocation().y + 50),
        // 20, Color.black, Color.blue);
        // LOG.trace(
        // "Creating a lobbyPageButton in HomeScreen.java setup method. ");
        // lobbyPageButton = new Text("Lobby Page", new Point(
        // pastGamesPageButton.getLocation().x + 27,
        // pastGamesPageButton.getLocation().y + 50), 20,
        // Color.black, Color.blue);
        // LOG.trace(
        // "Creating a startGameButtong in HomeScreen.java setup method.");
        // startGameButton = new Text("Start Game",
        // new Point(lobbyPageButton.getLocation().x,
        // lobbyPageButton.getLocation().y + 50),
        // 20, Color.black,
        // Color.blue);
        // LOG.trace(
        // "Going to add a lobby Page Button "
        // + "to the mainFrame in HomeScreen.java.");
        // // add(lobbyPageButton);
        // LOG.trace(
        // "Going to add a login page button "
        // + "to the main frame in HomeScreen.java.");
        // LOG.trace(
        // "Going to add a rules page button "
        // + "to the main frame in HomeScreen.java class.");
        // // add(rulesPageButton);
        // LOG.trace(
        // " Going to add past games page button "
        // + "to the main frame in HomeScreen.java class.");
        // add(pastGamesPageButton);
        // LOG.trace(
        // " Going to add start game button"
        // + " to the main frame in HomeScreen.java.");
        // // add(startGameButton);
        LOG.trace(
            " Going add the logo to the main frame in HomeScreen.java class.");
        add(logo);
        LOG.trace(
            "Creating a loginPageButtong in HomeScreen.java in setup method.");

        welcomeMessage =
            new Text("Welcome. Please log in/sign up to begin a new game.",
                new Point(logo.getLocation().x + 35,
                    logo.getLocation().y + 350),
                20,
                Color.black, Color.blue);
        loginPageButton = new Text("Login/Sign Up",
            new Point(welcomeMessage.getLocation().x
                + 195, welcomeMessage.getLocation().y + 40),
            20, Color.black, Color.blue);
        add(loginPageButton);
        add(welcomeMessage);
    }

    /**
     * override from DrawingSurface class.
     * 
     * @param e
     *            - Drawable object
     *            checks for a mouseclick on the DrawingSurface, then determines
     *            if the clickable surface was any of the buttons created.
     *            if loginPageButton, displays the login page
     *            if rulesPageButton, displays the rules page
     *            if pastGamesPageButton, displays the past games page
     */
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in HomeScreen.java");
        if (e == loginPageButton) {
            loginPage = PageManager.getInstance().getLoginPage();
            closeCurrentWindow();
        } else if (e == rulesPageButton) {
            rulesPage = new RulesPage();
            closeCurrentWindow();
        } else if (e == pastGamesPageButton) {
            pastGamesPage = new PastGamesPage();
            closeCurrentWindow();
        } else if (e == lobbyPageButton) {
            lobbyPage = new LobbyPage();
            closeCurrentWindow();
        } else if (e == startGameButton) {
            if (loginPage.loggedIn()) {
                lobbyPage = new LobbyPage();
            } else {
                loginPage = LoginPageManager.getInstance().getLoginPage();
            }
            startGamePage = new StartGamePage();
            closeCurrentWindow();
        }
    }

    /**
     * Closes current window.
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
