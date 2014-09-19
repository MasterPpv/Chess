/**
 * The horizontal and vertical coordinate of a tile on a chess
 * board. Understands where the tile is on the board in proper
 * chess notation.
 * 
 * @author Priten Vora
 *
 */
public class Location {

	public final int x;	// Horizontal coordinate of the tile
	public final int y;	// Vertical coordinate of the tile

	public Location(int tile_x, int tile_y) {
		x = tile_x;
		y = tile_y;
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