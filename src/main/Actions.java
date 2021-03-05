package main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Actions {

    private final PerfectFitMain main;

    public Actions(PerfectFitMain main) {
        this.main = main;
    }

    public void initActions() {
        initKeyboardActions();
    }

    private void initKeyboardActions() {
        // call onCancel() on ESCAPE
        main.contentPane.registerKeyboardAction(e ->
                        main.onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

}
