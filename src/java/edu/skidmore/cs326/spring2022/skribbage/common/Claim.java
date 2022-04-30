package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * enums for claims made during the pegging phase of the game.
 *
 * @author Michael Shriner.
 */
public enum Claim {

    /** the player is claiming to have brought the pegging total to 15. */
    FIFTEEN,

    /** the player is claiming to have brought the pegging total to 31. */
    THIRTYONE,

    /** the player is claiming to have a pair during pegging phase. */
    PAIR,

    /** the player is claiming to have a 3 pair during pegging phase. */
    THREEPAIR,

    /** the player is claiming to have a 4 pair during pegging phase. */
    FOURPAIR

}
