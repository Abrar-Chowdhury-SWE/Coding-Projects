Refer to the Board.java file to run through the game


This code implements the game board for the 2048 game. The goal of the 2048 game is to slide numbered tiles on a 4x4 grid to combine them and create a tile with the number 2048. The player can swipe the tiles left, right, up, or down, and the tiles will slide as far as possible in that direction until they collide with another tile or the edge of the grid. If two tiles with the same number collide while moving, they will merge into a single tile with the sum of their numbers.

Let's go through the main components and functionalities of the Board class:

updateOpenSpaces(): This method initializes the openSpaces array list with all the open spots on the game board (i.e., spots with a value of 0).

addRandomTile(): This method adds a random tile (either 2 or 4) to a random open spot on the game board with a probability of 90% for a 2 and 10% for a 4.

swipeLeft(): This method shifts all non-zero tiles on the board to the left, maintaining the same order of tiles, and filling the empty spaces with zeros. After the swipe, there should be no zero tiles in between non-zero tiles.

mergeLeft(): This method finds and merges all identical left pairs in the board. For example, "2 2 2 2" will become "4 0 4 0". The leftmost value takes on double its own value, and the rightmost value becomes 0.

rotateBoard(): This method rotates the game board 90 degrees clockwise by taking the transpose of the board and then reversing the rows.

transpose(): This method updates the game board to be its transpose, flipping the board along its main diagonal (top-left to bottom-right).

flipRows(): This method updates the game board to reverse its rows, effectively flipping the board horizontally.

makeMove(char letter): This method calls previous methods to make right, left, up, and down moves. It performs the corresponding swipe, merge, and rotation operations to achieve the desired move.

isGameLost(): This method returns true when the game is lost and no empty spaces are available (i.e., the player cannot make any more moves).

showScore(): This method calculates and returns the final score when the game is lost.

print(): This method prints the board as integer values in the text window.

printOpenSpaces(): This method prints the board as integer values in the text window, with open spaces denoted by "**".

The Board class provides functionalities to handle the game board, update its state, and allow the player to make moves in the game. Note that this class doesn't implement the entire game logic, but it provides the essential operations needed for the 2048 game. The actual game logic and user interactions would be implemented in a separate class, such as the TextDriver mentioned in the comments.