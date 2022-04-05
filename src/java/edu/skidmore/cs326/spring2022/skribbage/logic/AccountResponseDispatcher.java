//package edu.skidmore.cs326.spring2022.skribbage.logic;
//
//import java.beans.PropertyChangeEvent;
//
//import edu.skidmore.cs326.spring2022.skribbage.common.EventDispatcher;
//import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
//import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
//import edu.skidmore.cs326.spring2022.skribbage.common.User;
//
///**
// * The method for responding to events is still up in the air. It would be
// * simple to fire events directly from the controller that caught the
// * incoming events, however that could potentially break SRP.
// * 
// * @author Declan Morris & Alex Carney
// */
//public class AccountResponseDispatcher implements EventDispatcher {
//
//    private final EventManager eventManager;
//
//    public AccountResponseDispatcher() {
//        eventManager = EventManager.getInstance();
//
//    }
//
//    public void accountEventResponseFactory(EventType eventType, User user,
//        boolean success, String responseMessage) {
//        PropertyChangeEvent eventToFire;
//        switch (eventType) {
//            case USER_LOGIN_RESPONSE:
//                eventToFire = new UserLoginResponseEvent(null, eventType, user,
//                    success, responseMessage);
//                break;
//
//            default:
//                throw new IllegalStateException(
//                    "Unexpected value: " + eventType);
//        }
//        fireEvent(eventToFire);
//    }
//
//    @Override
//    public void fireEvent(PropertyChangeEvent event) {
//        eventManager.notify(event);
//    }
//}