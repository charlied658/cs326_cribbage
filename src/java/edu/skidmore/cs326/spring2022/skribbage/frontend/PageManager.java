package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Page manager for different page persistence.
 * 
 * @author Zoe Beals
 *         4/13/2022
 *         Code review by Jonah Marcus on 17 April 2022
 */
public final class PageManager {

    /**
     * logger.
     */
    private static final Logger LOG;

    /**
     * singleton instance of this class.
     */
    private static final PageManager INSTANCE;

    /**
     * key for the login page.
     */
    private static final String LOGINKEY;

    /**
     * key for the home page.
     */
    private static final String HOMEKEY;

    /**
     * key for the navigation page.
     */
    private static final String NAVKEY;

    /**
     * key for the lobby.
     */
    private static final String LOBBYKEY;

    /**
     * key for the rules.
     */
    private static final String RULESKEY;

    /**
     * key for the past games page.
     */
    private static final String LOADKEY;

    /**
     * hashmap of pages.
     */
    private HashMap<String, Object> pages;

    static {
        LOG = Logger.getLogger(PageManager.class);
        LOGINKEY = "LoginPage";
        HOMEKEY = "HomePage";
        NAVKEY = "NavigationPage";
        LOBBYKEY = "LobbyPage";
        RULESKEY = "RulesPage";
        LOADKEY = "PastGamesPage";
        INSTANCE = new PageManager();
    }

    /**
     * PageManager constructor.
     */
    private PageManager() {
        LOG.debug("Instance created");
        pages = new HashMap<>();
        setup();
    }

    /**
     * getInstance method.
     * 
     * @return the instance of the class.
     */
    public static PageManager getInstance() {
        return INSTANCE;
    }

    /**
     * setup method.
     */
    private void setup() {
        pages.put(HOMEKEY, new HomeScreen());
        pages.put(LOGINKEY, new LoginPage());
        // pages.put(LOADKEY, new PastGamesPage());
        pages.put(LOBBYKEY, new LobbyPage());
        pages.put(NAVKEY, new NavigationPage());
        pages.put(RULESKEY, new RulesPage());
        System.out.println("HELLO" + pages);
    }

    /**
     * getter method for login page.
     * 
     * @return the login page.
     */
    public LoginPage getLoginPage() {
        return (LoginPage) pages.get(LOGINKEY);
    }

    /**
     * getter method for home page.
     * 
     * @return the home page.
     */
    public HomeScreen getHomePage() {
        return (HomeScreen) pages.get(HOMEKEY);
    }

    /**
     * getter method for past games page.
     * 
     * @return the past games
     */
    public PastGamesPage getPastGamesPage() {
        return (PastGamesPage) pages.get(LOADKEY);
    }

    /**
     * getter method for lobby page.
     * 
     * @return the lobby page.
     */
    public LobbyPage getLobbyPage() {
        return (LobbyPage) pages.get(LOBBYKEY);
    }

    /**
     * getter method for navigation page.
     * 
     * @return the navigation page.
     */
    public NavigationPage getNavPage() {
        return (NavigationPage) pages.get(NAVKEY);
    }

    /**
     * getter method for rules page.
     * 
     * @return the rules page.
     */
    public RulesPage getRulesPage() {
        return (RulesPage) pages.get(RULESKEY);
    }
}
