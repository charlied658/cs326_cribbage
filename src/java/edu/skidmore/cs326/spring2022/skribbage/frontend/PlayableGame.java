package edu.skidmore.cs326.spring2022.skribbage.frontend;

//import java.sql.Date;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @author Jonah Marcus
 *         Last modified: 13 April, 2022
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
public class PlayableGame {
    /**
     * dateStamp - Last date of played game.
     */
    private Calendar dateStamp = Calendar.getInstance();
    
    /**
     * gameName - User-specified game name. If no name is specified, name
     * is YYYYMMDD timestamp.
     */
    private String gameName = "";
    
    /**
     * players - Arraylist of players.
     */
    private ArrayList<String> players = new ArrayList<String>();

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
     * @param month
     * @param day
     * @param year
     * @param users
     * @param game
     * @param completed
     */
    public PlayableGame(int year, int month, int day, ArrayList<String> users,
        String game, boolean completed) {
        LOG.trace("Constructor of PlayableGame reached");
        dateStamp.set(Calendar.YEAR, year);
        dateStamp.set(Calendar.MONTH, month);
        dateStamp.set(Calendar.DATE, day);
        players = users;
        setName(game);
        setCompletionStatus(completed);
    }

    /**
     * @return dateStamp
     */
    public Calendar getDate() {
        LOG.trace("getDate() method in PlayableGame.java");
        return dateStamp;
    }

    /**
     * @return gameName
     */
    public String getName() {
        LOG.trace("Returning the given name of the game as a String");
        return gameName;
    }

    /**
     * @return players
     */
    public ArrayList<String> getPlayers() {
        return players;
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
            dateStamp.set(Calendar.MONTH, mm);
        }
    }

    /**
     * Throws exception when dd is less than 1 or greater than 31.
     * 
     * @param dd
     * @throws IllegalArgumentException
     */
    public void setDay(int dd) throws IllegalArgumentException {
        LOG.trace("setDay() method in PlayableGame.java");
        if (dd < 1 || dd > 31) {
            throw new IllegalArgumentException(
                "Day cannot be less than 1 or greater than 31.");
        } else {
            dateStamp.set(Calendar.DATE, dd);
        }
    }

    /**
     * @param yy
     */
    public void setYear(int yy) {
        LOG.trace("setYear() method in PlayableGame.java");
        dateStamp.set(Calendar.YEAR, yy);
    }

    /**
     * @param name
     */
    public void setName(String name) {
        LOG.trace("setName() method in PlayableGame.java");
        gameName = name;
    }

    /**
     * @param player
     * @throws Error - if maximum number of players are already
     * in the game.
     */
    public void addPlayer(String player) throws Error {
        if (players.size() >= 3) {
            throw new Error("Maximum number of players already in game.");
        }
        else {
            players.add(player);
        }
    }
    
    /**
     * @param player
     */
    public void removePlayer(String player) {
        if (players.size() > 0) {
            players.remove(player);   
        }
    }


    /**
     * @param isCompleted
     */
    public void setCompletionStatus(boolean isCompleted) {
        completed = isCompleted;
    }


}
