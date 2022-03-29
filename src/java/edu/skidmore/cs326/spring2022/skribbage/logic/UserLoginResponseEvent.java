//package edu.skidmore.cs326.spring2022.skribbage.logic;
//
//import edu.skidmore.cs326.spring2022.skribbage.common.*;
//
///**
// * @author Declan Morris
// */
//public class UserLoginResponseEvent extends AccountResponseEvent {
//
//    /**
//     * Event type.
//     */
//    private EventType eventType;
//
//    /**
//     * Getter for user.
//     * 
//     * @return the user
//     */
//    public User getUser() {
//        return user;
//    }
//
//    /**
//     * Default constructor.
//     * 
//     * @param source
//     *            The bean that fired the event.
//     * @param eventType
//     *            The string format of the event name.
//     * @param user
//     *            The user who is associated with this event.
//     * @param rejected
//     *            Whether the user's request has been rejected.
//     * @param responseMessage
//     *            The message passed to front end
//     */
//    public UserLoginResponseEvent(Object source, EventType eventType,
//        User user, boolean rejected,
//        String responseMessage) {
//        super(source, eventType, user, rejected, responseMessage);
//    }
//}
