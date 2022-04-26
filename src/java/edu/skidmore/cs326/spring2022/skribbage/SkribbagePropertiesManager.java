package edu.skidmore.cs326.spring2022.skribbage;

import java.util.Properties;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.User;

/**
 * Manage configurable properties for the Skribbage game. Properties are
 * initially loaded from the properties file.
 * 
 * @author readda
 */
public class SkribbagePropertiesManager implements PropertyAccess {
    /**
     * Serial version id.
     */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    /**
     * The name of the properties file containing the initial program
     * properties.
     */
    private static final String PROPERTY_FILE_NAME = "skribbage.properties";

    /**
     * The Singleton instance.
     */
    private static final SkribbagePropertiesManager INSTANCE;

    /**
     * Logger access.
     */
    private static final Logger LOG;

    /**
     * Application properties.
     */
    private Properties properties;

    /**
     * Setup logger and Singleton instance.
     */
    static {
        LOG = Logger.getLogger(User.class);
        INSTANCE = new SkribbagePropertiesManager();
    }

    /**
     * Create the instance.
     */
    private SkribbagePropertiesManager() {
        setup();
    }

    /**
     * Obtain the Singleton instance.
     * 
     * @return The instance
     */
    public static SkribbagePropertiesManager getInstance() {
        return INSTANCE;
    }

    /**
     * Load the initial properties from the configuration file.
     * 
     * @see #PROPERTY_FILE_NAME
     */
    private void setup() {
        properties = new Properties();
        try {
            properties
                .load(this.getClass().getResourceAsStream(PROPERTY_FILE_NAME));
            LOG.info("Loaded properties. Number of properties found: "
                + properties.keySet().size());
        }
        catch (Throwable t) {
            LOG.error("Unable to load properties file: " + PROPERTY_FILE_NAME,
                t);
        }
    }

    @Override
    public String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    @Override
    public String getProperty(String propertyName, String defaultValue) {
        return properties.getProperty(propertyName, defaultValue);
    }

    @Override
    public int getNumProperties() {
        return properties.keySet().size();
    }

    @Override
    public void setProperty(String propertyName, String value) {
        properties.setProperty(propertyName, value);

    }

}
