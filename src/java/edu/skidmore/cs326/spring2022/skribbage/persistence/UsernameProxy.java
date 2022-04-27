package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.ArrayList;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * username proxy.
 * 
 * @author Tinaye Mawocha
 *         =======
 * @author Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
 */
public class UsernameProxy {

    /**
     * file name.
     */
    @SuppressWarnings("unused")
    private static final String PROPERTY_FILE_NAME = "database.properties";

    /**
     * instance.
     */
    private static final UsernameProxy INSTANCE;

    /**
     * banned words.
     */
    private static final int AMOUNT_OF_BANNED_WORDS = 451;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UsernameProxy.class);
    }

    static {
        INSTANCE = new UsernameProxy();
    }

    /**
     * getInstance.
     * 
     * @return instance.
     */
    public static UsernameProxy getInstance() {
        return INSTANCE;
    }

    /**
     * username check.
     * 
     * @param username
     * @return bool.
     */
    public boolean usernameCheck(String username) {
        String currentDir = System.getProperty("user.dir");

        Boolean usernameIsGood = true;
        FileInputStream file = null;
        Properties prop = null;
        String filePath =
            currentDir + "/src/java/edu/skidmore/cs326/spring2022/"
                + "skribbage/persistence/badnicknames.properties";
        try {

            file = new FileInputStream(filePath);
            prop = new Properties();

            prop.load(file);
            // get the property value and print it out

            for (int i = 1; i <= AMOUNT_OF_BANNED_WORDS; i++) {
                String altProp = "$" + i;

                String tempban = prop.getProperty(altProp);
                tempban = tempban.trim();
                tempban = tempban.toLowerCase();
                username = username.toLowerCase();

                if (username.contains(tempban)) {
                    usernameIsGood = false;
                }
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return usernameIsGood;
        // return true;
    }
}
