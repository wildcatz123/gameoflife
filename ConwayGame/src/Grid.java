
/**
 * A Grid object keeps track of a rectangular grid of Cell objects.
 * 
 * @author jonesgare1
 *
 */
public class Grid {
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
		//TODO: Implement
	}

}
