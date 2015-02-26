package coderetreat;

/**
 * @author adityagai
 *
 */

public class Cell {
	private Boolean isAlive;
	private int row;
	private int col;
	 
	public Cell(){
		 row = -1; 
		 col = -1;
		 isAlive = false;
	}
	public Cell(int row, int col){
		 this.row = row; 
		 this.col = col;
		 isAlive = false;
	}
	public Cell(int row, int col, Boolean isAlive){
		 this.row = row; 
		 this.col = col;
		 this.isAlive = isAlive;
	}
	public Boolean isAlive() {
		return isAlive;
	}
	public void setAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
