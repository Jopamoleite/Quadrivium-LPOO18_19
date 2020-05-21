package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;

import java.awt.event.WindowEvent;
import java.io.IOException;

public class SwingLevelManagerView implements LevelManagerView{
    @Override
    public void closeScreen() {
        GameJFrame.getJframe().dispatchEvent(new WindowEvent(GameJFrame.getJframe(), WindowEvent.WINDOW_CLOSING));
    }
}
