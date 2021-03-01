package gui;

import buttons.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class FramePerfectFit extends JFrame {

    public FramePerfectFit() {
    }

    public FramePerfectFit getJFrame() {
        return this;
    }

    public void init() {
        ButtonFactory buttonFactory = new ButtonFactory();
        buttonFactory.makeButton("Login");
        JButton login = buttonFactory.makeButton("Login");
        JButton register = buttonFactory.makeButton("Register");
        ButtonGroup bg = new ButtonGroup();
        bg.add(login);
        bg.add(register);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttons.add(login);
        buttons.add(register);

        JPanel gui = new JPanel(new BorderLayout(5,5));
        gui.add(buttons, BorderLayout.SOUTH);

        CardLayout c1 = new CardLayout();
        JPanel cards = new JPanel(c1);
        gui.add(cards);

        getContentPane().add(gui);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane();
    }


}
