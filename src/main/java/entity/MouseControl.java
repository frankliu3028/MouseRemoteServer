package entity;

import utils.Log;

import java.awt.*;
import java.awt.event.InputEvent;

public class MouseControl {

	private final String TAG = MouseControl.class.getSimpleName();
	
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

	public void pressDown(int button){
		if(button != InputEvent.BUTTON1_MASK && button != InputEvent.BUTTON2_MASK){
			Log.e(TAG, "button mask error!");
		}
		robot.mousePress(button);
	}

	public void pressUp(int button){
		if(button != InputEvent.BUTTON1_MASK && button != InputEvent.BUTTON2_MASK){
			Log.e(TAG, "button mask error!");
		}
		robot.mousePress(button);
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
