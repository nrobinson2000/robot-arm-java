package application;

import java.util.Random;

import com.studiohartman.jamepad.ControllerState;

import javafx.scene.shape.Circle;

public class Ball {
	private double x;
	private double y;
	private double radius;
	
	private double vx, vy, dt;
	private double maxX, maxY;
	
	private boolean isPaused;
	
	private Circle node;
	private Random rand = new Random();
	
	private ControllerState cs;
	private ControllerHelper ch;
	
	public Ball(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		node = new Circle(x, y, radius);
		
		ch = new ControllerHelper();
		
		vx=100; // pixels/second
		vy=200;
		dt=0.03; // seconds
	}
	
	public void setBoundary(double x, double y) {
		maxX=x;
		maxY=y;
	}
	
	public Circle getGraphic() {
		return node;
	}
	
	public void move() {
		
		// Bounce off of walls
		if (x-radius<=0 || x+radius>=maxX) {
			vx=-vx;
		}
		
		if (y-radius<=0 || y+radius>=maxY) {
			vy=-vy;
		}
		
		// do physics
		// Euler's method
		// x(t+dt)=x(t)+Vdt
		
		x=x+vx*dt;
		y=y+vy*dt;
		
		node.setCenterX(x);
		node.setCenterY(y);
		

	}
	
	public void kick() {
		vx=vx+(rand.nextDouble()-0.5)*500;
		vy=vy+(rand.nextDouble()-0.5)*500;
	}
	
	
	
}
