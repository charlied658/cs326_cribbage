package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Manager for rules page.
 * 
 * @author Zoe Beals
 */
public class RulesPageManager {

    /**
     * logger.
     */
    private static final Logger LOG;

    /**
     * singleton instance of this class.
     */
    private static final RulesPageManager INSTANCE;

    /**
     * key for the rules page.
     */
    private static final String RULESKEY;

    /**
     * rules page being managed - only one.
     */
    private HashMap<String, RulesPage> rulesPage;

    static {
        LOG = Logger.getLogger(RulesPageManager.class);
        RULESKEY = "RulesPage";
        INSTANCE = new RulesPageManager();
    }

    /**
     * Constructor.
     */
    private RulesPageManager() {
        LOG.debug("Instance created");
        rulesPage = new HashMap<>();
        setup();
    }

    /**
     * getInstance method.
     * 
     * @return the instance of the rules page
     */
    public static RulesPageManager getInstance() {
        return INSTANCE;
    }

    /**
     * sets up the rules page.
     */
    private void setup() {
        rulesPage.put(RULESKEY, new RulesPage());
    }

    /**
     * getLoginPage method.
     * 
     * @return the rules page.
     */
    public RulesPage getRulesPage() {
        return rulesPage.get(RULESKEY);
    }

}
