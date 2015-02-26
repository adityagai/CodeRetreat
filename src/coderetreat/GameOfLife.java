package coderetreat;

/**
 * @author adityagai
 *
 */
public class GameOfLife {
	 private Grid generation;
	 public GameOfLife(int tick, int generations) {
		 createSeedGeneration();
	 }
	 
	 public Grid getGeneration() {
		return generation;
	}
	 
	 public void createSeedGeneration() {
		generation = new Grid(3);
		Cell[][] cells = 
				    {{new Cell(0,0,true), new Cell(0,1,true), new Cell(0,2,true)},
					{new Cell(1,0,true), new Cell(1,1,true), new Cell(1,2,true)},
					{new Cell(2,0,true), new Cell(2,1,true), new Cell(2,2,true)}};
		
		generation.setUniverse(cells);	
	}
	 
	public static void main(String args[]) throws InterruptedException {
		 int tick = 1; 				// in seconds
		 int generations = 3; 
		 GameOfLife gof = new GameOfLife(tick,generations);
		 
		 for(int i=0; i<generations; i++){
			 gof.getGeneration().displayUniverse(i);
			 gof.getGeneration().evolve();
			 Thread.sleep(tick * 1000);
		 }
	 }
}