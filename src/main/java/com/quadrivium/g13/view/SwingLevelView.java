package com.quadrivium.g13.view;

import com.quadrivium.g13.model.KeyPress;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingLevelView implements KeyListener {
    private KeyPress keyPressed = KeyPress.NO_KEY;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyPressed = KeyPress.UP;
                return;
            case KeyEvent.VK_RIGHT:
                keyPressed = KeyPress.RIGHT;
                return;
            case KeyEvent.VK_DOWN:
                keyPressed = KeyPress.DOWN;
                return;
            case KeyEvent.VK_LEFT:
                keyPressed = KeyPress.LEFT;
                return;
            case KeyEvent.VK_ENTER:
                keyPressed = KeyPress.ENTER;
                return;
            case KeyEvent.VK_W:
                keyPressed = KeyPress.W;
                return;
            case KeyEvent.VK_A:
                keyPressed = KeyPress.A;
                return;
            case KeyEvent.VK_S:
                keyPressed = KeyPress.S;
                return;
            case KeyEvent.VK_D:
                keyPressed = KeyPress.D;
                return;
            case KeyEvent.VK_ESCAPE:
                keyPressed = KeyPress.EXIT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public KeyPress getAndResetKey(){
        KeyPress key = keyPressed;
        keyPressed = KeyPress.NO_KEY;
        return key;
    }
}
