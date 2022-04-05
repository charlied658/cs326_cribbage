package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * @author Jonah Marcus
 *         CODEREVIEW BY STEN
 *         in set player1 and play2 methods, you seem to have it the wrong way.
 *         Instead of assigning player1 value to the parameter you take in, you
 *         should
 *         assign that parameter value to player1.
 *         I added javadoc comment sections for you to write out.
 *         I created a logger for this class so you can add logging to different
 *         sections.
 *         I left few examples.
 *         Dates can be handled better. I think the month, day, year separetly
 *         is a dedious thing to do,
 *         we should be able to use dateStamp package or some built in java
 *         methods.
 */
public class PlayableGame implements ActiveGame {
    /**
     * 
     */
    private int month = 0;

    /**
     * 
     */
    private int day = 0;

    /**
     * 
     */
    private int year = 0;

    /**
     * 
     */
    private String[] months =
        { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec" };

    /**
     * 
     */
    private String gameName = ""; // Name of the game specified by user. If no
                                  // name is
    // specified, name is YYYYMMDD timestamp.

    /**
     * 
     */
    private String player1 = ""; // Name of player 1

    /**
     * 
     */
    private String player2 = ""; // Name of player 2

    /**
     * 
     */
    private boolean completed = false; // Tracks whether or not game has been
                                       // completed.
    // Important for formatting PastGamesPage
    // (incomplete games must be on top)

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PlayableGame.class);
    }

    /**
     * @param day
     * @param month
     * @param year
     * @param p1
     * @param p2
     * @param game
     * @param completed
     */
    public PlayableGame(int month, int day, int year, String p1, String p2,
        String game, boolean completed) {
        LOG.trace("Constructor of PlayableGame reached");
        setDay(day);
        setMonth(month);
        setYear(year);
        setPlayer1(p1);
        setPlayer2(p2);
        setName(game);
        setCompletionStatus(completed);
    }

    /**
     * @return month
     */
    public int getMonth() {
        LOG.trace("Returning the integer value of month");
        return month;
    }

    /**
     * @return day
     */
    public int getDay() {
        LOG.trace("Returning the integer value of day");
        return day;
    }

    /**
     * @return year
     */
    public int getYear() {
        LOG.trace("Returning the integer value of year");
        return year;
    }

    /**
     * @return gameName
     */
    public String getName() {
        LOG.trace("Returning the given name of the game as a String");
        return gameName;
    }

    /**
     * @return player1
     */
    public String getPlayer1() {
        LOG.trace("Returning the name of player 1 as a String");
        return player1;
    }

    /**
     * @return player2
     */
    public String getPlayer2() {
        LOG.trace("Returning the name of player 2 as a String");
        return player2;
    }

    /**
     * @return completed
     */
    public boolean isCompleted() {
        LOG.trace("Returning the boolean value indicating whether or "
            + "not a game is completed");
        return completed;
    }

    /**
     * Formats an array of Strings to provide information for the
     * PastGamesPage to display. The array contains, in order,
     * YYYYMMDD timestamp, the game's name inputted by user,
     * (YYYYMMDD timestamp if this is empty), the name of the
     * first player, and the name of the second player.
     * 
     * @return The array of Strings as specified above.
     */
    public String[] getGameInfo() {
        String[] toReturn = new String[4];
        

        return toReturn;
    }

    /**
     * Throws exception when mm is less than 1 or greater than 12.
     * 
     * @param mm
     * @throws IllegalArgumentException
     */
    public void setMonth(int mm) throws IllegalArgumentException {
        if (mm < 1 || mm > 12) {
            LOG.warn("Month value is illegal, throwing an error");
            throw new IllegalArgumentException(
                "Month cannot be less than 1 or greater than 12.");

        } else {
            month = mm;
        }
    }

    /**
     * Throws exception when dd is less than 1 or greater than 31.
     * 
     * @param dd
     * @throws IllegalArgumentException
     */
    public void setDay(int dd) throws IllegalArgumentException {
        if (dd < 1 || dd > 31) {
            throw new IllegalArgumentException(
                "Day cannot be less than 1 or greater than 31.");
        } else {
            day = dd;
        }
    }

    /**
     * @param yy
     */
    public void setYear(int yy) {
        year = yy;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        gameName = name;
    }

    /**
     * @param p1
     */
    public void setPlayer1(String p1) {
        player1 = p1;
    }

    /**
     * @param p2
     */
    public void setPlayer2(String p2) {
        player2 = p2;
    }

    /**
     * @param isCompleted
     */
    public void setCompletionStatus(boolean isCompleted) {
        completed = isCompleted;
    }

    /**
     * toString method.
     * 
     * @return string rep.
     */
    public String convertToString() {
        return player1 + " vs " + player2 + " on " + day + "\\" + month
            + "\\ " + year;
    }

}
