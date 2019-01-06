package main;

import java.awt.*;
import java.awt.event.InputEvent;

public class MouseControl {
	
	private Robot robot;
	
	public MouseControl() {
		try {
			robot = new Robot();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void moveTo(int x,int y) {
		robot.mouseMove(x, y);
	}
	
	public void moveRelativeTo(int x,int y) {
		int currX, currY;
		Point p = getCurrentMouseLocation();
		currX = (int)p.getX();
		currY = (int)p.getY();
		robot.mouseMove(x+currX, y+currY);
	}
	
	public void click() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public Point getCurrentMouseLocation() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		return p;
	}

}
