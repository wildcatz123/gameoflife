/**
 * 
 */
package conwaygame;

import java.util.ArrayList;
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
	
	public static class Coordinate {
		
		public int x;
		public int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public List<Coordinate> getCoords() {
		return coords;
	}
	
	/**
	 * For testing if I have x and y the right way round.
	 * 
	 * @return A horizontal line.
	 */
	public static Shape testLine() {
		Shape line = new Shape();
		line.coords = new ArrayList<Coordinate>();
		line.coords.add(new Coordinate(10,10));
		line.coords.add(new Coordinate(11,10));
		line.coords.add(new Coordinate(12,10));
		line.coords.add(new Coordinate(13,10));
		return line;
	}
	
}
