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