package utlities;

import user.User;

import javax.swing.*;

public class App {

    public static void populateUserForms(JTextArea username, JTextArea name) {
        User user = User.getUser();
        username.setText(user.getUserName());
        name.setText(user.getUserFName()  + " " + user.getUserLName());

    }

}
