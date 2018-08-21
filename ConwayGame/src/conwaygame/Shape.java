/**
 * 
 */
package conwaygame;

import java.util.List;

/**
 * A Shape object contains a list of (x,y) coordinates.
 * 
 * Taken together, these coordinates describe a shape of living Cells on a Conway's Game of Life grid.
 * This class has static methods that produce particular shapes with interesting behaviors.
 * 
 * @author jonesgare1
 *
 */
public class Shape {
	
	private List<Coordinate> coords;
	
	public class Coordinate {
		public int x;
		public int y;
	}

	public List<Coordinate> getCoords() {
		return coords;
	}
	
}
