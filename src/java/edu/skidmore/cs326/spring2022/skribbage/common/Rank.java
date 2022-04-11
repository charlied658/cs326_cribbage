package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * @author Declan Morris
 */
public enum Rank {

    /**
     * The rank of ace.
     */
    ACE("Ace", "A", 1),
    /**
     * The rank of two.
     */
    TWO("Two", "2", 2),
    /**
     * The rank of three.
     */
    THREE("Three", "3", 3),
    /**
     * The rank of four.
     */
    FOUR("Four", "4", 4),
    /**
     * The rank of five.
     */
    FIVE("Five", "5", 5),
    /**
     * The rank of six.
     */
    SIX("Six", "6", 6),
    /**
     * The rank of seven.
     */
    SEVEN("Seven", "7", 7),
    /**
     * The rank of eight.
     */
    EIGHT("Eight", "8", 8),
    /**
     * The rank of nine.
     */
    NINE("Nine", "9", 9),
    /**
     * The rank of ten.
     */
    TEN("Ten", "10", 10),
    /**
     * The rank of jack.
     */
    JACK("Jack", "J", 10),
    /**
     * The rank of queen.
     */
    QUEEN("Queen", "Q", 10),
    /**
     * The rank of king.
     */
    KING("King", "K", 10);

    /**
     * The name of the rank in plain english.
     */
    private String name;

    /**
     * The symbol representing the rank as it would appear on a physical card.
     */
    private String symbol;

    /**
     * The numerical value added to the center sum during a game of cribbage.
     */
    private int pointValue;

    /**
     * Default constructor for all CardRanks.
     * 
     * @param name
     * @param symbol
     * @param pointValue
     */
    Rank(String name, String symbol, int pointValue) {
        this.name = name;
        this.symbol = symbol;
        this.pointValue = pointValue;
    }

    /**
     * Allows other classes accesses to name of Rank.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Allows other classes access to the Rank's symbol.
     * 
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Allows other classes access to the Rank's point value.
     * 
     * @return pointValue
     */
    public int getPointValue() {
        return pointValue;
    }
}
