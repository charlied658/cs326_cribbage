//package edu.skidmore.cs326.spring2022.skribbage.logic;
//
//import edu.skidmore.cs326.spring2022.skribbage.common.*;
//
//import java.beans.PropertyChangeEvent;
//
///**
// * @author Declan Morris
// */
//public abstract class AccountResponseEvent extends PropertyChangeEvent {
//
//    /**
//     * Message passed back to front end.
//     */
//    protected String responseMessage;
//
//    /**
//     * Rejection status of event.
//     */
//    protected boolean rejected;
//
//    /**
//     * The user associated with the event.
//     */
//    protected User user;
//
//    /**
//     * The string format of the event name.
//     */
//    private EventType eventType;
//
//    /**
//     * Getter for rejected.
//     * @return rejected
//     */
//    public boolean isRejected() {
//        return rejected;
//    }
//
//    /**
//     * Getter for responseMessage.
//     * @return responseMessage
//     */
//    public String getResponseMessage() {
//        return responseMessage;
//    }
//
//    /**
//     * Getter for user.
//     * @return user
//     */
//    public User getUser() {
//        return user;
//    }
//
//    /**
//     * Default Constructor
//     * 
//     * /**
//     * Default constructor.
//     * 
//     * @param source
//     *            The bean that fired the event.
//     * @param eventType
//     *            The string format of the event name.
//     * @param user
//     *            The user who is associated with this event.
//     * @param rejectionStatus
//     *            Whether the user's request has been rejected.
//     * @param responseMessage
//     *            The message passed to front end
//     */
//    public AccountResponseEvent(Object source, EventType eventType, User user,
//        boolean rejectionStatus, String responseMessage) {
//        super(source, eventType.toString(), null, null);
//        this.user = user;
//        this.rejected = rejectionStatus;
//        this.responseMessage = responseMessage;
//    }
//}
