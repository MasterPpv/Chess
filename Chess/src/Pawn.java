/**
 * A specific type of Piece corresponding to the Pawn piece in chess. It
 * can only move forward, and is the unit by which the value of all other
 * pieces is measured. It can attack in either forward-facing diagonal
 * direction. From its initial, starting position, it can move either one
 * or two spaces forward. However, after having moved from its initial
 * position, it can only move one space forward at a time. It also cannot
 * pass through other pieces. If it reaches the other side of the board,
 * it is "promoted" and the player can choose to turn it into a knight,
 * bishop, rook, or queen. If it is on the fifth row forward from its own
 * side's end of the board, and a pawn in one of the adjacent lanes moves
 * two spaces forward so that it ends up directly next to it, the pawn on
 * the fifth line can attack the just-moved pawn "en passant", or "in
 * passing". The pawn on the fifth line attacks diagonally like normal,
 * and the pawn that moved two spaces is removed as it would be if it only
 * moved one space and was attacked on the next turn. This attack, however,
 * can only take place during the turn immediately following that of the
 * pawn moving forward two spaces.
 * 
 * @author Priten Vora
 *
 */
public class Pawn extends Piece {
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