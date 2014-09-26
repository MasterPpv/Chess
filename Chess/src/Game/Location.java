package Game;
/**
 * The horizontal and vertical coordinate of a tile on a chess
 * board. Understands where the tile is on the board in proper
 * chess notation.
 * 
 * @author Priten Vora
 *
 */
public class Location {

	private final int x;	// Horizontal coordinate of the tile
	private final int y;	// Vertical coordinate of the tile

	/**
	 * Constructor for the location of a tile. Receives integer values
	 * corresponding to the horizontal and vertical coordinates of the
	 * tile on the chess board and stores them.
	 * 
	 * @param tileX The integer value of the horizontal coordinate of the tile.
	 * @param tileY The integer value of the vertical coordinate of the tile.
	 */
	public Location(int tileX, int tileY) {
		x = tileX;
		y = tileY;
	}

	/**
	 * Returns the horizontal coordinate of the tile as an integer.
	 * 
	 * @return The integer value of the horizontal coordinate of the tile.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the vertical coordinate of the tile as an integer.
	 * 
	 * @return The integer value of the horizontal coordinate of the tile.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Calculates and returns the proper chess notation designation
	 * for this location on the chess board (e.g. "a6" or "h1").
	 * 
	 * @return The proper chess notation designation for the location in question.
	 */
	public String toString() {
		char rank = (char)('a' + x);
		return "" + rank + y;
	}
}