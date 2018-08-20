import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game extends Application {


	public Game() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		//basic UI button creation
		Button clear = new Button("Clear");
		Button choose = new Button("Play");
		Button start = new Button("Start");
		Button stop = new Button("Stop");
		
		// the clear button
		clear.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//clearButton();
						clear.setText("Play");
					}
				});
		
		// the play button
		choose.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						choose.setText("Play");
					}
				});
		
		// the play button
		start.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						start.setText("Play");
					}
				});
		
		// the play button
		stop.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						stop.setText("Play");
					}
				});
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
