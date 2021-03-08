package user;

import size.Size;

/*
* Hard coded singleton user
* TODO move to database users. Probably not though
*  */
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

    private User() {
        this.userID = "n2uAqFI8z";
        this.userName = "BobSmith123";
        this.userPassword = "password";
        this.userFName = "Bob";
        this.userLName = "Smith";
        this.userEmail = "bobsmith@email.com";
        this.userAddress = "Golden Gate Bridge, San Francisco, CA";
        // -1 so we don't run into actual shoes on a default user
        this.userSize = new Size(-1,-1);
    }

    public static User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserFName() {
        return userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public Size getUserSize() {
        return userSize;
    }

    public void nullUser() {
        user = null;
    }
}
