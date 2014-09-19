import java.util.ArrayList;

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
	 * Returns whether or not the queen can move to the tile in question.
	 * 
	 * @param destination The tile the queen wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the queen can move to this tile; false otherwise.
	 */
	public boolean can_move_to(Tile destination, Board board) {
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
	public ArrayList<Tile> potential_moves(Board board) {
		// Set up the necessary variables.
		Location my_location = current_tile.get_location();
		Tile[][] current_board = board.tiles;
		ArrayList<Tile> moves = new ArrayList<Tile>();

		// Add all squares in the same rank besides the one we're on.
		for(int i = 0; i < board.width; i++) {
			if(i != my_location.x) {
				moves.add(current_board[i][my_location.y]);
			}
		}

		// Add all squares in the same file besides the one we're on.
		for(int j = 0; j < board.width; j++) {
			if(j != my_location.y) {
				moves.add(current_board[my_location.x][j]);
			}
		}

		return moves;
	}
}