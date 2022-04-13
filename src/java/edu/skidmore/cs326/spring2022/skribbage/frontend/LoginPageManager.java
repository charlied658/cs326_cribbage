package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Manages login page instances. Singleton class.
 * @author Zoe Beals
 *
 */
public class LoginPageManager {
    
    /**
     * logger.
     */
    private static final Logger LOG;
    
    /**
     * singleton instance of this class.
     */
    private static final LoginPageManager INSTANCE;
    
    /**
     * key for the login page.
     */
    private static final String LOGINKEY;
    
    /**
     * login page being managed - only one.
     */
    private HashMap<String, LoginPage> loginPage;
    
    static {
        LOG = Logger.getLogger(LoginPageManager.class);
        LOGINKEY = "LoginPage";
        INSTANCE = new LoginPageManager();
    }
    
    /**
     * Constructor.
     */
    private LoginPageManager() {
        LOG.debug("Instance created");
        loginPage = new HashMap<>();
        setup();
    }
    
    /**
     * getInstance method.
     * @return the instance of the login page
     */
    public static LoginPageManager getInstance() {
        return INSTANCE;
    }
    
    /**
     * sets up the login page.
     */
    private void setup() {
        loginPage.put(LOGINKEY, new LoginPage());
    }
    
    /**
     * getLoginPage method.
     * @return the login page.
     */
    public LoginPage getLoginPage() {
        return loginPage.get(LOGINKEY);
    }
}
