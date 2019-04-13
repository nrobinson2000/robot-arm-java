package application;

import java.util.Timer;
import java.util.TimerTask;

import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;

public class ControllerInput {
	private static ControllerManager controllers;
	Timer t = new Timer();
	
	public ControllerInput() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				getSticks();
			}
		}, 500, 30);
}
	public String getSticks() {
		String stickValues = "";
		ControllerState currState = controllers.getState(0);
		
		double leftX = currState.leftStickX;
		double leftY = currState.leftStickY;
		
		double rightY = currState.rightStickY;
		
		double leftT = currState.leftTrigger;
		double rightT = currState.rightTrigger;
		
		//direction 3 = no movement, 1 = forward, 2 = backward
		double rotation = 3;
		if(leftX>0) {
			rotation = 1;
		} else if(leftX<0) {
			rotation = 2;
		}
		
		double base = 3;
		if(leftY>0) {
			base = 1;
		}else if(leftY<0) {
			base = 2;
		}
		
		//based of 0-1 and converts to 0-255
		int speedRotation = (int)(Math.abs(leftX) * 255);
		int speedBase = (int)(Math.abs(leftY) * 255);
		
		double elbow = 3;
		if(rightY>0) {
			elbow = 1;
		} else if(rightY<0) {
			elbow = 2;
		}
		
		int speedElbow = (int)(Math.abs(rightY) * 255);
		
		stickValues = String.format("%f,%d,%f,%d,%f,%d,%f,%f",rotation, speedRotation, base, speedBase, elbow, speedElbow, leftT, rightT);
		
		return stickValues;
	}
	
}
	



