package conwaygame;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * A Grid object keeps track of a rectangular grid of Cell objects.
 * 
 * @author jonesgare1
 *
 */
public class Grid extends GridPane{
	private int height;	//set to 500 when instantiated in Game
	private int width;	//set to 500 when instantiated in Game
	private int cellWidth = 10;	//10 - width of single rectangular cell
	private int cellHeight = 10;//10 - height of single rectangular cell
	private Cell[][] cells;		//2D Array storing all cells in the grid
	private Color fill = Color.BLACK;	//Default alive cell fill color
	private Color stroke = Color.WHITE;	//Default alive cell stroke color
	
	//Constructor
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		setCells(new Cell[height/cellHeight][width/cellWidth]);
	}

	/**
	 * Runs when the game window opens or the game is restarted. Initialises the game by populating
	 * every coordinate on the viewable game grid with cells.  Also greys out
	 * cells in the 5 cell wide border surrounding the game viewer.
	 */
	public void initialFill() {
		for(int y = 0;y<height/cellHeight;y++) {  //starting at 0,0 iterate through every position to add rectangular cells
			for(int x = 0;x< width/cellWidth; x++) {
				Cell c = new Cell(cellWidth,cellHeight,x,y,false);

				this.add(c, x, y);  //add a cell with its x and y coordinate
				cells[y][x] = c;	//add current cell to the 2D Array
				if((x<5||x>45)||(y<5||y>45)) {  	//This block sets cells outside the viewable game grid to grey
					cells[y][x].setFill(Color.GREY);
					cells[y][x].setStroke(Color.GREY);			
				}
				if((y>=5&&y<=45)&&(x>=5&&x<=45)) {	//And to treat cells in the viewable game grid as dead until a user
					cells[y][x].setAlive(false);	//generated fill is initiated						
				}
			}

		}
		for(int y = 0;y<height/cellHeight;y++) {	//iterate through the newly created grid of cells
			for(int x = 0;x< width/cellWidth; x++) {
				provideNeighbours(cells[y][x]);		//run provideNeighbours() on every cell in the grid
			}
		}
	}

	/**
	 * The following 3 methods setAllGreen(), setAllBlue() and setAllPink()
	 * Provide the colour change functionality for the Button Colour Event Handlers
	 * and associated dropdown menu in the UI of the Game class
	 */
	//Sets current colour of alive cells in the game to green
	public void setAllGreen() {
		this.fill = Color.CHARTREUSE;
		this.stroke = Color.BLACK;
		System.out.println("Green Color");
		for(int y = 5;y<=height/cellHeight-5;y++) {
			for(int x = 5;x<=width/cellWidth-5; x++) {
				cells[y][x].changeColor(fill, stroke);
			}
		}
	}
	
	//Sets current colour of alive cells in the game to blue
	public void setAllBlue() {
		this.fill = Color.BLUE;
		this.stroke = Color.BLACK;
		for(int y = 5;y<=height/cellHeight-5;y++) {
			for(int x = 5;x<= width/cellWidth-5; x++) {
				cells[y][x].changeColor(fill, stroke);
			}
		}
	}
	
	//Sets current colour of alive cells in the game to pink
	public void setAllPink() {
		this.fill = Color.PINK;
		this.stroke = Color.BLACK;
		for(int y = 5;y<=height/cellHeight-5;y++) {
			for(int x = 5;x<= width/cellWidth-5; x++) {
				cells[y][x].changeColor(fill, stroke);
			}
		}
	}

	/**
	 * Fills the whole grid with cells, a random mix of alive and dead. Called by 'Random Fill' button in Game.
	 * This is one of the 3 options for user generated cells in the grid, the others being 
	 * setCellEvent() and the Shape Button Handlers and associated drop down menu in the Game class
	 * 
	 * Should call provideNeighbours() with each Cell as an argument after creating all the cells.
	 */
	public void randomFill() {
		for(int y = 5;y<height/cellHeight-5;y++) {
			for(int x = 5;x< width/cellWidth-5; x++) {
				int checkFill = (int)(Math.random()*30); //
					if(checkFill<1) {
						cells[y][x].setAlive(true);
					}
			}
		}
	}

	/**
	 * Applies the rules of Conway's Game of Life to update the grid.
	 * 
	 * Should call prepareForUpdate() on each Cell, then call update() on each Cell.
	 */
	public void update() {
		for (Cell[] column : cells) {	//Iterate over all cells
			for (Cell c : column) {
				c.prepareForUpdate();	//Apply Conway's rules to all cells
			}
		}
		for (Cell[] column : cells) {
			for (Cell c : column) {
				c.update();				//All cells that prepareForUpdate() deemed should live in the next iteration
			}							//appear as live cells in the next iteration as per update()
		}
	}

	/**
	 * Finds all the adjacent Cells to a given Cell and stores them.
	 * 
	 * Stores them using c.setNeighbours.
	 * 
	 * @param c The Cell that needs its neighbours provided.
	 */
	public void provideNeighbours(Cell c) {
		List<Cell> neighbours = new ArrayList<Cell>(8);  //List contents will be up to 8 depending on location
														//within grid.  Method accounts for X and Y values
		//Left column									//that clash with our self imposed boundary of the viewable grid.
		if (c.getXPos() > 0) {
			if (c.getYPos() > 0) {
				neighbours.add(cells[c.getYPos()-1][c.getXPos()-1]);
			}
			neighbours.add(cells[c.getYPos()][c.getXPos()-1]);
			if (c.getYPos() < height/cellHeight - 1) {
				neighbours.add(cells[c.getYPos()+1][c.getXPos()-1]);
			}
		}

		//Central column
		if (c.getYPos() > 0) {
			neighbours.add(cells[c.getYPos()-1][c.getXPos()]);
		}
		if (c.getYPos() < height/cellHeight - 1) {
			neighbours.add(cells[c.getYPos()+1][c.getXPos()]);
		}

		//Right column
		if (c.getXPos() < width/cellWidth - 1) {
			if (c.getYPos() > 0) {
				neighbours.add(cells[c.getYPos()-1][c.getXPos()+1]);
			}
			neighbours.add(cells[c.getYPos()][c.getXPos()+1]);
			if (c.getYPos() < height/cellHeight - 1) {
				neighbours.add(cells[c.getYPos()+1][c.getXPos()+1]);
			}
		}

		c.setNeighbours(neighbours);  //After the iteration through all possible adjacent cells add neighbours to List
	}

	//Accessor method for 2D array of cells
	public Cell[][] getCells() {
		return cells;
	}

	//Setter for cells 2D array
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	/**
	 * The shape dropdown menu and handlers in the Game UI trigger this method to populate
	 * the viewable grid with the shape objects defined in the Shape class
	 * 
	 * @param s The selected shape of live cells to be added to the grid
	 */
	public void addShape(Shape s) {
		for (Shape.Coordinate coord : s.getCoords()) {
			cells[coord.y][coord.x].setAlive(true);
		}
	}
	
	/**
	 * Pressing the 'Clear' button in the Game UI runs this method that reinitialises the game viewable grid
	 * to a clear grid with no live cells.  
	 */
	public void clearAll() {
		for(int y = 0;y<height/cellHeight;y++) {
			for(int x = 0;x< width/cellWidth; x++) {
				Cell c = cells[y][x];
				c.setAlive(false);
				c.setWillBeAlive(false);
			}
		}
	}

	/**
	 * This method is an extended feature that is not currently fully implemented though remains an option in the UI
	 * 
	 * The intention if time allows is to allow the user to set the color of the animations
	 * by selecting from a colour picker in addition to the current options in the dropdown menu
	 */
	public void pickColor() {
		ColorPicker colorPick = new ColorPicker();
		Color color = colorPick.getValue();
		for(int y = 5;y<height/cellHeight-5;y++) {
			for(int x = 5;x< width/cellWidth-5; x++) {
				if(cells[y][x].isAlive()==true) {
					cells[y][x].setCellFill(color);	
					cells[y][x].setCellStroke(Color.BLACK);	
				}

			}
		}
	}

}
