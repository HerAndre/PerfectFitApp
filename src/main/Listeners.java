package main;

import shoes.Shoe;
import shoes.ShoeDatabase;
import size.Size;
import user.User;
import utlities.App;
import utlities.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;

/**
* Contains all the logic for the application.
* Contains all the button listeners. The buttons drive the application
* Contains instance of the PerfectFitMain
*/
public class Listeners {

    private final PerfectFitMain main;

    /**
     * Constructor for Listeners
     * @param main the main instance containing all the form objects
     */
    public Listeners(PerfectFitMain main) {
        this.main = main;
    }

    /**
     * Initialized all types of listeners
     */
    public void initListeners() {
        initButtonListeners();
        initComponentListeners();
        initWindowListeners();
    }

    /**
     * Initializes all window listeners.
     * Currently has one listener and it handled the window closing
     */
    private void initWindowListeners() {
        main.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                main.onCancel();
            }
        });
    }
    /**
     * Initializes all component listeners.
     */
    private void initComponentListeners() {

        main.home.addComponentListener(new ComponentAdapter() {
            /**
             * Hides the back button if the home page is displayed
             * Invoked when the component has been made visible.
             *
             * @param e The event making the method run
             */
            @Override
            public void componentShown(ComponentEvent e) {
                main.backButton.setVisible(false);
                main.revalidate();
                super.componentShown(e);
            }
        });

        main.home.addComponentListener(new ComponentAdapter() {
            /**
             * Displays the back button if the home page is displayed
             * Invoked when the component has been made invisible.
             *
             * @param e The event making the method run
             */
            @Override
            public void componentHidden(ComponentEvent e) {
                main.backButton.setVisible(true);
                main.revalidate();
                super.componentHidden(e);
            }
        });
    }

    /**
     * Initializes all button listeners.
     */
    private void initButtonListeners() {
        main.loginButton.addActionListener(new ActionListener() {
            /**
             * Displays the login screen
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.contentCard.show(main.contentBody, "login");
                main.currentPanelName = "login";
                main.pack();
            }
        });

        main.registerButton.addActionListener(new ActionListener() {
            /**
             * Displays the register screen
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.contentCard.show(main.contentBody, "register");
                main.currentPanelName = "register";
                main.pack();
            }
        });

        main.aboutUsButton.addActionListener(new ActionListener() {
            /**
             * Displays the about us page
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.contentCard.show(main.contentBody, "aboutUs");
                main.currentPanelName = "aboutUs";
                main.pack();
            }
        });

        main.appViewProfileButton.addActionListener(new ActionListener() {
            /**
             * Displays the profile page
             * Populates the text areas within the profile page with the user's data
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appProfile");
                main.currentPanelName = "appProfile";
                App.populateUserForms(new JTextArea[] {
                        main.profileUsernameText,
                        main.profileNameText,
                        main.profileAddressText,
                        main.profileEmailText
                });
                main.pack();
            }
        });

        main.loginSubmitButton.addActionListener(new ActionListener() {
            /**
             * Attempts to login using the text fields displayed on the application
             * Validates whether the login information is valid
             * Changes the application screen if the validation is successful
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Object user = Login.authenticate(main.loginUsername.getText(), main.loginPassword.getPassword());
                // Clear text fields    
//                main.loginUsername.setText("");
                main.loginPassword.setText("");

                if (user != null) {
                    main.contentCard.show(main.contentBody, "app");
                    main.currentPanelName = "appHome";
                    App.populateUserForms(new JTextArea[] {main.appUserNameText});
                } // TODO display login error
                main.pack();
            }
        });

        main.backButton.addActionListener(new ActionListener() {
            /**
             * Uses a helper function to navigate backwards in the application
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton(main.currentPanelName);
            }
        });

        main.appRequestSocksButton.addActionListener(new ActionListener() {
            /**
             * Displays the sock request page
             * Populates the text areas within the sock request page with the user's data
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appSocks");
                main.currentPanelName = "appSocks";
                App.populateUserForms(new JTextArea[] {
                        main.socksAddressText
                });
            }
        });
        main.appFootScanButton.addActionListener(new ActionListener() {
            /**
             * Displays the scan page
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appScan");
                main.currentPanelName = "appScan";
            }
        });

        main.scanManualButton.addActionListener(new ActionListener() {
            /**
             * Displays manual scan page (where the user inputs their own size values)
             * Populates the fields with the user's size
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appScanManual");
                main.currentPanelName = "appScanManual";
                main.manualLengthText.setText(String.valueOf(User.getUser().getUserSize().getLength()));
                main.manualWidthText.setText(String.valueOf(User.getUser().getUserSize().getWidth()));
                main.manualArchText.setText(String.valueOf(User.getUser().getUserSize().getArch()));
                main.manualResultsText.setText(User.getUser().getUserSize().stringifySize());
            }
        });
        main.scanAutoButton.addActionListener(new ActionListener() {
            /**
             * Displays automatic scan page (where the user scans their foot)
             * Creates a timer that increments the progress bar's values
             * Resets the progress bar when the page is loaded to override any previous changes.
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appScanAuto");
                main.currentPanelName = "appScanAuto";
                main.scanProgressBar.setValue(0);
                main.scanViewShoesButton.setEnabled(false);
                main.scanProgressBar.setForeground(new Color(60, 63, 65));
                main.scanResultsText.setText(User.getUser().getUserSize().stringifySize());
                final int[] value = {main.scanProgressBar.getValue()};

                java.util.Timer timer = new java.util.Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!main.currentPanelName.equals("appScanAuto")) {
                            timer.cancel();
                            timer.purge();
                        }
                        value[0] += 1;
                        main.scanProgressBar.setValue(value[0]);

                        // Bar has reached 100%
                        if (value[0] >= 100) {
                            main.scanProgressBar.setForeground(new Color(55, 163, 0));
                            main.scanProgressBar.setString("Scan Complete");
                            main.scanViewShoesButton.setEnabled(true);

                            // Generate a random size for the user
                            User.getUser().getUserSize()
                                .setArch(new Random().nextInt(4))
                                .setLength(new Random().nextInt(11))
                                .setWidth(new Random().nextInt(11));

                            // Outputs results to the scan result text area
                            main.scanResultsText.setText(User.getUser().getUserSize().stringifySize());

                            // Stops timer
                            timer.cancel();
                            timer.purge();
                        }
                    }
                }, 0, 20);
            }
        });
        main.scanSubmitButton.addActionListener(new ActionListener() {
            /**
             * Attempts to submit using the text fields displayed on the application
             * Populates the user's size with the new values if values are integer castable
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                // Set user's size based on the text inputs on the manual input page
                // Errors if the inputs are not castable to ints
                try {
                    User.getUser().getUserSize()
                            .setWidth(Integer.parseInt(main.manualWidthText.getText()))
                            .setLength(Integer.parseInt(main.manualLengthText.getText()))
                            .setArch(Integer.parseInt(main.manualArchText.getText()));

                    // Outputs results to the scan result text area
                    main.manualResultsText.setText(User.getUser().getUserSize().stringifySize());

                } catch (Error ignored) {
                    // TODO display error
                }
            }
        });

        main.appViewShoesButton.addActionListener(new ActionListener() {
            /**
             * Displays shoes page
             * Failfast if the user's size is unset
             * Clears any previous selections made on the list and populates the list with shoes that match the size of the user
             * Clicking on any shoe on the list will narrow down to the shoe, displaying the shoe view page
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // If size isn't set yet don't continue.
                if (User.getUser().getUserSize().isEqual(new Size(-1, -1, -1))) return;

                main.shoesShoeList.clearSelection();
                main.appCard.show(main.appBody, "appShoes");
                main.currentPanelName = "appShoes";
                // Populate a listModel with shoes that match
                DefaultListModel<String> listModel = new DefaultListModel<>();
                ShoeDatabase.getInstance().getShoeDataTable().forEach(shoe -> {
                    if (shoe.getSize().isEqual(User.getUser().getUserSize())) {
                        listModel.addElement(shoe.stringifyShoe());
                    }
                });
                // Set the listModel onto the shoeList
                main.shoesShoeList.setModel(listModel);
                main.pack();
                main.shoesShoeList.addListSelectionListener(event -> {
                    DefaultListModel<String> shoeModel = new DefaultListModel<>();
                    String selectedValue = (String) main.shoesShoeList.getSelectedValue();
                    shoeModel.addElement(selectedValue);
                    main.appCard.show(main.appBody, "appShoesView");
                    main.currentPanelName = "appShoesView";
                    main.shoesViewList.setModel(shoeModel);
                });
            }
        });
        main.scanViewShoesButton.addActionListener(new ActionListener() {
            /**
             * Displays shoes page
             * Failfast if the user's size is unset
             * Clears any previous selections made on the list and populates the list with shoes that match the size of the user
             * Clicking on any shoe on the list will narrow down to the shoe, displaying the shoe view page
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // If size isn't set yet don't continue.
                if (User.getUser().getUserSize().isEqual(new Size(-1, -1, -1))) return;

                main.shoesShoeList.clearSelection();
                main.appCard.show(main.appBody, "appShoes");
                main.currentPanelName = "appShoes";
                // Populate a listModel with shoes that match
                DefaultListModel<String> listModel = new DefaultListModel<>();
                ShoeDatabase.getInstance().getShoeDataTable().forEach(shoe -> {
                    if (shoe.getSize().isEqual(User.getUser().getUserSize())) {
                        listModel.addElement(shoe.stringifyShoe());
                    }
                });
                // Set the listModel onto the shoeList
                main.shoesShoeList.setModel(listModel);
                main.pack();
                main.shoesShoeList.addListSelectionListener(event -> {
                    DefaultListModel<String> shoeModel = new DefaultListModel<>();
                    String selectedValue = (String) main.shoesShoeList.getSelectedValue();
                    shoeModel.addElement(selectedValue);
                    main.appCard.show(main.appBody, "appShoesView");
                    main.currentPanelName = "appShoesView";
                    main.shoesViewList.setModel(shoeModel);
                });
            }
        });
    }
    /**
    * Hardcoded checks to determine previous page in application
    * Could do a stack containing the paths, and pop the stack when the user hits back
    */
    private void backButton(String currentPanelName) {
        switch (currentPanelName) {
            case "aboutUs":
            case "register":
            case "login":
                main.contentCard.show(main.contentBody, "home");
                main.currentPanelName = "home";
                break;
            case "appHome":
                main.contentCard.show(main.contentBody, "login");
                main.currentPanelName = "login";
                break;
            case "appProfile":
            case "appSocks":
            case "appShoes":
            case "appScan":
                main.appCard.show(main.appBody, "appHome");
                main.currentPanelName = "appHome";
                break;
            case "appShoesView":
                main.appCard.show(main.appBody, "appShoes");
                main.currentPanelName = "appShoes";
                break;
            case "appScanAuto":
            case "appScanManual":
                main.appCard.show(main.appBody, "appScan");
                main.currentPanelName = "appScan";
                break;
            default:
                break;
        }
        // Resize frame to fit content bc we might've switched the content.
        main.pack();
    }
}
