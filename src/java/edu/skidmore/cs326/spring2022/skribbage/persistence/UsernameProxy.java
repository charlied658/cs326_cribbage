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
<<<<<<< HEAD
=======
    @SuppressWarnings("unused")
>>>>>>> 6fe32f857ae5344a2b390adab0619d58f4984ff8
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
     * parseString.
     * 
     * @return string.
     */
    @SuppressWarnings("unused")
    private ArrayList<String> parseString() {
        String path = "/students/home/tmawocha/eclipse-workspace/"
            + "SkribbageBattleRoyale/src/java/edu/skidmore"
            + "/cs326/spring2022/skribbage/persistence/BadNicknames";

        File file = new File(path);
        Scanner sc = null;
        String tempbadname = "";
        int lastUsed = 0;

        String pattern = "(\\$)(\\d+).*";
        String emptySpace = "^\\s+(.*)";

        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Pattern emp = Pattern.compile(emptySpace, Pattern.CASE_INSENSITIVE);

        ArrayList<String> toPrint = new ArrayList<String>();

        try {

            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {

            // e.printStackTrace();
            LOG.error(e);
        }

        toPrint.clear();

        while (sc.hasNextLine()) {

            tempbadname = sc.nextLine();

            if (tempbadname.contains("$")) {

                System.out.println(tempbadname);
                Matcher matcher = p.matcher(tempbadname);
                matcher.find();
                lastUsed = Integer.parseInt(matcher.group(2));
                toPrint.add(tempbadname);

            } else {

                Matcher matcher = emp.matcher(tempbadname);

                if (matcher.find()) {
                    tempbadname = matcher.group(1);
                }

                lastUsed += 1;
                String process = "$" + lastUsed + " = " + tempbadname;
                toPrint.add(process);

            }

        }

        return toPrint;
    }

    /**
     * username check.
     * 
     * @param username
     * @return bool.
     */
    public boolean usernameCheck(String username) {

        Boolean usernameIsGood = true;
        FileInputStream file = null;
        Properties prop = null;
        String filePath =
            "/SkribbageBattleRoyale/src/java/edu/skidmore/cs326/spring2022/"
                + "skribbage/persistence/BadNicknames";
        try {

            file = new FileInputStream(filePath);
            prop = new Properties();

            prop.load(file);
            // get the property value and print it out

            for (int i = 1; i <= AMOUNT_OF_BANNED_WORDS; i++) {
                String altProp = "$" + i;

                String tempban = prop.getProperty(altProp);
                tempban = tempban.trim();

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

    /**
     * main.
     * 
     * @param args
     */
    public static void main(String[] args) {

        UsernameProxy instance = new UsernameProxy();

        System.out.println(instance.usernameCheck("naughtynicknam"));
        System.out.println(instance.usernameCheck("fuck"));

    }
}
