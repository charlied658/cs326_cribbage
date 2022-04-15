package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Navigation Page manager class.
 * 
 * @author Zoe Beals
 */
public class NavigationPageManager {

    /**
     * LOG.
     */
    private static final Logger LOG;

    /**
     * singleton instance.
     */
    private static final NavigationPageManager INSTANCE;

    /**
     * key for the nav page.
     */
    private static final String NAVKEY;

    /**
     * nav page hashmap.
     */
    private HashMap<String, NavigationPage> navPage;

    static {
        LOG = Logger.getLogger(NavigationPageManager.class);
        NAVKEY = "NavPage";
        INSTANCE = new NavigationPageManager();
    }

    /**
     * NavigationPageManager constructor.
     */
    private NavigationPageManager() {
        LOG.debug("Instance created");
        navPage = new HashMap<>();
        setup();
    }

    /**
     * getInstance method.
     * 
     * @return the instance of the nav page.
     */
    public static NavigationPageManager getInstance() {
        return INSTANCE;
    }

    /**
     * setup method.
     */
    private void setup() {
        navPage.put(NAVKEY, new NavigationPage());
    }

    /**
     * getNavPage method.
     * 
     * @return the nav page.
     */
    public NavigationPage getNavPage() {
        return navPage.get(NAVKEY);
    }
}
