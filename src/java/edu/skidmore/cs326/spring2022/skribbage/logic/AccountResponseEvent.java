package edu.skidmore.cs326.spring2022.skribbage.logic;

import edu.skidmore.cs326.spring2022.skribbage.common.*;

import java.beans.PropertyChangeEvent;

/**
 * @author Declan Morris
 */
public class AccountResponseEvent {

    /**
     * TODO: javadoc
     */
    protected String responseMessage;

    /**
     * TODO: javadoc
     */
    protected boolean rejected;

    /**
     * TODO: javadoc
     */
    protected User user;

    /**
     * TODO: javadoc
     */
    private EventType eventType;

    /**
    * Getter for rejected
    */
    public boolean isRejected() {
      return rejected;
    }

    /**
    * Getter for responseMessage
    */
    public String getResponseMessage() {
      return responseMessage;
    }

    /**
    * Getter for user
    */
    public User getUser() {
      return user;
    }

    /**
    * Default Constructor
    * @PARAM all attributes for the class in addition to the source to be responded to.
    */
    public AccountResponseEvent(Object source, EventType eventType, User user, boolean rejectionStatus, String responseMessage) {
      this.eventType = eventType;
      this.user = user;
      this.rejected = rejectionStatus;
      this.responseMessage = responseMessage;
    }
}
