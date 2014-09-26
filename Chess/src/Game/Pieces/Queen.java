package Game.Pieces;
import java.util.ArrayList;
import Game.*;
/**
 * A specific type of Piece corresponding to the Queen piece in chess. It can only move
 * as many spaces as it wants in any direction it wants, but cannot pass through other
 * pieces. It is worth approximately 9 pawns.
 * 
 * @author Priten Vora
 *
 */
public class Queen extends Piece {

	/**
	 * Constructor for the queen. Gets and sets its color.
	 * 
	 * @param pieceColor The color of the queen (either BLACK or WHITE).
	 */
	public Queen(Color pieceColor) {
		super(pieceColor);
	}

	/**
	 * Returns whether or not the queen can move to the tile in question.
	 * 
	 * @param destination The tile the queen wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the queen can move to this tile; false otherwise.
	 */
	public boolean canMoveTo(Tile destination, Board board) {
		return false;
	}

	public boolean move(Tile destination) {
		return false;
	}

	/**
	 * Evaluates the current position of the piece on the board and
	 * returns an array of all the tiles that it might be possible for
	 * the piece to move to. NOTE: this is NOT the list of all LEGAL
	 * moves available to the piece - this is the list of every move
	 * that COULD be legal for the piece given its current location on
	 * the board. This list must be checked with the current condition
	 * of the board and other pieces to determine the list of all the
	 * moves the piece can actually legally make.
	 * 
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return A list of all possible (but not necessarily legal) moves for the piece.
	 */
	public ArrayList<Tile> potentialMoves(Board board) {

		// Set up the necessary variables.
		Location myLocation = currentTile.getLocation();
		Tile[][] currentBoard = board.getTiles();
		ArrayList<Tile> moves = new ArrayList<Tile>();
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int width = board.getWidth();
		int height = board.getHeight();

		// Add all squares in the same rank besides the one we're on.
		for(int i = 0; i < width; i++) {
			if(i != myX) {
				moves.add(currentBoard[i][myY]);
			}
		}

		// Add all squares in the same file besides the one we're on.
		for(int j = 0; j < height; j++) {
			if(j != myY) {
				moves.add(currentBoard[myX][j]);
			}
		}

		return moves;
	}
}