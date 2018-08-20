import java.util.List;

/**
 * A Cell object represents a single cell in the grid of Conway's Game of Life.
 * It keeps track of its neighbours and whether it is alive or dead.
 * @author jonesgare1
 *
 */
public class Cell {
    private int x;// display the x position
    private int y;// display the y position
    private boolean isAlive;
    private boolean willBeAlive; //Whether this cell should be alive in the next frame.
    private List<Cell> neighbours;// store the neighbours
    
	public Cell(int x, int y, boolean isAlive) {
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

}
