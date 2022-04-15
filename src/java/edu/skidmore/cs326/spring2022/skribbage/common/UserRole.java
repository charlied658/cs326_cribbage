package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Basic enum (no metadata yet) for different roles a user can obtain.
 * 
 * @author Alex Carney
 */
public enum UserRole {
    /**
     * A user that is not logged in yet. Used to package requests to login
     * from the front end down to logic
     */
    UNAUTHORIZED,
    /**
     * A user that is logged in and able to play/start a game.
     */
    AUTHORIZED,
    /**
     * A user that is logged in and has extra admin permissions.
     */
    ADMIN;

    /**
     * Empty constructor, in case extra metadata is added in the future.
     */
    UserRole() {

    }
}
