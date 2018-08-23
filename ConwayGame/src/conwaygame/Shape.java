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
	 * For testing if x and y are the right way round.
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
	
	public static Shape gliderGun() {
		Shape gliderGun = new Shape();
		gliderGun.coords = new ArrayList<Coordinate>();
		gliderGun.coords.add(new Coordinate(7,17));
		gliderGun.coords.add(new Coordinate(8,17));
		gliderGun.coords.add(new Coordinate(7,18));
		gliderGun.coords.add(new Coordinate(8,18));
		gliderGun.coords.add(new Coordinate(17,17));
		gliderGun.coords.add(new Coordinate(17,18));
		gliderGun.coords.add(new Coordinate(17,19));
		gliderGun.coords.add(new Coordinate(18,16));
		gliderGun.coords.add(new Coordinate(18,20));
		gliderGun.coords.add(new Coordinate(19,15));
		gliderGun.coords.add(new Coordinate(20,15));
		gliderGun.coords.add(new Coordinate(19,21));
		gliderGun.coords.add(new Coordinate(20,15));
		gliderGun.coords.add(new Coordinate(20,21));
		gliderGun.coords.add(new Coordinate(21,18));
		gliderGun.coords.add(new Coordinate(22,16));
		gliderGun.coords.add(new Coordinate(22,20));
		gliderGun.coords.add(new Coordinate(23,17));
		gliderGun.coords.add(new Coordinate(23,18));
		gliderGun.coords.add(new Coordinate(23,19));
		gliderGun.coords.add(new Coordinate(24,18));
		gliderGun.coords.add(new Coordinate(27,15));
		gliderGun.coords.add(new Coordinate(27,16));
		gliderGun.coords.add(new Coordinate(27,17));
		gliderGun.coords.add(new Coordinate(28,15));
		gliderGun.coords.add(new Coordinate(28,16));
		gliderGun.coords.add(new Coordinate(28,17));
		gliderGun.coords.add(new Coordinate(29,14));
		gliderGun.coords.add(new Coordinate(29,18));
		gliderGun.coords.add(new Coordinate(31,13));
		gliderGun.coords.add(new Coordinate(31,14));
		gliderGun.coords.add(new Coordinate(31,18));
		gliderGun.coords.add(new Coordinate(31,19));
		gliderGun.coords.add(new Coordinate(41,15));
		gliderGun.coords.add(new Coordinate(41,16));
		gliderGun.coords.add(new Coordinate(42,15));
		gliderGun.coords.add(new Coordinate(42,16));
		
		return gliderGun;
	}
}
