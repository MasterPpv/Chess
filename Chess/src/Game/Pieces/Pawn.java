package Game.Pieces;
import java.util.ArrayList;
import Game.*;
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

	private boolean firstAdvance;	// Whether or not this pawn is advancing for the first time.

	/**
	 * Constructor for the pawn. Gets and sets its color and whether or
	 * not this pawn has advanced forward yet.
	 * 
	 * @param pieceColor The color of the pawn (either BLACK or WHITE).
	 */
	public Pawn(Color pieceColor) {
		super(pieceColor);
		firstAdvance = true;
	}

	/**
	 * Returns whether or not the pawn can move to the tile in question.
	 * 
	 * @param destination The tile the pawn wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the pawn can move to this tile; false otherwise.
	 */
	public boolean canMoveTo(Tile destination, Board board) {
		return false;
	}

	public boolean move(Tile destination) {
		firstAdvance = false;
		return firstAdvance;
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
		return new ArrayList<Tile>();
	}
}