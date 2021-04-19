package user;

import size.Size;

/**
* Hard coded singleton user
* TODO move to database users. Probably not though
*/
public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userFName;
    private String userLName;
    private String userEmail;
    private String userAddress;
    private Size userSize;
    private static User user = null;

    /**
     * Private constructor and initializes some basic info about the user
     *
     */
    private User() {
        this.userID = "n2uAqFI8z";
        this.userName = "BobSmith123";
        this.userPassword = "password";
        this.userFName = "Bob";
        this.userLName = "Smith";
        this.userEmail = "bobsmith@email.com";
        this.userAddress = "Golden Gate Bridge, San Francisco, CA";
        // -1 so we don't run into actual shoes on a user who has no feet sizing
        this.userSize = new Size(-1,-1, -1);
    }

    /**
     * @return instance of the user and or creates one if there does not exist one
     */
    public static User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
    /**
     * @return user id of user
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Getter for username
     * @return username of user
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Getter for password
     * @return password of user
     */
    public String getUserPassword() {
        return userPassword;
    }
    /**
     * Getter for first name
     * @return first name of user
     */
    public String getUserFName() {
        return userFName;
    }
    /**
     * Getter for last name
     * @return last name of user
     */
    public String getUserLName() {
        return userLName;
    }
    /**
     * Getter for email
     * @return email of user
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**
     * Getter for address
     * @return address of user
     */
    public String getUserAddress() {
        return userAddress;
    }
    /**
     * Getter for size
     * @return size of user
     */
    public Size getUserSize() {
        return userSize;
    }

    /**
     * Nulls the user object
     */
    public void nullUser() {
        user = null;
    }
}
