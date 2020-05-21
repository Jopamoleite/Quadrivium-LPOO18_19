package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.KeyPress;

import javax.swing.*;
import java.io.IOException;

public class SwingGameView extends JComponent {

    public KeyPress processKey() {
        return KeyPress.NO_KEY;
    }
    public void refreshScreen() {
    }
    public void clearScreen(){
        GameJFrame.getJframe().getContentPane().removeAll();
        GameJFrame.getJframe().getContentPane().revalidate();
        GameJFrame.getJframe().getContentPane().repaint();
    }
}
