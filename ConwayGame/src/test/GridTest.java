/*package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import conwaygame.Cell;
import conwaygame.Grid;
import javafx.scene.layout.GridPane;

public class GridTest {

	private Grid gridPane = new Grid(500,500);
	private Cell cell = new Cell(10,10,6,8,true);
	private Cell neighbour1 = new Cell(10,10,5,8,false);
	private Cell neighbour2 = new Cell(10,10,6,7,false);
	private Cell neighbour3 = new Cell(10,10,7,7,false);
	private Cell neighbour4 = new Cell(10,10,5,8,false);
	private Cell neighbour5 = new Cell(10,10,7,8,false);
	private Cell neighbour6 = new Cell(10,10,5,9,false);
	private Cell neighbour7 = new Cell(10,10,6,9,false);
	private Cell neighbour8 = new Cell(10,10,7,9,false);
	
	public GridTest() {
		// TODO Auto-generated constructor stub
		gridPane.getChildren().add(cell);
	}
	
	
	@Test
	*//**
	 * test the provideNeighbours
	 *//*
	public void testProvideNeighbours() {
		gridPane.provideNeighbours(cell);
		int neighbourNum = cell.getNeighbours().size();
		assertEquals(neighbourNum,8);
	}
	
	@Test
	*//**
	 * test the top left neighbours
	 *//*
	public void testTheTopLeftNeighbours() {
		Cell topLeftCell = new Cell(10,10,0,0,false);
		gridPane.provideNeighbours(topLeftCell);
		int neighbourNum = cell.getNeighbours().size();
		assertEquals(neighbourNum,3);
	}
	@Test
	*//**
	 * test the initialFill method, when running this method, the grid will fill with dead cell 
	 * and part of them are always grey, part of them are white.
	 *//*
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
	*//**
	 * test the randomFill method
	 *//*
	public void testRandomFill() {
		
	}
	@Test
	*//**
	 * test the update method
	 *//*
	public void testUpdate() {
		
	}
	
}
*/