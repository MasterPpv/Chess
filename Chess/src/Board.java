/**
 * A representation of a chess board. Made up of ranks and files of tiles,
 * each of which may or may not be occupied by a piece.
 * 
 * @author Priten Vora
 *
 */
public class Board {

	Tile[][] board; // A list of all the tiles that make up the board.
	boolean ongoing_check; // Whether or not there is a king currently in check.

	/**
	 * Gets the width and height of the board to be made and readies a
	 * board with those dimensions.
	 * 
	 * @param width The width of the board in terms of number of tiles.
	 * @param height The height of the board in terms of number of tiles.
	 */
	public Board(int width, int height) {
		board = new Tile[width][height];
		this.initialize_tiles(width, height);
		ongoing_check = false;
	}

	/**
	 * Private helper for the constructor. Initializes the baord to have
	 * the correct number of tiles in the correct number of ranks and
	 * files (AKA rows and columns). Tells each tile its x and y values,
	 * its color, and its proper name by standard chess notation.
	 * 
	 * @param width The number of files (columns) of tiles on the board.
	 * @param height The number of ranks (rows) of tiles on the board.
	 */
	private void initialize_tiles(int width, int height) {
		boolean color = false;
		for(int x = 0; x <width; x++) {
			for(int y = 0; y < height; y++) {
				board[width][height] = new Tile(x, y, color, this.name_tile(x, y));
				color = !color;
			}
		}
	}

	/**
	 * Private helper method for the initialize_tiles helper for the constructor.
	 * Receives an x and y value for the location of the tile on the board and
	 * calculates and returns the proper chess notation designation for the tile
	 * (e.g. "a6" or "h1").
	 * 
	 * @param x The x value of the tile on the board.
	 * @param y The y value of the tile on the board.
	 * @return The proper chess notation designation for the tile in question.
	 */
	private String name_tile(int x, int y) {
		char rank = (char)('a' + x);
		return "" + rank + y;
	}
}