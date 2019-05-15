package entity;

import org.junit.Test;

import java.awt.event.InputEvent;

import static org.junit.Assert.*;

public class MouseControlTest {

    @Test
    public void mouseClick() {
        MouseControl mouseControl = new MouseControl();
        mouseControl.mouseClick(InputEvent.BUTTON3_MASK);
    }
}