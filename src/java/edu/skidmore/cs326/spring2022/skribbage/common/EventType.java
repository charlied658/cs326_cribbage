package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * An enum representing all possible events. Whenever a new event type is
 * written, its associated title must be included with this enum.
 *
 * @author Alex Carney
 *
 */
public enum EventType {
    USER_LOGIN,
    USER_LOGIN_HASHED,
    USER_LOGIN_RESPONSE,
    USER_CHANGE_PASSWORD,

}
