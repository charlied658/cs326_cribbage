package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {

    private static final String PROPERTY_FILE_NAME = "database.properties";

    private Properties properties;

    private static final DatabaseProperties INSTANCE;

    static {
        INSTANCE = new DatabaseProperties();
    }

    public static DatabaseProperties getInstance() {
        return INSTANCE;
    }

    public String getValue(String key) {

        return (String) properties.get(key);

    }

    private DatabaseProperties() {

        InputStream in =
            this.getClass().getResourceAsStream(PROPERTY_FILE_NAME);
        properties = new Properties();
        try {
            properties.load(in);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
