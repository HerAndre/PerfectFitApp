package buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFactory {

    public JButton makeButton(String name) {
        JButton button = new JButton(name);
        button.addActionListener(setAction(name));
        return button;
    }

    private ActionListener setAction(String buttonName) {
        switch(buttonName) {
            case "Login":
                return e -> {
                    System.out.println("Login was pressed");
                };
            case "Register":
                return e -> {
                    System.out.println("Register was pressed");
                };
            default:
                return null;
        }
    }
}
