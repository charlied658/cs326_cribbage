package edu.skidmore.cs326.spring2022.skribbage.logic.events;

/**
 * Bean to store data such as responseMessage used by response event classes.
 * 
 * @author Declan Morris
 */
public class AccountResponse {

    /**
     * Constructor sets all attributes to given values.
     * 
     * @param responseMessage
     * @param rejectionStatus
     */
    public AccountResponse(String responseMessage, boolean rejectionStatus) {
        this.responseMessage = responseMessage;
        this.rejectionStatus = rejectionStatus;
    }

    /**
     * Message passed along with response event to front end.
     */
    private String responseMessage;

    /**
     * Whether the login attempt was rejected.
     */
    private boolean rejectionStatus;

    /**
     * Allow access to responseMessage to other classes.
     * 
     * @return responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    // /**
    // * Allows other classes to modify responseMessage.
    // * @param responseMessage
    // */
    // public void setResponseMessage(String responseMessage) {
    // this.responseMessage = responseMessage;
    // }

    /**
     * Allow access to rejectionStatus to other classes.
     * 
     * @return rejectionStatus
     */
    public boolean isRejectionStatus() {
        return rejectionStatus;
    }

    // /**
    // * Allows other classes to modify rejectionStatus.
    // * @param rejectionStatus
    // */
    // public void setRejectionStatus(boolean rejectionStatus) {
    // this.rejectionStatus = rejectionStatus;
    // }

}
