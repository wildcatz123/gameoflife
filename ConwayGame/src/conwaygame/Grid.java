package conwaygame;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * A Grid object keeps track of a rectangular grid of Cell objects.
 * 
 * @author jonesgare1
 *
 */
public class Grid extends GridPane{
    private int height;//500
    private int width;//500
    private int cellWidth;//10
    private int cellHeight;//10
    private Cell[][] cells;
    
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		setCells(new Cell[height/cellWidth][width/cellHeight]);
	}

	public void initialFill() {
		for(int y = 0;y<height/cellHeight-5;y++) {
		for(int x = 0;x< width/cellWidth-5; x++) {
			if((x<5||x>54)&&(y<5||y>54)) {
				Cell c = new Cell(10,10,y,x,false);
				cells[y][x].setFill(Color.GRAY);
				cells[y][x].setStroke(Color.GREY);			
			}
			if((y>5&&y<55)&&(x>5&&x<55)) {
				cells[y][x].setAlive(false);
				cells[y][x].setFill(Color.WHITE);
				cells[y][x].setStroke(Color.BLACK);			

			}
		}
	}
}

/**
 * Fills the whole grid with cells, a random fix of alive and dead.
 * 
 * Should call provideNeighbours with each Cell as an argument after creating all the cells.
 */
public void randomFill() {
	for(int y = 0;y<height/cellHeight-5;y++) {
		for(int x = 0;x< width/cellWidth-5; x++) {
			int checkFill = (int)(Math.random()*30);
			if((y>5&&y<55)&&(x>5&&x<55)) {
			if(checkFill<1) {
				cells[y][x].setAlive(true);
				cells[y][x].setFill(Color.BLACK);
				cells[y][x].setStroke(Color.WHITE);	


			}
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
		//TODO: Implement
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	

}
