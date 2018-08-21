package conwaygame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
	/*
	 * private int width = 500; // scene width private int height = 500 + 100;//
	 * scene height
	 */ private Grid grids = new Grid(500, 500);

	public Game() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * the stage of the game
	 */
	public void start(Stage primaryStage) throws Exception {

		// Initialize the game

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

		MenuItem shape1 = new MenuItem("Shape 1");
		MenuItem shape2 = new MenuItem("shape 2");
		MenuItem shape3 = new MenuItem("Shape 3");
		MenuButton menuButton = new MenuButton("Shape Choose", null, shape1, shape2, shape3);
		menuButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		menuButton.setOnMouseEntered(new MenuButtonColorHandler(menuButton, Color.MEDIUMSEAGREEN));
		menuButton.setOnMouseExited(new MenuButtonColorHandler(menuButton, Color.KHAKI));

		MenuItem slowSpeed = new MenuItem("Slow");
		MenuItem medSpeed = new MenuItem("Medium");
		MenuItem fastSpeed = new MenuItem("Fast");
		MenuButton speedButton = new MenuButton("Speed", null, slowSpeed, medSpeed, fastSpeed);
		speedButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		speedButton.setOnMouseEntered(new MenuButtonColorHandler(speedButton, Color.MEDIUMSEAGREEN));
		speedButton.setOnMouseExited(new MenuButtonColorHandler(speedButton, Color.KHAKI));

		MenuItem color1 = new MenuItem("color1");
		MenuItem color2 = new MenuItem("color1");
		MenuItem color3 = new MenuItem("Color2");
		MenuItem color4 = new MenuItem("Colour Picker");
		MenuButton colorButton = new MenuButton("Clour", null, color1, color2, color3, color4);
		colorButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));
		colorButton.setOnMouseEntered(new MenuButtonColorHandler(colorButton, Color.MEDIUMSEAGREEN));
		colorButton.setOnMouseExited(new MenuButtonColorHandler(colorButton, Color.KHAKI));

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
				System.out.println("Random Fill Button press");
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
		// the Exit button Handler
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Exit Button press");
				Platform.exit();

			}
		});

		// ____________Chooser button Handler______

		menuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Choose Button press");
			}
		});

		slowSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Shape 1 selected");
			}
		});

		medSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("shape2  selected");
			}
		});

		fastSpeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("shape 3 selected(God Damn!! stop)");
			}
		});

		// _______________Speed Button Hnadler______

		menuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Speed Button press");
			}
		});

		shape1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("speed 1 selected");
			}
		});

		shape2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("speed 2  selected");
			}
		});

		shape3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("speed 3 selected(Oii! Slow down)");
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
						System.out.println("Colour 1  selected");
					}
				});

				color2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("Colour 2  selected");
					}
				});

				color3.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("Colour 3 selected(God Damn!! stop)");
					}
				});
				
				color3.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("Colour 4 selected(eww Picky Basterd!)");
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// ____________________Colour Button Handler

		// stage > scene > VBox
		// VBox contains GridPane for display the grid and HBox to display the
		// control panel.
		primaryStage.setTitle("Conway Game!!");
		BorderPane root = new BorderPane();
		Separator sep = new Separator();
		HBox controlPanel = new HBox(10, menuButton, randomFill, play, stop, clear, exit);
		HBox controlPane2 = new HBox(10, speedButton, colorButton, exit);
		VBox hboxHolder = new VBox(sep, controlPanel, controlPane2);
		controlPanel.setPadding(new Insets(10));
		controlPanel.setAlignment(Pos.CENTER);
		controlPane2.setPadding(new Insets(10));
		controlPane2.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		root.setCenter(grids);
		root.setBottom(hboxHolder);
		Scene scene = new Scene(root, 550, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	// all the methods

	public void clearButton() {
		// grids.getChildren().clear();
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
