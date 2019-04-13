package application;

import javafx.scene.text.Text;

public class ControllerText {
	
	private Text textBox;
	private ControllerHelper ch;
	
	public ControllerText() {
		this(10, 50, "Welcome to my game!");
	}
	
	public ControllerText(double x, double y) {
		this(x, y, "Welcome to my game!");
	}
	
	public ControllerText(double x, double y, String fillerText) {
		textBox = new Text(x, y, fillerText);
		ch = new ControllerHelper();
	}
	
	public Text getText() {
		return textBox;
	}
	
	public void showButtons() {
		textBox.setText(ch.getButtons());
	}
	
	public void showSticks() {
		textBox.setText(ch.getSticks());
	}
	

}
