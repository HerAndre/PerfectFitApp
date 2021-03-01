package gui;

import actions.ActionFactory;
import buttons.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class InitFrame extends JFrame {

    public InitFrame() {
        setTitle("Perfect Fit");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initButtons();
        pack(); // Sizes everything to proportion (REQUIRED FOR setLocationRelativeTo)
        setLocationRelativeTo(null); // Centers frame
        setVisible(true);
    }

    private void initButtons() {
        ButtonFactory buttonFactory = new ButtonFactory();
        ActionFactory actionFactory = new ActionFactory();
        add(buttonFactory.makeButton("Login", actionFactory.makeAction("Login", this)));
        add(buttonFactory.makeButton("Register", actionFactory.makeAction("Register", this)));
    }


}
