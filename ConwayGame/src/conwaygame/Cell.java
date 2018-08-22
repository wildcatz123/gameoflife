package conwaygame;

import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * A Cell object represents a single cell in the grid of Conway's Game of Life.
 * It keeps track of its neighbours and whether its current state is alive or dead,
 * and based on Conway's rules whether its state in the next frame will be alive or dead.
 * 
 * @author jonesgare1
 *
 */
public class Cell extends Rectangle{
    private int xPos;	// display the x position
    private int yPos;	// display the y position
    private boolean isAlive;	//Cells current state is alive and represented by a non-white colour in the viewable grid
    private boolean willBeAlive; 	//Whether this cell should be alive in the next frame.
    private List<Cell> neighbours;	// store the (up to 8) neighbours of the target cell in this ArrayList
    private Color cellStroke = Color.WHITE;		//single cell border for an alive cell
    private Color cellFill = Color.BLACK;		//single cell fill colour for an alive cell


    //Constructor
	public Cell(int width, int height, int x, int y, boolean isAlive) {
		super(width, height);
		this.xPos = x;
		this.yPos = y;
		this.setAlive(isAlive);
	}

	//Getters and Setters
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * Sets cells to alive and dictates the appearance of alive or dead cells in the viewable grid
	 * 
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
		if ((xPos>=5&&xPos<=45)&&(yPos>=5&&yPos<=45)) {  //these numbers refer to number of cell/grids in the
			if (isAlive) {								//viewable grid window 
				setFill(cellFill);		
				setStroke(cellStroke);				//live cells are filled with black (or a colour) and a white border
			} else {
				setFill(Color.WHITE);
				setStroke(Color.BLACK);				//dead cells appear as empty white cells with a black border
			}
		}
	}
	
	//If this is true of a targeted cell then the cell will be alive in the next iteration on update()
	public void setWillBeAlive(boolean willBeAlive) {
		this.willBeAlive = willBeAlive;
	}
   
	//Method that allows the changing of cell/grid colour appearance based on state
	public void changeColor(Color fill, Color stroke) {
		this.cellFill = fill;
		this.cellStroke = stroke;
	}

	//Grid lines getter
	public Color getCellStroke() {
		return cellStroke;
	}
	
	//Grid lines setter
	public void setCellStroke(Color cellStroke) {
		this.cellStroke = cellStroke;
	}

	public Color getCellFill() {
		return cellFill;
	}

	public void setCellFill(Color cellFill) {
		this.cellFill = cellFill;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}
	
	//Accessor method to the neighbours ArrayList
	public List<Cell> getNeighbours() {
		return neighbours;
	}
	
	/**
	 * Sets the neighbours of this cell.
	 * 
	 * Should be run once by the Grid class, once all the cells have been created.
	 * 
	 * @param neighbours The up-to-8 Cells adjacent to this cell
	 */
	public void setNeighbours(List<Cell> neighbours) {
		this.neighbours = neighbours;
	}
	
	/**
	 * Calculate the correct value of willBeAlive.
	 * 
	 * Applies the rules of Conway's Game of Life, based on the isAlive field of neighbours.
	 */
	public void prepareForUpdate() {  
		int aliveNeighbours = 0;	//the count of neighbours that will be incremented by the number of
									//live neighbours adjacent to the target cell.
		
		for (Cell c : neighbours) {
			if (c.isAlive) aliveNeighbours++;  	//increment aliveNeighbours
		}

		if(this.isAlive==true) {				//this if/else block applies Conway's rules that
			if(aliveNeighbours<2) {				//determine whether the target cell lives/dies in the
				this.willBeAlive = false;		//next iteration
			}else if(aliveNeighbours < 4){
				this.willBeAlive = true;
			}else {
				this.willBeAlive = false;
			}
		}else {
			if(aliveNeighbours == 3) {
				this.willBeAlive = true;
			}
		}
	}
	
	/**
	 * Sets the current state to the next state.
	 * 
	 * Always run prepareForUpdate() on all Cells before calling this.
	 */
	public void update() {
		setAlive(willBeAlive);
	}

}
