package edu.skidmore.cs326.spring2022.skribbage.frontend;

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
     * Single active page open at a time.
     */
    @SuppressWarnings("unused")
    private final Page activePage;

    static {
        LOG = Logger.getLogger(PageManager.class);
        INSTANCE = new PageManager();
    }

    /**
     * PageManager constructor.
     */
    private PageManager() {
        LOG.debug("Instance created");
        activePage = new HomeScreen();
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
     * createPage method.
     * 
     * @param page
     * @return the page to create.
     */
    public Page createPage(PageType page) {
        switch (page) {
            case LOGIN_PAGE:
                return new LoginPage();
            case LOBBY_PAGE:
                return new LobbyPage();
            case NAVIGATION_PAGE:
                return new NavigationPage();
            case START_GAME_PAGE: 
                return new StartGamePage();
            case INVENTORY_PAGE:
                return new InventoryPage();
            case HOMESCREEN_PAGE:
                return new HomeScreen();
            case PAST_GAMES_PAGE:
                return new PastGamesPage();
            default:
                return null;
        }
    }

}
