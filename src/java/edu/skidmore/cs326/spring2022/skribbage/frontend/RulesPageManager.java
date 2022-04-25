package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Manager for rules page.
 * 
 * @author Zoe Beals
 * Code review by Jonah Marcus on 17 April 2022
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
     * @throws FileNotFoundException 
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
     * @throws FileNotFoundException 
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
