package Game.Pieces;
import static java.lang.Math.abs;
import java.util.ArrayList;
import Game.*;
/**
 * A specific type of Piece corresponding to the Bishop piece in chess.
 * It can only move diagonally, is worth approximately 3 pawns, and cannot
 * pass through other pieces.
 * 
 * @author Priten Vora
 *
 */
public class Bishop extends Piece {

	/**
	 * Constructor for the bishop. Gets and sets its color.
	 * 
	 * @param pieceColor The color of the bishop (either BLACK or WHITE).
	 */
	public Bishop(Color pieceColor) {
		super(pieceColor);
	}

	/**
	 * Returns whether or not the bishop can move to the tile in question.
	 * 
	 * @param destination The tile the bishop wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the bishop can move to this tile; false otherwise.
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
		boolean movable = true;
		Location myLocation = currentTile.getLocation();
		Location destLocation = destination.getLocation();
		Tile[][] currentBoard = board.getTiles();
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int destX = destLocation.getX();
		int destY = destLocation.getY();

		// Destination is diagonally in line with the current location.
		if(abs(destX - myX) == abs(destY - myY)) {
			// Destination is up and to the right of the current location.
			if(myX < destX && myY < destY) {
				for(int i = (myX + 1), j = (myY + 1); i < destX && j < destY; i++, j++) {
					Tile toTest = currentBoard[i][j];
					movable = (toTest.getPiece() == null);
					if(!movable) {
						break;
					}
				}
			}
			// Destination is down and to the right of the current location.
			else if(myX < destX && myY > destY) {
				for(int i = (myX + 1), j = (myY - 1); i < destX && j > destY; i++, j--) {
					Tile toTest = currentBoard[i][j];
					movable = (toTest.getPiece() == null);
					if(!movable) {
						break;
					}
				}
			}
			// Destination is up and to the left of the current location.
			else if(myX > destX && myY < destY) {
				for(int i = (myX - 1), j = (myY + 1); i > destX && j < destY; i--, j++) {
					Tile toTest = currentBoard[i][j];
					movable = (toTest.getPiece() == null);
					if(!movable) {
						break;
					}
				}
			}
			// Destination is down and to the left of the current location.
			else if(myX > destX && myY > destY) {
				for(int i = (myX - 1), j = (myY - 1); i > destX && j > destY; i--, j--) {
					Tile toTest = currentBoard[i][j];
					movable = (toTest.getPiece() == null);
					if(!movable) {
						break;
					}
				}
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
	 * Evaluates the current position of the bishop on the board and
	 * returns an array of all the tiles that it might be possible for
	 * the bishop to move to. NOTE: this is NOT the list of all LEGAL
	 * moves available to the bishop - this is the list of every move
	 * that COULD be legal for the piece given its current location on
	 * the board. This list must be checked with the current condition
	 * of the board and other pieces to determine the list of all the
	 * moves the bishop can actually legally make.
	 * 
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return A list of all possible (but not necessarily legal) moves for the bishop.
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

		// Add all squares diagonally up and to the right from where we are.
		for(int i = (myX + 1), j = (myY + 1); i < width && j < height; i++, j++) {
			moves.add(currentBoard[i][j]);
		}

		// Add all squares diagonally down and to the right from where we are.
		for(int i = (myX + 1), j = (myY - 1); i < width && j >= 0; i++, j--) {
			moves.add(currentBoard[i][j]);
		}

		// Add all squares diagonally up and to the left from where we are.
		for(int i = (myX - 1), j = (myY + 1); i >= 0 && j < height; i--, j++) {
			moves.add(currentBoard[i][j]);
		}

		// Add all squares diagonally down and to the left from where we are.
		for(int i = (myX - 1), j = (myY - 1); i >= 0 && j >= 0; i--, j--) {
			moves.add(currentBoard[i][j]);
		}

		return moves;
	}
}