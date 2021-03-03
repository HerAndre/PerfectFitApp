package utlities;

import user.User;

import javax.swing.*;

public class App {

    public static void populateUserForms(JTextArea name) {
        User user = User.getUser();
        name.setText(user.getUserFName()  + " " + user.getUserLName());
    }

}
