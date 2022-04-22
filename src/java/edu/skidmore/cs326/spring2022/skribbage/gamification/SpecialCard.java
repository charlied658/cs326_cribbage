package edu.skidmore.cs326.spring2022.skribbage.gamification;

/**
 * Special Card Type enum.
 * 
 * @author Muaded Almheiri
 */
public enum SpecialCard {

    /**
     * REBATTLECARD - If special card is a Re-Battle Card.
     */
    REBATTLECARD("Re-Battle Card", 25, "Use this card to get another chance of "
        + "battling the opponent after a battle."),

    /**
     * LASTPLAYERSHOWCARD - If special card is a Last-Player-Show Card.
     */
    LASTPLAYERSHOWCARD("Last-Player-Show Card", 50, "Use this card to affect "
        + "the order of the show."
        + " Choose an opponent whose show will be moved to following"
        + "the last show player. May only be used once during a show "
        + "phase"),

    /**
     * SKIPPLAYERTURNCARD - If special card is a Skip-Player-Show Card.
     */
    SKIPPLAYERTURNCARD("Skip-Player-Turn Card", 100, "Use this card to"
        + "to skip the opponent's next turn. May only use one Skip-Player"
        + "-Turn card per turn. Cannot be used during the show phase."),

    /**
     * THROWAWAYPICKUPCARD - If special card is a Throw-Away-Pickup Card.
     */
    THROWAWAYPICKUPCARD("Throw-Away-Pickup Card", 100, "Pick any player"
        + " to throw one card away and pick up a new one."),

    /**
     * MIRROR - If special card is a mirror card.
     */
    MIRROR("Mirror", 100, "After the show phase has begun, if a card"
        + " is used against you, deflect to an available player of"
        + " your choosing."),

    /**
     * DISARM - If special card is a disarm card.
     */
    DISARM("Disarm", 100,
        "Target a player and prevent them from using any special"
            + " cards."),

    /**
     * PICKPOCKET - If special card is a Pick Pocket card.
     */
    PICKPOCKET("Pick Pocket", 100,
        "Once the show phase has started, pick a player"
            + " to steal a card from. Cannot be used against players with "
            + "one card."),

    /**
     * AUTOPILOT - If special card is a Auto Pilot card.
     */
    AUTOPILOT("Auto Pilot", 100,
        "Target a player who has not played a card yet. Auto"
            + " Pilot would pick a random card and force the player to "
            + "use it."),

    /**
     * COPYCAT - If special card is a Copy Cat card.
     */
    COPYCAT("Copycat", 100, "Copies last card that was placed down.");

    /**
     * Name of Special Card.
     */
    private String type;

    /**
     * Price of Special Card.
     */
    private int price;

    /**
     * Description of Special Card.
     */
    private String description;

    /**
     * Enum constructor that will set type, price, and description.
     * 
     * @param type
     *            Name of Special Card.
     * @param price
     *            Price of Special Card.
     * @param description
     *            Description of Special Card.
     */
    SpecialCard(String type, int price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    /**
     * Getter method to return Special Card name.
     * 
     * @return Name of Special Card.
     */
    public String getType() {
        return type;
    }

    /**
     * Getter method to return Special Card price.
     * 
     * @return Price of Special Card.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter method to return Special Card description.
     * 
     * @return Description of Special Card.
     */
    public String getDescription() {
        return description;
    }

}
