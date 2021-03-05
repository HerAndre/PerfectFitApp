package main;

import utlities.App;
import utlities.Login;

import javax.swing.*;
import java.awt.event.*;

// Couldn't do extends PerfectFitMain bc it would recreate it and loop
public class Listeners {

    private PerfectFitMain main;

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
                main.setCurrentPanelName("login");
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
                main.setCurrentPanelName("register");
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
                main.setCurrentPanelName("aboutUs");
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
                main.setCurrentPanelName("appProfile");
                App.populateUserForms(new JTextArea[] {
                        main.profileUsernameText,
                        main.profileNameText,
                        main.profileAddressText,
                        main.profileEmailText
                });

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
                    main.setCurrentPanelName("appHome");
                    App.populateUserForms(new JTextArea[] {main.appNameText});
                } // TODO display login error
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
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                main.appCard.show(main.appBody, "appSocks");
                main.setCurrentPanelName("appSocks");
                App.populateUserForms(new JTextArea[] {
                        main.socksAddressText
                });
            }
        });

    }


    private void backButton(String currentPanelName) {
        switch (currentPanelName) {
            case "aboutUs":
            case "register":
            case "login":
                main.contentCard.show(main.contentBody, "home");
                main.setCurrentPanelName("home");
                break;
            case "appHome":
                main.contentCard.show(main.contentBody, "login");
                main.setCurrentPanelName("login");
                break;
            case "appProfile":
            case "appSocks":
            case "appShoes":
            case "appScan":
                main.appCard.show(main.appBody, "appHome");
                main.setCurrentPanelName("appHome");
                break;
            default:
                break;
        }
    }
}
