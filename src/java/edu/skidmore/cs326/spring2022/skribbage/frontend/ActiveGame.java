package edu.skidmore.cs326.spring2022.skribbage.frontend;

public class ActiveGame {
    private int MM;

    private int DD;

    private int YY;

    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
        "Aug", "Sep", "Oct", "Nov", "Dec" };

    private String gameName = "";

    private String p1 = "";

    private String p2 = "";

    private boolean completed;

    public ActiveGame(int month, int day, int year, String player1,
        String player2, String name) {
        MM = month;
        DD = day;
        YY = year;
        gameName = name;
        p1 = player1;
        p2 = player2;
    }

    public ActiveGame(int month, int day, int year, String player1,
        String player2, String name, boolean completionStatus) {
        MM = month;
        DD = day;
        YY = year;
        gameName = name;
        p1 = player1;
        p2 = player2;
        completed = completionStatus;
    }

    public String getMonth() {
        return months[MM - 1];
    }

    public int getDay() {
        return DD;
    }

    public int getYear() {
        return YY;
    }

    public String getName() {
        return gameName;
    }

    public String getPlayer1() {
        return p1;
    }

    public String getPlayer2() {
        return p2;
    }

    public String getDate() {
        String month = months[MM - 1];
        String day = "" + DD;
        String year = "" + YY;

        return month + " " + day + " " + year;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String[] getGameInfo() {
        String year = "" + YY;
        String month = "";
        if (MM < 10)
            month = "0" + MM;
        else
            month = "" + MM;
        String day = "";
        if (DD < 10)
            day = "0" + DD;
        else
            day = "" + DD;
        String nameOfGame = "";
        if (gameName.equalsIgnoreCase("") == true)
            nameOfGame = year + month + day;
        else
            nameOfGame = gameName;
        String[] toReturn = { year + month + day, nameOfGame, p1, p2 };
        return toReturn;
    }

    public void setMonth(int mm) throws IllegalArgumentException {
        if (mm < 1 || mm > 12)
            throw new IllegalArgumentException(
                "Month cannot be less than 1 or greater than 12.");

        else
            MM = mm;
    }

    public void setDay(int dd) throws IllegalArgumentException {
        if (dd < 1 || dd > 31)
            throw new IllegalArgumentException(
                "Day cannot be less than 1 or greater than 31.");

        else
            DD = dd;
    }

    public void setYear(int yy) throws IllegalArgumentException {
        YY = yy;
    }

    public void setName(String name) {
        gameName = name;
    }

    public void setPlayer1(String player1) {
        p1 = player1;
    }

    public void setPlayer2(String player2) {
        p2 = player2;
    }

    public void setCompletionStatus(boolean isCompleted) {
        completed = isCompleted;
    }

}
