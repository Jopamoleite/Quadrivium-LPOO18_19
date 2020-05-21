package com.quadrivium.g13.model;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CreateGame {

    public void initGame() {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);

        if (GameDimensions.isSwing()) {
            JFrame frame;
            frame = new JFrame("Quadrivium");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(125 * 8 + 48, 41 * 16 + 64));
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.BLACK);
            GameJFrame.setJframe(frame);
        } else {
            try {
                Screen screen;
                TerminalSize termSize = new TerminalSize(GameDimensions.getWidth(), GameDimensions.getHeight());
                DefaultTerminalFactory defaultTerm = new DefaultTerminalFactory();
                defaultTerm = defaultTerm.setInitialTerminalSize(termSize);
                Terminal terminal = defaultTerm.createTerminal();
                screen = new TerminalScreen(terminal);
                GameScreen.setScreen(screen);

                screen.setCursorPosition(null);   // we don't need a cursor
                screen.startScreen();             // screens must be started
                screen.doResizeIfNecessary();     // resize screen if necessary
                screen.doResizeIfNecessary();     // resize screen if necessary
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}
