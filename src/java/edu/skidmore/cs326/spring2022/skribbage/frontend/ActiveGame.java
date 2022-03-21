package edu.skidmore.cs326.spring2022.skribbage.frontend;

public interface ActiveGame {
    int month = 0;
    int day = 0;
    int year = 0;
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String gameName = ""; //Name of the game specified by user. If no name is specified, name is YYYYMMDD timestamp.
    String player1 = ""; //Name of player 1
    String player2 = ""; //Name of player 2
    boolean completed = false; //Tracks whether or not game has been completed. Important for formatting PastGamesPage (incomplete games must be on top)
    
    /**
     * @return month
     */
    public String getMonth();  
    
    /**
     * @return day
     */
    public int getDay();
    
    /**
     * @return year
     */
    public int getYear();
    
    /**
     * @return gameName
     */
    public String getName();
    
    /**
     * @return player1
     */
    public String getPlayer1();
    
    /**
     * @return player2
     */
    public String getPlayer2();
    
    /**
     * @return completed
     */
    public boolean isCompleted ();
    
    /**
     * Formats an array of Strings to provide information for the 
     * PastGamesPage to display. The array contains, in order,
     * YYYYMMDD timestamp, the game's name inputted by user,
     * (YYYYMMDD timestamp if this is empty), the name of the
     * first player, and the name of the second player.
     * @return The array of Strings as specified above.
     */
    public String[] getGameInfo();
    
    /**
     * Throws exception when mm is less than 1 or greater than 12.
     * @param mm
     * @throws IllegalArgumentException
     */
    public void setMonth(int mm) throws IllegalArgumentException;
    
    /**
     * Throws exception when dd is less than 1 or greater than 31.
     * @param dd
     * @throws IllegalArgumentException
     */
    public void setDay(int dd) throws IllegalArgumentException;
    
    /**
     * @param yy
     */
    public void setYear(int yy);
    
    /**
     * @param name
     */
    public void setName(String name);
    
    /**
     * @param player1
     */
    public void setPlayer1(String player1);
    
    /**
     * @param player2
     */
    public void setPlayer2(String player2);
    
    /**
     * @param isCompleted
     */
    public void setCompletionStatus (boolean isCompleted); 
}

/***
 * Creates a game to be displayed on the PastGamesPage.
 * 
 * @author Jonah Marcus
 *         Last Edit: March 11 2022
 *         Documentation: Sten Leinasaar
 *         Reviewed: Sten Leinasaar
 * @TODO Variables MM, DD, YY need to be renamed.
 * 
 *       Refactoring of the code is needed.
 *       
 *       IF setDay and year and methods are present then they should
 *       be used to initilize the variables from constructor.   --->  DONE 
 *       Hence: Call the methods from the constructor.
 */

public class ActiveGame {
    /**
     * Private integer value of a month.
     */
    private int MM;

    /**
     * Private integer value for a day.
     */
    private int DD;

    /**
     * Private integer value for year.
     */
    private int YY;

    /**
     * 
     */
    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
        "Aug", "Sep", "Oct", "Nov", "Dec" };

    /**
     * 
     */
    private String gameName = "";

    /**
     * 
     */
    private String p1 = "";

    /**
     * 
     */
    private String p2 = "";

    /**
     * 
     */
    private boolean completed;

    /**
     * @param month
     * @param day
     * @param year
     * @param player1
     * @param player2
     * @param name
     * @param completionStatus
     */
    public ActiveGame(int month, int day, int year, String player1,
        String player2, String name, boolean completionStatus) {
        setDay(day);
        setMonth(month);
        setYear(year);
        setGameName(name);
        setPlayer1(player1);
        setPlayer2(player2);
        setCompletionStatus(completionStatus);
    }

    /**
     * @param dd
     * @throws IllegalArgumentException
     */
    public void setDay(int dd) throws IllegalArgumentException {
        if (dd < 1 || dd > 31) {
            throw new IllegalArgumentException(
                "Day cannot be less than 1 or greater than 31.");
        } else {
            DD = dd;
        }

    }

    /**
     * @param mm
     * @throws IllegalArgumentException
     */
    public void setMonth(int mm) throws IllegalArgumentException {
        if (mm < 1 || mm > 12) {
            throw new IllegalArgumentException(
                "Month cannot be less than 1 or greater than 12.");
        } else {
            MM = mm;
        }

    }

    /**
     * @param yy
     * @throws IllegalArgumentException
     */
    public void setYear(int yy) throws IllegalArgumentException {
        YY = yy;
    }

    /**
     * @param name
     */
    public void setGameName(String name) {
        gameName = name;
    }

    /**
     * @param player1
     */
    public void setPlayer1(String player1) {
        p1 = player1;
    }

    /**
     * @param player2
     */
    public void setPlayer2(String player2) {
        p2 = player2;
    }

    /**
     * @param isCompleted
     */
    public void setCompletionStatus(boolean isCompleted) {
        completed = isCompleted;
    }

    /**
     * This method returns the string value of a month.
     * 
     * @return A month value of type String.
     */
    public String getMonth() {
        return months[MM - 1];
    }

    /**
     * This method returns the value of a day of type Integer.
     * 
     * @return A day value of type integer.
     */
    public int getDay() {
        return DD;
    }

    /**
     * @return A year value of type integer.
     */
    public int getYear() {
        return YY;
    }

    /**
     * @return a name of the game of type String.
     */
    public String getName() {
        return gameName;
    }

    /**
     * @return A player1 of type String.
     */
    public String getPlayer1() {
        return p1;
    }

    /**
     * @return A player2 of type String.
     */
    public String getPlayer2() {
        return p2;
    }

    /**
     * @return The date as a type String.
     */
    public String getDate() {
        String month = months[MM - 1];
        String day = "" + DD;
        String year = "" + YY;

        return month + " " + day + " " + year;
    }

    /**
     * @return the comp[etion status of a game in the type of boolean.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * @return game info in a type of array of strings.
     */
    public String[] getGameInfo() {
        String year = "" + YY;
        String month = "";
        String day = "";
        String nameOfGame = "";
        if (MM < 10) {
            month = "0" + MM;
        } else {
            month = "" + MM;
        }

        if (DD < 10) {
            day = "0" + DD;
        } else {
            day = "" + DD;
        }
        if (gameName.equalsIgnoreCase("")) {
            nameOfGame = year + month + day;
        } else {
            nameOfGame = gameName;
        }
        String[] toReturn = { year + month + day, nameOfGame, p1, p2 };
        return toReturn;
    }

}
>>>>>>> 9c862aa5a073955ecefdfebeacc0b0caff944441
