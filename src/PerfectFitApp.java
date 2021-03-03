import user.User;
import utlities.App;
import utlities.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PerfectFitApp extends JDialog {
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
    private JPanel loginHeader;
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
    private JTextArea nameTextArea;
    private JPanel appBody;
    private JButton logoutButton;
    private JPanel appHome;
    private JButton appFootScanButton;
    private JButton appViewShoesButton;
    private JButton appViewProfileButton;
    private JButton appRequestSocksButton;
    private JTextField registerText;
    private JPanel registerBody;
    private JPanel registerHeader;
    private JButton registerBackButton;
    private JButton aboutUsBackButton;
    private JPanel aboutUsHeader;
    private JPanel aboutUsBody;
    private JTextField aboutUsText;
    private final CardLayout contentCard = (CardLayout)contentBody.getLayout();
    private final CardLayout appCard = (CardLayout)appBody.getLayout();

    public PerfectFitApp() {
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
        // Load button action listeners
        initButtonListeners();
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

    private void initButtonListeners() {
        loginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "login");
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

            }
        });

        /*These back buttons are not the best implementation, too much repeated code.
        * Using an ultimate back button lead to other issues due to CardLayout*/
        loginBackButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "home");
            }
        });
        registerBackButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "home");
            }
        });
        aboutUsBackButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "home");
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
                    App.populateUserForms(nameTextArea);
                } // TODO display login error
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event making the method run
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCard.show(contentBody, "home");
                User.getUser().nullUser();
            }
        });
    }

    public static void main(String[] args) {
        PerfectFitApp perfectFitApp = new PerfectFitApp();
        perfectFitApp.pack();
        perfectFitApp.setLocationRelativeTo(null);
        perfectFitApp.setVisible(true);
        System.exit(0);
    }
}
