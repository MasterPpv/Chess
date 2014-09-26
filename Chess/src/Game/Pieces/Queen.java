package Game.Pieces;
import java.util.ArrayList;
import static java.lang.Math.abs;
import Game.*;
/**
 * A specific type of Piece corresponding to the Queen piece in chess. It can only move
 * as many spaces as it wants in any direction it wants, but cannot pass through other
 * pieces. It is worth approximately 9 pawns.
 * 
 * @author Priten Vora
 *
 */
public class Queen extends Piece {

	/**
	 * Constructor for the queen. Gets and sets its color.
	 * 
	 * @param pieceColor The color of the queen (either BLACK or WHITE).
	 */
	public Queen(Color pieceColor) {
		super(pieceColor);
	}

	/**
	 * Returns whether or not the queen can move to the tile in question.
	 * 
	 * @param destination The tile the queen wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the queen can move to this tile; false otherwise.
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

		// Destination is in the same file but in a higher rank.
		if(myX == destX && myY < destY) {
			for(int i = (myY + 1); i < destY; i++) {
				Tile toTest = currentBoard[myX][i];
				movable = (toTest.getPiece() == null);
				if(!movable) {
					break;
				}
			}
		}
		// Destination is in the same file but in a lower rank.
		else if(myX == destX && myY > destY) {
			for(int i = (myY - 1); i > destY; i--) {
				Tile toTest = currentBoard[myX][i];
				movable = (toTest.getPiece() == null);
				if(!movable) {
					break;
				}
			}
		}
		// Destination is in the same rank but in a higher file.
		else if(myY == destY && myX < destX) {
			for(int i = (myX + 1); i < destX; i++) {
				Tile toTest = currentBoard[i][myY];
				movable = (toTest.getPiece() == null);
				if(!movable) {
					break;
				}
			}
		}
		// Destination is in the same rank but in a lower file.
		else if(myY == destY && myX > destX) {
			for(int i = (myX - 1); i > destX; i--) {
				Tile toTest = currentBoard[i][myY];
				movable = (toTest.getPiece() == null);
				if(!movable) {
					break;
				}
			}
		}
		// Destination is diagonally in line with the current location.
		else if(abs(destX - myX) == abs(destY - myY)) {
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

		// Add all squares in the same rank besides the one we're on.
		for(int i = 0; i < width; i++) {
			if(i != myX) {
				moves.add(currentBoard[i][myY]);
			}
		}

		// Add all squares in the same file besides the one we're on.
		for(int j = 0; j < height; j++) {
			if(j != myY) {
				moves.add(currentBoard[myX][j]);
			}
		}

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