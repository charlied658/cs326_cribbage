package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * Database properties class.
 * 
 * @author ??
 *         Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
 */
public class DatabaseProperties {

    /**
     * fill in.
     */
    private static final String PROPERTY_FILE_NAME = "database.properties";

    /**
     * fill in.
     */
    private Properties properties;

    /**
     * fill in.
     */
    private static final DatabaseProperties INSTANCE;

    static {
        INSTANCE = new DatabaseProperties();
    }

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(DatabaseProperties.class);
    }

    /**
     * fill in.
     * 
     * @return instance.
     */
    public static DatabaseProperties getInstance() {
        return INSTANCE;
    }

    /**
     * fill in.
     * 
     * @param key
     * @return key
     */
    public String getValue(String key) {

        return (String) properties.get(key);

    }

    /**
     * constructor.
     */
    private DatabaseProperties() {

        InputStream in =
            this.getClass().getResourceAsStream(PROPERTY_FILE_NAME);
        properties = new Properties();
        try {
            properties.load(in);
        }
        catch (Throwable e) {
            // e.printStackTrace();
            LOG.error(e);
        }

    }

}
