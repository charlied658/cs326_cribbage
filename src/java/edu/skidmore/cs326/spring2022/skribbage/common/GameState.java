package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Enums containing the possible states of the game.
 * @author cdavidso
 *
 */
public enum GameState {
    
    /**
     * Player needs to click the "Start Game" button.
     */
    START_GAME,
    
    /**
     * Player needs to cut the deck to determine who the dealer is.
     */
    CUT_DECK,
    
    /**
     * Player needs to discard 2 cards to the crib.
     */
    DISCARD_TO_CRIB,
    
    /**
     * Player needs to select a starter card before card play.
     */
    STARTER_CARD,
    
    /**
     * Player needs to play a card to the center of the board.
     */
    PLAY_CARD
    
}