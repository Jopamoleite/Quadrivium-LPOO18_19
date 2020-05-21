package com.quadrivium.g13.model;

import javax.swing.*;

public final class GameJFrame {

    private static JFrame jframe;

    public static JFrame getJframe() {
        return jframe;
    }

    public static void setJframe(JFrame jframe) {
        GameJFrame.jframe = jframe;
    }
}