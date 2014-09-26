package Game;
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
public class Tile {

	private final Location location;	// Location of the tile on the board
	private final Color color;			// Color of the tile (WHITE or BLACK)
	private final String name;			// Name of the tile in chess notation
	private Piece currentPiece;		// Which piece is currently on the tile

	/**
	 * Constructor for the tile. When created, each tile must be
	 * given a location object signifying the location of the tile
	 * on the board, a color (either WHITE or BLACK) signifying
	 * the color of the tile, and a name corresponding to a tile
	 * in proper chess notation, like "a6" or "h1".
	 * 
	 * @param tileLocation The location of the new tile on the board.
	 * @param tileColor The color of the new tile (either WHITE or BLACK).
	 * @param tileName The proper chess notation name of the new tile.
	 */
	public Tile(Location tileLocation, Color tileColor, String tileName) {
		location = tileLocation;
		color = tileColor;
		name = tileName;
		currentPiece = null;
	}

	/**
	 * Sets the tile to hold the given piece. The user must also set
	 * the piece so that it knows that it is on this tile.
	 * 
	 * @param newPiece The piece that is now occupying the tile.
	 */
	public void setPiece(Piece newPiece) {
		currentPiece = newPiece;
	}

	/**
	 * Returns the piece currently occupying the tile, and null if there
	 * isn't a piece currently occupying the tile.
	 * 
	 * @return The piece currently on the tile; null if the tile is unoccupied.
	 */
	public Piece getPiece() {
		return currentPiece;
	}

	/**
	 * Returns the location of the tile on the board.
	 * 
	 * @return The horizontal coordinate of the tile.
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Returns the color of the tile.
	 * 
	 * @return Either WHITE or BLACK.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the name corresponding to the tile in proper chess
	 * notation, like "a6" or "h1".
	 * 
	 * @return The name of the tile in chess notation.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns whether or not the tile is occupied.
	 * 
	 * @return True if the tile is occupied; false if it is not.
	 */
	public boolean isOccupied() {
		return (currentPiece == null);
	}
}