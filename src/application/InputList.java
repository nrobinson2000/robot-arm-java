package application;

import java.util.ArrayList;

import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;

public class InputList {
	public ArrayList<Double> List;
	private static ControllerManager controllers;
	
	public InputList() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
		ControllerState currState = controllers.getState(0);
		List.add((double) currState.leftStickX);
		List.add((double) currState.leftStickY);
		List.add((double) currState.rightStickY);
		List.add((double) currState.leftTrigger);
		List.add((double) currState.rightTrigger);
	}
	
	 

}
