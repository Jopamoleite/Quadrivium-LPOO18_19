package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.xml.ws.BindingType;

import static org.junit.Assert.assertEquals;

public class TestControls {

    private Controls controls;

    @Before
    public void setUp(){
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));

        controls = new Controls();
    }

    @Test
    public void testLetterX(){
        controls.setLetterX(10);
        assertEquals(10, controls.getLetterX());
    }

    @Test
    public void testLetterY(){
        controls.setLetterY(10);
        assertEquals(10, controls.getLetterY());
    }

    @Test
    public void testLetterSize(){
        controls.setLetterSize(10);
        assertEquals(10, controls.getLetterSize());
    }
}
