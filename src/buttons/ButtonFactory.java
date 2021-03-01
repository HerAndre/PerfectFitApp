package buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonFactory {

    public JButton makeButton(String name, ActionListener a) {
        JButton button = new JButton(name);
        button.addActionListener(a);
        return button;
    }

}
