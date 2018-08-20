import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int x;// display the x position
    private int y;// display the y position
    private boolean isAlive;
    private List<Cell> neighbours;// store the neighbours
    
	public Cell(int x, int y, boolean isAlive) {
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}

}
