package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * A simple bean representing data associated with a User
 *
 * @author Alex Carney
 */
public class User {
    private final String email;
    private final String userName;
    private final String password;
    private final boolean isAuthorized;

    public User(String email, String userName, String password, boolean isAuthorized) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAuthorized = isAuthorized;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}
