Refer to the "GameOfLife.java" file in src folder to run through the actual game.


This code defines a class called GameOfLife that simulates Conway's Game of Life. The Game of Life is a cellular automaton devised by the British mathematician John Conway. It consists of a grid of cells, each of which can be either alive or dead, and it evolves through generations based on a set of rules. The rules are as follows:

Alive cells with 0-1 neighbors die of loneliness.
Alive cells with >=4 neighbors die of overpopulation.
Alive cells with 2-3 neighbors survive.
Dead cells with exactly 3 neighbors become alive by reproduction.
Let's break down the main components and functionalities of the code:

Constructor: There are two constructors. The default constructor creates a small 5x5 grid with five alive cells. The other constructor takes a file as input and creates a grid with the given number of alive cells based on the contents of the file.

Instance Variables:

ALIVE and DEAD: Constants representing the states of cells (true for alive, false for dead).
grid: A 2D boolean array representing the current generation of cells.
totalAliveCells: An integer representing the total number of alive cells in the grid.
Methods:

getGrid(): Returns the current grid.
getTotalAliveCells(): Returns the total number of alive cells in the grid.
getCellState(int row, int col): Returns the status of the cell at the specified row and column.
isAlive(): Returns true if there is at least one cell alive in the grid, otherwise returns false.
numOfAliveNeighbors(int row, int col): Determines the number of alive cells around a given cell.
computeNewGrid(): Creates a new grid with the next generation of cells based on the Game of Life rules.
nextGeneration(): Updates the current grid with the next generation of cells computed by computeNewGrid().
nextGeneration(int n): Updates the grid with the grid computed after n generations.
numOfCommunities(): Determines the number of separate cell communities in the grid.
The computeNewGrid() method is a key function that implements the Game of Life rules to generate the next generation of cells. The method numOfCommunities() aims to find the number of separate cell communities formed on the grid.

Overall, this class provides the necessary functionalities to simulate Conway's Game of Life and progress through multiple iterations to observe the evolution of the cell patterns.


