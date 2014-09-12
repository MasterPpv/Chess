/**
 * A specific type of Piece corresponding to the Queen piece in chess. It can only move
 * as many spaces as it wants in any direction it wants, but cannot pass through other
 * pieces. It is worth approximately 9 pawns.
 * 
 * @author Priten Vora
 *
 */
public class Queen extends Piece {
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