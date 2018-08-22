package test;

import conwaygame.Cell;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class CellTest {
	private Cell cell = new Cell(10,10,6,8,true);
	private Cell neighbour1 = new Cell(10,10,5,8,false);
	private Cell neighbour2 = new Cell(10,10,6,7,false);
	private Cell neighbour3 = new Cell(10,10,7,7,false);
	private Cell neighbour4 = new Cell(10,10,5,8,false);
	private Cell neighbour5 = new Cell(10,10,7,8,false);
	private Cell neighbour6 = new Cell(10,10,5,9,false);
	private Cell neighbour7 = new Cell(10,10,6,9,false);
	private Cell neighbour8 = new Cell(10,10,7,9,false);
	private List<Cell> neighbours = new ArrayList<Cell>();


	@Before
	public void setup() {
		neighbours.add(neighbour1);
		neighbours.add(neighbour2);
		neighbours.add(neighbour3);
		neighbours.add(neighbour4);
		neighbours.add(neighbour5);
		neighbours.add(neighbour6);
		neighbours.add(neighbour7);
		neighbours.add(neighbour8);
	}

	public List<Cell> createAliveNeighbours(int n) {
		for(int i=0; i<n;i++) {
			neighbours.get(i).setAlive(true);
		}
		return neighbours;
	}
	
	public void testNextStage(boolean isAlive, int neighboursNum, boolean lifeStatus) {
		cell.setAlive(isAlive);
		cell.setNeighbours(createAliveNeighbours(neighboursNum));
		cell.prepareForUpdate();
		cell.update();
		assertEquals(cell.isAlive(),lifeStatus);
	}
	@Test
	public void testAlive() {
		assertEquals(cell.isAlive(), true);
	}

	@Test
	public void testDead() {
		cell.setAlive(false);
		assertEquals(cell.isAlive(),false);
	}

	@Test
	*//**
	 * test good population
	 *//*
	public void testAliveAnd2Neighbours(){
		testNextStage(true, 2, true);
	}

	@Test
	*//**
	 * test under population
	 *//*
	public void testAliveAnd1Neighbours() {
		testNextStage(true,1,false);
	}
	@Test
	*//**
	 * test over population
	 *//*
	public void testAliveAnd4Neighbours(){
		testNextStage(true, 4, false);
	}
	
	@Test
	*//**
	 * test reproduction.
	 *//*
	public void testDeadAnd3Neighbours() {
		testNextStage(false,3,true);
	}

	@Test
	*//**
	 * test not reproduction
	 *//*
	public void testDeadAnd2Neighbours() {
		testNextStage(false,2,false);
	}
	
}