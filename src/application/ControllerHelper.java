package application;

import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;

public class ControllerHelper {
	
	private static ControllerManager controllers;
	
	public ControllerHelper() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
	}
	
	public String getSticks() {
		String stickValues = "";
		ControllerState currState = controllers.getState(0);
		
		double leftX = currState.leftStickX;
		double leftY = currState.leftStickY;
		
		double rightX = currState.rightStickX;
		double rightY = currState.rightStickY;
		
		stickValues = String.format("Left: X: %f Y: %f, Right: X: %f Y: %f", leftX, leftY, rightX, rightY);
		
		return stickValues;
	}
	
	public ControllerState getRawData() {
		ControllerState currState = controllers.getState(0);
		return currState;
	}
	
	public String getButtons() {
		String pressedButtons = "";
		ControllerState currState = controllers.getState(0);

		boolean pressed = false;

		if (currState.a) {
			pressed = true;
			pressedButtons += " A";
		}

		if (currState.b) {
			pressed = true;
			pressedButtons += " B";
		}

		if (currState.x) {
			pressed = true;
			pressedButtons += " X";
		}

		if (currState.y) {
			pressed = true;
			pressedButtons += " Y";
		}

		if (currState.leftStickClick) {
			pressed = true;
			pressedButtons += " LS";
		}

		if (currState.rightStickClick) {
			pressed = true;
			pressedButtons += " RS";
		}

		if (currState.dpadUp) {
			pressed = true;
			pressedButtons += " UD";
		}

		if (currState.dpadRight) {
			pressed = true;
			pressedButtons += " RD";
		}

		if (currState.dpadDown) {
			pressed = true;
			pressedButtons += " DD";
		}

		if (currState.dpadLeft) {
			pressed = true;
			pressedButtons += " LD";
		}

		if (currState.back) {
			pressed = true;
			pressedButtons += " BACK";
		}

		if (currState.start) {
			pressed = true;
			pressedButtons += " START";
		}

		if (currState.lb) {
			pressed = true;
			pressedButtons += " LB";
		}

		if (currState.rb) {
			pressed = true;
			pressedButtons += " RB";
		}

		if (!pressed) {
			pressedButtons = "None";
		}
		
		return pressedButtons;
	}

}
