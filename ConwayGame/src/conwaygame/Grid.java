package conwaygame;

import java.util.ArrayList;
import java.util.List;

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
    private int cellWidth =10;//10
    private int cellHeight = 10;//10
    private Cell[][] cells;
    
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		setCells(new Cell[height/cellWidth][width/cellHeight]);
	}

	public void initialFill() {
		for(int y = 0;y<height/cellHeight;y++) {
		for(int x = 0;x< width/cellWidth; x++) {
			Cell c = new Cell(10,10,x,y,false);
			this.add(c, x, y);
			cells[y][x] = c;
			if((x<5||x>45)||(y<5||y>45)) {
				// to do 
				cells[y][x].setFill(Color.GREY);
				cells[y][x].setStroke(Color.GREY);			
			}
			if((y>=5&&y<=45)&&(x>=5&&x<=45)) {
				cells[y][x].setFill(Color.WHITE);
				cells[y][x].setStroke(Color.BLACK);			

			}
		}
		
	}
		for(int y = 0;y<height/cellHeight;y++) {
			for(int x = 0;x< width/cellWidth; x++) {
				provideNeighbours(cells[y][x]);
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
		for (Cell[] column : cells) {
			for (Cell c : column) {
				c.prepareForUpdate();
			}
		}
		for (Cell[] column : cells) {
			for (Cell c : column) {
				c.update();
			}
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
		List<Cell> neighbours = new ArrayList<Cell>(8);
		
		//Left column
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
		
		c.setNeighbours(neighbours);
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	

}
