package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.util.List;

/**
 * @author Jonah Marcus
 *         Code Reviewed by Zoe Beals 4/14/2022
 */
public interface ActiveGame {

    /**
     * @return month
     */
    int getMonth();

    /**
     * @return day
     */
    int getDay();

    /**
     * @return year
     */
    int getYear();

    /**
     * @return gameName
     */
    String getName();

    /**
     * @return list of players
     */
    List<String> getPlayers();

    /**
     * @return completed
     */
    boolean isCompleted();

    /**
     * Formats an array of Strings to provide information for the
     * PastGamesPage to display. The array contains, in order,
     * YYYYMMDD timestamp, the game's name inputted by user,
     * (YYYYMMDD timestamp if this is empty), the name of the
     * first player, and the name of the second player.
     *
     * @return The array of Strings as specified above.
     */
    String[] getGameInfo();

    /**
     * Throws exception when mm is less than 1 or greater than 12.
     *
     * @param mm
     * @throws IllegalArgumentException
     */
    void setMonth(int mm) throws IllegalArgumentException;

    /**
     * Throws exception when dd is less than 1 or greater than 31.
     *
     * @param dd
     * @throws IllegalArgumentException
     */
    void setDay(int dd) throws IllegalArgumentException;

    /**
     * @param yy
     */
    void setYear(int yy);

    /**
     * @param name
     */
    void setName(String name);

    /**
     * @param player
     *            player to add to list of players
     */
    void addPlayer(String player);

    /**
     * @param player
     *            player to remove from list of players
     */
    void removePlayer(String player);

    /**
     * @param isCompleted
     */
    void setCompletionStatus(boolean isCompleted);
}
