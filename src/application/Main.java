package application;
	
import java.util.Timer;
import java.util.TimerTask;

import com.studiohartman.jamepad.ControllerState;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private boolean isPaused = false;
	private ControllerState controller;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Timer t = new Timer();
			
			
			
			Pane root = new Pane();
			ControllerText text1 = new ControllerText(10,50);
			ControllerText text2 = new ControllerText(10, 70);
			
			Ball b = new Ball(300,300,25);
			b.setBoundary(600, 400);
			
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			root.getChildren().add(text1.getText());
			root.getChildren().add(text2.getText());
			root.getChildren().add(b.getGraphic());
			
			
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(e->{
				t.cancel();
			});
			
			root.setOnKeyPressed(e->{
				if (e.getCode() == KeyCode.ESCAPE) {
					t.cancel();
					System.exit(0);
				}
			});
			
			root.requestFocus();
			
			t.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					
					controller = new ControllerHelper().getRawData();
					
					if (controller.startJustPressed) {
						isPaused=!isPaused;
					}
					
					if (controller.backJustPressed) {
						t.cancel();
						System.exit(0);
					}
					
					
					text1.showButtons();
					text2.showSticks();
					
					if (controller.aJustPressed) {
						b.kick();
					}
					
					if (!isPaused) {
						b.move();
					}
				}
			}, 500, 30);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
//		
//		
//		primaryStage.setTitle("Hello World!");
//		final Button btn = new Button();
//		
//		
//		
//		btn.setText(buttonText.toString());
//		
//		final StackPane root = new StackPane();
//		root.getChildren().add(btn);
//		primaryStage.setScene(new Scene(root, 300, 250));
//		primaryStage.show();
//		
//		
//		TimerTask tasknew = new ControllerTimer(buttonText);
//		Timer timer = new Timer();
//
//		timer.scheduleAtFixedRate(tasknew, 500, 30);
//		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
