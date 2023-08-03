package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Abrar Chowdhury
 */
public class GameOfLife {
 
    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;
  
    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)
  
    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }
  
    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {
        StdIn.setFile(file);
        int r = StdIn.readInt();
        int c = StdIn.readInt();
         grid = new boolean [r][c];
      
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if (StdIn.readBoolean() == true){
                    grid[i][j] = ALIVE;
                    totalAliveCells++;
               }
               else{
                    grid[i][j] = DEAD;
               }
            }
        }
    }
  
    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
   
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }
  
    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {
  
        boolean s = grid[row][col];
        if (s == ALIVE) {
            return true;
        }
        else return false;
         // update this line, provided so that code compiles
    }
  
    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {
  
        
        if(totalAliveCells > 0){
            return true;
        }
        else{
            return false;
        }
  
    }
  
  
    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are
     * horizontally, vertically, or diagonally adjacent.
     *
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int rowA;
        int rowB;
        int colL;
        int colR;
        if (row == 0) rowA=nRows-1;
            else rowA = row-1;
        if (row == nRows-1) rowB=0;
            else rowB = row+1;
        if (col==0) colL=nCols-1;
            else colL = col-1;
        if (col==nCols-1) colR=0;
            else colR = col+1;
       
        int aliveCells=0;
        if(grid[rowA][col]==true) aliveCells++;
        if(grid[rowA][colL]==true) aliveCells++;
        if(grid[rowA][colR]==true) aliveCells++;
        if(grid[row][colR]==true) aliveCells++;
        if(grid[row][colL]==true) aliveCells++;
        if(grid[rowB][colL]==true) aliveCells++;
        if(grid[rowB][col]==true) aliveCells++;
        if(grid[rowB][colR]==true) aliveCells++;
        return aliveCells;
    }
       
        // update this line, provided so that code compiles
   
  
    /**
     * Creates a new grid with the next generation of the current grid using
     * the rules for Conway's Game of Life.
     *
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
        for(int j = 0; j<grid[0].length; j++){
        int living = numOfAliveNeighbors(i, j);
        if(grid[i][j]== ALIVE){
        if(living<=1){
        newGrid[i][j]=DEAD;
        }
        else if(living<=3){
        newGrid[i][j]=ALIVE;
        }
        else{
        newGrid[i][j]=DEAD;
        }
        }
        else{
        if(living==3){
        newGrid[i][j]=ALIVE;
        }
        else{
        newGrid[i][j]=DEAD;
        }
        }
        }
        }
        return newGrid;// update this line, provided so that code compiles
       
  
  
    // update this line, provided so that code compiles
    }
  
    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     *
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {
  
        grid=computeNewGrid();
    }
  
    /**
     * Updates the current grid with the grid computed after multiple (n) generations.
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {
  
        for(int i=0; i<n;i++){
            grid=computeNewGrid();
        }
    }
  
    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {
       
        int nrows = grid.length;
        int ncols = grid[0].length;
  
        WeightedQuickUnionUF cellcom = new WeightedQuickUnionUF(nrows,ncols);
  
        for(int i = 0; i < nrows; i++){
            for(int j =0; j < ncols; j++){
                int nextR;
                    if(i == nrows -1) nextR = 0;
                    else nextR = i+1;
                int lastC;
                    if (j==0) lastC = ncols - 1;
                    else lastC = j-1;
                int nextC;
                    if (j == ncols - 1) nextC =0;
                    else nextC = j+1;
  
                if(grid[i][j] == ALIVE){
                    if(grid[nextR][lastC] == ALIVE) cellcom.union(i,j,nextR,lastC);
                    if(grid[nextR][j] == ALIVE) cellcom.union(i,j,nextR,j);
                    if(grid[nextR][nextC] == ALIVE) cellcom.union(i,j,nextR,nextC);
                    if(grid[i][nextC] == ALIVE) cellcom.union(i,j,i,nextC);
                }
            }
        }
       
        ArrayList<Integer> parent = new ArrayList<Integer>();
        for(int i = 0; i < nrows; i++){
            for(int j =0; j < ncols; j++){
                int tempP = cellcom.find(i,j);
                boolean repeat = false;
                int a = 0;
                while((a < parent.size()) && repeat==false){
                    if(parent.get(a) == tempP) repeat = true;
                    a++;
                }
                if(grid[i][j] == ALIVE && repeat==false) parent.add(tempP);
            }
        }
       
        return parent.size();
    }
       
       
       
  
        // WRITE YOUR CODE HERE
         // update this line, provided so that code compiles
  
 }