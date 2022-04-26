
package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;
import edu.skidmore.cs326.spring2022.skribbage.common.LobbyManager;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Navigation Page - holds the functionality to peruse
 * between Rules, Past Games, and New Game pages.
 *
 * @author Zoe Beals
 * Code reviewed by Sten Leinasaar 04/20/22
 * Line modified by Declan Morris on 04/26/22
 */
@SuppressWarnings("serial")
public class NavigationPage extends DrawingSurface implements Page {

    /**
     * welcomeMessage - Text variable to hold welcome message.
     */
    private Text welcomeMessage;

    /**
     * user - Text variable to hold user.
     */
    private Text user;

    /**
     * loginPage - LoginPage window.
     */
    @SuppressWarnings("unused")
    private LoginPage loginPage;

    /**
     * logOut - Text varibale to hold link to log out.
     */
    private Text logOut;

    /**
     * logo - game logo.
     */
    private Image logo;

    /**
     * navPage - MainFrame window.
     */
    private MainFrame navPage;

    /**
     * rulesPageButton - Text variable to hold link to rules page.
     */
    private Text rulesPageButton;

    /**
     * rulesPage - RulesPage window.
     */
    @SuppressWarnings("unused")
    private RulesPage rulesPage;

    /**
     * lobbyPage - LobbyPage window.
     */
    @SuppressWarnings("unused")
    private LobbyPage lobbyPage;

    /**
     * lobbyPageButton - Text variable to hold link to lobby page.
     */
    private Text lobbyPageButton;

    /**
     * pastGamesPageButton - Text variable to hold link to past games page.
     */
    private Text pastGamesPageButton;

    /**
     * pastGamesPage - PastGamesPage window.
     */
    @SuppressWarnings("unused")
    private PastGamesPage pastGamesPage;

    /**
     * PageManager instance for page management.
     */
    private PageManager pageManager;

    /**
     * EventManager instance for event management.
     */
    private final EventFactory eventFactory;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(NavigationPage.class);
    }

    /**
     * NavigationPage constructor.
     */
    public NavigationPage() {
        LOG.trace("Entered NavigationPage Constructor.");
        pageManager = PageManager.getInstance();
        eventFactory = EventFactory.getInstance();
        navPage = new MainFrame(this, "Skribbage Battle Royale Navigation",
            900, 900, false);
        setup();
    }

    /**
     * setup method to instantiate the NavPage window.
     */
    public void setup() {
        LOG.trace("Entered setup method for NavPage");

        LOG.trace("Creating a logo in NavPage.java in setup method.");
        logo = new Image("logo.png", new Point(150, 0), .6, null);
        add(logo);

        LOG.trace("Creating rules page button in NavPage.java in setup method");
        rulesPageButton = new Text("View Game Rules",
            new Point(logo.getLocation().x + 225, logo.getLocation().y + 360),
            20, Color.black, Color.blue);
        add(rulesPageButton);

        LOG.trace("Creating lobby page button in NavPage.java in setup "
            + "method.");
        lobbyPageButton = new Text("Enter Lobby",
            new Point(rulesPageButton.getLocation().x + 20,
                rulesPageButton.getLocation().y + 40),
            20,
            Color.black, Color.blue);
        add(lobbyPageButton);

        LOG.trace("Creating past games page button in NavPage.java in setup.");
        pastGamesPageButton = new Text("Load Existing Game", new Point(
            lobbyPageButton.getLocation().x - 29,
            lobbyPageButton.getLocation().y + 40), 20,
            Color.black, Color.blue);
        add(pastGamesPageButton);

        LOG.trace("Creating log out button in NavPage.java in setup");
        logOut = new Text("Log Out", new Point(logo.getLocation().x,
            logo.getLocation().y + 350), 20,
            Color.black, Color.blue);
        add(logOut);

        welcomeMessage =
            new Text("Welcome", new Point(20, 30), 20, Color.black, Color.blue);
        // user = new Text(
        // "" + LoginPageManager.getInstance().getLoginPage().getUsername(),
        // new Point(20, 60), 20, Color.black, Color.blue);
        // add(user);
        user = new Text(
            "" + pageManager.getLoggedInUser().getUserName(),
            new Point(20, 60), 20, Color.black, Color.blue);
        add(user);
        add(welcomeMessage);
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        if (e == rulesPageButton) {
            rulesPage = (RulesPage) pageManager.createPage(PageType.RULES_PAGE);
            closeWindow();
        } else if (e == lobbyPageButton) {


            // Fire an event to start a new lobby
            // Lobby lobby = new Lobby()
            if (pageManager.getLoggedInUser() != null) {
                LOG.trace(
                    "Starting a new lobby from Nav page with user "
                        + pageManager.getLoggedInUser());
                LobbyManager.getInstance()
                    .createLobby(pageManager.getLoggedInUser());
            } else {
                LOG.error("A user started a lobby without being logged in");
            }
            lobbyPage = (LobbyPage) pageManager.createPage(PageType.LOBBY_PAGE);
            closeWindow();

        } else if (e == pastGamesPageButton) {
            pastGamesPage = (PastGamesPage) pageManager
                .createPage(PageType.PAST_GAMES_PAGE);
            closeWindow();
        } else if (e == logOut) {
            loginPage = (LoginPage) pageManager.createPage(PageType.LOGIN_PAGE);
            closeWindow();
        }
    }

    /**
     * closing the navigation page.
     */
    public void closeWindow() {
        navPage.dispose();
    }

}
