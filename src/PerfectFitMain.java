import utlities.App;
import utlities.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PerfectFitMain extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JPanel contentBody;
    private JPanel home;
    private JPanel register;
    private JPanel aboutUs;
    private JButton loginButton;
    private JButton registerButton;
    private JButton aboutUsButton;
    private JPanel login;
    private JButton loginBackButton;
    private JPanel loginBody;
    private JPanel loginForm;
    private JPasswordField loginPassword;
    private JTextField loginUsername;
    private JButton loginSubmitButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel app;
    private JPanel appHeader;
    private JTextArea appNameText;
    private JPanel appBody;
    private JButton appBackButton;
    private JPanel appHome;
    private JButton appFootScanButton;
    private JButton appViewShoesButton;
    private JButton appViewProfileButton;
    private JButton appRequestSocksButton;
    private JTextField registerText;
    private JPanel registerBody;
    private JButton registerBackButton;
    private JButton aboutUsBackButton;
    private JPanel aboutUsBody;
    private JTextField aboutUsText;
    private JPanel appProfile;
    private JTextArea profileUsernameText;
    private JTextArea profileAddressText;
    private JTextArea profileEmailText;
    private JTextArea profileNameText;
    private JLabel profileUsernameLabel;
    private JLabel profileNameLabel;
    private JLabel profileAddressLabel;
    private JLabel profileEmailLabel;
    private JPanel contentHeader;
    private JButton backButton;
    private JPanel appSocks;
    private JTextArea socksAddressText;
    private JTextArea socksConfirmText;
    private JButton socksSubmitButton;
    private final CardLayout contentCard = (CardLayout)contentBody.getLayout();
    private final CardLayout appCard = (CardLayout)appBody.getLayout();
    private String currentPanelName;

    public PerfectFitMain() {
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Load keyboard action listeners
        initKeyboardActions();

        // Hide back button on initial load (nothing to back to)
        backButton.setVisible(false);

        // Load button action listeners
        initListeners();
        appRequestSocksButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                appCard.show(appBody, "appSocks");
                setCurrentPanelName("appSocks");
                App.populateUserForms(new JTextArea[] {
                        socksAddressText
                });
            }
        });
    }

    private void backButton(String currentPanelName) {
        switch (currentPanelName) {
            case "aboutUs":
            case "register":
            case "login":
                contentCard.show(contentBody, "home");
                setCurrentPanelName("home");
                break;
            case "appHome":
                contentCard.show(contentBody, "login");
                setCurrentPanelName("login");
                break;
            case "appProfile":
            case "appSocks":
            case "appShoes":
            case "appScan":
                appCard.show(appBody, "appHome");
                setCurrentPanelName("appHome");
                break;
            default:
                break;
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void initKeyboardActions() {
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e ->
                onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initListeners() {

        loginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "login");
                setCurrentPanelName("login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "register");
                setCurrentPanelName("register");
            }
        });

        aboutUsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "aboutUs");
                setCurrentPanelName("aboutUs");
            }
        });

        appViewProfileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                appCard.show(appBody, "appProfile");
                setCurrentPanelName("appProfile");
                App.populateUserForms(new JTextArea[] {
                        profileUsernameText, profileNameText, profileAddressText, profileEmailText
                });

            }
        });

        loginSubmitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Object user = Login.authenticate(loginUsername.getText(), loginPassword.getPassword());
                // Clear text fields
//                loginUsername.setText("");
                loginPassword.setText("");

                if (user != null) {
                    contentCard.show(contentBody, "app");
                    setCurrentPanelName("appHome");
                    App.populateUserForms(new JTextArea[] {appNameText});
                } // TODO display login error
            }
        });

        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton(getCurrentPanelName());
            }
        });

        // Component Listeners
        home.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made visible.
             *
             * @param e The event making the method run
             */
            @Override
            public void componentShown(ComponentEvent e) {
                backButton.setVisible(false);
                PerfectFitMain.super.revalidate();
                super.componentShown(e);
            }
        });

        home.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made invisible.
             *
             * @param e The event making the method run
             */
            @Override
            public void componentHidden(ComponentEvent e) {
                backButton.setVisible(true);
                PerfectFitMain.super.revalidate();
                super.componentHidden(e);
            }
        });
    }

    public String getCurrentPanelName() {
        return currentPanelName;
    }

    public void setCurrentPanelName(String currentPanelName) {
        this.currentPanelName = currentPanelName;
    }

    public static void main(String[] args) {
        PerfectFitMain perfectFitMain = new PerfectFitMain();
        perfectFitMain.pack();
        perfectFitMain.setLocationRelativeTo(null);
        perfectFitMain.setVisible(true);
        System.exit(0);
    }
}
