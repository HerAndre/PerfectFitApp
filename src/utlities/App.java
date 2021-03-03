package utlities;

import user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class App {

    public static void populateUserForms(JTextArea[] textAreas) {
        User user = User.getUser();
        // Iterate through the array and populate accordingly
        for( JTextArea area : textAreas ) {
            switch (area.getName()) {
                // Either one of the following cases will run the code
                case "appNameText":
                case "profileNameText":
                case "addressNameText":
                    area.setText(user.getUserFName() + " " + user.getUserLName());
                    break;
                case "profileUsernameText":
                case "addressUsernameText":
                    area.setText(user.getUserName());
                    break;
                case "profileAddressText":
                case "addressAddressText":
                    area.setText(user.getUserAddress());
                    break;
                case "profileEmailText":
                case "addressEmailText":
                    area.setText(user.getUserEmail());
                    break;
                default:
                    break;
            }

        }
    }
}
