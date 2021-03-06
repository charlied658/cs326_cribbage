package edu.skidmore.cs326.spring2022.skribbage.frontend;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
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
    private Page activePage;

    /**
     * Single active user at a time.
     */
    private User loggedInUser;

    static {
        LOG = Logger.getLogger(PageManager.class);
        INSTANCE = new PageManager();
    }

    /**
     * PageManager constructor.
     */
    private PageManager() {
        LOG.debug("Instance created");
        // This line was causing 2 homescreens to display when starting the game
        // activePage = new HomeScreen();
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
     * getActivePage method.
     *
     * @return the active page.
     */
    public Page getActivePage() {
        return activePage;
    }

    /**
     * Get logged in user.
     * @return A user object.
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Set logged in user.
     * @param loggedInUser User that is now logged in.
     */
    public void setLoggedInUser(
        User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    /**
     * returns a created page.
     *
     * @param page page type to create.
     * @return the page.
     */
    public Page createPage(PageType page) {
        switch (page) {
            case LOGIN_PAGE:
                activePage = new LoginPage();
                break;
            case LOBBY_PAGE:
                activePage = new LobbyPage();
                break;
            case NAVIGATION_PAGE:
                activePage = new NavigationPage();
                break;
            case START_GAME_PAGE:
                activePage = new StartGamePage();
                break;
            case INVENTORY_PAGE:
                activePage = new InventoryPage();
                break;
            case HOMESCREEN_PAGE:
                activePage = new HomeScreen();
                break;
            case PAST_GAMES_PAGE:
                activePage = new PastGamesPage();
                break;
            case RULES_PAGE:
                activePage = new RulesPage();
                break;
            default:
                break;
        }
        return activePage;
    }

}
