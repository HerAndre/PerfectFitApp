package main;

import shoes.ShoeBuilder;
import shoes.ShoeDatabase;

import javax.swing.*;
import java.awt.*;

public class PerfectFitMain extends JDialog {
    /*
    * Form populates most of these variables
    * If it's not found in the form then it probably is a
    * useless declaration.
    */
    private JPanel register;
    private JPanel aboutUs;
    private JPanel login;
    private JPanel loginBody;
    private JPanel loginForm;
    private JPanel app;
    private JPanel appHeader;
    private JPanel appHome;
    private JPanel aboutUsBody;
    private JPanel appProfile;
    private JPanel appSocks;
    private JPanel contentHeader;
    private JLabel profileUsernameLabel;
    private JLabel profileNameLabel;
    private JLabel profileAddressLabel;
    private JLabel profileEmailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField aboutUsText;
    private JTextArea socksConfirmText;

    // No access modifier = default; package private
    JPanel home;
    JPanel contentPane;
    JPanel contentBody;
    JPasswordField loginPassword;
    JTextField loginUsername;
    JPanel appBody;
    // Nav bar text (header)
    JTextArea appUserNameText;
    JTextArea appUserShoeText;
    // Profile page text
    JTextArea profileUsernameText;
    JTextArea profileAddressText;
    JTextArea profileEmailText;
    JTextArea profileNameText;
    // Sock page text
    JTextArea socksAddressText;
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
    JButton appFootScanButton;
    JButton appViewShoesButton;
    // Socks screen buttons
    JButton socksSubmitButton;
    // Scanning foot section
    JButton scanAutoButton;
    JButton scanManualButton;
    JButton scanSubmitButton;
    // Foot scan bar
    JProgressBar scanProgressBar;
    // Foot scan button
    JButton scanViewShoesButton;
    private JPanel appScan;
    private JPanel appScanManual;
    // Manual size entry
    JTextField manualArchText;
    JTextField manualLengthText;
    JTextField manualWidthText;
    private JLabel lengthLabel;
    private JLabel widthLabel;
    private JLabel archLabel;
    private JPanel appScanAuto;
    private JPanel appShoes;
    private JTextField registerUsernameText;
    private JTextField registerPasswordText;
    private JTextField registerEmailText;
    private JButton registerSubmitButton;
    private JLabel registerEmailLabel;
    private JLabel registerUsernameLabel;
    private JLabel registerPasswordLabel;

    final CardLayout contentCard = (CardLayout)contentBody.getLayout();
    final CardLayout appCard = (CardLayout)appBody.getLayout();
    String currentPanelName;

    public PerfectFitMain() {
        // JDialog setup
        setContentPane(contentPane);
        setModal(true);

        // Closing is handled by window Listener
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Load listeners
        new Listeners(this).initListeners();

        // Load actions
        new Actions(this).initActions();

        // Hide back button on initial load (nothing to back to)
        backButton.setVisible(false);

    }

    /*
    * Used to handle closing of the gui,
    * Currently used by clicking the X button and pressing ESC
    */
    void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        ShoeBuilder shoeBuilder = new ShoeBuilder();
        shoeBuilder.createShoes("nike");
        shoeBuilder.createShoes("adidas");
        shoeBuilder.createShoes("puma");
        shoeBuilder.createShoes("reebok");
        shoeBuilder.createShoes("vans");
        shoeBuilder.createShoes("converse");

        // Only runs if debug mode is on
        ShoeDatabase.getInstance().printShoeDataTable();

        PerfectFitMain perfectFitMain = new PerfectFitMain();
        perfectFitMain.pack();
        perfectFitMain.setLocationRelativeTo(null);
        perfectFitMain.setVisible(true);
        System.exit(0);
    }

}
