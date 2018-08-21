package conwaygame;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
	private int width = 500; // scene width
	private int height = 500 + 100;// scene height
	private Grid grids = new Grid(500, 500);

	public Game() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * the stage of the game
	 */
	public void start(Stage primaryStage) throws Exception {

		//Initialize  the game
		grids.initialFill();





		// basic UI button creation
		Button clear = new Button("Clear");
		clear.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		clear.setOnMouseEntered(new ButtonColorHandler(clear, Color.MEDIUMSEAGREEN));
		clear.setOnMouseExited(new ButtonColorHandler(clear, Color.KHAKI));

		Button play = new Button("Play");
		play.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		play.setOnMouseEntered(new ButtonColorHandler(play, Color.MEDIUMSEAGREEN));
		play.setOnMouseExited(new ButtonColorHandler(play, Color.KHAKI));

		Button randomFill = new Button("Random Fill");
		randomFill.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		randomFill.setOnMouseEntered(new ButtonColorHandler(randomFill, Color.MEDIUMSEAGREEN));
		randomFill.setOnMouseExited(new ButtonColorHandler(randomFill, Color.KHAKI));

		Button stop = new Button("Stop");
		stop.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		stop.setOnMouseEntered(new ButtonColorHandler(stop, Color.MEDIUMSEAGREEN));
		stop.setOnMouseExited(new ButtonColorHandler(stop, Color.KHAKI));

		Button exit = new Button("Exit");
		exit.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		exit.setOnMouseEntered(new ButtonColorHandler(exit, Color.MEDIUMSEAGREEN));
		exit.setOnMouseExited(new ButtonColorHandler(exit, Color.KHAKI));

		// the clear button Handler
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				clearButton();
				System.out.println("Clear Button press");
			}
		});

		// the play button Handler
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				grids.update();
				System.out.println("Play Button press");
			}
		});

		// the Start button Handler
		randomFill.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				grids.randomFill();
				System.out.println("Start Button press");
			}
		});

		// the Stop button Handler
		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// stopButton();
				System.out.println("Stop Button press");
			}
		});

		//// the Exit button Handler
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Exit Button press");
				Platform.exit();

			}
		});

		// stage > scene > VBox
		// VBox contains GridPane for display the grid and HBox to display the
		// control panel.

		primaryStage.setTitle("Conway Game!!");
		BorderPane root = new BorderPane();
		Separator sep = new Separator();
		HBox controlPanel = new HBox(10, play, randomFill, stop, clear, exit);
		VBox hboxHolder = new VBox(sep,controlPanel);
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		controlPanel.setPadding(new Insets(10));
		controlPanel.setAlignment(Pos.CENTER);
		root.setCenter(grids);
		//grids.setGridLinesVisible(true);
		root.setBottom(hboxHolder);
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		setCellEvent();
		

	}

	public static void main(String[] args) {
		launch(args);
	}

	//all the methods

	/*clearButton();
	playButton()
	randomFillButton();
	stopButton();*/


	public void clearButton(){
		//grids.getChildren().clear();
	}


	public void setCellEvent(){
		for(Node cell: grids.getChildren()) {
			Cell cellText = (Cell) cell;
			cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent event) {
			    	   System.out.println(event.getSource().toString());
			    	   cellText.setFill(Color.AQUA);
			    }});
		}
	} 


	/**
	 * This ButtonColorHandler's event handler act on every button by changing
	 * different colors
	 * 
	 * @author chadz
	 */
	class ButtonColorHandler implements EventHandler<MouseEvent> {
		private Button btn;
		private Color color;

		public ButtonColorHandler(Button btn, Color color) {
			this.btn = btn;
			this.color = color;
		}

		@Override
		public void handle(MouseEvent event) {
			btn.setBackground(new Background(new BackgroundFill(color, null, null)));

		}

	}


}
