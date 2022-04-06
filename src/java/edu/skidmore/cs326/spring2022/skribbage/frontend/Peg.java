package edu.skidmore.cs326.spring2022.skribbage.frontend;

/**
 * An object that represents an individual peg on the Skribbage board.
 * @author Jonah Marcus
 *         Last Updated April 6 2022
 *
 */
public interface Peg {
    PegType role;
    Spot spot;
    Player owner;
    

    PegType getRole();
}