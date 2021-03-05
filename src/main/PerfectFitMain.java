package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PerfectFitMain extends JDialog {
    JPanel contentPane;
    private JButton buttonCancel;
    JPanel contentBody;
    JPanel home;
    private JPanel register;
    private JPanel aboutUs;
    private JPanel login;
    private JPanel loginBody;
    private JPanel loginForm;
    JPasswordField loginPassword;
    JTextField loginUsername;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel app;
    private JPanel appHeader;
    JTextArea appNameText;
    JPanel appBody;
    private JPanel appHome;
    private JButton appFootScanButton;
    private JButton appViewShoesButton;
    private JTextField registerText;
    private JPanel registerBody;
    private JPanel aboutUsBody;
    private JTextField aboutUsText;
    private JPanel appProfile;
    JTextArea profileUsernameText;
    JTextArea profileAddressText;
    JTextArea profileEmailText;
    JTextArea profileNameText;
    private JLabel profileUsernameLabel;
    private JLabel profileNameLabel;
    private JLabel profileAddressLabel;
    private JLabel profileEmailLabel;
    private JPanel contentHeader;
    private JPanel appSocks;
    JTextArea socksAddressText;
    private JTextArea socksConfirmText;
    // No access modifier = default; package private
    // Global button
    JButton backButton;
    // First screen buttons
    JButton registerButton;
    JButton aboutUsButton;
    JButton loginButton;
    // Login screen button
    JButton loginSubmitButton;
    // Post login buttons
    JButton appViewProfileButton;
    JButton appRequestSocksButton;
    // Socks screen buttons
    JButton socksSubmitButton;

    final CardLayout contentCard = (CardLayout)contentBody.getLayout();
    final CardLayout appCard = (CardLayout)appBody.getLayout();
    String currentPanelName;

    public PerfectFitMain() {
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Load listeners
        new Listeners(this).initListeners();

        // Load actions
        new Actions(this).initActions();

        // Hide back button on initial load (nothing to back to)
        backButton.setVisible(false);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    void onCancel() {
        dispose();
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
