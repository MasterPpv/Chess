import java.util.ArrayList;
/**
 * A specific type of Piece corresponding to the Rook piece in chess. It
 * can only move horizontally and vertically and cannot pass through other
 * pieces. It is worth approximately 5 pawns and can perform the special
 * movement technique called "Castling" with the King (see the description
 * of the King class for details).
 * 
 * @author Priten Vora
 *
 */
public class Rook extends Piece {

	/**
	 * Returns whether or not the rook can move to the tile in question.
	 * 
	 * @param destination The tile the rook wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the rook can move to this tile; false otherwise.
	 */
	public boolean can_move_to(Tile destination, Board board) {

		// Check if the destination tile already has one of your own pieces.
		Piece dest_piece = destination.get_piece();
		if(dest_piece != null && dest_piece.color == this.color) {
			return false;
		}

		// Collect the necessary information and set up variables.
		boolean movable = true;
		Location my_location = current_tile.get_location();
		Location dest_location = destination.get_location();
		Tile[][] current_board = board.tiles;

		// Destination is in the same file but in a higher rank.
		if(my_location.x == dest_location.x && my_location.y < dest_location.y) {
			for(int i = (my_location.y + 1); i < dest_location.y; i++) {
				Tile to_test = current_board[my_location.x][i];
				movable = (to_test.get_piece() == null);
			}
		}
		// Destination is in the same file but in a lower rank.
		else if(my_location.x == dest_location.x && my_location.y > dest_location.y) {
			for(int i = (my_location.y - 1); i > dest_location.y; i--) {
				Tile to_test = current_board[my_location.x][i];
				movable = (to_test.get_piece() == null);
			}
		}
		// Destination is in the same rank but in a higher file.
		else if(my_location.y == dest_location.y && my_location.x < dest_location.x) {
			for(int i = (my_location.x + 1); i < dest_location.x; i++) {
				Tile to_test = current_board[i][my_location.y];
				movable = (to_test.get_piece() == null);
			}
		}
		// Destination is in the same rank but in a lower file.
		else if(my_location.y == dest_location.y && my_location.x > dest_location.x) {
			for(int i = (my_location.x - 1); i > dest_location.x; i--) {
				Tile to_test = current_board[i][my_location.y];
				movable = (to_test.get_piece() == null);
			}
		}
		// Destination is some other tile on the board (can't move there).
		else {
			movable = false;
		}

		return movable;
	}

	public boolean move(Tile destination) {
		return false;
	}

	/**
	 * Evaluates the current position of the rook on the board and
	 * returns an array of all the tiles that it might be possible for
	 * the rook to move to. NOTE: this is NOT the list of all LEGAL
	 * moves available to the rook - this is the list of every move
	 * that COULD be legal for the rook given its current location on
	 * the board. This list must be checked with the current condition
	 * of the board and other pieces to determine the list of all the
	 * moves the rook can actually legally make.
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