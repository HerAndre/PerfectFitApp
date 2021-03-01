import gui.FramePerfectFit;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FramePerfectFit framePerfectFit = new FramePerfectFit();
        framePerfectFit.init();
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
