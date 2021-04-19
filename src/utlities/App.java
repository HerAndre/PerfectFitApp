package utlities;

import user.User;

import javax.swing.*;

/**
 * Helper functions for the application
 */
public class App {

    /**
     * Populates a textArea with specific information based on the case/switch
     * @param textAreas textArea to populate
     */
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
                case "socksAddressText":
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
