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
	public boolean can_move() {
		return false;
	}
	public boolean can_move_to(Tile destination) {
		return false;
	}
	public boolean move(Tile destination) {
		return false;
	}
}