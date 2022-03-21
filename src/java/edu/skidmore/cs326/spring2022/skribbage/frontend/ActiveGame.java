package edu.skidmore.cs326.spring2022.skribbage.frontend;

public interface ActiveGame {
    
    
    /**
     * @return month
     */
    public int getMonth();  
    
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
     * @param p1
     */
    public void setPlayer1(String p1);
    
    /**
     * @param p2
     */
    public void setPlayer2(String p2);
    
    /**
     * @param isCompleted
     */
    public void setCompletionStatus (boolean isCompleted); 
}



   
 
 

  
    
   
    

    

  


   




