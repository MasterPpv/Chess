import java.util.ArrayList;

/**
 * A representation of a chess board. Made up of ranks and files of tiles,
 * each of which may or may not be occupied by a piece.
 * 
 * @author Priten Vora
 *
 */
public class Board {

	protected Tile[][] tiles; 			// A list of all the tiles that make up the board.
	protected ArrayList<Piece> pieces;	// A list of all the pieces currently on the board.
	protected boolean is_in_check;		// Whether or not there is a king currently in check.
	protected final int width;			// The width of the board (in number of tiles).
	protected final int height;			// The height of the board (in number of tiles).

	/**
	 * Gets the width and height of the board to be made and readies a
	 * board with those dimensions.
	 * 
	 * @param width The width of the board in terms of number of tiles.
	 * @param height The height of the board in terms of number of tiles.
	 */
	public Board(int board_width, int board_height) {
		tiles = new Tile[board_width][board_height];
		this.initialize_tiles(board_width, board_height);
		this.initialize_pieces();
		width = board_width;
		height = board_height;
		is_in_check = false;
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
		Color color = Color.BLACK;
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Location new_tile = new Location(x, y);
				tiles[width][height] = new Tile(new_tile, color, new_tile.toString());
				color = color.other();
			}
		}
	}

	
	private void initialize_pieces() {
		Color color = Color.WHITE;
		for(int x = 0; x < width; x++) {
			Pawn white_pawn = new Pawn(color);
			tiles[width][1].set_piece(white_pawn);
			color = color.other();
			Pawn black_pawn = new Pawn(color);
			tiles[width][6].set_piece(black_pawn);
		}
	}
}