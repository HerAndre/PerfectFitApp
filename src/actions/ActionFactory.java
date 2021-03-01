package actions;

import gui.LoginFrame;
import gui.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ActionFactory {

    public ActionListener makeAction(String buttonName, Object obj) {
        JFrame jFrame = (JFrame) obj;
        switch( buttonName ) {
            case "Login":
                return e -> {
                    try {
                        jFrame.dispose();
                        new LoginFrame().setVisible(true);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                };

            case "Register": {
                return e -> {
                    try {
                        jFrame.dispose();
                        new RegisterFrame().setVisible(true);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                };
            }
        }

        return null;
    }

}
