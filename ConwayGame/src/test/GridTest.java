package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import conwaygame.Cell;
import conwaygame.Grid;

public class GridTest {

	private Grid gridPane = new Grid(500,500);
	private Cell cell = new Cell(10,10,6,8,true);
	
	
	public GridTest() {
		// TODO Auto-generated constructor stub
		gridPane.getChildren().add(cell);
	}
	
	
	@Test
	/**
	 * test the provideNeighbours
	 */
	public void testProvideNeighbours() {
		gridPane.provideNeighbours(cell);
		int neighbourNum = cell.getNeighbours().size();
		assertEquals(neighbourNum,8);
	}
	
	@Test
	/**
	 * test the top left neighbours
	 */
	public void testTheTopLeftNeighbours() {
		Cell topLeftCell = new Cell(10,10,0,0,false);
		gridPane.provideNeighbours(topLeftCell);
		int neighbourNum = topLeftCell.getNeighbours().size();
		assertEquals(neighbourNum,3);
	}
	@Test
	/**
	 * test the initialFill method, when running this method, the grid will fill with dead cell 
	 * and part of them are always grey, part of them are white.
	 */
	public void testInitialFill() {
		gridPane.initialFill();
		boolean isAlive = false;
		for(Cell[] c :gridPane.getCells()) {
			for(Cell e: c) {
				isAlive = e.isAlive();
			}
		};
		assertEquals(isAlive,false);
	}
	@Test
	/**
	 * test the randomFill method
	 */
	public void testRandomFill() {
		gridPane.initialFill();
		gridPane.randomFill();
		int n = 0;
		for(Cell[] cellCol: gridPane.getCells()) {
			for(Cell cell: cellCol) {
				if(cell.isAlive())
				    n++;
			}
		}
		// make sure when randomFill the grid, the number of alive cell will be larger than 0
		assertEquals(n>0, true);
	}
	@Test
	/**
	 * test the update method
	 */
	public void testUpdate() {
        gridPane.initialFill();
        Cell[][] cells = gridPane.getCells();
        Cell cellUpdate = cells[6][8];
        cellUpdate.setAlive(true);
        gridPane.update();
        assertEquals(cellUpdate.isAlive(), false);
	}
	
}
