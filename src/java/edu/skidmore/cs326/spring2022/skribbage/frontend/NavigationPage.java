
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
 * Navigation Page - holds the functionality to peruse
 * between Rules, Past Games, and New Game pages.
 * 
 * @author Zoe Beals
 * 
 *      Code reviewed by Jonah Marcus on April 11, 2022.
 */
public class NavigationPage extends DrawingSurface {
    
    /**
     * loginPage - LoginPage window.
     */
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
    private RulesPage rulesPage;

    /**
     * lobbyPage - LobbyPage window.
     */
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
    private PastGamesPage pastGamesPage;
    
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
        navPage = new MainFrame(this, "Skribbage Battle Royale Navigation",
            900, 900, true);
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
            rulesPageButton.getLocation().y + 40), 20, 
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
    }
    
    @Override
    public void drawableMouseClick(Drawable e) {
        if (e == rulesPageButton) {
            rulesPage = new RulesPage();
        } else if (e == lobbyPageButton) {
            lobbyPage = new LobbyPage();
        } else if (e == pastGamesPageButton) {
            pastGamesPage = new PastGamesPage();
        } else if (e == logOut) {
            loginPage = new LoginPage();
        }
    }
    
    /**
     * main method to run program.
     * @param args
     */
    public static void main(String[] args) {
        new NavigationPage();
    }

}
