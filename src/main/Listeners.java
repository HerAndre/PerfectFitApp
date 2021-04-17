package main;

import user.User;
import utlities.App;
import utlities.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;

/*
* Couldn't do extends PerfectFitMain bc it would recreate it and loop
* Also couldn't create the buttons here because PerfectFitMain.form binds them to PerfectFitMain
*/
public class Listeners {


    private final PerfectFitMain main;

    public Listeners(PerfectFitMain main) {
        this.main = main;
    }

    public void initListeners() {
        initButtonListeners();
        initComponentListeners();
        initWindowListeners();

    }

    private void initWindowListeners() {
        main.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                main.onCancel();
            }
        });
    }
    private void initComponentListeners() {
        // Component Listeners
        main.home.addComponentListener(new ComponentAdapter() {
            /**
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

    // Could be rewritten to reduce code redundancy
    private void initButtonListeners() {
        main.loginButton.addActionListener(new ActionListener() {
            /**
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
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appScan");
                main.currentPanelName = "appScan";
                App.populateUserForms(new JTextArea[] {
                        main.socksAddressText
                });
            }
        });
        main.scanManualButton.addActionListener(new ActionListener() {
            /**
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
            }
        });
        main.scanAutoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appScanAuto");
                main.currentPanelName = "appScanAuto";
                main.scanProgressBar.setValue(0);
                main.scanProgressBar.setForeground(new Color(60, 63, 65));
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

                        if (value[0] >= 100) {
                            main.scanProgressBar.setForeground(new Color(55, 163, 0));
                            main.scanProgressBar.setString("Scan Complete");
                            main.scanViewShoesButton.setEnabled(true);

                            // Generate a random size for the user
                            User.getUser().getUserSize()
                                .setArch(new Random().nextInt(3))
                                .setLength(new Random().nextInt(10))
                                .setWidth(new Random().nextInt(10));

                            main.appUserShoeText.setText(User.getUser().getUserSize().stringifySize());

                            timer.cancel();
                            timer.purge();
                        }
                    }
                }, 0, 20);
            }
        });
        main.scanSubmitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                // Set user's size based on the text inputs on the manual input page
                // Errors if the inputs are not ints
                try {
                    User.getUser().getUserSize()
                            .setWidth(Integer.parseInt(main.manualWidthText.getText()))
                            .setLength(Integer.parseInt(main.manualLengthText.getText()))
                            .setArch(Integer.parseInt(main.manualArchText.getText()));

                    main.appUserShoeText.setText(User.getUser().getUserSize().stringifySize());

                } catch (Error ignored) {}

                main.appCard.show(main.appBody, "appHome");
                main.currentPanelName = "appHome";
            }
        });

    }
    /*
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
            case "appScanAuto":
            case "appScanManual":
                main.appCard.show(main.appBody, "appScan");
                main.currentPanelName = "appScan";
            default:
                break;
        }
        // Resize frame to fit content bc we might've switched the content.
        main.pack();
    }
}
