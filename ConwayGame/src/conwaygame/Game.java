package conwaygame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game extends Application {
    private int width = 500; // scene width
    private int height = 500 + 100;// scene height
    private Grid grids = new Grid(500,500); 
	public Game() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * the stage of the game
	 */
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		// stage > scene > VBox
		//VBox contains GridPane for display the grid and  HBox to display the control pannel.
		
		
		
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
						clear.setText("Clear");
					}
				});
		
		// the play button
		choose.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						choose.setText("Choose");
					}
				});
		
		// the play button
		start.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						start.setText("Start");
					}
				});
		
		// the play button
		stop.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						//playButton();
						stop.setText("Stop");
					}
				});
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
