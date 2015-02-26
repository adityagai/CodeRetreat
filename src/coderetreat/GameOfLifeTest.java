package coderetreat;

/**
 * @author adityagai
 *
 */
import static org.junit.Assert.*;

import java.util.List;

/**
 * @author adityagai
 *
 */
public class GameOfLifeTest {

	@org.junit.Test
	public void isNewCellNull() {
		Cell cell = new Cell();
		assertTrue(cell!=null);
	}
	
	@org.junit.Test
	public void isNewCellStateAlive(){
		Cell cell = new Cell();
		cell.setAlive(true);
		
		assertTrue(cell.isAlive() == true);
	}

	@org.junit.Test
	public void isNewCellStateDead(){
		Cell cell = new Cell();
		cell.setAlive(false);
		
		assertTrue(cell.isAlive() == false);
	}
	
	@org.junit.Test
	public void isGridNull(){
		Grid grid = new Grid(24);
		assertTrue(grid!=null);
	}
	
	@org.junit.Test
	public void doesGridHavePositiveDimension(){
		Grid grid = new Grid(24);
		
		assertTrue(grid.getDimensions()>0);
	}
	
	@org.junit.Test
	public void areNeighboursAliveMoreThanThree(){
		Grid grid = new Grid(3);
		Cell[][] cells = 
				    {{new Cell(0,0,true), new Cell(0,1,false), new Cell(0,2,true)},
					{new Cell(1,0,true), new Cell(1,1,true), new Cell(1,2,false)},
					{new Cell(2,0,true), new Cell(2,1,true), new Cell(2,2,true)}};
		
		grid.setUniverse(cells);
		List<Cell> neighbours = grid.getNeighbours(grid.getCell(1,1));
		int count = 0;
		for(Cell c : neighbours){
			if(c.isAlive())	count++;
		}
		assertTrue(count > 3);
	}
	
	@org.junit.Test
	public void checkCellAlive(){
		Grid grid = new Grid(3);
		Cell[][] cells = 
				    {{new Cell(0,0,true), new Cell(0,1,false), new Cell(0,2,true)},
					{new Cell(1,0,true), new Cell(1,1,false), new Cell(1,2,false)},
					{new Cell(2,0,true), new Cell(2,1,true), new Cell(2,2,true)}};
		
		grid.setUniverse(cells);
		Cell c = new Cell(1,2);
		assertTrue(grid.shouldAlive(c) == true);
	}
	
	@org.junit.Test
	public void checkCellDead(){
		Grid grid = new Grid(3);
		Cell[][] cells = 
				    {{new Cell(0,0,true), new Cell(0,1,false), new Cell(0,2,true)},
					{new Cell(1,0,true), new Cell(1,1,false), new Cell(1,2,false)},
					{new Cell(2,0,true), new Cell(2,1,true), new Cell(2,2,true)}};
		
		grid.setUniverse(cells);
		Cell c = new Cell(0,0);
		assertTrue(grid.shouldAlive(c) == false);
	}
	
	@org.junit.Test
	public void reachedStableState(){
		Grid grid = new Grid(3);
		Cell[][] cells = 
				    {{new Cell(0,0,true), new Cell(0,1,true), new Cell(0,2,true)},
					{new Cell(1,0,true), new Cell(1,1,true), new Cell(1,2,true)},
					{new Cell(2,0,true), new Cell(2,1,true), new Cell(2,2,true)}};
		
		grid.setUniverse(cells);	
		grid.evolve();
		// grid.displayUniverse();
	}

}
