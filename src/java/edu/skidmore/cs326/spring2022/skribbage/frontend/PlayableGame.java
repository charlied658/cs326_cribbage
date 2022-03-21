package edu.skidmore.cs326.spring2022.skribbage.frontend;

public class PlayableGame implements ActiveGame{
    
    int month = 0;
    int day = 0;
    int year = 0;
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String gameName = ""; //Name of the game specified by user. If no name is specified, name is YYYYMMDD timestamp.
    String player1 = ""; //Name of player 1
    String player2 = ""; //Name of player 2
    boolean completed = false; //Tracks whether or not game has been completed. Important for formatting PastGamesPage (incomplete games must be on top)
    
    public PlayableGame() {
        
    }
    
    /**
     * @return month
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * @return day
     */
    public int getDay() {
        return day;
    }
    
    /**
     * @return year
     */
    public int getYear() {
        return year;
    }
    
    /**
     * @return gameName
     */
    public String getName() {
        return gameName;
    }
    
    /**
     * @return player1
     */
    public String getPlayer1() {
        return player1;
    }
    
    /**
     * @return player2
     */
    public String getPlayer2() {
        return player2;
    }
    
    /**
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }
    
    /**
     * Formats an array of Strings to provide information for the 
     * PastGamesPage to display. The array contains, in order,
     * YYYYMMDD timestamp, the game's name inputted by user,
     * (YYYYMMDD timestamp if this is empty), the name of the
     * first player, and the name of the second player.
     * @return The array of Strings as specified above.
     */
    public String[] getGameInfo() {
        String[] toReturn = new String[4];
        
        return toReturn;
    }
    
    /**
     * Throws exception when mm is less than 1 or greater than 12.
     * @param mm
     * @throws IllegalArgumentException
     */
    public void setMonth(int mm) throws IllegalArgumentException{
        if(mm < 1 || mm > 12){
            throw new IllegalArgumentException("Month cannot be less than 1 or greater than 12.");
        }
        else {
            month = mm;
        }
    }
    
    /**
     * Throws exception when dd is less than 1 or greater than 31.
     * @param dd
     * @throws IllegalArgumentException
     */
    public void setDay(int dd) throws IllegalArgumentException{
        if (dd < 1 || dd > 31) {
            throw new IllegalArgumentException("Day cannot be less than 1 or greater than 31.");
        }
        else {
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
        p1 = player1;
    }
        
    /**
     * @param p2
     */
    public void setPlayer2(String p2) {
        p2 = player2;
    }
    
    
    /**
     * @param isCompleted
     */
    public void setCompletionStatus(boolean isCompleted) {
        completed = isCompleted;
    }

}
