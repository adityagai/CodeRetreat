package coderetreat;

/**
 * @author adityagai
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Grid {
	private Cell[][] universe;
	private int dimensions;
	
	public Grid(int dimensions){
		this.dimensions = dimensions;
		this.universe = createDefaultCells(this.dimensions);
	}
	
	public Cell[][] createDefaultCells(int dim){
		Cell[][] univ = new Cell[dim][dim];
		for(int i=0; i< dim; i++){
			for (int j=0; j< dim; j++){
				univ[i][j] = new Cell(i,j);
			}
		}
		return univ;
	}
	
	public Cell[][] getUniverse() {
		return universe;
	}

	public void setUniverse(Cell[][] universe) {
		this.universe = universe;
	}
	
	public int getDimensions() {
		return dimensions;
	}
	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	
	Cell getCell(int row , int col){
		return universe[row][col];
	}
	
	List<Cell> getNeighbours(Cell cell){
		List<Cell> neighbours = new ArrayList<Cell>();
		int row = cell.getRow();
		int col = cell.getCol();
		for(int i=row-1; i<= row+1; i++){
			for(int j=col-1; j<= col+1; j++){
				if(i == row &&  j == col) continue;
				if(i < 0 || j < 0 || i > (dimensions-1) || j > (dimensions-1)) continue;
			//	System.out.println(i+","+j);
				neighbours.add(getCell(i,j));
			}
		}
		return neighbours;
	}
	
	public void displayUniverse(int current){
		System.out.println("------------------- Generation "+ (current+1) +"----------------------------------------");
		for (Cell x[] : getUniverse()) {
		      for (Cell y : x) {
		        System.out.println("(" + y.getRow()+","+y.getCol()+") : "+(y.isAlive() ? "Alive" : "Dead"));
		      }
		 }
	}
	
	public int getNumberOfLiveNeighbours(Cell cell){
		int count = 0;
		for(Cell c : getNeighbours(cell)){
			if(c.isAlive())	count++;
		}
		return count;
	}
	
	public boolean shouldAlive(Cell cell) {
		if(getNumberOfLiveNeighbours(cell) == 2 || getNumberOfLiveNeighbours(cell) == 3) 
			return true;
		else 
			return false;
	}
	
	public void evolve() {
		Cell[][] parallelUniverse = createDefaultCells(this.dimensions);
		for(int i=0; i<this.dimensions; i++){
			for(int j=0; j<this.dimensions; j++){
				int liveNeighbours = getNumberOfLiveNeighbours(getCell(i,j));
				if(liveNeighbours == 3)
					parallelUniverse[i][j].setAlive(true);
				else{
					if(liveNeighbours >= 0 && liveNeighbours != 2)
						parallelUniverse[i][j].setAlive(false);
				}					
			}
		}
		this.setUniverse(parallelUniverse);
	}
}
