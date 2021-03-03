package utlities;

import user.User;

import java.util.Arrays;

/***
* Authenticate user and return user object
* */
public class Login {

    public static User authenticate(String username, char[] password) {
        // TODO Implement actual validation
        User user;
        if (Arrays.equals(password, User.getUser().getUserPassword().toCharArray()) && username.contentEquals(User.getUser().getUserName())) {
            user = User.getUser();
        } else {
            user = null;
        }
        if (DebugMode.DEBUG) {
            // BAD: password lingers in memory when made as a string
            System.out.println("Username: " + username
                    + "\nPassword: " + new String(password)
                    + "\nUser: " + ( (user == null) ? "Invalid User" : user.getUserName())
            );
        }

        return user;
    }

}
