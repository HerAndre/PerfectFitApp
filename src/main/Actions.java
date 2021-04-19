package main;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Contains all the actions of the application.
 */
public class Actions {

    private final PerfectFitMain main;

    /**
     * Constructor for Actions
     * @param main the main instance containing all the form objects
     */
    public Actions(PerfectFitMain main) {
        this.main = main;
    }

    /**
     * Initialize keyboard actions
     */
    public void initActions() {
        initKeyboardActions();
    }

    /**
     * Listens for the escape key and closes the window on press
     */
    private void initKeyboardActions() {
        // call onCancel() on ESCAPE
        main.contentPane.registerKeyboardAction(e ->
                        main.onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

}
