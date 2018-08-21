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
	
	public static Shape glider() {
		Shape glider = new Shape();
		glider.coords = new ArrayList<Coordinate>();
		glider.coords.add(new Coordinate(10,10));
		glider.coords.add(new Coordinate(10,12));
		glider.coords.add(new Coordinate(9,12));
		glider.coords.add(new Coordinate(11,12));
		glider.coords.add(new Coordinate(11,11));
		return glider;
	}
	
	public static Shape spaceShip() {
		Shape ship = new Shape();
		ship.coords = new ArrayList<Coordinate>();
		ship.coords.add(new Coordinate(31,10));
		ship.coords.add(new Coordinate(30,11));
		ship.coords.add(new Coordinate(30,12));
		ship.coords.add(new Coordinate(30,13));
		ship.coords.add(new Coordinate(31,13));
		ship.coords.add(new Coordinate(32,13));
		ship.coords.add(new Coordinate(33,13));
		ship.coords.add(new Coordinate(34,12));
		ship.coords.add(new Coordinate(34,10));
		return ship;
	}
	
}
