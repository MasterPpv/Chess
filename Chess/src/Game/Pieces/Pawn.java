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

		// Check if the destination tile is the same as your current location.
		if(destination == currentTile) {
			return false;
		}

		// Check if the destination tile already has one of your own pieces.
		Piece destPiece = destination.getPiece();
		if(destPiece != null && destPiece.getColor() == this.getColor()) {
			return false;
		}

		// Collect the necessary information and set up variables.
		Location myLocation = currentTile.getLocation();
		Location destLocation = destination.getLocation();
		Tile[][] currentBoard = board.getTiles();
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int destX = destLocation.getX();
		int destY = destLocation.getY();

		// Check relevant moves if the pawn is white.
		if(color == Color.WHITE) {
			if(destX == myX && destY == (myY + 1) && !destination.isOccupied()) {
					return true;
			}
			else if(destX == myX && destY == (myY + 2) && !destination.isOccupied()) {
				if(!currentBoard[myX][myY + 1].isOccupied() && firstAdvance) {
					return true;
				}
			}
			else if((destX == (myX + 1) || destX == (myX - 1)) && destY == (myY + 1)) {
				if(destination.isOccupied() && destination.getPiece().getColor() == Color.BLACK) {
					return true;
				}
			}
			return false;
		}

		// Check relevant moves if the pawn in black.
		else {
			if(destX == myX && destY == (myY - 1) && !destination.isOccupied()) {
				return true;
			}
			else if(destX == myX && destY == (myY - 2) && !destination.isOccupied()) {
				if(!currentBoard[myX][myY - 1].isOccupied() && firstAdvance) {
					return true;
				}
			}
			else if((destX == (myX + 1) || destX == (myX - 1)) && destY == (myY - 1)) {
				if(destination.isOccupied() && destination.getPiece().getColor() == Color.BLACK) {
					return true;
				}
			}
			return false;
		}

	}

	/**
	 * Moves the pawn to the given tile. If the pawn captured an
	 * enemy piece by moving, the enemy piece is removed from the
	 * game. Does not need to check the legality or validity of
	 * the move - this method will only ever get called if it is
	 * possible for the move to take place.
	 * 
	 * @param destination The tile to move the pawn to.
	 * @return Whether the move was successful or not, for error-checking.
	 */
	public boolean move(Tile destination) {
		if(firstAdvance) {
			firstAdvance = false;
		}
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

		// Set up the necessary variables.
		Location myLocation = currentTile.getLocation();
		Tile[][] currentBoard = board.getTiles();
		ArrayList<Tile> moves = new ArrayList<Tile>();
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int width = board.getWidth();
		int height = board.getHeight();

		// Add relevant moves for a white pawn.
		if(color == Color.WHITE) {
			if((myY + 1) < height) {
				moves.add(currentBoard[myX][myY + 1]);
				if((myX + 1) < width) {
					moves.add(currentBoard[myX + 1][myY + 1]);
				}
				if((myX - 1) >= 0) {
					moves.add(currentBoard[myX - 1][myY + 1]);
				}
			}
			if((myY + 2) < height && firstAdvance) {
				moves.add(currentBoard[myX][myY + 2]);
			}
		}

		// Add relevant moves for a black pawn.
		else {
			if((myY - 1) >= 0) {
				moves.add(currentBoard[myX][myY - 1]);
				if((myX + 1) < width) {
					moves.add(currentBoard[myX + 1][myY - 1]);
				}
				if((myX - 1) >= 0) {
					moves.add(currentBoard[myX - 1][myY - 1]);
				}
			}
			if((myY - 2) >= 0 && firstAdvance) {
				moves.add(currentBoard[myX][myY - 2]);
			}
		}

		return moves;
	}
}