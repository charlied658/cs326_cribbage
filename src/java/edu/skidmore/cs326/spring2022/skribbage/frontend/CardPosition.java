package edu.skidmore.cs326.spring2022.skribbage.frontend;

/**
 * Enum for the different positions that a card can be in.
 */
public enum CardPosition {
    /**
     * DECK - In the deck of cards.
     */
    DECK,

    /**
     * In the hand (2).
     */
    OPPONENT_HAND,

    /**
     * In the hand (1).
     */
    PLAYER_HAND,

    /**
     * In the play.
     */
    IN_PLAY,

    /**
     * In the crib.
     */
    IN_CRIB,
}
