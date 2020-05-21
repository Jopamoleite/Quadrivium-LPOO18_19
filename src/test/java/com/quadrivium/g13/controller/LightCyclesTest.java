package com.quadrivium.g13.controller;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.StyleSet;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.screen.TabBehaviour;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaLightCyclesView;
import com.quadrivium.g13.view.LanternaPlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;

import static org.junit.Assert.assertEquals;

public class LightCyclesTest {
    private LightCyclesController lc;
    private CurrentLevel level;

    @Before
    public void setUp() throws OutOfBoundsException, InvalidGameException {
        GameDimensions.setSwing(false);
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        Mockito.when(screenMock.newTextGraphics()).thenReturn(new TextGraphics() {
            @Override
            public TextColor getBackgroundColor() {
                return null;
            }

            @Override
            public TextGraphics setBackgroundColor(TextColor backgroundColor) {
                return null;
            }

            @Override
            public TextColor getForegroundColor() {
                return null;
            }

            @Override
            public TextGraphics setForegroundColor(TextColor foregroundColor) {
                return null;
            }

            @Override
            public TextGraphics enableModifiers(SGR... modifiers) {
                return null;
            }

            @Override
            public TextGraphics disableModifiers(SGR... modifiers) {
                return null;
            }

            @Override
            public TextGraphics setModifiers(EnumSet<SGR> modifiers) {
                return null;
            }

            @Override
            public TextGraphics clearModifiers() {
                return null;
            }

            @Override
            public EnumSet<SGR> getActiveModifiers() {
                return null;
            }

            @Override
            public TextGraphics setStyleFrom(StyleSet<?> source) {
                return null;
            }

            @Override
            public TerminalSize getSize() {
                return null;
            }

            @Override
            public TextGraphics newTextGraphics(TerminalPosition topLeftCorner, TerminalSize size) throws IllegalArgumentException {
                return null;
            }

            @Override
            public TabBehaviour getTabBehaviour() {
                return null;
            }

            @Override
            public TextGraphics setTabBehaviour(TabBehaviour tabBehaviour) {
                return null;
            }

            @Override
            public TextGraphics fill(char c) {
                return null;
            }

            @Override
            public TextGraphics setCharacter(int column, int row, char character) {
                return null;
            }

            @Override
            public TextGraphics setCharacter(int column, int row, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics setCharacter(TerminalPosition position, char character) {
                return null;
            }

            @Override
            public TextGraphics setCharacter(TerminalPosition position, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics drawLine(TerminalPosition fromPoint, TerminalPosition toPoint, char character) {
                return null;
            }

            @Override
            public TextGraphics drawLine(TerminalPosition fromPoint, TerminalPosition toPoint, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics drawLine(int fromX, int fromY, int toX, int toY, char character) {
                return null;
            }

            @Override
            public TextGraphics drawLine(int fromX, int fromY, int toX, int toY, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics drawTriangle(TerminalPosition p1, TerminalPosition p2, TerminalPosition p3, char character) {
                return null;
            }

            @Override
            public TextGraphics drawTriangle(TerminalPosition p1, TerminalPosition p2, TerminalPosition p3, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics fillTriangle(TerminalPosition p1, TerminalPosition p2, TerminalPosition p3, char character) {
                return null;
            }

            @Override
            public TextGraphics fillTriangle(TerminalPosition p1, TerminalPosition p2, TerminalPosition p3, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics drawRectangle(TerminalPosition topLeft, TerminalSize size, char character) {
                return null;
            }

            @Override
            public TextGraphics drawRectangle(TerminalPosition topLeft, TerminalSize size, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics fillRectangle(TerminalPosition topLeft, TerminalSize size, char character) {
                return null;
            }

            @Override
            public TextGraphics fillRectangle(TerminalPosition topLeft, TerminalSize size, TextCharacter character) {
                return null;
            }

            @Override
            public TextGraphics drawImage(TerminalPosition topLeft, TextImage image) {
                return null;
            }

            @Override
            public TextGraphics drawImage(TerminalPosition topLeft, TextImage image, TerminalPosition sourceImageTopLeft, TerminalSize sourceImageSize) {
                return null;
            }

            @Override
            public TextGraphics putString(int column, int row, String string) {
                return null;
            }

            @Override
            public TextGraphics putString(TerminalPosition position, String string) {
                return null;
            }

            @Override
            public TextGraphics putString(int column, int row, String string, SGR extraModifier, SGR... optionalExtraModifiers) {
                return null;
            }

            @Override
            public TextGraphics putString(TerminalPosition position, String string, SGR extraModifier, SGR... optionalExtraModifiers) {
                return null;
            }

            @Override
            public TextGraphics putString(int column, int row, String string, Collection<SGR> extraModifiers) {
                return null;
            }

            @Override
            public TextGraphics putCSIStyledString(int column, int row, String string) {
                return null;
            }

            @Override
            public TextGraphics putCSIStyledString(TerminalPosition position, String string) {
                return null;
            }

            @Override
            public TextCharacter getCharacter(TerminalPosition position) {
                return null;
            }

            @Override
            public TextCharacter getCharacter(int column, int row) {
                return null;
            }
        });

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(30, 19)), new LanternaPlayerView());
        lc = new LightCyclesController(new LightCycles(), new LanternaLightCyclesView());
        player.resetPosition();
        lc.setPlayer(player);
        level = new CurrentLevel();
        level.setPlayer(player);
        level.setActiveGame(lc);
    }

    @Test
    public void enemyCollide() throws OutOfBoundsException, IOException, InterruptedException {
        this.lc.getPlayer().setPosition(new Position(30, GameDimensions.getHeight()-6));
        assertEquals(this.lc.play(level), GameResult.LOSE);
        assertEquals(LoseScreenController.class, this.level.getActiveGame().getClass());
    }
}
