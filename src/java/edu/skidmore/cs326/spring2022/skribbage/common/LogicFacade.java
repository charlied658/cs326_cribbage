package edu.skidmore.cs326.spring2022.skribbage.common;
import org.apache.log4j.Logger;

/**
 * Allow other tiers to access logic methods pertaining to claim checks, deck
 * cutting, etc.
 * 
 * @author Declan Morris
 */
public class LogicFacade {
    
    /**
     * Logger instance.
     */
    private static final Logger LOG;
    
    /**
     * Initialization of logger.
     */
    static {
        LOG = Logger.getLogger(LogicFacade.class);
    }
    
    /**
     * The singleton instance of LoginFacade.
     */
    private static LogicFacade instance = null;
    
    /**
     * Constructor should not be accessible to any external paries.
     */
    private LogicFacade() {
        
    }
    
    /**
     * Allows other tiers to access instance.
     * @return instance
     */
    public static LogicFacade getInstance() {
        if (instance == null) {
            LOG.trace("Initializing LogicFacade instance.");
            instance = new LogicFacade();
        }
        return instance;
    }
    
    // Communicate with Logic team to add methods needed.

}
