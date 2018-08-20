package conwaygame;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.GridPane;

/**
 * A Grid object keeps track of a rectangular grid of Cell objects.
 * 
 * @author jonesgare1
 *
 */
public class Grid extends GridPane{
    private int height;
    private int width;
    private Cell[][] cells;
    
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		cells = new Cell[height][width];
	}
	
	/**
	 * Fills the whole grid with cells, a random fix of alive and dead.
	 * 
	 * Should call provideNeighbours with each Cell as an argument after creating all the cells.
	 */
	public void randomFill() {
		//TODO: Implement
	}
	
	/**
	 * Applies the rules of Conway's Game of Life to update the grid.
	 * 
	 * Should call prepareForUpdate() on each Cell, then call update() on each Cell.
	 */
	public void update() {
		//TODO: Implement
	}
	
	/**
	 * Finds all the adjacent Cells to a given Cell and stores them.
	 * 
	 * Stores them using c.setNeighbours.
	 * 
	 * @param c The Cell that needs its neighbours provided.
	 */
	public void provideNeighbours(Cell c) {
		List<Cell> neighbours = new ArrayList<Cell>(8);
		
		//Left column
		if (c.getXPos() > 0) {
			if (c.getYPos() > 0) {
				neighbours.add(cells[c.getYPos()-1][c.getXPos()-1]);
			}
			neighbours.add(cells[c.getYPos()][c.getXPos()-1]);
			if (c.getYPos() < height - 1) {
				neighbours.add(cells[c.getYPos()+1][c.getXPos()-1]);
			}
		}
		
		//Central column
		if (c.getYPos() > 0) {
			neighbours.add(cells[c.getYPos()-1][c.getXPos()]);
		}
		if (c.getYPos() < height - 1) {
			neighbours.add(cells[c.getYPos()+1][c.getXPos()]);
		}
		
		//Right column
		if (c.getXPos() < width - 1) {
			if (c.getYPos() > 0) {
				neighbours.add(cells[c.getYPos()-1][c.getXPos()+1]);
			}
			neighbours.add(cells[c.getYPos()][c.getXPos()+1]);
			if (c.getYPos() < height - 1) {
				neighbours.add(cells[c.getYPos()+1][c.getXPos()+1]);
			}
		}
		
		c.setNeighbours(neighbours);
	}

}
