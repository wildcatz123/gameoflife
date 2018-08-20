package conwaygame;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * A Cell object represents a single cell in the grid of Conway's Game of Life.
 * It keeps track of its neighbours and whether it is alive or dead.
 * 
 * @author jonesgare1
 *
 */
public class Cell extends Rectangle{
    private int xPos;// display the x position
    private int yPos;// display the y position
    private boolean isAlive;
    private boolean willBeAlive; //Whether this cell should be alive in the next frame.
    private List<Cell> neighbours;// store the neighbours
    
	public Cell(int width, int height, int x, int y, boolean isAlive) {
		super(width, height);
		this.xPos = x;
		this.yPos = y;
		this.setAlive(isAlive);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
		if (isAlive) {
			setFill(Color.BLACK);
		} else {
			setFill(Color.WHITE);
		}
	}
   
	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

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
		int aliveNeighbours = 0;
		
		for (Cell c : neighbours) {
			if (c.isAlive) aliveNeighbours++;
		}

		if(this.isAlive==true) {
			if(aliveNeighbours<2) {
				this.willBeAlive = false;
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
