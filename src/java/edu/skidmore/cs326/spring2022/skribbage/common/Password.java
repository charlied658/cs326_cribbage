package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * A simple bean that represents a password object. Contains the raw
 * string of the password (which may or not be hashed), along with
 * the salt required to generate the hashed password
 */
public class Password implements Payload {
    /**
     * Represents the string password. May or may not be hashed
     */
    private String passwordValue;

//    /**
//     * Defaults to false when instantiated from the front end. May be set
//     * to true once logic tier hashes incoming password
//     */
//    private boolean isHashed;

    /**
     * The salt required to hash the password.
     */
    private String salt;

    /**
     * Creates a new password object. Only required field is passwordValue,
     * others can be added later
     * 
     * @param passwordValue
     *            The string value of the password
     */
    public Password(String passwordValue) {
        this.passwordValue = passwordValue;
//        isHashed = false;
    }

    /**
     * Returns string password value, may be raw.
     * 
     * @return String password value
     */
    public String getPasswordValue() {
        return passwordValue;
    }

//    /**
//     * Has the string been hashed yet or is it still raw text.
//     * 
//     * @return True: password is hashed.
//     */
//    public boolean isHashed() {
//        return isHashed;
//    }

//    /**
//     * Change the status of this password being hashed or not.
//     * 
//     * @param hashed
//     *            boolean update
//     */
//    public void setHashed(boolean hashed) {
//        isHashed = hashed;
//    }

    /**
     * Update password text. If incoming password is hashed, make sure to
     * update setHashed as well
     * 
     * @param passwordValue
     *            Incoming password
     */
    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    /**
     * Returns salt associated with password. May be null.
     * 
     * @return A potentially null byte array representing a salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets salt associated with password.
     * 
     * @param salt
     *            Salt to set.
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
