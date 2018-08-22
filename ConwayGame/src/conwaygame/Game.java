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

public class Game extends Application {
	/*
	 * private int width = 500; // scene width private int height = 500 + 100;//
	 * scene height
	 */
	private Grid grids = new Grid(500, 500);
	private Timeline timeline;
	private String speed = "Fast";
	private KeyFrame keyFrame;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public void updateTimeline(String speed) { // speed e.g. "Fastest" //
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
		// EventHandler<ActionEvent>eventHandler = getEventHandler();
		keyFrame = new KeyFrame(duration, t -> grids.update());
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);

		if (wasPlaying)
			timeline.play();
	}

	@Override
	/**
	 * the stage of the game
	 */
	public void start(Stage primaryStage) throws Exception {
		// Initialize the game
		grids.initialFill();

		// basic UI button creation
		Button clear = new Button("CLEAR");
		clear.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		clear.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		clear.setOnMouseEntered(new ButtonColorHandler(clear, Color.SILVER));
		clear.setOnMouseExited(new ButtonColorHandler(clear, Color.CORNFLOWERBLUE));

		Button play = new Button("PLAY");
		play.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		play.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		play.setOnMouseEntered(new ButtonColorHandler(play, Color.SILVER));
		play.setOnMouseExited(new ButtonColorHandler(play, Color.CORNFLOWERBLUE));

		Button randomFill = new Button("RANDOM FILL");
		randomFill.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		randomFill.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		randomFill.setOnMouseEntered(new ButtonColorHandler(randomFill, Color.SILVER));
		randomFill.setOnMouseExited(new ButtonColorHandler(randomFill, Color.CORNFLOWERBLUE));

		Button stop = new Button("STOP");
		stop.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		stop.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		stop.setOnMouseEntered(new ButtonColorHandler(stop, Color.SILVER));
		stop.setOnMouseExited(new ButtonColorHandler(stop, Color.CORNFLOWERBLUE));

		Button exit = new Button("EXIT");
		exit.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		exit.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		exit.setOnMouseEntered(new ButtonColorHandler(exit, Color.SILVER));
		exit.setOnMouseExited(new ButtonColorHandler(exit, Color.CORNFLOWERBLUE));

		CheckMenuItem shape1 = new CheckMenuItem("TEST LINE");
		CheckMenuItem shape2 = new CheckMenuItem("GLIDER");
		CheckMenuItem shape3 = new CheckMenuItem("SPACESHIP");
		CheckMenuItem shape4 = new CheckMenuItem("GLIDERGUN");
		shape1.setSelected(false);
		shape2.setSelected(false);
		shape3.setSelected(false);
		shape4.setSelected(false);
		shape1.setAccelerator(new KeyCodeCombination(KeyCode.B,KeyCodeCombination.SHORTCUT_DOWN));
		shape2.setAccelerator(new KeyCodeCombination(KeyCode.U,KeyCodeCombination.SHORTCUT_DOWN));
		shape3.setAccelerator(new KeyCodeCombination(KeyCode.I,KeyCodeCombination.SHORTCUT_DOWN));
		shape4.setAccelerator(new KeyCodeCombination(KeyCode.O,KeyCodeCombination.SHORTCUT_DOWN));
		MenuButton shapeButton = new MenuButton("CHOOSE SHAPES", null, shape1, shape2, shape3, shape4);
		shapeButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		shapeButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		shapeButton.setOnMouseEntered(new MenuButtonColorHandler(shapeButton, Color.SILVER));
		shapeButton.setOnMouseExited(new MenuButtonColorHandler(shapeButton, Color.CORNFLOWERBLUE));

		
		CheckMenuItem slowSpeed = new CheckMenuItem("SLOW");
		CheckMenuItem medSpeed = new CheckMenuItem("MEDIUM ");
		CheckMenuItem fastSpeed = new CheckMenuItem("FAST");
		CheckMenuItem fastestSpeed = new CheckMenuItem("FASTEST");
		slowSpeed.setSelected(false);
		medSpeed.setSelected(false);
		fastSpeed.setSelected(false);
		fastestSpeed.setSelected(false);
		slowSpeed.setAccelerator(new KeyCodeCombination(KeyCode.W,KeyCodeCombination.SHORTCUT_DOWN));
		medSpeed.setAccelerator(new KeyCodeCombination(KeyCode.E,KeyCodeCombination.SHORTCUT_DOWN));
		fastSpeed.setAccelerator(new KeyCodeCombination(KeyCode.R,KeyCodeCombination.SHORTCUT_DOWN));
		fastestSpeed.setAccelerator(new KeyCodeCombination(KeyCode.T,KeyCodeCombination.SHORTCUT_DOWN));
		MenuButton speedButton = new MenuButton("SPEED", null, slowSpeed, medSpeed, fastSpeed, fastestSpeed);
		speedButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		speedButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		speedButton.setOnMouseEntered(new MenuButtonColorHandler(speedButton, Color.SILVER));
		speedButton.setOnMouseExited(new MenuButtonColorHandler(speedButton, Color.CORNFLOWERBLUE));
		
		
		
		CheckMenuItem color1 = new CheckMenuItem("BLUE");
		CheckMenuItem color2 = new CheckMenuItem("GREEN");
		CheckMenuItem color3 = new CheckMenuItem("PINK");
		CheckMenuItem color4 = new CheckMenuItem("COLOUR PICKER");
		color1.setSelected(false);
		color2.setSelected(false);
		color3.setSelected(false);
		color4.setSelected(false);
		color1.setAccelerator(new KeyCodeCombination(KeyCode.A,KeyCodeCombination.SHORTCUT_DOWN));
		color2.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCodeCombination.SHORTCUT_DOWN));
		color3.setAccelerator(new KeyCodeCombination(KeyCode.D,KeyCodeCombination.SHORTCUT_DOWN));
		color4.setAccelerator(new KeyCodeCombination(KeyCode.F,KeyCodeCombination.SHORTCUT_DOWN));
		MenuButton colorButton = new MenuButton("COLOUR", null, color1, color2, color3, color4);
		colorButton.setFont(Font.font("Aldhabi", FontWeight.BOLD, FontPosture.ITALIC, 13));
		colorButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		colorButton.setOnMouseEntered(new MenuButtonColorHandler(colorButton, Color.SILVER));
		colorButton.setOnMouseExited(new MenuButtonColorHandler(colorButton, Color.CORNFLOWERBLUE));

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
				timeline.play();
				System.out.println("Play Button press");
			}
		});

		// the Start button Handler
		randomFill.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				grids.randomFill();
				System.out.println("Random Fill Button press");
			}
		});

		// the Stop button Handler
		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				timeline.pause();
				System.out.println("Stop Button press");
			}
		});
		// the Exit button Handler
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Exit Button press");
				Platform.exit();

			}
		});

		// Speed Button Handlers______________________

		speedButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println(" Speed Button press");
			}
		});

		slowSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Slow";
				updateTimeline(speed);
			}
		});

		medSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Medium";
				updateTimeline(speed);
			}
		});

		fastSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Fast";
				updateTimeline(speed);
			}
		});

		fastestSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				speed = "Fastest";
				updateTimeline(speed);
			}
		});

		// Shape Button Handlers______________________

		shapeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Speed Button press");
			}
		});

		shape1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.testLine());
			}
		});

		shape2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.glider());
			}
		});

		shape3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.spaceShip());
			}
		});

		shape4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.addShape(Shape.gliderGun());
			}
		});
		// _______________Colour Button Hnadler______

		colorButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Colour Button  press");
			}
		});

		color1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllBlue();
				System.out.println("Colour 1  selected");
			}
		});

		color2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllGreen();
				System.out.println("Colour 2  selected");
			}
		});

		color3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.setAllPink();
				System.out.println("Colour 3 selected");
			}
		});

		color4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				grids.pickColor();
				System.out.println("Colour 4 selected(eww Picky Basterd!)");
			}
		});

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
		// add some condition to set the speed mode
		// updateTimeline();
		updateTimeline(this.speed);
		primaryStage.setScene(scene);
		primaryStage.show();
		setCellEvent();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void clearButton() {
		grids.clearAll();
	}

	/**
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
