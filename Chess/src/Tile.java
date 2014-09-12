/**
 * One tile of a chess board. Can be occupied by a piece or
 * open to become occupied, can be either black or white, and
 * has a defined position within a two-dimensional space for
 * which there is a name in defined, standard chess notation.
 * The tile also knows what piece is currently on it.
 * 
 * @author Priten Vora
 *
 */
public class Tile extends Board {

	private final int x;			// Horizontal coordinate of the tile
	private final int y;			// Vertical coordinate of the tile
	private final boolean color;	// Color of the tile (true = white & false = black)
	private final String name;		// Name of the tile in chess notation
	private Piece current_piece;	// Which piece is currently on the tile

	/**
	 * Constructor for the tile. When created, each tile must be
	 * given an x and y value and a name corresponding to a tile
	 * in proper chess notation, like "A6" or "H1".
	 * 
	 * @param tile_x The x-coordinate value of the new tile.
	 * @param tile_y The y-coordinate value of the new tile.
	 * @param tile_color The color of the new tile (true = white & false = black).
	 * @param tile_name The proper chess notation name of the new tile.
	 */
	public Tile(int tile_x, int tile_y, boolean tile_color, String tile_name) {
		x = tile_x;
		y = tile_y;
		color = tile_color;
		name = tile_name;
		current_piece = null;
	}

	/**
	 * Sets the tile to hold the given piece.
	 * 
	 * @param new_piece The piece that is now occupying the tile.
	 */
	public void set_piece(Piece new_piece) {
		current_piece = new_piece;
	}

	/**
	 * Returns the piece currently occupying the tile, and null if there
	 * isn't a piece currently occupying the tile.
	 * 
	 * @return The piece currently on the tile; null if the tile is unoccupied.
	 */
	public Piece get_piece() {
		return current_piece;
	}

	/**
	 * Returns the horizontal coordinate of the tile on the board.
	 * 
	 * @return The horizontal coordinate of the tile.
	 */
	public int get_x() {
		return x;
	}

	/**
	 * Returns the vertical coordinate of the tile on the board.
	 * 
	 * @return The vertical coordinate of the tile.
	 */
	public int get_y() {
		return y;
	}

	/**
	 * Returns the color of the tile.
	 * 
	 * @return True if the tile is white; false if it is black.
	 */
	public boolean get_color() {
		return color;
	}

	/**
	 * Returns the name corresponding to the tile in proper chess
	 * notation, like "A6" or "H1".
	 * 
	 * @return The name of the tile in chess notation.
	 */
	public String get_name() {
		return name;
	}

	/**
	 * Returns whether or not the tile is occupied.
	 * 
	 * @return True if the tile is occupied; false if it is not.
	 */
	public boolean is_occupied() {
		return (current_piece == null);
	}
}