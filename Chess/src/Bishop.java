/**
 * A specific type of Piece corresponding to the Bishop piece in chess.
 * It can only move diagonally, is worth approximately 3 pawns, and cannot
 * pass through other pieces.
 * 
 * @author Priten Vora
 *
 */
public class Bishop extends Piece {
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