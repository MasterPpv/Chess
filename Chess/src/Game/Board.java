package Game;
import java.util.ArrayList;
import Game.Pieces.*;
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
	protected boolean isInCheck;		// Whether or not there is a king currently in check.
	protected final int width;			// The width of the board (in number of tiles).
	protected final int height;			// The height of the board (in number of tiles).

	/**
	 * Gets the width and height of the board to be made and readies a
	 * board with those dimensions.
	 * 
	 * @param width The width of the board in terms of number of tiles.
	 * @param height The height of the board in terms of number of tiles.
	 */
	public Board(int boardWidth, int boardHeight) {
		tiles = new Tile[boardWidth][boardHeight];
		this.initializeTiles(boardWidth, boardHeight);
		this.initializePieces();
		width = boardWidth;
		height = boardHeight;
		isInCheck = false;
	}

	/**
	 * Private helper for the constructor. Initializes the board to have
	 * the correct number of tiles in the correct number of ranks and
	 * files (AKA rows and columns). Tells each tile its x and y values,
	 * its color, and its proper name by standard chess notation.
	 * 
	 * @param width The number of files (columns) of tiles on the board.
	 * @param height The number of ranks (rows) of tiles on the board.
	 */
	private void initializeTiles(int width, int height) {
		Color tileColor = Color.BLACK;
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Location newTile = new Location(x, y);
				tiles[x][y] = new Tile(newTile, tileColor, newTile.toString());
				tileColor = tileColor.other();
			}
		}
	}

	/**
	 * Private helper for the constructor. Initializes the board to have
	 * the correct pieces for a standard, default chess board. Creates
	 * and places the pawns for both sides, then each of the individual
	 * minor and major pieces. For each piece created, the tile that the
	 * piece is placed on is told that it now has a piece on it, and also
	 * what piece it is, complete with the color of the piece.
	 * 
	 */
	// TODO: NOT YET COMPLETE
	private void initializePieces() {
		Color pieceColor = Color.WHITE;
		for(int x = 0; x < width; x++) {
			Pawn whitePawn = new Pawn(pieceColor);
			tiles[x][1].setPiece(whitePawn);
			pieceColor = pieceColor.other();
			Pawn blackPawn = new Pawn(pieceColor);
			tiles[x][6].setPiece(blackPawn);
		}
	}

	/**
	 * Returns the width of the board in number of tiles.
	 * 
	 * @return The width of the board.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the board in number of tiles.
	 * 
	 * @return The height of the board.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns a two-dimensional array of all of the tiles
	 * that the board is comprised of.
	 * 
	 * @return A 2-D array of tiles that make up the board.
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
}