package conwaygame;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/***
 * This Game class holds the JavaFX User Interface, viewable grid and entry point for our Conway's Game
 * 
 * @author faanannath
 *
 */

public class Game extends Application {
	
	//Have removed the height and width variables previously here 
	//as Grid extends Gridpane allowing passing of these as parameters
	 
	private Grid grids = new Grid(500, 500);
	private Timeline timeline;
	private String speed = "Fast";
	private KeyFrame keyFrame;

	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * This method allows passing of a variable parameter speed 
	 * via the speed menubar handler to change
	 * the playback speed of the animation in the timeline
	 * 
	 * Adjusts the speed either before or during animation
	 * 
	 * @param speed 'Slow' 'Medium' 'Fast' 'Fastest'
	 */
	public void updateTimeline(String speed) { 

		boolean wasPlaying;
		if (timeline == null) {
			wasPlaying = false;
		} else {
			wasPlaying = (timeline.getStatus() == Status.RUNNING);
			timeline.stop();
		}
		
		SpeedControl speedControl = new SpeedControl();
		Duration duration = speedControl.getNewDuration(speed);// change to
																// speed
		keyFrame = new KeyFrame(duration, t -> grids.update());
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);

		if (wasPlaying)
			timeline.play();
		
		if (wasPlaying) timeline.play();
	}

	/**
	 * The following method implements the stage of the game
	 */
	public void start(Stage primaryStage) throws Exception {
		
		// Initialize the game and set up for user interaction
		grids.initialFill();

		/**
		 * The following block designated by //**BUTTON UI & MENU SETUP BEGINS** sets up the UI Buttons in the stage
		 */
		
		//********BUTTON UI & MENU SETUP BEGINS********
		Button clear = new Button("CLEAR");
		clear.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		clear.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		clear.setOnMouseEntered(new ButtonColorHandler(clear, Color.SILVER));
		clear.setOnMouseExited(new ButtonColorHandler(clear, Color.CORNFLOWERBLUE));
		
		//'PLAY' button
		Button play = new Button("PLAY");
		play.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		play.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		play.setOnMouseEntered(new ButtonColorHandler(play, Color.SILVER));
		play.setOnMouseExited(new ButtonColorHandler(play, Color.CORNFLOWERBLUE));
		
		//'RANDOM FILL' button
		Button randomFill = new Button("RANDOM FILL");
		randomFill.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		randomFill.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		randomFill.setOnMouseEntered(new ButtonColorHandler(randomFill, Color.SILVER));
		randomFill.setOnMouseExited(new ButtonColorHandler(randomFill, Color.CORNFLOWERBLUE));
		
		//'STOP' button
		Button stop = new Button("STOP");
		stop.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		stop.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		stop.setOnMouseEntered(new ButtonColorHandler(stop, Color.SILVER));
		stop.setOnMouseExited(new ButtonColorHandler(stop, Color.CORNFLOWERBLUE));
		
		//'EXIT' button
		Button exit = new Button("EXIT");
		exit.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		exit.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		exit.setOnMouseEntered(new ButtonColorHandler(exit, Color.SILVER));
		exit.setOnMouseExited(new ButtonColorHandler(exit, Color.CORNFLOWERBLUE));
		
		//'CHOOSE SHAPES' menu item and button
		CheckMenuItem shape1 = new CheckMenuItem("TEST LINE");
		CheckMenuItem shape2 = new CheckMenuItem("GLIDER");
		CheckMenuItem shape3 = new CheckMenuItem("SPACESHIP");
		CheckMenuItem shape4 = new CheckMenuItem("GLIDERGUN");
		shape1.setSelected(false);
		shape2.setSelected(false);
		shape3.setSelected(false);
		shape4.setSelected(false);
		
		//Keyboard shortcuts for Shapes menu options
		shape1.setAccelerator(new KeyCodeCombination(KeyCode.B,KeyCodeCombination.SHORTCUT_DOWN));
		shape2.setAccelerator(new KeyCodeCombination(KeyCode.U,KeyCodeCombination.SHORTCUT_DOWN));
		shape3.setAccelerator(new KeyCodeCombination(KeyCode.I,KeyCodeCombination.SHORTCUT_DOWN));
		shape4.setAccelerator(new KeyCodeCombination(KeyCode.O,KeyCodeCombination.SHORTCUT_DOWN));
		
		//'CHOOSE SHAPES' Button
		MenuButton shapeButton = new MenuButton("CHOOSE SHAPES", null, shape1, shape2, shape3, shape4);
		shapeButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		shapeButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		shapeButton.setOnMouseEntered(new MenuButtonColorHandler(shapeButton, Color.SILVER));
		shapeButton.setOnMouseExited(new MenuButtonColorHandler(shapeButton, Color.CORNFLOWERBLUE));

		//'SPEED' menu item
		CheckMenuItem slowSpeed = new CheckMenuItem("SLOW");
		CheckMenuItem medSpeed = new CheckMenuItem("MEDIUM ");
		CheckMenuItem fastSpeed = new CheckMenuItem("FAST");
		CheckMenuItem fastestSpeed = new CheckMenuItem("FASTEST");
		slowSpeed.setSelected(false);
		medSpeed.setSelected(false);
		fastSpeed.setSelected(false);
		fastestSpeed.setSelected(false);
		
		//Keyboard shortcuts for speed dropdown menu items
		slowSpeed.setAccelerator(new KeyCodeCombination(KeyCode.W,KeyCodeCombination.SHORTCUT_DOWN));
		medSpeed.setAccelerator(new KeyCodeCombination(KeyCode.E,KeyCodeCombination.SHORTCUT_DOWN));
		fastSpeed.setAccelerator(new KeyCodeCombination(KeyCode.R,KeyCodeCombination.SHORTCUT_DOWN));
		fastestSpeed.setAccelerator(new KeyCodeCombination(KeyCode.T,KeyCodeCombination.SHORTCUT_DOWN));
		
		//'SPEED' menu button
		MenuButton speedButton = new MenuButton("SPEED", null, slowSpeed, medSpeed, fastSpeed, fastestSpeed);
		speedButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		speedButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		speedButton.setOnMouseEntered(new MenuButtonColorHandler(speedButton, Color.SILVER));
		speedButton.setOnMouseExited(new MenuButtonColorHandler(speedButton, Color.CORNFLOWERBLUE));
		
		//'COLOUR' menu item
		CheckMenuItem color1 = new CheckMenuItem("BLUE");
		CheckMenuItem color2 = new CheckMenuItem("GREEN");
		CheckMenuItem color3 = new CheckMenuItem("PINK");
		CheckMenuItem color4 = new CheckMenuItem("COLOUR PICKER");
		color1.setSelected(false);
		color2.setSelected(false);
		color3.setSelected(false);
		color4.setSelected(false);
		
		//Keyboard shortcuts for Colour menu item
		color1.setAccelerator(new KeyCodeCombination(KeyCode.A,KeyCodeCombination.SHORTCUT_DOWN));
		color2.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCodeCombination.SHORTCUT_DOWN));
		color3.setAccelerator(new KeyCodeCombination(KeyCode.D,KeyCodeCombination.SHORTCUT_DOWN));
		color4.setAccelerator(new KeyCodeCombination(KeyCode.F,KeyCodeCombination.SHORTCUT_DOWN));
		
		//'COLOUR' menu button
		MenuButton colorButton = new MenuButton("COLOUR", null, color1, color2, color3, color4);
		colorButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		colorButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		colorButton.setOnMouseEntered(new MenuButtonColorHandler(colorButton, Color.SILVER));
		colorButton.setOnMouseExited(new MenuButtonColorHandler(colorButton, Color.CORNFLOWERBLUE));
		MenuButton menuButton = new MenuButton("Shape Choose", null, shape1, shape2, shape3, shape4);
		menuButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		menuButton.setOnMouseEntered(new MenuButtonColorHandler(menuButton, Color.MEDIUMSEAGREEN));
		menuButton.setOnMouseExited(new MenuButtonColorHandler(menuButton, Color.KHAKI));
		
		//********BUTTON UI SETUP ENDS********
		
		//********BUTTON EVENT HANDLERS BEGINS********
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				clearButton();
				System.out.println("Clear Button press");
			}
		});

		//The 'PLAY' button EventHandler
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				timeline.play();
				System.out.println("Play Button press");
			}
		});

		//The 'RANDOM FILL' button EventHandler
		randomFill.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				grids.randomFill();
				System.out.println("Random Fill Button press");
			}
		});

		//The 'STOP' button EventHandler
		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				timeline.pause();
				System.out.println("Stop Button press");
			}
		});
		
		//The 'EXIT' button EventHandler
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Exit Button press");
				Platform.exit();

			}
		});

		//*****Speed Button Handlers*****

		speedButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println(" Speed Button press");
			}
		});
		
		//Slow
		slowSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Slow";
				updateTimeline(speed);
			}
		});
		
		//Medium
		medSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Medium";
				updateTimeline(speed);
			}
		});
		
		//Fast
		fastSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Fast";
				updateTimeline(speed);
			}
		});
		
		//Fastest
		fastestSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Fastest";
				updateTimeline(speed);
			}
		});

		//*****Shape Button Handlers*****

		shapeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Speed Button press");
			}
		});
		
		//TestLine shape
		shape1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.testLine());
			}
		});
		
		//Glider shape
		shape2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.glider());
			}
		});
		
		//spaceShip shape
		shape3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.spaceShip());
			}
		});
		
		//Glider Gun shape
		shape4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.gliderGun());
			}
		});
		
		// *****Colour Button Handlers*****
		
		colorButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Colour Button  press");
			}
		});
		
		//Set to Blue 
		color1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllBlue();
				System.out.println("Colour 1  selected");
			}
		});
		
		//Set to Green
		color2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllGreen();
				System.out.println("Colour 2  selected");
			}
		});
		
		//Set to Pink
		color3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllPink();
				System.out.println("Colour 3 selected");
			}
		});
		
		//Colour Picker *NOT YET IMPLEMENTED CORRECTLY*
		color4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.pickColor();
				System.out.println("Colour Picker selected");
			}
		});

		/***
		 * This block controls the setup and layout of the game window in the stage.
		 */
		// stage > scene > VBox
		// VBox contains GridPane for display the grid and HBox to display the
		// control panel.
		
		primaryStage.setTitle("Conway Game!!");  
		BorderPane root = new BorderPane();
		Separator sep = new Separator();
		HBox controlPanel = new HBox(10, shapeButton, randomFill, play, stop, clear, exit);
		HBox controlPane2 = new HBox(10, speedButton, colorButton, exit);
		VBox hboxHolder = new VBox(sep, controlPanel, controlPane2);
		controlPanel.setPadding(new Insets(10));
		controlPanel.setAlignment(Pos.CENTER);
		controlPane2.setPadding(new Insets(10));
		controlPane2.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, null, null)));
		root.setCenter(grids);
		root.setBottom(hboxHolder);
		Scene scene = new Scene(root, 560, 700);
		updateTimeline(this.speed);
		primaryStage.setScene(scene);
		primaryStage.show();
		setCellEvent();

	}
	/***
	 * Main method to launch the program at runtime
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/***
	 * This method called by its associated button and event handlers
	 * calls the clearAll() method which reinitialises the viewable grid to clear
	 * with no live cells
	 */
	public void clearButton() {
		grids.clearAll();
	}

	/***
	 * This method allows user to manually click on the viewable grid to populate with alive cells
	 * 
	 * method to set up the each cell's mouse action then when click the cell,
	 * if the cell is dead, it will be alive. if the cell is alive, it will be
	 * dead
	 */
	public void setCellEvent() {
		for (Node cell : grids.getChildren()) {
			Cell cellClicked = (Cell) cell;
			cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
					if (cellClicked.isAlive()) {
						cellClicked.setAlive(false);
					} else {
						cellClicked.setAlive(true);
					}
				}
			});
		}
	}

	//Leaving this at the bottom of Game class for possible refactoring
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

	/**
	 * This MenuButtonColorHandler's event handler act on every button by
	 * changing different colors
	 * 
	 * @author chadz
	 */
	class MenuButtonColorHandler implements EventHandler<MouseEvent> {
		private MenuButton btn2;
		private Color color2;

		public MenuButtonColorHandler(MenuButton btn2, Color color2) {
			this.btn2 = btn2;
			this.color2 = color2;
		}

		@Override
		public void handle(MouseEvent event) {
			btn2.setBackground(new Background(new BackgroundFill(color2, null, null)));

		}

	}

}
