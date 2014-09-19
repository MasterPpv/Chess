/**
 * A specific type of Piece corresponding to the Knight piece in chess.
 * It has a strange movement pattern - it can choose between moving one
 * space up, right, left, or down in a given direction and then two spaces
 * in a direction perpendicular to the first, or moving two spaces in a
 * given direction first and then one space in a perpendicular direction.
 * It is worth approximately 3 pawns, and can pass through other pieces.
 * 
 * @author Priten Vora
 *
 */
public class Knight extends Piece {
	public boolean can_move(Board board) {
		return false;
	}
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
	public Tile[] potential_moves(Board board){
		return new Tile[0];
	}
}