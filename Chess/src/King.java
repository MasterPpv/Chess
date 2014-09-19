import java.util.ArrayList;

/**
 * A specific type of Piece corresponding to the King piece in chess.
 * It can only move one square in any direction. It is also the most
 * important piece in the game. The King cannot be captured. However,
 * if it is ever in a position where it could be captured if it were
 * any other piece, it is in a "Check" state, and the player MUST get
 * it out of being in Check with their next move. If it is impossible
 * for the player to get out of Check, the result is a "Checkmate"
 * and that player loses the game. The King also has a special move
 * that it can perform provided that certain conditions are met. If
 * the King has not yet moved from its original position (it must not
 * have moved at all; this is not the same as having moved and then
 * come back to the initial position), and a Rook of the same color
 * is also still unmoved, the player may "Castle" the King and Rook.
 * This is done by moving the King two spaces toward the Rook and then
 * having the Rook leap over to the other side of the King, to the
 * square directly adjacent to the King's new position. Also, another
 * restriction on castling is that the King cannot end up in a Check
 * situation at the end, and cannot move through spaces that would
 * normally put the King in Check. In fact, the King in general can't
 * move into or through a position that would cause them to be in
 * Check, and other friendly pieces also cannot move if their movement
 * would cause the King to come under Check.
 * 
 * @author Priten Vora
 *
 */
public class King extends Piece {

	/**
	 * Returns whether or not the king can move to the tile in question.
	 * 
	 * @param destination The tile the king wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the king can move to this tile; false otherwise.
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
		return new ArrayList<Tile>();
	}
}