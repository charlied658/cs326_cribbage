package edu.skidmore.cs326.spring2022.skribbage.frontend;

/**
 * @author Jonah Marcus
 *         Code Reviewed by Zoe Beals 3/24/2022
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
     * @return player1
     */
    String getPlayer1();

    /**
     * @return player2
     */
    String getPlayer2();

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
     * @param p1
     */
    void setPlayer1(String p1);

    /**
     * @param p2
     */
    void setPlayer2(String p2);

    /**
     * @param isCompleted
     */
    void setCompletionStatus(boolean isCompleted);
}
